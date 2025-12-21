package TASK;

public class task05 {
    public static void main(String[] args) {
        int[][] arr = new int[5][6];
        int v = 1;
        for (int i = 0; i < 5; i++) {
            int cnt = 1;
            switch (i) {
                case 0:
                    for (int j = 0; j < 10; j++) {
                        if (v >= 7) {
                            arr[cnt][5] = v;
                            cnt++;
                            v++;
                        } else {
                            arr[i][j] = v;
                            v++;
                        }
                    }
                    break;
                case 1:
                    v = 18;
                    cnt = 0;
                    for (int j = 0; j < 7; j++) {
                        if (v >= 22) {
                            arr[cnt + i][4] = v;
                            cnt++;
                            v++;
                        } else {
                            arr[i][j] = v;
                            v++;
                        }
                    }
                    break;
                case 2:
                    v = 28;
                    for (int j = 1; j < 4; j++) {
                        arr[i][j] = v;
                        v++;
                    }
                    break;
                case 3:
                    v = 27;
                    for (int j = 1; j < 4; j++) {
                        arr[i][j] = v;
                        v--;
                    }
                    break;
                case 4:
                    cnt = 4;
                    v = 11;
                    for (int j = 0; j < 7; j++) {
                        if (cnt <= -1) {
                            arr[i - (cnt * -1)][0] = v;
                            v++;
                            cnt--;
                        } else {
                            arr[i][cnt] = v;
                            v++;
                            cnt--;
                        }
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
