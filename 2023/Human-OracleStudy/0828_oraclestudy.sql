-- 8월 28일
-- 오라클수업자료 실습

--철수는 상품을 등록하는 테이블을 구축한다.	
--다음 조건에 맞게 테이블을 만드시오	
--(주의) 컬럼명과 테이블 명은 영문으로 지정하시오	
--	
--1.상품의 아이디가 있어야 한다 , 아이디는 4글자	
--2. 상품명이 있어야 한다, 상품명은 한글로 최대 6글자	
--3. 상품의 수량이 있어야 한다.  수량은 기본 값이 10개 이다.	
--4. 상품의 상태가 있어야 한다. 기본값은 양호이다	
--관리자명이 있어야 한다 , 관리자명은 한글로 최대 3글자	
--상품명은 반드시 입력해야한다.	
--아이디는 중복 될 수 없다.	
--	
--샘플로 상품 2개를 입력하세요	
--입력된 상품을 모두 확인해 보세요	
--	
--	
--1. 개체찾기	
--	상품/상품아이디/상품명/수량/상태/관리자명
--	
--2. 제약조건 찾기	
--	상품 아이디는 - 4글자 / 한영기재 없음, 8byte로 잡으면 됨 / primary key
--	상품명 - 한글로 최대 6글자 / 12byte로 잡으면 됨 not null
--	수량 - 기본값 10개 default
--	상태 - 기본값 '양호' , check 으로 ('양호', '불량', '폐기') 
--	관리자명 - 한글 최대3글자 / 16byte로 잡으면됨
	
CREATE TABLE Item (
	Item_id varchar2(8) primary key,
	Item_name varchar2(12) NOT NULL , 
	Item_cnt number(20) default 10 , 
	Item_cundistion varchar2(8) default ('양호') check(Item_cundistion IN('양호','불량','폐기')) , 
	manager varchar2(12)
);
	
insert into Item VALUES ('1', '화장품', default, default,'김씨네'); 


SELECT * FROM Item;


--자동차 번호 관리기 테이블을 생성하시오	
--	자동차 번호는 xx마1234 형식으로 저장하여 중복 될 수 없다 - 가
--	자동차 소유자의 이름, 이름은 한글로 5글자까지 가능  - 나
--	자동차년식은 연도 앞자리 4자리만 가능 - 다
--	벌점, 벌점은 기본값 0점 - 라
--	
--가 기능을 증명할 수 있는 예제 쿼리문을 작성하시오.	
--나 기능을 증빙할 수 있는 예제 쿼리문을 작성하시오.	
--다 기능을 증빙할 수 있는 예제 쿼리문을 작성하시오	
--	
--자동차번호 관리기	
--자동차 번호는 xx마1234 형식으로 저장하며 중복될 수 없다	
--자동차 소유자의 이름, 이름은 한글로 5글자까지 가능	
--자동차 연식은 년도 앞자리 4자리만 가능	
--벌점, 벌점은 기본값 0점	
--구분, 기본값 소형차	
--종류, 종류에 입력될 수 있는 값은 suv, rv, 승용, 기타 중에 하나임	
--입력날짜 시스템이 있는 날짜를 자동으로 입력하게 하며 년월일시분초가 입력된다.	


CREATE TABLE CAR (
	car_number VARCHAR2(10) CONSTRAINT unique_car_number UNIQUE,
	CONSTRAINT format_car_number 
	CHECK (REGEXP_LIKE(car_number, '^[A-Z]{2}[가-힣]{1}\d{4}$')),
	Oner_name varchar2(20) ,
	Car_year varchar2(4) ,
	Penalty int default 0 ,
	Car_Distinguish varchar2(15) DEFAULT '소형차' , 
	Car_Type varchar(8) check (Car_Type IN('suv', 'rv', '승용', '기타') ),
	Car_pop TIMESTAMP DEFAULT sysdate
);

SELECT * FROM CAR;
DROP TABLE car;

INSERT INTO CAR VALUES ('xx마1234','모닝','1991',DEFAULT,DEFAULT,'기타',DEFAULT);
INSERT INTO CAR VALUES ('봉봉','케이파이브','2020',DEFAULT,DEFAULT,'승용',DEFAULT);


