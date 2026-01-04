package com.skt.mo.compare;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SortMain1
 */
public class SortMain1 {
    public static void main(String[] args) {
        Integer[] array = {3, 2, 1};
        System.out.println("array = " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Array.toString(array) = " + Arrays.toString(array));

    }
}
