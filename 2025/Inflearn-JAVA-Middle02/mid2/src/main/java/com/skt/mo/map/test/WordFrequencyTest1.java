package com.skt.mo.map.test;

import java.util.HashMap;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : WordFrequencyTest1
 */
public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        HashMap<String, Integer> map = new HashMap<>();
        
        // 코드 작성
        String[] words = text.split(" ");
        
        for(String word : words){
//            Integer count = map.get(word);
//            if (count == null) {
//                count = 0;
//            }
//            count++;
            Integer count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }
        System.out.println("map = " + map);
    }
}
