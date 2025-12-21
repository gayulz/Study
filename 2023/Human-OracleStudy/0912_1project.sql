CREATE TABLE CUSTOMER (
	  cos_num	NUMBER 
	, cos_id	varchar2(15) 
	, cos_name	varchar2(10)
	, cos_pass	varchar2(15) 
	, cos_phone	varchar2(13) 
	, cos_point	NUMBER	DEFAULT 0 
	, PRIMARY KEY (cos_num)
	, UNIQUE (cos_id)
);


CREATE TABLE MOVIE (
	      mo_num	NUMBER	PRIMARY KEY
		, mo_title	varchar2(50) NOT NULL
		, mo_actor	varchar2(10) NOT NULL
	  	, mo_gen	varchar2(15) CHECK (mo_gen IN('로멘스', 'SF', '액션', '호러', '드라마', '코미디', '판타지'))
		, mo_super	varchar2(15) NOT NULL
);


CREATE TABLE SHOW_DAY (
		  sh_num	NUMBER 
		, sh_time	DATE
		, sh_movien	NUMBER
		, mo_num	NUMBER
		, CONSTRAINT show_pk
			  PRIMARY KEY (sh_num)
			, FOREIGN KEY (mo_num) REFERENCES MOVIE(mo_num) 
);


CREATE TABLE MOVIE_ROUNGE (
		  ro_num	NUMBER  PRIMARY KEY	
		, ro_seet	NUMBER CHECK ( ro_seet >= 200) 
);


CREATE TABLE TICKETTING (
		  ti_num	number	
		, sh_num	number	
		, cos_num	number	
		, ti_nop	number	
		, CONSTRAINT ticket_pk
			  PRIMARY KEY (ti_num)
			, FOREIGN KEY (sh_num) REFERENCES SHOW_DAY (sh_num) ON DELETE SET NULL 
			, FOREIGN KEY (cos_num) REFERENCES CUSTOMER (cos_num) ON DELETE SET NULL 
);


CREATE TABLE PAY (
		  ti_num	number	
		, py_type	varchar2(7)	CHECK (py_type IN('카드', '삼성페이', '카카오페이', '애플페이', '네이버페이', '상품권'))
		, py_minus	varchar2(7)	CHECK (py_minus IN('SKT', 'KT', 'LG'))
		, py_tot	number	NOT NULL
		, py_min	number	NOT NULL
		, CONSTRAINT pay_fk
			FOREIGN KEY (ti_num) REFERENCES TICKETTING (ti_num)
);



CREATE TABLE REVIEW (
		  mo_num	number	
		, re_text	varchar2(100)	
		, CONSTRAINT re_fk
			FOREIGN KEY (mo_num) REFERENCES MOVIE (mo_num) ON DELETE CASCADE 
);


-- 회원ID용 시퀀스 
CREATE SEQUENCE CUSTOMER_no INCREMENT BY 1;
DROP SEQUENCE customer_no;
-- 예매번호 시퀀스 
CREATE SEQUENCE TI_no INCREMENT BY 1;
DROP SEQUENCE TI_no;

## 	코멘트 적용
COMMENT ON TABLE CUSTOMER IS '회원정보';
COMMENT ON TABLE MOVIE IS '영화정보';
COMMENT ON TABLE SHOW_DAY IS '상영정보';
COMMENT ON TABLE TICKETTING IS '예매정보';
COMMENT ON TABLE PAY IS '결제정보';
COMMENT ON TABLE REVIEW IS '리뷰정보';



SELECT * FROM customer;
SELECT * FROM movie;
SELECT * FROM show_day;
SELECT * FROM ticketting;
SELECT * FROM pay;
SELECT * FROM review;
SELECT * FROM MOVIE_ROUNGE;


DROP TABLE TICKETTING;
DROP TABLE pay;
DROP TABLE review;
DROP TABLE customer;
DROP TABLE movie;
DROP TABLE SHOW_DAy;
DROP TABLE MOVIE_ROUNGE;




INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abccddfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'a42141','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcsdfafg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aasd124ddfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'233fscbg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'ab5dssg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abccssdkkdfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSdfsddfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'Gsfdddfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcSdf','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSdfsfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSDsfsdfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aGssssgdfg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'gsdfsdf','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSDsfafg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abSDdsafsg','**123456**', '010-0101-0202', DEFAULT );

INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcgggg','**123456**', '010-0101-0202', DEFAULT );




