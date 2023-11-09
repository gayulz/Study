package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.MembersDTO;

public class MembersDAO {

    Boolean conn = AccessDAO.getConnection();
    MembersDTO m = null;

    public MembersDTO viewAll(String id , String pw) {
        ArrayList<MembersDTO> loglist = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        if (conn) {
            try {
                String sql = "SELECT id, pw, name, point FROM Members WHERE id = ? AND pw = ?; ";
                psmt = AccessDAO.getConn().prepareStatement(sql);
                psmt.setString(1, id);
                psmt.setString(2, pw);
                rs = psmt.executeQuery();
                if (rs.next() == true) {
                    m = new MembersDTO();
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
                System.out.println("insert 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();

            }
        } return null;
    }



    public void add(MembersDTO d) {

        PreparedStatement psmt = null;
        if (conn) {
            try {
                String sql = "insert into Members values (?,?,?,?)";
                System.out.println("1");
                psmt = AccessDAO.getConn().prepareStatement(sql);
                System.out.println("2");
                psmt.setString(1, d.getId());
                psmt.setString(2, d.getPw());
                psmt.setString(3, d.getName());
                psmt.setInt(4, d.getPoint());
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
}