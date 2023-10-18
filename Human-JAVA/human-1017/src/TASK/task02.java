package TASK;

public class task02 {
    public static void main(String[] args) {
        int[][] tempArr = {
                            { 1, 1, 0},
                            { 0, 1, 0},
                            { 0, 1, 1}};
        int[][] nowBlock = new int[3][3];

//         오른쪽 회전
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) nowBlock[j][2] = tempArr[i][j];
                if (i == 1) nowBlock[j][i] = tempArr[i][j];
                if (i == 2) nowBlock[j][0] = tempArr[i][j];

            }
        }


        // 왼쪽 회전
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if ( j == 0) nowBlock[2][i] = tempArr[i][j];
//                if ( j == 1) nowBlock[1][i] = tempArr[i][j];
//                if ( j == 2) nowBlock[0][i] = tempArr[i][j];
//            }
//        }



        // 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nowBlock[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
