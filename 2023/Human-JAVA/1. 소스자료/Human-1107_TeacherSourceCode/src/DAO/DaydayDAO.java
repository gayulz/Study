package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.DaydayDTO;

public class DaydayDAO {
	// DB에 접속하기 위해서는 DB url, username, password 가 필요함
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "system";
	private String pass = "1111";
	private Connection conn = null; // 데이터베이스에 접속하기 위한 자원.

	public DaydayDAO() {
		// 7가지 생각...
		// 클래스 로드
		try { // 실행중에 발생하는 예외를 처리하여 프로그램 오류가 나지 않게 한다.
			Class.forName("oracle.jdbc.driver.OracleDriver"); // - 가
			System.out.println("드라이버 로드 성공"); // 가 코드가 정상적이면 실행된다.
		} catch (Exception e) {
			System.out.println("드라이버 로드 실패"); // 가 코드에서 드라이버를 로드못하면 실행
		}
	}

	private boolean getConn() {
		try {
			conn = DriverManager.getConnection(url, username, pass);
			System.out.println("컨넥션 성공");
			return true;
		} catch (Exception e) {
			System.out.println("컨넥션 실패");
		}
		return false;
	}

	public DaydayDTO oneSelect(String title) {
		// 쿼리문은 select * from dayday where title=?
		PreparedStatement psmt = null;
		ResultSet rs = null; // select 결과물의 행과 열의 집합
		if (getConn()) {
			try {
				String sql = "select * from dayday where title=?";
				psmt = conn.prepareStatement(sql);// 연결된 자원에서 쿼리문을 연결하고 리턴으로
													// PreparedStatment 객체를 넘겨줌
				// 매핑하기
				psmt.setString(1, title);
				// 쿼리 전송하고 리턴값 받기 리턴타입이 ResultSet행과 열로 구성...
				rs = psmt.executeQuery();
				// resultset에서 가져오기
				if (rs.next()) { // rs결과값에 가져올 행이 있는가? 가져온거 아님..
					DaydayDTO daydto = new DaydayDTO();// 저장할 객체..
					daydto.setTitle(rs.getString("title")); // 현재 행에서 title속성의 값을 가져옴
					daydto.setMemo(rs.getString("memo"));
					// 리턴값처리하기
					return daydto;
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {

			}
		}
		return null;
	}
	public ArrayList<DaydayDTO> selectAll(){
		PreparedStatement psmt = null; // 쿼리문을 만들고 매핑하고 실행하는 객체
		ArrayList<DaydayDTO> daylist = new ArrayList<>();
		ResultSet rs = null;
		if(getConn()) {
			try {  // 예외 발생 가능한 코드를 작성. 예외 가 발생하면 더이상 코드를 실행하지 않고
				   // catch문 갔다가 finally로 간다
				   // 예외가 발생하지 않으면 마지막 코드까지 실행후 finally로 간다.
					//쿼리문 만들기 매핑하기 쿼리전송 리턴값 처리
				String sql = "select * from dayday";
				psmt = conn.prepareStatement(sql);  // 연결된 객체의 기능으로  sql쿼리를 연결
				//매핑생략
				rs = psmt.executeQuery();
				while(rs.next()) {
					//System.out.println(rs.getRow());
					DaydayDTO tempday = new DaydayDTO();
					tempday.setTitle(rs.getString("title"));
					tempday.setMemo(rs.getString("memo"));
					daylist.add(tempday);
					System.out.println(daylist.size());
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				
			}
		}
		
		
		return daylist;
		
	}
	
	public void delete(String delTitle) {
		PreparedStatement psmt = null; // 쿼리문을 만들고 매핑하고 실행하는 객체
		if (getConn()) {  //true 컨넥션 자원 얻어오기 성공
			// 쿼리만들기 > 매핑하기 > 쿼리 전송 > 리턴값 받기 > 처리 자원반납
			try {
				String sql = "delete from dayday where title=?";
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				psmt.setString(1, delTitle);
				// 쿼리 전송하고 리턴값 받기
				int resultInt = psmt.executeUpdate();
				// 리턴값처리하기
				System.out.println(resultInt + "건 삭제 성공");
			} catch (Exception e) {
				System.out.println("delete 오류");
				e.printStackTrace();
			} finally {
				// 자원반납하기
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

	public void update(DaydayDTO d) {
		PreparedStatement psmt = null; // 쿼리문을 만들고 매핑하고 실행하는 객체
		if (getConn()) {  //true 컨넥션 자원 얻어오기 성공
			// 쿼리만들기 > 매핑하기 > 쿼리 전송 > 리턴값 받기 > 처리 자원반납
			try {
				String sql = "update dayday set memo=? where title=?";
				psmt = conn.prepareStatement(sql);// 연결된 자원에서 쿼리문을 연결하고 리턴으로
													// PreparedStatment 객체를 넘겨줌
				// 매핑하기
				psmt.setString(1, d.getMemo());
				System.out.println("1");   // 디버깅 용으로 작성함
				psmt.setString(2, d.getTitle());
				System.out.println("2");  // 디버깅 용으로 작성함
				// 쿼리 전송하고 리턴값 받기
				int resultInt = psmt.executeUpdate();
				System.out.println("3");  // 디버깅 용으로 작성함
				// 리턴값처리하기
				System.out.println(resultInt + "건 수정 성공");
			} catch (Exception e) {
				System.out.println("insert 오류");
				e.printStackTrace();
			} finally {
				// 자원반납하기
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

	// 저장하기 위한 메서드를 설계
	public void add(DaydayDTO d) {
		// 쿼리문 insert into dayday values (?,?)
		// ?가 있다는 것은 매개변수가 있다는 이야기
		PreparedStatement psmt = null; // 쿼리문을 만들고 매핑하고 실행하는 객체
		if (getConn()) {
			// 쿼리만들기 > 매핑하기 > 쿼리 전송 > 리턴값 받기 > 처리 자원반납
			try {
				String sql = "insert into dayday values (?,?)";
				psmt = conn.prepareStatement(sql);// 연결된 자원에서 쿼리문을 연결하고 리턴으로
													// PreparedStatment 객체를 넘겨줌
				// 매핑하기
				psmt.setString(1, d.getTitle());
				psmt.setString(2, d.getMemo());
				// 쿼리 전송하고 리턴값 받기
				int resultInt = psmt.executeUpdate();
				// 리턴값처리하기
				System.out.println(resultInt + "건 삽입 성공");
			} catch (Exception e) {
				System.out.println("insert 오류");
				e.printStackTrace();
			} finally {
				// 자원반납하기
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

}
