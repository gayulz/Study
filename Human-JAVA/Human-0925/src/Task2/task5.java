package Task2;

public class task5 {
    public static void main(String[] args) {
        // 문제 5 : int[] arr = {45,23,25,64,3,24,48}
        //   배열에서 최대값과 최소값의 차이를 구하시오.

        // 선언부
        int[] arr = {45,23,25,64,3,24,48};
        int max = 0;
        int min = 0;

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            int tmp=0;
            if(arr[i] > max){
                max = arr[i];
            } else {
                tmp = min;
                max = tmp;
                min = arr[i];
            }
        }
        System.out.println("배열의 최대 값 : " + max);
        System.out.println("배열의 최소 값 : " + min);
        System.out.println("최대값과 최소값의 차이 : " + (max-min));
    }
}
