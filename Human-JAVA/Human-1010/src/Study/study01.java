package Study;

import java.util.Random;

public class study01 {
    public static void main(String[] args) {
        Random r = new Random();
        String name = "abcdefaagaaggefagaga";
        int aCnt = 0;
        for (int i = 1; i < name.length() ; i++) {
            char a = name.charAt(i);
            if (a=='a'){
                aCnt++;
            }
        }

        System.out.println(aCnt);
    }
}

