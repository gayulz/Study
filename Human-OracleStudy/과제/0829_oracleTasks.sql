---------- 8월 29일 과제 ------------------
--
--게시판 테이블만들기
--글은 글번호가 있으며 1 2 3 4 로 부여된다.
--제목이 있으며 제목은 한글 10글자까지가능
--작성자가 있으며 한글5글자까지 가능합니다. 반드시 입력해야 합니다.
--게시글의 구분을 입력합니다. 공지글, 자유게시글, 중고장터 중에 하나를
--입력할 수 있습니다. 기본값은 자유게시글입니다.
--게시글은 조회수를 기록합니다 기본값은 0입니다.
--게시날짜를 시분초까지 저장합니다. 
--게시판의 글에 댓글을 작성할 수 있다.
--댓글을 작성할 수 있게 업그레이드하시오.
--게시판의 글이 없을 경우는 댓글을 작성 할 수 없다.
--댓글은  작성자, 내용, 작성일을 저장한다.  
--

create table boards ( 
	w_no number(10) primary KEY, 
	title varchar2(20),
	writer varchar2(20) not NULL ,
	w_type nvarchar2(10) check(w_type in('공지글','자유게시글','중고장터')), 
	w_cnt int DEFAULT 0,
	w_date date default sysdate
);


create table W_comment ( 
	w_no number(10),
	com_text varchar(200) , 
	writer varchar2(10),
	wdate date default sysdate,
	foreign key(w_no) references boards(w_no) ON DELETE CASCADE
);

DROP TABLE W_comment;

DROP TABLE boards;

------------ 테이블 생성 완료 -----------------

8. 게시글 5개를 등록하세요. 글번호는 차례대로 1 2 3 4 5 입니다.

INSERT INTO boards VALUES (1,'제목1','글쓴이1','중고장터',DEFAULT, sysdate);
INSERT INTO boards VALUES (2,'제목2','글쓴이2','공지글',DEFAULT, sysdate);
INSERT INTO boards VALUES (3,'제목3','글쓴이3','중고장터',DEFAULT, sysdate);
INSERT INTO boards VALUES (4,'제목4','글쓴이4','자유게시글',DEFAULT, sysdate);
INSERT INTO boards VALUES (5,'제목5','글쓴이5','중고장터',DEFAULT, sysdate);

9. 게시글을 모두 출력하세요.

SELECT * FROM boards;

10. 3번 게시물의 제목을 오늘비오네 라고 변경하세요.

UPDATE boards set title = '오늘비오네' where w_no = 3;


11. 3번 게시물만 출력하세요.

select *
from boards
where w_no = 3;

12. 모든 게시물의 제목하고 작성자만 출력하세요.

SELECT title , writer
FROM boards;


13. 2번 글의 댓글을 2개 등록하세요.

INSERT INTO W_comment VALUES (2, '재미있네요굿굿', '깜깜이', sysdate);
INSERT INTO W_comment VALUES (2, '한번 더 보겟씀', '밝은이', sysdate);

14. 3번 글의 댓글을 1개 등록하세요.

INSERT INTO W_comment VALUES (3, '비올때봐야하나요?', '비옴', sysdate);


15. 4번 글을 삭제 하세요.

DELETE FROM boards WHERE w_no = 4 ;


16. 댓글이 있는 글은 삭제할 수 없다. 이것을 삭제 가능하게 할 수는 없을까?

DELETE FROM boards WHERE w_no = 3 ;
무결성 제약조건 위반으로 나온다.
삭제 대상 테이블이 부모테이블인 boards , w_no 는 기본키로 되어있지만 
자식 테이블인 W_comment 테이블에 w_no 참조되어 있기 때문에 
삭제할 수 없다고 나오는 내용이다.

이럴 경우 자식 테이블에 있는 데이터를 삭제 후 부모 테이블에 있는 데이터를 삭제 하면 되지만
부모 테이블의 데이터 제거 시 자식 테이블 데이터도 자동제거되는 
ON DELETE CASCADE 를 사용하면 편리하다

SELECT * FROM W_comment;
SELECT * FROM boards;


