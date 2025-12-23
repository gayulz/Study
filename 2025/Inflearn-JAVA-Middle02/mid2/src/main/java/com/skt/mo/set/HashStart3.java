package com.skt.mo.set;

import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 23.
 * @fileName : HashStart2
 */
public class HashStart3 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[100];

        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        inputArray[14] = 14;
        inputArray[99] = 99;
        System.out.println("Arrays.toString(inputArray) = " + Arrays.toString(inputArray));

        int searchValue = 99;
        Integer result = inputArray[searchValue];
        System.out.println(result);
    }
}
