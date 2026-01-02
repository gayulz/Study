package com.skt.mo.set.test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : UniqueNameTest2
 */
public class UniqueNameTest3 {
    public static void main(String[] args) {
        /**
         * 여러 정수가 입력된다. 여기서 중복 값을 제거하고 값을 출력해라.
         * 30, 20, 20, 10, 10 이 출력되면 중복을 제거 하고 출력하면 된다.
         * 데이터의 값 순서대로 출력해라.
         * 예 ) 10, 20, 30
         */
        Set<Integer> set = new TreeSet<>(List.of(30,20,20,10,10));
        System.out.print("TreeSet : ");
        for(Integer i : set){
            System.out.print(i + " ");
        }
    }
}
