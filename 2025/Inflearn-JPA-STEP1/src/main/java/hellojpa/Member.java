package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author : focusone
 * @date : 2025. 12. 20.
 * @fileName : Member
 */

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    /**
     * Enumerated의 기본 옵션은 EnumType.ORDINAL 임
     * ORDINAL은 선언된 순서대로 0,1,2.. 이렇게 DB에 삽입 됨으로 순서가 바뀌면 일관성이 깨짐
     * 그러므로 꼭 STRING 타입으로 하여 진행 해야한다 !
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {
    }
}
