package com.skt.mo.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SyncMain
 */
public class SyncMain {
    public static void main(String[] args) {

        /**
         * 출력 : class java.util.Collections$SynchronizedRandomAccessList
         * Collections.synchronizedList() 를 사용하면
         * 일반 리스트를 멀티스레드 상황에서 동기화 문제가 발생하지 않는
         * 안전한 리스트로 만들 수 있다.
         *
         * 단 , 동기화 작업으로 인해 일반 리스트 보다 성능은 느리다.
         * */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list.getClass() = " + list.getClass());
        List<Integer> syncList = Collections.synchronizedList(list);
        System.out.println("syncList.getClass() = " + syncList.getClass());

    }
}
