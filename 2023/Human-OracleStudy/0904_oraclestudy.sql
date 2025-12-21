CREATE TABLE BOOK(
	  book_id number(10) PRIMARY KEY
	, book_title varchar2(50)
	, pub_date DATE
	, author varchar2(50) 
	, publisher varchar2(50)
	, reg_date DATE
);


CREATE TABLE CUSTOMER (
	  customer_id varchar2(20) PRIMARY key
	, customer_name varchar2(50) NOT NULL
	, password varchar(20) NOT NULL
	, phone_number varchar2(20)
	, member_type varchar2(10) CHECK (member_type IN('학생', '성인'))
	, point number(10) DEFAULT 100
	, join_date DATE
);

CREATE TABLE RENTAL (
	  rental_id number(10) 
	, customer_id varchar2(20) 
	, book_id number(10)
	, rental_date DATE
	, return_date DATE
	, CONSTRAINT rental_pk
		  PRIMARY KEY (rental_id)
		, FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id) ON DELETE SET NULL
		, FOREIGN KEY (book_id) REFERENCES BOOK(book_id) ON DELETE CASCADE
);


CREATE TABLE REVIEW(
	  customer_id varchar2(20)
	, book_id number(10)
	, book_title varchar2(50)
	, review_text varchar2(500)
	, review_date DATE
	, CONSTRAINT review_fk 
		  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id) ON DELETE SET NULL 
		, FOREIGN KEY (book_id) REFERENCES BOOK(book_id) ON DELETE CASCADE
);



CREATE SEQUENCE book_seq START WITH 1 nocycle;
CREATE SEQUENCE rental_seq START WITH 1 nocycle;

CREATE OR REPLACE TRIGGER point_trigger
AFTER INSERT ON RENTAL
FOR EACH ROW
DECLARE
    v_customer_id rental.customer_id%TYPE;
BEGIN
    -- 새로 삽입된 행의 customer_id 값을 가져옴
    v_customer_id := :NEW.customer_id;

    -- customer 테이블의 point 값을 100씩 증가
    UPDATE customer
    SET point = point + 100
    WHERE customer_id = v_customer_id;
END;


-- Book Insert -- 
INSERT INTO BOOK VALUES (book_seq.nextval,'태백산맥',TO_DATE('2020-10-15', 'YYYY-MM-DD'), '조정래', '해냄', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'총균쇠',TO_DATE('2005-12-19', 'YYYY-MM-DD'), '재레드다이아몬드', '허블', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'데미안',TO_DATE('2000-12-20', 'YYYY-MM-DD'), '헤르만헤세', '민음사', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'사피엔스', TO_DATE('2015-11-23', 'YYYY-MM-DD'), '유발하라리', '김영사', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'누가 내 치즈를 옮겼을까',TO_DATE('2015-05-08', 'YYYY-MM-DD'), '스펜서존슨', '진명출판사', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'세이노의 가르침 ',TO_DATE('2023-02-02', 'YYYY-MM-DD'), '세이노', '데이원', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'지능의 역설 ',TO_DATE('2020-05-21', 'YYYY-MM-DD'), '가나자와사토시', '데이원', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'프로스트와 베타 ',TO_DATE('2023-07-20', 'YYYY-MM-DD'), '로저 젤라즈니', '데이원', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'태백산맥',TO_DATE('2020-10-15', 'YYYY-MM-DD'), '조정래', '해냄', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'총균쇠',TO_DATE('2005-12-19', 'YYYY-MM-DD'), '재레드다이아몬드', '허블', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'데미안',TO_DATE('2000-12-20', 'YYYY-MM-DD'), '헤르만헤세', '민음사', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'태백산맥',TO_DATE('2020-10-15', 'YYYY-MM-DD'), '조정래', '해냄', SYSDATE);
INSERT INTO BOOK VALUES (book_seq.nextval,'총균쇠',TO_DATE('2005-12-19', 'YYYY-MM-DD'), '재레드다이아몬드', '허블', SYSDATE);




-- CUSTOMER INSTERT --

INSERT INTO CUSTOMER VALUES ('HwaseongE','화성이', '232323**', '010-0000-0078', '성인', DEFAULT, TO_DATE('2022-01-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('DregonE','용인이', '456721*', '010-5656-5656', '학생', DEFAULT, TO_DATE('2008-01-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('SeoulE','서울이', '4232451*', '010-5432-1256', '성인', DEFAULT, TO_DATE('2021-01-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('SamchukE','삼척이', '414515*', '010-2222-1111', '학생', DEFAULT, TO_DATE('2001-12-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('MokpoE','모포이', '424515*', '010-2341-1651', '학생', DEFAULT, TO_DATE('2010-02-27', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('InchonE','인촌', '41231515*', '010-0012-2221', '학생', DEFAULT, TO_DATE('2008-07-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER VALUES ('SuwonE','수원이', '12345678*', '010-1234-5678', '학생', DEFAULT, TO_DATE('2021-01-01', 'YYYY-MM-DD'));



-- RENTAL INSERT --
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '화성이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '3' ), TO_DATE('2023-01-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-02-01', 'YYYY-MM-DD'));
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name ='수원이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '4' ), TO_DATE('2023-02-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-12-01', 'YYYY-MM-DD'))


INSERT INTO  RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '삼척이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '1' ), TO_DATE('2000-01-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-12-01', 'YYYY-MM-DD'));
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '모포이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '2' ), TO_DATE('2022-01-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-02-01', 'YYYY-MM-DD'));
	
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '삼척이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '3' ), TO_DATE('2000-01-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-02-01', 'YYYY-MM-DD'));
		
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '화성이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '6' ), TO_DATE('2021-02-05', 'YYYY-MM-DD'), 
		 TO_DATE('2023-01-01', 'YYYY-MM-DD'));
		
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name = '화성이' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '5' ), TO_DATE('2023-01-05', 'YYYY-MM-DD'), 		 
		 TO_DATE('2023-02-01', 'YYYY-MM-DD'));
		
INSERT INTO RENTAL (rental_id,customer_id, book_id, rental_date, return_date) 
	VALUES (rental_seq.nextval,
		(SELECT customer_id FROM CUSTOMER WHERE customer_name ='인촌' ), 
		(SELECT book_id FROM BOOK WHERE book_id = '5' ), TO_DATE('2023-01-05', 'YYYY-MM-DD'), 		 
		 TO_DATE('2023-02-01', 'YYYY-MM-DD'));

SELECT * FROM rental;

-- REVIEW INSERT --


INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '화성이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '8' ), 
		(SELECT book_title FROM BOOk WHERE book_id = '8'),
		'완전 재밌어요, 재밌게 봤습니다', TO_DATE('2023-01-05', 'YYYY-MM-DD'));	

INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '인촌' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '1' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '1' ),
		'완전 재밌어요, 재밌게 봤습니다2', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
	
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '화성이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '2' ),
		(SELECT book_title FROM BOOK WHERE book_id = '2' ),
		'완전 재밌어요, 재밌게 봤습니다3', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
			
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '화성이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '3' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '3' ), 
		'완전 재밌어요, 재밌게 봤습니다5', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
	
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '화성이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '4' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '4' ), 
		'완전 재밌어요, 재밌게 봤습니다6', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
INSERT INTO REVIEW (customer_id , book_id, book_title,review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '화성이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '7' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '7' ),
		'완전 재밌어요, 재밌게 봤습니다7', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '서울이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '9' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '9' ),
		'완전 재밌어요, 재밌게 봤습니다7', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
	
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '용인이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '10' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '10' ),
		'완전 재밌어요, 재밌게 봤습니다7', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name = '모포이' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '11' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '11' ),
		'완전 재밌어요, 재밌게 봤습니다7', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
INSERT INTO REVIEW (customer_id , book_id, book_title, review_text, review_date)
	VALUES (
		(SELECT customer_id FROM CUSTOMER WHERE CUSTOMER_name ='인촌' ) ,
		(SELECT book_id FROM BOOK WHERE book_id = '11' ), 
		(SELECT book_title FROM BOOK WHERE book_id = '11' ),
		'완전 재밌어요, 재밌게 봤습니다7', TO_DATE('2023-01-05', 'YYYY-MM-DD'));
	


SELECT DISTINCT C.CUSTOMER_NAME, C.POINT, B.RENTAL_DATE
FROM customer C 
    JOIN rental B
    ON C.customer_ID = B.CUSTOMER_ID ;
 

   
SELECT * FROM customer;
SELECT * FROM book;
SELECT * FROM rental;
SELECT * FROM review;

DROP TABLE rental;
DROP TABLE review;
DROP TABLE BOOK;
DROP TABLE customer;
DROP SEQUENCE book_seq;
DROP SEQUENCE review_seq;

COMMIT;
	
		


   
    


