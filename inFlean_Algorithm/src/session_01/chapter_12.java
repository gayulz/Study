package session_01;

import java.util.Scanner;

public class chapter_12 {
    public String solution(String speStr, int size){
        String answer = "";
        for (int i = 0; i < size; i++) {
            String tmp = speStr.substring(0,7).replace('#', '1').replace('*', '0');
            int num=Integer.parseInt(tmp, 2);
            // Integer.parseInt(tmp, 2) 하면 2진수를 아스키코드 번호로 바꿔준다....
            answer+=(char)num;
            speStr = speStr.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) {
        chapter_12 T = new chapter_12();
        Scanner in = new Scanner(System.in);
        int indexNum = in.nextInt();
        in.nextLine();
        String speStr = in.nextLine();
        System.out.println(T.solution(speStr, indexNum));
    }
}

