package com.skt.mo.set;

import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 23.
 * @fileName : MyHashSetV0
 */
public class MyHashSetV0 {
    private int[] elementData = new int[10];
    private int size = 0;

    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }
        elementData[size]  = value;
        size++;
        return true;
    }

    public boolean contains(int value) {
        for (int data : elementData) {
            if(data == value) return true;
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size=" + size +
                '}';
    }
}
