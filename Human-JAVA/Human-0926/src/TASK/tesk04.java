package TASK;

public class tesk04 {
    public static void main(String[] args) {
        /*
        문제 : 비밀편지
        String word ="gehoudfkimjnlvy";
        int[] letter={8,12,3,13,1,14,3,4};
        letter  배열은 word문자열 알파벳의 위치이다.
        letter배열의 암호를 풀어서 편지의 내용을 출력하시오.
        */

        // 선언문
        String word ="gehoudfkimjnlvy";
        char[] wordI = new char[word.length()];
        int[] letter={8,12,3,13,1,14,3,4};

        // 암호 해석 실행문
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            wordI[i] = tmp;
        }
        for (int i = 0; i < letter.length; i++) {
            int pick = letter[i];
            if (pick < wordI.length) {
                System.out.print(wordI[pick]);
            }
        }
    }
}
