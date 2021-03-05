---- *** 회원테이블 생성하기 *** ----
select *
from user_tables
where table_name = 'JDBC_MEMBER';


create table jdbc_member
(userseq       number        not null    -- 회원번호
,userid        varchar2(30)  not null    -- 회원아이디
,passwd        varchar2(30)  not null    -- 회원암호
,name          varchar2(20)  not null    -- 회원명
,mobile        varchar2(20)              -- 연락처
,point         number(10) default 0      -- 포인트
,registerday   date default sysdate      -- 가입일자 
,status        number(1) default 1       -- status 컬럼의 값이 1 이면 정상, 0 이면 탈퇴 
,constraint PK_jdbc_member primary key(userseq)
,constraint UQ_jdbc_member unique(userid)
,constraint CK_jdbc_member check( status in(0,1) )
);
-- Table JDBC_MEMBER이(가) 생성되었습니다.


create sequence userseq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence USERSEQ이(가) 생성되었습니다.


select *
from jdbc_member
order by userseq desc;




---- *** 게시판 테이블 생성하기 *** ----
create table jdbc_board
(boardno       number        not null          -- 글번호
,fk_userid     varchar2(30)  not null          -- 작성자아이디
,subject       varchar2(100) not null          -- 글제목
,contents      varchar2(200) not null          -- 글내용
,writeday      date default sysdate not null   -- 작성일자
,viewcount     number default 0 not null       -- 조회수 
,boardpasswd   varchar2(20) not null           -- 글암호 
,constraint PK_jdbc_board primary key(boardno)
,constraint FK_jdbc_board foreign key(fk_userid) references jdbc_member(userid) 
);
-- Table JDBC_BOARD이(가) 생성되었습니다.


create sequence board_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

desc jdbc_board;
/*
이름          널?       유형            
----------- -------- ------------- 
BOARDNO     NOT NULL NUMBER        
FK_USERID   NOT NULL VARCHAR2(30)  
SUBJECT     NOT NULL VARCHAR2(100) 
CONTENTS    NOT NULL VARCHAR2(200) 
WRITEDAY    NOT NULL DATE          
VIEWCOUNT   NOT NULL NUMBER        
BOARDPASSWD NOT NULL VARCHAR2(20)  
*/


select *
from jdbc_board
order by boardno desc;





---- *** 댓글 테이블 생성하기 *** ----
create table jdbc_comment 
(commentno   number        not null    -- 댓글번호 
,fk_boardno  number        not null    -- 원글의 글번호 
,fk_userid   varchar2(30)  not null    -- 사용자ID
,contents    varchar2(200) not null    -- 댓글내용 
,writeday    date default sysdate      -- 작성일자
,constraint  PK_jdbc_comment  primary key(commentno) 
,constraint  FK_jdbc_comment_fk_boardno foreign key(fk_boardno) 
             references jdbc_board(boardno) on delete cascade 
,constraint  FK_jdbc_comment_fk_userid  foreign key(fk_userid) 
             references jdbc_member(userid) 
);
-- Table JDBC_COMMENT이(가) 생성되었습니다.

create sequence seq_comment
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence SEQ_COMMENT이(가) 생성되었습니다.


select *
from jdbc_comment;


-----------------------------------------------------------------------------

select *
from jdbc_member
order by userseq desc;


select userseq, userid, passwd, name, mobile, point
     , to_char(registerday, 'yyyy-mm-dd') AS registerday, status 
from jdbc_member 
where userid = 'leess' and passwd = 'qwer134++';

-----------------------------------------------------------------------------

/*
    Transaction(트랜잭션) 처리 실습을 위해서 
    jdbc_member 컬럼의 값은 최대 30을 넘지 못하도록 check 제약을 걸도록 하겠습니다.
*/					   

alter table jdbc_member
add constraint CK_jdbc_member_point check(point between 0 and 30);
-- Table JDBC_MEMBER이(가) 변경되었습니다.

select *
from jdbc_board;

select *
from jdbc_member
order by userseq;

update jdbc_member set point = point +10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update jdbc_member set point = point +10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update jdbc_member set point = point +10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update jdbc_member set point = point +10
where userid = 'leess';
-- ORA-02290: check constraint (HR.CK_JDBC_MEMBER_POINT) violated

rollback;


select B.boardno
     , case when length(B.subject)>10 then substr(B.subject,1,8)||'..' else B.subject end as subject
     , M.name
     , to_char(B.writeday,'yyyy-mm-dd hh24:mi:ss') as writeday
     , b.viewcount
from jdbc_board B join jdbc_member M
on B.fk_userid = M.userid
order by 1 desc;
-- primary key 가 있는 jdbc_member 테이블이 부모 테이블이다.


String sql = "\n"+
"select B.boardno\n"+
"     , case when length(B.subject)>10 then substr(B.subject,1,8)||'..' else B.subject end as subject\n"+
"     , M.name\n"+
"     , to_char(B.writeday,'yyyy-mm-dd hh24:mi:ss') as writeday\n"+
"     , b.viewcount\n"+
"from jdbc_board B join jdbc_member M\n"+
"on B.fk_userid = M.userid\n"+
"order by 1 desc";


---- 글 내용보기 ----
select subject, contents, fk_userid
from jdbc_board
where boardno = 5;

String sql = "select subject, contents, fk_userid\n"+
"from jdbc_board\n"+
"where boardno = 5;";



select *
from jdbc_comment;



---- 댓글쓰기 ----
select *
from jdbc_comment;


insert into jdbc_comment(commentno, fk_boardno, fk_userid, contents)
values(seq_comment.nextval,?,?,?);


insert into jdbc_comment(commentno, fk_boardno, fk_userid, contents)
values(seq_comment.nextval,2342, 'eomjh', '자바와 오라클을 붙이는 것이 재미있어요~');
-- ORA-02291: integrity constraint (HR.FK_JDBC_COMMENT_FK_BOARDNO) violated - parent key not found



-- ==> 댓글의 개수를 부여주지 않는 SQL문 <== --
select B.boardno
     , B.subject
     , M.name
     , to_char( B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY
     , B.viewcount
     , nvl(C.COMMENTCNT,0) as COMMENTCNT
from jdbc_board B JOIN jdbc_member M 
ON B.fk_userid = M.userid
LEFT JOIN 
(
    select fk_boardno, count(*) as COMMENTCNT
    from jdbc_comment
    group by fk_boardno
) C
ON B.boardno = C.fk_boardno
order by 1 desc;

String sql = "\n"+
"select B.boardno\n"+
"     , B.subject\n"+
"     , M.name\n"+
"     , to_char( B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY\n"+
"     , B.viewcount\n"+
"     , nvl(C.COMMENTCNT,0) as COMMENTCNT\n"+
"from jdbc_board B JOIN jdbc_member M \n"+
"ON B.fk_userid = M.userid\n"+
"LEFT JOIN \n"+
"(\n"+
"    select fk_boardno, count(*) as COMMENTCNT\n"+
"    from jdbc_comment\n"+
"    group by fk_boardno\n"+
") C\n"+
"ON B.boardno = C.fk_boardno\n"+
"order by 1 desc;";



--- 댓글보기 ---
select *
from jdbc_comment
where fk_boardno=8;

select *
from jdbc_comment
where fk_boardno=7;


select *
from jdbc_board
order by boardno;



select C.contents, M.name, C.writeday
from
(
select contents, fk_userid, to_char(writeday,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_comment
where fk_boardno=8
) c
join jdbc_member M
on C.fk_userid = M.userid;


String sql = "select C.contents, M.name, C.writeday \n"+
"from \n"+
"(\n"+
" select contents\n"+
"      , to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY\n"+
"      , fk_userid\n"+
" from jdbc_comment\n"+
" where fk_boardno = 8\n"+
") C JOIN jdbc_member M \n"+
"ON C.fk_userid = M.userid; ";
