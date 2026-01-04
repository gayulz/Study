package com.skt.mo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : EmptyListMain
 */
public class EmptyListMain {
    public static void main(String[] args) {

        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println("list1 = " + list1.size());
        System.out.println("list2 = " + list2.size());

        // 빈 불변 리스트 생성
        List<Integer> list3 = Collections.emptyList();   // 자바5부터 제공
        List<Integer> list4 = List.of();                // 자바9부터 제공

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());

        /**
         *  arrList와 ofList는 조금 로직이 다름
         *  asList로 생성한건 값을 그대로 가져다 쓰며 참조값도 가져오기 때문에
         *  중간에 값이 변경 되면 기존 arr의 값도 변경된다
         *  List.of 같은 경우 새로운 객체로 반환함으로 기존 값은 수정되지 않음
         */
        Integer[] arr = {1, 2, 3};
        List<Integer> arrList = Arrays.asList(arr);
        List<Integer> ofList = List.of(arr);
    }
}
