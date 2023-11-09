package membershipRounge;

import DTO.MembersDTO;
import funtion.Funtions;

public class MemberMain {

    private static MemberMain self = null;
    private static Funtions fn = new Funtions();
    private MembersDTO prMember = null;

    public static MemberMain getInstance() {
        if (self == null) {
            self = new MemberMain();
        }
        return self;
    }
    private MemberMain(){};

    public void info(MembersDTO member) {
        this.prMember = member;
        boolean flag = true;
        while (flag) {
            System.out.println(prMember.getName() + "님 반값습니다, 회원 전용 메뉴입니다");
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
                    myPointSearch(prMember);
                    break;
                case 2: // 리뷰 등록
                    addReview(prMember);
                    break;
                case 3: // 리뷰 수정
                    editReview(prMember);
                    break;
                case 4: // 리뷰 삭제
                    deleteReview(prMember);
                    break;
                case 5: // 리뷰 전체 보기
                    allReviewShow();
                    break;
                case 6: // 도서명 리뷰 검색
                    titleSearchReview();
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


    /*

    하단의 메소드들의 라인수가 길어진다면 ? 클래스로 쪼개자

     */

    // 도서명 리뷰 검색
    private static void titleSearchReview() {
    }

    // 리뷰 전체 보기
    private static void allReviewShow() {

    }

    // 리뷰 삭제
    private static void deleteReview(MembersDTO member) {
    }

    // 리뷰 수정
    private static void editReview(MembersDTO member) {
    }

    // 리뷰 등록
    private static void addReview(MembersDTO member) {
    }

    // 내 정보 조회
    private static void myPointSearch(MembersDTO member) {
        fn.memberInfoPrt(member);
    }
}
