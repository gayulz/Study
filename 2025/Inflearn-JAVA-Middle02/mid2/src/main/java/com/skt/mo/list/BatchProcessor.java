package com.skt.mo.list;

/**
 * @author : focusone
 * @date : 2025. 12. 21.
 * @fileName : BachProcessor
 */
public class BatchProcessor {
//    구체적인 의존관계
//    private final MyLinkedList<Integer> list = new MyLinkedList<>();

    private final MyList<Integer> list;
    // 생성자를 통해 list의 주입(최종 적인 주입되는 결과)를 바꿀 수 있음.
    // 관계가 외부에서 주입되는 것 같다고 해서 이건 의존성 주입 , 생성자 의존 관계 주입이라 한다.(DI)
    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i); // 앞에 추가
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기 : " + size + "계산 시간 -> " + (endTime-startTime) + "ms");
    }
}
