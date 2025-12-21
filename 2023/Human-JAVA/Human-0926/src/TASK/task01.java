package TASK;

public class task01 {
    public static void main(String[] args) {
        /*
        문제  :  선택받은너
        int[] letter={8,12,4,13,2,14,4,5}
        짝수만 출력하시오.
        */

        // 배열 선언문
        int[] letter = { 8, 12, 4, 13, 2, 14, 4, 5 };

        // 짝수만 찾아내여 반복 출력하는 문
        for (int i = 0; i < letter.length; i++) {
            if (letter[i]%2==0){
                System.out.println("짝수 : " + letter[i]);
            }
        }
    }
}
