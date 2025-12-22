package com.skt.mo.list;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 22.
 * @fileName : MyListPerformanceTest
 */
public class MyListPerformanceTest {
    public static void main(String[] args) {
        int size = 50_000;
        System.out.println("===== MyArrayList 추가 ======");
        addFirst(new MyArrayList<>(), size);
        addMid(new MyArrayList<>(), size);
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        addLast(arrayList, size);

        int loop = 10000;
        System.out.println("===== MyArrayList getIndex ======");
        getIndex(arrayList, loop, 0); // 앞에서 조회
        getIndex(arrayList, loop, size / 2);  // 중간에서 조회
        getIndex(arrayList, loop, size -1);  // 뒤에서 조회

        System.out.println("===== MyArrayList search ======");
        search(arrayList, loop, 0); // 앞에서 조회
        search(arrayList, loop, size / 2);  // 중간에서 조회
        search(arrayList, loop, size -1);  // 뒤에서 조회


        System.out.println("===== MyLinkedList 추가 ======");
        addFirst(new MyLinkedList<>(), size);
        addMid(new MyLinkedList<>(), size);
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        addLast(linkedList, size);

        System.out.println("===== MyLinkedList getIndex ======");
        getIndex(linkedList, loop, 0); // 앞에서 조회
        getIndex(linkedList, loop, size / 2);  // 중간에서 조회
        getIndex(linkedList, loop, size -1);  // 뒤에서 조회

        System.out.println("===== MyLinkedList search ======");
        search(linkedList, loop, 0); // 앞에서 조회
        search(linkedList, loop, size / 2);  // 중간에서 조회
        search(linkedList, loop, size -1);  // 뒤에서 조회

    }

    private static void getIndex(MyList<Integer> list, int loop, int index) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("index : " + index + ", 반복 : " + loop + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void search(MyList<Integer> list, int loop, int findValue) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            list.get(findValue);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findValue : " + findValue + ", 반복 : " + loop + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void addFirst(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("앞에 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime-startTime) + "ms");
    }

    private static void addMid(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("평균 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime - startTime) + "ms");

    }
        private static void addLast(MyList<Integer> list, int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("뒤에 추가 - 크기 : " + size + ", 계산 시간 : " + (endTime - startTime) + "ms");
    }
}

