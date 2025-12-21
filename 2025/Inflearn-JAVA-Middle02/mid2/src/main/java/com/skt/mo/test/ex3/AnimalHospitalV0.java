package com.skt.mo.test.ex3;

import com.skt.mo.animal.Cat;
import com.skt.mo.animal.Dog;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : AnimalHospital
 */
public class AnimalHospitalV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제 1 : 개 병원에 고양이 전달이 안됨
        // dogHospital.set(cat); // 다른 타입 입력 시 컴파일 오류

        // 문제 2 : 개 타입 변환
        dogHospital.set(dog);
        Dog bigger = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("bigger = " + bigger);
        
    }
}
