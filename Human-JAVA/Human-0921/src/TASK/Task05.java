package TASK;

public class Task05 {
    public static void main(String[] args) {
        // 범인은 100부터 999까지 숫자에 숨어 있다.
        // 범인은 십의 자리에 있고. 3의 배수이다. 범인 숫자를 모두 출력하시오.
        for (int i = 100; i < 1000 ; i++) {
            int viv = (i%100)/10;
            if(viv%3==0 && viv != 0) {
                    System.out.println(i);
            }
        }
    }
}

