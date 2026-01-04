package com.skt.mo.deque;

import java.util.Stack;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : StackMain
 */
public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);

        // 다음 꺼낼 요소 확인(꺼내지 않고 단순 조회)
        System.out.println("stack.peek() = " + stack.peek());

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack = " + stack);
    }
    /**
     * Stack 클래스 사용 하지 말자.
     * Vector 라는 자료 구조를 사용함
     * 이 구조는 자바 1.0 에서 개발됨
     * 지금은 사용하지 않고 하위 호환을 위해 존재함
     * 지금은 더 빠른 좋은 구조가 많음 / Vector를 사용하는 Stack도 사용하지 않는 것을 권장함
     * 대신 이후에 Deque를 사용하는 것이 더 좋음
     */
}
