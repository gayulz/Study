
다음 문제를 해결하고 query문을 덧글로 작성하시오.​

​

1. 회원이 소유한 자동차 번호를 출력하시오. (id, 이름, 주소)
SELECT m.id 회원아이디 , m.name 회원이름 , m.addr 회원주소 , n.carnum 자동차번호  
FROM MEMBER m
INNER JOIN carNum n
ON m.id = n.id;



2. 자동차를 소유하지 않은 회원의 아이디와 이름을 출력하시오.
SELECT m.id , m.name 
FROM MEMBER m
LEFT OUTER JOIN carNum n 
ON m.id = n.id
WHERE n.id IS NULL;



3. 천안 사는 사람이 소유한 자동차번호 출력하시오.
SELECT m.name, m.addr, n.carnum 
FROM MEMBER m 
INNER JOIN carNum n 
ON m.id = n.id 
WHERE m.addr LIKE '%천안%';



4. 1441 번호의 자동차의 소유자의 이름은 무엇인가?
SELECT m.name , n.carnum  
FROM MEMBER m 
INNER JOIN carnum n 
ON m.id = n.id
WHERE n.carnum = 1441;


5. 회원의 id가 큰 것부터 회원의 모든 정보를 출력하시오.	



SELECT J.*, i.infoname 차종정보 
FROM ( 
	SELECT m.id 아이디, m.name 이름, m.addr 주소
	, m.point 포인트, c.carnum 차번호, c.infonum 관리번호   
	FROM MEMBER m 
	FULL JOIN carNum c 
	ON m.id = c.id 
	ORDER BY m.id DESC ) J 
FULL JOIN carinfo i 
ON j.관리번호 = i.infonum ;


WITH FOJ AS (
SELECT 
	  m.id 아이디, m.name 이름
	, m.addr 주소, m.point 포인트
	, c.carnum 차번호, c.infonum 관리번호   
FROM MEMBER m
FULL JOIN carNum c 
ON m.id = c.id 
ORDER BY m.id DESC 
)


SELECT FOJ.* , II.infoname 차종 
FROM FOJ 
FULL JOIN carinfo II 
ON FOJ.관리번호 = II. infonum;







6. 천안에 거주 하는 회원의 이름을 출력하시오.

SELECT name
FROM MEMBER 
WHERE addr LIKE '%천안%'; 




7. 천안에 거주 하지 않는 회원의 이름과 주소를 출력하시오.
SELECT name , addr
FROM MEMBER 
WHERE addr NOT LIKE '%천안%'; 




8. 천안엔 거주하는 사람들의 포인트를 모두 합하시오.
SELECT sum(point)
FROM MEMBER 
WHERE addr LIKE '%천안%'; 




9. 수원에 거주하거나 천안에 거주 하는 사람들의 이름, 주소를 출력하시오.
SELECT name , addr 
FROM MEMBER 
WHERE REGEXP_LIKE(addr, '수원|천안');



10. 포인트가 높은 사람순으로 출력하되, 포인트가 동일일 경우 id가 낮은 사람부터 출력하시오.
SELECT point , id 
FROM MEMBER 
ORDER BY point DESC, id ASC;



11. 200이상 1000이하 의 포인트를 소유한 사람의 이름과 포인트를 출력하시오.
SELECT name, point
FROM MEMBER 
WHERE point BETWEEN 200 AND 1000;




12. 도시별(천안시, 수원시 등)자동차 등록된 자동차 수를 구하시오.
SELECT m.addr 도시명 , count(c.id) 총자동차수 
FROM MEMBER m 
INNER JOIN carNum c 
ON m.id = c.id
GROUP BY m.addr;




13. 천안 사는 사람의 정보를 출력하되 포인트가 6000 이상이면 포인트란에 vip라고 출력하시오.​
SELECT id 아이디, name 이름, addr 주소, 
	 CASE WHEN point < 6000
	 THEN to_char(point)
	 ELSE 'vip' END 포인트 
FROM MEMBER 
WHERE addr LIKE '%천안%';





14. 도시별(천안시, 수원시 등)자동차 등록된 자동차 수를 구하시오. (단, 등록된 자동차의 수가 2이상인 도시와 자동차수만 출력하시오.
SELECT UP.addr 도시명 , UP.ccar 차랑총대수 
FROM ( SELECT m.addr , count(c.id) ccar 
	FROM MEMBER m 
	INNER JOIN carNum c 
	ON m.id = c.id
	GROUP BY m.addr) UP
WHERE UP.ccar >= 2;





15. 자동차를 소유한 회원의 정보를 출력하세요..(이름, 주소, 차번호, 차종)
SELECT J.*, i.infoname 차종정보 
FROM ( SELECT m.id 아이디, m.name 이름, m.addr 주소, m.point 포인트, c.carnum 차번호, c.infonum 관리번호   
		FROM MEMBER m
		INNER JOIN carNum c 
		ON m.id = c.id ) J 
INNER JOIN carinfo i 
ON j.관리번호 = i.infonum ;




16. 회원이 소유한 자동차의 종류를 차종기준으로 각각 몇 대인지 출력하시오.
SELECT i.infoname 차종 , count(i.infoname) 총대수 
FROM (  SELECT * 
		FROM MEMBER m 
		INNER JOIN carNum c 
		ON m.id = c.id) S
INNER JOIN carInfo i 
ON S.infonum = i.infonum  
GROUP BY i.infoname ;



17. 회원이 소유하지 않은 차종을 출력하시오.
SELECT i.infoname 차종 
FROM carNum n 
RIGHT OUTER JOIN carInfo i 
ON n.infonum = i.infonum
WHERE n.id IS NULL;₩



COMMIT;
