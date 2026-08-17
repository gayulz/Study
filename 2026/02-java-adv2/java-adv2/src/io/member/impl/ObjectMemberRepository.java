package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : ObjectMemberRepository
 */
public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/member-obj.dat";

    @Override
    public void add(Member member) throws IOException {
        List<Member> members = findAll();
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
