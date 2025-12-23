SELECT * FROM mymember;


-- 가율 ) 학년별 출생년도가 1970년 부터 1980년까지의 사람이 몇명씩 포함되어있는지 구하시오. 
SELECT a.grade  , count(*)
FROM (SELECT to_char(w_date, 'yyyy') SINCE, name, grade FROM mymember) a
WHERE SINCE BETWEEN 1970 AND 1980
GROUP BY a.grade;


-- 예종 ) 수원사는 3학년 학생의 이름, 학년, 포인트, 주소와 수원학생의 평균값을 출력하세요.
SELECT name, grade, point, addr,
	(SELECT avg(point) FROM mymember WHERE addr LIKE '%suwon%') 평균 
FROM mymember 
WHERE addr LIKE '%suwon%' AND grade = 3;


-- 병창 ) 전체 평균 포인트 값보다 낮은 그룹의 평균포인트, 그룹명, 명수를 출력하세요
SELECT grade 학년 , avg(point) 학년별평균 , count(*) 명수 
FROM mymember 
GROUP BY GRADE
HAVING avg(point) < (SELECT avg(point) FROM mymember);



-- 현희 ) 성적이 가장 낮은 5인의 이름과 성별 점수를 출력하시오.
SELECT rownum RANKING , name 이름  , gender 성별  , point 점수  
FROM (SELECT * FROM mymember ORDER BY point ASC)
WHERE rownum <= 5;



-- 가율 ) 1학년~2학년 사람들 중 이름에 kim 이 들어간 사람의 점수를 출력하되 
-- 1학년부터 점수가 낮은 순서대로 출력 하시오 

SELECT A.grade 학년 , A.name, A.point
FROM ( SELECT grade, name , point
		FROM mymember 
		WHERE grade IN (1, 2) ) A
WHERE A.name LIKE 'kim%'
ORDER BY A.grade, A.point ASC;


-- 병창 ) 전체 학생들 중 포인트 200이상인 학생이 총 몇명인지 출력하세요 
-- 학년별로 몇명인지 출력하세요

SELECT grade 학년, count(*) 인원수 
FROM mymember 
WHERE point >= 200
GROUP BY grade;


-- 현희 ) 전체평균 포인트보다 높은 점수를 가진 사람의  이름,포인트,학년  정보를 구하시오 
-- 단, 포인트가 낮은 사람 중에 2번째부터4번째 사람만 나와야 합니다.

SELECT C.R, C.name, C.point , C.grade
FROM ( SELECT rownum R, A.*
    	FROM (SELECT * FROM mymember WHERE point > (SELECT avg(point) FROM mymember)
	           ORDER BY point ASC) A) C
WHERE R BETWEEN 2 AND 4;


-- 예종 ) 나이 어린사람 20명을 포인트 내림차순으로 출력하시오.

SELECT B.*
FROM ( SELECT rownum R, A.*
		FROM (SELECT TRUNC(MONTHS_BETWEEN(sysdate, w_date)/12+1,0) nOld , point
				FROM mymember
				ORDER BY nOld , point DESC ) A) B
WHERE B.R <= 20;






	

