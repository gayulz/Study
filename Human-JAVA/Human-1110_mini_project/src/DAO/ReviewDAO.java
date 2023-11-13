package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.MembersDTO;
import DTO.ReviewDTO;
public class ReviewDAO{
    // 리뷰 삭제 메서드
    public static void reviewDel(int delReviewNum){
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        if (trueConn) {
            try {
                Connection conn= AccessDAO.getConn();
                String sql = "delete from review where rnum=?";
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1,delReviewNum);
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 삭제 성공");
            } catch (Exception e) {
                System.out.println("delete 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();
            }
        }
    }


    // DB에 입력된 Review테이블에 rtext레코드를 수정하는 메서드
    public void reviewMod(int rNum, String rtext) {
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        if (trueConn) {
            try {
                Connection conn= AccessDAO.getConn();
                String sql = "update review set rtext=? where rnum=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1,rtext);
                psmt.setInt(2,rNum);
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 삽입 성공");
            } catch (Exception e) {
                System.out.println("UPDATE 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();

            }
        }
    }


    // DB에 정의된 Review테이블에 insert처리 메서드
    public void reviewAdd(ReviewDTO reviewDTO) {
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        if (trueConn) {
            try {
                Connection conn= AccessDAO.getConn();
                String sql = "insert into Review values(Review_no.NEXTval,?,?,?,?,default)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1,reviewDTO.getBook());
                psmt.setString(2,reviewDTO.getRtext());
                psmt.setInt(3,reviewDTO.getRec());
                psmt.setString(4,reviewDTO.getId());
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 삽입 성공");
            } catch (Exception e) {
                System.out.println("insert 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();

            }
        }
    }


    // DB에 입력된 ID기준 리뷰목록을 DB에서 Select한 뒤 리턴해주는 메서드
    public ArrayList<ReviewDTO> returnReviewId( String title, MembersDTO nowMember, int selnum) {
        Boolean trueConn = AccessDAO.getConnection();
        ArrayList<ReviewDTO> rlist = new ArrayList();
        Connection conn = AccessDAO.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = null;
        if (trueConn) {
            try {
                switch (selnum){
                    case 6 : // 정확한 도서명을 전달받아 select 결과 전달받음
                        sql = "select * from review where book=? and id = ? ORDER BY RNUM";
                        psmt = conn.prepareStatement(sql);
                        psmt.setString(1, title);
                        psmt.setString(2, nowMember.getId());
                        break;
                    default : // 로그인된 Id로 select하여 결과 전달
                        sql = "select * from review where id=? ORDER BY RNUM";
                        psmt = conn.prepareStatement(sql);
                        psmt.setString(1, nowMember.getId());
                        break;
                }
                rs = psmt.executeQuery(); // 결과 참조 가능하도록 연결
                while(rs.next()) {
                    ReviewDTO rDTO = new ReviewDTO();
                    rDTO.setRnum(rs.getInt("rnum"));
                    rDTO.setBook(rs.getString("book"));
                    rDTO.setRtext(rs.getString("rtext"));
                    rDTO.setRec(rs.getInt("rec"));
                    rDTO.setId(rs.getString("id"));
                    rlist.add(rDTO);
                }
                return rlist;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("리뷰 조회 실패");
            }
        }
        return null;
    }

}