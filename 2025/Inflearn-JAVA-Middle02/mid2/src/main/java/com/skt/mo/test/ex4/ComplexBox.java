package com.skt.mo.test.ex4;

import com.skt.mo.animal.Animal;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : ComplexBox
 */
public class ComplexBox <T extends Animal>{
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public <T> T printAndReturn(T t) {
        System.out.println("animal.classNAme : " + animal.getClass().getName());
        System.out.println("t.classNAme : " + t.getClass().getName());
        return t;
    }
}
