package main_menu;
import printInfoMenu.*;
import resource.*;
public class First_Menu {
    Funtions_prt prt = new Funtions_prt();
    Funtions_fn fn = new Funtions_fn();

    // 생성자
    public First_Menu(){
        boolean flag = true;
        while(flag){
            prt.first_menu_prt();
            int choiceNumber = Integer.parseInt(fn.returnText("번호"));
            switch (choiceNumber){
                case 1 :
                    // 회원로그인
                    break;
                case 2 :
                    // 회원 가입
                    break;
                case 3 :
                    // 비회원 전용
                    break;
                case 4 :
                    // 관리자 메뉴
                    break;
                case 5 :
                    System.out.println("Exit the program");
                    flag = false;
                    break;
                default:
                    System.out.println("No menu number entered");
            }
        }
    }


}
