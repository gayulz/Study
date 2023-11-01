package Chapter_List;

import java.util.Scanner;

public class chapter_11 {
    public void solution(String str) {
        int cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if ( i+1 < str.length() ){
                if ( str.charAt(i) == str.charAt(i+1)) cnt++;
                else if ( str.charAt(i) != str.charAt(i+1) && cnt > 1) {
                    System.out.print( str.charAt(i) + "" + cnt );
                    cnt = 1;
                } else if ( str.charAt(i) != str.charAt(i+1) && cnt < 2) System.out.print(str.charAt(i));
            } else if ( i+1 == str.length() ){
                if (str.charAt(i-1) == str.charAt(i)) System.out.print(str.charAt(i) +""+cnt);
                else System.out.print(str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        chapter_11 T = new chapter_11();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        T.solution(str);
    }
}
