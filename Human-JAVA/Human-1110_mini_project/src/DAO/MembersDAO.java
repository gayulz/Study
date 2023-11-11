package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.MembersDTO;

public class MembersDAO {

    // 회원이 정보를 조회 할때마다 DB에 있는 회원 포인트를 다시 읽어와서 갱신 후 출력해주는 메서드
    public static MembersDTO newMemberP(String memberId) {
        MembersDTO newMember = new MembersDTO();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Boolean trueConn = AccessDAO.getConnection();
        if (trueConn != null){
            try {
                Connection conn = AccessDAO.getConn();
                String sql = "select * FROM Members WHERE id = ?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, memberId);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    newMember.setId(rs.getString("id"));
                    newMember.setPw(rs.getString("pw"));
                    newMember.setName(rs.getString("name"));
                    newMember.setPoint(rs.getInt("point"));
                    return newMember;
                }
            } catch (Exception e) {
                System.out.println("예외발생");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        return null;
    }


    // DB에서 등록된 사용자인지 검증 후 사용자 정보를 리턴해주는 메서드
    public MembersDTO serUser(String id, String pw) {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Boolean trueConn = AccessDAO.getConnection();
        if (trueConn) {
            try {
                Connection conn = AccessDAO.getConn();
                String sql = "select * from members where id=? and pw=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, id);
                psmt.setString(2, pw);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    MembersDTO m = new MembersDTO();
                    m.setId(rs.getString("id"));
                    m.setPw(rs.getString("pw"));
                    m.setName(rs.getString("name"));
                    m.setPoint(rs.getInt("point"));
                    System.out.println("로그인이 완료되었습니다");
                    return m;
                } else {
                    System.out.println("등록된 회원 정보가 없습니다");
                    return null;
                }
            } catch (Exception e) {
                System.out.println("select 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        return null;
    }


    // 회원 가입시 DB에 전달하여 Members 테이블에 Insert처리 해주는 메서드
    public MembersDTO memberAdd(MembersDTO tmpM) {
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        Connection conn = null;
        if (trueConn) {
            try {
                conn = AccessDAO.getConn();
                String sql = "insert into Members values (?,?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, tmpM.getId());
                psmt.setString(2, tmpM.getPw());
                psmt.setString(3, tmpM.getName());
                psmt.setInt(4, tmpM.getPoint());
                int resultInt = psmt.executeUpdate();
                if (resultInt <= 0) {
                    System.out.println("중복된 ID입니다 , 다시 가입하세요 ");
                    return null;
                } else {
                    System.out.println(tmpM.getName() + "님 회원가입 완료");
                    return tmpM;
                }
            } catch (Exception e) {
                System.out.println("회원가입 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        System.out.println("커넥션오류");
        return null;
    }
}