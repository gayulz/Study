package infoDesk;

import DAO.AccessDAO;
import DAO.MembersDAO;
import DTO.MembersDTO;
import funtion.Funtions;
import membershipRounge.Admin;
import membershipRounge.MemberMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// todo : 프로그램 시작 후 메뉴선택 클래스
public class Info {
    // 회원 멤버리스트
    private MembersDTO member = null;
    private MemberMain memberMain = MemberMain.getInstance();
    private Admin adminSelf = Admin.getInstanse();
    private AccessDAO driver = AccessDAO.getInstance();
    private Funtions fn = new Funtions();
    private MembersDAO dao = new MembersDAO();

    // 로그인/회원가입/비회원전용/관리자로그인 메뉴를 출력
    public Info() {
        AccessDAO driver = this.driver;
        boolean flag = true;
        while (flag) {
            fn.linePrt();
            info();
            int sel = Integer.parseInt(fn.OutText("번호"));
            switch (sel) {
                case 1: // 로그인
                    member = login(1);
                    if (member != null) memberMain.info(member);
                    break;
                case 2: // 회원가입
                    member = singUpMember();
                    if (member != null) memberMain.info(member);
                    else System.out.println("회원 정보를 확인 할 수 없습니다");
                    break;
                case 3: // 비회원전용
                    new NoMember();
                    break;
                case 4:// 관리자로그인
                    login(4);
                    break;
                case 5: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다");
                    flag = false;
                    break;
                default:
                    System.out.println("번호가 없습니다.");
            }
        }
    }

    // 회원 로그인 메뉴
    private MembersDTO login(int sel) {
        int loginCnt = 0;
        switch (sel) {
            case 1:
                fn.linePrt();
                System.out.println("회원 로그인 메뉴입니다");
                while (loginCnt < 3) {
                    String tmpId = fn.OutText("아이디");
                    String tmpPw = fn.OutText("비밀번호");
                    this.member = dao.serUser(tmpId, tmpPw);
                    if (member != null) {
                        System.out.println(member.getName() + "님 반갑습니다 정상 로그인 되었습니다");
                        return member;
                    } else {
                        loginCnt++;
                        System.out.println(" [ " + loginCnt + "회/ 3회 ] 시도 횟수 초과 시 초기화면으로 이동합니다");
                    }
                }
                break;
            case 4:
                fn.linePrt();
                System.out.println("관리자 로그인 메뉴입니다");
                while (loginCnt < 3) {
                    String tmpId = fn.OutText("아이디");
                    String tmpPW = fn.OutText("비밀번호");
                    if (tmpId.equals("admin") && tmpPW.equals("human")) {
                        adminSelf.adminInfo();
                        break;
                    } else {
                        loginCnt++;
                        System.out.println(" [ " + loginCnt + "회/ 3회 ] 시도 횟수 초과 시 초기화면으로 이동합니다");
                    }
                }
                break;
        }
        return null;
    }

    // 회원 가입 메뉴
    private MembersDTO singUpMember() {
        MembersDTO member = new MembersDTO();
        fn.linePrt();
        System.out.println("회원 가입 입니다");
        member.setId(fn.OutText("아이디"));
        member.setPw(fn.OutText("비밀번호"));
        member.setName(fn.OutText("이름"));
        if (dao.memberAdd(member) != null) return member;
        return null;
    }

    // 인포 메뉴내용 출력 메서드
    private void info() {
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 비회원전용");
        System.out.println("4. 관리자용 로그인");
    }
}
