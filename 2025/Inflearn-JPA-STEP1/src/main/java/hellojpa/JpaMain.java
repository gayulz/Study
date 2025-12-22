package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // webserver 실행시 EntityManagerFactory는 하나만 생성하여 애플리케이션 전체에서 공유한다
        // 엔티티 매니저는 쓰레드간에 공유X 사용하고 버려야함
        // JPA의 모든 데이터변경은 트랜잭션 안에서 실행해야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code

        // JPA 에선 모든 작업을 트랜젝션 단위 안에서 진행해야한다
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("SEQUENCE2");

            em.persist(member);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
