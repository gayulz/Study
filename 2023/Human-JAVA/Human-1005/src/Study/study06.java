package Study;

public class study06 {
    public static void main(String[] args) {
        // 응용2
        // * * * * *
        // ^ ^ ^ ^ ^
        // * * * * *
        // ^ ^ ^ ^ ^

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if ( i % 2 == 0 ){
                    System.out.print(" * ");
                } else {
                    System.out.print(" ^ ");
                }
            }
            System.out.println(" ");
        }
    }
}
