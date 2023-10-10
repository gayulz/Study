package TASK;

import java.util.Scanner;

public class task04 {
    public static void main(String[] args) {
//        for (int i = 1; i <= 4 ; i++) {
//            for (int j = 1; i-j >= 1 ; j++) {
//                System.out.print(" 0 ");
//            }
//            for (int j = i; i+j<= 8 ; j++) {
//                System.out.print(" * ");
//            }
//            System.out.println(" ");
//        }
        Scanner in = new Scanner(System.in);
        System.out.print("별 찍을 숫자를 입력하세요 : ");
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" 0 ");
            }
            for (int j = 1; j <= (size*2-1) - (i * 2); j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }
}
