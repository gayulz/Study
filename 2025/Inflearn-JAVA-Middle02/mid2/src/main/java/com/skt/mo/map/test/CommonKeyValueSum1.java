package com.skt.mo.map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : CommonKeyValueSum1
 */
public class CommonKeyValueSum1 {
    public static void main(String[] args) {
        /**
         * map1과 map2에 공통으로 들어간 키를 찾고 , 그 합을 구해라
         * 실행 결과 참조
         */
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 1);
        map2.put("C", 2);
        map2.put("D", 3);

        /**
         * 실행 결과
         * {B=6, C=8}
         */

        HashMap<String, Integer> result = new HashMap<>();
        for (String key : map1.keySet()) {
            if(map2.containsKey(key)){
                result.put(key, map1.get(key) + map2.get(key));
            }
        }
        System.out.println("result = " + result);
    }
}
