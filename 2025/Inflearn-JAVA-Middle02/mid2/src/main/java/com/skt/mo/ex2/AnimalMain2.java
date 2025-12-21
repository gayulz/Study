package com.skt.mo.ex2;

import com.skt.mo.animal.Animal;
import com.skt.mo.animal.Cat;
import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : AnimalMain2
 */
public class AnimalMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 50);

        Box<Animal> animalBox = new Box<>();

        animalBox.set(animal);
        animalBox.set(dog);
        animalBox.set(cat);

        Animal findAnimal = animalBox.get();
        System.out.println("findAnimal : " + findAnimal);
    }
}
