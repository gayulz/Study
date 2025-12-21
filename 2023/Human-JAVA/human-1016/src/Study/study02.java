package Study;

public class study02 {
    public static void main(String[] args) {

        int[][] a = new int[4][3];
        int cnt = 12;
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                a[i][j] = cnt;
//                cnt--;
//            }
//            cnt+=6;
//        }
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0 ; j--) {
                a[i][j] = cnt;
                cnt++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
