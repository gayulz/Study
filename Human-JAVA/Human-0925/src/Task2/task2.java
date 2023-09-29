package Task2;

public class task2 {
    public static void main(String[] args) {
        //문제 2번 : int[] arr= {45,23,25,64,3,24,48};
        // 배열의 길이를 출력하시오
        // 배열에서 가장 큰 값의 위치와 값을 출력하세요

        // 선언부
        int[] arr= {45,23,25,64,3,24,48};
        int point = 0;      // 큰 값의 위치 저장

        // 최고값 찾기
        System.out.println("arr의 배열 길이 : " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[point] < arr[i]) {
                point = i;
            }
        }

        // 최고값 출력
        System.out.println("배열 중 가장 큰 값 : " + arr[point]);
        System.out.println("배열 중 가장 큰 값 위치 : " + point);
    }
}
