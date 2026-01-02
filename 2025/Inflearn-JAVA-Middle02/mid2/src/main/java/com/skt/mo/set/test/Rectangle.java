package com.skt.mo.set.test;

import java.util.Objects;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : Rectangle
 */
public class Rectangle {
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int width;
    private int height;

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
