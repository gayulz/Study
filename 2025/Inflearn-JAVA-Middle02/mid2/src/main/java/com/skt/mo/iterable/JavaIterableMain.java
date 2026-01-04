package com.skt.mo.iterable;

import java.util.*;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : JavaIterableMain
 */
public class JavaIterableMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        foreach(list);
        foreach(set);
        System.out.println("======================================");
        printAll(list.iterator());
        printAll(set.iterator());


    }

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator 사용 : " + iterator.getClass());
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }

    private static void foreach(Iterable<Integer> iterable) {
        System.out.println("iterable 사용 : " + iterable.getClass());
        for (Integer i : iterable) {
            System.out.println("iterable.i = " + i);
        }
    }
}
