*** DML - select, subquery, rownum 마무리 정리 문제입니다.  
Table 이름 : mymember				
				

1. 성별 평균을 구하시오, 단 1학년은 제외합니다.				
SELECT gender , avg(point)
FROM mymember
WHERE grade > 1
GROUP BY gender;

				
2. 4학년만 출력하시오.  이름은 앞에 두글자만 출력하고 뒤에는 *표 4개로 마스킹하시오.				
SELECT grade 학년 , concat(substr(name, 1, 2), '****') 이름마스킹  
FROM mymember 
WHERE grade = 4;


3. 2번 문제에서 마스킹을 *표 4개가 아닌,  남은 글자만큼 마스킹하시오.				
SELECT name, RPAD(substr(name,1,2),length(name), '*') AS RPAD_name
FROM mymember;


4. 모든 학생의 정보를 출력하시오, w_date 출력시 년월일만 보기에 하시오.. ex   88/02/01				
SELECT NO, name, addr, gender, GRADE, point, to_char(A.w_date,'yy/mm/dd') 생년월일
FROM mymember A;


5. 나이가 가장 많은 학생 5명을 출력하시오.. 나이가 같다면 학년이 높은 사람으로 다시 정렬합니다.				
SELECT R,B.name 이름, B.나이,B.grade 학년
FROM (	SELECT rownum R , A.*
		FROM 	( SELECT name, to_char(w_date,'yyyy') 생년월일, (MONTHS_BETWEEN(sysdate, w_date)/12) 나이 , grade
		    	  FROM mymember 
			  	  ORDER BY w_date , grade ASC) A ) B
WHERE B.R <= 5;


6. 포인트가 5번째에서 10번째로 많은 사람의 정보를 출력하시오. 포인트가 같다면 나이가 적은 순서가 우선합니다.				
SELECT n.R 순위 , n.name 이름 , n.point 포인트 , n.나이 
FROM ( SELECT rownum R, m.*
		FROM (SELECT name, point,(MONTHS_BETWEEN(sysdate, w_date)/12) 나이
				FROM MYMEMBER
				ORDER BY w_date DESC) m ) n
WHERE R BETWEEN 5 AND 10;


7. 주소에 a라는 글자가 포함된 사람만 모든 정보를 출력하시오.				
SELECT *
FROM MYMEMBER
WHERE addr LIKE '%a%';


8. 모든 사람의 포인트를 +100한 정보를 저장하시오. 실제 테이블 정보에 반영되어야 한다.				
UPDATE mymember SET point = point + 100; 


9. 2학년의 이름을 마스킹하시오... 마스킹 방법은 앞에 글자 3글자 뒤에 ***(3개) 입니다. 실제 테이블 정보에 반영되어야 한다.				
UPDATE mymember 
SET name = concat(substr(name, 1, 3), '***')
WHERE grade = 2 ;


10. 모든 학생들이 grade가 1씩 증가하였다. 처리하세오 실제 테이블 정보에 반영되어야 한다.				
UPDATE MYMEMBER
SET grade = grade + 1;


