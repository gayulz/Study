package session_02;

import java.util.Scanner;

public class Chapter_01 {
    public String solution(int idx, String number) {
        String answer = "";
        int[] intTmp = new int[idx];
        int cnt = 0;
        for (int i = 0; i < number.length() - 1; i += 2) {
            intTmp[cnt] = Integer.parseInt(number.substring(i, i + 2).replace(" ", ""));
            System.out.println(intTmp[cnt]);
            cnt++;
        }
        for (int i = 0; i < intTmp.length; i++) {
            if ( i == 0 ) answer+=String.valueOf(intTmp[i] + " ");
            else{
                if ( intTmp[i] > intTmp[i-1] ) answer+=String.valueOf(intTmp[i] + " ");
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Chapter_01 T = new Chapter_01();
        Scanner in = new Scanner(System.in);
        int idx = in.nextInt();
        in.nextLine();
        String inNumStr = in.nextLine();
    }
}
