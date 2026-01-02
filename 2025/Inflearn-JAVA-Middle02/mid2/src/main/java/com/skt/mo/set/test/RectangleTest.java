package com.skt.mo.set.test;

import java.util.HashSet;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 3.
 * @fileName : RactangleTest
 */
public class RectangleTest {
    public static void main(String[] args) {
        HashSet<Rectangle> rectangeSet = new HashSet<>();
        rectangeSet.add(new Rectangle(10, 10));
        rectangeSet.add(new Rectangle(20, 20));
        rectangeSet.add(new Rectangle(20, 20));

        for (Rectangle rectangle : rectangeSet) {
            System.out.println("rectangle = " + rectangle);
        }

        /**
         * HashSet 알고리즘을 사용하기 때문에
         * !!!!!!!꼭!!!!!!!! equals 와 hashCode를 재정의 해야
         * 값을 제대로 비교한다.
         */

    }
}

