package membershipRounge;

import DAO.BookDAO;
import DAO.ReviewDAO;
import DTO.BookDTO;
import DTO.BookJoinReviewDTO;
import funtion.Funtions;

import java.util.ArrayList;

public class Admin {
    private ArrayList<BookJoinReviewDTO> bookJoinReviewDTOS = null;
    private Funtions fn = new Funtions();
    private static Admin self = null;

    private Admin() {
    }

    // 관리자 객체를 싱글톤으로 하기 위한 인스턴스 메서드
    public static Admin getInstanse() {
        if (self == null) self = new Admin();
        return self;
    }

    // 관리자 메뉴를 선택할 수 있는 메서드
    public void adminInfo() {
        while (true) {
            fn.linePrt();
            AdminInfo();
            int sel = Integer.parseInt(fn.OutText("메뉴"));
            if (sel == 1) addBook();
            if (sel == 2) delReview();
            if (sel == 3) break;
        }
    }

    // 리뷰 삭제 메서드
    // 관리자는 모든 책의 리뷰를 삭제할 수 있다
    private void delReview() {
        fn.linePrt();
        System.out.println("리뷰 삭제 메뉴 입니다");
        System.out.println("리뷰를 삭제할 도서명을 검색해주세요");
        String delbookTitle = fn.OutText("키워드");
        bookJoinReviewDTOS = BookDAO.bookTitleSearch(delbookTitle);
        if (bookJoinReviewDTOS != null) {
            fn.prtBookNReview(bookJoinReviewDTOS);
            int delNum = Integer.parseInt(fn.OutText("삭제 리뷰번호"));
            for (BookJoinReviewDTO tmp : bookJoinReviewDTOS) {
                if (tmp.getRnum() == delNum) {
                    ReviewDAO.reviewDel(delNum);
                    break;
                }
            }
        } else System.out.println("초기화면으로 이동합니다");
    }

    // 책 등록 메서드
    private void addBook() {
        fn.linePrt();
        System.out.println("책 등록 메뉴 입니다");
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBook(fn.OutText("책 이름"));
        bookDTO.setAuthor(fn.OutText("작가 이름"));
        BookDAO.bookInsertDB(bookDTO);
    }

    // 관리자 로그인시 info 출력 메서드
    private void AdminInfo() {
        System.out.println("관리자 메뉴입니다");
        System.out.println("1. 책 등록");
        System.out.println("2. 리뷰 삭제");
        System.out.println("3. 로그아웃");
    }

}
