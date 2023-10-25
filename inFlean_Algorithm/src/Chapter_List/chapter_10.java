package Chapter_List;

import java.util.Scanner;

public class chapter_10 {
    public void solution(String str, char t) {
        int cnt = 0;
        char[] tmpStr = str.toCharArray();
        int[] answer = new int[tmpStr.length];
        for (int i = 0; i < tmpStr.length; i++) {
            if (tmpStr[i] != t){
                cnt++;
                answer[i] = cnt;
            } else {
                cnt = 0;
                answer[i] = cnt;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
    public static void main(String[] args) {
        chapter_10 T = new chapter_10();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        char t = in.next().charAt(0);
        T.solution(str, t);
    }
}
