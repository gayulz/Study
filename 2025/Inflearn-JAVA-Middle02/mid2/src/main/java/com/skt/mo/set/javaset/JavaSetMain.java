package com.skt.mo.set.javaset;

import java.util.*;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : JavaSetMain
 */
public class JavaSetMain {
    public static void main(String[] args) {
        /**
         * HashSet : 입력한 순서를 보장하지 않는다.
         * LinkedHashSet : 입력 순서를 정확히 보장한다
         * TreeSet : 데이터 값을 기준으로 정렬한다
         */
        run(new HashSet<String>());
        run(new LinkedHashSet<String>());
        run(new TreeSet<String>());
    }

    private static void run(Set<String> set) {
        set.add("C");
        set.add("B");
        set.add("1");
        set.add("A");
        set.add("2");
        set.add("D");

        Iterator<String> iterator = set.iterator();
        System.out.print(set.getClass() + " : ");
        System.out.print("[ ");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println("]");
    }
}
