package controller;
import members.MemberDefine;
import java.util.Scanner;
import seetMain.SeetDefine;

public class MembershipMain {
    SeetDefine seetDefine = SeetDefine.getSeetInstance();
    private static MembershipMain membershipMainInstance = null;
    Scanner in = new Scanner(System.in);
    MemberDefine thisMember = null;
    private MembershipMain(){} // 생성자 잠굼
    public void info(MemberDefine user){
        thisMember = user;
        boolean flag = true;
        while (flag) {
            System.out.println(" * * 반갑습니다 회원님 , 예매 정보 메뉴 입니다 * * ");
            System.out.println("1. 예매 하기");
            System.out.println("2. 예메 확인");
            System.out.println("3. 좌석 수정");
            System.out.println("4. 예매 취소");
            System.out.println("5. 좌석 현황");
            System.out.println("6. 로그 아웃");
            System.out.print(" >> 메뉴를 선택하세요 : ");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice){
                case 1: // 예매
                    break;
                case 2 : // 예매 확인
                    break;
                case 3 : // 좌석 수정
                    break;
                case 4 : // 예매 취소
                    break;
                case 5 : // 좌석 현황
                    seetDefine.seetArrayPrint();
                    break;
                case 6 : // 로그 아웃
                    System.out.println(" > > 로그 아웃 ");
                    flag = false;
                    break;
                default :
                    System.out.println("입력된 메뉴는 확인 할 수 없습니다.");
            }
        }
    }

    public static MembershipMain getInstance(){
        if ( membershipMainInstance == null ) membershipMainInstance = new MembershipMain();
        return membershipMainInstance;
    }
}
