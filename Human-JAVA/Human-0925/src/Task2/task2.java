package Task2;

public class task2 {
    public static void main(String[] args) {
        //문제 2번 : int[] arr= {45,23,25,64,3,24,48};
        // 배열의 길이를 출력하시오
        // 배열에서 가장 큰 값의 위치와 값을 출력하세요

        // 선언부
        int[] arr= {45,23,25,64,3,24,48};
        int max = 0;     // 가장 큰 값 저장
        int point = 0;      // 큰 값의 위치 저장

        // 출력부
        System.out.println("arr의 배열 길이 : " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                point = i;
            }
        }
        System.out.println("배열 중 가장 큰 값 : " + max);
        System.out.println("배열 중 가장 큰 값 위치 : " + point);
    }
}
