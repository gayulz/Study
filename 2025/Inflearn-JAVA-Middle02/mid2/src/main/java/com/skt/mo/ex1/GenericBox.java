package com.skt.mo.ex1;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : GenericBox
 */
public class GenericBox<T> {

    private T value;

    public void set(T value){
        this.value = value;
    }

    public T get(){
        return value;
    }
}
