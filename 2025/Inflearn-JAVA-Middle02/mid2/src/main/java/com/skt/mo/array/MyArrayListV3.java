package com.skt.mo.array;

import java.util.Arrays;

/**
 * @author : focusone
 * @date : 2025. 12. 17.
 * @fileName : MyArrayListV1
 */
public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity) {
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
    public void add(int index, Object e){
        if (size == elementData.length) {
            grow();
        }
        // 데이터 이동
        shiftRightFrom(index);
        elementData[size] = e;
        size++;
    }

    public void shiftRightFrom(int index) {
        // 코드 추가 요소의 마지막부터 index 까지 오른쪽으로 밀기
        for (int i = size; i < index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    public Object remove(int index) {
        Object oldValue = get(index);
        shiftLeftFrom(index);
        // 데이터 이동
        size--;
        elementData[size] = null;
        return oldValue;
    }

    public void shiftLeftFrom(int index) {
        // 요소의 index 부터 마지막 까지 왼쪽으로 밀기
        for (int i = index; i < size-1; i++) {
            elementData[i] = elementData[i + 1];
        }
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
