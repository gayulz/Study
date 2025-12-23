기본 OUT 변수 활용하기


SELECT * FROM customer;
/*
CREATE OR REPLACE PROCEDURE run_roc1
(
	p_message OUT varchar2
--	d_message OUT varchar2
)
IS
BEGIN
	p_message := '출력하라';
--	dbms_output.put_line('호출완료');
END;

DECLARE
out_message varchar2(100);
BEGIN
	run_roc1(out_message);
	dbms_output.put_line(out_message);
END;


팝업띄울내용
1. 예매번호
2. 고객이름 
3. 상영시간
4. 영화이름 
5. 인원수
6. 결제정보

pay 테이블에 새로운 행이 INSERT되면
pay 테이블에 ti_num 번호와 ticketting의 ti_num이 일치하는 사람이 결제한 정보를 
출력하는 프로시저 

1. 예매번호 (pay 테이블의 ti_num 컬럼 데이터 )
2. 고객이름 (coustomer테이블의 cos_name 컬럼 데이터  )
3. 상영시간 (show_day테이블의 sh_time컬럼 데이터  )
4. 영화이름 (movie 테이블의 mo_title컬럼 데이터  )
5. 인원수 * 티켓금액 = 총금액 ( pay 테이블에 py_tot 컬럼과 ticketting 컬럼의 ti_nop가 곱셈 )
6. 결제정보 ( pay 테이블에 py_type 컬럼 데이터 )


CREATE OR REPLACE PROCEDURE show_payment_info
(
	P_PARA_1 IN NUMBER;
)
IS
	
	payment NUMBER := P_PARA_1;
	
BEGIN
    FOR payment IN (SELECT p.ti_num, c.cos_name, s.sh_time, m.mo_title, p.py_tot, p.py_type
                    FROM pay p
                    JOIN ticketting t ON p.ti_num = t.ti_num
                    JOIN customer c ON t.cos_num = c.cos_num
                    JOIN show_day s ON t.sh_num = s.sh_num
                    JOIN movie m ON s.sh_movien = m.mo_num)
    LOOP
        DBMS_OUTPUT.PUT_LINE('예매번호: ' || payment.ti_num);
        DBMS_OUTPUT.PUT_LINE('고객이름: ' || payment.cos_name);
        DBMS_OUTPUT.PUT_LINE('상영시간: ' || payment.sh_time);
        DBMS_OUTPUT.PUT_LINE('영화이름: ' || payment.mo_title);
        DBMS_OUTPUT.PUT_LINE('총금액: ' || payment.py_tot * payment.ti_nop);
        DBMS_OUTPUT.PUT_LINE('결제정보: ' || payment.py_type);
        DBMS_OUTPUT.PUT_LINE('----------------------------------');
    END LOOP;
END;


-------------------------

CREATE OR REPLACE PROCEDURE paysystem_info
(
	p_message out varchar2(100) , 
	pay_num out NUMBER , 
	pay_name out varchar2(10) , 
	pay_time out DATE, 
	pay_title OUT varchar2(50) , 
	pay_tot out NUMBER , 
	pay_type out varchar2(20)
)
IS
	
BEGIN
	SELECT p.ti_num, c.cos_name, s.sh_time, m.mo_title, p.py_tot, p.py_type, t.TI_NOP
	FROM pay p
	JOIN ticketting t ON p.ti_num = t.ti_num
	JOIN customer c ON t.cos_num = c.cos_num
	JOIN show_day s ON t.sh_num = s.sh_num
	JOIN movie m ON s.sh_movien = m.mo_num

	pay_num := p.TI_NUM;
	pay_name := c.cos_name;
	pay_time := s.sh_time;
	pay_title := m.mo_title;
	pay_tot := p.py_tot;
	pay_type := p.py_type;
	pay_nop := t.ti_nop;
	
	p_message := '영화를 예매해 주셔서 감사합니다,예매하신 정보입니다';
    DBMS_OUTPUT.PUT_LINE('예매번호: ' || pay_num);
    DBMS_OUTPUT.PUT_LINE('고객이름: ' || pay_name);
    DBMS_OUTPUT.PUT_LINE('상영시간: ' || pay_time);
    DBMS_OUTPUT.PUT_LINE('영화이름: ' || pay_title);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || paytot * pay._nop);
    DBMS_OUTPUT.PUT_LINE('결제정보: ' || pay_type);
    DBMS_OUTPUT.PUT_LINE('—————————————————');
END;

--------------------------------------------------------
    DBMS_OUTPUT.PUT_LINE('예매번호: ' || payment.ti_num);
    DBMS_OUTPUT.PUT_LINE('고객이름: ' || payment.cos_name);
    DBMS_OUTPUT.PUT_LINE('상영시간: ' || payment.sh_time);
    DBMS_OUTPUT.PUT_LINE('영화이름: ' || payment.mo_title);
    DBMS_OUTPUT.PUT_LINE('총금액: ' || payment.py_tot * payment.ti_nop);
    DBMS_OUTPUT.PUT_LINE('결제정보: ' || payment.py_type);
    DBMS_OUTPUT.PUT_LINE('—————————————————');
--------------------------------------------------------
DECLARE
out_message varchar2(100);
o_pay_num NUMBER;
o_pay_name varchar2(10);
o_pay_time DATE;
o_pay_title varchar2(50);
o_pay_tot NUMBER ;
o_pay_type varchar2(20);

BEGIN
	/*paysystem_info(out_message);
	paysystem_info(o_pay_num);
	paysystem_info(o_pay_name);
	paysystem_info(o_pay_time);
	paysystem_info(o_pay_title);
	paysystem_info(o_pay_tot);
	paysystem_info(o_pay_type);*//*
	dbms_output.put_line(out_message);
	dbms_output.put_line(o_pay_num);
	dbms_output.put_line(o_pay_name);
	dbms_output.put_line(o_pay_time);
	dbms_output.put_line(o_pay_title);
	dbms_output.put_line(o_pay_tot);
	dbms_output.put_line(o_pay_type);

END;*/ 

-----------------------------------------
/*
CREATE OR REPLACE PROCEDURE show_info
(
	p_message OUT varchar2
)
IS
BEGIN
	p_message := (SELECT ti_num FROM pay);
	dbms_output.put_line(p_message); */
	
/*	p_message := (SELECT ti_num FROM pay);
    FOR payment IN (SELECT p.ti_num, c.cos_name, s.sh_time, m.mo_title, p.py_tot, p.py_type, t.ti_nop
                    FROM pay p
                    JOIN ticketting t ON p.ti_num = t.ti_num
                    JOIN customer c ON t.cos_num = c.cos_num
                    JOIN show_day s ON t.sh_num = s.sh_num
                    JOIN movie m ON s.sh_movien = m.mo_num)
    LOOP
        DBMS_OUTPUT.PUT_LINE('예매번호: ' || payment.ti_num);
        DBMS_OUTPUT.PUT_LINE('고객이름: ' || payment.cos_name);
        DBMS_OUTPUT.PUT_LINE('상영시간: ' || payment.sh_time);
        DBMS_OUTPUT.PUT_LINE('영화이름: ' || payment.mo_title);
        DBMS_OUTPUT.PUT_LINE('총금액: ' || payment.py_tot * payment.ti_nop);
        DBMS_OUTPUT.PUT_LINE('결제정보: ' || payment.py_type);
        DBMS_OUTPUT.PUT_LINE('—————————————————');
    END LOOP;*//*
END;
-----------------------------------------

DECLARE
re_message varchar2(100);
BEGIN
	show_info(re_message);
	dbms_output.put_line(re_message);
END;


-----------------------------------------

SELECT ti_num FROM pay;


SET SERVEROUTPUT ON; 
pay 테이블에 새로운 행이 삽입 될때마다
pay 테이블의 ti_num 컬럼과 ticketting 테이블의 ti_num이
일치하는 사람들의 결제 정보를 화면에 출력하는 프로시저를 생성한다.
프로시저를 실행하면 예매번호, 고객이름, 상영시간, 영화이름, 총금액, 결제정보가 출력됩니다. 

DBMS_OUTPUT.PUT_LINE
DBMS_OUTPUT



SELECT p.ti_num, c.cos_name, s.sh_time, m.mo_title, p.py_tot, p.py_type, t.ti_nop
FROM pay 
JOIN ticketting t ON p.ti_num = t.ti_num
JOIN customer c ON t.cos_num = c.cos_num
JOIN show_day s ON t.sh_num = s.sh_num
JOIN movie m ON s.sh_movien = m.mo_num


--------------

-- 뷰 생성 
CREATE OR REPLACE VIEW system_pay_info
AS
 	SELECT p.ti_num PNO, c.cos_name NAMES , s.sh_time TIMES, m.mo_title TITLES , p.py_tot TOTS, p.py_type TYPES , (t.ti_nop)*p.py_tot TOPAY
	FROM pay p
	JOIN ticketting t ON p.ti_num = t.ti_num
	JOIN customer c ON t.cos_num = c.cos_num
	JOIN show_day s ON t.sh_num = s.sh_num
	JOIN movie m ON s.sh_movien = m.mo_num ; 

SELECT * FROM system_pay_info;


-------------------- 프로시저생성 
CREATE OR REPLACE PROCEDURE show_info_pays
(
	pay_no IN system_pay_info.PNO%TYPE;
	pay_name IN  system_pay_info.NAMES%TYPE;
	pay_time IN  system_pay_info.TIMES%TYPE;
	pay_title IN  system_pay_info.TITLE%TYPE;
	pay_tot IN  system_pay_info.TOTS%TYPE;
	pay_type IN  system_pay_info.TYPES%TYPE;
	pay_topay IN  system_pay_info.TOPAY%TYPE;
)
IS
BEGIN
	DBMS_OUTPUT.ENABLE;
	DBMS_OUTPUT.PUT_LINE( '-------- 결제 정보 출력 프로시저 -------- ' );
--	DBMS_OUTPUT.GET_LINE( pay_no, pay_name, pay_time, pay_title, pay_type, pay_topay );
	DBMS_OUTPUT.PUT_LINE('예매번호 : '|| pay_no || chr(10)||
						 '고객이름 : '||pay_name||'님'||chr(10)||
						 '영화 시간 : '||pay_time||chr(10)||
						 '영화 이름 : '||pay_title||chr(10)||
						 '결제 정보 : '||pay_type||chr(10)||
						 '총 결제금액 : '||pay_topay);
END;

/* 
DROP PROCEDURE show_info_pays;
show_info_pays( pay_no, pay_name, pay_time, pay_title, pay_type, pay_topay );
*/

------------------ 호출 */
/*
DECLARE
	pay_no system_pay_info.PNO%TYPE;
	pay_name system_pay_info.NAMES%TYPE;
	pay_time system_pay_info.TIMES%TYPE;
	pay_title system_pay_info.TITLES%TYPE;
	pay_tot system_pay_info.TOTS%TYPE;
	pay_type system_pay_info.TYPES%TYPE;
	pay_topay system_pay_info.TOPAY%TYPE;
BEGIN
	show_info_pays(pay_no, pay_name, pay_time, pay_title, pay_type, pay_topay);
	DBMS_OUTPUT.PUT_LINE( pay_no, pay_name, pay_time, pay_title, pay_type, pay_topay);
END;



 ----------------------------------

CREATE OR REPLACE PROCEDURE show_payment_info_proc
IS
BEGIN
    FOR payment IN (SELECT * FROM system_pay_info)
    LOOP
        DBMS_OUTPUT.PUT_LINE('예매번호: ' || payment.ti_num);
        DBMS_OUTPUT.PUT_LINE('고객이름: ' || payment.cos_name);
        DBMS_OUTPUT.PUT_LINE('상영시간: ' || payment.sh_time);
        DBMS_OUTPUT.PUT_LINE('영화이름: ' || payment.mo_title);
        DBMS_OUTPUT.PUT_LINE('총금액: ' || payment.py_tot * payment.ti_nop);
        DBMS_OUTPUT.PUT_LINE('결제정보: ' || payment.py_type);
        DBMS_OUTPUT.PUT_LINE('----------------------------------');
    END LOOP;
END;

DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE(show_payment_info_proc);
END;
*/

--------------------

--파라미터 



--------------------


SET SERVEROUTPUT ON;
SELECT * FROM system_pay_info;


CREATE OR REPLACE PROCEDURE pay_info
(
-- 매개변수 out %TYPE 선언 항목별 
	pi_no OUT system_pay_info.PNO%TYPE;
)
IS
-- 변수명 선언
BEGIN
-- 실행내용
	SELECT INFO.PNO, INFO.NAMES, INFO.TITLES, INFO.TYPES, INFO.TOPAY
	FROM system_pay_info INFO 
	INNER JOIN PAY PA
	ON PA.TI_NUM = INFO.PNO;
	
	DBMS_OUTPUT.ENABLE;
	DBMS_OUTPUT.PUT_LINE('--------예매 완료 되었습니다----------');
    DBMS_OUTPUT.PUT_LINE('예매번호: ' || pi_no);
    DBMS_OUTPUT.PUT_LINE('고객이름: ' || pi_name);
    DBMS_OUTPUT.PUT_LINE('상영시간: ' || pi_time);
    DBMS_OUTPUT.PUT_LINE('영화이름: ' || pi_title);
    DBMS_OUTPUT.PUT_LINE('결제정보: ' || pi_type);
    DBMS_OUTPUT.PUT_LINE('총 결제 : ' || pi_topay);
END;




/*
SELECT INFO.PNO, INFO.NAMES, INFO.TITLES, INFO.TYPES, INFO.TOPAY
FROM system_pay_info INFO 
INNER JOIN PAY PA
ON PA.TI_NUM = INFO.PNO; */


CALL pay_info(1);