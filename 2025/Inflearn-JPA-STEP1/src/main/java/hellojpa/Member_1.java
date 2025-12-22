//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
///**
// * @author : focusone
// * @date : 2025. 12. 20.
// * @fileName : Member
// */
//
//@Entity
//public class Member_1 {
//
//    @Id
//    private Long id;
//
//    // nullable = false : NOTNULL 제약조건
//    // unique = true : 유니크 제약 조건 , jpa에서는 class 속성에 사용하고 컬럼단위로는 사용하지않음(오류 출력시 멘트가 이상하게나옴)
//    //                 테이블단위 유니크제약조건시 @uniqueConstraints
//    // columnDefinition : 데이터베이스 컬럼 정보를 직접 줄 수 있음
//    @Column(name = "name", nullable = false)
//    private String username;
//
//    private Integer age;
//
//    /**
//     * Enumerated의 기본 옵션은 EnumType.ORDINAL 임
//     * ORDINAL은 선언된 순서대로 0,1,2.. 이렇게 DB에 삽입 됨으로 순서가 바뀌면 일관성이 깨짐
//     * 그러므로 꼭 STRING 타입으로 하여 진행 해야한다 !
//     */
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    /**
//     * LocalDate, LocalDateTime을 사용시 생략 가능(최신 하이버네이트 지원)
//     * LocalDate = Date Type과 매핑 , LocalDateTime = timestamp 와 매핑됨
//     */
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//
//    /**
//     * 문자타입은 기본 CLOB 생성됨
//     * 그 외는 BLOB
//     */
//    @Lob
//    private String description;
//
//    @Transient
//    // DB에서 사용하지 않는 컬럼(제외시킬 때 사용)
//    private int temp;
//
//    public Member_1() {
//    }
//}
