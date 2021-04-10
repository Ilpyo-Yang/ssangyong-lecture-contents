        ---- JSPServletBegin 에서 작업하는 것 -----
        
show user;
-- USER이(가) "SYS"입니다.

create user jspbegin_user identified by cclass
default tablespace users;
-- User JSPBEGIN_USER이(가) 생성되었습니다.

grant connect, resource, create view, unlimited tablespace to jspbegin_user;
-- Grant을(를) 성공했습니다.
        
show user;
-- USER이(가) "JSPBEGIN_USER"입니다.

drop table tbl_person_interest purge;
-- Table TBL_PERSON_INTEREST이(가) 삭제되었습니다.

create table tbl_person_interest
(seq          number
,name         varchar2(20) not null
,school       varchar2(20) not null
,color        varchar2(20) not null
,food         varchar2(80) 
,registerday  date default sysdate
,constraint PK_tbl_person_interest primary key(seq)
);
-- Table TBL_PERSON_INTEREST이(가) 생성되었습니다.

create sequence person_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle;
-- Sequence PERSON_SEQ이(가) 생성되었습니다.


select seq, name, school, color, food, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') AS registerday
from tbl_person_interest
order by seq;

insert into tbl_person_interest(seq, name, school, color, food)
values(person_seq.nextval, '이순신', '대졸', '파랑', '짜장면');

String sql = "select seq, name, school, color, food, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') AS registerday\n"+
"from tbl_person_interest\n"+
"order by seq;";

select seq, name, school, color, food, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') AS registerday
from tbl_person_interest
where seq='2';

delete tbl_person_interest where seq='2';