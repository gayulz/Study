package TEST01;

public class sample01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);                      // c 변수 값을 출력하라 의미 외에는 어떤 설명을 할 수 없는것을 유의
        System.out.println(c+20);                   // c 변수 값을 값에 정수 20을 연산하여 출력한다, c의 값은 변하지 않는다 . 출력만함
        System.out.println(b/a);                    // b 변수 값에 a 변수 값을 나누는 산술 연산의 값을 출력한다.
        System.out.println(a/b);                    // a 변수 값에 b 변수 값을 나누는 산술 연산을 한 뒤 출력한다.
                                                    // 단, 자료형이 정수임으로 결과값이 실수 이더라도 정수의 값만 출력한다.

        System.out.println((float) a/b);            // 캐스팅 , 자료형 형 변환 방법

        float d =  a/b;
        System.out.println(d);                      // 0.0으로 찍히는 이유
        System.out.println(a);                      // 정수로 찍히는 이유

        /*

        과제
        a 는 정수 10 이고
        b 는 정수 20 이다
        c 는 정수 30 이다
        d 는 실수 자료형 이다. a 의 정수 자료형과 b의 정수 자료형의 결과는 0.5이지만 두 변수의 자료형이 정수 임으로 0이라는 값이 d에 입력된다.
        d 의 자료형은 실수형 임으로 0.0을 갖게 된다. (연산자 처리 순서에 따라서 진행된다)
        a 의 자료형은 이미 정수로 선언되어 있으므로 그대로 정수형을 유지하며 값인 10을 출력하게된다.
        형 변환은 잠깐 바뀔 뿐이고 실제 자료형이 바뀌지 않는다.

        -- 응용문제 --
        float d 의 값이 0.5가 되게 하라
        float d = (float) a/b; // 캐스팅하여 일시적으로 a의 자료형을 실수로 변환화면 됨

        */

        System.out.println("-------------------------------------------------------");
        // 결과값 유추하기, Run 시키기 저 결과값 출력에 대해서 고민해보자

        int aa = 20;
        float bb = 10.2f;
        System.out.println(aa);         // 20
        System.out.println(bb);         // 10.2
        bb = bb+20;                     // 30.2
        System.out.println(bb);         // 30.2
        System.out.println(aa+(int)bb); // 50
        System.out.println(aa);         // 20

        int dd = 4;
        float cc = aa*(2+dd)/3+(float)bb;
        System.out.println(cc);
//        aa*(6)/3+30.2
//        20*6/3+30.2
//        120/3 = 40+30.2
//        70.2


    }
}
