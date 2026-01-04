package com.skt.mo.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : DequeQueueMain
 */
public class DequeQueueMain {
    public static void main(String[] args) {
        /**
         * 구현체로 성능이 빠른 ArrayDeque 사용을 권장한다
         */
        Deque<Integer> deque = new ArrayDeque<>();

        // 데이터 추가
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println("deque = " + deque);

        // 단순 조회 ( 안꺼냄 )
        System.out.println("deque.peek() = " + deque.peek());

        // 데이터 꺼내기
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque = " + deque);
    }
}
