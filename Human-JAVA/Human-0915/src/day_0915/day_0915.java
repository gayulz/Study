package day_0915;

public class day_0915 {
    public static void main(String[] args) {
        // 들여쓰기를 꼭 지킨다
        // 자바는 대소문자를 판단한다, 오타 금지
        // 들여쓰기를 잘해야 가독성이 높아진다
        // 철수의 이름을 저장시킨다
        String name = "철 수";
        // 선언문, 변수를 사용하겠다 라는 선언임 , 메모리를 할당하는 작업
        // 변수를 만들고 저장하는 코드
        // 해석 : 변수명은 name이다. 변수가 가질 수 있는 값은 문자열이다 , 초기값은 철수이다.
        System.out.println(name);
        // 철수가 박수로 개명을 했다
        name = "박수";
        System.out.println(name);
        // 자료형이 앞에 없다면 선언문이 아니다.
        int num = 10;
        System.out.println(num);
        System.out.println("현재 저장된 사탕의 갯수 : " + num);
        // 철수가 사탕 하나를 먹었다.
        num = num - 1;
        System.out.println("철수가 1개 먹었다 남은 갯수는? : " + num);






    }
}
