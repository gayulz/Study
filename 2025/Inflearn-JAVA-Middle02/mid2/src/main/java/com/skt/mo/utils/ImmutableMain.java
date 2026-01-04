package com.skt.mo.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : ImmutableMain
 */
public class ImmutableMain {
    public static void main(String[] args) {
        // 불변 -> 가변으로 변경
        List<Integer> list = List.of(1, 2, 3);
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(5);
        System.out.println("mutableList.getClass() = " + mutableList.getClass());
        
        // 가변 -> 불변으로 변경
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());
        // 출력 : class java.util.Collections$UnmodifiableRandomAccessList

    }
}
