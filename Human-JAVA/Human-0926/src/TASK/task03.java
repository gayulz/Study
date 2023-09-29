package TASK;

public class task03 {
    public static void main(String[] args) {
        /*
        문제  : 현상수배
        int[] letter={8,12,4,13,25,14,4,5}
        범인을찾으시오
        범인은 짝수이면서 가장큰 값이다.
        범인은 14입니다.
        */

        // 배열선언
        int[] letter={8,12,4,13,25,14,4,5};
        int hes = 0;
        int max = letter[0];

        // 범인찾는 실행문
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > max ){
                if ( letter[i]%2==0 ) {
                    hes = letter[i];
                }
            }
        }

        // 범인 출력문
        System.out.println("내가 찾는 범인은 : " + hes);

    }
}
