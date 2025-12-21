-------------- 9월 12일 문제
-------------- 조인의 연장 

-- 선생님답;
select * from member;
select * from carnum;
select * from carinfo;

-- 1. 회원이 소유한 자동차 번호를 출력하시오. (id, 이름, 주소)
-- 회원정보 :  member,  자동차번호 carnum에 있다... 두개 조인 필요하다 무슨조인 inner join
-- 조인결과 후  where group by order by가 필요한가?  필요없다
select m.name, c.carnum
from member m
inner join carnum c
on m.id=c.id;


-- 2. 자동차를 소유하지 않은 회원의 아이디와 이름을 출력하시오.
-- 자동차를 소유하지 않았다..     member, carnum  조인 >> 조인에 참여하지 않는 튜플을 원한다. 아우터조인
--  아우터 조인은 이너조인 + 조인에 참여하지 않은 튜플까지  나온다.. 그래서  where 절로 튜플을 선택
-- 회원의 아이디와 이름을 출력하자. 
select m.id, m.name
from member m
left outer join carnum c
on m.id=c.id
where c.id is null;   -- 조인 결과에 대한 자동차르 소유하지 않은 튜플만을 선택하기 위한 조건


-- 3. 천안 사는 사람이 소유한 자동차를 출력하시오.
--  천안살고 자동차를 소유한 사람... member carnum  조인에 참여한 튜플을 원하죠.. 이너조인
-- 조인결과에서 조인은 테이블을 합친다. 그 후 합친 결과에서 다시 튜플을 선정한다.. 
-- 조인결과 후 천안 사는 사람 튜플만 다시 선택한다. 

select m.name, m.addr, c.carnum
from member m
inner join carnum c
on m.id=c.id
where m.addr like ('%천안%');


-- 4. 1441 번호의 자동차의 소유자의 이름은 무엇인가?
-- 자동차 번호를 알고 있다..이 번호로 소요자를 알고 싶다.. member, carnum 조인하자
-- 의미가 조인이 가능한 튜플을 찾아 낸다..  inner join
-- 조인 결과 후 .. 자동차 번호로 튜플을 선택해야 한다..
select *
from member m
inner join carnum c
on m.id = c.id
where c.carnum = '1441';


select *
from member m
left outer join carnum c
on m.id = c.id
where c.carnum = '1441';



--5. 회원의 id가 큰 것부터 회원의 모든 정보를 출력하시오.
-- 회원이 정보 출력하라.. 회원의 id가 큰 것부터가 조건같이 보입니다.  조인필요없고, where, group by노노노
select *
from member
order by id desc;