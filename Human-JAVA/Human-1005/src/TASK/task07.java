package TASK;

public class task07 {
    public static void main(String[] args) {
        int money = 4570;  // 가격
        int pay = 100000;  //지불금액
        int jan = pay - money;
        // 만원 짜리가 거스름돈의 최대이다.
        for (int i = 10000; i > 0; i=i/10 ) {
            System.out.println( i + "원 짜리 " + jan / i + "개 입니다.");
            jan = jan % i;
        }
    }
}

