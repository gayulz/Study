package Task2;

public class task8 {
    public static void main(String[] args) {
        // 문제 8 :  int[] arr = {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,0,0,0,0,0,3,3}
        //   숫자는 터널의 번호이다. 터널의 길이가 가장 긴 숫자와 길이를 출력하시오.

        // 선언부
        int[] arr = {1, 2, 3, 0, 0, 0, 0, 0, 1, 2, 2, 4, 2, 2, 2, 2, 2, 0, 0, 0, 0, 3, 3};
        int nowNum = arr[0];
        int longNum = arr[0];
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == nowNum ){
                cnt++;
            } else {
                nowNum = arr[i];
                cnt = 1;
            }
            if(max < cnt ){
                max = cnt;
                longNum = nowNum;
            }
        }
        System.out.println("가장 긴 숫자 : " + longNum);
        System.out.println("가장 긴 숫자의 크기 : " + max);
    }
}