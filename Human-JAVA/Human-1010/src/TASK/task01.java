package TASK;

import java.util.Arrays;

public class task01 {
    public static void main(String[] args) {
        int[] elevator = {4, 1, 1, 1, 8, 1, 1, 8, 4, 1, 3, 2, 1, 1, 1, 2, 3};
        int tot = 1;

        for (int i = 0; i < elevator.length; i++) {
            int cnt = 1;
            for (int j = i; j < elevator.length; j++) {
                if (elevator[j] == 1) {
                    cnt++;
                } else if (elevator[j] != 1) {
                    i += cnt;
                    break;
                }
            }
            if (cnt > 2) {
                i += cnt-1;
                tot += cnt;
            }
            System.out.println("cnt 값 : " + cnt);
        }
        System.out.println("1이 연속적인 길이 : " + tot);
    }
}
