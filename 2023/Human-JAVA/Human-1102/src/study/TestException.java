package study;

public class TestException {
    public static void main(String[] args) throws InterruptedException {
        // ctrl + f11 실행시 jvm에 main 스레드가 생성된다.
        // main 메서드를 호출한다
//        System.out.println(Thread.currentThread().getName());
        /* currentThread 는 메서드
        Thread 개념
        자바 소스를 실행하는 것이 Thread이다.
        Thread가 있어야 실행이 가능하다
        Thread마다 이름을 갖고있는데 currentThread().getName()을 쓰게되면 이름을 가져온다
        Thread.sleep 하면 잠시 Thread를 잠재운다는 의미
        Test 객체를 만들고 kkk()메서드에 접근
        main스레드는 객체를 만들고 t 참조 변수의 주소값을 참조하여 kkk()메서드의
        모든 명령어가 다 실행되면 리턴한다
        */
        Test t = new Test();
        t.kkk();
        // 소스는 명령어의 집합이다. 실행중이진 않는다
        // 소스를 실행하게 하는 것이 Thread이다.
        // Thread 라인별로 읽어온다. 세미콜론으로 끝나는걸 인식한다
        // 현재는 main Thread 가 모든 처리를 해준다 : Single Thread
    }
}
