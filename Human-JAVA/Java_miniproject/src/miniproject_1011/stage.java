package miniproject_1011;

import java.util.Random;

public class stage {
    public static String whatStage(int stagenum) {
        String returnStr = "";
        Random r = new Random();
        // 단계별 단어
        String[] stage1 = {"sound", "score", "baseball", "father", "mother", "doctor", "singer", "student", "people", "apple"};
        String[] stage2 = {"lighthearted", "reassuringly", "consequently", "incompatible", "overestimate", "productivity", "notwithstanding", "underachieve", "authenticity", "metamorphose", "frenetically", "deliberately"};
        String[] stage3 = {"I am no more humble than my talents require", "We did not change as we grew older we just became more clearly ourselves", "Prosperity makes friends, adversity tries them", "Adversity does teach who your real friends are", "Isn't it great when friends visit from afar", "Rather be dead than cool", "Pride sullies the noblest character", "The less their ability, the more their conceit"};

        if (stagenum <= 3) returnStr = stage1[r.nextInt(stage1.length - 1)];
        else if (stagenum > 3 && stagenum < 7) returnStr = stage2[r.nextInt(stage2.length - 1)];
        else if (stagenum >= 7) returnStr = stage3[r.nextInt(stage3.length - 1)];

        return returnStr;
    }

    public static String whatStageNum(int trueCnt){
        String returnStr = "";
        if (trueCnt <= 3) returnStr = "Stage1";
        else if (trueCnt > 3 && trueCnt < 7) returnStr = "Stage2";
        else if (trueCnt >= 7) returnStr = "Stage3";
        return returnStr;
    }

}

