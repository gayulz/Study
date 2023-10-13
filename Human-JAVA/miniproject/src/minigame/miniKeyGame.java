package minigame;

import java.util.Scanner;

import static minigame.TrueAndFalse.trueIsFalse;

public class miniKeyGame {
    // 호출 생성자
    public miniKeyGame(String enter) {
        miniKeyGame();
    }

    // 초기 생명 개수 선언
    int heart = 3;
    // 연속 정답 확인을 위한 변수
    int trueCnt = 0;
    // 오답노트에 입력될 배열 처리 cnt
    int falseCnt = 0;
    // 총 정답 개수
    int totCnt = 0;
    // 스테이지 처리를 위한 변수
    int stageNum = 1;
    boolean flag = true;

    public void miniKeyGame() {
        Scanner in = new Scanner(System.in);
        Emoji Emo = new Emoji();
        TrueAndFalse tnf = new TrueAndFalse();
        String[] heartArr = {Emo.heart0, Emo.heart1, Emo.heart2, Emo.heart3};

        // 게임 시작을 알리는 하트이모지 출력
        StrPlot.Strplot(heartArr[heart]);

        while (flag) {
            String outPuts = Stage.whatStage(stageNum);
            System.out.println(" 문제 [ 대/소문자 관계없음 ] : " + outPuts);
            System.out.print("User 입력 >>  ");
            String tmp = in.nextLine().toLowerCase();


            // 강제종료 희망하는지 User 입력값 확인 : '참'일 경우 종료 문구 출력 및 종료
            if (!choice.endChoice(tmp, totCnt, stageNum)) break;


            // 정답일 경우
            if (trueIsFalse(outPuts, tmp)) {
                trueCnt++;
                totCnt++;
                if (trueCnt == 3) {
                    StrPlot.Strplot(Emo.stUP);
                    StrPlot.Strplot(heartArr[heart]);
                    trueCnt = 0;
                    stageNum++;
                }
            }
            // 오답일 경우
            else {
                trueCnt = 0;
                stageNum = 1;
                falseCnt++;
                // 오답노트에 넣기
                tnf.inPutWrong(outPuts, falseCnt);
                if (heart > 1) {
                    heart--;
                    StrPlot.Strplot(heartArr[heart]);
                } else if (heart <= 1) {
                    StrPlot.Strplot(Emo.gmOVER);
                    System.out.print(" 게임 종료 Y / 오답 노트 확인 후 재시작 N : ");
                    flag = choice.isReGame(in.next().toUpperCase(), totCnt, stageNum);
                    in.nextLine();
                    stageNum = 1;
                    totCnt = 0;
                    trueCnt = 0;
                    falseCnt = 0;
                    heart = 3;
                }
            }
        }
    }
}
