package session_01;

import java.util.Scanner;

public class chapter_6 {
    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)+ " / "+ i + " / " + str.indexOf(str.charAt(i)));
//            if(str.indexOf(str.charAt(i))==i) answer += str.charAt(i);
            // 가져온 글자를 indexOf 매개변수로 사용한다. 처음 나타난 글자와 i번째 글자와 같을 경우 answer에 문자열에 더한다
        }
        return answer;
    }


    public static void main(String[] args) {
        chapter_6 T = new chapter_6();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str));
    }
}
