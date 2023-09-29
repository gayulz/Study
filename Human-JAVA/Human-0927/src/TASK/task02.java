package TASK;

public class task02 {
    public static void main(String[] args) {
//        int[] a = {34,2,35,8,31,45}
//        최대값을 구하는 문제에서
//        철수는 변수를 사용하지 않고 배열만 이용하여 푸는 방법을 생각하였다.
//        철수는 배열의 0번 인덱스부터 순회한다.
//        0번 인덱스에서는 0번인덱스와 그 다음 인덱스를 비교하여 큰 수를 뒤로 배치한다.
//        이러한 방식으로 배열의 뒤까지 반복하면 맨 뒤에 가장 큰 수가 배치 될 것이다.
//        위와 같은 방식으로 가장큰 수를 구하시오.

        // 선언부
        int[] a = {70,2,35,45,31,1};

        // 큰수 처리문
        for (int i = 0; i < a.length; i++) {
            int cnt = i+1;
            if (a[i] > a[cnt]){
                a[cnt] = a[i];
            } else {
                a[i] = a[cnt];
            }
            if(cnt == 5){
                break;
            }
        }
        // 출력문
        System.out.print("가장 큰 수는 마지막 인덱스에 있다 : " + a[a.length-1]);

    }
}
