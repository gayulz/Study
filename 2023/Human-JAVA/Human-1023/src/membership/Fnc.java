package membership;

public class Fnc {
    String sign = "!@#$%^&*";

    public int chkString(String word){
        // word에 특수문자가 몇개 포함되어있는지 체크한다
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < sign.length(); j++) {
                if (word.charAt(i) == sign.charAt(j)) cnt++;
            }
        }
        return cnt;
    }
}
