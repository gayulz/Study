package com.skt.mo.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : MapMain2
 */
public class MapMain3 {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 50);
        System.out.println("studentMap = " + studentMap);

        // 학생이 없는 경우에만 추가 방법 1
        if(!studentMap.containsKey("studentA")){
            studentMap.put("studentA", 100);
        }
        System.out.println("studentMap = " + studentMap);

        // 학생이 없는 경우에만 추가 방법 2
        studentMap.putIfAbsent("studentA", 100);
        studentMap.putIfAbsent("studentB", 100);
        System.out.println("studentMap = " + studentMap);
    }
}
