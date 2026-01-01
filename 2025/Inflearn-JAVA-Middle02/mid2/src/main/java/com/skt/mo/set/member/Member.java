package com.skt.mo.set.member;

import java.util.Objects;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 1.
 * @fileName : Member
 */
public class Member {
    private String id;

    public Member(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                '}';
    }
}

