package com.skt.mo.map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : CommonKeyValueSum1
 */
public class CommonKeyValueSum2 {
    public static void main(String[] args) {

        /**
         * Map.of 로 생성한 객체는 불변 , 수정 불가
         */
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);

        HashMap<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if(map2.containsKey(key)){
                result.put(key, map1.get(key) + map2.get(key));
            }
        }
        System.out.println("result = " + result);
    }
}
