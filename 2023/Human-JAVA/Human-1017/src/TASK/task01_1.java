package TASK;

public class task01_1 {
    public static void main(String[] args) {
//        int[][] a = {{1, 2, 3, 4, 5, 6},
//                {7, 8, 9, 10, 11, 12},
//                {13, 14, 15, 16, 17, 18},
//                {19, 20, 21, 22, 23, 24},
//                {25, 26, 27, 28, 29, 30}};

        int [][] a = new int[5][6];
        int cnt = 0;

        for ( int i = 0; i<3; i++ ) {
            for ( int j = 1+i; j<6-i; j++ ) { // Case1 직선부분
                cnt++;
                a[i][j] = cnt;
                a[4-i][5-j] = 31-cnt; // (4,5) 평행이동후 원점대칭
            }
            for ( int j = 5-i; j<6 && i<=1; j++ ) { // Case2 직선부분끝쪽에서 행이 1씩증가하는부븐 ( 오른쪽 )
                cnt++;
                a[i+1][j] = cnt;
                a[3-i][5-j] = 31-cnt; // (4,5) 평행이동후 원점대칭
            }
            for ( int j = 5; j<6+i && i<=1; j++) { // Case3 직선부분끝쪽에서 행이 1씩증가하는부분 ( 왼쪽 )
                cnt++;
                a[i][j-5] = cnt;
                a[4-i][10-j] = 31-cnt; // (4,5) 평행이동후 원점대칭
            }

        }

        for ( int i = 0; i<5; i++ ) {
            for ( int j = 0; j<6; j++ ) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
