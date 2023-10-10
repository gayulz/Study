package TASK;

public class task03 {
    public static void main(String[] args) {
        for (int i = 1; i <=4 ; i++) {
//            for (int j = 1; j+i <= 4; j++) {
//                System.out.print(" 0 ");
//            }
//            for (int j = 1; j < 5-i; j++) {
//                System.out.print(" 0 ");
//            }
//            for (int j = 4-i ; j < i+3; j++) {
//                    System.out.print(" * ");
//            }
            for (int j = 1; j < 4+i ; j++) {
                if ( j <= 4-i ){
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println(" ");
        }
    }
}
