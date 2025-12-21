package block1.block;

import java.util.Random;
import java.util.Scanner;

public class Exe {
    // 전역변수
    String[] engArr = {"January", "February", "March", "April", "May", "June", "July", "Aug", "September", "October", "November", "December"};
    Scanner in = new Scanner(System.in);
    Random r = new Random();
    String[][] border = new String[4][5];
    int cnt = 0;

    // 생성자
    public Exe() {
        boolean flag = true;
        while (flag) {
            int choice = info();
            long startTime = System.currentTimeMillis();
            switch (choice) {
                case 1:
                    new MemoryTest();
                    break;
                case 2:
                    CreateBorder();
                    while (cnt <= 100) {
                        printBoders();
                        cnt += play();
                        if (cnt < 100) System.out.println("\n\t\t\t\t⚐ 현재 스코어 : " + cnt);
                        else if (cnt >= 100) System.out.println("\t\t\t\t⚐ 사용자 요청으로 종료합니다 ");
                    }
                    long stopTime = System.currentTimeMillis();
                    System.out.println("\n\t\t\t\t⚐ 플레이 시간 : " + (stopTime - startTime) / 1000 + "초");
                    break;
                default:
                    flag = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        }
    }


    // 사용자 입력후 일치되는 문자 확인후 반환 메서드
    private int play() {
        System.out.println("_________________________________________________________________________________________");
        System.out.print(" ☞ ☞ Player :  ");
        String userIn = in.nextLine().toLowerCase();
        int cnt = 0;
        if (userIn.equals("q")) cnt = 100;
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

    // 시작 멘트
    public int info() {
        System.out.println(" 게임 도중 종료시 Q , INFO화면에서 종료시 3을 눌러주세요 ");
        System.out.println(" 게임은 총 2가지 입니다\n\t\t☞ 1번 단기기억력 TEST영단어 게임\t\t☞ 2번 끝나지 않는 영단어 깨기 ");
        System.out.print(" ☞ ☞  Player :  ");
        int userRetrun = in.nextInt();
        return userRetrun;
    }
}
