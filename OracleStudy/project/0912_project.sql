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
		, mo_actor	varchar2(20) NOT NULL
	  	, mo_gen	varchar2(15) CHECK 
	  				(mo_gen IN('로맨스', 'SF', '액션', '스릴러', '드라마', '코미디', '판타지', '애니'))
		, mo_super	varchar2(20) NOT NULL
);

CREATE TABLE SHOW_DAY (
		  sh_num NUMBER
		, sh_time DATE
		, sh_movien NUMBER
		, mo_num NUMBER
		, CONSTRAINT show_pk
			  PRIMARY KEY (sh_num)
			, FOREIGN KEY (mo_num) REFERENCES MOVIE(mo_num)
);


CREATE TABLE MOVIE_ROUNGE (
		  ro_num	NUMBER  PRIMARY KEY	
		, ro_seet	NUMBER CHECK ( ro_seet <= 200) 
);


CREATE TABLE TICKETTING (
		  ti_num	number	
		, sh_num	number	
		, cos_num	number	
		, ti_nop	NUMBER DEFAULT 15000
		, CONSTRAINT ticket_pk
			  PRIMARY KEY (ti_num)
			, FOREIGN KEY (sh_num) REFERENCES SHOW_DAY (sh_num) ON DELETE SET NULL 
			, FOREIGN KEY (cos_num) REFERENCES CUSTOMER (cos_num) ON DELETE SET NULL 
);


CREATE TABLE PAY (
		  ti_num	number	
		, py_type	varchar2(20)	CHECK 
					(py_type IN('카드', '삼성페이', '카카오페이', '애플페이', '네이버페이', '상품권'))
		, py_tot	number	DEFAULT 15000
		, py_money	number  
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
-- 일정번호 시퀀스
CREATE SEQUENCE show_day_seq INCREMENT BY 1;
DROP SEQUENCE show_day_seq;

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





-- 회원 정보 16개 --
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abccddfg','김나라','**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'a42141','밤나라', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcsdfafg','강나라', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aasd124ddfg','집가라', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'233fscbg','최춘식', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'ab5dssg','이도용', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abccssdkkdfg','홍도도', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSdfsddfg','추마을', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'Gsfdddfg','서마은', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcSdf','솔방울', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSdfsfg','하도녀', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSDsfsdfg','박신령', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aGssssgdfg','주도용', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'gsdfsdf','최범죄', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'aSDsfafg','옥도시', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abSDdsafsg','반나라', '**123456**', '010-0101-0202', DEFAULT );
INSERT INTO CUSTOMER VALUES (customer_no.NEXTval ,'abcgggg','민나라', '**123456**', '010-0101-0202', DEFAULT );


-- 영화 정보 등록 --
-- '로맨스', 'SF', '액션', '스릴러', '드라마', '코미디', '판타지', '애니'
INSERT INTO MOVIE VALUES (1,'통증', '권상우', '드라마', '곽경택' );
INSERT INTO MOVIE VALUES (2,'베니스 유령 살인사건', '케네스', '스릴러', '곽경택' );
INSERT INTO MOVIE VALUES (3,'천박사 퇴마 연구소', '강동원', '액션', '김성식' );
INSERT INTO MOVIE VALUES (4,'너의 이름은', '카미키', '애니', '신카이' );
INSERT INTO MOVIE VALUES (5,'쿵푸허슬', '주성치', '코미디', '주성치' );
INSERT INTO MOVIE VALUES (6,'박쥐', '송강호', '드라마', '박찬옥' );



-- 리뷰 정보 등록 -- 
INSERT INTO REVIEW VALUES (1,'정말 재밌네요');
INSERT INTO REVIEW VALUES (1,'정말 재미없어요');
INSERT INTO REVIEW VALUES (1,'돈 아깝네요');
INSERT INTO REVIEW VALUES (2,'세 시간이 지나는줄 모르고 집중했습니다.');
INSERT INTO REVIEW VALUES (2,'등장인물이 많아서 좀 버거웠어요');
INSERT INTO REVIEW VALUES (2,'지루한건 나뿐인가... 극장이라 다 봄');
INSERT INTO REVIEW VALUES (2,'영화는 재밌다만.. 감독은 크게 발전 없는 느낌');
INSERT INTO REVIEW VALUES (3,'처음부터 몰입해서 보느라 3시간이 생각 안났어요.');
INSERT INTO REVIEW VALUES (3,'보는 내내 착잡한 기분이 든 영화');
INSERT INTO REVIEW VALUES (3,'얼굴 구분 어려움 있는분들은 좀 힘들어요');
INSERT INTO REVIEW VALUES (3,'주인공 연기가 인상 깊음');
INSERT INTO review VALUES (3,'단 한 장면도 CG 사용되지 않았다!!');
INSERT INTO review VALUES (3,'너무나도 재밋어요 오랜만에 신나게 웃었어요');
INSERT INTO review VALUES (1,'무엇이 국익을 위한 일인가');
INSERT INTO review VALUES (2,'폭탄을 소재로 폭탄을 터뜨리는듯 플롯을 짠 야심작');
INSERT INTO review VALUES (4,'아는만큼 보이는 영화 연출이 좋았다.');
INSERT INTO review VALUES (2,'너무 재밌어서 또 보고싶음');
INSERT INTO review VALUES (1,'3시간 동안 밀도가 뺵빽한데도 지루할 틈이 없었다.');
INSERT INTO review VALUES (3,'극장 팝콘이 맛나요');
INSERT INTO review VALUES (5,'다큐영화 같았네요 지루함.');
INSERT INTO review VALUES (6,'음악과 연출이 좋았어요.');
INSERT INTO review VALUES (6,'드디어 인간의 감정을 다룰줄 알게 된 누룽지');
INSERT INTO review VALUES (6,'마치 3시간이 30분 같았다.');
INSERT INTO review VALUES (1,'한 인간의 인생사로서 이 영화는 너무나 아름답고 경이롭다.');
INSERT INTO review VALUES (6,'비범한 사람이 평범해지는 과정');
INSERT INTO review VALUES (6,'지난 주말 극장가서 잘 보고왔다');
INSERT INTO review VALUES (4,'삼성이 이 영화를 좋아하지 않습니다.');
INSERT INTO review VALUES (3,'배우들 연기만으로 볼 가치가 있다.');
INSERT INTO review VALUES (1,'걍 봐바 걍 봐');
INSERT INTO review VALUES (5,'핸드폰에 우리의 모든 삶이 다 있다.');
INSERT INTO review VALUES (5,'코믹하면서도 생각 해볼만한 내용이 많은 영화!');
INSERT INTO review VALUES (3,'가볍게 즐길 수만은 없었던 블랙코미디');
INSERT INTO review VALUES (4,'꿀잼입니당 완전 꿀꿀잼이에용');
INSERT INTO review VALUES (6,'유쾌하면서 다른의미로 많은 생각을 하게되네요');
INSERT INTO review VALUES (4,'보는 내내 불안불안함');
INSERT INTO review VALUES (4,'어후 스트레스 받아....');
INSERT INTO review VALUES (5,'생각없이 봤는데 재밌네요');
INSERT INTO review VALUES (1,'진짜 죽는줄 ㅋㅋㅋ 나였으면...');
INSERT INTO review VALUES (2,'정말 많이 웃고왔어요... 그래도 한번쯤 생각하게 되는 영화였어요');
INSERT INTO review VALUES (3,'조아용ㅎㅎㅎ 재밌었어요');
INSERT INTO review VALUES (5,'재미로만 보면 이 영화가 천만 영화가 되어야 마땅하다.');
INSERT INTO review VALUES (3,'다들 연기 잘하고 재미있게 봐써용');
INSERT INTO review VALUES (4,'남자친구와 처음 본 영화인데 재밌었어요');
INSERT INTO review VALUES (4,'엄마랑 편하게 재밌게 봤어요');
INSERT INTO review VALUES (2,'연극으로 올려도 재밌을것같다.');
INSERT INTO review VALUES (5,'누구나 감추고싶은 비밀이 있다');
INSERT INTO review VALUES (3,'김가율 감독님 멋있어요');
INSERT INTO review VALUES (4,'좁은공간에서 어떻게 이런 연출을 하는지 대단.. 꿀잼');
INSERT INTO review VALUES (5,'배우들 연기가 좋아서 몰입이 잘됐어요.');
INSERT INTO review VALUES (1,'기아타이거즈 화이팅');
INSERT INTO review VALUES (2,'케이티위즈 화이팅');
INSERT INTO review VALUES (3,'고동현 배우 너무너무 재밌네요');
INSERT INTO review VALUES (6,'소원 배우의 연기력 너무너무 좋았어요');
INSERT INTO review VALUES (1,'독특한 소재여서 흥미로움');
INSERT INTO review VALUES (3,'장면 하나하나 다 터졌네요');
INSERT INTO review VALUES (5,'다 똑같은 세상을 살고있겠찌?');
INSERT INTO review VALUES (3,'동현 배우님 너무 굿이에요 긋긋긋');
INSERT INTO review VALUES (2,'김가율 배우의 감정연기의 끝은 어디까지인가...');
INSERT INTO review VALUES (4,'긴장감있고 잼나게 보았네요');
INSERT INTO review VALUES (6,'인간이 얼마나 쓰레기인지 잘 보여준 영화');




-- 상영 정보 입력 --
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('20230913', 'YYYYMMDDHH24MISS'), 1, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131530', 'YYYYMMDDHH24MISS'), 1, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131700', 'YYYYMMDDHH24MISS'), 1, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'),2, 2);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 2, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 3, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 3, 2);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 3, 3);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309142200', 'YYYYMMDDHH24MISS'), 4, 4);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309141400', 'YYYYMMDDHH24MISS'), 4, 5);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309141600', 'YYYYMMDDHH24MISS'), 4, 6);




-- 영화관 정보 입력 --
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet) VALUES(1, 200);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet) VALUES(2, 150);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet) VALUES(3, 180);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet) VALUES(4, 150);



-- 예매 정보 입력 --
insert into ticketting values (ti_no.nextval,1,1,4);
insert into ticketting values (ti_no.nextval,2,2,5);
insert into ticketting values (ti_no.nextval,4,3,1);
insert into ticketting values (ti_no.nextval,3,4,2);
insert into ticketting values (ti_no.nextval,5,5,6);
insert into ticketting values (ti_no.nextval,7,6,3);
insert into ticketting values (ti_no.nextval,7,7,2);
insert into ticketting values (ti_no.nextval,10,8,2);
insert into ticketting values (ti_no.nextval,11,9,1);
insert into ticketting values (ti_no.nextval,2,10,4);
insert into ticketting values (ti_no.nextval,5,11,4);
insert into ticketting values (ti_no.nextval,9,12,2);
insert into ticketting values (ti_no.nextval,8,13,5);
insert into ticketting values (ti_no.nextval,4,14,2);
insert into ticketting values (ti_no.nextval,5,15,3);
insert into ticketting values (ti_no.nextval,7,16,2);





-- 결제 정보 입력 --
insert into pay values (1,'카드',DEFAULT, 0);
insert into pay values (2,'카드',DEFAULT, 0);
insert into pay values (3,'삼성페이',DEFAULT, 0);
insert into pay values (1,'카드',DEFAULT, 0);
INsert into pay values (2,'카드',DEFAULT, 0);
insert into pay values (3,'삼성페이',DEFAULT, 0);
insert into pay values (1,'카드',DEFAULT, 0);
insert into pay values (2,'카드',DEFAULT, 0);
insert into pay values (3,'삼성페이',DEFAULT, 0);
insert into pay values (4,'삼성페이',default, 0);
insert into pay values (5,'카드',default, 0);
insert into pay values (6,'카카오페이',default, 0);
insert into pay values (7,'애플페이',default, 0);
insert into pay values (8,'삼성페이',default, 0);
insert into pay values (9,'상품권',default, 0);
insert into pay values (10,'상품권',default, 0);
insert into pay values (11,'네이버페이',default, 0);
insert into pay values (12,'카드',default, 0);
insert into pay values (13,'삼성페이',default, 0);
insert into pay values (14,'카드',default, 0);
insert into pay values (15,'애플페이',default, 0);
insert into pay values (16,'카드',default, 0);



