package com.skt.mo.list;

/**
 * @author : gayul.kim
 * @date : 2025. 12. 21.
 * @fileName : BatchMain
 */
public class BatchMain {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        BatchProcessor batchArrayList = new BatchProcessor(list);

        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        BatchProcessor batchLinkedList = new BatchProcessor(list1);


//        batchArrayList.logic(50);
        batchLinkedList.logic(5_000_000);
    }
}
