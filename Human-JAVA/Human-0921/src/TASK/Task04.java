package TASK;

public class Task04 {
    public static void main(String[] args) {
        //  100부터 999까지의 숫자의 모든 숫자의 합을 구하시오.
        //  453인 경우 4+5+3로 합한 값의 모든 총합을 구하시오.

        int subTot= 0;

        for (int i = 100; i < 1000; i++) {
            int subNum = i / 10;
            int subNum3 = i % 10;
            int subNum2 = subNum % 10;
            int subNum1 = subNum / 10;
            subTot += subNum1 + subNum2 + subNum3;
        }
        System.out.println(subTot);


    }
}
