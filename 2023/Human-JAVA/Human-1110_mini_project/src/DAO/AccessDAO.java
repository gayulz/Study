package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AccessDAO {
    final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    final static String username = "system";
    final static String pass = "oracle";
    static Connection conn = null;
    static PreparedStatement psmt = null;
    static AccessDAO self = null;

    public static AccessDAO getInstance() {
        if(self == null) {
            self = new AccessDAO();
        }
        return self;
    }

    // 드라이버 로드
    AccessDAO() {
        try {// 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");// 가 코드에서 드라이버를 로드 못하면 실행
        }
    }

    // 커넥션 시도 리턴값 : 성공/실패
    public static boolean getConnection()
    {
        try {
            conn = DriverManager.getConnection(url, username, pass);
            return true;
        } catch (Exception e) {
            System.out.println("컨넥션 실패");
        }
        return false;
    }

    // 자원 반납 메서드정의
    public static void resourcesClose(){
        try {
            if ( psmt != null ) psmt.close();
            if ( conn != null ) conn.close();
        }catch (Exception e){
            System.out.println("자원 반납 예외발생");
        }
    }

    /*
    Getter && Setter Area
     */
    public static Connection getConn() {
        return conn;
    }

}
