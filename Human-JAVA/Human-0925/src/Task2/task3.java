package Task2;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        // 문제 3 : 로또 번호를 저장 할 수 있는 배열을 선언하고 키보드로 6개 숫자를 입력 후 출력하라

        // 선언부
        int[] lottoN = new int[6];
        Scanner in = new Scanner(System.in);

        // 로또번호 입력부
        for (int i = 0; i < lottoN.length ; i++) {
            System.out.print("로또 번호를 입력하세요 1 ~ 46 까지. " + (i+1) + " 번째 입력 : ");
            lottoN[i] = in.nextInt();
            if (lottoN[i] >= 46) {
                i--;
                System.out.println(" 46 미만으로 다시 입력하세요 . ");
            }
        }

        // 입력된 번호 출력부
        for (int i = 0; i < lottoN.length; i++) {
            System.out.println( (i+1) + "번째 입력 로또 번호  : " + lottoN[i]);
        }
    }
}
