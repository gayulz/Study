package Tasks;

public class Test02 {
    public static void main(String[] args) {

        /*
        2. 철수는 행운의 번호를 선정하고 있다.
        첫번째 조건은   백의 자리가 7인경우
        두번째 조건은 십의 자리가 9인경우이다.
        번호는 000 - 999가지 라고 가정한다. 일의 자리는 무시한다.

        int num=975; 일경우 행운의 번호인가?

        2-1. if문 한개로 풀어 보세요
        2-2. 중첩if로 풀어 보세요.
        */

        int num = 975;
        // 9 7 5
        int number100 = num/100;  // 9
        int number10 = (num-(number100*100))/10;   // 7

        if(number100 == 7 && number10 == 9) {
            System.out.println(num + " : 행운의 번호 입니다 ");
        } else {
            System.out.println(num + " : 행운의 번호가 아닙니다");
        }

        System.out.println("--------------------------------------");

        if(number100 == 7) {
            if (number10 == 9) {
                System.out.println("행운의 번호 입니다");
            } else {
                System.out.println("행운의 번호가 아닙니다");
            }
        }
    }
}
