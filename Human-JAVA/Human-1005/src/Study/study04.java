package Study;

public class study04 {
    public static void main(String[] args) {
        // 별 찍기
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }
}
