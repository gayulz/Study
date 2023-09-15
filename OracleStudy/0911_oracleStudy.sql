CREATE TABLE car(
c_no varchar2(9) PRIMARY KEY,
c_type varchar2(20), 
c_date timestamp DEFAULT sysdate
);

CREATE TABLE repaircar(
r_no number(3) PRIMARY KEY,
r_date timestamp DEFAULT sysdate,
r_memo varchar2(100),
r_price number(10), 
r_c_no varchar2(9)
);

INSERT INTO car VALUES ('12가1234', '소나타', '23/08/12');
INSERT INTO car VALUES ('13가1234', '카니발', '23/07/12');
INSERT INTO car VALUES ('14가1234', '그랜저', '23/08/11');
INSERT INTO car VALUES ('15가1234', 'K7', '23/09/02');
INSERT INTO car VALUES ('16가1234', '포드', '23/08/20');

INSERT INTO repaircar values(1,'23/09/01','타이어교체', 150000, '12가1234');
INSERT INTO repaircar values(2,'23/09/01','엔진오일', 50000, '13가1234');
INSERT INTO repaircar values(3,'23/09/03','범퍼수리', 250000, '12가1234');
INSERT INTO repaircar values(4,'23/09/03','타이어펑크', 30000, '14가1234');
INSERT INTO repaircar values(5,'23/09/04','세차', 20000, '17가1234');
UPDATE repaircar SET r_memo = '엔진오일' WHERE R_NO = 2;

SELECT * FROM repaircar;
SELECT * FROM car;

--car의 첫번째 튜플에 repaircar를 다 합쳐버린 쿼리
--이론적 단어 : full Join 이라고함
SELECT * FROM car,repaircar;



--동등 inner Join 
SELECT * 
FROM car CAR, 
	repaircar RE
WHERE CAR.c_no = RE.r_c_no;




-- 자동차번호와 자동차이름과 수리내용과 수리날짜만 출력하시오
-- 테이블명.속성명 : 유니크하면 테이블명을 적지 않아도 되지만, 중복일 경우를 대비하여 적는것이 좋다.
 

SELECT CAR.c_no 자동차번호 , CAR.C_TYPE 자동차이름 , RE.R_MEMO 수리내용, RE.R_DATE 수리날짜
FROM car CAR
INNER JOIN repaircar RE
ON CAR.c_no = RE.r_c_no;


-- 문제 
-- 12가1234 차량의 차 타입과 수리 내역을 출력하시오, 내가 알고 있는 정보는 차량 번호 이다.
-- 풀이 : 조인을 해야하는가? , 조인 결과에 따라 where group by, select order를 기존과 같이 고려하면 됨
-- 문제에서 요구하는 컬럼들이,테이블 두개를 합쳐야 한다 

SELECT C.C_NO 차번호 , C.C_TYPE 차타입, R.R_MEMO 수리내역 
FROM car C 
INNER JOIN repaircar R 
ON C.c_no = R.r_c_no 
WHERE C.c_no = '12가1234';




-- 문제
-- 수리비가 10만원 이상인 자동차번호와 차타입, 수리내용, 수리가격을 출력하시오 

SELECT C.C_NO 차번호 , C.C_TYPE 차타입 , R.R_MEMO 수리내용 , R.R_PRICE 수리비 
FROM car C
INNER JOIN repaircar R
ON C.c_no = R.r_c_no
WHERE R.r_price >= 100000;



-- 문제
-- 자동차1대별로 수리건수를 출력하시오, 자동차 1대의 기준은 등록된 자동차 번호이다.

SELECT CAR.C_NO 차번호 , count(RE.R_NO) 수리건수 
FROM car CAR
INNER JOIN repaircar RE
ON CAR.c_no = RE.r_c_no
GROUP BY CAR.c_no
ORDER BY CAR.c_no DESC;


-- LEFT OUTER JOIN / RIGHT OUTER JOIN 예제
-- FROM 절의 테이블이 1차 테이블다. 
-- LEFT OUTER JOIN / RIGHT OUTER JOI 에 들어가는 테이블은 2차테이블이다.


SELECT *
FROM car c
LEFT OUTER JOIN repaircar r 
ON c.c_no = r.r_c_no;


SELECT *
FROM car c
RIGHT OUTER JOIN repaircar r 
ON c.c_no = r.r_c_no;



-- 문제
-- 수리내역이 없는 자동차번호만 출력하시오

SELECT c.c_no
FROM car c
LEFT OUTER JOIN repaircar r 
ON c.c_no = r.r_c_no
WHERE r.r_c_no IS null;




-- 문제
-- 수리내역은 있지만 등록된 자동차가 아닌 수리내역과 날짜를 출력하시오.

SELECT r.r_c_no , r.r_date, r.r_memo
FROM car c 
RIGHT OUTER JOIN repaircar r 
ON c.c_no = r.r_c_no  
WHERE c.c_no IS NULL;



