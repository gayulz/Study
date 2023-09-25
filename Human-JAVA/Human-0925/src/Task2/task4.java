package Task2;

public class task4 {
    public static void main(String[] args) {
        // 문제 4 : 배열의 값을 모두 더한 총 합을 구하시오
        // 선언부
        int[] arr = {45, 23, 25, 64, 3, 24, 48};
        int tot = 0;

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            tot += arr[i];
        }
        System.out.println("배열의 총 합 : " + tot);
    }
}
