package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import DTO.MemberDTO;

public class MemberDAO {
    // Database CRUD를 정의한 클래스
    // DB에 점속하기 위해서는 DB url ,username, password가 필요함
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String username = "system";
    private String pass = "oracle";

    private Connection conn = null; // 데이터베이스에 접속하기 위한 자원
    // 코드를 작성하는 절차
    /*
     * 1.드라이버로드<한번만> -가장 적당 한 위치로 객체가 생성될 때 딱 한번 실행하는 생성자에서 코딩
     * 2.컨넥션 자원 얻기 <작업 수행시마다>
     * 3.쿼리만들기
     * 4.쿼리 전송
     * 5.쿼리 결과값 리턴받기 < insert,delete update 리턴값이 Int, <select는 객체 한 개 이상>
     * 6.리턴값 처리
     * 7.2번 자원 반납하기
     */

    private boolean getConn() // 커넥션 성공 실패 여부
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


    //수정
    public void mod(MemberDTO m) {
        PreparedStatement psmt = null;
        if (getConn()) {
            //쿼리만들기>매핑하기>쿼리전송>리턴값 받기>처리 자원받납
            try {
                String sql = "update member set age=? where name=?";
                psmt = conn.prepareStatement(sql);
                //매핑하기
                psmt.setInt(1, m.getAge());
                psmt.setString(2, m.getName());
                //쿼리 전송하고 리턴값받기
                int resultInt = psmt.executeUpdate();//쿼리를 실제로 전송해주는 메서드
                //리턴값처리하기
                System.out.println(resultInt + "건 수 성공");
            } catch (Exception e) {
                System.out.println("insert 오류");
                e.printStackTrace();

            } finally {
                //자원받납하기
                try {
                    if (psmt != null) {
                        psmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e2) {
                }
            }
        } else {
            System.out.println("컨넥션 정보 없음");
        }
    }

    public void insert(MemberDTO m) {
        PreparedStatement psmt=null;
        if(getConn()) {
            //쿼리만들기>매핑하기>쿼리전송>리턴값 받기>처리 자원받납
            try {
                String sql="insert into member values(?,?,?)";
                psmt=conn.prepareStatement(sql);
                //매핑하기
                psmt.setString(1,m.getName());
                psmt.setInt(2,m.getAge());
                psmt.setString(3,m.getAddr());
                //쿼리 전송하고 리턴값받기
                int resultInt=psmt.executeUpdate();//쿼리를 실제로 전송해주는 메서드
                //리턴값처리하기
                System.out.println(resultInt+"건 삽입 성공");
            } catch (Exception e) {
                System.out.println("insert 오류");
                e.printStackTrace();

            }finally {
                //자원받납하기
                try {
                    if(psmt !=null) {
                        psmt.close();
                    }if(conn!=null) {
                        conn.close();
                    }
                } catch (Exception e2) {
                }
            }
        }else {
            System.out.println("컨넥션 정보 없음");
        }
    }

    public MemberDAO() {
        try {// 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");// -가
            System.out.println("드라이버 로드 성공"); // 가 코드가 정상적이면 실행
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");// 가 코드에서 드라이버를 로드 못하면 실행

        }
    }

}
