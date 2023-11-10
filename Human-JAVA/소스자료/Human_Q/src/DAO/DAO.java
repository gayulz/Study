package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.DTO;

public class DAO {
    private String url="jdbc:oracle:thin:@localhost:1521:XE";
    private String username="system";
    private String pass="oracle";
    private Connection conn=null;
    public static DAO self = null;
    public static DAO getInstance() {
        if(self == null) {
            self = new DAO();
        }
        return self;
    }

    private DAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");
        }
    }

    private boolean getConn() {
        try {
            conn = DriverManager.getConnection(url,username,pass);
            System.out.println("컨넥션 성공");
            return true;
        } catch (Exception e) {
            System.out.println("컨넥션 실패");
        }
        return false;
    }
    public int chkWrCnt(String wruser){
        ResultSet rs =null;
        int resultCnt=0;
        if(getConn()) {
            try {
                PreparedStatement psmt = null;
                String sql = "select count(*) cnt from qanda where wr=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1,wruser);
                rs = psmt.executeQuery();
                if(rs.next()) {
                    resultCnt = rs.getInt("cnt");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
        return resultCnt;


    }

    public void delete(String title){

        if(getConn()) {
            try {
                PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
                String sql="delete from qanda where title=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, title);
                psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
    }
    public void update(DTO qa){

        if(getConn()) {
            try {
                PreparedStatement psmt = null;
                String sql ="update qanda set memo=? where title=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, qa.getMemo());
                psmt.setString(2, qa.getTitle());
                psmt.executeQuery();
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
    }

    public DTO selectOne(String sw) {  // 받아야죠.. 받을 ㄸ ㅐ는 변수로 받는다.
        DTO a = null;
        ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
        if(getConn()) {
            try {
                PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
                String sql = "select * from qanda where title=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, sw);
                rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
                if(rs.next()) {
                    a = new DTO();
                    a.setTitle(rs.getString("title"));
                    a.setMemo(rs.getString("memo"));
                    a.setWr(rs.getString("wr"));
                    a.setPass(rs.getString("pass"));
                    a.setScret(rs.getInt("scret"));
                }

            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
        return a;
    }
    public ArrayList<DTO> selectSearch(String title){
        ArrayList<DTO> alist = new ArrayList<>();
        ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
        if(getConn()) {
            try {
                PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
                String sql = "select * from qanda where title like '%"+title+"%'";
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
                while(rs.next()) {
                    DTO a = new DTO();
                    a.setTitle(rs.getString("title"));
                    a.setMemo(rs.getString("memo"));
                    a.setWr(rs.getString("wr"));
                    a.setPass(rs.getString("pass"));
                    a.setScret(rs.getInt("scret"));
                    alist.add(a);
                }

            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
        return alist;

    }
    public ArrayList<DTO> selectAll() {
        ArrayList<DTO> alist = new ArrayList<>();
        ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
        if(getConn()) {
            try {
                PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
                String sql = "select * from qanda";
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
                while(rs.next()) {
                    DTO a = new DTO();
                    a.setTitle(rs.getString("title"));
                    a.setMemo(rs.getString("memo"));
                    a.setWr(rs.getString("wr"));
                    a.setPass(rs.getString("pass"));
                    a.setScret(rs.getInt("scret"));
                    alist.add(a);
                }

            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                allClose();
            }
        }
        return alist;

    }

    public void allClose() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void insert(DTO DTO) {
        if(getConn()) {
            try {
                PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
                String sql = "insert into qanda values (?,?,?,?,?,default)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, DTO.getTitle());
                psmt.setString(2, DTO.getMemo());
                psmt.setString(3, DTO.getWr());
                psmt.setString(4, DTO.getPass());
                psmt.setInt(5, DTO.getScret());
                psmt.executeQuery();
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                allClose();
            }
        }
    }

}
