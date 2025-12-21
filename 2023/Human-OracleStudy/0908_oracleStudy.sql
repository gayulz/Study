9월 8일 실습

SELECT * FROM mymember;

-- 1번문제, 포인트가 200인 이상인 사람들 그룹별로 몇인지 출력하시오
SELECT grade , count(*) 
FROM mymember
WHERE point >= 200
GROUP BY grade 
ORDER BY grade;



-- 2번문제, 그룹별 몇명인지 출력하시오, 단 옆 컬럼에는 전체 인원수를 출력한다
SELECT count(*) 그룹별인원 
	, (SELECT count(*) FROM mymember) 전체인원수
FROM mymember 
GROUP BY grade; 


-- 3번문제, 그룹몇 몇명인지 출력하시오, 단 옆 컬럼에는 grade=1 이면 1학년 이렇게 학년을 뒤에 붙혀서 출력하시오
SELECT count(*) 
FROM mymember 
GROUP BY grade; 



-- 4번문제, 그룹별 몇명인지 출력하시오, 단 그 옆 컬럼에는 m이면 남자, w이면 여자로 출력하시오
SELECT count(*) 
FROM mymember 
GROUP BY grade; 




-- 그룹별 몇명인지 출력하시오 단 그룹의 평균이 전체 평균보다 높은 그룹만 출력(평균은 포인트)
SELECT count(*), grade
FROM mymember
GROUP BY grade HAVING avg(point) > (SELECT avg(point) FROM mymember);




-- 전체 포인트 평균보다 높은 평균의 포인틀을 가진 사람들을 모두 출력하시오 
SELECT *
FROM mymember
WHERE name = ( SELECT name FROM MYMEMBER member);



-- 전체에서 최고점을 가진 사람의 이름과 성별과 점수를 출력하시오
SELECT name, gender, point
FROM mymember
WHERE point IN (SELECT max(point) FROM MYMEMBER);



-- 포인트가 300인 사람과 같은 도시에 살고 있는 사람의 이름을 출력하시오.
SELECT name
FROM mymember 
WHERE addr IN (SELECT addr FROM mymember WHERE point =300 );




-- 포인트가 300인 사람과 같은 그룹이면서 같은 도시에 살고 있는 사람의 이름을 출력하시오 
SELECT name 
FROM mymember
WHERE (grade.addr) IN (SELECT grade, addr, FROM mymember WHERE point=300);



-- m 이라고 하는건 테이블에 별칭을 지어주는 것, 약어
SELECT rownum, m.*
FROM mymember m;



-- rownum 사용하여 순서를 매긴 뒤 포인트가 가장 높은 사람 5명 출력
SELECT rownum , m.* 
FROM ( SELECT point FROM mymember ORDER BY point DESC ) m
WHERE rownum <= 5;


-- rownum 은 select 절에서 순서를 매기는데 다음에 order by 가 실행되면 순서가 바뀐다.
-- mymember 테이블 자리에 정렬된 테이블로 바꾸면 된다 > 서브쿼리중 인라인 뷰 로 해당됨
-- 포인트가 높은 순서대로 rownum 을 사용하여 번호를 부여하고 5번째~10번째 사람만 출력

SELECT b.* 
FROM ( SELECT rownum INS, a.* 
		FROM ( SELECT *
				FROM mymember 
				ORDER BY point DESC ) a ) b 
WHERE INS BETWEEN 10 AND 20;




