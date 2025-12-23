-------------------------------------------------------------------------------------------------------------
-- 					CREATE TABLE 쿼리 1. 회원 테이블 
-------------------------------------------------------------------------------------------------------------

CREATE TABLE CUSTOMER (     
	  cos_num NUMBER
	, cos_id varchar2(15)  NOT NULL
	, cos_name varchar2(10) NOT NULL
	, cos_pass varchar2(15) NOT NULL
	, cos_phone varchar2(13) 
	, cos_point NUMBER DEFAULT 0    
	
	, PRIMARY KEY (cos_num)  															
	, UNIQUE (cos_id) 				 													
);

SELECT * FROM customer;

/* 
	회원 포인트, 기본값은 0으로 함
	회원번호를 기본키로 설정 
	회원의 아이디가 중복되지 않도록 unique 제약조건 설정

*/
-------------------------------------------------------------------------------------------------------------
-- 					CREATE TABLE 쿼리 2. 영화 정보 테이블 
-------------------------------------------------------------------------------------------------------------

CREATE TABLE CUSTOMER (     
	  cos_num NUMBER
	, cos_id varchar2(15)  NOT NULL
	, cos_name varchar2(10) NOT NULL
	, cos_pass varchar2(15) NOT NULL
	, cos_phone varchar2(13) 
	, cos_point NUMBER DEFAULT 0  
	
	, PRIMARY KEY (cos_num)  			
	, UNIQUE (cos_id) 					
);

/*
 	회원 포인트, 기본값은 0으로 함
	회원번호를 기본키로 설정 
	회원의 아이디가 중복되지 않도록 unique 제약조건 설정
*/
-------------------------------------------------------------------------------------------------------------
-- 					CREATE TABLE 쿼리 3. 상영 정보 테이블 
-------------------------------------------------------------------------------------------------------------

CREATE TABLE SHOW_DAY (  				
	  sh_num NUMBER  					
	, sh_time DATE   					
	, sh_movien NUMBER NOT NULL			
	, mo_num NUMBER  					
	, CONSTRAINT show_pk 

	 PRIMARY KEY (sh_num) 				
	, FOREIGN KEY (mo_num) REFERENCES MOVIE(mo_num) 	
	, UNIQUE (sh_movien) 								
);

/*
 	상영정보, 일정번호, 상영시간, 상영관 번호,영화번호
 	일정 번호를 기본 키로 지정 하여 영화 번호를 영화 테이블의 영화 번로참조하는 외래키로 지정한다
 	상영관 번호는 중복되어선 안된다 
 */
------------------------------------------------------------------------------------------------------------- 
-- 					CREATE TABLE 쿼리 4. 영화관 정보 테이블  
-------------------------------------------------------------------------------------------------------------

CREATE TABLE MOVIE_ROUNGE (  								
	  ro_num	NUMBER   									
	, ro_seet	NUMBER CHECK ( ro_seet <= 200) 				
    , re_seet  	NUMBER NOT NULL 					

	, CONSTRAINT rounge_fk
	  FOREIGN KEY (ro_num) REFERENCES SHOW_DAY(sh_movien)	
);															

/*
	영화관
 	상영관 번호 , 총좌석 : 좌석은 200개가 넘지 않도록 제한 , 잔여좌석 
 	부모테이블인 SHOW_DAY의 sh_movien과 자식 테이블인 MOVIE_ROUNGE 외래키 지정
*/
-------------------------------------------------------------------------------------------------------------
 --					CREATE TABLE 쿼리 5. 예매 정보 테이블 
-------------------------------------------------------------------------------------------------------------

CREATE TABLE TICKETTING (  								 
	  ti_num	number	 								
	, sh_num	number									
	, cos_num	number									
	, ti_nop	NUMBER	NOT NULL						
	, CONSTRAINT ticket_pk
	    PRIMARY KEY (ti_num)		  					
	  , FOREIGN KEY (sh_num) REFERENCES SHOW_DAY (sh_num) ON DELETE SET NULL  								 
	  , FOREIGN KEY (cos_num) REFERENCES CUSTOMER (cos_num)	ON DELETE SET NULL  								
);														 
														 

/*
		예매 정보
		예매 번호 , 일정번호 , 회원 번호, 인원 수 
		예매 번호를 기본 키로 지정
		일정번호 외래외래키로 지정하며 부모 테이블인 SHOW_DAY	테이블에 정보 삭제 시 NULL로 보존
		회원번호 외래키 지정 부모 테이블인 CUSTOMER에 정보 삭제되더라도 NULL값으로 처리되며 정보유지 옵션지정
 */
-------------------------------------------------------------------------------------------------------------
-- 					CREATE TABLE 쿼리 6. 결제 정보 테이블 
-------------------------------------------------------------------------------------------------------------

CREATE TABLE PAY (  																					
       ti_num	number																			
     , py_type	varchar2(20)	CHECK															
        (py_type IN('카드', '삼성페이', '카카오페이', '애플페이', '네이버페이', '상품권'))  	
     , py_tot	number	DEFAULT 15000															
    	CONSTRAINT pay_fk FOREIGN KEY (ti_num) 	
			REFERENCES TICKETTING (ti_num) 														
			ON DELETE CASCADE																	
);																								

/*
		결제 정보
		예약 번호, 결제 방법, 결제 방법 입력 값 체크제약으로 제한 , 1인당 기본 티켓 금액, 15000원으로고정 
 		부모 테이블인 TICKETTING 테이블에 예매번호
 		삭제 시 자식 테이블인 PAY 테이블에도 정보가 삭제 될 수 있도록 옵션 추가
 */
 
SELECT * FROM pay;
-------------------------------------------------------------------------------------------------------------
-- 					CREATE TABLE 쿼리 7. 리뷰 정보 테이블  
-------------------------------------------------------------------------------------------------------------

CREATE TABLE REVIEW ( 				
	  mo_num	number				
	, re_text	varchar2(100)			
	, CONSTRAINT re_fk
	FOREIGN KEY (mo_num) REFERENCES MOVIE (mo_num) ON DELETE CASCADE 				
);						


/*
		리뷰 정보
		 부모 테이블인 MOVIE테이블에 영화 넘버가 삭제 시 = 영화 삭제
		 자녀 테이블인 Review테이블에 자료도 삭제될 수 있도록 옵션지정
		
*/
-------------------------------------------------------------------------------------------------------------
-- 					CREATE SEQUENCE 쿼리 1. 회원 번호 
-------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE CUSTOMER_no INCREMENT BY 1;

-------------------------------------------------------------------------------------------------------------
-- 					CREATE SEQUENCE 쿼리 2. 예매 번호 
-------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE TI_no INCREMENT BY 1;

-------------------------------------------------------------------------------------------------------------
-- 					CREATE SEQUENCE 쿼리 3. 일정 정보 번호 
-------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE show_day_seq INCREMENT BY 1;

-------------------------------------------------------------------------------------------------------------
-- 					INSERT 쿼리 1. 회원 정보 : 16개 
-------------------------------------------------------------------------------------------------------------

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

-------------------------------------------------------------------------------------------------------------
--					CREATE SEQUENCE 쿼리 2. 영화 정보 등록 : 6개 
-------------------------------------------------------------------------------------------------------------

INSERT INTO MOVIE VALUES (1,'통증', '권상우', '드라마', '곽경택' );
INSERT INTO MOVIE VALUES (2,'베니스 유령 살인사건', '케네스', '스릴러', '곽경택' );
INSERT INTO MOVIE VALUES (3,'천박사 퇴마 연구소', '강동원', '액션', '김성식' );
INSERT INTO MOVIE VALUES (4,'너의 이름은', '카미키', '애니', '신카이' );
INSERT INTO MOVIE VALUES (5,'쿵푸허슬', '주성치', '코미디', '주성치' );
INSERT INTO MOVIE VALUES (6,'박쥐', '송강호', '드라마', '박찬옥' );



-------------------------------------------------------------------------------------------------------------
 --					CREATE SEQUENCE 쿼리 3. 리뷰 정보 등록 60개  
-------------------------------------------------------------------------------------------------------------

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



-------------------------------------------------------------------------------------------------------------
 --					CREATE SEQUENCE 쿼리 4. 상영 정보  : 5개  
-------------------------------------------------------------------------------------------------------------

INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('20230913', 'YYYYMMDDHH24MISS'), 1, 1);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131530', 'YYYYMMDDHH24MISS'), 2 ,2);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131700', 'YYYYMMDDHH24MISS'), 3, 3);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 4, 4);
INSERT INTO SHOW_DAY(sh_num, sh_time, sh_movien, mo_num) VALUES(show_day_seq.nextval, to_date('202309131200', 'YYYYMMDDHH24MISS'), 5, 5);


-------------------------------------------------------------------------------------------------------------
 --					CREATE SEQUENCE 쿼리 5. 상영관 정보 : 5개  
-------------------------------------------------------------------------------------------------------------

INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet, re_seet) VALUES(1, 200, 200);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet, re_seet) VALUES(2, 150, 150);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet, re_seet) VALUES(3, 180, 180);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet, re_seet) VALUES(4, 150, 150);
INSERT INTO MOVIE_ROUNGE(ro_num, ro_seet, re_seet) VALUES(5, 200, 200);

-------------------------------------------------------------------------------------------------------------
-- 					CREATE SEQUENCE 쿼리 6. 예매 정보 : 19개 
-------------------------------------------------------------------------------------------------------------

insert into ticketting values (ti_no.nextval,1,1,4);
insert into ticketting values (ti_no.nextval,2,2,5);
insert into ticketting values (ti_no.nextval,4,3,1);
insert into ticketting values (ti_no.nextval,3,4,2);
insert into ticketting values (ti_no.nextval,5,5,6);
insert into ticketting values (ti_no.nextval,2,10,4);
insert into ticketting values (ti_no.nextval,5,11,4);
insert into ticketting values (ti_no.nextval,4,14,2);
insert into ticketting values (ti_no.nextval,5,15,3);
insert into ticketting values (ti_no.nextval,1,1,4);
insert into ticketting values (ti_no.nextval,2,2,5);
insert into ticketting values (ti_no.nextval,4,3,1);
insert into ticketting values (ti_no.nextval,3,4,2);
insert into ticketting values (ti_no.nextval,3,2,1);
insert into ticketting values (ti_no.nextval,5,11,4);
insert into ticketting values (ti_no.nextval,3,2,1);
insert into ticketting values (ti_no.nextval,5,11,4);
insert into ticketting values (ti_no.nextval,2,2,5);
insert into ticketting values (ti_no.nextval,2,2,5);


-------------------------------------------------------------------------------------------------------------
-- 					CREATE SEQUENCE 쿼리 7. 결제 정보 입력 19개 
-------------------------------------------------------------------------------------------------------------

insert into pay values (1 , '카드', DEFAULT);
insert into pay values (2,'카드',DEFAULT);
insert into pay values (3,'삼성페이',DEFAULT);
insert into pay values (4,'삼성페이',default);
insert into pay values (5,'카드',default);
insert into pay values (6,'카카오페이',default);
insert into pay values (7,'애플페이',default);
insert into pay values (8,'삼성페이',default);
insert into pay values (9,'상품권',default);
insert into pay values (10,'상품권',default);
insert into pay values (11,'네이버페이',default);
insert into pay values (12,'카드',default);
insert into pay values (13,'삼성페이',default);
insert into pay values (14,'삼성페이',default);
insert into pay values (15,'카드',default);
insert into pay values (16,'카카오페이',default);
insert into pay values (17,'애플페이',default);
insert into pay values (18,'삼성페이',default);
insert into pay values (19,'상품권',default);



-------------------------------------------------------------------------------------------------------------
-- 					TRIGGER 쿼리 1. 결제 완료 시 포인트 자동 증가 및 잔여 좌석차감 
-------------------------------------------------------------------------------------------------------------
-- TICKETTING 테이블에 새 행이 추가될 때마다 
-- CUSTOMER 테이블의 cos_point를 TICKETTING 테이블의 ti_nop의 명수만큼 포인트 * 100을 하고 
-- TICKETTING 테이블의 ti_nop의 명수만큼 MOVIE_ROUNGE 테이블의 ro_reseet를 자동 차감해주는 트리거 
-- 트리거 명 : upd_cos_point 

CREATE OR REPLACE TRIGGER upd_cos_point
AFTER INSERT ON TICKETTING
FOR EACH ROW
DECLARE
	cnt number;
	s_num number;
BEGIN
	cnt := :NEW.ti_nop;
	s_num := :NEW.sh_num;

-- 포인트 적립 기능
	UPDATE CUSTOMER
	SET cos_point = cos_point + 100 * cnt
	WHERE cos_num = :NEW.cos_num ;

-- 자동 잔여좌석 차감기능 
	UPDATE MOVIE_ROUNGE
	SET re_seet= re_seet-cnt
	WHERE ro_num=(select sh_movien from show_day where sh_num=s_num) ;
END;

-------------------------------------------------------------------------------------------------------------
-- 					TRIGGER 쿼리 2. 결제 취소 시 포인트 자동 차감 및 잔여 좌석 증가  
-------------------------------------------------------------------------------------------------------------
-- TICKETTING 테이블에서 행이 삭제될 때마다 실행되며, 
-- 삭제된 행의 정보를 사용하여 포인트를 복구하고 좌석을 복구합니다. 
-- 포인트는 삭제된 티켓 수에 100을 곱한 만큼 감소하고, 좌석은 삭제된 티켓 수만큼 증가합니다.
-- 트리거명 : upd_reset 

CREATE OR REPLACE TRIGGER upd_reset 
AFTER DELETE ON TICKETTING
FOR EACH ROW
DECLARE
    cnt number;
    s_num number;
BEGIN
    cnt := :OLD.ti_nop;
    s_num := :OLD.sh_num;

    -- 포인트 복구 기능
    UPDATE CUSTOMER
    SET cos_point = cos_point - 100 * cnt
    WHERE cos_num = :OLD.cos_num ;

    -- 자동 잔여좌석 복구 기능
    UPDATE MOVIE_ROUNGE
    SET re_seet = re_seet + cnt
    WHERE ro_num = (SELECT sh_movien FROM show_day WHERE sh_num = s_num);
END;



-------------------------------------------------------------------------------------------------------------
-- 					VIEW 쿼리 1. 결제 내역을 모아서 구성해놓은 뷰 쿼리  
-------------------------------------------------------------------------------------------------------------


CREATE OR REPLACE VIEW EW_pay_info
AS
 	SELECT p.ti_num T_NUM, c.cos_name T_NAMES , s.sh_time T_TIMES
        , m.mo_title M_TITLES , p.py_type P_TYPES , (t.ti_nop)*p.py_tot P_TOPAY
	FROM pay p
	JOIN ticketting t ON p.ti_num = t.ti_num
	JOIN customer c ON t.cos_num = c.cos_num
	JOIN show_day s ON t.sh_num = s.sh_num
	JOIN movie m ON s.sh_movien = m.mo_num ; 


SELECT * FROM EW_pay_info;

-------------------------------------------------------------------------------------------------------------
-- 					PROCEDURE 쿼리 1. pay 테이블의 결제 번호를  입력시 결제 정보 자동 호출 기능   
-------------------------------------------------------------------------------------------------------------

SET SERVEROUTPUT ON;  -- 출력창 활성화

-------------------------------------------------------------------------------------------------------------
--				PROCEDURE 쿼리 1. pay 테이블의 결제 번호를  입력시 결제 정보 자동 호출 기능   
-------------------------------------------------------------------------------------------------------------
/*											payProc 프로시저 설명 
 

CREATE 구문중 ()괄호 안에 있는 pay_no는 입력 파라미터 입니다.
특정 프로시저를 호출 할때 입력 받을 파라미터를 먼저 지정해 주어야 됩니다.
AS 구문 뒤에는 출력할 매개변수들의 데이터 타입과 변수명을 지정해 줍니다.
begin ~ end 사이의 구문은 실제 처리할 내용들을 적습니다.
select ~ into 구문을 사용하여 EM_pay_info 뷰
별칭 T_NUM, T_NAMES, T_TIMES, M_TITLES, P_TYPE, P_TOPAY를 각각
선언한 변수에 넣어줍니다.
DBMS_OUTPUT.PUT_LINE 을 사용 하여 해당 변수에 들어간 값을 출력하도록 지정해 놓습니다.
해당 프로시저를 사용할 때엔 지정해놓은 매개변수를 이용하여 
뷰의 T_NUM을 넣어주었을때 
해당 일치된 NUM의 결제정보를 화면에 출력해줍니다.
프로시저는 학원에서 배운 영역은 아니지만. 트리거와 자료를 찾다보니 알게되어 사용해 보았습니다.
저장 프로시저같은 경우 다른 외부 값을 받아 펑션처럼 처리도 할 수 있고
리턴값을 출력해주는 기능 등 다양한 기능이 있어 알아두면 좋을 것 같습니다
아직 해당 프로시저라는 개념을 100% 핸들링 하지는 못하지만 
이번 기회에 활용해보아서 너무 뿌듯합니다

*/-------------------------------------------------------------------------------------------------------------


CREATE OR REPLACE PROCEDURE payProc 
(
    pay_no IN EW_pay_info.T_NUM%TYPE
)
AS 
    v_payNUMBER NUMBER;
    v_payNAME varchar2(20);
    v_payTIME DATE;
    v_payTITLE varchar2(50);
    v_payTYPE varchar2(20);
    v_payTOPAY NUMBER;
begin
    SELECT T_NUM into v_payNUMBER from EW_pay_info WHERE T_NUM=pay_no;
    SELECT T_NAMES into v_payNAME from EW_pay_info WHERE T_NUM=pay_no;
    SELECT T_TIMES into v_payTIME from EW_pay_info WHERE T_NUM=pay_no;
    SELECT M_TITLES into v_payTITLE from EW_pay_info WHERE T_NUM=pay_no;
    SELECT P_TYPES into v_payTYPE from EW_pay_info WHERE T_NUM=pay_no;
    SELECT P_TOPAY into v_payTOPAY from EW_pay_info WHERE T_NUM=pay_no;
    
    DBMS_OUTPUT.PUT_LINE('-------- 결제 완료 --------');
    DBMS_OUTPUT.PUT_LINE('티켓번호 : ' || v_payNUMBER);
    DBMS_OUTPUT.PUT_LINE('회원이름 : ' || v_payNAME);
    DBMS_OUTPUT.PUT_LINE('상영날짜 : ' || v_payTIME);
    DBMS_OUTPUT.PUT_LINE('영화이름 : ' || v_payTITLE);
    DBMS_OUTPUT.PUT_LINE('결제타입 : ' || v_payTYPE);
    DBMS_OUTPUT.PUT_LINE('결제총액 : ' || v_payTOPAY);
END payProc ; 



-------------------------------------------------------------------------------------------------------------
--									기능 테스트 내용 
-------------------------------------------------------------------------------------------------------------
DELETE ticketting WHERE ti_num = 1;
-- 티켓테이블 / 예매번호 1번 삭제 / 일정번호 1번 삭제 / 회원번호 1 / 인원수 4명 

DELETE ticketting WHERE ti_num = 2;
-- 티켓테이블 / 예매번호 2번 삭제 / 일정번호 2번 삭제 / 회원번호 2 / 인원수 5명 
-- 티켓테이블의 예매번호 2번 삭제 시 pay 테이블에 있는 동일 예매번호 row도 삭제 확인 
-- 회원 기존 포인트 1,000에서 500으로 감소 확인
-- 상영관번호 2번 잔여좌석이 136개에서 141개로 증가 확인


EXEC payProc(7);

BEGIN
	payProc(3);
END;
-- 프로시저 호출 확인 


-- 다른 기능 테스트 ( 정상동작 확인용 문제 )
--1. 회원은 모두 몇명인가?
select count(*)
from customer;

--2. '나라'라는 이름을 가진 회원의 정보를 출력하시오.
select *
from customer
where cos_name like '%나라%';

--3. 이름에 '라' 가 들어가 있는 회원의 포인트 평균은?
select avg(cos_point)
from customer
where cos_name like '%라%';

--4. 500포인트 이상 소유하고 있는 회원들을 출력하시오.
select *
from customer
where cos_point >=500;

--5. 회원중 포인트를 가장 많이 소유하고 있는 회원의 정보를 출력하시오
select c.*
from customer c
where cos_point = (select max(cos_point) from customer);

--6. '나라' 라는 이름을 가진 회원 중 최대 포인트는 몇점인가?
select max(cos_point)
from customer
where cos_name like '%나라%';

select *
from customer;

--7. 회원의 정보를 출력하시오 단 비밀번호는 * 표로 출력하시오.
select cos_name,cos_id,rpad(substr(cos_pass,0,1),length(cos_pass),'*')
from customer;

--8. '삼성페이'로 결제하는 회원의 정보를 출력하시오
select c.*,p.*
from customer c
inner join ticketting t
on c.cos_num = t.cos_num
inner join pay p
on t.ti_num = p.ti_num
where p.py_type like '삼성페이';

--9. 결제방법 별로 예매한 건수는? 단 2건 이상의 결과만 출력하시오.
select p.py_type,count(*)
from customer c
inner join ticketting t
on c.cos_num = t.cos_num
inner join pay p
on t.ti_num = p.ti_num
group by p.py_type having count(*)>=2;

select py_type,count(*)
from pay
group by py_type having count(*)>=2;

--10. 영화를 예매하지 않은 회원의 정보를 출력하시오.
select c.*, t.*
from customer c
left outer join ticketting t
on c.cos_num = t.cos_num
where t.ti_num is null;

--11. 포인트가 높은 순서대로 4~6위까지 회원의 정보를 출력하시오
select *
from(
select rownum rn,c.*
from(
select * from customer c order by cos_point desc)c)c1
where rn between 4 and 6;

--12. 영화 제목이 박쥐이다 이 영화의 정보와 리뷰를 출력하시오.
select *
from movie m
inner join review r
on m.mo_num = r.mo_num
where mo_title like '박쥐';

--13. 영화별 예매 건수를 구하시오 단, 예매 건수가 3건이상인 영화만 출력하시오.
select m.mo_title,count(*)
from movie m
inner join show_day s
on m.mo_num = s.mo_num
inner join ticketting t
on s.sh_num = t.sh_num
inner join pay p
on t.ti_num = p.ti_num
group by m.mo_title having count(*)>=3;

select m.mo_title,count(*)
from movie m, show_day s, ticketting t, pay p
where m.mo_num = s.mo_num and s.sh_num = t.sh_num and t.ti_num = p.ti_num
group by m.mo_title having count(*)>=3;

--14. 장르가 애니인 영화를 예매한 사람들의 수를 구하시오
select m.mo_gen, count(*)
from movie m
inner join show_day s
on m.mo_num = s.mo_num
inner join ticketting t
on s.sh_num = t.sh_num
inner join customer c
on t.cos_num = c.cos_num
where m.mo_gen = '애니'
group by m.mo_gen;

--15. 장르가 드라마인 영화의 리뷰를 출력하시오
select *
from movie m
inner join review r
on m.mo_num = r.mo_num
where m.mo_gen = '드라마';

--16. 결제한 방법별로 회원들의 포인트의 평균을 구하시오
select p.py_type, avg(c.cos_point)
from customer c
inner join ticketting t
on c.cos_num = t.cos_num
inner join pay p
on t.ti_num = p.ti_num
group by p.py_type;