package TASK;

public class task04 {
    public static void main(String[] args) {
        int[][] arr = new int[5][6];
        int v = 1 , vv = 21;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if ( i == 0 && j == 0 ) arr[0][0] = v;
                if ( i == 0 && j > 0 ) {
                    v+=j;
                    arr[i][j] = v;
                }
                if ( i > 0 ) {
                    if ( j+1 == 6 ) break;
                    else arr[i][j] = arr[i-1][j+1] + 1;
                }
            }
        }
        for (int i = 1; i < 5 ; i++) {
            int x = i;
            int y = 5;
            for (int j = 0; j <= 5-i ; j++) {
                if ( x+1 > 5 || y-1 < 0) break;
                else {
                    arr[x][y] = vv;
                    x++;
                    y--;
                    vv++;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


