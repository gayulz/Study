package com.skt.mo.link;

/**
 * @author : focusone
 * @date : 2025. 12. 21.
 * @fileName : MyLinkedListV2Main
 */
public class MyLinkedListV2Main {
    public static void main(String[] args) {

        MyLinkedListV2 list = new MyLinkedListV2();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("list = " + list);
        list.add(0, "d");
        System.out.println("첫번째 항목에 추가 list = " + list);
        list.remove(0);
        System.out.println("첫번째 항목 삭제 list = " + list);
        list.add(2, "z");
        System.out.println("두번째 항목 추가 list = " + list);
        list.add("f");
        list.add("g");
        list.add("h");
        System.out.println("f, g, h 추가 list = " + list);
        list.remove(4);
        System.out.println("4번째 항목 삭제 list = " + list);
    }
}
