package Study_0921;

public class TEST01 {
    public static void main(String[] args) {
        /*1부터 10까지 숫자를 합한 값을 출력하시오*/

        int sum = 0;
        for (int i = 1; i <=10 ; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
        System.out.println("\n-----------------------------");
        System.out.println("결과 : " + sum);
    }
}
