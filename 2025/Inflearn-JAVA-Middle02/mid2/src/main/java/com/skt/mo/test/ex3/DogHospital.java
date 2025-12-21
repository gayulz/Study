package com.skt.mo.test.ex3;

import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : DogHespital
 */
public class DogHospital {
    private Dog animal;

    public void set(Dog animal) {
        this.animal = animal;
    }

    public Dog get() {
        return animal;
    }

    public void checkup() {
        System.out.println("동물 이름 : " + animal.getName());
        System.out.println("동물 크기 : " + animal.getSize());
        animal.sound();
    }

    public Dog bigger(Dog target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
