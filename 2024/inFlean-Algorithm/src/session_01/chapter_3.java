package session_01;
import java.util.Scanner;
public class chapter_3 {
    public String solution(String str) {
        String answer = "";
        String[] strArray = str.split(" ");

        for (String string : strArray) {
            if (answer.length() <= string.length()) {
                answer = string;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        chapter_3 T = new chapter_3();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(T.solution(str));
    }
}
