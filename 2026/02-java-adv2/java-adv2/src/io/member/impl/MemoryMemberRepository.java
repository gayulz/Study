package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : MemoryMemberRepositry
 */
public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();

    @Override
    public void add(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }
}
