package membershipRounge;

import DAO.BookDAO;
import DAO.ReviewDAO;
import DTO.BookDTO;
import DTO.MembersDTO;
import DTO.ReviewDTO;
import funtion.Funtions;

import java.util.ArrayList;

public class MemberMain {

    private static MemberMain self = null;
    private static Funtions fn = new Funtions();
    private static MembersDTO nowMember = null;
    private static ReviewDAO rDAO = new ReviewDAO();
    private static ArrayList<ReviewDTO> rList = new ArrayList<>();

    public static MemberMain getInstance() {
        if (self == null) {
            self = new MemberMain();
        }
        return self;
    }

    private MemberMain() {
    }

    public void info(MembersDTO member) {
        this.nowMember = member;
        boolean flag = true;
        while (flag) {
            fn.linePrt();
            System.out.println("1. 내 정보 조회 ");
            System.out.println("2. 리뷰 등록 ");
            System.out.println("3. 리뷰 수정 ");
            System.out.println("4. 리뷰 삭제 ");
            System.out.println("5. 리뷰 전체 보기 ");
            System.out.println("6. 도셔명 리뷰 검색 ");
            System.out.println("7. 로그 아웃 ");
            int sel = Integer.parseInt(fn.OutText("메뉴"));
            switch (sel) {
                case 1: // 내 정보 조회
                    myPointSearch();
                    break;
                case 2: // 리뷰 등록
                    addReview();
                    break;
                case 3: // 리뷰 수정
                    editReview(sel);
                    break;
                case 4: // 리뷰 삭제
                    deleteReview(sel);
                    break;
                case 5: // 리뷰 전체 보기
                    allReviewShow(sel);
                    break;
                case 6: // 도서명 리뷰 검색
                    titleSearchReview(sel);
                    break;
                case 7:
                    System.out.println("로그아웃 진행합니다 . 감사합니다");
                    flag = false;
                    break;
                default:
                    System.out.println("잘 못 입력 하셨습니다. 다시 입력해주세요");
            }
        }
    }


    // 메뉴번호 6번 : 도서명 기준으로 모든 리뷰를 검색하는 메서드
    private static void titleSearchReview(int selnum) {
        fn.linePrt();
        System.out.println("도서명 리뷰검색 입니다.");
        fn.reviewPrt(nowMember, selnum);

    }

    // 로그인된 회원 기준으로 해당 회원이 등록한 리뷰만 전베보기하는 메서드
    private static void allReviewShow(int selnum) {
        fn.linePrt();
        System.out.println("전체보기입니다.");
        fn.reviewPrt(nowMember, selnum);
    }


    // 로그인된 회원 기준으로 해당 회원이 등록한 리뷰만 삭제하는 메서드
    private static void deleteReview(int selnum) {
        fn.linePrt();
        System.out.println("리뷰 삭제 입니다.");
        System.out.println(nowMember.getName() + "님의 리뷰 내역 입니다.");
        fn.reviewPrt(nowMember, selnum);
        int delReview = Integer.parseInt(fn.OutText("삭제 리뷰 번호"));
        editSelDel(delReview, selnum);
    }

    // 로그인된 회원 기준으로 해당 회원의 리뷰만 수정하는 메서드
    private static void editReview(int selnum) {
        fn.linePrt();
        System.out.println("리뷰 수정 입니다.");
        System.out.println(nowMember.getName() + "님의 리뷰 내역 입니다.");
        fn.reviewPrt(nowMember, selnum);
        int modReview = Integer.parseInt(fn.OutText("수정 리뷰 번호"));
        editSelDel(modReview, selnum);
    }


    // 로그인한 회원 기준으로 리뷰 등록 하는 메서드
    private static void addReview() {
        ReviewDTO rDTO = new ReviewDTO();
        fn.linePrt();
        System.out.println("리뷰 등록 입니다.");
        System.out.println("책 제목을 검색해 주세요");
        String bookTitle = fn.OutText("책 제목");
        BookDTO bDTO = BookDAO.searchBook(bookTitle);
        if (bDTO != null) {
            rDTO.setBook(bookTitle);
            if (rDTO != null) {
                rDTO.setRtext(fn.OutText("리뷰 "));
                System.out.println("0. 추천안함 / 1. 추천함");
                rDTO.setRec(Integer.parseInt(fn.OutText("번호")));
                rDTO.setId(nowMember.getId());
                rDAO.reviewAdd(rDTO);
            }
        } else
            System.out.println("입력한 도서명은 등록되지 않았습니다. 관리자에게 문의하세요");
    }

    // 로그인된 회원 기준에 회원 정보를 출력하는 메서드
    private static void myPointSearch() {
        fn.memberInfoPrt(nowMember);
    }

    // 수정 삭제 실제 처리메서드에 전달
    // int selnum = 3 (수정) or 4(삭제)
    private static void editSelDel(int rnum, int selnum) {
        rList = rDAO.returnReviewId(null, nowMember, selnum);
        try {
            if (rList != null) {
                ReviewDTO editReview = null;
                for (ReviewDTO review : rList) {
                    if (review.getRnum() == rnum) {
                        editReview = review;
                        break;
                    }
                }
                switch (selnum) {
                    case 3:
                        rDAO.reviewMod(editReview.getRnum(), fn.OutText("수정할 리뷰내용"));
                        break;
                    case 4:
                        rDAO.reviewDel(editReview.getRnum());
                        break;
                }
            } else System.out.println("해당 리뷰번호는 찾을 수 없습니다");
        } catch ( Exception e ){
            System.out.println("\t\t !! 예외발생 !! \t\t");
        }
    }
}