package com.skt.mo.ex1;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : BoxMain3
 */
public class BoxMain3 {
    public static void main(String[] args) {
//        생성 시점에 타입 결정이 됨
        GenericBox<Integer> integerBox = new GenericBox<>();

        integerBox.set(10);

        Integer integer = integerBox.get();
        System.out.println(integer);

        GenericBox<String> stringBox = new GenericBox<>();

        stringBox.set("Hello");

        String string = stringBox.get();
        System.out.println(string);
    }
}
