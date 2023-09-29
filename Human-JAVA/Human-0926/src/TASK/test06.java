package TASK;
import java.util.Scanner;

public class test06 {
    public static void main(String[] args) {  
        /*  
        위뒤가똑같은너  
        키보드로 문자를 입력받는다.  
        이때 문자열의 길이는 0보다 크고 10보다 작으며 짝수만 가능하다.  
        조건에 만족될때까지 문자 입력을 받는다.  
        문자열을 앞으로 읽으나 뒤로 읽으나 같은 경우의 
        문자를 판별하는 코드를 작성하세요  
        */
        // 선언부
        String[] teststr = new String[6];
        Scanner in = new Scanner(System.in);
        int[] testInt = new int[6];
        int lt = 0;
        int rt = 5;

        // 배열 입력 부
        for (int i = 0; i < teststr.length; i++) {
            System.out.print( i + "번째 / 문자 6개를 입력해주세요 : ");
            teststr[i] = in.next();
        }

        // 비고 처리 후 출력 부
        for (int i = 0; i < teststr.length; i++) {
            if (teststr[lt].equals(teststr[rt])) {
                lt++;
                rt--;
            }
            if (rt < lt && lt == (teststr.length / 2)) {
                System.out.println("앞 뒤가 같은 글자 입니다 ");
                break;
            } else if (lt == 0 && rt == 5) {
                System.out.println("앞 뒤가 다른 글자 입니다 ");
                System.out.println(lt + " + " + rt);
                break;
            }
        }
    }
}