package com.skt.mo.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : SortMain2
 */
public class SortMain2 {
    public static void main(String[] args) {
        Integer[] array = {3, 2, 1};
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("Comparator 비교");

        Arrays.sort(array, new AscComparator());
        System.out.println("AscComparator : " + Arrays.toString(array));

        Arrays.sort(array, new DescComparator());
        System.out.println("DescComparator = " + Arrays.toString(array));

        Arrays.sort(array, new DescComparator().reversed());
        System.out.println("AscComparator().reversed() = " + Arrays.toString(array));
    }

    static class AscComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2);
            return o1.compareTo(o2);
        }
    }

    /**
     * reversed() 사용하면 됨.
     */
    static class DescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println("o1=" + o1 + " o2=" + o2);
            return (o1 < o2) ? -1 : ((o1.equals(o2)) ? 0 : 1) * -1;
        }
    }
}
