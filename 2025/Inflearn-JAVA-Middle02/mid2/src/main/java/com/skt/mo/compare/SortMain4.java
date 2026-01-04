package com.skt.mo.compare;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SortMain4
 */
public class SortMain4 {
    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);
        LinkedList<MyUser> list = new LinkedList<MyUser>();

        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);

        System.out.println("기본 데이터 : " + list );
        list.sort(null);
//        Collections.sort(list);
        System.out.print("Conmparable 기본 정렬 : " + list);

        System.out.println("---------------------------------------");
        list.sort(new IdComparator());
//        Collections.sort(list, new IdComparator());
        System.out.println("IdComparator 정렬 : " + list);

        /**
         * Collections.sort 보다 .sort()를 사용하는 것이 더 객체지향적이다.
         */
    }
}
