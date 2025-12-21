package Today_Task;

public class Task04 {
    public static void main(String[] args) {
        // 문제 4 : 범인 숫자 구하기
        //         범인은 100부터 999까지 숫자중에 여러명이다
        //         범인의 특징은 숫자의 각자리수에 더한 값이 짝수이다.
        //         범인의 숫자를 모두 찾으시오

        for (int i = 100; i <1000 ; i++) {
            int n1 = i%10;
            int n10 = (i/10)%10;
            int n100 = (i/10)/10;
            if ((n1+n10+n100)%2==0){
                System.out.println(i);
            }
        }
    }
}
