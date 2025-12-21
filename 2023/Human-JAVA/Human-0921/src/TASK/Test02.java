package TASK;

public class Test02 {
    public static void main(String[] args) {
        // 1부터 100까지 숫자 중 홀수는 홀수끼리 더한 값을 짝수는 짝수끼리 더한 값을 각각출력하시오.
        int evenNum = 0;
        int oddNum = 0;
        for (int i = 0; i <=100; i++) {
            if (i%2==0){
                evenNum += i;
            }
            else if (i%2==1){
                oddNum += i;
            }
        }
        System.out.println("짝수 값 : " + evenNum + "\n홀수 값 : " + oddNum);
    }
}
