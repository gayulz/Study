package com.skt.mo.test.ex1;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : ContainerTest
 */
public class ContainerTest {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>();
        System.out.println("빈값 확인 1 :" + stringContainer.isEmpty());

        stringContainer.setItem("data1");

        System.out.println("저장 데이터 -> " + stringContainer.getItem());
        System.out.println("저장 데이터 빈값 확인 -> " + stringContainer.isEmpty());

        Container<Integer> integerContainer = new Container<>();
        integerContainer.setItem(10);
        System.out.println("저장 데이터 -> " + integerContainer.getItem());
    }
}
