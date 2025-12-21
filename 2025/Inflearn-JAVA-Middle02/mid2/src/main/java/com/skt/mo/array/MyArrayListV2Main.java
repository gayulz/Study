package com.skt.mo.array;

/**
 * @author : focusone
 * @date : 2025. 12. 17.
 * @fileName : MyArrayListV1Main
 */
public class MyArrayListV2Main {
    public static void main(String[] args) {
        MyArrayListV2 list = new MyArrayListV2(2);

        System.out.println("== 데이터 추가 ==");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);
        list.add("d");
        System.out.println(list);
        list.add("e");
        System.out.println(list);

        // 범위 초과 , capacity가 늘어나지 않으면 예외가 발생한다.
         list.add("f");
         System.out.println(list);
    }
}
