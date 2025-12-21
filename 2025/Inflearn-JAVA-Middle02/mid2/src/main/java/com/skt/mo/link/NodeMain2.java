package com.skt.mo.link;

/**
 * @author : focusone
 * @date : 2025. 12. 21.
 * @fileName : NodeMain2
 */
public class NodeMain2 {
    public static void main(String[] args) {

        // 노드 생성하고 연결하기 : A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        // 연결된 노드 출력하기
        System.out.println("연결된 노드 출력하기");
        System.out.println("first = " + first);
    }
}
