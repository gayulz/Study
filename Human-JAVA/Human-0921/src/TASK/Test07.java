package TASK;

public class Test07 {
    public static void main(String[] args) {
        /*
        System.out.println("abc");  // i변수 값을 출력후 줄바꿈을 하는 코드이다.
        System.out.println("def");  // 위코드를 실행하면
        abc
        def

       System.out.print("abc");    // ln이 빠지면 i변수 값을 출력 후 줄바꿈을 하지 않는 코드이다.
       System.out.print("def");
       // 위코드를 실행하면
       abcdef

         문제>> 다음과 같이 출력하게 하시오.
        1+2+3+4+5+6+7+9+9+10=결과값
        */

        int tot = 0;
        for (int i = 1; i <= 10; i++) {
            if (i == 10){
                tot+=i;
                System.out.print(i+ " = "+tot);
            } else {
                tot+=i;
                System.out.print(i + " + ");
            }
        }
    }
}
