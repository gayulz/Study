package com.skt.mo.set.member;

import java.util.Objects;

/**
 * @author : gayul.kim
 * @date : 2026. 1. 1.
 * @fileName : MemberOnlyHash
 */
public class MemberOnlyHash {
    private String id;

    public MemberOnlyHash(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MemberOnlyHash{" +
                "id='" + id + '\'' +
                '}';
    }
}
