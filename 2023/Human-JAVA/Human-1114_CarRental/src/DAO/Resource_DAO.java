package DAO;
import rentalInfo.Rental_CarAdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Resource_DAO {
    // todo : 리소스 관리 클래스
    final static String url = "jdbc:oracle:thin:@192.168.0.70:1521:orcl";
    final static String username = "system";
    final static String pass = "1111";
    static Connection conn = null;
    static PreparedStatement psmt = null;
    static ResultSet rs = null;
    static String sql;
    static Rental_CarAdd newCar = null;

    // 드라이버로드 생성자
    public Resource_DAO(){
        try {// 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("Driver Load Failed");// 가 코드에서 드라이버를 로드 못하면 실행
        }
    }

    // 커넥션 시도 리턴값 : 성공/실패
    public static boolean isConnections() {
        try {
            conn = DriverManager.getConnection(url, username, pass);
            return true;
        } catch (Exception e) {
            System.out.println("Connections Failed");
        }
        return false;
    }

    // 자원 반납 메서드정의
    public static void resourcesClose(){
        try {
            if ( psmt != null ) psmt.close();
            if ( conn != null ) conn.close();
        }catch (Exception e){
            System.out.println("Resources return Failed");
        }
    }

    // sql 문법 사용 메서드 (추상화)로 진행하여 DB에 접근하는 클래스들은
    // 모두 추상화로 재정의해야함
    public abstract void setSqlquery_DAO();
}
