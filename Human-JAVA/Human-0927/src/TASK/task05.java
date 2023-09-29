package TASK;
import java.util.Random;

public class task05 {
    public static void main(String[] args) {
//        4번에서 중복이 되지 않게 하시오...  이때 for문은 한 개만 사용

        // 선언부
        Random r = new Random();
        int[] lotto = new int[6];
        // 로또번호 랜덤추출 입력 처리문
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = r.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]){
                    i--;
                }
            }
        }


        System.out.println("로또번호 랜덤생성기");
        System.out.println("--------------------");
        // 로또번호 출력부
        for (int i = 0; i < lotto.length; i++) {
            System.out.println(i + 1 + "번 번호 : " + lotto[i]);
        }
    }
}

