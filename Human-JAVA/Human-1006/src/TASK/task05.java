package TASK;

public class task05 {
    public static void main(String[] args) {
        int resultTmp = 0;
        for (int i = 1; i <= 10; i++) {
            int tmp = 1;
            for (int j = 1; j <= i ; j++) {
                tmp *= j;
            }
            System.out.println(i+"!의 팩토리얼 합은 :" + tmp);
            resultTmp+=tmp;
            tmp=1;
        }
        System.out.println("모든 팩토리얼의 합 : " + resultTmp);
    }
}
