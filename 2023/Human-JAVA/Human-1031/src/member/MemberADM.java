package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberADM {
    private Scanner in = new Scanner(System.in);
    private ArrayList<MemberDefine> memberList = new ArrayList<>();
    private Functions fn = new Functions();

    public MemberADM() {
        boolean flag = true;
        while (flag) {
            info();
            int userNum = in.nextInt();
            in.nextLine();
            switch (userNum) {
                case 1: // 고객 등록
                    add();
                    break;
                case 2: // 고객 수정
                    mod();
                    break;
                case 3: // 고객 삭제
                    del();
                    break;
                case 4: // 전체 보기
                    totalView();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    flag = false;
                    break;
                default:
                    System.out.println("사용 불가한 메뉴번호 입니다 다시 입력하세요");
            }
        }
    }

    // 회원 등록
    private void add() {
        System.out.println("회원 등록 입니다.");
        MemberDefine m = new MemberDefine();
        while(true) {
            System.out.println("아이디 규칙\n5글자 이상 , 한글 불가 , 영 대소문자 가능 , 숫자 불가 , 특수문자 [ ! @ # $ % ^ & * ] 1개 이상 포함 필수");
            String id = title("아이디");
            if (searchId(id) >= 0) {
                System.out.println("이미 등록된 아이디 입니다.");
            } else if (searchId(id) < 0 && !(fn.isId(id))) {
                System.out.println("아이디 생성규칙을 다시 확인하세요");
            } else {
                m.setId(id);
                System.out.println("비밀번호 규칙\n5글자 이상 , 특수문자 [ ! @ # $ % ^ & * ] 1개 이상 포함 필수");
                String pass = title("패스워드");
                if (fn.isPass(pass)) {
                    m.setPass(pass);
                    System.out.println(id + " 회원 가입 완료.");
                    memberList.add(m);
                    break;
                } else System.out.println("패스워드 생성규칙을 다시 확인하세요");
            }
        }
    }

    // 회원 수정
    private void mod() {
        System.out.println("회원 수정 입니다.");
        String id = title("조회 할 아이디");
        int memberIdx = searchId(id);
        if (memberIdx >= 0) {
            MemberDefine m = memberList.get(memberIdx);
            m.setPass(title("비밀번호"));
        } else System.out.println("입력된 아이디는 찾을 수 없습니다.");
    }


    // 회원 삭제
    private void del() {
        System.out.println("회원 삭제 입니다.");
        String id = title("아이디");
        int delIdxNum = searchId(id);
        if (delIdxNum >= 0) {
            System.out.println(id + " 삭제 완료");
            memberList.remove(delIdxNum);
        } else System.out.println("입력한 아이디는 찾을 수 없습니다");
    }


    // 회원 전체보기
    private void totalView() {
        for (MemberDefine m : memberList) {
            m.prt();
        }
    }

    // 기능 메서드 : 입력 후 리턴
    private String title(String text) {
        System.out.print(text + " 를 입력하세요 >> ");
        String title = in.nextLine();
        return title;
    }


    // 기능 메서드 : 특정 Id를 찾아 해당 인덱스 번호를 리턴
    private int searchId(String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) return i;
        }
        return -1;
    }

    private void info() {
        System.out.println("회원관리 메인메뉴");
        System.out.println("1. 회원등록");
        System.out.println("2. 회원수정");
        System.out.println("3. 회원삭제");
        System.out.println("4. 회원전체보기");
        System.out.println("5. 종료");
        System.out.print(" 메뉴 번호 입력  >> ");
    }
}
