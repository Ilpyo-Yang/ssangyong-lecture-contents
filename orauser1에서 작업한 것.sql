show user;
-- USER이(가) "ORAUSER1"입니다.

select * from tab;

create table tbl_emp
(empno  number(4)
,ename  varchar2(20)
);
-- Table TBL_EMP이(가) 생성되었습니다.

insert into tbl_emp(empno, ename) values(1001, '홍길동');

commit;

select *
from tbl_emp;

select *
from orauser1.tbl_emp;
-- 원래는 소유주명.테이블명 인데 소유주명을 생략하면 자기자신의 것으로 본다.

select *
from tbl_emp;

select *
from hr.employees;
-- ORA-00942: table or view does not exist
-- hr.employees; 테이블은 존재하지만 ORAUSER1 한테는 hr.employees; 테이블을 select 하는 권한이 없기 때문에 위와 같은 오류가 나온다.

select *
from hr.employees;

select *
from employees;
-- 소유주명 안쓰면 자기꺼

update hr.employees set last_name = 'KING'
where employee_id = 100;
-- 01031. 00000 -  "insufficient privileges"
-- hr.employees 테이블에서 update 권한이 없다는 말이다.

update hr.employees set last_name = 'KING'
where employee_id = 100;
-- 1 행 이(가) 업데이트되었습니다.

commit;

delete from hr.employees where department_id is null;
-- 01031. 00000 -  "insufficient privileges"
-- hr.employees 테이블에서 delete 권한이 없다는 말이다.

delete from hr.employees where department_id is null;
-- 1 행 이(가) 삭제되었습니다.

rollback;

------------------------------------------------------------------------------
grant select on tbl_emp to hr;
-- Grant을(를) 성공했습니다.








