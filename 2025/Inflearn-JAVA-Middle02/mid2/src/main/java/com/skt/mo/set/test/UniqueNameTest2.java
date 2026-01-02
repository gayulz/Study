package com.skt.mo.set.test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : UniqueNameTest2
 */
public class UniqueNameTest2 {
    public static void main(String[] args) {
        /**
         * 여러 정수가 입력된다.
         * 여기서 중복값을 제거하고 값을 출력해라
         * 30,20,20,10,10 이 출력되면 중복을 제거하고 출력하면 된다.
         * 단 입력 순서대로 출력해라.
         */
        Set<Integer> set = new LinkedHashSet(List.of(30,20,20,10,10));
        System.out.print("LinkedHashSet : ");
        for(Integer i : set){
            System.out.print(i + " ");
        }
    }
}
