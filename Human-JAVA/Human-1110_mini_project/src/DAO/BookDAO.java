package DAO;

import DTO.BookDTO;
import DTO.BookJoinReviewDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
    // DB에 도서를 추가하는 메서드
    public static void bookInsertDB(BookDTO BDTO) {
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        if (trueConn == true) {
            Connection conn = AccessDAO.getConn();
            try {
                String sql = "insert into Book values (?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, BDTO.getBook());
                psmt.setString(2, BDTO.getAuthor());
                psmt.setInt(3, BDTO.getRec());
                psmt.executeQuery();
                System.out.println("도서명 : " + BDTO.getBook() + " 등록 완료 ");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("도서 등록 실패");
            } finally {
                AccessDAO.resourcesClose();
            }
        }
    }


    // DB에서 검색하고자 하는 도서를 키워드 Like 검색, 후기와 함께 서브쿼리 리턴값 반환
    public static ArrayList<BookJoinReviewDTO> bookTitleSearch(String title) {
        ArrayList<BookJoinReviewDTO> searchBookReview = new ArrayList<>();
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        if (trueConn) {
            try {
                Connection conn = AccessDAO.getConn();
                String sql = "SELECT * FROM ReviewAndBook WHERE book LIKE ? ORDER BY RNUM";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, "%" + title + "%");
                rs = psmt.executeQuery();
                while (rs.next()) {
                    BookJoinReviewDTO tmpBook = new BookJoinReviewDTO();
                    tmpBook.setRnum(rs.getInt("rnum"));
                    tmpBook.setBook(rs.getString("book"));
                    tmpBook.setAuthor(rs.getString("author"));
                    tmpBook.setId(rs.getString("id"));
                    tmpBook.setrText(rs.getString("rtext"));
                    searchBookReview.add(tmpBook);
                }
                return searchBookReview;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("검색 결과가 없습니다");
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        return null;
    }


    // DB 에서 도서 단건 검색 후 리턴 메서드
    public static BookDTO searchBook(String searchBookTitle) {
        Boolean trueConn = AccessDAO.getConnection();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        if (trueConn) {
            try {
                Connection conn = AccessDAO.getConn();
                String sql = "select * from book where book=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, searchBookTitle);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    BookDTO bDTO = new BookDTO();
                    bDTO.setBook(rs.getString("book"));
                    System.out.println(bDTO.getBook() + "가 검색되었습니다.");
                    return bDTO;
                } else {
                    System.out.println("검색하신 책이 없습니다.");
                }
            } catch (Exception e) {
                System.out.println("select 오류");
                e.printStackTrace();
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        return null;
    }


    // 등록된 책 이름만 DB에서 가져오는 메서드
    public static ArrayList<BookDTO> allBookTitle() {
        ArrayList<BookDTO> allTitle = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Boolean trueConn = AccessDAO.getConnection();
        if (trueConn != null) {
            try {
                Connection conn = AccessDAO.getConn();
                String sql = "SELECT * FROM Book ORDER BY book";
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery();
                while (rs.next()) {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setBook(rs.getString("book"));
                    bookDTO.setAuthor(rs.getString("author"));
                    bookDTO.setRec(rs.getInt("rec"));
                    allTitle.add(bookDTO);
                }
                return allTitle;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("오류발생");
            } finally {
                AccessDAO.resourcesClose();
            }
        }
        return null;
    }
}

