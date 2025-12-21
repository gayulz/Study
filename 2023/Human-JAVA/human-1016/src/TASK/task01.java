package TASK;

public class task01 {
    public static void main(String[] args) {
         int[][] arr = new int[5][6];

        for (int i = 0 , v = 6; i <5; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = v;
                v--;
            }
            v+=12;
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + "\t");
            }
        System.out.println(" ");
        }
    }
}
