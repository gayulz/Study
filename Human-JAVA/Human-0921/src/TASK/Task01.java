package TASK;

public class Task01 {
    public static void main(String[] args) {
        // 1부터 100까지 숫자 중 홀수는 더하고 짝수는 뺀 결과값을 출력하시오

        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i%2==0){
                sum-=i;
                System.out.print(i + " /" + sum + "\n");
            } else {
                sum+=i;
                System.out.print(i + " /"+ sum + "\n");
            }
        }
        System.out.println("결과 값 : " + sum);
    }
}
