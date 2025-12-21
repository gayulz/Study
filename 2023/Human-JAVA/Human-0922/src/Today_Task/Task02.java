package Today_Task;

public class Task02 {
    public static void main(String[] args) {
        // 문제 2 : 1부터 100까지 숫자중에서 홀수의 총합을 구하시오
        int tot = 0;
        for (int i = 0; i <=100; i++) {
            if(i%2==1){
                tot+=i;
            }
        }
        System.out.println(tot);
    }
}
