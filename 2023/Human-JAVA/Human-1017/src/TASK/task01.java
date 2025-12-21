package TASK;

public class task01 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30}};

        int[][] aa = new int[5][6];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            switch (i){
                case 0 :   // i = 0
                    for (int j = 0; j < 6; j++) {
                        if (j == 0 ) aa[i][j] = a[i + 1][j];
                        if (j + 1 <= 5) aa[i][j+1] = a[i][j];
                        else break;
                    }
                    for (int j = 5; cnt+1 <=4;cnt++) {
                        aa[cnt+1][j] = a[cnt][j];
                    }
                    cnt=0;
                    break;
                case 1 : // i = 1
                    for (int j = 0; j < 4; j++) {
                        if ( j == 0 ) aa[i][j] = a[i+1][j];
                        else if ( j == 1 ) aa[i][j] = a[i+1][j];
                        aa[i][j+1] = a[i][j];
                    }
                    for (int j = 4; cnt+1<=4;cnt++) {
                        aa[cnt+1][j] = a[cnt][j];
                    }
                    cnt=0;
                    break;
                case 2 : // i = 2
                    for (int j = 0; j < 4; j++) {
                        if (j < 2) aa[i][j] = a[i+1][j];
                        else if ( j < 3 ) aa[i][j+1] = a[i][j];
                        else aa[i][j-1] = a[i][j];
                    }
                    break;
                case 3 : // i = 3
                    for (int j = 2; j < 5; j++) {
                        aa[i][j-1] = a[i][j];
                    }
                    break;
                case 4 :
                    for (int j = 5; j >= 0 ; j--) {
                        if ( j > 0) aa[i][j-1] = a[i][j];
                        else aa[i-1][j] = a[i][j];
                    }
                    break;

            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(aa[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
