package com.skt.mo.compare;

import java.util.Comparator;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 4.
 * @fileName : IdComparator
 */
public class IdComparator implements Comparator<MyUser> {

    @Override
    public int compare(MyUser o1, MyUser o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
