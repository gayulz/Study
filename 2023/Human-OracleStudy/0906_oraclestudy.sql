SELECT * FROM MEMBER;
SELECT max(point) FROM MEMBER;
-- max함수가 매개변수로 받은 컬럼의 데이터중 최고값을 반환해준다
-- max(매개변수)



SELECT LENGTH(addr) FROM  MEMBER;
-- length(매개변수)
-- lengh 함수는 매개변수로 받은 컬의 모든 문자 데이터값의 길이를 반환한다 

-- 차이점
-- max함수는 튜플 전체를 그룹화를 시키고 length 는 그룹화를 시키지 않는다
-- 함수중에 그룹화 하는 함수를 집계함수 라고 한다.

-- 오라클 집계함수 종류 : sum / max / avg / count 

SELECT sum(point) AS 포인트합계값 , 
	   min(point) AS 포인트컬럼최소값,
	   avg(point) AS 포인트컬럼평균값,
	   count(point) AS 포인트컬럼갯수
FROM MEMBER;
SELECT * FROM MEMBER;

-- 응용문제1
-- 회원은 모두 몇명인가요

SELECT count(name) FROM MEMBER;
-- 답 : 7



-- 응용문제2
-- 서울 사는 회원의 평균 나이는 ?

SELECT avg(age)
FROM MEMBER
WHERE addr = '서울시';
-- 답 : 27.3333...



-- 응용문제3
-- 수원에 살지 않는 회원의 포인트 중 최저 포인트는 ?
SELECT min(point) 최저포인트 
FROM MEMBER
WHERE addr != '수원시';




-- 응용문제4 
-- 30세 이상은 모두 몇명인가요 ?
SELECT count(age)
FROM MEMBER
WHERE age >= 30;


-- 응용문제5 
-- 포인트의 평균을 구하시오, 단 200포인트 미만은 제외
SELECT avg(point)
FROM MEMBER 
WHERE point > 200;


-- 응용문제6
-- 주소는 한글3글자만 가능하다, 3글자 이상인 튜플만 찾아내시오 
SELECT *
FROM MEMBER 
WHERE length(addr) >= 3;



-- 응용문제7
-- 최고점을 받은 사람의이름은 ?
-- 우리가 공부한 범위에서 해결이 가능한가요 ? 
-- 서술식으로 답을 작성하세요 , 쿼리문은안됨
-- 답 : 서브쿼리를 사용하지 않는다면 불가 , max() 함수는 그룹함수 임으로

-- SELECT NAME
-- FROM MEMBER 
-- WHERE point = max(point); // 오류 

-- 답 : WHERE 절에서는 그룹함수를 사용할 수 없기 때문에 해당 문제는 지금까지 배운 과정으론 처리불가입니다
-- 1. 논리적 실행 순서: SQL 문의 논리적 실행 순서에 따라 WHERE 절은 그룹화 및 집계 함수보다 먼저 실행됩니다. 
-- 따라서 WHERE 절에서 그룹 함수를 사용하면 집계 함수의 결과를 참조할 수 없게 됩니다.
-- 2. 그룹화: 그룹 함수는 집계 레벨에서 작동하며, 여러 행의 값을 결합하여 단일 결과를 반환합니다. 
-- WHERE 절은 개별 행 레벨에서 조건을 평가하는 데 사용되므로 그룹화 함수와 함께 사용할 수 없습니다.
-- 따라서 그룹 함수를 사용하여 집계된 결과를 필터링하려면 HAVING 절을 사용해야 합니다. 
-- HAVING 절은 그룹화 후에 실행되며, 그룹 함수의 결과를 기반으로 행을 필터링할 수 있습니다.
-- 집계함수는 그룹화를 만드는 함수이다, 개별 튜플엔 관심이 없다
-- 그룹이 되면 그룹에 대한 집계가 가능하지만 개별 튜플을 제어할 순 없다.

SELECT name 
FROM MEMBER 
WHERE point = (SELECT max(point) FROM MEMBER );

-- 답 : 해당 최고점을 받은 사람을 찾기 위해 조건절에 select문을 추가로 넣어서 집계함수인 max를 통해 최고점 먼저 추출한 뒤 
-- 		포인트에 최고점포인트가 같은 사람을 SELECT문 name 적어 이름이 출력되게끔 한 



-- 정리문제
1. SELECT 절을 설명하시오
SELECT문법 중 4번째로 실행하는 절이며 조건에 부합한 데이터 중에 원하는 컬럼을 보여주기 위한 절 

2. SELECT 절의 동작 순서를 섦령하세요
FROM 절에서 검색하고자 하는 데이터를 재료로 WHERE절을 통해 추출하고자 하는 데이터의 조건을 만듭니다 조건에 부합한 데이터들은 때에따라  
GROUP BY 절에서 그룹화가 되거나,없을 경우 SELECT 절로 실행되어 WHERE 절에서 부합한 조건의 데이터를 기준 보여지고자 하는 컬럼을 보여주게 동작합니다.
SELECT 절이 끝난 다음 정렬이 필요할 경우 ORDER BY 절로 추가 정렬도 가능합니다

3. 집계 함수란 무엇인가
한 컬럼에 일정 구간 데이터들을 그룹화 시켜서 갯수 나 글자길이 등 통계를 해주는 함수 

4. 함수란 무엇인가
많은 수식을 쓰지 않더라도 좀더 간결하고 정확하게 값을 구할 수 있도록 도와주는 기능 

5. 매개변수란 무엇인가
함수에 입력되는 데이터를 매개변수라고 합니다 

6. 리턴값이란 무엇인가
입력된 매개변수가 함수의 일정한 수식에 의해나오는 결과값을 리턴값 이라고 합니다 

7. 함수는 어떻게 구분하는가 
함수명(매개변수) , 리턴값 여부 및 갯수 

9. 스스로 정리 문제 - 검색어
오라클 함수를 검색해보고 정의해보세요

1. 문자함수
문자 값을 반환하는 문자 함수
문자 값을 반환하는 문자 함수는 별도의 문서가 없는 한 다음 데이터 유형의 값을 반환합니다:
입력 인수가 CHAR 또는 VARCHAR2인 경우 반환되는 값은 VARCHAR2입니다.
입력 인수가 NCHAR 또는 NVARCHAR2인 경우 반환되는 값은 NVARCHAR2입니다.
함수가 반환하는 값의 길이는 반환되는 데이터 유형의 최대 길이에 의해 제한됩니다.
CHR
CONCAT
INITCAP
LOWER
LPAD
LTRIM
NCHR
NLS_INITCAP
NLS_LOWER
NLS_UPPER
NLSSORT
REGEXP_REPLACE
REGEXP_SUBSTR
REPLACE
RPAD
RTRIM
SOUNDEX
SUBSTR
TRANSLATE
TRANSLATE ... USING
TRIM
UPPER 

주로쓰는 함수 : UPPER() LOWER() SUBSTR() LENGTH REPLACE CONCAT()


2. 숫자함수
숫자 함수는 숫자 입력을 받아 숫자 값을 반환합니다.
대부분의 숫자 함수는 소수점 이하 38자리까지 정확한 NUMBER 값을 반환합니다. 
초월 함수인 COS, COSH, EXP, LN, LOG, SIN, SINH, SQRT, TAN 및 
ANH는 소수점 36자리까지 정확합니다. 
초월 함수 ACOS, ASIN, ATAN 및 ATAN2는 소수점 이하 30자리까지 정확합니다. 
숫자 함수는 다음과 같습니다

ABS / ACOS / ASIN / ATAN / ATAN2 / BITAND / CEIL
COS / COSH / EXP / FLOOR / LN / LOG / MOD / NANVL
POWER / REMAINDER / ROUND (number) / SIGN / SIN 
SINH / SQRT / TAN / TANH / TRUNC (number) / WIDTH_BUCKET

주로 쓰는 함수 : ROUND() TRUNC() CEIL FLOOR() MOD


3. 날짜함수 
날짜/시간 함수
날짜 시간 함수는 날짜(날짜)
타임스탬프(타임스탬프, 시간대가 포함된 타임스탬프, 현지 시간대가 포함된 타임스탬프) 및 
간격(간격 일~초, 간격 년~월) 값에 대해 작동합니다.
일부 날짜/시간 함수는 Oracle DATE 데이터 유형
(ADD_MONTHS, CURRENT_DATE, LAST_DAY, NEW_TIME 및 NEXT_DAY) 용으로 설계되었습니다. 
타임스탬프 값을 인자로 제공하는 경우 Oracle 데이터베이스는 내부적으로 
입력 유형을 DATE 값으로 변환하고 DATE 값을 반환합니다. 
숫자를 반환하는 MONTHS_BETWEEN 함수와 타임스탬프 
또는 간격 값을 전혀 허용하지 않는 ROUND 및 TRUNC 함수는 예외입니다.
나머지 날짜 시간 함수는 세 가지 유형의 데이터(날짜, 타임스탬프, 간격) 중 
하나를 허용하고 이 중 하나의 값을 반환하도록 설계되었습니다.

SYSDATE, SYSTIMESTAMP, CURRENT_TIMESTAMP 등과 같이 
현재 시스템 날짜/시간 정보를 반환하는 모든 날짜/시간 함수는 
해당 문에서 참조되는 횟수에 관계없이 각 SQL 문에 대해 한 번씩 평가됩니다.

날짜/시간 함수는 다음과 같습니다
ADD_MONTHS
CURRENT_DATE
CURRENT_TIMESTAMP
DBTIMEZONE
EXTRACT (datetime)
FROM_TZ
LAST_DAY
LOCALTIMESTAMP
MONTHS_BETWEEN
NEW_TIME
NEXT_DAY
NUMTODSINTERVAL
NUMTOYMINTERVAL
ORA_DST_AFFECTED
ORA_DST_CONVERT
ORA_DST_ERROR
ROUND (date)
SESSIONTIMEZONE
SYS_EXTRACT_UTC
SYSDATE
SYSTIMESTAMP
TO_CHAR (datetime)
TO_DSINTERVAL
TO_TIMESTAMP
TO_TIMESTAMP_TZ
TO_YMINTERVAL
TRUNC (date)
TZ_OFFSET

주로 쓰는 함수 : ADD_MONTHS() MONTHS_BETWEEN()




문제1 이름의 첫 글자만 출력하시오 
SELECT SUBSTR(name, 1,1) AS  이
FROM MEMBER ;
SELECT * FROM MEMBER;

문제2 서울시를 서울특별시로 치환하시오 
SELECT REPLACE(addr, '서울시', '서울특별시') AS 도시
FROM MEMBER ;

문제3 이름 뒤에 님을 붙혀서 출력하시오 
SELECT concat(name,'님')
FROM MEMBER;

문제4 나이가 짝수인 사람만 출력하시오
SELECT name 이름 , age 나이 
FROM MEMBER 
WHERE MOD(age, 2)=0;


-- 가장 중요한건 적절한 함수 선택
-- 함수 검색시 오라클 내장함수  
-- 함수사용법


COMMIT;
