set hidden param parseThreshold = 150000;

show user;
-- USER이(가) "HR"입니다.

create table jdbc_tbl_memo
(no        number(4)
,name      varchar2(20) not null
,msg       varchar2(200) not null
,writeday  date default sysdate
,constraint PK_jdbc_tbl_memo_no primary key(no)
);
-- Table JDBC_TBL_MEMO이(가) 생성되었습니다.

create sequence jdbc_seq_memo
start with 1
increment by 1 
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence JDBC_SEQ_MEMO이(가) 생성되었습니다.

select *
from jdbc_tbl_memo
order by no desc;

/*
insert into jdbc_tbl_memo(no, name, msg)
values(jdbc_seq_memo.nextval, ?, ?);
*/
select *
from user_db_links;

select *
from jdbc_tbl_memo@TEACHERSERVER
order by no desc;




select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_tbl_memo
order by no desc;
-- 포함/표시 -> 자바 -> 적용 -> 이클립스에 붙여넣기

String sql = "select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday\n"+
"from jdbc_tbl_memo\n"+
"order by no desc;";
-- 위의 문장에서 "\n"를 이클립스에서 지우게 되면 아래와 같이 하나의 문장으로 되어 from 이나 order by 적용이 되지 않는다. 주의!
-- ; 은 뒤에 없어야 한다.
select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writedayfrom jdbc_tbl_memoorder by no desc;


select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_tbl_memo
where no = 1;
-- 또는
select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_tbl_memo
where no = '1';
-- 문자열 입력도 호환가능하다!

select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_tbl_memo
where msg like '%우와%';
-- 또는
select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday
from jdbc_tbl_memo
where msg like '%'||'우와'||'%';
-- 자바에서는 '||'를 넣어주어야 한다.


select *
from jdbc_tbl_examtest;

---------------------------------------------------------------------------------

select * 
from USER_TABLES 
where table_name = 'JBDC_TBL_EXAMTEST';
			

select *
from user_sequences
where sequence_name = 'JDBC_SEQ_EXAMTEST';

drop table jdbc_tbl_examtest purge;
drop sequence jdbc_seq_examtest;

