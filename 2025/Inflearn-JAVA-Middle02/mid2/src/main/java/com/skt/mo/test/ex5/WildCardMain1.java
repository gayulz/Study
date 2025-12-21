package com.skt.mo.test.ex5;

import com.skt.mo.animal.Animal;
import com.skt.mo.animal.Cat;
import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : WildCardMain1
 */
public class WildCardMain1 {
    public static void main(String[] args) {
        Box<Object> obBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);
        System.out.println("-------------------------------------");
        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);
        System.out.println("-------------------------------------");
        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);


    }
}