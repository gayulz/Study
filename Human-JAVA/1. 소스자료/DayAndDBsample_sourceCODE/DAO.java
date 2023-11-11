import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String username = "system";
    private String pass = "1111";
    private Connection conn = null;

    public DAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (Exception var2) {
            System.out.println("드라이버 로드 실패");
        }

    }

    private boolean getConn() {
        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.pass);
            System.out.println("컨넥션 성공");
            return true;
        } catch (Exception var2) {
            System.out.println("컨넥션 실패");
            return false;
        }
    }

    public DTO oneSelect(String title) {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        if (this.getConn()) {
            try {
                String sql = "select * from dayday where title=?";
                psmt = this.conn.prepareStatement(sql);
                psmt.setString(1, title);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    DTO daydto = new DTO();
                    daydto.setTitle(rs.getString("title"));
                    daydto.setMemo(rs.getString("memo"));
                    return daydto;
                }
            } catch (Exception var6) {
            }
        }

        return null;
    }

    public void add(DTO d) {
        PreparedStatement psmt = null;
        if (this.getConn()) {
            try {
                String sql = "insert into dayday values (?,?)";
                psmt = this.conn.prepareStatement(sql);
                psmt.setString(1, d.getTitle());
                psmt.setString(2, d.getMemo());
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 삽입 성공");
            } catch (Exception var13) {
                System.out.println("insert 오류");
                var13.printStackTrace();
            } finally {
                try {
                    if (psmt != null) {
                        psmt.close();
                    }

                    if (this.conn != null) {
                        this.conn.close();
                    }
                } catch (Exception var12) {
                }

            }
        } else {
            System.out.println("컨넥션 정보 없음");
        }

    }
}

