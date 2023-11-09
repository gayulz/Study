package controller;
import java.sql.Connection;
import java.sql.DriverManager;


public class CRUD {
    // Database CRUD를 정의한 클래스
    // DB에 점속하기 위해서는 DB url ,username, password가 필요함
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "system";
    private static String pass = "oracle";
    private static Connection conn = null; // 데이터베이스에 접속하기 위한 자원
    /*
    코드를 작성하는 절차
    1.드라이버로드<한번만> -가장 적당 한 위치로 객체가 생성될 때 딱 한번 실행하는 생성자에서 코딩
    2.컨넥션 자원 얻기 <작업 수행시마다>
    3.쿼리만들기
    4.쿼리 전송
    5.쿼리 결과값 리턴받기 < insert,delete update 리턴값이 Int, <select는 객체 한 개 이상>
    6.리턴값 처리
    7.2번 자원 반납하기
    */

    public static boolean getConn() // 커넥션 성공 실패 여부
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

    public CRUD() {
        try {// 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");// -가
            System.out.println("드라이버 로드 성공"); // 가 코드가 정상적이면 실행
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");// 가 코드에서 드라이버를 로드 못하면 실행
        }
    }
}
