package TASK;

public class task04 {
    public static void main(String[] args) {
        // int[] aaa = {10, 20, 5, 3, 25};
        // aaa.length 는 배열의 길이
        // 문제 : aaa의 배열의 모든 값의 합을 구하시오

        int[] aaa = {10,20,5,3,25};
        int tot = 0;
        for (int i = 0; i < aaa.length; i++) {
            tot += aaa[i];
        }
        System.out.println(tot);
    }
}
