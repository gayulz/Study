package TASK;

import java.util.Random;

public class randomHash {
    public static void main(String[] args) {
        int[] lotto = new int[100];
        Random random = new Random();

        // 로또 번호 10000번 랜덤 추출
        for (int i = 0; i < 100; i++) {
            int rNumber = random.nextInt(45) + 1;
            lotto[rNumber -1]++;
        }

        // 중복된 값의 개수 출력
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i] > 1) {
                System.out.println("번호 " + (i + 1) + " : " + lotto[i] + "개");
            }
        }

        // 가장 많이 뽑힌 로또 번호 찾기
        int maxNum = 0;
        int reNumber = 0;

        for (int i = 0; i < lotto.length; i++) {
            if (maxNum <= lotto[i]){
                maxNum = lotto[i];
                reNumber = i + 1;
            }
        }

        // 추천 로또 번호 출력
        System.out.println("오늘의 추천 로또 번호: " + reNumber);
    }
}
