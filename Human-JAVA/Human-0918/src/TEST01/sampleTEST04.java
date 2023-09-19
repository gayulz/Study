package TEST01;

public class sampleTEST04 {
    public static void main(String[] args) {
        // 문제 4
        // int addNumber = 56;
        // 홀수이면 현재값에서 + 30 , 짝수이면 현재 값에서 -20 한 결과를 저장하고 출력하시오

        int addNumber = 52;
        if (addNumber % 2 == 0) {
            System.out.println("짝수");
            addNumber -= 20;
        } else {
            System.out.println("홀수");
            addNumber += 30;
        }
        System.out.println(addNumber);
    }
}
