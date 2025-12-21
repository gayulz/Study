package com.skt.mo.test.ex3;

import com.skt.mo.animal.Cat;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : CatHespital
 */
public class CatHospital {
    private Cat animal;

    public void set(Cat animal) {
        this.animal = animal;
    }

    public Cat get() {
        return animal;
    }

    public void checkup() {
        System.out.println("동물 이름 : " + animal.getName());
        System.out.println("동물 크기 : " + animal.getSize());
        animal.sound();
    }

    public Cat bigger(Cat target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
