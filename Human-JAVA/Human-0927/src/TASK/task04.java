package TASK;

import java.util.Random;

public class task04 {
    public static void main(String[] args) {
//        Random r = new Random();
//        변수이름은 r이며 랜덤한 숫자를 추출하는 기능인 Random이라는 자료형을 선언함
//        int num = r.nextInt(45)+1;
//        변수 r을 참조하여 nextInt 메서드를 호출함. 매개변수는 랜덤한 숫자의 범위를 지정함
//        즉 0 - 44까지 중 랜덤한 숫자 하나를 선택하여 리턴함.
//        로또 번호는 1-45까지 이므로 리턴값이 +1로 보정함
//        리턴값을 보정하여  num변수의 값에 대입
//        위 코드를 이용하여
//        문제 4
//        로또번호를 자동으로 생성하는 게임을 작성하시오.
//        중복허용 가능, 로또 번호 6개를 배열에 저장하고, 출력하시오.

        // 선언부
        Random r = new Random();
        int[] lotto = new int[6];

        // 로또번호 랜덤추출 입력 처리문
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = r.nextInt(45) + 1;
        }
        System.out.println("로또번호 랜덤생성기");
        System.out.println("--------------------");
        // 로또번호 출력부
        for (int i = 0; i < lotto.length; i++) {
            System.out.println(i + 1 + "번 번호 : " + lotto[i]);
        }
    }
}

