package Task;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        // 문제 4 : a정수의 모든 숫자를 자리수 상관 없이 더한 값을 출력하시오

        int a = 6454634;
        // 6 4 5 4 6 3 4 / 10 하면 끝에 자리가 짤림 -- 몫으로 나눠짐
        int sum = 0;

//        while (a != 0){
//            sum += a % 10;      // 소수점 자리의 몫값을 sum에 누적
//            a /= 10;            // 끝에 숫자 4가 빠진 나머지 몫값을 a에 대입
//        }

        if ( a != 0 ) {
            sum = a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10;
            sum += a % 10;
            a = a / 10; }

        System.out.println(sum);





    }
}
