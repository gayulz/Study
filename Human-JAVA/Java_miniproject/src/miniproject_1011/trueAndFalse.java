package miniproject_1011;

import java.awt.*;
import java.util.Scanner;

public class trueAndFalse {
        // 문자열 같은지 판단하는 메서드
        public static boolean trueIsFalse(String str1, String str2) {
            //str1 : 문제 , str2 : User입력문자
            boolean result = true;
            String str1lower = str1.toLowerCase();
            String str2lower = str2.toLowerCase();
            result = str1lower.equals(str2lower);

            if (result == true){
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println("\t\t\t\t정답입니다.");
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");

            }
            else if (result == false) {
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println("\t\t\t\t오답 입니다");
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");

            }
            return result;
        }

        public static Boolean isReGame (String str, int totCnt, int trueCnt){
            boolean answer = true;
            Scanner in = new Scanner(System.in);
            String isStr = str.toUpperCase();
            emoji Emo = new emoji();
            String y = "Y";
            String n = "N";

            if (isStr.equals(y)) {
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println("\t\t\t총 정답 개수 : " + totCnt + "\n\t\t\t최종 스테이지 : " + stage.whatStageNum(trueCnt));
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println(Emo.bye);
                answer = false;
            } else if (isStr.equals(n)) {
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println("\t\t\t총 정답 개수 : " + totCnt + "\n\t\t\t최종 스테이지 : " + stage.whatStageNum(trueCnt));
                System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
                System.out.println(Emo.gmStart);
                answer = true;
            }
            return  answer;

        }

    }

