package Chapter_List;

import java.util.Scanner;

public class chapter_6 {
    public String solution(int cnt, String str){
        String answer;
        char[] chars = str.toCharArray();   // char배열로 뽑을 그릇
        char[] chap = new char[cnt];        // 최종 담을 그릇
        int lt = 0;
        while ( lt > cnt ){
            if ( chars[lt] == lt ){
                chap[lt] = chars[lt];
                System.out.print( chap[lt] + " ");
            } else {
                ++lt;
                chap[lt] = chars[lt];
//                System.out.print( chap[i] + " ");
            }
        }
        answer = String.valueOf(chap);
        return answer;
    }

    public static void main(String[] args) {
        chapter_6 T = new chapter_6();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(T.solution(str.length(), str));
    }
}
