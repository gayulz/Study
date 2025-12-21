package Study;

import sun.font.FontRunIterator;

public class Study06 {
    public static void main(String[] args) {

        String k = "37423210234";
        String kk = "";
        char[] tmp = k.toCharArray();

        for (int i = 0; i < tmp.length; i++) {
            char kTmp = tmp[i];
            if(kTmp == '0' ){
                break;
            } else if (kTmp == '4' ){
                continue;
            }
            kk = kk+kTmp;
        }
        System.out.println(kk);
    }
}
