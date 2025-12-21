package TASK;

public class Test08 {
    public static void main(String[] args) {
        /*
        피보나치 수열구하기.
        i는 피보나치 수의 갯수이다.  1 2 3 4 5 6 7 8  총 8개의 피보나치 수를 구하고 합한 값을 출력하시오.
        for(int i=1;i < 8; i++){

        }
        결과 : 1 + 1 + 2 +3 + 5 + 8 + 13 + 21 = 합한 값
        */

        int jun = 0 , pi = 1, Sum = 0;

        for (int i = 1; i <= 8; i++) {
            int tot = jun + pi;
//            if (pi >= 21)  {
//                System.out.print(pi);
//            } else {
//                System.out.print(pi + " + ");
//            }
            Sum += pi;
            jun = pi;
            pi = tot;
        }
        System.out.println(" 합산 값 :  "+ Sum);
    }
}
