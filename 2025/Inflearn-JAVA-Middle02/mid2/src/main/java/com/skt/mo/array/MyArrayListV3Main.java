package com.skt.mo.array;

/**
 * @author : focusone
 * @date : 2025. 12. 17.
 * @fileName : MyArrayListV1Main
 */
public class MyArrayListV3Main {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        // 원하는 위치에 추가
        System.out.println("addLast");
        list.add(3, "addList");
        System.out.println(list);

        System.out.println("addFirst");
        list.add(0, "addFirst");
        System.out.println(list);

        Object removed1 = list.remove(4);
        System.out.println("removed1 = " + removed1);
        System.out.println(list);

        Object removed2 = list.remove(0);
        System.out.println("removed2 = " + removed2);
        System.out.println(list);
    }
}
