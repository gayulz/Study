package session_01;
import java.util.Scanner;

public class chapter_7 {
    public String solution(String str){
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) answer = "YES";
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i)!=str.charAt(len-i-1)) return "NO";
//        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        chapter_7 T = new chapter_7();
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
