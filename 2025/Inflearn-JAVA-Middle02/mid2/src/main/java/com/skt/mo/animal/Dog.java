package com.skt.mo.animal;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : Dog
 */
public class Dog extends Animal{

    public Dog(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
