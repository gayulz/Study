package Study_0921;

public class TEST02 {
    public static void main(String[] args) {
        // 1부터 10까지 숫자 중 짝수만 합 하시오


        int sum = 0;
        for (int i = 2; i <=10; i+=2){
            sum+=i;
//            System.out.print("i의 값 : " + i + "\nsum의 합산 값 : " + sum + "\n");
//            System.out.println("----------------");
        }
        System.out.println("결과 : " + sum);



        sum = 0;

        for (int i = 0; i <= 10; i++) {
            sum = i%2==0 ? sum+=i : sum;
//            System.out.println("i의 값 : "+ i);
//            System.out.println("sum의 값 : "+ sum);
//            System.out.println("---------------------------");
        }

        System.out.println("결과 : " + sum);
    }
}
