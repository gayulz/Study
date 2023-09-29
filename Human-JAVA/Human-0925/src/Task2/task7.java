package Task2;

public class task7 {
    public static void main(String[] args) {
        // 문제 7 :  int[] arr = {1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,0,0}
        //   0은 터널이다. 가장 긴 터널의 길이를 구하시오.

        // 선언부
        int[] arr = {1,2,3,0,0,0,1,2,3,4,5,2,2,2,2,0,0,0,0,0,0,0};
        int tmp = 0;
        int cnt = 0;

        // 출력부
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if ( cnt > tmp ) {
                tmp = cnt;
            }
        }
        System.out.println("가장 긴 터널의 길이 : " + tmp);
    }
}
