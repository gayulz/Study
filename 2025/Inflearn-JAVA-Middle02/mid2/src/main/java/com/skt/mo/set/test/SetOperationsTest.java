package com.skt.mo.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : SetOperationsTest
 */
public class SetOperationsTest {
    public static void main(String[] args) {
        /**
         * 두 숫자의 집합이 제공된다.
         * 집합1: 1, 2, 3, 4, 5
         * 집합2: 3, 4, 5, 6, 7
         * 두 집합의 합집합, 교집합, 차집합을 구해라. 출력의 순서는 관계없다.
         * 합집합 : 두 집합의 합, 중복은 제거 [1, 2, 3, 4, 5, 6, 7]
         * 교집합 : 두 집합의 공통 값 , 중복은 제거 [3, 4, 5]
         * 차집합 : 집합1에서 집합2와 같은 값을 뺀 나머지 [1, 2]
         */
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("union = " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("intersection = " + intersection);

        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("difference = " + difference);
    }
}
