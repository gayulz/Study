package com.skt.mo.list;

/**
 * 제네릭 인터페이스
 * @author : focusone
 * @date : 2025. 12. 21.
 * @fileName : MyList
 */
public interface MyList<E> {

    int size();

    void add(E e);

    void add(int index, E e);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int indexOf(E o);
}
