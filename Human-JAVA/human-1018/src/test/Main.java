package test;

public class Main {
    // 메인 메소드가 있는 클래스는 프로그램의 시작을 알리는 역할 정도만 한다
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다.");
        Admin a = new Admin(); // 생성자 , 객체를 만들때는 생성자를 호출해서 만드는 것이다
        //new Admin();         // 생성자는 1번만 호출되기때문에 굳이 변수를 사용하지 않아도 실행된다
        System.out.println("프로그램 종료");
    }
}
