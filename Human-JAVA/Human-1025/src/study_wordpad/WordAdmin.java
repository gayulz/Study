package study_wordpad;

import java.util.Scanner;

public class WordAdmin {
    // 등록, 수정, 삭제하는 클래스
    Scanner in = new Scanner(System.in);
    Word[] wlist = new Word[10];

    WordAdmin() {

    }

    public void menu() {

    }

    public void add() {

    }

    public void mod(){
        // 제목으로 검색 후 제목과 일치한 객체를 찾아 멤버 변수를 수정
        String delTitle = in.nextLine(); // 수정할 제목을 지정함
        for (int i = 0; i < wlist.length; i++) {
            if (wlist[i] != null){
                if (wlist[i].title.equals(delTitle)){
                    // 조건이 참이면 수정할 객체를 찾은것 , 그 객체는 wlist[i]
                    System.out.println("내용을 수정하세요");
                    String newMemo = in.nextLine();
                    wlist[i].memo = newMemo;
                    System.out.println("중요도를 입력하세요");
                    int newFlag = in.nextInt();
                    in.nextLine();
                    wlist[i].flag=newFlag;
                }
            }
        }
    }

    public void del() {

    }

    public void alllist() {
        for (int i = 0; i < wlist.length; i++) {
            if (wlist[i] != null ){
                wlist[i].prt();
            }
        }

    }

    public void search() {
        String sTitle = in.nextLine();
        for (int i = 0; i < wlist.length; i++) {
            if (wlist[i] != null ) {
                if (wlist[i].title.equals(sTitle)) wlist[i].prt();
            }
        }

    }
}
