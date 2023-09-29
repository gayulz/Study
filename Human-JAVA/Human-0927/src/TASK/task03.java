package TASK;

public class task03 {
    public static void main(String[] args) {

//        문제 3
//        철수는 배열의 0번 인덱스에 가장 큰 값을 저장하면 될 것이라고 생각한다.
//        0번 인덱스가 가장 큰 값이라고 정의하고 1번부터 마지막까지 순회하면서
//        가장 큰 값이 나오면 가장 큰 값을 갱신한다.
//        위와 같은 방식으로 가장 큰 수를 구하시오.

        int[] arr = { 10, 2, 4, 7, 11, 4, 12};
        for (int i = 0; i < arr.length; i++) {
            int tmp = 0;
            if ( arr[0] < arr[i] ){
                tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
            }
        }

        System.out.println("배열 중 가장 큰 값 : " + arr[0]);
        System.out.println("배열의 인덱스별 값 ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("인덱스"+ i + " : " + arr[i] + "\n");
        }
    }
}
