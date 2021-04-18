---- **** MyMVC에서 작업하는 것 **** ----

show user;
-- USER이(가) "SYS"입니다.

create user mymvc_user identified by cclass
default tablespace users;
-- User MYMVC_USER이(가) 생성되었습니다.

grant connect, resource , create view, unlimited tablespace to mymvc_user;
-- Grant을(를) 성공했습니다.

show user;
-- USER이(가) "MYMVC_USER"입니다.

create table tbl_test01
(name    varchar2(40)
,address varchar2(60)
);

select * from tbl_test01;


----------------------------------------------------------------------------


create table tbl_main_image
(imgno           number not null
,imgfilename     varchar2(100) not null
,constraint PK_tbl_main_image primary key(imgno)
);

create sequence seq_main_image
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '미샤.png');  
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '원더플레이스.png'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '레노보.png'); 
insert into tbl_main_image(imgno, imgfilename) values(seq_main_image.nextval, '동원.png'); 

commit;

select imgno, imgfilename
from tbl_main_image 
order by imgno asc;

-------------------------------------------------------------------------------------

create table tbl_member
(userid             varchar2(40)   not null  -- 회원아이디
,pwd                varchar2(200)  not null  -- 비밀번호 (SHA-256 암호화 대상)
,name               varchar2(30)   not null  -- 회원명
,email              varchar2(200)  not null  -- 이메일 (AES-256 암호화/복호화 대상)
,mobile             varchar2(200)            -- 연락처 (AES-256 암호화/복호화 대상) 
,postcode           varchar2(5)              -- 우편번호
,address            varchar2(200)            -- 주소
,detailaddress      varchar2(200)            -- 상세주소
,extraaddress       varchar2(200)            -- 참고항목
,gender             varchar2(1)              -- 성별   남자:1  / 여자:2
,birthday           varchar2(10)             -- 생년월일   
,coin               number default 0         -- 코인액
,point              number default 0         -- 포인트 
,registerday        date default sysdate     -- 가입일자 
,lastpwdchangedate  date default sysdate     -- 마지막으로 암호를 변경한 날짜  
,status             number(1) default 1 not null     -- 회원탈퇴유무   1: 사용가능(가입중) / 0:사용불능(탈퇴) 
,idle               number(1) default 0 not null     -- 휴면유무      0 : 활동중  /  1 : 휴면중 
,constraint PK_tbl_member_userid primary key(userid)
,constraint UQ_tbl_member_email  unique(email)
,constraint CK_tbl_member_gender check( gender in('1','2') )
,constraint CK_tbl_member_status check( status in(0,1) )
,constraint CK_tbl_member_idle check( idle in(0,1) )
);

select *
from tbl_member
order by registerday desc;


--- *** "로그인 기록"을 위한 테이블 생성하기 *** ---
create table tbl_loginhistory
(fk_userid   varchar2(40) not null 
,logindate   date default sysdate not null
,clientip    varchar2(20) not null
,constraint FK_tbl_loginhistory foreign key(fk_userid) 
                                references tbl_member(userid)  
);
-- Table TBL_LOGINHISTORY이(가) 생성되었습니다.

select *
from tbl_loginhistory;


--- *** 로그인 처리를 위한 한 명의 회원정보 조회하기 *** ---
select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender
    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd 
    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday
    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchageqap
from tbl_member
where status=1 and userid='kimys' and pwd='fdfdf122da83e3b1daee3a01d0f5269c1f5a11b1162e5c25136282c98ad97b18';


String sql = "select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender\n"+
"    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd \n"+
"    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday\n"+
"    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchageqap\n"+
"from tbl_member\n"+
"where status=1 and userid='kimys' and pwd='fdfdf122da83e3b1daee3a01d0f5269c1f5a11b1162e5c25136282c98ad97b18' ";



--- 사용자 id가 'ilpyoyang' 인 회원이 6개월 전 회원가입을 하고서 비밀번호를 변경한지가 5개월이 지났다라고 가정한다.
---- 이러한 경우 로그인시 "비밀번호를 변경하신지 3개월이 지났습니다. 암호를 변경하세요!!" 라는 메시지를 띄우기 위해 아래와 같이 한다.
update tbl_member set registerday = add_months(registerday, -6), lastpwdchangedate = add_months(lastpwdchangedate, -5)
where userid = 'ilpyoyang';

update tbl_member set pwd = 'def3dfc42d7afe9dd50425167f313021a1a0acdc19ea30a682f88ddf86ef3ad5'
where userid = 'ilpyoyang';

commit;

select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender
    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd 
    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday
    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchageqap
from tbl_member
where status=1 and userid='ilpyoyang' and pwd='def3dfc42d7afe9dd50425167f313021a1a0acdc19ea30a682f88ddf86ef3ad5';


select *
from tbl_member
order by registerday desc;

delete from tbl_loginhistory where fk_userid='test';
commit;


select *
from tbl_loginhistory;



--- 마지막으로 로그인을 한지 12개월이 초과한 경우 또는 회원을 가입하고서 로그인을 하지 않은지가 12개월이 초과한 경우
--- 로그인시 "로그인을 한지 1년이 지나서 휴면상태로 되었습니다. 관리자에게 문의 바랍니다." 라는 alert 를 띄우기 위해 아래와 같이 한다.
update tbl_member set registerday = add_months(registerday, -13)
                    , lastpwdchangedate = add_months(lastpwdchangedate, -13)
where userid = 'leess';


update tbl_loginhistory set logindate = add_months(logindate, -13)
where fk_userid = 'leess';


update tbl_member set registerday = add_months(registerday, -14)
                    , lastpwdchangedate = add_months(lastpwdchangedate, -14)
where userid = 'test';


commit;



select *
from tbl_member
where userid in ('test','leess');
-- leess 는 회원가입을 '20/03/15' 날짜에 가입을 했다.

select fk_userid, to_char(logindate, 'yyyy-mm-dd hh24:mi:ss') as logindate, clientip
from tbl_loginhistory
where fk_userid in ('test','leess');

-- test 는 로그인 한 적이 단 한 번도 없다.
-- leess 가 마지막으로 로그인 한 날짜 및 시각은 2020-03-16 16:13:46 이다.
SELECT userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender,
       birthyyyy, birthmm, birthdd, coin, point, registerday, pwdchagegap, lastlogingap
FROM
(
select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender
    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd 
    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday
    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchagegap
from tbl_member
where status=1 and userid='leess' and pwd='def3dfc42d7afe9dd50425167f313021a1a0acdc19ea30a682f88ddf86ef3ad5'
) M
CROSS JOIN
(
select months_between(sysdate, max(logindate)) as lastlogingap 
from tbl_loginhistory
where fk_userid = 'leess'
) H;


--- 회원가입만하고서 로그인을 하지 않은 경우에는 tbl_loginhistory 테이블에 insert 되어진 정보가 없으므로 
--- 회원가입한 날짜를 마지막으로 로그인한 날짜로 간주 한다.
SELECT userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender,
       birthyyyy, birthmm, birthdd, coin, point, registerday, pwdchagegap, 
       nvl(lastlogingap, trunc(months_between(sysdate,registerday))) as lastlogingap
FROM
(
select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender
    , substr(birthday,1,4) as birthyyyy, substr(birthday,6,2) as birthmm, substr(birthday,9,2) as birthdd 
    , coin, point, to_char(registerday, 'yyyy-mm-dd') as registerday
    , trunc(months_between(sysdate, lastpwdchangedate)) as pwdchagegap
from tbl_member
where status=1 and userid='test' and pwd='def3dfc42d7afe9dd50425167f313021a1a0acdc19ea30a682f88ddf86ef3ad5'
) M
CROSS JOIN
(
select months_between(sysdate, max(logindate)) as lastlogingap 
from tbl_loginhistory
where fk_userid = 'test'
) H;

