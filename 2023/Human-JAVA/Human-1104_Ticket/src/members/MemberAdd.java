package members;

import java.util.Scanner;

public class MemberAdd {
    MemberList memberList = MemberList.getInstance();
    MemberFunctions mFnc = new MemberFunctions();

    // 회원가입 클래스

    public void memberAdd() {
        Scanner in = new Scanner(System.in);
        MemberDefine user = new MemberDefine();
        MemberFunctions fnc = new MemberFunctions();
        System.out.println("회원가입");
        System.out.print(" >> 이름 입력 : ");
        String name = in.nextLine();
        user = mFnc.memberWho(name);
        if (user == null) {
            System.out.print(" >> 비밀번호 입력 : ");
            String userPass = in.nextLine();
            if (fnc.passValidity(userPass)) {
                for (int i = 0; i < memberList.listArray.length; i++) {
                    if (memberList.listArray[i] == null) {
                        memberList.listArray[i] = user;
                        System.out.println("회원 가입 완료");
                        break;
                    }
                }
            } else System.out.println("비밀번호 규칙에 위배됩니다.다시 시작하세요");
        } else System.out.println("기존 가입된 회원입니다");
    }
}

