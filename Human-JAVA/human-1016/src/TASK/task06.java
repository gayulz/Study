package TASK;

public class task06 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2, 1, 3, 3},
                {1, 1, 2, 3, 3, 4},
                {5, 2, 2, 2, 3, 5},
                {2, 3, 4, 2, 5, 4},
                {1, 1, 5, 1, 5, 5}
        };


        int[][] newArr = new int[5][6];
        int rowP = 0, columP = 0, cnt = 1;

        for (int i = 4; i >= 0 ; i++) {
            for (int j = 0; j < 6; j++) {
                if ( j-1 >= 0) {
                    if (arr[i][j] == arr[i][j-1]) {
                        cnt++;
                    } else {
                        cnt = 1;
                    }
                    if (cnt == 3){
                        rowP = j;
                        columP = i;
                        for (int k = rowP-1; k < rowP+1; k++) {
                            if (arr[columP][rowP-1] == arr[columP][rowP] ) arr[columP][rowP] = 0;
                            if (arr[columP-1][rowP] == arr[columP][rowP] ) arr[columP][rowP] = 0;
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < 5; i++) {
//            int tmp = 0;
//            for (int j = 0; j < 6; j++) {
//                if (arr[i][j] == 0) continue;
//                else if (i - 1 < 0 || j - 1 < 0) continue;
//                else if (i + 1 >= 5 && j + 1 >= 6) break;
//                else if (arr[i][j] == arr[i][j - 1] && arr[i][j] == arr[i][j + 1]) {
//                    for (int k = i - 1; k >= 0; k--) {
//                        for (int l = j - 1; l <= j + 1; l++) {
//                            tmp = arr[k][l];
//                            arr[k + 1][l] = tmp;
//                        }
//                        tmp = 0;
//                    }
//                    for (int k = 0; k < 1; k++) {
//                        for (int l = 1; l < 4; l++) {
//                            arr[k][l] = 0;
//                        }
//                    }
//                    if (arr[i][j] == arr[i-1][j] )
//                }
//            }
//        }
//        for (int j = 0; j < 6; j++) {
//            int tmp = 0;
//            for (int i = 0; i < 5; i++) {
//                if (j-1 < 0) break;
//                if (i-1 >= 0 && i+1 <=4) {
//                    if (arr[i][j] == arr[i-1][j] && arr[i][j] == arr[i+1][j]) {
//
//                    }
//                }
//
////                System.out.print(arr[i][j] + " [i:"+i+" ||j:"+j+"]\t");
//            }
////            System.out.println();
//        }
//                        for (int k = i + 1; k >= i-1; k--) {
//                            tmp = arr[k][j];
//                            arr[k][j] = 0;
//                        }
//                        tmp = 0;
//        for (int i = 0, v = 1; i < 6; i++) {
//            for (int j = 0; j < 5; j++) {
//                arr[j][i] = v;
//                v++;
//            }
//        }
//        for (int i = 0; i < 6; i++) {
//            int tmp = 0;
//            for (int j = 0; j < 5; j++) {
//                if (arr[j][i] == 0) continue;
//                else if (j-1 < 0 || i-1 < 0) continue;
//                else if (j+1 >= 6 && i+1 >= 5) break;
//                else if (arr[j][i] == arr[j][i-1] && arr[j][i] == arr[j][i+1]) {
//                    for (int k = j; k >= 1; k--) {
//                        for (int l = 0; l < i + 1; l++) {
//                                tmp = arr[k - 1][l];
//                                arr[k][l] = tmp;
//                        }
//                        tmp = 0;
//                    }
//                }
//        for (int j = 0; j < 6; j++) {
//            for (int i = 0; i < 5; i++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }

        // 출력부
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}