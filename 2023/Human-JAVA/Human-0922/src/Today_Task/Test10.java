package Today_Task;

public class Test10 {
    public static void main(String[] args) {
        // 문제 10 : a는 터널이다 가장 긴 터널의 길이를 구하시오
        String ttt ="aabbcccaaaaaaaraaddbbbaaas";
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < ttt.length(); i++) {
            char tt = ttt.charAt(i);
            int bin = 0;
            if (tt == 'a') {
                cnt++;
                if (cnt > max) {
                    //bin = cnt;
                    max = cnt;
                }
            } else {
                cnt=0;
            }
        }
        System.out.println(max);
    }
}
