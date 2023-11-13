package funtion;
import DAO.MembersDAO;
import DAO.ReviewDAO;
import DTO.BookDTO;
import DTO.BookJoinReviewDTO;
import DTO.MembersDTO;
import DTO.ReviewDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Funtions {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<ReviewDTO> rList = null;
    private static ReviewDAO rDAO = new ReviewDAO();

    // 회원의 정보를 출력해주는 메서드
    public void memberInfoPrt(MembersDTO tmpMember){
        linePrt();
        MembersDTO newMember = MembersDAO.newMemberP(tmpMember.getId());
        System.out.println("  I     D : " + newMember.getId());
        System.out.println("  P     W : " + newMember.getPw());
        System.out.println("  N A M E : " + newMember.getName());
        System.out.println("P O I N T : " + newMember.getPoint());
    }

    // 리뷰에 대한 정보를 출력해주는 메서드
    public static void reviewPrt(MembersDTO nowMember, int selnum) {
        try {
            switch ( selnum ){
                case 6 :
                    // 정확한 도서명을 입력받아 DB에서 select 결과 rList에 대입 , 출력
                    String str = OutText("책 제목");
                    rList = rDAO.returnReviewId(str, nowMember, selnum);
                    break;
                default :
                    // 로그인된 id가 등록한 리뷰에 대해 DB에서 select 결과를 rList에 대입 , 출력
                    rList = rDAO.returnReviewId(null, nowMember,selnum);
                    break;
            }
            if (rList.size() != 0) {
                Iterator var3 = rList.iterator();
                while (var3.hasNext()) {
                    ReviewDTO list = (ReviewDTO) var3.next();
                    linePrt1();
                    System.out.println(String.format("%10s", "✧ 리뷰 번호 : ") + list.getRnum());
                    System.out.println(String.format("%10s", "✧ 추천 수 : ") + list.getRec());
                    System.out.println(String.format("%10s", "✧ 도서 명 : ") + list.getBook());
                    System.out.println(String.format("%10s", "✧ 리뷰 내용 : ") + list.getRtext());
                }
            }
        } catch ( Exception e ){
            System.out.println("예외발생");
        }
    }


    // DB결과 : 도서명별 리뷰정보와 도서정보를 서브쿼리로 출력
    // 해당 내용을 매개변수로 전달받아 출력해주는 메서드
    public void prtBookNReview(ArrayList<BookJoinReviewDTO> bjrtmp){
        for (BookJoinReviewDTO tmpBook : bjrtmp) {
            linePrt1();
            System.out.println(String.format("%20s", "리뷰 번호 : ") + tmpBook.getRnum());
            System.out.println(String.format("%20s", "도서 명 : ") + tmpBook.getBook());
            System.out.println(String.format("%20s", "저서 명 : ") + tmpBook.getAuthor());
            System.out.println(String.format("%20s", "리뷰 ID : ") + tmpBook.getId());
            System.out.println(String.format("%20s", "리뷰 내용 : ") + tmpBook.getrText());

        }
    }


    // 등록된 책 정보만 전체 출력해주는 메서드
    public void prtTitle(ArrayList<BookDTO> allTitle){
        for (BookDTO tmpBook : allTitle) {
            System.out.print(String.format("%10s", "✧ 도서 명 : ") + String.format("%-20s" , tmpBook.getBook()));
            System.out.println();
            System.out.print("∘₊✧──────────────────────────✧₊∘✧ 작가 명 : " + String.format("%-10s" , tmpBook.getAuthor()));
            System.out.print(String.format("%-5s", "✧ 추천 수 : ") + String.format("%-10s" , tmpBook.getRec()));
            System.out.println();
        }
    }


    // 입력된 문자열을 리턴해주는 메서드
    public static String OutText(String text) {
        System.out.print("\t" + text + " 입력 >> ");
        return in.nextLine();
    }

    public void linePrt(){
        System.out.println("∘₊✧──────────────────────────✧₊∘ Information ∘₊✧──────────────────────────✧₊∘");
    }

    public static void linePrt1(){
        System.out.println("∘₊✧──────────────────────────✧₊∘ Description ∘₊✧──────────────────────────✧₊∘");
    }
}
