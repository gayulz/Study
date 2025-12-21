package Study;

public class Study03 {
    public static void main(String[] args) {
        String ttt ="aabbccaaaaddbbaaaaa";
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < ttt.length(); i++) {
            if (ttt.charAt(i) == 'a') {
                cnt++;
                if (cnt > max){
                    max = cnt;
                }
            }
            else {
                cnt = 0;
            }
            System.out.print(cnt + " ");
        }
        System.out.println("\n가장 긴 터널은 갯수 : " + max);
    }
}
