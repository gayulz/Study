package io.member;

import java.io.IOException;
import java.util.List;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : MemberRepository
 */
public interface MemberRepository {
    void add(Member member) throws IOException;

    List<Member> findAll();
}
