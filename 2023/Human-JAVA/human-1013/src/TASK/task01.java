package TASK;

public class task01 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        for (int i = 0 , v = 10; i < 4; i++, v++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = v;
                v+=4;
            }
            v -= 16;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
