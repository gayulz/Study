package com.skt.mo.animal;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : Animal
 */
public class Animal {
    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String name;
    private int size;

    public void sound(){
        System.out.println("동물 울음소리");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
