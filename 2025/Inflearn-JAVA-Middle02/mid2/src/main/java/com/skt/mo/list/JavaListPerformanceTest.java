package com.skt.mo.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 22.
 * @fileName : MyListPerformanceTest
 */
public class JavaListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("===== ArrayList 추가 ======");
        addFirst(new ArrayList<>(), size);
        addMid(new ArrayList<>(), size);
        ArrayList<Integer> arrayList = new ArrayList<>();
        addLast(arrayList, size);

        int loop = 10000;
        System.out.println("===== ArrayList getIndex ======");
        getIndex(arrayList, loop, 0); // 앞에서 조회
        getIndex(arrayList, loop, size / 2);  // 중간에서 조회
        getIndex(arrayList, loop, size -1);  // 뒤에서 조회

        System.out.println("===== ArrayList search ======");
        search(arrayList, loop, 0); // 앞에서 조회
        search(arrayList, loop, size / 2);  // 중간에서 조회
        search(arrayList, loop, size -1);  // 뒤에서 조회


        System.out.println("===== LinkedList 추가 ======");
        addFirst(new LinkedList<>(), size);
        addMid(new LinkedList<>(), size);
        LinkedList<Integer> linkedList = new LinkedList<>();
        addLast(linkedList, size);

        System.out.println("===== LinkedList getIndex ======");
        getIndex(linkedList, loop, 0); // 앞에서 조회
        getIndex(linkedList, loop, size / 2);  // 중간에서 조회
        getIndex(linkedList, loop, size -1);  // 뒤에서 조회

        System.out.println("===== LinkedList search ======");
        search(linkedList, loop, 0); // 앞에서 조회
        search(linkedList, loop, size / 2);  // 중간에서 조회
        search(linkedList, loop, size -1);  // 뒤에서 조회

    }

    private static void getIndex(List<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index : " + index + ", 반복 : " + loop + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void search(List<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue : " + findValue + ", 반복 : " + loop + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void addFirst(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("앞에 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void addMid(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("평균 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime - startTime) + "ms");

    }
        private static void addLast(List<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("뒤에 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime - startTime) + "ms");
    }
}

