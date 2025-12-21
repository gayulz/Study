package com.skt.mo.test.ex1;

/**
 * @author : focusone
 * @date : 2025. 12. 14.
 * @fileName : Contaøiner
 */
public class Container<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public boolean isEmpty() {
        return item == null;
    }

}
