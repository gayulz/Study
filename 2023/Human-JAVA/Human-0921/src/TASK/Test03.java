package TASK;

public class Test03 {
    public static void main(String[] args) {
        // 1부터 100까지 숫자 중 홀수는 모두 몇개인가?
        int cnt = 0;

        for (int i = 1; i <=100 ; i++) {
            if (i%2==1){
                cnt++;
            }
        }
        System.out.println("홀수의 갯 수 : " + cnt);
    }
}
