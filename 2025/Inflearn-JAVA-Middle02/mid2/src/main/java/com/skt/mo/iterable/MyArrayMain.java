package com.skt.mo.iterable;

import java.util.Iterator;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : MyArrayMain
 */
public class MyArrayMain {
    public static void main(String[] args) {

        /**
         * Iterable : 반복 가능 한
         * Iterator : 반복자
         */
        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4, 5});

        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator 사용");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("for - each 사용");
        for (int value : myArray) {
            System.out.println("value = " + value);
        }
    }
}
