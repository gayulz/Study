package com.skt.mo.link;

/**
 * @author : focusone
 * @date : 2025. 12. 21.
 * @fileName : Node
 */
public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node x = this;
        sb.append("[");
        while (x != null) {
            sb.append(x.item);
            if(x.next != null) sb.append(" -> ");
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                '}';
//    }


}
