9월 12일 
오라클 마지막 단계

-- 확인문제
-- 1. 자동차 종류별로 등록된 수를 출력하시오.
-- 단 등록된 수가 많은 정보부터 출력하시오

SELECT
    O.INFONAME,
    COUNT(O.INFONUM)
FROM
    CARNUM  C
    INNER JOIN CARINFO O
    ON C.INFONUM = O.INFONUM
GROUP BY
    O.INFONAME
ORDER BY
    O.INFONAME DESC;

-- 모든 회원의 자동차 등록 현황표를 조회하시오.
-- 회원아이디, 회원이름, 주소, 자동차 번호 , 차종


WITH CaIn AS ( 
SELECT C1.ID IID , C1.carnum Carnum  , C1.INFONUM Carinfos , C2.INFONAME Carnames
FROM carNum C1  
INNER JOIN carInfo C2
ON C1.infonum = C2.infonum )

SELECT ID, name, addr , CaIn.Carnum , CaIn.Carnames
FROM MEMBER
INNER JOIN CaIn 
ON ID = CaIn.IID;

   
   
   
-- 조인이 필요한 기능을 실행할 때 물리적인 테이블을 여러개 검색하지 않고 논리적인 테이블을 하나 검색 할 수 있돋록 한다
-- 여기서 논리적인 테이블은 view 라고 한다, view 는 실제 존재하는 테이블이 아닌 가상의 테이블이라고 한다.
-- 물리적인 테이블의 데이터로 별도로 저장하는 것이 아니라 물리적인 데이터를 연결하여서 참조한다.

   
CREATE VIEW Carinfos as (
    select m.id, m.name, m.addr, c2.carnum, c1.infoname
    from member m 
    INNER JOIN carnum c2 
    on m.id = c2.id
    inner join carinfo c1
    on  c2.INFONUM = c1.INFONUM
);

SELECT * FROM Carinfos;
