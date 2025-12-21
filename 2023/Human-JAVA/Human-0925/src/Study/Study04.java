package Study;

public class Study04 {
    public static void main(String[] args) {
        String ttt = "aabbccaaaaddbbaaaaa";
        int cnt = 0;
        for (int i = 0; i <= ttt.length(); i++) {
            char tmp = ttt.charAt(i);
            int lt = 0;
            if (tmp == ttt.charAt(i+1)){
                lt+= 2+i;
                cnt+=2;
            } else {
                lt+= 1+i;
                cnt+=1;
            }
            System.out.println(tmp + " " + cnt);
        }
    }
}
