package Today_Task;

import java.util.Scanner;

public class Tesk05 {
    public static void main(String[] args) {
        // 문제 5 : 키보드로 숫자를 입력받아 홀 짝 인지 판별하시오


        Scanner in = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        int numBer = in.nextInt();
        if (numBer % 2 == 0){
            System.out.println("\n짝수 입니다.");
        }else{
            System.out.println("\n홀수 입니다.");
        }
    }
}
