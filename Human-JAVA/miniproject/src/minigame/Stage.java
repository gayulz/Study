package minigame;
import java.util.Random;

public class Stage {
    public static String whatStage(int stagenum) {
        String returnStr = "";
        Random r = new Random();
        // 단계별 단어
        String[] stage1 = {"sound", "score", "baseball", "father", "mother", "doctor", "singer", "student", "people", "apple","friend", "poverty", "union", "good", "book", "reader", "law", "promise", "example", "learn", "first", "smoke", "fire", "speak"};
        String[] stage2 = {"lighthearted", "reassuringly", "consequently", "incompatible", "overestimate", "productivity", "notwithstanding", "underachieve", "authenticity", "metamorphose", "frenetically", "deliberately", "language", "translators", "judges", "repentance", "character", "flattering", "quarrels", "misunderstanding", "dangerous", "masterpieces","happiness", "translators"};
        String[] stage3 = {"I am no more humble than my talents require", "We did not change as we grew older we just became more clearly ourselves", "Prosperity makes friends, adversity tries them", "Adversity does teach who your real friends are", "Isn't it great when friends visit from afar", "Rather be dead than cool", "Pride sullies the noblest character", "The less their ability, the more their conceit", "love sees no faults", "pride will have a fall", "patience is the art of hoping", "if you laugh blessings will come your way","slow and steady win the game", "the family is one of nature's masterpieces", "happiness lies first of all in health"};

        if (stagenum == 1) returnStr = stage1[r.nextInt(stage1.length - 1)];
        else if (stagenum == 2) returnStr = stage2[r.nextInt(stage2.length - 1)];
        else if (stagenum >= 3) returnStr = stage3[r.nextInt(stage3.length - 1)];
        return returnStr;
    }
    public static String whatStageNum(int stageNum){
        String returnStr = "";
        if (stageNum == 1) returnStr = "Stage1";
        else if (stageNum == 2) returnStr = "Stage2";
        else if (stageNum >= 3) returnStr = "Stage3";
        return returnStr;
    }
}
