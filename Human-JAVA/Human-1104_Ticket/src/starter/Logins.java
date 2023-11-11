package starter;
import controller.MembershipMain;
import members.MemberDefine;
import members.MemberAdd;
import members.MemberFunctions;
import members.MemberList;
import java.util.Scanner;

public class Logins {
    MembershipMain membershipMain = MembershipMain.getInstance();
    MemberFunctions mFnc = new MemberFunctions();
    Scanner in = new Scanner(System.in);
    MemberAdd add = new MemberAdd();
    MemberDefine whoUser = null;

    public Logins(){
        boolean flag = true;
        while (flag){
            info();
            int selectNumber = in.nextInt();
            switch (selectNumber){
                case 1 : // 회원가입
                    add.memberAdd();
                    break;
                case 2 : // 로그인
                    System.out.println(" 회원 이름을 입력하세요 : ");
                    String username = in.nextLine();
                    whoUser = mFnc.memberWho(username);
                    if (whoUser != null) membershipMain.info(whoUser);
                    break;
                case 3 : // 비회원 전용
                    //공사중
                    break;
                case 4 :
                    flag = false;
                    break;
                default:
                    System.out.println("없는 메뉴 입니다. 다시 선택 하세요");
            }
        }
    }
    public void info() {
        System.out.println("\t\t [ 회원 전용 티켓 예매소 입니다 ] ");
        System.out.print("1. 회원 가입");
        System.out.print("\t2. 로그인");
        System.out.print("\t3. 비회원 전용(조회만 가능)");
        System.out.println("\t4. 종료");
    }
}
