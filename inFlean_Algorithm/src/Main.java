import java.util.Scanner;

public class Main {
//    public String solution(String speStr, int size){
//        String answer = "";
//        for (int i = 0; i < size; i++) {
//            String tmp = speStr.substring(0,7).replace('#', '1').replace('*', '0');
//            int num=Integer.parseInt(tmp, 2);
//            // Integer.parseInt(tmp, 2) 하면 2진수를 아스키코드 번호로 바꿔준다....
//            answer+=(char)num;
//            speStr = speStr.substring(7);
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        int[] intTmp = { 3, 2, 1, 3, 2, 1, 3 };
        String answer = "";
        for (int i = 0; i < intTmp.length; i++) {
            if ( i == 0 ) answer+=String.valueOf(intTmp[i] + " ");
            else{
                if ( intTmp[i] > intTmp[i-1] ) answer+=String.valueOf(intTmp[i] + " ");
            }
        }
        System.out.println(answer);

    }
}