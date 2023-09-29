
import java.util.Objects;
import java.util.Scanner;

public class test06 {
    public static void main(String[] args) {
        /*
        위뒤가똑같은너
        키보드로 문자를 입력받는다.
        이때 문자열의 길이는 0보다 크고 10보다 작으며 짝수만 가능하다.
        조건에 만족될때까지 문자 입력을 받는다.
        문자열을 앞으로 읽으나 뒤로 읽으나 같은 경우의 문자를 판별하는 코드를 작성하세요
        */
        //String[] teststr = new String[6];
        int[] testInt = new int[6];
        Scanner in = new Scanner(System.in);


        for (int i = 0; i < testInt.length; i++) {
            System.out.print( i + "번째 / 숫자 6개를 입력해주세요 : ");
            testInt[i] = in.nextInt();
        }

        for (int i = 0; i < testInt.length; i++) {
            int lt = i;
            int rt = 5;
            System.out.println(testInt[i]);
            if( testInt[lt] == testInt[rt] ) {
                rt--;
                System.out.println( i + "번째 : " + lt + " / " + rt);
            }
        }
    }
}
