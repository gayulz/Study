package Study;

import java.util.Random;

public class study01 {
    public static void main(String[] args) {
//        int a = 10; // int는 원시자료형이다
//        boolean b = true; // boolean원시타입 자료형이다
//        // 원시타입은
//
//        // String은 참조타입이다
//        String c = "abc";
//        // 참조 타입의 값은 내가 원하는 데이터가 있는 위치의 주소를 받는다
//        // 참조 타입은 공유의 목적이 있다
//        // 공유를 하면 자원을 아껴 쓸 수 있다 (매우중요!!)
//        // 자바에서 원시타입과 참조타입을 따로 공부하면 좋다
//        // 원시타입 자료형은 소문자로 시작한다 int , double , float, char,
//        // 원시타입인지 참조 타입인지 선언시 고민해야한다
//        // 배열은 참조타입이다
//        Random r = new Random();
//        선언문을 이해하는 방법, 원시변수와 참조변수를 생각한다
// 원시 변수는 아스키코드를 생각하면서 코드를 짜면 좋다
        int aa = 65;
        char bb = 65;
        System.out.println(aa+" " + bb);
        // char는 원시변수이고 아스키코드로 인해 10진수로 변환되어
        char b = '#'+1;
        System.out.println(b);
        System.out.println((int)b);
        System.out.println();
    }
}
