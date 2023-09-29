package Task2;

public class task10 {
    public static void main(String[] args) {
        /*
         문제 9 :  int[] arr = {1,2,3,0,0,0,1,2,2,4,2,2,2,2,2,0,0,0,0,0,3,3}
                  숫자는 터널의 번호이다. 터널의 길이가 가장 긴 숫자와 길이를 출력하시오.
                  만약, 터널의 길이가 가장 긴 터널의 길이와 같은 것이 있다면 그 터널의 번호도 출력하시오.
        */
        // 선언부
        //            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
        int[] arr = {1, 2, 3, 3, 3, 0, 0, 0, 1, 2, 2, 4, 4, 4, 2, 2, 2, 0, 0, 3, 3, 3, 3};
        int nowN = arr[0];
        int cnt = 0;
        int max = 0;
        int longN = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == nowN){
                cnt++;
            } else {
                nowN = arr[i];
                cnt = 1;
            }
            if( max < cnt ) {
                max = cnt;
                longN = nowN;
                System.out.println(longN + " " + max);
            }
        }
    }
}