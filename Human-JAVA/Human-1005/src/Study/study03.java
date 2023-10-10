package Study;

public class study03 {
    public static void main(String[] args) {
        // 별 찍기
        // *
        // * *
        // * * *
        // * * * *

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }
}
