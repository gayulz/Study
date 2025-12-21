package movietiket;

import java.util.Scanner;

public class LoginMain {
    Scanner in = new Scanner(System.in);
    TicketAdmin ticketAdmin = new TicketAdmin();
    Members nowUser = null;

    public LoginMain() {
        // TODO : 로그인 및 회원가입 생성자
        boolean flag = true;
        while (flag) {
            info();
            int inputNumber = in.nextInt();
            in.nextLine();
            switch (inputNumber) {
                case 1:
                    loginMember();
                    break;
                case 2:
                    joinMember();
                    break;
                case 3:
                    flag = false;
                    System.out.println("프로그램을 종료합니다");
                    break;
                default:
                    System.out.println("✘ 입력된 메뉴는 없습니다 ✘");
            }
        }

    }

    private void info() {
    }

    // 회원 가입 메서드
    private void joinMember() {
        nowUser = ticketAdmin.memberAdd();
        if (nowUser != null) {
            ticketAdmin.infodesk(nowUser);
            nowUser = null;
        }
    }

    //로그인 메서드
    private void loginMember() {
        int cnt = 0;
        while (cnt < 3) {
            System.out.print("\t ✐ 이름 입력 ➜ ");
            String loginName = in.nextLine();
            nowUser = ticketAdmin.findName(loginName);
            if (nowUser == null) {
                System.out.println("입력하신 이름은 가입되지 않았습니다");
                break;
            } else {
                System.out.print("\t ✐ 비밀번호 입력 ➜ ");
                String loginPass = in.nextLine();
                if (nowUser.memberPass.equals(loginPass)) {
                    ticketAdmin.infodesk(nowUser);
                    nowUser = null;
                    break;
                } else {
                    System.out.println("입력하신 비밀번호는 틀렸습니다");
                    if (nowUser == null) {
                        cnt++;
                        System.out.println("남은 입력 횟수 (" + cnt + "/3)");
                    }
                }
            }
        }
    }
}
