
# 테이블 생성 쿼리
```
create table ContackList(
contactNum number(2) primary key,
contactWriter varchar2(30),
contactTitle varchar2(100),
contactComment varchar2(500),
contactDate timestamp default sysdate
)
```

# 시퀀스 생성 쿼리
```
CREATE SEQUENCE contact_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
```

# 테스트용 insert
```
INSERT INTO ContackList VALUES (contact_seq.NEXTVAL, '김춘장', '아니이거왜이래요','고장났는데 짜증나네여 언제 방문해야되여?', DEFAULT);
INSERT INTO ContackList VALUES (contact_seq.NEXTVAL, '김춘식', '환불해줘요 고장났어요','아니 고장난걸 팔면 우짭니꺼', DEFAULT);
```

select * from ContackList;