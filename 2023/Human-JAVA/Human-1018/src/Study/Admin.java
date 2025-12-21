package Study;

import java.util.Scanner;

public class Admin {
    Scanner in = new Scanner(System.in);
    // 클래스 영역에 선언 : 멤버 변수 , 클래스 전체에서 사용가능
    // 선언하는 위치에 따라 사용 가능한 범위가 달라진다
    String[] name = new String[10];
    // 회원의 이름을 저장할 배열을 만듬
    public Admin() {
        boolean flag = true;
        // 블록 내에서 선언함 : 지역 변수 , 블록 안에서만 사용 가능하다.
        while (flag){
            menu();
            System.out.print("메뉴를 선택하세요 : ");
            int num = in.nextInt();
            in.nextLine();
            // next를 사용해서 키보드 입력을 받는 경우 nextLine을 꼭 써줘야한다.
            // 사용해야 하는 이유는 내일 알려주신다함
            if (num  == 1){
                addMember();
            } else if (num == 5){
                memberList();
            }else if (num == 6){
                flag = false;
            }
        }
    }

    public void addMember() {
        System.out.print("신규 회원의 ID를 입력하세요 . : ");
        String newName = in.nextLine();
        for (int i = 0; i < name.length; i++) {
            if (name[i] == null){
                // 입력 받는 공간이 빈 공간이라면
                name[i] = newName;
                // 입력을 받아라
                break;
                // 입력 받은뒤 탈출
            }
        }
    }

    public void memberList(){
        System.out.println("전체 회원 보기");
        for (int i = 0; i < name.length; i++) {
            System.out.println(i+"번 고객 : " + name[i]);
        }
    }
    public void menu(){
        System.out.println("----------[ 1. 입력 | 2. 수정 | 3. 삭제 | 4. 검색 | 5. 전체보기 | 6. 종료 ]----------");
    }
}
