package TASK;

public class task04 {
    public static void main(String[] args) {
        int[][] arr = new int[4][5];

        for (int i = 0 , v = 10; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if ( i % 2 == 0){
                    arr[i][j] = v;
                    v++;
                } else {
                    v--;
                    arr[i][j] = v;
                }
            }
            v = v+5;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
