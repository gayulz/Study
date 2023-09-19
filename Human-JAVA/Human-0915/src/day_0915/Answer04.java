package day_0915;

public class Answer04 {
    public static void main(String[] args) {

        /*
        *철수는 프로그램이름을 저장하고, 프로그램이름은 거스름돈 계산기
        int money=10000;
        int pay= 2300;
        천원짜리 몇개, 백원짜리 몇개,십원자리 몇개, 일원짜리 몇 개 이렇게 출력한다.
         */

        int money=10000;
        int pay=2331;
        int change = money - pay;                              // 잔돈 변수 생성

        int rechange1000 = change%1000;                        // 7669원의 나머지 699원을 저장
        int rechange100 = rechange1000%100;                    // 669원의 나머지 69원을 저장

        System.out.println("거스름 돈 : " + change);              // 7669             : 잔돈 저장
        System.out.println("천원 갯수 : " + (change/1000));       // 7669 나누기 1000원 : 몫 7
        System.out.println("백원 갯수 : " + (rechange1000/100));  // 669  나누기 100원  : 몫 6
        System.out.println("십원 갯수 : " + (rechange100/10));    // 69   나누기 10원   : 몫 6
        System.out.println("십원 갯수 : " + (rechange100%10));    // 69   나누기 10원   : 나머지 9

        /*
            기존 변수를 활용하는 방법을 생각 해 보자.
        */


    }
}
