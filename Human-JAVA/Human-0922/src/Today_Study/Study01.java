package Today_Study;

import java.util.Scanner;
public class Study01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("더하는 계산기");
        System.out.print("첫번째 숫자 입력 : ");
        int num1 = in.nextInt();
        System.out.print("두번째 숫자 입력 : ");
        int num2 = in.nextInt();
        System.out.println("덧셈 결과  : " + (num1 + num2));
    }
}
