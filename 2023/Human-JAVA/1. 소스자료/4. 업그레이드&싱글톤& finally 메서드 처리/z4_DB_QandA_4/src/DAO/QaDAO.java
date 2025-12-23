package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.QaDTO;

public class QaDAO {  //1.드라이버로드, 2. 커넥션 3. 쿼리  4. 전송
	
	// DB에 접속하기 위해서는 DB url, username, password 가 필요함
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String username="system";
	private String pass="1111";
	private Connection conn=null; //데이터베이스에 접속하기 위한 자원. 
	public static QaDAO self = null;
	public static QaDAO getInstance() {
		if(self == null) {
			self = new QaDAO();
		}
		return self;
	}
	
	private QaDAO() {
		try {   // 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");  //- 가
			System.out.println("드라이버 로드 성공");  // 가 코드가 정상적이면 실행된다.
		} catch (Exception e) {
			System.out.println("드라이버 로드 실패"); // 가 코드에서 드라이버를 로드못하면 실행
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
	public void update(QaDTO qa){
		
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
				String sql ="update qanda set memo=? where title=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, qa.getMemo());
				psmt.setString(2, qa.getTitle());
				psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				allClose();
			}
		}
	}
	
	public QaDTO selectOne(String sw) {  // 받아야죠.. 받을 ㄸ ㅐ는 변수로 받는다.
		QaDTO a = null;
		ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
				String sql = "select * from qanda where title=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, sw);
				rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
				if(rs.next()) {
					a = new QaDTO();
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
	public ArrayList<QaDTO> selectSearch(String title){
		ArrayList<QaDTO> alist = new ArrayList<>();
		ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
				String sql = "select * from qanda where title like '%"+title+"%'";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
				while(rs.next()) {
					QaDTO a = new QaDTO();
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
	public ArrayList<QaDTO> selectAll() {
		ArrayList<QaDTO> alist = new ArrayList<>();
		ResultSet rs = null;  //쿼리의 결과 값... 테이블이 아니다. 테이블로 부터 추출된 임시 결과 테이블
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
				String sql = "select * from qanda";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery(); // select쿼리의 의도는 실행 후 출력된 결과를 리턴
				while(rs.next()) {
					QaDTO a = new QaDTO();
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
	
	public void insert(QaDTO qadto) {
		
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   //psmt객체가 만들어 지기 전
				String sql = "insert into qanda values (?,?,?,?,?,default)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, qadto.getTitle());
				psmt.setString(2, qadto.getMemo());
				psmt.setString(3, qadto.getWr());
				psmt.setString(4, qadto.getPass());
				psmt.setInt(5, qadto.getScret());
				psmt.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				allClose();
			}
		}
		
		
		
		
	}

}
