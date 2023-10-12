package miniproject_1011;
import java.util.Scanner;
import static miniproject_1011.trueAndFalse.trueIsFalse;


public class Task01 {
    // 게임 종료 상수 선언
    static final String EXIT = "e";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        emoji emo = new emoji();

        // 하트 갯 수별 이모지 배열
        String[] heartArr = { emo.heart0, emo.heart1, emo.heart2, emo.heart3};
        // while문 반복
        boolean flag = true;
        // 생명 개수
        int heart = 3;
        // 스테이지 이동시 필요한 연속 정답 횟수
        int trueCnt = 0;
        // 총 문제 정답 횟수
        int totCnt = 0;
        // 게임 룰 북 및 스타트 출력
        rollBook.roll();
        // enter 입력확인
        in.nextLine();

        // 게임 시작
        while (flag) {

            // 정답 횟수에 따른 스테이지 별 문제 출제
            String outPuts = stage.whatStage(trueCnt);
            System.out.println("똑같이 입력하세요 [ 대/소문자 관계없음 ] : " + outPuts);
            System.out.print("User 입력 : ");
            String tmp = in.nextLine();

            if (trueIsFalse(outPuts, tmp)) {
                trueCnt++;
                totCnt++;
                if (trueCnt == 3 || trueCnt == 7) {
                    System.out.println(emo.stUP);
                    System.out.println(heartArr[heart - 1]);
                }
            } else {
                trueCnt = 0;
                if (heart > 0) {
                    heart--;
                    System.out.println(heartArr[heart]);
                } else if (heart <= 0 && !(tmp.equals(EXIT))) {
                    System.out.println(emo.gmOVER);
                    System.out.print(" 게임 종료 Y / 재 시작 N : ");
                    flag = trueAndFalse.isReGame(in.next(), totCnt, trueCnt);
                    in.nextLine();
                    totCnt = 0;
                    trueCnt = 0;
                    heart = 3;
                }
                // tmp 입력된 문자열이 게임 종료를 희망하는 e 인지 아닌지 확인
                if (tmp.equals(EXIT)) {
                    System.out.println(emo.gmExit);
                    System.out.println("총 정답 개수 : " + totCnt + "\n최종 스테이지 : " + stage.whatStageNum(trueCnt));
                    flag = false;
                }
            }
        }
    }
}




