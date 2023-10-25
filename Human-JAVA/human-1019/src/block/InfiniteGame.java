package block;

import java.util.Random;
import java.util.Scanner;
// 무한 단어깨기 게임
public class InfiniteGame {
    // 전역변수
    String[] engArr = {"January", "February", "March", "April", "May", "June", "July", "Aug", "September", "October", "November", "December"};
    Scanner in = new Scanner(System.in);
    Random r = new Random();
    String[][] border = new String[4][5];
    int cnt = 0;
    long startTime = System.currentTimeMillis();

    public InfiniteGame() {
        CreateBorder();
        while (true) {
            printBoders();
            cnt += play();
            if (cnt > 0) System.out.println("\t⚐ 현재 스코어 : " + cnt);
            else {
                System.out.println("\t\t⚐ 사용자 요청으로 종료합니다 ");
                System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════\n");
                break;
            }
            long stopTime = System.currentTimeMillis();
            System.out.println("\t⚐ 플레이 시간 : " + (stopTime - startTime) / 1000 + "초");
            System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════\n");

        }
    }

    // 사용자 입력후 일치되는 문자 확인후 반환 메서드
    private int play() {
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════\n");
        System.out.print(" ☞ ☞ Player :  ");
        String userIn = in.nextLine().toLowerCase();
        int cnt = 0;
        if (userIn.equals("q")) cnt = -100;
        else {
            for (int i = 4 - 1; i >= 0; i--) {
                for (int j = 0; j < 5; j++) {
                    if (border[i][j].toLowerCase().equals(userIn)) {
                        cnt++;
                        border[i][j] = "null";
                    }
                }
            }
        }
        for (int k = 0; k < 5; k++) {
            for (int i = 3; i >= 1; i--) {
                for (int j = 0; j < 5; j++) {
                    if (border[i][j].equals("null")) {
                        border[i][j] = border[i - 1][j];
                        border[i - 1][j] = "null";
                    }
                }
            }
        }
        return cnt;
    }
    // 보드판 출력 및 수정 메서드
    public void printBoders() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (border[i][j].equals("null")) {
                    border[i][j] = engArr[r.nextInt(engArr.length - 1)];
                    String tmp = String.format("✧ %-20s", border[i][j]);
                    System.out.print(tmp);
                } else {
                    String tmp = String.format("✧ %-20s", border[i][j]);
                    System.out.print(tmp);
                }
            }
            System.out.println();
        }
    }
    // Boder판 생성
    public void CreateBorder() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                border[i][j] = engArr[r.nextInt(engArr.length - 1)];
            }
        }
    }
}
