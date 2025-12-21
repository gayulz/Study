package com.skt.mo.test.ex4;

import com.skt.mo.animal.Cat;
import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : MethodMAin3
 */
public class MethodMAin3 {
    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.set(dog);

        Cat returnCat = hospital.printAndReturn(cat);
        System.out.println("return Cat = " + returnCat);

    }
}
