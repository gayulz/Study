package membership;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fnc fncLink = new Fnc();
        Scanner in = new Scanner(System.in);
        // todo : 회원관리하는 프로그램 실행
        System.out.print("관리자 암호 입력 : ");
        String pass = in.nextLine();
        if (fncLink.chkString(pass)!=0) {
            if (pass.equals("1234!!")) new Admin();
            else System.out.println("암호 불일치");
        }
        else System.out.println("암호에 특수문자가 필요합니다");
    }
}
