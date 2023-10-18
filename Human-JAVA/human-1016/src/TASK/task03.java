package TASK;

public class task03 {
    public static void main(String[] args) {
        char[][] arr = new char[5][6];
        char r = '*';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < j) arr[i][j] = '0';
                else arr[i][j] = r;
            }
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println("-----------------------------------");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] == '*') {
                    System.out.print(arr[i][j] + "\t");
                } else {
                    arr[i][j] = ' ';
                    System.out.print(arr[i][j] + "\t");
                }
            }
                System.out.println(" ");
        }
    }
}
