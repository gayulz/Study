package Task2;

public class task1 {
    public static void main(String[] args) {
        // 문제 1 : 10길이 배열을 만들고 첫번쩨 인덱스부터 0~9까지 값을 채워라. 그리고 출력하라

        // 선언부
        int[] arr = new int[10];

        // 입력부
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            System.out.println("인덱스" + i + "번째 값 : " + arr[i]);
        }
    }
}
