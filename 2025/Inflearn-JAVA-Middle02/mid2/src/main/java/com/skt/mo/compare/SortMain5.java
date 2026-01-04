package com.skt.mo.compare;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SortMain4
 */
public class SortMain5 {
    public static void main(String[] args) {

        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(myUser1);
        treeSet1.add(myUser2);
        treeSet1.add(myUser3);
        System.out.println("Comparable 기본 정렬 - TreeSet은 들어간 순간부터 정렬이 된다");
        System.out.println("treeSet1 = " + treeSet1);

        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
        treeSet2.add(myUser1);
        treeSet2.add(myUser2);
        treeSet2.add(myUser3);
        System.out.println("IdComparator 정렬 : " + treeSet2);

    }
}
