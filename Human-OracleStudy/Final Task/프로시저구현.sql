SELECT * FROM EW_pay_info;

CREATE OR REPLACE VIEW EW_pay_info
AS
 	SELECT p.ti_num T_NUM, c.cos_name T_NAMES , s.sh_time T_TIMES
        , m.mo_title M_TITLES , p.py_type P_TYPES , (t.ti_nop)*p.py_tot P_TOPAY
	FROM pay p
	JOIN ticketting t ON p.ti_num = t.ti_num
	JOIN customer c ON t.cos_num = c.cos_num
	JOIN show_day s ON t.sh_num = s.sh_num
	JOIN movie m ON s.sh_movien = m.mo_num ; 
	
-- 뷰생성 완료

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


BEGIN  payProc(2);	END;
