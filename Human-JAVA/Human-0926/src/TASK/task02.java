package TASK;

import sun.font.FontRunIterator;

public class task02 {
    public static void main(String[] args) {
        /*
        문제 : 큰놈
        int[] letter={8,12,4,13,2,14,4,5}
        배열의 가장 큰수가 있는 인덱스를 출력하시오. 출력값은 5입니다.
        */

        // 선언문
        int[] letter={8,12,4,13,2,14,4,5};
        int spot = 0;

        // 큰수를 찾는 실행문
        for (int i = 0; i < letter.length; i++) {
            int max = letter[0];
            if (max < letter[i]){
                spot = i;
            }
        }

        // 결과 출력문
        System.out.println(" 배열 중 가장 큰 수의 인덱스번호 : " + spot);

    }
}
