package main;
import member.*;
public class Main {
    public static void main(String[] args) {
        /*
               Todo : 프로그램의 시작
               improt는 외부에 정의되어있는 자료를 정의한다.
               improt(패키지명)(클래스명)
         */
        Member m = new Member();
//        m.name = "홍";
        m.setName("홍");
        System.out.println(m.getName());

    }
}
