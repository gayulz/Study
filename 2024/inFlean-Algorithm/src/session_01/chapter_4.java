package session_01;
import java.util.Arrays;
import java.util.Scanner;

public class chapter_4 {
    public String solution(String[] str){
        String answer = "";
        for (int i = 0; i < str.length; i++) {
            StringBuilder taskrevers = new StringBuilder(str[i]);
            String revers = taskrevers.reverse().toString();
            str[i] = revers;
        }
        Arrays.stream(str).forEach(System.out::println);
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        chapter_4 T = new chapter_4();
        int cnt = in.nextInt();
        String[] str = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            str[i] = in.next();
        }
        System.out.println(T.solution(str));
    }
}
