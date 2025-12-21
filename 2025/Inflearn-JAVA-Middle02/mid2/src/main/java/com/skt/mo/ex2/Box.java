package com.skt.mo.ex2;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : Box
 */
public class Box<T>{
    private T value;
    public void set(T value){
        this.value = value;
    }
    public T get(){
        return value;
    }
}
