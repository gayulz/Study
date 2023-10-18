package TASK;

public class task02 {
    public static void main(String[] args) {
        int[][] arr = new int[2][5];

        for (int i = 0 , v = 14; i < 2; i++) {
            for (int j = 0; j < 5 ; j++) {
                arr[i][j] = v;
                v--;
            }
            v += 10;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
