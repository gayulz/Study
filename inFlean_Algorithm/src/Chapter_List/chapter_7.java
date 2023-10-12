package Chapter_List;

import java.util.Scanner;

public class chapter_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String tmpStr = str.toUpperCase();
        boolean flag = false;
        int rtPoint = tmpStr.length()-1;
        for (int i = 0; i < str.length(); i++) {
            char tmp = tmpStr.charAt(i);
            if ( i == tmpStr.length()/2 ){
                break;
            }
            if (tmp == tmpStr.charAt(rtPoint)){
                flag = true;
                rtPoint--;
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
