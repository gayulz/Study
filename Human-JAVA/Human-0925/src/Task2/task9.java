package Task2;

public class task9 {
    public static void main(String[] args) {
        int[] arr1 = { 1,2,3,0,0,0,1,2,3,4,2,2,2,2,2,0,0,0,0,0,3,3 };
        int[] arr2 = { 1,1,1,1,2,3,1,1,1,1,1,2,3,4,5,1,2,3,4,5,1,1 };

        int nowNum = arr1[0];
        int cnt = 0;
        int tagetNum = 0;
        int max = 0;
        int indx = 0;

        for (int i = 0; i < arr1.length; i++) {
            if( arr1[i] == nowNum ){
                cnt++;
            } else {
                nowNum = arr1[i];
                cnt = 1;
            }
            if ( max < cnt ){
                max = cnt;
                tagetNum = arr1[i];
                indx = i;
            }
        }
        System.out.println("가장 긴 터널의 숫자 : " + tagetNum + " | 크기 : " +  max  );
        System.out.println("arr1 의 위치 : " + indx + " arr1의 위치값을 2에 적용시 출력값 : " + arr2[indx]);
    }
}
