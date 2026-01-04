package com.skt.mo.compare;

import java.util.Arrays;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SortMain3
 */
public class SortMain3 {
    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);
        MyUser[] array = {myUser1, myUser2, myUser3};

        System.out.println("기본 데이터 : " + Arrays.toString(array));

        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array);
        System.out.println("array = " + Arrays.toString(array));

        /**
         * Comparable과 compareTo 를 구현하지 않고 진행 하면 예외발생
         * ClassCastException 발생
         */

        // Id 기준 정렬
        System.out.println("IdComparator 정렬");
        Arrays.sort(array, new IdComparator());
        System.out.println("IdComparator = " + Arrays.toString(array));
        Arrays.sort(array, new IdComparator().reversed());
        System.out.println("reversed= " + Arrays.toString(array));

    }
}
