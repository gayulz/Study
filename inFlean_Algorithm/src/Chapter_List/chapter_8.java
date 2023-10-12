package Chapter_List;
import java.util.Scanner;

public class chapter_8 {

    public String solution(String str) {
        String answer = str.toUpperCase();
        String newAnswer = answer.replaceAll("[^a-zA-Z$]", "");
        boolean flag = false;
        int rtPoint = newAnswer.length()-1;
        for (int i = 0; i < str.length(); i++) {
            char tmp = newAnswer .charAt(i);
            if ( i == newAnswer.length()/2 ){
                break;
            }
            if (tmp == newAnswer.charAt(rtPoint)){
                flag = true;
                rtPoint--;
            } else {
                flag = false;
                break;
            }
        }
        if ( flag == false ) answer = "NO";
        else if ( flag == true ) answer = "YES";
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
