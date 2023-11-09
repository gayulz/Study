package boardDAO;

import boardDTO.BoardDTO;
import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
    private static ArrayList<BoardDTO> postList = null;
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String username = "system";
    private static String pass = "oracle";
    private static Connection conn = null;
    private static PreparedStatement psmt = null;
    private static ResultSet rs = null;


    // 드라이버 로드
    public BoardDAO() {
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

    // 글 삭제
    public static void delete(BoardDTO board) {
        // 쿼리문 : DELETE board WHERE title = ?;
        if (getConnection()){
            try {
                String sql = "DELETE board WHERE title = ?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, board.getTitles());
                int resultInt = psmt.executeUpdate();
                System.out.println( resultInt + "건 삭제 완료");
            } catch (Exception e){
                System.out.println("삭제 오류");
                e.printStackTrace();
            } finally {
                resourcesReturn();
            }
        }
    }

    // 수정된 내용을 입력받고 sql 전달 메서드
    public static void update(BoardDTO boardDTO){
        if (getConnection()){
            // 쿼리문 : UPDATE board SET content =? WHERE title =?;
            try {
                String sql = "UPDATE board SET content =? WHERE title =?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, boardDTO.getContent());
                psmt.setString(2, boardDTO.getTitles());
                int resultInt = psmt.executeUpdate();
                System.out.println( resultInt + "건 수정 완료");
            }catch (Exception e){
                System.out.println("예외 발생!");
                e.printStackTrace();
            }finally {
                // 자원 반납 메서드 호출
                resourcesReturn();
            }
        }
    }

    // 검색 메서드
    public static ArrayList<BoardDTO> getPostList(String keyword, int menuNum){
        postList = new ArrayList<>();
        String sql = null;
        if (getConnection()){
            try{
                if ( menuNum == 4 ){
                    sql = "SELECT * FROM board WHERE title LIKE ?";
                    psmt=conn.prepareStatement(sql);
                    psmt.setString(1, "%" + keyword + "%");
                } else {
                    sql = "SELECT * FROM board";
                    psmt = conn.prepareStatement(sql);
                }
                rs=psmt.executeQuery();
                while ( rs.next() ){
                    BoardDTO tempPost = new BoardDTO();
                    tempPost.setAuthor(rs.getString("author"));
                    tempPost.setTitles(rs.getString("title"));
                    tempPost.setContent(rs.getString("content"));
                    tempPost.setPassword(rs.getString("password"));
                    tempPost.setCheckSecret(rs.getInt("checkSecreat"));
                    postList.add(tempPost);
                    System.out.println(postList.size());
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                resourcesReturn();
            }
        }
        return postList;
    }

    // 검색 메서드
    public static BoardDTO postSearch(String title){
        // 쿼리문 : SELECT content FROM board WHERE title =?;
        if (getConnection()) {
            try {
                String sql = "SELECT * FROM board WHERE title =?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, title);
                rs = psmt.executeQuery();
                if ( rs.next() ){
                    BoardDTO board = new BoardDTO();
                    board.setAuthor(rs.getString("author"));
                    board.setTitles(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setPassword(rs.getString("password"));
                    board.setCheckSecret(rs.getInt("checkSecreat"));
                    return board;
                }
            } catch ( Exception e ){
                resourcesReturn();
            }
        }
        return null;
    }

    // 게시글 새로운 글 작성시 카운트 확인
    public static boolean isAuthorCnt(String author){
        if (getConnection()){
            try {
                String sql = "SELECT COUNT(author) FROM board WHERE author = ?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, author);
                rs = psmt.executeQuery();
                if(rs.next())
                    if(rs.getInt(1) < 2) return true;
            } catch ( Exception e){
                System.out.println("예외 발생");
            } finally {
                resourcesReturn();
            }
        }
        return false;
    }


    // 새 게시글 작성 메서드
    public static void createPost(BoardDTO board){
        // 쿼리문 INSERT into board VALUES (?,?,?,?,?)
        /*
        CREATE TABLE board(
	        author varchar2(20),
	        title varchar2(20),
	        content varchar2(500),
	        password varchar2(20),
	        checkSecreat int CHECK(checkSecreat in('0', '1'))
	    );*/
        if (getConnection()) {
            try {
                String sql = "INSERT into board VALUES (?,?,?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, board.getAuthor());
                psmt.setString(2, board.getTitles());
                psmt.setString(3, board.getContent());
                psmt.setString(4, board.getPassword());
                psmt.setInt(5, board.getCheckSecret());
                int resultInt = psmt.executeUpdate();
                System.out.println( resultInt + "건 삽입 완료 ");
            } catch (SQLException e) {
                System.out.println(" INSERT 오류");
                throw new RuntimeException(e);
            } catch (Exception e){
                System.out.println(" 예외 발생 ");
                e.printStackTrace();
            } finally {
                // 자원 반납 메서드 호출
                resourcesReturn();
            }
        } else System.out.println("커넥션 정보 없음 ");
    }

    // 자원 반납 메서드정의
    private static void resourcesReturn(){
        try {
            if ( psmt != null ) psmt.close();
            if ( conn != null ) conn.close();
        }catch (Exception e){
            System.out.println("자원 반납에서 예외발생");
            e.printStackTrace();
        }
    }
}
