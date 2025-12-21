package com.skt.mo.animal;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : Cat
 */
public class Cat extends Animal{

    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
