package com.skt.mo.iterable;

import java.util.Iterator;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : MyArray
 */
public class MyArray implements Iterable<Integer> {
    private int[] numbers;

    public MyArray(int[] numbers){
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }
}
