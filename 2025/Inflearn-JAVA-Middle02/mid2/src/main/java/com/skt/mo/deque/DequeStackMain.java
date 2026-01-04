package com.skt.mo.stack;

import java.util.Stack;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : DequeQueueMain
 */
public class DequeStackMain {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 데이터 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);

        // 단순 조회 ( 안꺼냄 )
        System.out.println("stack.peek() = " + stack.peek());

        // 데이터 꺼내기
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
    }
}
