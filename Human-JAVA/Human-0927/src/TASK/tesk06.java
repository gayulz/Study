package TASK;

import java.util.Random;
import java.util.Scanner;

public class tesk06 {
    public static void main(String[] args) {
//        문제 6
//        컴퓨터는 랜덤으로 번호를 먼저 뽑고, 키보드로 사용자가 번호를 입력하는 방식으로 가위 바위 보 게임을 작성하시오
       // 선언문
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        int pc = r.nextInt(3);

        // 게임시작 알림
        System.out.println("가위바위보 게임 ");
        System.out.println("주먹 : 0 , 가위 : 1, 보 : 2");

        // User 입력값 확인 및 비교처리, 출력부
        for (int i = 0; i < 1; i++) {
            System.out.print("숫자를 입력 해 주세요 : ");
            int user = in.nextInt();
            if (user >= 3 || user < 0) {
                System.out.println("주먹 : 0 , 가위 : 1, 보 : 2 만 입력 가능합니다");
                i--;
            }
            if (pc == user) {
                System.out.println("무승부 입니다. 다시하세요");
                i--;
            }
            if (pc == 0) {
                if (user == 1) {
                    System.out.println("PC는 주먹, User는 가위입니다");
                    System.out.println("PC 승리");
                } else if ( user == 2 ){
                    System.out.println("PC는 주먹, User는 보입니다");
                    System.out.println("User 승리");
                }
            }
            if (pc == 1) {
                if (user == 0) {
                    System.out.println("PC는 가위, User는 주먹입니다");
                    System.out.println("User 승리");
                } else if(user == 2) {
                    System.out.println("PC는 가위, User는 보입니다");
                    System.out.println("PC 승리");
                }
            }
            if (pc == 2) {
                if (user == 0) {
                    System.out.println("PC는 보, User는 주먹입니다");
                    System.out.println("PC 승리");
                } else if(user == 1) {
                    System.out.println("PC는 보, User는 가위입니다");
                    System.out.println("User 승리");
                }
            }
        }
    }
}
