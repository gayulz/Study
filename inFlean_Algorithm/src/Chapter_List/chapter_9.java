package Chapter_List;

import java.util.Scanner;

public class chapter_9 {

    public String solution(String str) {
        String answer = str.replaceAll("^[]","")
        return answer;
    }
    public static void main(String[] args) {
        chapter_9 T = new chapter_9();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
