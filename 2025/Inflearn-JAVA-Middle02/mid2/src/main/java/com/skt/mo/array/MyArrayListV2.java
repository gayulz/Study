package com.skt.mo.array;

import java.util.Arrays;

/**
 * @author : focusone
 * @date : 2025. 12. 17.
 * @fileName : MyArrayListV1
 */
public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object a){
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = a;
        size++;
    }

    // 코드 추가
    private void grow() {
        // 큰 배열을 만들고 기존 배열을 복사 하고 추가 데이터를 입력
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity *2;
        //  새로운 크기의 배열을 만들고 기존 데이터를 복사해 만듦
        Object[] newArr = Arrays.copyOf(elementData, newCapacity);
//        Object[] newArr = new Object[newCapacity];
//        for (int i = 0; i < elementData.length; i++) {
//            newArr[i] = elementData[i];
//        }
        elementData = newArr;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public Object set(int index, Object element) {
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size))
                + "size= " + size + ", capacity=" + elementData.length;
    }
}
