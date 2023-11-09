package session_01;

import java.util.Scanner;

public class chapter_9 {

    public int solution(String str) {
        int answer = 0;
        for ( char x:str.toCharArray()) {
            if (x >= 48 && x <= 57) answer=answer*10+(x-48);
        }
//        String tmpStr = str.replaceAll("[a-zA-Z]","");
//        int answer = Integer.parseInt(tmpStr);
//        System.out.println(answer);

        return answer;
    }
    public static void main(String[] args) {
        chapter_9 T = new chapter_9();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
