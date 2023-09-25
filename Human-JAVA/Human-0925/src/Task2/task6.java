package Task2;

public class task6 {
    public static void main(String[] args) {
        // 문제 6 : int[] arr = {45,23,25,64,3,24,48}
        //   값이 짝수인 인덱스 와 값을 모두 출력하시오.

        // 선언부
        int[] arr = {45,23,25,64,3,24,48};

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0) {
                System.out.println(" 짝수인 값 인덱스 번호 : " + i);
                System.out.println(" 값 : " + arr[i]);
            }
        }

    }
}
