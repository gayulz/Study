package minigame;
import static minigame.TrueAndFalse.outWrongNote;

public class choice {
    // 게임 종료 상수 선언
    static final String EXIT = "exit";

    public static Boolean endChoice(String s, int totCnt, int stageNum){
        Emoji Emo = new Emoji();
        boolean answer = true;
        if (s.equals(EXIT)) {
            StrPlot.Strplot(Emo.gmExit);
            System.out.println("\t\t\t✎ 총 정답 개수 : " + totCnt + "\n\t\t\t✎ 최종 스테이지 : " + Stage.whatStageNum(stageNum));
            answer = false;
        }
        return answer;
    }
    // 재시작 여부 판별 후 처리 메소드
    public static Boolean isReGame(String str, int totCnt, int stageNum) {
        boolean answer = true;
        Emoji Emo = new Emoji();
        String y = "Y";
        String n = "N";

        if (str.equals(y)) {
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            System.out.println("\t\t\t✎ 총 정답 개수 : " + totCnt + "\n\t\t\t✎ 최종 스테이지 : " + Stage.whatStageNum(stageNum));
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            StrPlot.Strplot(Emo.bye);
            answer = false;
        } else if (str.equals(n)) {
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            System.out.println("\t\t\t✎ 총 정답 개수 : " + totCnt + "\n\t\t\t✎ 최종 스테이지 : " + Stage.whatStageNum(stageNum));
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            outWrongNote();
            StrPlot.Strplot(Emo.gmStart);
        }
        return answer;
    }
}
