show user;
-- USER이(가) "HR"입니다.

select *
from dba_users;
-- ORA-00942: table or view does not exist
-- 관리자만 조회할 수 있는 것이지 일반 사용자인 hr은 조회가 불가하다.

-- *** ORACLE은 관계형 데이터베이스(Relation DataBase) 관리 시스템(Management System)이다. ***
--              RDBMS(Relation DataBase Management System) 
-- 관계형 데이터베이스는 데이터를 열(column, field)과 행(row, record, tuple) 으로 이루어진 테이블(table, entity, 개체) 형태로 저장한다.

select *
from DEPARTMENTS;  -- sql 명령어는 대,소문자를 구분하지 않습니다.

select *
from departments;

select *
from Departments
where department_name = 'Sales';  -- 테이블명과 컬럼명도 대,소문자를 구분하지 않습니다.

select *
from Departments
where dePARTment_NAME = 'Sales';

select *
from Departments
where department_name = 'SALES';  -- 저장되어진 데이터값 만큼은 대,소문자를 구분합니다!!

select *
from Departments
where department_name = 'sales';

select *
from Departments
where department_name = 'IT';

select *
from Departments
where department_name = 'It';

-----------------------------------------------------------------------
select *
from DEPARTMENTS; -- "부서" 테이블

describe DEPARTMENTS;  -- DEPARTMENTS 테이블의 컬럼(column)의 정보를 알려주는 것이다.
-- 또는 
desc DEPARTMENTS;
/*
이름              널?       유형           
--------------- -------- ------------ 
DEPARTMENT_ID   NOT NULL NUMBER(4)      => 숫자타입     NOT NULL 은 반드시 데이터를 입력해야 한다는 뜻이다.
DEPARTMENT_NAME NOT NULL VARCHAR2(30)   => 문자열타입
MANAGER_ID               NUMBER(6)      없는 것이나 NULL 은 같은데 데이터를 입력하든 입력하지 않든 모두 허용한다는 뜻이다.
LOCATION_ID              NUMBER(4)
*/

select *
from EMPLOYEES;  -- "사원" 테이블

desc employees;
/*
이름             널?       유형           
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)    
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE            => 날짜타입
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2)  
COMMISSION_PCT          NUMBER(2,2)     커미션(수당)퍼센테이지가 0.2라 함은 기본급여의 20%라는 말이다.  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)
*/

select *
from Locations;  -- 부서의 위치정보를 알려주는 테이블

select *
from COUNTRIES;  -- 국가정보를 알려주는 테이블

select *
from REGIONS;  -- 대륙정보를 알려주는 테이블

/*
    === 아주아주 중요!!!!!!!! 필수 암기!!!!!!!! ===
    === 어떠한 테이블(또는 뷰)에서 데이터정보를 꺼내오는 명령어인 select 의 처리순서 ===
    select 컬럼명, 컬럼명   -- 5      컬럼명 대신에 *(아스테리크)을 쓰면 모든 컬럼을 뜻하는 것이다.
    from 테이블명(또는 뷰명) -- 1
    where 조건절           -- 2      where 조건절이 뜻하는 것은 테이블명(또는 뷰명)에서 조건에 만족하는 행(row)을 메모리(RAM)에 로딩(올리는 것)해주는 것이다.
    group by 절           -- 3
    having 그룹함수조건절   -- 4
    order by 절           -- 6
*/

---------------------------------------------------------------------------

--- *** NULL 을 처리해주는 함수 *** ---
--- NULL 은 존재하지 않는 것이므로 4칙연산(+ - * /)에 NULL 이 포함되어지면 그 결과는 무조건 NULL 이 된다.
1. NVL

select '안녕하세요'
from dual; -- dual은 select 다음에 나오는 값들을 화면에 보여주기 위한 용도로 쓰이는 가상테이블이다.

select 1+2, 1+null, 3*0, null*0, 2-1, 2-null, 5/2, 5/null
from dual;

select nvl(7,3), nvl(null,3),
       nvl('이순신','거북선'), nvl(null,'거북선')
from dual;
-- 첫번째 값이 null 이 아니므로 1번째 값을 나타냄
-- 두번째 값이 null 이므로 2번째 값을 나타냄


2. NVL2

select nvl2(7,3,2), nvl2(null,3,2),
       nvl2('이순신','거북선','구국영웅'), nvl2(null,'거북선','구국영웅')
from dual;
-- 첫번째 값이 null 이 아니므로 2번째 값을 나타냄
-- 두번째 값이 null 이므로 3번째 값을 나타냄


select *        -- * 이므로 모든 컬럼들을 추출(select)해라는 말이다.
from employees; -- where 절이 없으므로 employees 테이블에 저장되어져 있던 모든 행들을 메모리(RAM)에 퍼올린다.(Loading)

select employee_id, first_name, last_name -- employee_id, first_name, last_name 컬럼들을 추출(select)해라는 말이다.
from employees; -- where 절이 없으므로 employees 테이블에 저장되어져 있던 모든 행들을 메모리(RAM)에 퍼올린다.(Loading)

-- 월급은 기본월급(salary) + 수당(commisson_pct) 이다. 
-- 수당은 commission_pct 컬럼의 값인데 예를 들어 null은 commisson_pct 컬럼의 값이 null 은 수당은 없다는 말이다.
-- commissio_pct 컬럼의 값이 0.2이라 함은 기본월급의 20% 이므로 실제 수당금액은 0.2*salary 이다.

select employee_id as "사원번호"  -- 별칭(별명) alias
       , first_name "이름"       -- 별칭에서 as는 생략가능함
       , last_name 성            -- 별칭에서 ""는 생략가능함
       , salary "기본 급여"       -- 별칭에서 공백을 주고자한다면 반드시 ""로 해주어야 한다
       , commission_pct 커미션 
       , nvl(salary+(salary*commission_pct),salary) as MONTSAL_1
       , nvl2(commission_pct,salary+(salary*commission_pct),salary)  as "montsal_2"
from employees; 


----- *** 비교연산자 *** -----
   1. 같다        = 
   2. 같지않다    !=  <>  ^= 
   3. 크다.작다.  >  < 
   4. 같거나크다. 같거나작다  >=   <= 
   5. NULL 은 존재하지 않는 것이므로 비교대상이 될수가 없다.
      그러므로 비교연산( = != <> ^= > < >= <= )을 할수가 없다.
      그래서 비교연산을 하려면 nvl()함수, nvl2()함수를 사용하여 처리한다.


-- employees 테이블에서 부서번호 30번에 근무하는 사원들만
-- 사원번호, 사원명, 월급, 부서번호를 나타내세요.

-- 오라클에서 컬럼들을 붙일때(연결할때)는 문자 타입이건 숫자 타입이든 날짜 타입이든 관계없이 || 를 쓰면 된다.
select '대한민국'||' '||'서울시'||123||' '||sysdate
from dual;

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where DEPARTMENT_ID = 30;

-- employees 테이블에서 부서번호 NULL인 사원들만
-- 사원번호, 사원명, 월급, 부서번호를 나타내세요.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where department_id = null;
--> 데이터가 출력되지 않는다.
-- 왜냐하면 null은 존재하지 않는 것이므로 비교대상이 될 수 없다.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , nvl(department_id,-9999) as 부서번호
from employees;


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(department_id,-9999) = -9999;

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where department_id is null;  -- null은 is 연산자를 사용하여 구한다.
                              -- department_id 컬럼의 값이 null 인 행들만 RAM(메모리)에 퍼올리는 것이다.


-- employees 테이블에서 부서번호 30번이 아닌 사원들만
-- 사원번호, 사원명, 월급, 부서번호를 나타내세요.


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
   where department_id != 30;
-- where department_id <> 30;
-- where department_id ^= 30;
-- null 값을 가지고 있는 Kimberely Grant 도 제외됨.

desc employees;


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(department_id,-9999) != 30;

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where not nvl(department_id,-9999) = 30;


-- employees 테이블에서 부서번호가 null이 아닌 사원들만
-- 사원번호, 사원명, 월급, 부서번호를 나타내세요.
select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where department_id is not null;
-- 106명(전체 사원 107명)

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where not department_id is null;

-- 정렬(오름차순정렬, 내림차순정렬)을 할때 null 은 존재하지 않는 것이므로 
-- 오라클에서는 가장 큰것으로 간주를 해주고, MS-SQL 에서는 가장 작은것으로 간주를 해버린다.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by first_name||' '||last_name ASC;  -- ASC; 이 오름차순 정렬


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by first_name||' '||last_name DESC;  -- DESC; 이 오름차순 정렬


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by first_name||' '||last_name;  -- ASC; 이나 DESC; 이 없으면 기본은 오름차순 정렬


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 사원명;

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 2 DESC; 


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 4;


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 4 DESC;


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 4 ASC, 3 DESC;
--       1차정렬 2차정렬
-- 부서 오름차순인데 동일 부서 내에서 월급에 내림차순으로 하겠다

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
order by 4, 3 DESC;
--    1차정렬 2차정렬
-- 1차정렬 department_id 의 오름차순으로 정렬 시킨 후
-- 2차정렬 동일한 department_id 의 값에서 salary에 내림차순으로 하겠다.


-- employees 테이블에서 수당퍼센티지가 null 인 사원들만 
-- 사원번호, 사원명, 월급(기본급여+수당금액), 부서번호를 나타내되 
-- 부서번호의 오름차순으로 정렬한 후 동일한 부서번호내에서는 월급의 내림차순으로 나타내세요.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where commission_pct is null
order by 4, 3 DESC;


-- employees 테이블에서 수당퍼센티지가 null 인 아닌 사원들만 
-- 사원번호, 사원명, 월급(기본급여+수당금액), 부서번호를 나타내되 
-- 부서번호의 오름차순으로 정렬한 후 동일한 부서번호내에서는 월급의 내림차순으로 나타내세요.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where commission_pct is not null
order by 4, 3 DESC;


-- employees 테이블에서 월급(기본급여+수당금액)이 10000 보다 큰 사원들만
-- 사원번호, 사원명, 월급(기본급여+수당금액), 부서번호를 나타내되 
-- 부서번호의 오름차순으로 정렬한 후 동일한 부서번호내에서는 월급의 내림차순으로 나타내세요.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(salary+(salary*commission_pct),salary)>10000
order by 4, 3 DESC;


-- employees 테이블에서 부서번호가 50번 부서가 아닌 사원들만
-- 사원번호, 사원명, 월급(기본급여+수당금액), 부서번호를 나타내되 
-- 부서번호의 오름차순으로 정렬한 후 동일한 부서번호내에서는 월급의 내림차순으로 나타내세요.

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(department_id,1) != 50
-- 또는 where not nvl(department_id,1) = 50
order by 4, 3 DESC;

----------------------------------------------------------------------------

/*
   === AND, OR, NOT 연산자가 혼용되어지면 우선순위를 따르는데 
       NOT > AND > OR 의 순위를 따라간다. 
       우선순위에 있어서 최우선은 () 괄호 이다.
       
       OR 연산자와 같은 것이 IN() 이다. IN()는 괄호가 있는 OR 이다.
       
       범위연산자가 있는데 between A and B 이 A 이상 B 이하를 나타내는 것이다.
*/

select 2+3*4  -- 14
from dual;

/*
      employees 테이블에서 부서번호가 30, 50, 60번 부서에 근무하는 사원들중에 
      연봉(월급*12)이 20000 이상 60000 이하인 사원들만
      사원번호, 사원명, 연봉(월급*12), 부서번호를 나타내되
      부서번호의 오름차순으로 정렬한 후, 연봉의 내림차순으로 정렬하여 출력하세요.
*/

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary)*12 as 연봉
       , department_id as 부서번호
from employees
where department_id = 30 or department_id = 50 or department_id = 60
      and nvl(salary+(salary*commission_pct),salary)*12>=20000 
      and nvl(salary+(salary*commission_pct),salary)*12<=60000
order by 4, 3 desc;
-- !!! AND 와 OR 가 혼용되어지면 우선순위는 AND 가 먼저 실행된다. !!!


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary)*12 as 연봉
       , department_id as 부서번호
from employees
where (department_id = 30 or department_id = 50 or department_id = 60)
      and nvl(salary+(salary*commission_pct),salary)*12>=20000 
      and nvl(salary+(salary*commission_pct),salary)*12<=60000
order by 4, 3 desc;
-- !!! 연산자의 우선순위에서 괄호()가 제일 우선한다. !!! --

