package TASK;

public class task03 {
    public static void main(String[] args) {
        int[][] arr = new int[4][5];

        for (int i = 0 , v = 26; i < 4; i++, v++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = v;
                v = v-4;
            }
            v+=20;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
