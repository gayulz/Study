
create table mymember(							
no int primary key,							
name varchar(10),								
addr varchar(10),								
gender varchar(1) default 'w',							
grade int default 1,								
point int default 100,							
w_date timestamp);											

create sequence member_no							
increment by 1								
start with 10;	


-----------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------

insert into mymember values(member_no.nextval,'kim min','suwon city','m',2,300,'19780201');							
insert into mymember values(member_no.nextval,'Lee soo','seoul','m',1,200,'19810201');						
insert into mymember values(member_no.nextval,'kim jin','cheonan','w',1,150,'19880401');						
insert into mymember values(member_no.nextval,'Park su','daejeon','w',2,100,'19780601');						
insert into mymember values(member_no.nextval,'kim hyun','busan','m',2,300,'19780201');						
insert into mymember values(member_no.nextval,'Ryu min','cheonan','w',3,400,'19780201');						
insert into mymember values(member_no.nextval,'kim mee','suwon','m',4,300,'19880201');						
insert into mymember values(member_no.nextval,'kim sun','seoul','w',4,290,'19720201');						
insert into mymember values(member_no.nextval,'choi min','suwon','w',2,220,'19850701');						
insert into mymember values(member_no.nextval,'choi sun','cheonan','m',2,200,'19810801');						
insert into mymember values(member_no.nextval,'park min','seoul','w',3,340,'19800501');						
insert into mymember values(member_no.nextval,'kim min','suwon','m',3,370,'19841101');						
insert into mymember values(member_no.nextval,'choi min','cheonan','w',2,300,'19901101');						
insert into mymember values(member_no.nextval,'Song ban','busan','w',4,390,'19921201');						
insert into mymember values(member_no.nextval,'Lee kyu','suwon','w',2,500,'19920901');						
insert into mymember values(member_no.nextval,'kim suk','suwon','m',1,400,'19800801');						
insert into mymember values(member_no.nextval,'park suk','daejeon','w',1,250,'19780501');						
insert into mymember values(member_no.nextval,'kim wan','cheonan','m',2,210,'19790201');						
insert into mymember values(member_no.nextval,'James','suwon','w',1,240,'19790301');				
insert into mymember values(member_no.nextval,'Han me','seoul','m',4,210,'19731201');						
insert into mymember values(member_no.nextval,'Jeon su','suwon','w',3,320,'19820401');						
insert into mymember values(member_no.nextval,'Gong dul','daejeon','w',3,410,'19770411');						
insert into mymember (no,name,gender,grade,point,w_date) values(member_no.nextval,'Ha ha','m',2,250,'19820201');				
insert into mymember (no,name,gender,grade,point,w_date) values(member_no.nextval,'lee ha','w',3,350,'19870601');					
insert into mymember (no,name,gender,grade,point,w_date) values(member_no.nextval,'choi ha','m',1,450,'19900201');


-----------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------

-- 다음문제를 해결하시오. --  
SELECT * FROM mymember;

--1. 남학생의 이름과 성별, 포인트를 출력하시오.
SELECT name 이름 , gender 성별, point 포인트 
FROM mymember
WHERE gender = 'm';

--2. 남학생은 모두 몇명입니까?
SELECT count(gender) AS gender
FROM mymember
WHERE gender = 'm';

--3. 여학생의 평균 포인트를 출력하시오.
SELECT avg(point) AS 여학생평균포인트
FROM mymember
WHERE gender = 'w';

--4. 4학년중 최고점은 몇점입니까?		
SELECT max(point)
FROM mymember
WHERE GRADE = '4';


--5. 이름을 모두 대문자로 바꿔서 출력하시오.
SELECT UPPER(name) AS 대문자출력 
FROM mymember;



--6. 이름은 모두 몇글자인지 출력하시오. (공백도 이름에 포함)
SELECT name, LENGTH(name) AS 이름글자수 
FROM mymember;


--7. 이름뒤에 성별도 같이 출력하되 하나의 컬럼에서 출력하시오.
SELECT CONCAT(name, gender) AS 이름성별
FROM mymember;

SELECT CONCAT(name, concat(' 성별 : ',gender)) AS 이름성별
FROM mymember;


--8. 이름을 출력하되 이름의 첫글짜 부터 4번째 글자까지 출력하시오. (공백포함)
SELECT SUBSTR(name, 1, 4) AS 이름
FROM mymember;


--9. 이름을 출력하되 이름의 2번째 글자 부터 6번째 글자까지 출력하시오.(공백포함)
SELECT SUBSTR(name, 2, 5) AS 이름
FROM mymember;


--10. 주소에서 알파벳 o를 *로 치환하시오.
SELECT REPLACE(addr, 'o', '*')
FROM mymember;


--11. 주소에서 공백을 모두 제거하시오
SELECT REPLACE (addr,' ') 
FROM mymember;


--12. 2학년의 포인트 평균을 구하시오.
SELECT avg(point)
FROM mymember
WHERE grade = '2' ; 


--13. 학년이 짝수인 학생을 모두 출력하시오.
SELECT * 
FROM mymember
WHERE MOD(grade, 2)=0;


--14. w_date는 등록일이다. 모든 학생의 등록년도를 출력하시오.
SELECT EXTRACT(year FROM w_date)
FROM mymember;


SELECT * FROM mymember;

--15.<어려움> 남자들의 포인트를 출력하시오. 포인트 출력시 백단위에서 절삭하시오
SELECT point, TRUNC(point, -2)
FROM mymember
WHERE gender = 'm';


--16.<어려움> 모든 학생의 포인트의 평균을 구하고 소숫점 2째 자리까지 표현하시오.
SELECT to_char(sum(point)/count(point), 'fm9990.00') AS 평균포인트 
FROM mymember;

SELECT TRUNC(avg(point),2) 
FROM mymember;


--17.<어려움>  이름의 맨 뒤부터 시작하여 3개의 문자를 출력하시오.
SELECT substr(name, -3) 
FROM mymember;


--18.<아주많이어려움> 이름의 맨 뒤부터 시작하여 공백전까지의 문자를 출력하시오.
SELECT name , SUBSTR(name, instr(name,' ', 1)) 마지막공백이후 
FROM mymember;


--19.<많이어려움> 이름은 모두 소문자 이다.  대문자로 검색어 KIM을 입력하였을때도
--    정상적으로  이름에 kim이 포함된 사람의 정보를 출력하시오.

SELECT name
FROM mymember
WHERE upper(name) LIKE '%KIM';


--20.<어려움> w_date를 생년월일로 가정한다. 모두 2000년도 미만의 출생자이다
--    위 조건을 참고하여 3학년의 나이를 구하시오.


SELECT name 이름, grade 학년 
	 , substr(w_date,1,8) 출생일 
	 , extract(YEAR FROM sysdate)-EXTRACT(YEAR FROM w_date) 나이
FROM MYMEMBER;



  
--21. 이름에 빈칸이 없는 사람의 정보를 출력하시오.
SELECT *
FROM mymember
WHERE instr(name,' ') = 0 ;


--22 모든 사람의 정보를 출력하되 남자일 경우 한글로 남, 여자일 경우 한글로 여 라고 출력하시오

SELECT no, name, addr
	, REPLACE(REPLACE(gender,'m', '남'), 'w', '여') AS gender, grade, point, w_date
FROM mymember;



SELECT * FROM mymember;

-----------------------------------------------------------------------------------------------------------------------------
