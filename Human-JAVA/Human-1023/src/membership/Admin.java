package membership;

import java.util.Scanner;

// 클래스 정의 : 회원관리(추가, 검색, 수정, 삭제)
public class Admin {
    Scanner in = new Scanner(System.in);
    Members[] mList = new Members[5];
    Fnc fncLink = new Fnc();
    // 생성자
    Admin(){
        boolean f = true;
        while(f) {
            menu();
            System.out.print(" 메뉴 선택 >> ");
            int selMenu = in.nextInt();
            in.nextLine();
            if (selMenu == 1){
                add();
            }else if(selMenu == 2){
                viewList();
            }else if(selMenu == 3){
                ser();
            }else if(selMenu == 4){
                f = false;
            }
        }
    }

    private void ser() {
        System.out.println("검색할 이름을 입력하세요");
        String name  = in.nextLine();
        for (int i = 0; i < mList.length; i++) {
            if (mList[i] != null){
                if (mList[i].name.equals(name)){
                    mList[i].prt();
                    break;
                }
            }
        }
    }

    public void menu(){
        System.out.println("1. 신규가입");
        System.out.println("2. 전체보기");
        System.out.println("3. 검색하기");
        System.out.println("4. 종료하기");

    }

    public void add(){
        System.out.println("신규 가입 입니다 . . . . ");
        Members m = new Members();
        System.out.print(" 이름 입력 >> ");
        String name = in.nextLine();
        if (fncLink.chkString(name) != 0) {
            m.name = name;
            System.out.print(" 주소 입력 >> ");
            String addr = in.nextLine();
            m.addr = addr;
            System.out.print(" 나이 입력 >> ");
            int age = in.nextInt();
            m.age = age;
            for (int i = 0; i < mList.length; i++) {
                if (mList[i] == null){
                    mList[i] = m;
                    m = null; // 메모리 누수를 막는 코드
                    break;
                }
            }
        }
        else System.out.println("이름에 특수 문자가 없습니다");
    }
    public void viewList(){
        for (int i = 0; i < mList.length; i++) {
            if (mList[i] != null)  mList[i].prt();
        }
    }

    public void mod(){

    }

    public void del(){

    }

}
