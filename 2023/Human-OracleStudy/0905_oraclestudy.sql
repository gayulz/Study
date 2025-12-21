-- 9월 5일 SQL 실습 --
-- 기존 테이블 삭제 
DROP TABLE MEMBER;


-- 새로운 테이블 생성 
CREATE TABLE MEMBER (
	NO number(2) PRIMARY KEY,
	name varchar2(10),
	age number(2), 
	addr varchar2(20)
);

-- 생성 테이블 확인 
SELECT * FROM MEMBER;



-- ALTER 문법 
-- alter rename  : 	테이블 이름, 컬럼 이름, 제약조건 이름 변경
-- alter add : 컬럼 추가
-- alter modify :  컬럼의 데이터 유형 또는 크기 변경 
-- alter drop : 컬럼의 삭제, 제약조건 삭제,

ALTER TABLE MEMBER ADD point number(4);
ALTER TABLE MEMBER MODIFY age number(3);
SELECT * FROM MEMBER;


-- Insert 문법 
-- insert into [ 테이블명 ] values (입력값1,2,3,...)
-- insert into [ 테이븖령(컬럼명지정)] values (입력값1,2,3..)


insert into member values ( 1, '김일수', 23, '경기도수원시',300);
insert into MEMBER values ( 2, '홍길수', 34, '수원시', 250);
insert into member values ( 3, '이지수', 48, '용인시', 100);
insert into member values ( 4, '삼국지', 49, '서울시', 400);
insert into member values ( 5, '사거리', 37, '용인시', 250);
insert into member values ( 6, '오징어', 23, '서울시', 180);
insert into member values ( 7, '칠성수', 10, '서울시', 300);

SELECT * FROM MEMBER;

-- 연습 -- 
-- 1번 나이가 20세 이상인 사람의 정보를 모두 출력하시오
SELECT name 
FROM MEMBER
WHERE age >= 20;

-- 2번 나이가 20세 이상인 사람의 이름과 나이를 출력하시오 
SELECT name, age 
FROM MEMBER 
WHERE age >= 20;

-- 과제 --

-- 1번 포인트가 200이상인 사람의 이름과 주소, 포인트를 출력하시오
select name , addr, point
from member
where point >= 200;



-- 2번 포인트가 300미만인 사람들의 모든 정보를 출력하되, 포인트를 내림차순으로 출력하시
SELECT name, age, addr
FROM MEMBER
WHERE age >= 30
ORDER BY age DESC ;


-- 3번 포인트가 200이상 250미만인 사람들의 모든 정보를 출력하시
select *
from member
where point BETWEEN 200 AND 250;


-- 4번 거주지가 서울인 사람의 모든 정보를 출력하시오.
SELECT * FROM MEMBER
WHERE addr LIKE '서울시';



-- 5번 거주지가 서울이거나 용인인 사람의 정보 이름과 주소 출력
select name , addr 
from MEMBER
WHERE addr = '서울시'
OR addr = '용인시';


-- 6번 거주지가 수원인 사람의 모든 정보를 출력하시오 
select *
from member
where addr LIKE '%수원시';


-- 7번 문제5번에서 조건식 in 연산자를 이용하여 풀어보시오
select name , addr
from member
where addr in('서울시', '용인시');


-- 8번 모든 사람의 이름과 나이가 출력되게 하세요, 출력시에는 name 대신 이름
-- age 대신 나이라고 컬럼명을 변경하여 출력하시오
SELECT name AS 이름, age AS 나이
FROM MEMBER;


-- 9번 문제8번 쿼리문을 실행 한 후 실제 테이블의 컬럼명도 바뀌었는지 확인하시오
SELECT * FROM MEMBER; -- 안바뀜


-- 10번 30대인 사람의 정보를 모두 출력하시오
SELECT * 
FROM ( SELECT * FROM MEMBER WHERE age >=30 )
WHERE age < 40;

SELECT * FROM MEMBER
WHERE age >= 30 AND age < 40;


-- 11번 포인트에 10% 사용가능(가용포인트)라고 할때 20포인트가 넘는 사람의
-- 이름 나이 실제포인트 가용포인트를 출력하시오
select name , age, point as 실제포인트, point*0.1 as 가용포인트
from member
where point >= 200;


-- 12번 포인트가 높은 순서대로 정렬하시오, 
-- 포인트가 같은 경우는 나이가 많은 순서가 우선입니다
SELECT name, point , age
FROM MEMBER 
ORDER BY point DESC , age DESC;
























