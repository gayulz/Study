package com.skt.mo.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : MapMain1
 */
public class MapMain1 {
    public static void main(String[] args) {
        /**
         * Map의 특징
         * Key는 중복 불가
         * Value는 중복 가능
         * 순서를 보장하지 않음
         *  상위인터페이스 Map
         *              |
         *      HashMap     TreeMap
         *          |
         *    LinkedHashMap
         */
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);

        // 특정 학생의 값 조회
        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);
        System.out.println("===============================================");
        System.out.println("KeySet 활용\n");
        Set<String> keySet = studentMap.keySet();
        for(String key : keySet){
            Integer value = studentMap.get(key);
            System.out.println("key = " + key + " , value = " + value);
        }
        System.out.println("===============================================");
        System.out.println("values 활용\n");
        Collection<Integer> values = studentMap.values();
        for(Integer value : values){
            System.out.println("value = " + value);
        }
        System.out.println("===============================================");
        System.out.println("entrySet 활용\n");

        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key + " , value = " + value);
        }
    }
}
