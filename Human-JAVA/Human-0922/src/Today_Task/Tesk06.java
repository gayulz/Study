package Today_Task;

import java.util.Scanner;

public class Tesk06 {
    public static void main(String[] args) {
        // 문제 6 : 키보드로 숫자 2개를 입력받아 서로의 차를 구하는 프로그램을 작성하시오


        Scanner in = new Scanner(System.in);
        System.out.print("숫자1번을 입력하세요 : ");
        int num1 = in.nextInt();
        System.out.print("숫자2번을 입력하세요 : ");
        int num2 = in.nextInt();
        System.out.println("숫자1번과 2번의 차 : " + (num1-num2));
    }
}
