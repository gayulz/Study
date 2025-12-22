package com.skt.mo.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 22.
 * @fileName : ListInoutEx1
 */
public class ListEx3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("n개의 정수를 입력하세요(종료 0)");

        while (true) {
            int input = sc.nextInt();
            if (input == 0) {
                break;
            }
            list.add(input);
            total += input;
        }

        System.out.println("출력");
        System.out.println("입력한 정수의 합계 : " + total);
        System.out.println("입력한 정수의 평균 : " + (double)(total/list.size()));
    }
}
