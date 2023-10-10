package TASK;

import static java.lang.Math.abs;

public class task09 {
    public static void main(String[] args) {
        for (int i = 1; i <=4 ; i++) {
            for (int j = 1; j < 3+i ; j++) {
                if ( j <= 5-i ){
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println(" ");
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" 0 ");
            }
            for (int j = 1; j <= (4*2-1) - (i * 2); j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }
}

