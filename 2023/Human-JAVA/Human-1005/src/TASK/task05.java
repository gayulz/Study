package TASK;

public class task05 {
    public static void main(String[] args) {
        int[] a = {34, 55, 23, 56, 34, 45, 34};
        int cnt = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int tmp = 40;
            if (tmp < a[i]) {
                cnt++;
            }
        }

        System.out.println(" 40 보다 큰 수 개수 : " + cnt);
    }
}
