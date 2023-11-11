package infoDesk;
import java.util.ArrayList;
import DAO.BookDAO;
import DTO.BookDTO;
import DTO.BookJoinReviewDTO;
import funtion.Funtions;

public class NoMember {
    private Funtions fn = new Funtions();

    // 비회원 전용 클래스
    public NoMember() {
        boolean flag = true;
        while (flag) {
            info();
            int sel = Integer.parseInt(fn.OutText("번호"));
            switch (sel) {
                case 1: // 등록된 책 이름 전체보기
                    AllBookTitle();
                    break;
                case 2: // 책 이름별 리뷰 전체보기
                    bookTitleSearch();
                    break;
                case 3:
                    System.out.println("초기 화면으로 돌아갑니다");
                    flag = false;
                    break;
                default:
                    System.out.println("없는 메뉴 번호입니다");
            }
        }
    }

    // 책 이름별 리뷰 전체보기
    private void bookTitleSearch() {
        System.out.println("리뷰 조회 도서명");
        String selBookTitle = fn.OutText("키워드");
        ArrayList<BookJoinReviewDTO> bookJoinReviewDTO = BookDAO.bookTitleSearch(selBookTitle);
        if ( bookJoinReviewDTO != null ) fn.prtBookNReview(bookJoinReviewDTO);
        else System.out.println("조회된 내용이 없습니다.");
    }

    // 등록된 책 이름 전체보기
    private void AllBookTitle() {
        System.out.println("현제 등록된 책 목록입니다");
        ArrayList<BookDTO> allTitle = BookDAO.allBookTitle();
        fn.linePrt();
        fn.prtTitle(allTitle);
    }

    // 비회원 전용 info 메뉴
    private void info() {
        System.out.println("비회원 전용 화면입니다");
        System.out.println("1. 등록된 책 이름 전체보기");
        System.out.println("2. 책 이름별 리뷰 전체보기");
        System.out.println("3. 초기화면 돌아가기");
    }
}