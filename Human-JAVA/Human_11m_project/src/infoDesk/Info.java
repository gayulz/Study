package infoDesk;
import DTO.MembersDTO;
import funtion.Funtions;
import membershipRounge.MemberMain;

import java.util.ArrayList;

// todo : 프로그램 시작 후 메뉴선택 클래스
public class Info {
    private Funtions fn = new Funtions();
    // 회원 멤버리스트
    private static ArrayList<MembersDTO> memberList = new ArrayList<>();
    private MembersDTO member = null;
    MemberMain memberMain = MemberMain.getInstance();
    public Info(){
        boolean flag = true;
        while (flag){
            if ( member == null ) System.out.println("비 회원 입니다");
            if ( member != null ) System.out.println(member.getName() + "님 반갑습니다");
            info();
            int sel = Integer.parseInt(fn.OutText("번호"));
            switch ( sel ){
                case 1 : // 로그인
                    member = login();
                    if (member != null) memberMain.info(member);
                    else member = login();
                    break;
                case 2 : // 회원가입
                    member = singUpMember();
                    if (member != null ) memberMain.info(member);
                    else System.out.println("회원 정보를 확인 할 수 없습니다");
                    break;
                case 3 : // 비회원전용
                    // 아직 미구현
                    break;
                case 4 : // 프로그램 종료
                    System.out.println("프로그램을 종료합니다");
                    flag = false;
                    break;
                default :
                    System.out.println("번호가 없습니다.");
            }
        }
    }

    private MembersDTO login() {
        System.out.println("로그인 메뉴입니다");
        int loginCnt = 0 ;
        while ( loginCnt < 3 ){
            String tmpId = fn.OutText("아이디");
            String tmpPw = fn.OutText("비밀번호");
            this.member = fn.isMappingMember(tmpId, tmpPw);
            if (member != null){
                System.out.println(member.getName()+"님 반갑습니다 정상 로그인 되었습니다");
                return member;
            } else {
                loginCnt++;
                System.out.println( " [ " + loginCnt + "회/ 3회 ] 시도 횟수 초과 시 초기화면으로 이동합니다");
            }
        }
        return null;
    }

    private MembersDTO singUpMember(){
        MembersDTO member = new MembersDTO();
        System.out.println("회원 가입 입니다");
        member.setId(fn.OutText("아이디"));
        member.setPw(fn.OutText("비밀번호"));
        member.setName(fn.OutText("이름"));
        if ( fn.isMappingMember(member.getId() , member.getPw()) == null ){
            memberList.add(member);
            System.out.println(member.getName() + "님 회원가입 감사합니다");
            return member;
        }
        return null;
    }

    private void info(){
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 비회원전용");
    }

    /*
    Getter & Setter
     */

    public static ArrayList<MembersDTO> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<MembersDTO> memberList) {
        this.memberList = memberList;
    }
}
