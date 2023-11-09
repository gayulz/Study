package session_01;

import java.util.Scanner;

public class chapter_5 {
        public String solution(String str){
            String answer;
            char[] substr = str.toCharArray();
            int lt = 0 , rt = str.length()-1;
            while (lt < rt) {
                if (!Character.isAlphabetic(substr[lt])) lt++;
                else if (!Character.isAlphabetic(substr[rt])) rt--;
                else {
                    char tmp = substr[lt];
                    substr[lt] = substr[rt];
                    substr[rt] = tmp;
                    lt++;
                    rt--;
                }
            }
            answer = String.valueOf(substr);
            return  answer;
        }

        public static void main(String[] args) {
            chapter_5 T = new chapter_5();
            Scanner in = new Scanner(System.in);
            String str = in.next();
            System.out.println(T.solution(str));
        }
    }


