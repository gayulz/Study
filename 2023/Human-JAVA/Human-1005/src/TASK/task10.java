package TASK;

import static java.lang.Math.abs;

public class task10 {
    public static void main(String[] args) {
        for (int i = 1; i <=7 ; i++) {
            int tmp = 4 - i;
            if (tmp < 0 ){
                tmp *= -1;
            }
            for (int j = 1; j <= (4-tmp)+3 ; j++) {
                if ( tmp < j) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }
}
