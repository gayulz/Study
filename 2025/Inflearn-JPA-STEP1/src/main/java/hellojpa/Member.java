package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author : focusone
 * @date : 2025. 12. 20.
 * @fileName : Member
 */

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName="member_seq")
public class Member {

    /**
     * ID를 직접 할당 시 @Id 만 사용하면 됨
     * 자동 생성 시 @GeneratedValue사용
     * 옵션
     * 1. IDENTITY : 데이터베이스 위임 , MYSQL / PostgreSQL, Server, DB2에서 사용(AUTO_INCREMENT)
     * 2. SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용, 주로 오라클에서 사용(SequenceGenerator 필요)
     * 3. TABLE : 키 생성용 테이블 사용, 모든 DB에서 사용 @TableGenerator 필요 / 단점 : 성능
     * 4. AUTO : 방언에 따라 자동 지정이며 기본값임
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="member_seq_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
