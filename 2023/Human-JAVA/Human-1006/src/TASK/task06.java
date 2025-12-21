package TASK;

public class task06 {
    public static void main(String[] args) {
        int tot = 0;
        for (int i = 1; i < 10000 ; i++) {
            int tmp = i;
            for(;tmp>0;) {
                tot += tmp % 10;
                tmp /= 10;
            }
        }
        System.out.println("1 ~ 9999 까지 각 자리수 합산 : " + tot);
    }
}
