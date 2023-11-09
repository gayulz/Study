package session_01;
import java.util.Scanner;

public class chapter_8 {

    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        System.out.println(str);
        System.out.println(tmp);
        if (str.equals(tmp)) answer = "YES";
        return answer;
    }
//    found7, time: study; Yduts; emit, 7Dnuof
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        chapter_8 T = new chapter_8();
        System.out.println(T.solution(str));
    }
}
