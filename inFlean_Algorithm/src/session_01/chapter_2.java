package session_01;
import java.util.*;

public class chapter_2{
    public String solution(String str){
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            char input2 = str.charAt(i);
            if(input2 >= 65 && input2 <= 90){
                input2+=32;
                System.out.print(input2);
            }
            else if (input2 >= 97 && input2 <= 122){
                input2-=32;
                System.out.print(input2);
            }
//        for (char x : str.toCharArray()) {
//            if (Character.isLowerCase(x)) {
//                answer += Character.toUpperCase(x);
//            } else {
//                answer += Character.toLowerCase(x);
//            }
        }
        return answer;
    }
    public static void main(String[] args) {
        chapter_2 T = new chapter_2();
//        Scanner kb = new Scanner(System.in);
//
//        String input1 = kb.next();
//
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        System.out.println(T.solution(input1));

    }
}

