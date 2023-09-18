
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


DROP TABLE mymember;

DROP SEQUENCE member_no;

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
SELECT * FROM MYMEMBER;


1. 남학생들 중 6월에 태어난 학생의 이름과 주소와 w_date를 출력하시오
w_date 는 생년원일임

SELECT name 이름 , addr 주소, w_date 생년월일
FROM MYMEMBER
WHERE gender = 'm'
AND  EXTRACT(MONTH FROM w_date) = 02;

SELECT name, addr, SUBSTR(w_date, 1, 8)
FROM mymember
WHERE gender = 'm' 
AND SUBSTR(w_date, 4, 2)='02';



2. 2월에 태어난 사람은 모두 몇명인가요 
SELECT count(w_date)
FROM MYMEMBER
WHERE to_char(w_date, 'mm') = 2;

SELECT count(*)
FROM MYMEMBER
WHERE SUBSTR(w_date, 4, 2)='02';


3. 이름이 sun으로 끝나는 학생의 평균 포인트를 구하고 소수점 첫째까지 표현하세요

SELECT ROUND(avg(POINT),1) SUN평균 
FROM MYMEMBER
WHERE name LIKE '%sun';




4. 3학년만 포인트를 30씩 더하여 출력하고  
나머지 학생은 현재의 포인트를 출력하세요
SELECT point , grade, 
	CASE grade WHEN 3 THEN point+30 
		   	   WHEN 4 THEN point+50
	ELSE point END AS Plus  
FROM mymember;





5. 학년별 인원수를 구하시오

SELECT grade 학년 , concat(count(*), '명')합계 
FROM MYMEMBER
GROUP BY grade
ORDER BY grade;


다중행위  =  집계행위 라고 개념정리 필요
GROUP BY 는 그룹을 짓는것에 관심이 있다, 해당 그룹 안에 특정한 컬럼엔 관심이 없다
선택된 튜플을 기준으로 설정된 컬림으로 그룹으로 묶는다
그룹으로 묶으면 개별 튜플의 제어가 불가능해 진다



문제
포인트가 150 이상인 사람들은 그룹별로 몇명인가 ?

SELECT concat(count(*), '명') 인원 , grade  
FROM MYMEMBER
WHERE point >= 150
GROUP BY grade; 


문제
그룹의 인원수가 7 이상인 그룹만 출력하시오
그룹의 인원수가 7 이상이라는 것은,, 그룹에 대한 조건 , 튜플 선택을 위한 조건이 아니다 

SELECT grade
FROM MYMEMBER
GROUP BY grade HAVING count(*) >= 7;    --HAVING 은 그룹에 대한 조건이다,



오라클에서 그룹에 의미는
그룹에 관심이 있다는 것 , 개별적으로는 관심이 없다
그룹에 대한 조건은 HAVING 으로 조건처리를 하면 된다.
그룹을 만들어라 , 단 조건이 있다 -- GROUP BY ~ HAVING 



COMMIT;


