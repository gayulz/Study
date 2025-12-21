package TASK;

import java.util.Random;

public class task02 {
    public static void main(String[] args) {
        int[] arrInt = new int[10];
        Random r = new Random();

        for (int i = 0; i < arrInt.length; i++) {
            int tmp = r.nextInt(99);
            if (tmp % 2 == 0){
                arrInt[i] = tmp;
            }
        }

        for (int i = 0; i < arrInt.length; i++) {
            System.out.print(arrInt[i] + " / ");
        }
    }
}
