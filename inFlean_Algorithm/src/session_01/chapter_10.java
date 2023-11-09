package session_01;
import java.util.Scanner;

public class chapter_10 {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p=1000;
        for (int i = str.length()-1; i >= 0 ; i--) {
            if (str.charAt(i) == t) p = 0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        chapter_10 T = new chapter_10();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char t = in.next().charAt(0);
        for (int x : T.solution(s,t)) System.out.print(x + " ");
    }
}
