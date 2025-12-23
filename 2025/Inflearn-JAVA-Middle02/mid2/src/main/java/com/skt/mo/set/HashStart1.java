package com.skt.mo.set;

import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 23.
 * @fileName : HashStart1
 */
public class HashStart1 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[4];
        inputArray[0] = 1;
        inputArray[1] = 2;
        inputArray[2] = 5;
        inputArray[3] = 8;
        System.out.println("Arrays.toString(inputArray) = " + Arrays.toString(inputArray));

        int searchValue = 8;
        for (int inputValue : inputArray) {
            if (inputValue == searchValue) {
                System.out.println(inputValue);
            }
        }
    }
}
