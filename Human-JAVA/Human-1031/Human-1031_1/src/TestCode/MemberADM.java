package TestCode;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberADM {
    private Scanner in = new Scanner(System.in);
    private ArrayList<Member> mlist = new ArrayList<>();

    public MemberADM() {
        boolean flag = true;
        while (flag) {
            info();
            int selNum = in.nextInt();
            in.nextLine();
            if (selNum == 1) {
                add();
            } else if (selNum == 2) {
                mod();
            } else if (selNum == 3) {
                del();
            } else if (selNum == 4) {
                list();
            }
        }

    }

    private void del() {
        String id = keyData("아이디", 1);
        int delIdx = searchIdx(id);
        if (delIdx != -1) {
            mlist.remove(delIdx);
            System.out.println(delIdx + "삭제 완료");
        } else System.out.println("아이디가 없습니다 ");

    }

    private void mod() {
        String id = keyData("아이디", 1);
        int modIdx = searchIdx(id);
        if (modIdx != -1) {
            Member m = mlist.get(modIdx);
            m.setPass(keyData("비밀번호", 2));
        } else System.out.println("아이디가 없습니다.");
    }

    private void add() {
        Member m = new Member();
        String id = keyData("아이디", 1);
        int result = searchIdx(id);
        if (result == -1) {
            m.setId(id);
            m.setPass(keyData("비밀번호", 2));
            mlist.add(m);
        } else System.out.println("중복된 아이디입니다");
    }

    private void list() {
        for (Member m : mlist) {
            m.prt();
        }
    }

    private String keyData(String title, int level) {
        String data = null;
        while (data == null) {
            System.out.println(title + "을 입력해 주세요");
            System.out.print(" 입력 >> ");
            data = in.nextLine();
            if (level == 1){
                String s = "!@#$%^&*";
                int cnt = 0;
                for(int i=0; i < data.length(); i++){
                    int tempa = data.toUpperCase().charAt(i);
                    System.out.println(tempa);
                    if (tempa < 65 || tempa > 90){
                        System.out.println("한글만 입력하세요");
                        break;
                    }
                }
                for (int i = 0; i < data.length(); i++) {
                    char tt = data.charAt(i);
                    if ( tt >= 33 && tt <= 126 ){
                        for (int j = 0; j < s.length();  j++) {
                            if (tt == s.charAt(j)) {
                                cnt++;
                                break;
                            }
                        }
                    }
                }
                if (data.length() > 3){
                    if (cnt <= 0){
                        System.out.println("아이디에 특수문자 1개이상 입력되야합니다");
                        data = null;
                    }
                } else {
                    System.out.println("아이디는 4자리 이상 만들어주세요");
                    data = null;
                }
            } else if (level == 2){
                if (data.length() < 4){
                    System.out.println("비밀번호는 4자리 이상 만들어주세요");
                    data = null;
                }
            }
        }
        return data;
    }

    private int searchIdx(String id) {
        for (int i = 0; i < mlist.size(); i++) {
            if (mlist.get(i).getId().equals(id)) return i;
        }
        return -1;
    }

    private void info() {
        System.out.println("회원관리");
        System.out.println("1. 회원등록");
        System.out.println("2. 회원수정");
        System.out.println("3. 회원삭제");
        System.out.println("4. 회원전체보기");
        System.out.println("5. 종료");
        System.out.print(" 메뉴 번호 입력  >> ");
    }
}
