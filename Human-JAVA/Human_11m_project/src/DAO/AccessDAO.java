package DAO;

import DTO.MembersDTO;
import infoDesk.Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccessDAO {
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "system";
    private static String pass = "oracle";
    private static Connection conn = null;
    private static PreparedStatement psmt = null;
    private static ResultSet rs = null;
    private static AccessDAO self = null;
    private static ArrayList<MembersDTO> memberList = Info.getMemberList();

    public static AccessDAO getInstance() {
        if(self == null) {
            self = new AccessDAO();
        }
        return self;
    }

    // 드라이버 로드
    private AccessDAO() {
        try {// 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");// -가
            System.out.println("드라이버 로드 성공"); // 가 코드가 정상적이면 실행
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");// 가 코드에서 드라이버를 로드 못하면 실행
        }
    }


    // 커넥션 시도 리턴값 : 성공/실패
    public static boolean getConnection()
    {
        try {
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println("컨넥션 성공");
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
            System.out.println("자원 반납에서 예외발생");
            e.printStackTrace();
        }
    }

    /*
    Getter && Setter Area
     */

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        AccessDAO.conn = conn;
    }

    public static PreparedStatement getPsmt() {
        return psmt;
    }

    public static void setPsmt(PreparedStatement psmt) {
        AccessDAO.psmt = psmt;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        AccessDAO.rs = rs;
    }

}
