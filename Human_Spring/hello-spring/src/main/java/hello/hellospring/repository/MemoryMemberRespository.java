package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.*;


public class MemoryMemberRespository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    // sequence 는 번호를 부여해주는 객체라고 보면 됨
    private static long sequence = 0L;



    @Override
    public Member save(Member member) {
        // 시퀀스 값을 올려줌
        member.setId(++sequence);
        // 맵에 데이터 삽입
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 람다식
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
