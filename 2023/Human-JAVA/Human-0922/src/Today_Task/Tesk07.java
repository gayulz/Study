package Today_Task;

import java.util.Scanner;

public class Tesk07 {
    public static void main(String[] args) {
        // 문제 7 : 키보드로 입력받아 업 다운 게임하기
        //         정답까지 반복 해야한다 . 정답시 종료


        int com = 45;
        Scanner in = new Scanner(System.in);
        System.out.println("게임을 시작합니다.");
        System.out.print("1부터 100사이의 숫자를 입력하세요 : ");
        for (int i = 0; i < 1; i++) {
            int nowNum = in.nextInt();
            if (nowNum > 0 && nowNum <= 100){
                if (com>nowNum){
                    System.out.print("업 . 다시입력하세요 : ");
                } else if (com<nowNum) {
                    System.out.print("다운 . 다시입력하세요 : ");
                } else {
                    System.out.println("정답입니다.\n프로그램이 종료됩니다");
                    break;
                }
            } else {
                System.out.print("1부터 100까지 숫자로 다시 입력하세요 : ");
            }
            i-=1;
        }
    }
}

