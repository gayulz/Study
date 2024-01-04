package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRespository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRespository memoryMemberRespository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRespository = new MemoryMemberRespository();
        memberService = new MemberService(memoryMemberRespository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRespository.clearStore();
    }


    @Test
    void 회원가입() {
        // given : 무언가가 주어지고
        Member member = new Member();
        member.setName("hi");
        // when : 이걸로 실행했을때
        Long saveId = memberService.join(member);
        // then : 결과가 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());;
    }

    @Test
    public void 중복_회원_예약(){
        // given
        Member member1 = new Member();
        member1.setName("spirng");

        Member member2 = new Member();
        member2.setName("spring");
        // when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try{
            memberService.join(member2);
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        // then

         */
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}