package com.skt.mo.map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : ArrayToMapTest
 */
public class ArrayToMapTest {
    public static void main(String[] args) {

        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        // 주어진 배열로부터 Map 생성 - 코드 작성
        Map<String, Integer> productMap = new HashMap<>();
        for(String[] product : productArr){
            productMap.put(product[0], Integer.valueOf(product[1]));
        }

        // Map의 모든 데이터 출력 - 코드 작성
        for (String key : productMap.keySet()) {
            System.out.println("제품 : " + key + ", 가격 : " + productMap.get(key));
        }
    }
}
