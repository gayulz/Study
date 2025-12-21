package com.skt.mo.ex2;

import com.skt.mo.animal.Animal;
import com.skt.mo.animal.Cat;
import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : AnimalMain1
 */
public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 50);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        Dog findDog = dogBox.get();
        System.out.println("findDog = " + findDog);

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        Cat findCat = catBox.get();
        System.out.println("findCat = " + findCat);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        Animal findAnimal = animalBox.get();
        System.out.println("findAnimal = " + findAnimal);

    }
}
