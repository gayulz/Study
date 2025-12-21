package Study;

import java.sql.SQLOutput;

public class study01 {
    public static void main(String[] args) {
        System.out.println(" 구구단 출력 ");
        for (int i = 0; i < 10; i++) {
            System.out.println("[" + i + "단]");
            for (int j = 0; j < 10; j++) {
                System.out.print( i + " x " + j + " = " + i * j + "\t");
            }
            System.out.println(" ");
        }

        // 복습
        System.out.println("----------------------------------------------------------");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 3 ; j++) {
                System.out.print( i + " * " + j + " = " + i*j + "\t");
            }
            System.out.println(" ");
        }
    }
}