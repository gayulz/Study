package Study;

public class study05 {
    public static void main(String[] args) {
        // 응용
        // * ^ * ^ * ^
        // * ^ * ^ * ^
        // * ^ * ^ * ^
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if ( j % 2 == 0 ) System.out.print(" * ");
                else System.out.print(" ^ ");
            }
            System.out.println(" ");
        }
    }
}
