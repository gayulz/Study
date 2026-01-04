package com.skt.mo.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : OfMain
 */
public class OfMain {
    public static void main(String[] args) {

        // 편리한 불변 컬렉션 생성
        List<Integer> list = List.of(1, 2, 3);
        Set<Integer> set = Set.of(1, 2, 3);
        Map<Integer, String> map = Map.of(1, "one", 2, "two");

//        list.add(9); -> 불변 객체로 업데이트 불가
        System.out.println("map.getClass() = " + map.getClass());
        System.out.println("set.getClass() = " + set.getClass());
        System.out.println("list.getClass() = " + list.getClass());
    }
}
