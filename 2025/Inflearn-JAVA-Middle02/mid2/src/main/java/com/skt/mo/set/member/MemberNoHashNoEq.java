package com.skt.mo.set.member;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 1.
 * @fileName : MemberNoHashNoEq
 */
public class MemberNoHashNoEq {
    private String id;

    public MemberNoHashNoEq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MemberNoHashNoEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
