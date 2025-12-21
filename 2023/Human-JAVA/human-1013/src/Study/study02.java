package Study;

public class study02 {
    public static void main(String[] args) {
        int[][] arr = new int[4][5];
        int cnt = 10;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = cnt;
                cnt++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0 , v = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(v + "\t");
                v++;
            }
            System.out.println();
        }
    }
}
