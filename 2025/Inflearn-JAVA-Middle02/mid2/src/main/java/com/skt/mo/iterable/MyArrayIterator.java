package com.skt.mo.iterable;

import java.util.Iterator;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : MyArrayIterator
 */
public class MyArrayIterator implements Iterator<Integer> {
    /**
     * 배열 반복자
     */
    private int currentIndex = -1;
    private int[] targetArr;

    public MyArrayIterator(int[] targetArr) {
        this.targetArr = targetArr;
    }


    @Override
    public boolean hasNext() {
        return currentIndex < targetArr.length - 1;
    }

    @Override
    public Integer next() {
        return targetArr[++currentIndex];
    }

}
