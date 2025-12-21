package TASK;

public class task03 {
    public static void main(String[] args) {
        int[] arr={3,45,26,50,74};
        int a = 5;

        for (int i = 0; i < arr.length; i++) {
            double tmp = (double)arr[i]/a;
            if ( tmp == (int)tmp ){
                System.out.println(" a 로 나누었을때 떨어지는 배열의 값 : " + arr[i]);
            }
        }
    }
}
