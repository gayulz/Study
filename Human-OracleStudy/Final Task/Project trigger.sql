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


