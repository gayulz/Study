package com.skt.mo.set;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 23.
 * @fileName : MyHashSetV0Main
 */
public class MyHashSetV0Main {
    public static void main(String[] args) {
        MyHashSetV0 set = new MyHashSetV0();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println("set = " + set);

        boolean result = set.add(4);
        System.out.println("중복 데이터 저장 결과 = " + result);
        System.out.println("set = " + set);

        System.out.println("set.contains(3) = " + set.contains(3));
        System.out.println("set.contains(99) = " + set.contains(99));
    }
}