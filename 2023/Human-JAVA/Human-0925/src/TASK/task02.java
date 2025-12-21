package TASK;

import sun.font.FontRunIterator;

import java.util.Scanner;

public class task02 {
    public static void main(String[] args) {
        int[] arr = new int[5];     // 5개의 Int를 받을 수 있는 공간 생성, [5]는 배열의 길이
                                       // 인덱스는 0 ~ 4까지 있다
        // 입력부 : 배열의 값을 저장하는 부
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }

        // 출력부  : 배열의 값을 출력하는 부
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }


    }
}
