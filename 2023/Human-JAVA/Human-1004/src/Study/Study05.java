package Study;

public class Study05 {
    public static void main(String[] args) {
        // 범인찾기
        // 배열의 값을 0번 인덱스 부터 합한다.
        // 합을 110 넘어가게 하는 숫자(값)이 범인이다

        int[] a = { 35, 45, 37, 29, 38, 4};
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum >= 110 ){
                System.out.println(i + "번째 인덱스가 범인이다");
                System.out.println("범인의 숫자 : " + a[i]);
                break;
            }
            sum+=a[i];
        }

        System.out.println("합계 : " + sum);
    }
}
