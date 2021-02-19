set hidden param parseThreshold = 150000;

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
       
       범위연산자가 있는데 between A and B 은 A 이상 B 이하를 나타내는 것이다.
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


select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary)*12 as 연봉
       , department_id as 부서번호
from employees
where department_id in(30,50,60)
      and nvl(salary+(salary*commission_pct),salary)*12 between 20000 and 60000
order by 4, 3 desc;
-- 대용량 데이터베이스인 경우 in 보다는 or를, between A and B 보다는 >= <= 를 사용할것을 권장한다.
-- 왜냐하면 in 은 내부적으로 or 로 변경되어서 사용되고, 
-- 또한 between A and B 도 >= <= 로 변경되어서 사용되어지기 때문이다.
-- 대용량 데이터베이스의 기준은 어떤 테이블의 행의 갯수가 100만건을 넘을 경우를 말한다.
-- 소규모 데이터베이스의 기준은 어떤 테이블의 행의 갯수가 1만건 미만인 경우를 말한다.


/*
      employees 테이블에서 부서번호가 50, 80번 부서에 근무하지 않는 사원들중에 
      월급이 4000 이상인 사원들만 사원번호, 사원명, 월급, 부서번호를 나타내되
      부서번호의 오름차순으로 정렬한 후, 월급의 내림차순으로 정렬하여 출력하세요.
*/

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(department_id, -9999) not in (50,80) and 
      nvl(salary+(salary*commission_pct),salary) >= 4000
order by 4, 3 desc;

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where nvl(department_id,-9999) != 50 and 
      nvl(department_id,-9999) != 80 and
      nvl(salary+(salary*commission_pct),salary) >= 4000
order by 4, 3 desc;

-- 또는

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct),salary) as 월급
       , department_id as 부서번호
from employees
where not nvl(department_id,-9999) in(50,80) and 
      nvl(salary+(salary*commission_pct),salary) >= 4000
order by 4, 3 desc;

 
--- *** ===== 범위 연산자 ===== *** ---
--     >   <   >=   <= 
--     between A and B 
--     범위 연산자에 사용되는 데이터인 A와 B는 숫자 뿐만아니라 문자, 날짜까지 모두 사용가능하다.

desc employees;
/*
    HIRE_DATE (입사일자) DATE (날짜타입) 
    ==> DATE 타입의 기본적인 표현방식은 'RR/MM/DD'으로 나타내어진다.
        RR 은 년도의 2자리만 나타내어주는데 50 ~ 99 은 1950 ~ 1999 을 말하는 것이다.
        RR 은 년도의 2자리만 나태내어주는데 00 ~ 49 은 2000 ~ 2049 을 말하는 것이다.
        MM 은 월이고, DD 는 일이다.
*/

-- ***  ==== 현재시각을 알려주는 것 ==== *** --
select sysdate, current_date, localtimestamp, current_timestamp, systimestamp
from dual;
-- 21/02/08

select sysdate, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')
       , to_char(sysdate,'yyyy-mm-dd am hh:mi:ss')
       , to_char(sysdate,'yyyy-mm-dd pm hh:mi:ss')
from dual;
-- 2021-02-08 10:01:28
-- 2021-02-08 오전 10:04:53


-- employees 테이블에서 입사일자가 2005년 1월 1일부터 2006년 12월 31일까지 입사한 사원들만
-- 사원번호, 사원명, 입사일자를 나타내세요

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
       , hire_date as 입사일자
from employees
where '05/01/01' <= hire_date and hire_date <= '06/12/31'
order by 3;

select employee_id as 사원번호
       , first_name||' '||last_name as 사원명
--     , hire_date as 입사일자
       , to_char(hire_date,'yyyy-mm-dd') as 입사일자
from employees
where hire_date between '05/01/01' and '06/12/31'
order by 3;
-- 146	Karen Partners	05/01/05	2005-01-05


'A' --> 65
'a' --> 97
'0' --> 48
' ' --> 32

select ascii('A'), ascii('a'), ascii('0'), ascii(' ')
from dual;
-- 65	97	48	32

select chr(65), chr(97), chr(48), chr(32)
from dual;
-- A	a	0	 

-- employees 테이블에서 first_name 컬럼의 값이 'Elj' 부터 'H'까지인 데이터를 가지는 사원들만
-- first_name 을 출력하세요.
select first_name
from employees
where 'Elj' <= first_name and first_name <= 'I'
order by 1;

-- 또는

select first_name
from employees
where first_name between 'Elj' and 'I'
order by 1;



-- *** employees 테이블에 jubun(주민번호) 이라는 컬럼을 추가하겠다 *** --
-- jubun(주민번호) 컬럼의 값을 입력할 때는 '-'는 빼고 숫자로만 입력할 것입니다.
-- 그렇다면 jubun(주민번호) 컬럼의 데이터타입은 숫자가 아니라 문자 타입이어야 한다!!!
-- 왜냐하면 맨 앞 첫자리에 0이 올 수 있으므로 숫자타입을 사용하면 0이 생략되어지므로 
-- 반드시 문자 타입으로 해야 한다.

select 9710201234567,'9710201234567'
from dual;
-- 9710201234567	9710201234567
-- 오른쪽 맞춤 숫자, 왼쪽 맞춤 문자

select 0110204234567,'0110204234567'
from dual;
-- 110204234567	0110204234567

select 010,'010'
from dual;
-- 10	010

alter table employees
add jubun varchar2(13); 
-- employees 테이블에 문자열 최대 13byte까지 입력이 가능한 컬럼명이 jubun 인 것을 추가한다.

desc employees;
-- JUBUN              VARCHAR2(13)

select *
from employees;

-- employees 테이블에서 사원번호가 100 에 해당하는 사원의 jubun 컬럼의 값을 '6010151234567'로 변경(수정) 하세요.
update employees set jubun = '6010151234567'  -- = 은 값을 대입하는 것을 의미하고, 
where employee_id = 100;  -- = 은 일치하는 것을 의미한다.

rollback;  -- 변경된 사항들을 취소한다. commit 한 다음에는 rollback 해봐야 취소불가하다.

update employees set jubun = '6010151234567'  
where employee_id = 100;  

commit;    -- 변경된 사항들을 disk file에 저장한다.

update employees set jubun = '8510151234567'
where employee_id = 101;

update employees set jubun = '6510152234567'
where employee_id = 102;

update employees set jubun = '7510151234567'
where employee_id = 103;

update employees set jubun = '6110152234567'
where employee_id = 104;

update employees set jubun = '6510151234567'
where employee_id = 105;

update employees set jubun = '6009201234567'
where employee_id = 106;

update employees set jubun = '0803153234567'
where employee_id = 107;

update employees set jubun = '0712154234567'
where employee_id = 108;

update employees set jubun = '8810151234567'
where employee_id = 109;

update employees set jubun = '8908152234567'
where employee_id = 110;

update employees set jubun = '9005052234567'
where employee_id = 111;

update employees set jubun = '6610151234567'
where employee_id = 112;

update employees set jubun = '6710151234567'
where employee_id = 113;

update employees set jubun = '6709152234567'
where employee_id = 114;

update employees set jubun = '6110151234567'
where employee_id = 115;

update employees set jubun = '6009301234567'
where employee_id = 116;

update employees set jubun = '6110152234567'
where employee_id = 117;

update employees set jubun = '7810151234567'
where employee_id = 118;

update employees set jubun = '7909151234567'
where employee_id = 119;

update employees set jubun = '7702152234567'
where employee_id = 120;

update employees set jubun = '7009151234567'
where employee_id = 121;

update employees set jubun = '7111011234567'
where employee_id = 122;

update employees set jubun = '8010131234567'
where employee_id = 123;

update employees set jubun = '8110191234567'
where employee_id = 124;

update employees set jubun = '9012132234567'
where employee_id = 125;

update employees set jubun = '9406251234567'
where employee_id = 126;

update employees set jubun = '9408252234567'
where employee_id = 127;

update employees set jubun = '9204152234567'
where employee_id = 128;

update employees set jubun = '8507251234567'
where employee_id = 129;

update employees set jubun = '6511111234567'
where employee_id = 130;

update employees set jubun = '0010153234567'
where employee_id = 131;

update employees set jubun = '0005254234567'
where employee_id = 132;

update employees set jubun = '0110194234567'
where employee_id = 133;

update employees set jubun = '0412154234567'
where employee_id = 134;

update employees set jubun = '0503253234567'
where employee_id = 135;

update employees set jubun = '9510012234567'
where employee_id = 136;

update employees set jubun = '9510021234567'
where employee_id = 137;

update employees set jubun = '9610041234567'
where employee_id = 138;

update employees set jubun = '9610052234567'
where employee_id = 139;

update employees set jubun = '7310011234567'
where employee_id = 140;

update employees set jubun = '7310092234567'
where employee_id = 141;

update employees set jubun = '7510121234567'
where employee_id = 142;

update employees set jubun = '7612012234567'
where employee_id = 143;

update employees set jubun = '7710061234567'
where employee_id = 144;

update employees set jubun = '7810052234567'
where employee_id = 145;

update employees set jubun = '6810251234567'
where employee_id = 146;

update employees set jubun = '6811062234567'
where employee_id = 147;

update employees set jubun = '6712052234567'
where employee_id = 148;

update employees set jubun = '6011251234567'
where employee_id = 149;

update employees set jubun = '6210062234567'
where employee_id = 150;

update employees set jubun = '6110191234567'
where employee_id = 151;

update employees set jubun = '5712062234567'
where employee_id = 152;

update employees set jubun = '5810231234567'
where employee_id = 153;

update employees set jubun = '6311051234567'
where employee_id = 154;

update employees set jubun = '6010182234567'
where employee_id = 155;

update employees set jubun = '6110191234567'
where employee_id = 156;

update employees set jubun = '6210112234567'
where employee_id = 157;

update employees set jubun = '6311132234567'
where employee_id = 158;

update employees set jubun = '8511112234567'
where employee_id = 159;

update employees set jubun = '8710131234567'
where employee_id = 160;

update employees set jubun = '8710072234567'
where employee_id = 161;

update employees set jubun = '9010171234567'
where employee_id = 162;

update employees set jubun = '9112072234567'
where employee_id = 163;

update employees set jubun = '9110241234567'
where employee_id = 164;

update employees set jubun = '9212251234567'
where employee_id = 165;

update employees set jubun = '9310232234567'
where employee_id = 166;

update employees set jubun = '9811151234567'
where employee_id = 167;

update employees set jubun = '9810252234567'
where employee_id = 168;

update employees set jubun = '9910301234567'
where employee_id = 169;

update employees set jubun = '0910153234567'
where employee_id = 170;

update employees set jubun = '1011153234567'
where employee_id = 171;

update employees set jubun = '1006153234567'
where employee_id = 172;

update employees set jubun = '1111154234567'
where employee_id = 173;

update employees set jubun = '1209103234567'
where employee_id = 174;

update employees set jubun = '1207154234567'
where employee_id = 175;

update employees set jubun = '0906153234567'
where employee_id = 176;

update employees set jubun = '0812113234567'
where employee_id = 177;

update employees set jubun = '9810132234567'
where employee_id = 178;

update employees set jubun = '8712111234567'
where employee_id = 179;

update employees set jubun = '8310012234567'
where employee_id = 180;

update employees set jubun = '6510191234567'
where employee_id = 181;

update employees set jubun = '6510221234567'
where employee_id = 182;

update employees set jubun = '6510232234567'
where employee_id = 183;

update employees set jubun = '8512131234567'
where employee_id = 184;

update employees set jubun = '8510182234567'
where employee_id = 185;

update employees set jubun = '7510192234567'
where employee_id = 186;

update employees set jubun = '8512192234567'
where employee_id = 187;

update employees set jubun = '9511151234567'
where employee_id = 188;

update employees set jubun = '7509302234567'
where employee_id = 189;

update employees set jubun = '8510161234567'
where employee_id = 190;

update employees set jubun = '9510192234567'
where employee_id = 191;

update employees set jubun = '0510133234567'
where employee_id = 192;

update employees set jubun = '0810194234567'
where employee_id = 193;

update employees set jubun = '0910183234567'
where employee_id = 194;

update employees set jubun = '1010134234567'
where employee_id = 195;

update employees set jubun = '9510032234567'
where employee_id = 196;

update employees set jubun = '9710181234567'
where employee_id = 197;

update employees set jubun = '9810162234567'
where employee_id = 198;

update employees set jubun = '7511171234567'
where employee_id = 199;

update employees set jubun = '7810172234567'
where employee_id = 200;

update employees set jubun = '7912172234567'
where employee_id = 201;

update employees set jubun = '8611192234567'
where employee_id = 202;

update employees set jubun = '7810252234567'
where employee_id = 203;

update employees set jubun = '7803251234567'
where employee_id = 204;

update employees set jubun = '7910232234567'
where employee_id = 205;

update employees set jubun = '8010172234567'
where employee_id = 206;

commit;

select *
from employees
order by employee_id;


--- *** ===== like 연산자 ===== *** ---
select *
from employees
where department_id = 30;

select *
from employees
where department_id like 30;

/*
      like 연산자와 함께 사용되어지는 % 와 _ 를 wild character 라고 부른다.
      like 연산자와 함께 사용되어지는 % 의 뜻은 글자가 있든지(글자수와는 관계없음) 없든지 관계없다라는 말이고,
      like 연산자와 함께 사용되어지는 _ 의 뜻은 반드시 아무글자 1개만을 뜻하는 것이다.
*/

-- employees 테이블에서 여자 1990년생과 남자 1991년생의 사원들만 사원번호, 사원명, 주민번호를 나타내세요.
select employee_id as 사원번호,
       first_name||' '||last_name as 사원명,
       jubun as 주민번호
from employees
where jubun like '90____2%' or jubun like '91____1%';

-- employees 테이블에서 first_name 컬럼의 값이 'J'로 시작하는 사원들만 사원번호, 이름, 성, 기본급여를 나타내세요.
select employee_id as 사원번호,
       first_name as 이름,
       last_name as 성,
       salary as 기본급여
from employees
where first_name like 'J%';

-- employees 테이블에서 first_name 컬럼의 값이 'S'로 끝나는 사원들만 사원번호, 이름, 성, 기본급여를 나타내세요.
select employee_id as 사원번호,
       first_name as 이름,
       last_name as 성,
       salary as 기본급여
from employees
where first_name like '%s';

-- employees 테이블에서 first_name 컬럼의 값 중에 'ee'라는 글자가 들어있는 사원들만 사원번호, 이름, 성, 기본급여를 나타내세요.
select employee_id as 사원번호,
       first_name as 이름,
       last_name as 성,
       salary as 기본급여
from employees
where first_name like '%ee%';

-- employees 테이블에서 first_name 컬럼의 값 중에 'e'가 2개 이상 들어있는 사원들만 사원번호, 이름, 성, 기본급여를 나타내세요.
select employee_id as 사원번호,
       first_name as 이름,
       last_name as 성,
       salary as 기본급여
from employees
where first_name like '%e%e%';

-- employees 테이블에서 last_name 컬럼의 값이 첫 글자는 'F'이고 두번째 글자는 아무거나 이고
-- 세번째 글자는 소문자 'e'이며 네번째 부터는 글자가 있든지 없든지 상관없는 사원들만 사원번호, 이름, 성, 기본급여를 나타내세요.
select employee_id as 사원번호,
       first_name as 이름,
       last_name as 성,
       salary as 기본급여
from employees
where last_name like 'F_e%';


  -- escape 문자
  -- *** like 연산자와 함께 사용되어지는 % 와 _ 는 어떤 뜻을 가지고 있는 wild character 인데 
  --     이러한 wild character 기능에서 탈출시키도록 해본다. *** --
  create table tbl_watch
  (watchname   Nvarchar2(10)    -- varchar2(10)은 최대 10byte까지만 허용.          '쌍용교육센터' --> 12byte  'oravle' --> 6byte
  ,bigo        Nvarchar2(100)   -- Nvarchar2(10)은 글자수가 최대 10글자까지만 허용.  '쌍용교육센터' --> 6글자   'oravle' --> 6글자
  );
  
  insert into tbl_watch(watchname, bigo)
  values('금시계', '순금 99.99% 함유 고급시계');
  
  insert into tbl_watch(watchname, bigo)
  values('은시계', '고객만족도 99.99점 획득한 고급시계');
  
  commit;
  
  select *
  from tbl_watch;


 -- tbl_watch 테이블에서 bigo 컬럼에 99.99% 라는 글자가 들어있는 행만 추출하세요 --
  select *
  from tbl_watch
  where bigo like '%99.99\%%' escape '\';
  -- escape 문자로 '\'을 주었으므로 '\' 다음에 나오는 % 1개는 wild character 기능에서 탈출시키므로 %는 진짜 퍼센트(%)로 인식된다.

  select *
  from tbl_watch
  where bigo like '%99.992%%' escape '2';
  -- escape 문자로 '2'을 주었으므로 '2' 다음에 나오는 % 1개는 wild character 기능에서 탈출시키므로 %는 진짜 퍼센트(%)로 인식된다.

  select *
  from tbl_watch
  where bigo like '%99.99a%%' escape 'a';
  -- escape 문자로 'a'을 주었으므로 'a' 다음에 나오는 % 1개는 wild character 기능에서 탈출시키므로 %는 진짜 퍼센트(%)로 인식된다.




----------------------------------------------------------------------------
    --->> 단일행 함수 <<---
    /*
        ※ 단일행 함수의 종류
 
        1. 문자함수
        2. 숫자함수
        3. 날짜함수
        4. 변환함수
        5. 기타함수
    */

    --->> 1. 문자함수 <<---
    -- 1.1 upper('문자열') ==> '문자열'을 모두 대문자로 변환시켜주는 것.
    select 'kOreA SEoul', upper('kOreA SEoul')
    from dual;
    -- kOreA SEoul	KOREA SEOUL
    
    -- 1.2 lower('문자열') ==> '문자열'을 모두 소문자로 변환시켜주는 것.
    select 'kOreA SEoul', lower('kOreA SEoul')
    from dual;
    -- kOreA SEoul	korea seoul
    
    -- 1.3 initcap('문자열') ==> '문자열'을 단어별(구분자가 공백) 첫 글자만 대문자, 나머지는 모두 소문자로 변환시켜주는 것.
    select 'kOreA SEoul', initcap('kOreA SEoul')
    from dual;
    -- kOreA SEoul	Korea Seoul
    
    select *
    from employees
    where last_name = 'King';
    
    select * -- last_name, upper(last_name), lower(last_name)
    from employees
    where lower(last_name) = lower('king');
    
    select *
    from employees
    where lower(last_name) = lower('KING');
    
    -- 1.4 substr('문자열', 시작글자번호, 뽑아야할 글자길이) 
    --     ==> '문자열' 중에서 문자열의 특정일부분을 선택해올때 사용한다.
    
    select '쌍용교육센터'
            ,substr('쌍용교육센터',2,3) -- '쌍용교육센터'에서 2번째 글자인 '용'부터 3글자만 뽑아온다.
            ,substr('쌍용교육센터',2) -- '쌍용교육센터'에서 2번째 글자인 '용'부터 끝까지 뽑아온다.
    from dual;
    -- 용교육  용교육센터
    
    
    
    -- *** employees 테이블에서 성별이 '여자'인 사원들만 사원번호, 사원명, 주민번호를 나타내세요. *** --
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           jubun as 주민번호
    from employees
    where substr(jubun,7,1) in ('2','4')
    order by 1;
    
    
    
    -- *** employees 테이블에서 1990~1995년에 태어난 사원들 중 
    --     성별이 '남자'인 사원들만 사원번호, 사원명, 주민번호를 나타내세요. *** --
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           jubun as 주민번호
    from employees
    where substr(jubun,0,2) between '90' and '95'
          and substr(jubun,7,1) = '1';
          
    
    -- 1.5 instr : 어떤 문자열에서 명명된 문자열의 위치를 알려주는 것 *** --
    
    select instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 1, 1)
    from dual;
    /*
        '쌍용교육센터 서울교육대학교 교육문화원' 에서 '교육'이 나온 위치를 찾는데
        출발점은 1번째부터 1번째로 나오는 '교육'의 위치를 알려달라는 말이다.
    */
    -- 3
    
    
    select instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 1, 2)
    from dual;
    /*
        '쌍용교육센터 서울교육대학교 교육문화원' 에서 '교육'이 나온 위치를 찾는데
        출발점은 2번째부터 1번째로 나오는 '교육'의 위치를 알려달라는 말이다.
    */
    -- 10
    
   
    select instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 4, 1)
    from dual;
    /*
        '쌍용교육센터 서울교육대학교 교육문화원' 에서 '교육'이 나온 위치를 찾는데
        출발점은 4번째부터 1번째로 나오는 '교육'의 위치를 알려달라는 말이다.
    */
    -- 10 
    
    select instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 4, 3)
            -- 0    0은 없다라는 말이다.
         , instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 1)
            -- 3    출발점만 나오면 뒤에 , 1 이 생략된 것이다.
         , instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', 4)
            -- 10       
    from dual;
    
    
    -- *** 1.6 reverse : 어떤 문자열을 거꾸로 보여주는 것이다. *** --
    
    select 'ORACLE', reverse('ORACLE')
            , '대한민국', reverse('대한민국'), reverse(reverse('대한민국')) 
    from dual;
    -- ORACLE	ELCARO	대한민국	�����	대한민국
    
    
    
    -- [퀴즈] --
  create table tbl_files
  (fileno      number(3)
  ,filepath    varchar2(200)
  );
  
  insert into tbl_files(fileno, filepath)
  values(1, 'c:\myDocuments\resume.hwp');
  
  insert into tbl_files(fileno, filepath)
  values(2, 'd:\mymusic.mp3');
  
  insert into tbl_files(fileno, filepath)
  values(3, 'c:\myphoto\2020\08\face.jpg');
  
  commit;
  
  
  select fileno, filepath
  from tbl_files;
  
  
  -- 아래와 같이 나오도록 하세요 --
  /*
    -------------------------------
     파일번호       파일명     
    -------------------------------
        1	    resume.hwp
        2	    mymusic.mp3
        3	    face.jpg
  */
  
    
  select fileno as 파일번호, 
         reverse(substr(reverse(filepath),1,instr(reverse(filepath),'\',1)-1)) as 파일명
  from tbl_files;
  -- 모든 행을 올리는 것으로 where 절 작성하는 것이 아니다.


    select instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', -1, 1)
            -- 16   출발점에 -(음수)를 주면 오른쪽부터 출발이 역순으로 이루어진다. 즉 방향이 오른쪽에서부터 왼쪽으로 나간다.    
         , instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', -6, 2)
            -- 3    출발점만 나오면 뒤에 , 1 이 생략된 것이다.
         , instr('쌍용교육센터 서울교육대학교 교육문화원', '교육', -1)
            -- 16       
    from dual;
    
  
  select fileno AS 파일번호, 
         substr(filepath, instr(filepath, '\', -1) + 1 ) AS 파일명
  from tbl_files;
  
  
  --- **** 1.7  lpad : 왼쪽부터 문자를 자리채움 **** --
  --- **** 1.8  rpad : 오른쪽부터 문자를 자리채움 **** --
   select lpad('교육센터', 20, '*') -- 20byte를 확보해서 거기에 '교육센터'를 넣습니다. 넣은 후 빈공간(12byte)이 있으면 왼쪽부터 * 로 채워라.
        , rpad('교육센터', 20, '*') -- 20byte를 확보해서 거기에 '교육센터'를 넣습니다. 넣은 후 빈공간(12byte)이 있으면 오른쪽부터 * 로 채워라.
   from dual;
  
  
  --- **** 1.9   ltrim : 왼쪽부터 문자를 제거한다. **** --
  --- **** 1.10  rtrim : 오른쪽부터 문자를 제거한다. **** --
  --- **** 1.11  trim : 왼쪽,오른쪽부터 공백문자를 제거한다. **** --
   
   select ltrim('abbbcccccdaabbccdTabbdddabcdSSS', 'abcd'),
          rtrim('abbbcccccdaabbccdTabbdddabcd', 'abcd'),
          rtrim( ltrim('abbbcccccdaabbccdTdabcSabbdddabcd', 'abcd'), 'abcd')
   from dual;
   -- TabbdddabcdSSS    abbbcccccdaabbccdT     TdabcS
   
   
   select '쌍용' || '               교육             센터'
        , '쌍용' || ltrim('               교육             센터')
        , '쌍용                 ' || '교육             센터'
        , rtrim('쌍용                 ') || '교육             센터'
        , '쌍용' || trim('             교육             ') || '센터'
   from dual;
   -- 쌍용               교육             센터	
   -- 쌍용교육             센터	
   -- 쌍용                 교육             센터	
   -- 쌍용교육             센터	
   -- 쌍용교육센터
  
  
  --- **** 1.12  translate  **** --
   select translate('010-3456-7890' 
                   ,'0123456789-'
                   ,'영일이삼사오육칠팔구#')
   from dual;
   -- 영일영#삼사오육#칠팔구영
   -- 1:1 맵핑 숫자 0 은 한글 영 으로 바꿔라 
   
   
   --- **** 1.13  replace  **** --
   select replace('쌍용교육센터 서울교육대학교 교육문화원'
                 ,'교육'
                 ,'education')
   from dual;
   -- 쌍용education센터 서울education대학교 education문화원
   
   
   --- **** 1.14  length => 문자열의 길이를 알려주는 것 **** --
   select length('쌍용center')  -- 8
   from dual;
   
   
   
   ---->> 2. 숫자함수 <<----
   
   
   -- 2.1 mod : 나머지를 구해주는 것.
   select 5/2, mod(5,2), trunc(5/2)
   from dual;
   -- 2.5	1	2
   
   
   -- 2.2 round : 반올림을 해주는 것.
   select 94.5467, round(94.5467), round(94.5467,0), round(94.5467,1), round(94.5467, 2),
                   round(94.5467, -1), round(94.5467, -2)
   from dual;
   -- 94.5467	95	95	94.5    94.55	90  100
   -- round( , 0) 에서 0 은 생략될 수 있다. 0 은 정수 1자리까지만 나타내준다.
   -- 1 은 소수 1자리까지만 나타내준다.
   -- 2 는 소수 2자리까지만 나타내준다.
   -- -1 은 정수 10자리까지만 나타내준다.
   -- -2 은 정수 100자리까지만 나타내준다.
   
   
   -- 2.3 trunc : 절삭해주는 것
   select 94.5467, trunc(94.5467), trunc(94.5467,0), trunc(94.5467,1), trunc(94.5467, 2),
                   trunc(94.5467, -1), trunc(94.5467, -2)
   from dual;


    -- [퀴즈] --
    create table tbl_sungjuk
    (hakbun     varchar2(20) -- 문자열 최대 20byte까지 허용함.
    , name      varchar2(20)
    , kor      number(3)
    , eng      number(3)
    , math     number(3)
    );
    
    select *
    from tbl_sungjuk;
    
    -- *** 데이터 입력하기 *** --
   insert into tbl_sungjuk(hakbun, name, kor, eng, math)
   values('SIST001','한석규',90,92,93);
   
   rollback;
   
   select *
   from tbl_sungjuk;
    
   insert into tbl_sungjuk(hakbun, name, kor, eng, math)
   values('SIST001','한석규',90,92,93);
   
   commit;
   
    insert into tbl_sungjuk(hakbun, name, kor, eng, math)
    values('SIST002','두석규', 100, 100, 100);
    
    insert into tbl_sungjuk(hakbun, name, kor, eng, math)
    values('SIST003','세석규', 71, 72, 73);
    
    insert into tbl_sungjuk(hakbun, name, kor, eng, math)
    values('SIST004','네석규', 89, 87, 81);
    
    insert into tbl_sungjuk(hakbun, name, kor, eng, math)
    values('SIST005','오석규', 60, 50, 40);
    
    insert into tbl_sungjuk(hakbun, name, kor, eng, math)
    values('SIST006','육석규', 80, 81, 87);
   
   commit;
   
   select *
   from tbl_sungjuk;
   
   -----------------------------------------------------------
   학번 성명 국어 영어 수학 총점 평균(소수부 첫째자리까지 나타내되 반올림)
   
   select hakbun as 학번,
          name as 이름,
          kor as 국어, eng as 영어, math as 수학,
          (kor+eng+math) as 총점,
          round((kor+eng+math)/3,1) as 평균,
          to_char(round((kor+eng+math)/3,1),'999.9') as 평균2
    from tbl_sungjuk;
    
    
    -- 2.4 power
     select 2*2*2*2*2, power(2,5)
     from dual;
     
     
     -- 2.5 sqrt
     select sqrt(4), sqrt(16), sqrt(2), sqrt(3) 
     from dual;
    
    
     -- 2.6 sin, cos, tan, asin, acos, atan 
     select sin(90), cos(90), tan(90), 
            asin(0.3), acos(0.3), atan(0.3)
     from dual;
     
     
     -- 2.7 log 
     select log(10,100)
     from dual;
     
        
     -- 2.8 ascii , chr
     select ascii('A'), ascii('a'), ascii('0'), ascii(' ')
     from dual;
     
     select chr(65), chr(97), chr(48), chr(32)
     from dual;
     
     
     -- 2.9 sign ==> 결과값이 양수라면 1, 결과값이 0 이라면 0, 결과값이 음수이라면 -1
     select sign(5-2), sign(5-5), sign(2-5)
     from dual;
     -- 1	0	-1
     
     
     -- 2.10  *** ceil , floor ***
     -- ceil(실수) ==> 입력되어진 실수 보다 큰 최소의 정수를 나타내어준다. 
     -- ceil(정수) ==> 입력되어진 정수 그대로 나온다.
     select ceil(10.1), ceil(-10.1), ceil(10), ceil(-10)
     from dual;
     
     -- floor(실수) ==> 입력되어진 실수 보다 작은 최대의 정수를 나타내어준다. 
     -- floor(정수) ==> 입력되어진 정수 그대로 나온다.
     select floor(10.1), floor(-10.1), floor(10), floor(-10)
     from dual;
     
     
     
     
    
     
     
     
     ---->> 3. 날짜함수 <<----
/*
    HIRE_DATE (입사일자) DATE (날짜타입) 
    ==> DATE 타입의 기본적인 표현방식은 'RR/MM/DD'으로 나타내어진다.
        RR 은 년도의 2자리만 나타내어주는데 50 ~ 99 은 1950 ~ 1999 을 말하는 것이다.
        RR 은 년도의 2자리만 나태내어주는데 00 ~ 49 은 2000 ~ 2049 을 말하는 것이다.
        MM 은 월이고, DD 는 일이다.
*/

    -- ***  ==== 현재시각을 알려주는 것 ==== *** --
    select sysdate, current_date, localtimestamp, current_timestamp, systimestamp
    from dual;
    -- 21/02/08
     
    /*
        ==================
        날짜1 + 숫자 = 날짜2      날짜1 에서 숫자(일수)만큼 더한 값은 날짜2 이다.
        날짜1 - 숫자 = 날짜2      날짜1 에서 숫자(일수)만큼 뻰 값은 날짜2 이다.
        ==================
    */
    
    select  sysdate-1, to_char(sysdate-1, 'yyyy-mm-dd hh24:mi:ss') as 어제시각,
            sysdate, to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') as 현재시각,
            sysdate+1, to_char(sysdate+1, 'yyyy-mm-dd hh24:mi:ss') as 내일시각
    from dual;
    
    --- 단위환산 ---
    /*
        1kg = 1000g
        1g = 1/1000kg
        1일 = 24시간
        1시간 = 1/24일
        1시간 = 60분
        1분 = 1/60시간
        1분 = 60초
        1초 = 1/60분
    */
    
    -- [퀴즈] 현재시각 및 현재시각으로부터 1일 2시간 3분 4초 뒤를 나타내세요.
    select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') as 현재시각,
           to_char(sysdate+1+(2/24)+(3/(24*60))+(4/(24*60*60)), 'yyyy-mm-dd hh24:mi:ss') as 퀴즈
    from dual;
    
    -- 3.1 add_months(날짜, 숫자) 
    --     ==> 숫자가 양수이면 날짜에서 숫자 개월수 만큼 더해준 날짜를 나타내는 것이고,
    --     ==> 숫자가 음수이면 날짜에서 숫자 개월수 만큼 뺀 날짜를 나타내는 것이다.
    --         여기서 숫자의 단위는 개월수 이다.
    select to_char(add_months(sysdate,-2), 'yyyy-mm-dd hh24:mi:ss') as "2개월전시각",
           to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') as 현재시각,
           to_char(add_months(sysdate,2), 'yyyy-mm-dd hh24:mi:ss') as "2개월후시각"
    from dual;
    
    --- *** 오늘 홍길동이 군대에 입대를 했다. 복무기간이 18개월이라면 제대일자(년-월-일)를 구하세요
    select to_char(add_months(sysdate,18),'yyyy-mm-dd') as 제대일자
    from dual;
    
    
    -- 3.2 months_between(날짜1,날짜2)
    --     날짜1 에서 날짜2 를 뺀 값으로 그 결과는 숫자가 나오는데 결과물 숫자의 단위는 개월수 이다.
    --     즉, 두 날짜의 개월 차이를 구할 때 사용하는 것이다.
    select months_between(add_months(sysdate,18), sysdate)
    from dual;      -- 18
    
    -- 날짜1 - 날짜2 은 날짜1 에서 날짜2 를 뺀 값으로 숫자가 나오는데 결과물 숫자의 단위는 일수 이다.
    -- 즉, 두 날짜의 일수 차이를 구할 때 사용하는 것이다.
    select sysdate+3-sysdate
    from dual;      -- 3
    
    
    -- 3.3 last_day(특정날짜)
    --     ==> 특정날짜가 포함된 달력에서 맨 마지막날짜를 알려주는 것이다.
    select last_day(sysdate)
         , to_char(last_day(sysdate), 'yyyy-mm-dd')
         , last_day(to_date('2020-02-08','yyyy-mm-dd'))
         , to_char(last_day(to_date('2020-02-08','yyyy-mm-dd')), 'yyyy-mm-dd')
    from dual;
    
    
    -- 3.4 next_day(특정날짜,'일')   '일'~'토'
    --     ==> 특정날짜로부터 다음번에 돌아오는 가장 빠른 '일'~'토'의 날짜를 알려주는 것이다.
    select sysdate
         , next_day(sysdate, '금')
         , next_day(sysdate, '화')
    from dual;
    -- 21/02/09	    21/02/12	 21/02/16
    
    
    -- 3.5 extract ==> 날짜에서 년, 월, 일을 숫자형태로 추출해주는 것이다.
    select sysdate
         , extract(year from sysdate), to_char(sysdate,'yyyy')
         , extract(month from sysdate), to_char(sysdate,'mm')
         , extract(day from sysdate), to_char(sysdate,'dd')
    from dual;
    -- 21/02/09	 2021	2021	2	02	9	09
    -- 정렬이 왼쪽이라면 날짜 또는 문자, 오른쪽은 숫자
    -- extract는 숫자, to_char는 문자
    
    
    -- 3.6   to_yminterval , to_dsinterval 
    --       to_yminterval 은 년 과 월을 나타내어 연산자가 + 이면 날짜에서 더해주는 것이고, 
    --       to_dsinterval 은 일 시간 분 초를 나타내어 연산자가 + 이면 날짜에서 더해주는 것이다.
    --       연산자에 - 를 쓰면 날짜를 빼주는 것이다. 
    
    --     현재일로부터 1년 2개월 3일 4시간 5분 6초 뒤를 나타내시오.
    select to_char(sysdate, 'yyyy-mm-dd hh24-mi-ss') as 현재시각,
           sysdate + to_yminterval('01-02') + to_dsinterval('003 04:05:06'),
           to_char((sysdate + to_yminterval('01-02') + to_dsinterval('003 04:05:06')),'yyyy-mm-dd hh24-mi-ss') as "1년2개월3일4시간5분6초"
    from dual; 
    -- 2021-02-09 09-28-30	 22/04/12	 2022-04-12 13-33-36
    
    
    
     
    
     
    ---->> 4. 변환함수 <<----
    
    -- 4.1 to_char() ==> 날짜를 문자형태로 변환, 숫자를 문자형태로 변환
    
    -- 날짜를 문자형태로 변환 --
    select to_char(sysdate,'yyyy') as 년도
          ,to_char(sysdate,'mm') as 월
          ,to_char(sysdate,'dd') as 일
          ,to_char(sysdate,'hh24') as "24시간"
          ,to_char(sysdate,'hh am') as "12시간"
          ,to_char(sysdate,'hh pm') as "12시간"
          ,to_char(sysdate,'mi') as 분
          ,to_char(sysdate,'ss') as 초
          ,to_char(sysdate,'q') as 분기 -- 1월~3월 => 1, 4월~6월 => 2, 7월~9월 => 3, 10월~12월 => 4
          -- 호환 때문에 day, dy 안 쓴다
          ,to_char(sysdate,'day') as 요일명 -- 화요일(Windows), Tuesday(linux)
          ,to_char(sysdate,'dy') as 줄인요일명 -- 화(Windows), Tue(linux)
    from dual;
    -- 2021	02	09	11	11 오전	11 오전	41	43	1	화요일	화

    
    select to_char(sysdate,'ddd'), to_char(sysdate,'dd'), to_char(sysdate,'d') 
           -- sysdate의 년도 1월 1일부터(2021년 1월 1일부터) sysdate(현재는 2021년 2월 9일)까지 몇일째 인지를 알려주는 것이다.
           -- sysdate의 월 1일부터(2021년 2월 1일부터) sysdate(현재는 2021년 2월 9일)까지 몇일째 인지를 알려주는 것이다.
           -- sysdate의 주의 일요일부터(2021년 2월 7일부터) sysdate(현재는 2021년 2월 9일)까지 몇일째 인지를 알려주는 것이다.
    from dual;
    -- 040	09	3
    
    select to_char(sysdate,'sssss')  -- sysdate의 0시 0분 0초(현재 2021년 2월 9일 0시 0분 0초)부터 sysdate(2021년 2월 9일 오후 12시 18분 19초) 까지 흘러간 초를 알려주는 것이다.
    from dual;
    
    -- 숫자를 문자형태로 변환 --
    select 1234567890,
           to_char(1234567890, '9,999,999,999'),
           to_char(1234567890, '$9,999,999,999'),
           to_char(1234567890, 'L9,999,999,999')  -- L은 그 나라의 화폐기호 이다.
    from dual;
    -- 1234567890	 1,234,567,890	  $1,234,567,890	     ￦1,234,567,890
    
    select to_char(100,'999.0'), to_char(95.7,'999.0')
    from dual;
    
    
    -- 4.2 to_date() ==> 문자를 날짜형태로 변환
    select '2021-02-05'+1
    from dual;
    -- ORA-00936: missing expression
    
    select to_date('2021-02-05','yyyy-mm-dd')+1,
           to_date('20210205','yyyymmdd')+1
    from dual;
    -- 21/02/06	21/02/06
    
    select to_date('2021-02-29','yyyy-mm-dd')+1
    from dual;
    -- ORA-01839: date not valid for month specified
    -- 달력에 없는 날짜이므로 오류
    
    select to_date('2020-02-29','yyyy-mm-dd')+1
    from dual;
    -- 20/03/01
    
    
    -- 4.3 to_number() ==> 숫자로 되어진 문자를 숫자형태로 변환
    select 2+3, 2+'3', '3', to_number('3'),
           2+to_number('3')
           -- 숫자로의 형변환, 없어도 자동적으로 바뀜
    from dual;
    -- 5  5	 3	 3	 5
    
    select to_number('010')
    from dual;
    -- 10
    
    select to_number('홍길동')
    from dual;
    -- ORA-01722: invalid number
    
    
    
    
    
    ---->> 5. 기타함수 <<----
   
   
    -- 5.1 case when then else end ==> !!!암기!!!
    
    select case 5-2
           when 4 then '5-2=4 입니다.'
           when 1 then '5-2=1 입니다.'
           when 3 then '5-2=3 입니다.'
           else '나는 수학을 몰라요ㅜㅜ'
           end as 결과
    from dual;
    
    select case
           when 4>5 then '4는 5보다 큽니다.'
           when 5>7 then '5는 7보다 큽니다.'
           when 3>2 then '3는 2보다 큽니다.'
           else '나는 수학을 몰라요ㅜㅜ'
           end as 결과
    from dual;
    
    
    -- 5.2 decode ==> !!!암기!!!
    select case 5-2
           when 4 then '5-2=4입니다.'
           when 1 then '5-2=1입니다.'
           when 3 then '5-2=3입니다.'
           else '나는 수학을 몰라요ㅜㅜ'
           end as 결과1
           ,
           decode(5-2, 4, '5-2=4입니다.'
                     , 1, '5-2=1입니다.'
                     , 3, '5-2=3입니다.'
                        , '나는 수학을 몰라요ㅜㅜ') as 결과2
                           
    from dual;
    
    
  --------------------------------------------------------------------------------------------------
   학번 성명 국어 영어 수학 총점 평균(소수부 첫째자리까지 나타내되 반올림) 학점(평균이 90이상 'A' ~ 60 미만이면 'F')
   
   select hakbun as 학번,
          name as 이름,
          kor as 국어, eng as 영어, math as 수학,
          (kor+eng+math) as 총점,
          round((kor+eng+math)/3,1) as 평균,
          to_char(round((kor+eng+math)/3,1),'999.9') as 평균2,
          case trunc(round((kor+eng+math)/3,1),-1)
          when 100 then 'A'
          when 90 then 'A'
          when 80 then 'B'
          when 70 then 'C'
          when 60 then 'D'
          else 'F'
          end as 학점1,
          decode(trunc(round((kor+eng+math)/3,1),-1), 100, 'A'
                    , 90, 'A'
                    , 80, 'B'
                    , 70, 'C'
                    , 60, 'D'
                        , 'F') as 학점2
           
    from tbl_sungjuk;
    
    
    -- 5.3 greatest, least
    select greatest(10,90,100,80), least(10,90,100,80)
    from dual;
    -- 나열되어진 것들 중에서 가장 큰 값을 알려주는 것
    -- 나열되어진 것들 중에서 가장 작은 값을 알려주는 것
    
    select greatest('김유신','윤봉길','허준','고수'),
           least('김유신','윤봉길','허준','고수')
    from dual;
    -- 허준   고수
  
    
    -- 5.4 rank 등수(석차)구하기, dense_rank 서열구하기
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명
           nvl(salary+(salary*commission_pct),salary) as 월급,
           rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수,
           dense_rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수2
    from employees;
    
    
    select department_id as 부서번호,
           employee_id as 사원번호,
           first_name||' '||last_name as 사원명
           nvl(salary+(salary*commission_pct),salary) as 월급,
           
           rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급전체등수,
           dense_rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급전체서열,
           
           rank() over(partition by department_id order by nvl(salary+(salary*commission_pct),salary) desc) as 월급부서내등수,
           dense_rank() over(partition by department_id order by nvl(salary+(salary*commission_pct),salary) desc) as 월급부서내서열
    from employees
    order by 1;
  
    
    -- 5.5 lag, lead(게시판에서 특정글을 조회할 때 많이 사용한다) --
    --     아래에서 한다.
    
  
  
    ------------------------------------------------------------------------  
    ------------------------------------------------------------------------
    
         
/*
   [퀴즈]
   employees 테이블에서 모든 사원들에 대해
   사원번호, 사원명, 주민번호, 성별, 현재나이, 월급, 입사일자, 정년퇴직일 을 나타내세요.

   여기서 정년퇴직일이라 함은 
   해당 사원의 생월이 3월에서 8월에 태어난 사람은 
   해당사원의 나이(한국나이)가 63세가 되는 년도의 8월 31일로 하고,
   해당사원의 생월이 9월에서 2월에 태어난 사람은 
   해당사원의 나이(한국나이)가 63세가 되는 년도의 2월말일(2월28일 또는 2월29일)로 한다.
*/


select employee_id AS 사원번호
       , first_name || ' ' || last_name AS 사원명
       , jubun AS 주민번호
      
       , case substr(jubun,7,1)
         when '1' then '남'
         when '3' then '남'
         else '여'
         end AS 성별1
         
       , decode(substr(jubun,7,1), '1', '남'
                                 , '3', '남'
                                      , '여') AS 성별2  
                                      
       , case 
         when substr(jubun,7,1) in('2','4') then '여'
         else '남'
         end AS 성별3
         
       --  현재년도 - (태어난년도) + 1  AS 현재나이  
       --  태어난년도는 주민번호에서 성별을 알수 있는 값이 '1' 또는 '2' 이라면 1900년대생이고
       --             주민번호에서 성별을 알수 있는 값이 '3' 또는 '4' 이라면 2000년대생이다.
       --  1900 또는 2000 + (주민번호 앞에서 2자리) 하면 태어난년도가 나올것이다.
       , extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1 AS 현재나이  
         
       , nvl(salary + (salary * commission_pct), salary) AS 월급  
       
       , to_char(hire_date , 'yyyy-mm-dd') AS 입사일자
       
       -- 사원의 현재나이가 60세 이라면 3년(3*12개월)뒤 정년퇴직. add_months(현재날짜, 3*12) ==>  add_months(현재날짜, (63-60)*12)  ==>  add_months(현재날짜, (63-현재나이)*12)
       -- 사원의 현재나이가 55세 이라면 8년(8*12개월)뒤 정년퇴직. add_months(현재날짜, 8*12) ==>  add_months(현재날짜, (63-55)*12)  ==>  add_months(현재날짜, (63-현재나이)*12)
       -- 
   --  , add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12)  
       
   --  , to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
   --           , 'yyyy') || '-08-01'  -- || '-02-01'
                
   --  , to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
   --           , 'yyyy') || case when substr(jubun,3,2) between '03' and '08' then '-08-01' else '-02-01' end        
       
   --  , last_day( to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
   --           , 'yyyy') || case when substr(jubun,3,2) between '03' and '08' then '-08-01' else '-02-01' end        
   --   )
         
       , to_char( last_day( to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
                , 'yyyy') || case when substr(jubun,3,2) between '03' and '08' then '-08-01' else '-02-01' end        
         ), 'yyyy-mm-dd') AS 정년퇴직일 
         
  from employees
  order by 1;
  
        
  select 63-(EXTRACT(YEAR FROM sysdate)-case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 + substr(jubun,1,2)+1)
  from employees
  order by 1;
    
    -- [퀴즈] --
    create table tbl_loan
    (gejanum        varchar2(10)   -- 통장번호
    ,loanmoney      number         -- 대출금
    ,interestrate   number(2,2)    -- 이자율   number(2,2) ==> -0.99~0.99
    ,paymentdate    varchar2(2)    -- 이자를내는날짜 '01', '06', '16', '21', 매월말일 '00'
    );           
    
    insert into tbl_loan(gejanum, loanmoney, interestrate, paymentdate)
    values('10-1234-01', 5000, 0.03, '01');
    
    insert into tbl_loan(gejanum, loanmoney, interestrate, paymentdate)
    values('10-1234-02', 5000, 0.03, '06');
    
    insert into tbl_loan(gejanum, loanmoney, interestrate, paymentdate)
    values('10-1234-03', 5000, 0.03, '16');
    
    insert into tbl_loan(gejanum, loanmoney, interestrate, paymentdate)
    values('10-1234-04', 5000, 0.03, '21');
    
    insert into tbl_loan(gejanum, loanmoney, interestrate, paymentdate)
    values('10-1234-05', 5000, 0.03, '00');
    
    commit;
    
    select *
    from tbl_loan;
    
    
    -- 이자납부일이 '토요일','일요일'이라면 '월요일' 납부하도록 만든다.
    
    -- *** 해당 날짜에 대한 요일명을 알아오는 것 *** --
    select to_char(sysdate,'day'),  -- 화요일
           to_char(sysdate,'dy'),   -- 화
           to_char(sysdate,'dy')    -- 3
    from dual;
    
    select decode(to_char(sysdate,'d'),'1','일'
                                       ,'2','월' 
                                       ,'3','화'
                                       ,'4','수'
                                       ,'5','목'
                                       ,'6','금'
                                       ,'7','토') as 오늘의요일명
    from dual;
    
    -- 통장번호 이자를내는날짜 이번달이자납부일 
    select gejanum as 통장번호,
           paymentdate,
           to_char(sysdate,'yyyy-mm-')||paymentdate,
           to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate)
    from tbl_loan;
    
    /*
        decode(to_char(이자납부날짜,'d'),'1',이자납부날짜+1
                                      ,'7',이자납부날짜+2
                                          ,이자납부날짜) as 실제이자납부날짜
    */
    
    -- *** 다시!!!!!!!!!!!!!!!!!!!1
    select gejanum as 통장번호,
           paymentdate,
           to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate)as 이자납부날짜,
           to_date(to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate)),
           decode(to_char(to_date(to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate)),'d'),'1',to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate))+1
                                                                                                                                         ,'7',to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate))+2
                                                                                                                                             ,to_char(sysdate,'yyyy-mm-')||decode(paymentdate,'00',to_char(last_day(sysdate),'dd'),paymentdate))) as 실제이자납부일자                                                                                                    
    from tbl_loan;
     

    select gejanum, paymentdate
             
         , to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                    , paymentdate)
                                                                    
         , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                             , paymentdate) , 'yyyy-mm-dd') AS 이달이자납부날짜                                                         
     /*                                                            
         , decode(to_char(이달이자납부날짜,'d') , '1', 이달이자납부날짜+1
                                              , '7', 이달이자납부날짜+2
                                                   , 이달이자납부날짜) AS 실제이달이자납부일자
     */ 
         , decode(to_char( to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                                             , paymentdate) , 'yyyy-mm-dd') ,'d') 
                                    , '1', to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                                                             , paymentdate) , 'yyyy-mm-dd')+1
                                    , '7', to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                                                             , paymentdate) , 'yyyy-mm-dd')+2
                                         , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                                                             , paymentdate) , 'yyyy-mm-dd')) AS 실제이달이자납부일자
         
        , to_date( to_char( add_months(sysdate, -1) , 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day( add_months(sysdate, -1) ), 'dd') 
                                                                                            , paymentdate) , 'yyyy-mm-dd') AS 전달이자납부날짜 
         
        /*                                                            
             , decode(to_char(전달이자납부날짜,'d') , '1', 전달이자납부날짜+1
                                                  , '7', 전달이자납부날짜+2
                                                       , 전달이자납부날짜) AS 전달이자납부일자
        */ 
        
         , decode(to_char( to_date( to_char(add_months(sysdate,-1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(add_months(sysdate,-1)), 'dd') 
                                                                                                            , paymentdate) , 'yyyy-mm-dd') ,'d') 
                                    , '1', to_date( to_char(add_months(sysdate,-1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(add_months(sysdate,-1)), 'dd') 
                                                                                                            , paymentdate) , 'yyyy-mm-dd')+1
                                    , '7', to_date( to_char(add_months(sysdate,-1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(add_months(sysdate,-1)), 'dd') 
                                                                                                            , paymentdate) , 'yyyy-mm-dd')+2
                                         , to_date( to_char(add_months(sysdate,-1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(add_months(sysdate,-1)), 'dd') 
                                                                                                            , paymentdate) , 'yyyy-mm-dd')) AS 실제전달이자납부일자
    from tbl_loan;     
    
    
    
    
    
---- **** !!!!! 아주 중요중요 아주 !!!!! **** ----
-- 복잡한 SQL(Structured Query Language) == 정형화된 질의어) 을 간단하게 만들어주는 것이
-- VIEW 이다.
-- VIEW는 테이블은 아니지만 select 되어진 결과물을 마치 테이블처럼 보는 것
     
-- VIEW는 2가지 종류가 있다.
-- 첫번째로 inline view가 있고, 두번째로 stored view가 있다.
-- inline view 는 select 구문을 괄호( )를 쳐서 별칭(예:V)을 부여한 것을 말한다.
-- stored view 는 저장된 뷰로써 언제든지 다시 재활용이 가능한 것이다. 


select gejanum, paymentdate
                                                                      
     , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS currentPaymentDate
     
     , to_date( to_char(add_months(sysdate, -1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day( add_months(sysdate, -1) ), 'dd') 
                                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS prevPaymentDate
from tbl_loan; 


--- *** Inline View 생성하기 *** ---
select V.gejanum,
       V.currentPaymentDate,
       decode(to_char(V.currentPaymentDate,'d') , '1', V.currentPaymentDate+1
                                                , '7', V.currentPaymentDate+2
                                                     , V.currentPaymentDate) AS 실제이달이자납부일자,
       v.prevPaymentDate,
       decode(to_char(v.prevPaymentDate,'d') , '1', v.prevPaymentDate+1
                                             , '7', v.prevPaymentDate+2
                                                  , v.prevPaymentDate) AS 실제전달이자납부일자
from
(select gejanum, paymentdate
                                                                      
     , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS currentPaymentDate
     
     , to_date( to_char(add_months(sysdate, -1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day( add_months(sysdate, -1) ), 'dd') 
                                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS prevPaymentDate
 from tbl_loan)V;   -- V가 inline view 이다.
     

--- *** Stored View 생성하기 *** ---
/*
    create or replace view 뷰명  --> 뷰명으로 되어진 view가 없으면 create(생성), 있으면 replace(수정)해라.
    as
    select 문장;
*/

create or replace view view_loan
as
select V.gejanum,
       V.currentPaymentDate,
       decode(to_char(V.currentPaymentDate,'d') , '1', V.currentPaymentDate+1
                                                , '7', V.currentPaymentDate+2
                                                     , V.currentPaymentDate) AS Real_CurrentDate,
       v.prevPaymentDate,
       decode(to_char(v.prevPaymentDate,'d') , '1', v.prevPaymentDate+1
                                             , '7', v.prevPaymentDate+2
                                                  , v.prevPaymentDate) AS Real_PrevDate
from
(select gejanum, paymentdate
                                                                      
     , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS currentPaymentDate
     
     , to_date( to_char(add_months(sysdate, -1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day( add_months(sysdate, -1) ), 'dd') 
                                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS prevPaymentDate
 from tbl_loan)V;   -- V가 inline view 이다.
-- View VIEW_LOAN이(가) 생성되었습니다.     
    
  select *
  from view_loan; 
  
  desc view_loan;
  /*
    이름                 널? 유형           
    ------------------ -- ------------ 
    GEJANUM               VARCHAR2(10) 
    CURRENTPAYMENTDATE    DATE         
    REAL_CURRENTDATE      DATE         
    PREVPAYMENTDATE       DATE         
    REAL_PREVDATE         DATE 
  */
  
  -- 현재 오라클 서버에 접속되어진 사용자(지금은 hr)가 만든 테이블 목록을 조회하겠다
  select * 
  from tab;
  
  select gejanum
        ,currentpaymentdate
        ,case when to_char(real_currentdate, 'mm-dd') in ('01-01','03-01','05-05','06-06','08-15','10-03','10-09','12-25')
              then real_currentdate+1
              else real_currentdate
         end as RealCurrentdate
        ,prevpaymentdate
        ,case when to_char(real_prevdate, 'mm-dd') in ('01-01','03-01','05-05','06-06','08-15','10-03','10-09','12-25')
              then real_prevdate+1
              else real_prevdate
         end as RealPrevdate
  from view_loan;
  
  
  select T.gejanum
        ,T.currentpaymentdate
        ,case to_char(T.RealCurrentdate,'d')
             when '1' then T.RealCurrentdate+1
             when '7' then T.RealCurrentdate+2
             else T.RealCurrentdate
         end as 실제이번달납부일자
        ,T.prevpaymentdate
        ,case to_char(T.RealPrevdate,'d')
             when '1' then T.RealPrevdate+1
             when '7' then T.RealPrevdate+2
             else T.RealPrevdate
         end as 실제저번달납부일자
        ,case to_char(T.RealCurrentdate,'d')
             when '1' then T.RealCurrentdate+1
             when '7' then T.RealCurrentdate+2
             else T.RealCurrentdate
         end -
         case to_char(T.RealPrevdate,'d')
             when '1' then T.RealPrevdate+1
             when '7' then T.RealPrevdate+2
             else T.RealPrevdate
         end as 대출일수 
  from
  (
      select gejanum
            ,currentpaymentdate
            ,case when to_char(real_currentdate, 'mm-dd') in ('01-01','03-01','05-05','06-06','08-15','10-03','10-09','12-25')
                  then real_currentdate+1
                  else real_currentdate
             end as RealCurrentdate
            ,prevpaymentdate
            ,case when to_char(real_prevdate, 'mm-dd') in ('01-01','03-01','05-05','06-06','08-15','10-03','10-09','12-25')
                  then real_prevdate+1
                  else real_prevdate
             end as RealPrevdate
      from view_loan
  )T;
  
    
--- *** Stored View 의 원본소스 알아보기 *** ---
select *
from user_views
where view_name = 'VIEW_LOAN';
-- 데이터값은 대문자로 작성해야 한다.

select text
from user_views
where view_name = 'VIEW_LOAN';
/*
"select V.gejanum,
       V.currentPaymentDate,
       decode(to_char(V.currentPaymentDate,'d') , '1', V.currentPaymentDate+1
                                                , '7', V.currentPaymentDate+2
                                                     , V.currentPaymentDate) AS Real_CurrentDate,
       v.prevPaymentDate,
       decode(to_char(v.prevPaymentDate,'d') , '1', v.prevPaymentDate+1
                                             , '7', v.prevPaymentDate+2
                                                  , v.prevPaymentDate) AS Real_PrevDate
from
(select gejanum, paymentdate
                                                                      
     , to_date( to_char(sysdate, 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day(sysdate), 'dd') 
                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS currentPaymentDate
     
     , to_date( to_char(add_months(sysdate, -1), 'yyyy-mm-') || decode( paymentdate, '00', to_char( last_day( add_months(sysdate, -1) ), 'dd') 
                                                                                         , paymentdate) , 'yyyy-mm-dd') 
       AS prevPaymentDate
 from tbl_loan)V"
*/


--- *** Stored View를 삭제하기 *** ---
select *
from view_loan;

drop view view_loan;
-- View VIEW_LOAN이(가) 삭제되었습니다.

select *
from view_loan;
-- ORA-00942: table or view does not exist

/*
   [퀴즈]
   employees 테이블에서 모든 사원들에 대해
   사원번호, 사원명, 주민번호, 성별, 현재나이, 월급, 입사일자, 정년퇴직일, 정년까지근무개월수 을 나타내세요.

   여기서 정년퇴직일이라 함은 
   해당 사원의 생월이 3월에서 8월에 태어난 사람은 
   해당사원의 나이(한국나이)가 63세가 되는 년도의 8월 31일로 하고,
   해당사원의 생월이 9월에서 2월에 태어난 사람은 
   해당사원의 나이(한국나이)가 63세가 되는 년도의 2월말일(2월28일 또는 2월29일)로 한다.
   
   정년까지근무개월수 ==> 입사일자로부터 정년퇴직일가지 개월차이
   months_between(정년퇴직일, 입사일자)
*/

select V.사원번호
      ,V.사원명
      ,V.주민번호
      ,V.성별
      ,V.현재나이
      ,V.월급
      ,V.입사일자
      ,V.정년퇴직일
      ,trunc(months_between( to_date(V.정년퇴직일,'yyyy-mm-dd'),to_date(V.입사일자,'yyyy-mm-dd'))) as 정년까지근무개월수
      ,trunc(trunc(months_between( to_date(V.정년퇴직일,'yyyy-mm-dd'),to_date(V.입사일자,'yyyy-mm-dd'))) /12) as 정년까지근무년수
      ,trunc(trunc(months_between( to_date(V.정년퇴직일,'yyyy-mm-dd'),to_date(V.입사일자,'yyyy-mm-dd'))) /12)*V.월급 as 정년퇴직금
from
(
    select employee_id AS 사원번호
           , first_name || ' ' || last_name AS 사원명
           , jubun AS 주민번호        
           , case 
             when substr(jubun,7,1) in('2','4') then '여'
             else '남'
             end AS 성별
           , extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1 AS 현재나이  
             
           , nvl(salary + (salary * commission_pct), salary) AS 월급  
           
           , to_char(hire_date , 'yyyy-mm-dd') AS 입사일자
              
           , to_char( last_day( to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
                    , 'yyyy') || case when substr(jubun,3,2) between '03' and '08' then '-08-01' else '-02-01' end        
             ), 'yyyy-mm-dd') AS 정년퇴직일 
             
     from employees
)V;


-- select 절에서 v는 생략가능하다.
-- select employee_id,사원명,주민번호,성별,현재나이,월급,입사일자,정년퇴직일 -- 오류!!
select 사원번호,사원명,주민번호,성별,현재나이,월급,입사일자,정년퇴직일
      ,trunc(months_between( to_date(정년퇴직일,'yyyy-mm-dd'),to_date(입사일자,'yyyy-mm-dd'))) as 정년까지근무개월수
      ,trunc(trunc(months_between( to_date(정년퇴직일,'yyyy-mm-dd'),to_date(입사일자,'yyyy-mm-dd'))) /12) as 정년까지근무년수
      ,trunc(trunc(months_between( to_date(정년퇴직일,'yyyy-mm-dd'),to_date(입사일자,'yyyy-mm-dd'))) /12)*V.월급 as 정년퇴직금
from
(
    select employee_id AS 사원번호
           , first_name || ' ' || last_name AS 사원명
           , jubun AS 주민번호        
           , case 
             when substr(jubun,7,1) in('2','4') then '여'
             else '남'
             end AS 성별
           , extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1 AS 현재나이  
             
           , nvl(salary + (salary * commission_pct), salary) AS 월급  
           
           , to_char(hire_date , 'yyyy-mm-dd') AS 입사일자
              
           , to_char( last_day( to_char( add_months(sysdate, (63-(extract(year from sysdate) - ( case when substr(jubun,7,1) in('1','2') then 1900 else 2000 end + substr(jubun,1,2) ) + 1))*12) 
                    , 'yyyy') || case when substr(jubun,3,2) between '03' and '08' then '-08-01' else '-02-01' end        
             ), 'yyyy-mm-dd') AS 정년퇴직일 
             
     from employees
)V;


create table tbl_members
(userid    varchar2(20)
,passwd    varchar2(20)
,name      varchar2(20)
,addr      varchar2(100)
);

insert into tbl_members(userid, passwd, name, addr)
values('kimys','abcd','김유신','서울');

insert into tbl_members(userid, passwd, name, addr)
values('young2','abcd','이영이','서울');

insert into tbl_members(userid, passwd, name, addr)
values('leesa','abcd','이에리사','서울');

insert into tbl_members(userid, passwd, name, addr)
values('park','abcd','박이남','서울');

insert into tbl_members(userid, passwd, name, addr)
values('leebon','abcd','이본','서울');

commit;

select *
from tbl_members;

select count(*)
from tbl_members;
-- select 되어져 나온 결과물의 행의 개수 5개행


select *
from tbl_members
where userid = 'kimys' and passwd = 'abcd';

select count(*)
from tbl_members
where userid = 'kimys' and passwd = 'abcd';
-- select 되어져 나온 결과물의 행의 개수 1개행


select *
from tbl_members
where userid = 'kimys' and passwd = '1234';


select count(*)
from tbl_members
where userid = 'kimys' and passwd = '1234';
-- select 되어져 나온 결과물의 행의 개수 0개행


select count(*)
from tbl_members
where userid = 'aflejomsa' and passwd = 'abcd';
-- select 되어져 나온 결과물의 행의 개수 0개행


/*
    tbl_members 테이블에서
    userid 및 passwd 가 모두 올바르면 '로그인성공' 을 보여주고,
    userid 는 올바르지만 passwd 가 틀리면 '암호가 틀립니다' 을 보여주고,
    userid 가 틀리면 '아이디가 존재하지 않습니다' 을 보여주려고 한다.
*/

select case (select count(*)
             from tbl_members
             where userid = 'kimys' and passwd = 'abcd')
       when 1 then '로그인성공'
       else (case (select count(*)
                   from tbl_members
                   where userid = 'kimys')
             when 1 then '암호가 틀립니다'
             else '아이디가 존재하지 않습니다'
             end)
       end as 로그인결과
from dual;





create table tbl_board         
(boardno       number          -- 글번호
,subject       varchar2(4000)  -- 글제목  varchar2의 최대크기는 4000byte이다. 4000 보다 크면 오류!!
,content       varchar2(4000) -- 글내용   Nvarchar2의 최대크기는 2000byte이다. 2000 보다 크면 오류!!
,userid        varchar2(40)    -- 글쓴이의 ID  
,registerday   date            -- 작성일자
,readcount     number(10)      -- 조회수               
);
-- ORA-00910: specified length too long for its datatype


 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(1, '안녕하세요', '글쓰기 연습입니다', 'leess', sysdate, 0);
 -- sysdate 는 현재시각을 말한다. 
 
 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(2, '반갑습니다', '모두 취업대박 나십시오', 'eomjh', sysdate, 0);
  
 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(3, '건강하세요', '로또 1등을 기원합니다', 'leess', sysdate, 0);
  
 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(4, '기쁘고 감사함이 넘치는 좋은하루되세요 ', '늘 행복하세요', 'emojh', sysdate, 0);

 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(5, '오늘도 좋은하루되세요', '늘 감사합니다', 'hongkd', sysdate, 0);

 insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
 values(6, '좋은 하루 되시고 건강하시고 부자되시고 늘 행복하세요', '맛있는 점심 드세요', 'leess', sysdate, 0);

 commit;
 
 
 select *
 from tbl_board;
 
 
 -- ** tbl_board 테이블에 저장된 모든 행들을 삭제하기 ** --
 delete from tbl_board; 

 rollback;
 
 select *
 from tbl_board;
 
 delete from tbl_board
 where boardno = 3;
 -- 1 행 이(가) 삭제되었습니다.
 
 delete from tbl_board
 where boardno in(2,5);
 -- 2개 행 이(가) 삭제되었습니다.
 
 delete from tbl_board;
 -- 6개 행 이(가) 삭제되었습니다.
 
 commit;
 
 -- 위에서 insert 한 것을 다시 하세요...
 
 select boardno, subject
 from tbl_board;

 
 -- subject 컬럼의 값의 길이가 16보다 크면 subject 컬럼의 값 중 16글자만 보여주고 뒤에 ...을 붙여서 나타내라.
 select boardno, subject, length(subject),
        case when length(subject) > 16
             then substr(subject,1,16)||'...'
             else subject
        end as 글제목
 from tbl_board
 order by boardno desc;



-- **** lag, lead(게시판에서 특정글을 조회할 때 많이 사용한다) **** --
select boardno, subject, content
from tbl_board;

/*
    ---------------------------------------------------------------------------------------------
     이전글번호  이전글제목         글번호  글제목       글내용                다음글번호     다음글제목
    ---------------------------------------------------------------------------------------------
      null      null               1	안녕하세요	글쓰기 연습입니다           2	       반갑습니다
       1	    안녕하세요          2	    반갑습니다	모두 취업대박 나십시오       3        건강하세요
       2	    반갑습니다          3    	건강하세요	로또 1등을 기원합니다       4         기쁘고 감사함이 넘치는 좋은하루되세요 
    .............................................................................................
       5        오늘도 좋은하루되세요6	좋은 하루 되시고 건강하시고 부자되시고 늘 행복하세요   null    null
*/

select   lag(boardno,1) over(order by boardno asc) as 이전글번호,
         lag(subject,1) over(order by boardno asc) as 이전글제목,
         
         boardno, subject, content,
         
         lead(boardno,1) over(order by boardno asc) as 다음글번호, 
         lead(subject,1) over(order by boardno asc) as 다음글제목
from tbl_board;



select   lag(boardno,2) over(order by boardno asc) as 이전글번호,
         lag(subject,2) over(order by boardno asc) as 이전글제목,
         
         boardno, subject, content,
         
         lead(boardno,2) over(order by boardno asc) as 다음글번호, 
         lead(subject,2) over(order by boardno asc) as 다음글제목
from tbl_board;



-- 숫자가 없으면 1이 생략된 것이다.
select   lag(boardno) over(order by boardno asc) as 이전글번호,
      -- boardno(글번호)의 오름차순으로 정렬했을때 위쪽으로 1칸 올라가서 boardno 값을 얻어온다.
         lag(subject) over(order by boardno asc) as 이전글제목,
      -- boardno(글번호)의 오름차순으로 정렬했을때 위쪽으로 1칸 올라가서 subject 값을 얻어온다.

         boardno, subject, content,
         
         lead(boardno) over(order by boardno asc) as 다음글번호, 
      -- boardno(글번호)의 오름차순으로 정렬했을때 위쪽으로 1칸 내려가서 boardno 값을 얻어온다.
         lead(subject) over(order by boardno asc) as 다음글제목
      -- boardno(글번호)의 오름차순으로 정렬했을때 위쪽으로 1칸 내려가서 subject 값을 얻어온다.
from tbl_board;



-- [퀴즈]
/*
    ---------------------------------------------------------------------------------------------
     이전글번호  이전글제목         글번호  글제목       글내용                다음글번호     다음글제목
    ---------------------------------------------------------------------------------------------
       2	    반갑습니다          3    	건강하세요	로또 1등을 기원합니다       4         기쁘고 감사함이 넘치는 좋은하루되세요 
*/

-- 틀린 해결
select *
from tbl_board
where boardno = 3;

select   lag(boardno) over(order by boardno asc) as 이전글번호,
         lag(subject) over(order by boardno asc) as 이전글제목,

         boardno, subject, content,
         
         lead(boardno) over(order by boardno asc) as 다음글번호, 
         lead(subject) over(order by boardno asc) as 다음글제목
from tbl_board
where boardno=3;



-- 바른해결
select *
from
(
    select   lag(boardno) over(order by boardno asc) as 이전글번호,
             lag(subject) over(order by boardno asc) as 이전글제목,
    
             boardno, subject, content,
             
             lead(boardno) over(order by boardno asc) as 다음글번호, 
             lead(subject) over(order by boardno asc) as 다음글제목
    from tbl_board
)  V
where boardno = 3; 


/*
    -------------------------------------------------------------
    글번호     글제목                          작성일자
    -------------------------------------------------------------
    9723      오늘은 2001년 2월 10일 입니다.    2001-02-10 14:36:40 
    9722      오늘은 2001년 2월 9일 입니다.     2001-02-09 14:36:40 
    .....    ............................    ....................
    .....    ............................    ....................
    
    1         오늘은 2001년 1월 9일 입니다.     2001-01-09 14:36:40  
    
    =============================================================
                    1 2 3 4 5 6 7 8 9 10 다음          ==> "페이지바(Page Bar)"라고 부른다.
             
             이전 11 12 13 14 15 16 17 18 19 11 다음    ==> "페이지바(Page Bar)"라고 부른다.
    
    
    다음은 옛날 것이고, 이전이 가장 최신의 가까운 것이다
*/

-- 게시판에서는 아래와 같이 해야 한다.
select *
from
(
    select   lag(boardno) over(order by boardno desc) as 이전글번호,
             lag(subject) over(order by boardno desc) as 이전글제목,
    
             boardno, subject, content,
             
             lead(boardno) over(order by boardno desc) as 다음글번호, 
             lead(subject) over(order by boardno desc) as 다음글제목
    from tbl_board
)  V
where boardno = 3; 



 --[퀴즈] employees 테이블에서 월급에 대한 전체 등수가 1등부터 10등까지인 사원들만 
 --      사원번호, 사원명, 월급, 월급등수를 나타내세요.
 select employee_id as 사원번호,
       first_name||' '||last_name as 사원명
       nvl(salary+(salary*commission_pct),salary) as 월급,
       rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수,
       dense_rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수2
 from employees
 where rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) between 1 and 10;
 -- 오류!! rank() 및 dense_rank()는 where 절에 사용이 불가하다.
 
 -- 등수를 구하는 해결책은 inline view를 사용해서 구한다!!!!!
select *
from
(    
     select employee_id as 사원번호,
           first_name||' '||last_name as 사원명
           nvl(salary+(salary*commission_pct),salary) as 월급,
           rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수,
           dense_rank() over(order by nvl(salary+(salary*commission_pct),salary) desc) as 월급등수2
     from employees
) V
where 월급등수 between 1 and 10; 




/*
    문제 1. 
    employees 테이블에서 커미션을 받는 사원들만 
    사원번호, 사원명, 기본급여, 수당, 월급을 
    사원번호로 오름차순 정렬후, 월급의 내림차순으로 정렬하여 나타내세요.
    
    ------------------------------------------------------
    사원번호    사원명            기본급여 수당     월급
    ------------------------------------------------------
    145       John Russell       14000   5600   19600
    146       Karen Partners       13500   4050   17550
    147       Alberto Errazuriz   12000   3600   15600
    148       Gerald Cambrault   11000   3300   14300
    149       Eleni Zlotkey       10500   2100   12600
    150       Peter Tucker       10000   3000   13000
    151       David Bernstein       9500   2375   11875
    152       Peter Hall           9000   2250   11250
    153       Christopher Olsen   8000   1600   9600
    154       Nanette Cambrault   7500   1500   9000
    155       Oliver Tuvault       7000   1050   8050
    156       Janette King       10000   3500   13500
    157       Patrick Sully       9500   3325   12825
    158       Allan McEwen       9000   3150   12150
    159       Lindsey Smith       8000   2400   10400
    160       Louise Doran       7500   2250   9750
    161       Sarath Sewall       7000   1750   8750
    162       Clara Vishney       10500   2625   13125
    163       Danielle Greene       9500   1425   10925
    164       Mattea Marvins       7200   720       7920
    165       David Lee           6800   680       7480
    166       Sundar Ande           6400   640       7040
    167       Amit Banda           6200   620       6820
    168       Lisa Ozer           11500   2875   14375
    169       Harrison Bloom       10000   2000   12000
    170       Tayler Fox           9600   1920   11520
    171       William Smith       7400   1110   8510
    172       Elizabeth Bates       7300   1095   8395
    173       Sundita Kumar       6100   610       6710
    174       Ellen Abel           11000   3300   14300
    175       Alyssa Hutton       8800   2200   11000
    176       Jonathon Taylor       8600   1720   10320
    177       Jack Livingston       8400   1680   10080
    178       Kimberely Grant       7000   1050   8050
    179       Charles Johnson       6200   620       6820
*/

    select *
    from employees;
    
    
    select employee_id as 사원번호, 
           first_name||' '||last_name as 사원명,
           salary as 기본급여,
           nvl(salary*commission_pct,salary) as 수당,
           nvl(salary+(salary*commission_pct),salary) as 월급
    from employees
    where commission_pct is not null
    order by 1, 5 desc;
    
        
    select  employee_id AS 사원번호
        , first_name || ' ' || last_name AS 사원명
        , salary AS 기본급여
        , (salary * commission_pct) AS 수당
        , nvl(salary + (salary * commission_pct), salary) AS 월급
    from employees
    where commission_pct is not null 
        and
        commission_pct > 0
    order by 사원번호, 월급 desc;





/*
    문제 2. 
    employees 테이블에서 커미션이 없는 사원들중 남자직원들만 
    부서번호, 사원명, 주민번호, 기본급여를 
    부서번호로 오름차순 정렬후, 사원명의 오름차순으로 정렬하여 나타내세요.
    
    -------------------------------------------------------
    부서번호    사원명             주민번호        기본급여
    -------------------------------------------------------
    30       Alexander Khoo       6110151234567   3100
    30       Guy Himuro           7810151234567   2600
    30       Karen Colmenares   7909151234567   2500
    30       Shelli Baida       6009301234567   2900
    50       Adam Fripp           7009151234567   8200
    50       Curtis Davies       7510121234567   3100
    50       Douglas Grant       7511171234567   2600
    50       Irene Mikkilineni   9406251234567   2700
    50       James Marlow       0010153234567   2500
    50       Jean Fleaur           6510191234567   3100
    50       Joshua Patel       7310011234567   2500
    50       Kelly Chung           9511151234567   3800
    50       Kevin Feeney       9710181234567   3000
    50       Kevin Mourgos       8110191234567   5800
    50       Ki Gee               0503253234567   2400
    50       Laura Bissot       8507251234567   3300
    50       Martha Sullivan       6510221234567   2500
    50       Mozhe Atkinson       6511111234567   2800
    50       Nandita Sarchand   8512131234567   4200
    50       Payam Kaufling       7111011234567   7900
    50       Peter Vargas       7710061234567   2500
    50       Renske Ladwig       9510021234567   3600
    50       Samuel McCain       0910183234567   3200
    50       Sarah Bell           0510133234567   4000
    50       Shanta Vollman       8010131234567   6500
    50       Stephen Stiles       9610041234567   3200
    50       Timothy Gates       8510161234567   2900
    60       Alexander Hunold   7510151234567   9000
    60       David Austin       6510151234567   4800
    60       Diana Lorentz       0803153234567   4200
    60       Valli Pataballa       6009201234567   4800
    70       Hermann Baer       7803251234567   10000
    90       Neena Kochhar       8510151234567   17000
    90       Steven King           6010151234567   24000
    100       Daniel Faviet       8810151234567   9000
    100       Jose Manuel Urman   6610151234567   7800
    100       Luis Popp           6710151234567   6900
*/

    select nvl(department_id, -9999) as 부서번호, 
           first_name||' '||last_name as 사원명,
           jubun as 주민번호,
           salary as 기본급여
    from employees
    where commission_pct is null and
          substr(jubun,7,1) is ('1','3') 
    order by 1;
 

    select department_id AS 부서번호
        , first_name || ' ' || last_name AS 사원명
        , jubun AS 주민번호
        , salary AS 기본급여
    from employees
    where (commission_pct is null 
             or
             commission_pct = 0
            )
            and
            substr(jubun, 7, 1) in ('1','3')
    order by 부서번호, 사원명;  






/*
    문제 3. 
    employees 테이블에서 부서번호 30,50,60,80,100 번 부서에 근무하지 않는 사원들만 
    부서번호, 사원명, 월급을 
    부서번호로 오름차순 정렬후, 월급의 내림차순으로 정렬하여 나타내세요.
    
    ---------------------------------------
    부서번호     사원명             월급
    ---------------------------------------
    10        Jennifer Whalen     4400
    20        Michael Hartstein     13000
    20        Pat Fay             6000
    40        Susan Mavris         6500
    70        Hermann Baer         10000
    90        Steven King         24000
    90        Neena Kochhar         17000
    90        Lex De Haan         17000
    110        Shelley Higgins     12008
    110        William Gietz         8300
    (null)    Kimberely Grant     8050
*/

    select nvl(department_id, -9999) as 부서번호, 
           first_name||' '||last_name as 사원명,
           nvl(salary+(salary*commission_pct),salary) as 월급
    from employees
    where nvl(department_id, -9999) not in (30,50,60,80,100)
    order by 1, 3 desc;


    select department_id AS 부서번호
         , first_name || ' ' || last_name AS 사원명
         , nvl(salary + (salary * commission_pct), salary) AS 월급
    from employees
    where nvl(department_id, -9999) not in(30,50,60,80,100)
    order by 부서번호, 월급 desc;







/*
    문제 4. 
    employees 테이블에서 부서번호가 존재하는 사원들중 월급이 8000 이상 8999 이하인 사원들만 
    부서번호, 사원명, 월급을 
    부서번호로 오름차순 정렬후, 월급의 내림차순으로 정렬하여 나타내세요.
    
    ------------------------------------------
    부서번호        사원명            월급
    ------------------------------------------
    50           Adam Fripp           8200
    50           Matthew Weiss       8000
    80           Sarath Sewall       8750
    80           William Smith       8510
    80           Elizabeth Bates       8395
    80           Oliver Tuvault       8050
    100           John Chen           8200
    110           William Gietz       8300
*/

    select nvl(department_id, -9999) as 부서번호, 
           first_name||' '||last_name as 사원명,
           nvl(salary+(salary*commission_pct),salary) as 월급
    from employees
    where department_id is not null and
          nvl(salary+(salary*commission_pct),salary) between 8000 and 8999
    order by 1, 3 desc;


    select department_id AS 부서번호
         , first_name || ' ' || last_name AS 사원명
         , nvl(salary + (salary * commission_pct), salary) AS 월급
    from employees
    where department_id is not null
          and
          nvl(salary + (salary * commission_pct), salary) between 8000 and 8999
    order by 부서번호, 월급 desc;







/*
    문제 5. 
    employees 테이블에서 3월과 9월에 태어난 남자 사원들만 
    사원명, 주민번호를 
    사원명의 오름차순으로 정렬하여 나타내세요.
    
    ----------------------------------
    사원명               주민번호
    ----------------------------------
    Adam Fripp           7009151234567
    Diana Lorentz       0803153234567
    Ellen Abel           1209103234567
    Hermann Baer       7803251234567
    Karen Colmenares    7909151234567
    Ki Gee               0503253234567
    Shelli Baida       6009301234567
    Valli Pataballa       6009201234567
*/

    select first_name||' '||last_name as 사원명,
           jubun as 주민번호
    from employees
    where substr(jubun,4,1) is ('3','9')
    order by 1;


    select first_name || ' ' || last_name AS 사원명
         , jubun AS 주민번호
    from employees
    where substr(jubun,3,2) in ('09','03')
          and
          substr(jubun,7,1) in ('1','3')
    order by 사원명;






/*
    문제 6. 
    employees 테이블에서 부서번호 30번, 50번에 근무하는 사원들만 
    사원명, 주민번호, 성별을 나타내세요.
    성별은 '남' 또는 '여'라고 나타낸다.
    
    ----------------------------------------------------
    부서번호    사원명             주민번호        성별
    ----------------------------------------------------
    30       Den Raphaely        6709152234567   여
    30       Alexander Khoo      6110151234567   남
    30       Shelli Baida       6009301234567   남
    30       Sigal Tobias       6110152234568   여
    30       Guy Himuro           7810151234567   남
    30       Karen Colmenares   7909151234567   남
    50       Matthew Weiss       7702152234567   여
    50       Adam Fripp           7009151234567   남
    50       Payam Kaufling       7111011234567   남
    50       Shanta Vollman       8010131234567   남
    50       Kevin Mourgos       8110191234567   남
    50       Julia Nayer           9012132234567   여
    50       Irene Mikkilineni   9406251234567   남
    50       James Landry       9408252234567   여
    50       Steven Markle       9204152234567   여
    50       Laura Bissot       8507251234567   남
    50       Mozhe Atkinson       6511111234567   남
    50       James Marlow       0010153234567   남
    50       TJ Olson           0005254234567   여
    50       Jason Mallin       0110194234567   여
    50       Michael Rogers       0412154234567   여
    50       Ki Gee               0503253234567   남
    50       Hazel Philtanker   9510012234567   여
    50       Renske Ladwig       9510021234567   남
    50       Stephen Stiles       9610041234567   남
    50       John Seo           9610052234567   여
    50       Joshua Patel       7310011234567   남
    50       Trenna Rajs           7310092234567   여
    50       Curtis Davies       7510121234567   남
    50       Randall Matos       7612012234567   여
    50       Peter Vargas       7710061234567   남
    50       Winston Taylor       8310012234567   여
    50       Jean Fleaur           6510191234567   남
    50       Martha Sullivan       6510221234567   남
    50       Girard Geoni       6510232234567   여
    50       Nandita Sarchand   8512131234567   남
    50       Alexis Bull           8510182234567   여
    50       Julia Dellinger       7510192234567   여
    50       Anthony Cabrio       8512192234567   여
    50       Kelly Chung           9511151234567   남
    50       Jennifer Dilly       7509302234567   여
    50       Timothy Gates       8510161234567   남
    50       Randall Perkins       9510192234567   여
    50       Sarah Bell           0510133234567   남
    50       Britney Everett       0810194234567   여
    50       Samuel McCain       0910183234567   남
    50       Vance Jones           1010134234567   여
    50       Alana Walsh           9510032234567   여
    50       Kevin Feeney       9710181234567   남
    50       Donald OConnell       9810162234567   여
    50       Douglas Grant       7511171234567   남
*/

    select nvl(department_id, -9999) as 부서번호, 
           first_name||' '||last_name as 사원명,
           jubun as 주민번호,
           nvl(salary+(salary*commission_pct),salary) as 월급,
           case substr(jubun,7,1)
           when '1' then '남'
           when '3' then '남'
           else '여'
           end as 성별
    from employees
    where nvl(department_id, -9999) in (30,50)
    order by 1;


    select department_id AS 부서번호
         , first_name || ' ' || last_name AS 사원명
         , jubun AS 주민번호
         , case when substr(jubun,7,1) in('1','3') then '남'
           else '여'
           end AS 성별
    from employees
    where department_id in (30,50);






/*
    문제 7. 
    employees 테이블에서 부서번호 30번, 50번에 근무하는 사원들만 
    사원명, 주민번호, 성별을 나타내세요.
    성별은 '남' 또는 '여'라고 나타낸다. 그리고 주민번호는 생년월일만 기재해주고 나머지는 마스킹('*')처리해서 보여준다.
    
    ------------------------------------------------------------
    부서번호        사원명             주민번호            성별
    ------------------------------------------------------------
    30           Den Raphaely       670915*******   여
    30           Alexander Khoo       611015*******   남
    30           Shelli Baida       600930*******   남
    30           Sigal Tobias       611015*******   여
    30           Guy Himuro           781015*******   남
    30           Karen Colmenares    790915*******   남
    50           Matthew Weiss       770215*******   여
    50           Adam Fripp           700915*******   남
    50           Payam Kaufling       711101*******   남
    50           Shanta Vollman       801013*******   남
    50           Kevin Mourgos       811019*******   남
    50           Julia Nayer           901213*******   여
    50           Irene Mikkilineni   940625*******   남
    50           James Landry       940825*******   여
    50           Steven Markle       920415*******   여
    50           Laura Bissot       850725*******   남
    50           Mozhe Atkinson       651111*******   남
    50           James Marlow       001015*******   남
    50           TJ Olson           000525*******   여
    50           Jason Mallin       011019*******   여
    50           Michael Rogers       041215*******   여
    50           Ki Gee               050325*******   남
    50           Hazel Philtanker    951001*******   여
    50           Renske Ladwig       951002*******   남
    50           Stephen Stiles       961004*******   남
    50           John Seo           961005*******   여
    50           Joshua Patel       731001*******   남
    50           Trenna Rajs           731009*******   여
    50           Curtis Davies       751012*******   남
    50           Randall Matos       761201*******   여
    50           Peter Vargas       771006*******   남
    50           Winston Taylor       831001*******   여
    50           Jean Fleaur           651019*******   남
    50           Martha Sullivan       651022*******   남
    50           Girard Geoni       651023*******   여
    50           Nandita Sarchand    851213*******   남
    50           Alexis Bull           851018*******   여
    50           Julia Dellinger       751019*******   여
    50           Anthony Cabrio       851219*******   여
    50           Kelly Chung           951115*******   남
    50           Jennifer Dilly       750930*******   여
    50           Timothy Gates       851016*******   남
    50           Randall Perkins       951019*******   여
    50           Sarah Bell           051013*******   남
    50           Britney Everett       081019*******   여
    50           Samuel McCain       091018*******   남
    50           Vance Jones           101013*******   여
    50           Alana Walsh           951003*******   여
    50           Kevin Feeney       971018*******   남
    50           Donald OConnell       981016*******   여
    50           Douglas Grant       751117*******   남
*/

    select nvl(department_id, -9999) as 부서번호, 
           first_name||' '||last_name as 사원명,
           substr(jubun,1,6)||'*******' as 주민번호,
           case substr(jubun,7,1)
           when '1' then '남'
           when '3' then '남'
           else '여'
           end as 성별
    from employees
    where nvl(department_id, -9999) in (30,50)
    order by 1;


    select department_id AS 부서번호
         , first_name || ' ' || last_name AS 사원명
         , rpad( substr(jubun, 1, 6), length(jubun), '*')  AS 주민번호
     --  , rpad( substr(jubun, 1, 6), 13, '*')  AS 주민번호
         , case when substr(jubun,7,1) in('2','4') then '여'
           else '남'
           end AS 성별
    from employees
    where department_id in (30,50)
    order by department_id;






/*
    문제 8. 
    employees 테이블에서 90번 부서에 근무하는 사원들만 아래와 같이
    사원명, 공개연락처, 비공개연락처를 나타내세요.
    여기서 비공개연락처란? 국번을 * 로 마스킹처리 한것을 말한다.
    
    ---------------------------------------------
    사원명          공개연락처      비공개연락처
    ---------------------------------------------
    Steven King       515.123.4567   515.***.4567
    Neena Kochhar   515.123.4568   515.***.4568
    Lex De Haan       515.123.4569   515.***.4569
*/

    select first_name||' '||last_name as 사원명, 
           phone_number as 공개연락처,
           substr(phone_number,1,3)||'.***.'||substr(phone_number,9,3) as 비공개연락처
    from employees
    where nvl(department_id, -9999) in 90;


/*
   국번만 '*' 로 마스킹 처리한다.
   
   phone_number 컬럼에서 국번전까지만 발췌하고 || 국번 || 국번다음부터 끝까지 발췌한다.
   국번만 translate 를 사용하여 '*' 로 바꾸어주면 되겠다.
*/

    select phone_number, translate(phone_number, '0123456789', '**********')
    from employees;

/*
   국번만 발췌해와야 하는데 어떻게 할까?
   국번만 발췌 ==> phone_number 컬럼에서 최초로 . 이 나오는 위치 그 다음부터 두번째로 . 이 나오는 위치 그 앞까지만 발췌를 해오면 된다. 
*/

   select phone_number,
   --  substr(phone_number, 출발점, 몇글자) AS "국번만 발췌"
   
   --  출발점 ==>  최초로 . 이 나오는 위치 그 다음
   --             instr(phone_number, '.', 1, 1) + 1
   
   --  몇글자 ==> phone_number 컬럼에서 두번째로 . 이 나오는 위치 - 1 ==> 예  7-1 = 6
   --            phone_number 컬럼에서 첫번째로 . 이 나오는 위치     ==> 예   4
   --           (phone_number 컬럼에서 두번째로 . 이 나오는 위치 - 1) - phone_number 컬럼에서 첫번째로 . 이 나오는 위치 ==> 예 6-4 = 2 
   --           instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)
   
   --            phone_number 컬럼에서 두번째로 . 이 나오는 위치 - 1 ==> 예  8-1 = 7 
   --            phone_number 컬럼에서 첫번째로 . 이 나오는 위치     ==> 예   4 
   --           (phone_number 컬럼에서 두번째로 . 이 나오는 위치 - 1) - phone_number 컬럼에서 첫번째로 . 이 나오는 위치 ==> 예 7-4 = 3  
   --           instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)
   
   -- substr(phone_number, 출발점, 몇글자) AS "국번만 발췌"
      substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)) AS "국번만 발췌"   
   from employees;    

   select phone_number as "원래전화번호",
          substr(phone_number, 1, instr(phone_number,'.', 1)) as "국번전까지",

          substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)) as "국번",
          translate(substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)), '0123456789', '**********') as "마스킹",

          substr(phone_number, instr(phone_number, '.', 1, 2)) as "국번다음부터 끝까지"
   from employees;


   select phone_number as "원래전화번호",
          substr(phone_number, 1, instr(phone_number,'.', 1)) ||
          translate(substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)), '0123456789', '**********') ||
          substr(phone_number, instr(phone_number, '.', 1, 2)) as "마스킹처리한전화번호"
   from employees;


    select first_name||' '||last_name as 사원명,
           phone_number as 공개연락처,
           substr(phone_number, 1, instr(phone_number,'.', 1)) ||
           translate(substr(phone_number, instr(phone_number, '.', 1, 1) + 1, instr(phone_number, '.', 1, 2) - 1 - instr(phone_number, '.', 1)), '0123456789', '**********') ||
           substr(phone_number, instr(phone_number, '.', 1, 2)) as 비공개연락처
   from employees
   where department_id = 90;






/*
    문제 9. 
    employees 테이블에서 80번 부서에 근무하는 사원들만 아래와 같이
    사원명, 공개연락처, 비공개연락처를 나타내세요.
    여기서 비공개연락처란? 첫번째 국번과 마지막 개별번호를 * 로 마스킹처리 한것을 말한다.
    
    ---------------------------------------------------------------
    사원명               공개연락처               비공개연락처
    ---------------------------------------------------------------
    John Russell       011.44.1344.429268       011.**.1344.******
    Karen Partners       011.44.1344.467268       011.**.1344.******
    Alberto Errazuriz   011.44.1344.429278       011.**.1344.******
    Gerald Cambrault    011.44.1344.619268       011.**.1344.******
    Eleni Zlotkey       011.44.1344.429018       011.**.1344.******
    Peter Tucker       011.44.1344.129268       011.**.1344.******
    David Bernstein       011.44.1344.345268       011.**.1344.******
    Peter Hall           011.44.1344.478968       011.**.1344.******
    Christopher Olsen   011.44.1344.498718       011.**.1344.******
    Nanette Cambrault   011.44.1344.987668       011.**.1344.******
    Oliver Tuvault       011.44.1344.486508       011.**.1344.******
    Janette King       011.44.1345.429268       011.**.1345.******
    Patrick Sully       011.44.1345.929268       011.**.1345.******
    Allan McEwen       011.44.1345.829268       011.**.1345.******
    Lindsey Smith       011.44.1345.729268       011.**.1345.******
    Louise Doran       011.44.1345.629268       011.**.1345.******
    Sarath Sewall       011.44.1345.529268       011.**.1345.******
    Clara Vishney       011.44.1346.129268       011.**.1346.******
    Danielle Greene     011.44.1346.229268       011.**.1346.******
    Mattea Marvins       011.44.1346.329268       011.**.1346.******
    David Lee           011.44.1346.529268       011.**.1346.******
    Sundar Ande           011.44.1346.629268       011.**.1346.******
    Amit Banda           011.44.1346.729268       011.**.1346.******
    Lisa Ozer           011.44.1343.929268       011.**.1343.******
    Harrison Bloom       011.44.1343.829268       011.**.1343.******
    Tayler Fox           011.44.1343.729268       011.**.1343.******
    William Smith       011.44.1343.629268       011.**.1343.******
    Elizabeth Bates       011.44.1343.529268       011.**.1343.******
    Sundita Kumar       011.44.1343.329268       011.**.1343.******
    Ellen Abel           011.44.1644.429267       011.**.1644.******
    Alyssa Hutton       011.44.1644.429266       011.**.1644.******
    Jonathon Taylor       011.44.1644.429265       011.**.1644.******
    Jack Livingston       011.44.1644.429264       011.**.1644.******
    Charles Johnson       011.44.1644.429262       011.**.1644.******
*/ 

    select first_name||' '||last_name as 사원명, 
           phone_number as 공개연락처,
           substr(phone_number,1,3)||'.**.'||substr(phone_number,8,4)||'.******' as 비공개연락처
    from employees
    where nvl(department_id, -9999) in 80
    order by 1;


    select first_name || ' ' || last_name AS 사원명
         , phone_number AS 공개연락처
         , substr(phone_number,1,instr(phone_number,'.',1,1)) 
        || lpad('*',instr(phone_number,'.',1,2)-instr(phone_number,'.',1,1)-1,'*') 
        || substr(phone_number,instr(phone_number,'.',1,2), instr(phone_number,'.',1,3)-instr(phone_number,'.',1,2))
        || translate( substr(phone_number,instr(phone_number,'.',1,3)), '0123456789','**********')  AS 비공개연락처
    from employees
    where department_id = 80;






/*
    문제 10. (난이도 상)
    employees 테이블에서 80번, 90번 부서에 근무하는 사원들만 아래와 같이
    부서번호, 사원명, 공개연락처, 비공개연락처를 나타내세요.
    여기서 비공개연락처란? 첫번째 국번과 마지막 개별번호를 * 로 마스킹처리 한것을 말한다.
    
    ------------------------------------------------------------------------------
    부서번호        사원명              공개연락처               비공개연락처
    ------------------------------------------------------------------------------  
    80           John Russell       011.44.1344.429268       011.**.1344.******
    80           Karen Partners       011.44.1344.467268       011.**.1344.******
    80           Alberto Errazuriz   011.44.1344.429278       011.**.1344.******
    80           Gerald Cambrault    011.44.1344.619268       011.**.1344.******
    80           Eleni Zlotkey       011.44.1344.429018       011.**.1344.******
    80           Peter Tucker       011.44.1344.129268       011.**.1344.******
    80           David Bernstein       011.44.1344.345268       011.**.1344.******
    80           Peter Hall           011.44.1344.478968       011.**.1344.******
    80           Christopher Olsen   011.44.1344.498718       011.**.1344.******
    80           Nanette Cambrault   011.44.1344.987668       011.**.1344.******
    80           Oliver Tuvault       011.44.1344.486508       011.**.1344.******
    80           Janette King       011.44.1345.429268       011.**.1345.******
    80           Patrick Sully       011.44.1345.929268       011.**.1345.******
    80           Allan McEwen       011.44.1345.829268       011.**.1345.******
    80           Lindsey Smith       011.44.1345.729268       011.**.1345.******
    80           Louise Doran       011.44.1345.629268       011.**.1345.******
    80           Sarath Sewall       011.44.1345.529268       011.**.1345.******
    80           Clara Vishney       011.44.1346.129268       011.**.1346.******
    80           Danielle Greene       011.44.1346.229268       011.**.1346.******
    80           Mattea Marvins       011.44.1346.329268       011.**.1346.******
    80           David Lee           011.44.1346.529268       011.**.1346.******
    80           Sundar Ande           011.44.1346.629268       011.**.1346.******
    80           Amit Banda           011.44.1346.729268       011.**.1346.******
    80           Lisa Ozer           011.44.1343.929268       011.**.1343.******
    80           Harrison Bloom       011.44.1343.829268       011.**.1343.******
    80           Tayler Fox           011.44.1343.729268       011.**.1343.******
    80           William Smith       011.44.1343.629268       011.**.1343.******
    80           Elizabeth Bates       011.44.1343.529268       011.**.1343.******
    80           Sundita Kumar       011.44.1343.329268       011.**.1343.******
    80           Ellen Abel           011.44.1644.429267       011.**.1644.******
    80           Alyssa Hutton       011.44.1644.429266       011.**.1644.******
    80           Jonathon Taylor       011.44.1644.429265       011.**.1644.******
    80           Jack Livingston       011.44.1644.429264       011.**.1644.******
    80           Charles Johnson       011.44.1644.429262       011.**.1644.******
    90           Steven King           515.123.4567       515.***.****
    90           Neena Kochhar       515.123.4568       515.***.****
    90           Lex De Haan           515.123.4569       515.***.****
*/

    select 부서번호, 사원명, 공개연락처,
           Case 부서번호
           when 80
           then substr(공개연락처,1,3)||'.**.'||substr(공개연락처,8,4)||'.******' 
           else substr(공개연락처,1,3)||'.***.'||substr(공개연락처,9,3)
           end as as 비공개연락처
    from
    (
        select nvl(department_id, -9999) as 부서번호,
               first_name||' '||last_name as 사원명, 
               phone_number as 공개연락처
        from employees
    ) V
    where nvl(department_id, -9999) in (80,90)
    order by 1;


    select department_id AS 부서번호
         , first_name || ' ' || last_name AS 사원명
         , phone_number AS 공개연락처
         , substr(phone_number, 1, instr(phone_number,'.',1,1)) 
        || lpad('*', instr(phone_number,'.',1,2)-instr(phone_number,'.',1,1)-1, '*')
        || case 
           when instr(phone_number,'.',1,3) > 0 
                then substr(phone_number, instr(phone_number,'.',1,2), instr(phone_number,'.',1,3)-instr(phone_number,'.',1,2))
           else ''
           end
        || translate(substr(phone_number, instr(phone_number,'.',-1,1)), '0123456789', '**********')
        AS 비공개연락처
    from employees
    where department_id in (80,90)
    order by department_id;






-- ==========================================================================

-- **** >>>> 그룹함수(집계함수) <<<< **** --

/*
     1. sum       -- 합계
     2. avg       -- 평균
     3. max       -- 최대값
     4. min       -- 최소값
     5. count     -- select 되어서 나온 결과물의 행의 갯수 
     6. variacne  -- 분산 
     7. stddev    -- 표준편차
     
     분산    : 분산의 제곱근이 표준편차 (평균에서 떨어진 정도)
     표준편차 : 표준편차의 제곱승이 분산 (평균과의 차액)
     
     >>> 주식투자 <<<
     50 60 40 50 55 45 52 48   평균 50  편차가 적음  -- 안정투자
     10 90 20 80 30 70 90 10   평균 50  편차가 큼    -- 투기성투자(위험을 안고서 투자함) 
     
     분산과 표준편차는 어떤 의사결정시 도움이 되는 지표이다.
*/

--- !!!! 중요중요중요
--- 그룹함수(집계함수)에서는 null 이 있으면 무조건 null 은 제외시킨 후 연산을 한다.!!!!!
--- 그룹함수(집계함수)를 사용하면 말 그대로 1개의 결과값만 나온다. 

select sum(salary),avg(salary), max(salary), min(salary), count(salary)
     , variance(salary), stddev(salary)
from employees;

select salary, sum(salary)
from employees; -- 오류!! 왜냐하면 select 되어진 결과물은 사각형의 테이블모양을 띄는데
                --       salary 컬럼에 대한 행의 개수는 107개이고, sum(salary) 의 결과값은 행의 개수가 1개이다.
                --       그러므로 다각형 모양을 띄므로 오류이다!!
       
                
select salary*commission_pct, nvl(salary*commission_pct,0)
from employees;

select sum(salary*commission_pct), sum(nvl(salary*commission_pct,0))
from employees;
-- 사칙연산에서 null 이 포함되면 무조건 null
-- sum을 이용한 집계함수에서는 null 값 제외하고 더함
-- 73690    73690


select salary, commission_pct, department_id
from employees;

select count(salary), count(commission_pct), count(department_id)
from employees;
--   107	35	106


select count(*)
from employees;     -- 사원수


--- employees 테이블에서 기본급여(salary)의 평균치를 구하세요.
select sum(salary), count(salary),  
       sum(salary)/count(salary),
       avg(salary)
from employees;
-- 691416	107	
-- 6461.831775700934579439252336448598130841	
-- 6461.831775700934579439252336448598130841


--- employees 테이블에서 수당(salary*commission_pct)이 null 아닌 사원들만의 수당(salary*commission_pct)의 평균치를 구하세요.
select sum(salary*commission_pct), count(salary*commission_pct),  
       sum(salary*commission_pct)/count(salary*commission_pct),
       avg(salary*commission_pct)
from employees;
-- 73690	35	
-- 2105.428571428571428571428571428571428571	
-- 2105.428571428571428571428571428571428571


--- employees 테이블에서 모든 직원들에 대해 수당(salary*commission_pct)의 평균치를 구하세요.
select sum(salary*commission_pct), count(nvl(salary*commission_pct,0)),  
       sum(salary*commission_pct)/count(nvl(salary*commission_pct,0)),
       avg(nvl(salary*commission_pct,0))
from employees;
-- 73690	107	
-- 688.691588785046728971962616822429906542	
-- 688.691588785046728971962616822429906542


--- *** employees 테이블에서 부서번호별 인원수를 나타내세요. *** ---
select department_id as 부서번호, count(*) as 인원수
from employees
group by department_id  -- department_id 컬럼의 값이 같은 것끼리 그룹을 짓는다.
order by 1;


--- *** employees 테이블에서 부서번호별 인원수를 나타내세요. *** ---
---     또한 모든 사원들의 총 인원수도 나타내세요. *** ---
select department_id as 부서번호, count(*) as 인원수
from employees
group by rollup(department_id);

-- 결과물에서 인원수가 1 이고 부서번호가 null 인 것의 부서번호 null 은 실제 부서번호 컬럼의 값이 null 인 것이다.
-- 결과물에서 인원수가 107 이고 부서번호가 null 인 것의 부서번호 null 은 그룹을 안 지었을 때의 count(*) 값이다.
-- 그렇다면 부서번호 컬럼의 값을 나타낼때 실제 부서번호 컬럼의 값이 null 인 것을 '인턴'이라고 나타내어주고,
-- 그룹을 안 지었을 때의 null 은 '전체'라고 나타내어주고자 한다.
select grouping(department_id),
       -- department_id 컬럼의 값을 가지고 group 을 지었을 때 
       -- grouping(department_id) 값이 0 이라면 department_id 컬럼의 값은 실제 데이터임을 알려주는 것이고,
       -- grouping(department_id) 값이 1 이라면 department_id 컬럼의 값은 실제 데이터가 아니라 group 을 짓지 않은 전체를 뜻하는 것이다.
       department_id as 부서번호, count(*) as 인원수
from employees
group by rollup(department_id);


select decode(grouping(department_id),0,department_id
                                       ,-9999) as 부서번호
     , count(*) as 인원수
from employees
group by rollup(department_id);


select decode(grouping(department_id),0, to_char(department_id)
                                       , '전체') as 부서번호
     , count(*) as 인원수
from employees
group by rollup(department_id);
-- ORA-01722: invalid number


select decode(grouping(department_id),0, nvl(to_char(department_id),'인턴')
                                       , '전체') as 부서번호
     , count(*) as 인원수
from employees
group by rollup(department_id);


---- **** employees 테이블에서 성별 인원수를 나타내세요. **** ----

------------------------
성별        인원수
------------------------
남           56
여           51
전체         107
------------------------

-- [방법1]
select grouping(case when substr(jubun,7,1) in ('1','3') then '남' else '여' end),
       case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as 성별,
       count(*) as 인원수
from employees
group by rollup(case when substr(jubun,7,1) in ('1','3') then '남' else '여' end);


select decode(grouping(case when substr(jubun,7,1) in ('1','3') then '남' else '여' end)
            ,0, case when substr(jubun,7,1) in ('1','3') then '남' else '여' end
              , '전체') as 성별,
       count(*) as 인원수
from employees
group by rollup(case when substr(jubun,7,1) in ('1','3') then '남' else '여' end);


-- [방법2 - inline view의 사용]
select decode(grouping(gender),0,gender,1,'전체') as 성별, count(*) as 인원수
from
(
    select case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as GENDER
    from employees
) V
group by rollup(gender);


--- *** === inline view(인라인뷰) 를 with 절을 사용하여 나타낼 수 있다. === *** ---
with V as (
    select case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as GENDER
    from employees
)
select decode(grouping(gender),0,gender,'전체') as 성별, count(*) as 인원수
from V
group by rollup(gender);




---- **** employees 테이블에서 성별 인원수 및 퍼센티지를 나타내세요. **** ----

--------------------------------
성별        인원수      퍼센티지(%)
--------------------------------
남           56         52.3 
여           51         47.7
전체         107         100
--------------------------------

select round((56/107)*100,1), round((56/(select count(*) from employees))*100,1),
       round((51/107)*100,1), round((51/(select count(*) from employees))*100,1)
from dual;


select decode(grouping(gender),0,gender,'전체') as 성별, count(*) as 인원수,
       round(count(*)/(select count(*) from employees)*100,1) as "퍼센티지(%)"
from 
(
    select case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as GENDER
    from employees
)V
group by rollup(gender);


with V as (
    select case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as GENDER
    from employees
)
select decode(grouping(gender),0,gender,'전체') as 성별, count(*) as 인원수,
       round(count(*)/(select count(*) from employees)*100,1) as "퍼센티지(%)"
from V
group by rollup(gender);



---- **** employees 테이블에서 연령대별 인원수 및 퍼센티지를 나타내세요. **** ----

--------------------------------------
 연령대       인원수     퍼센티지(%)
--------------------------------------
 10대미만
 10대
 20대
 ....
 60대
 전체
--------------------------------------

select extract(year from sysdate) 
       - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1 as age,
       trunc(extract(year from sysdate) 
       - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as 연령대

from employees;


select decode(grouping(ageline),0,to_char(ageline),1,'전체') as 연령대, 
       count(*) as 인원수,
       to_char(round(count(*)/(select count(*) from employees)*100,1),'999.0') as "퍼센티지(%)"
from
(
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline
    from employees
)V
group by rollup(ageline);



with V as (
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline
    from employees
)
select decode(grouping(ageline),0,to_char(ageline),1,'전체') as 연령대, 
       count(*) as 인원수,
       round(count(*)/(select count(*) from employees)*100,1) as "퍼센티지(%)"
from V
group by rollup(ageline);



--- *** group 을 지을때 1차로 그룹을 지은 다음에 거기서 다시 한 번 2차로 또 group 을 지을 수 있다. *** ---

--------------------------------------
 연령대    성별    인원수     퍼센티지(%)
--------------------------------------
 10대      남
 10대      여
 20대
 ....
 60대
 전체
--------------------------------------


select ageline, gender,
       count(*) as 인원수,
       to_char(round(count(*)/(select count(*) from employees)*100,1),'999.0') as "퍼센티지(%)"
from
(
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline,
           case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as gender
    from employees
)V
group by ageline, gender
order by 1,2;



select ageline, gender,
       count(*) as 인원수,
       to_char(round(count(*)/(select count(*) from employees)*100,1),'999.0') as "퍼센티지(%)"
from
(
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline,
           case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as gender
    from employees
)V
group by rollup(ageline, gender);
-- rollup 은 오름차순이 되므로 order by 를 사용하지 않는다


select decode(grouping(ageline),0,to_char(ageline),'전체') as 연령대,
       decode(grouping(gender),0, gender,'전체') as 성별,
       count(*) as 인원수,
       to_char(round(count(*)/(select count(*) from employees)*100,1),'999.0') as "퍼센티지(%)"
from
(
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline,
           case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as gender
    from employees
)V
group by rollup(ageline, gender);



--------------------------------------
 부서번호  성별    인원수     퍼센티지(%)
--------------------------------------
 10      남
 10      여
 10      전체
 ....
 전체
--------------------------------------


 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by rollup(department_id, gender);


 with V as (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 )
 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from V 
 group by rollup(department_id, gender);



-- employees 테이블에서 부서번호별 기본급여의 합계를 나타내세요.
-- 또한 모든 부서에 대한 기본급여의 총합계도 나타내세요.
select decode(grouping(department_id),0,nvl(to_char(department_id),'인턴'),'전체') as 부서번호, 
       to_char(sum(salary),'$999,999') as 급여합게
from employees
group by rollup(department_id);
-- 여섯자리까지 가능, 문자타입
-- 통화기호는 L 쓰면 그 지역의 통화기호로 나온다



-- employees 테이블에서 부서번호별 기본급여의 평균를 나타내세요.
select decode(grouping(department_id),0,nvl(to_char(department_id),'인턴'),'전체') as 부서번호, 
       sum(salary) as 기본급여,
       to_char(round(avg(salary),1),'$99,999.0') as 급여평균
from employees
group by rollup(department_id);



-- employees 테이블에서 부서번호별 기본급여의 최대값 나타내세요.
select nvl(to_char(department_id),'인턴') as 부서번호, 
       to_char(max(salary),'$99,999') as 최대급여
from employees
group by department_id
order by department_id;
-- order by 1; 이렇게 하면 문자열의 배열로 순서가 바르지 않다.



-- employees 테이블에서 부서번호별 기본급여의 최소값 나타내세요.
select nvl(to_char(department_id),'인턴') as 부서번호, 
       to_char(min(salary),'$99,999') as 최대급여
from employees
group by department_id
order by department_id;



----- >>>>> 요약값(rollup, cube, grouping sets) <<<<< ------
  /*
      1. rollup(a,b,c) 은 grouping sets( (a,b,c),(a,b),(a),() ) 와 같다.
    
            group by rollup(department_id, gender)
         == group by grouping sets( (department_id, gender), (department_id), () )
  
      2. cube(a,b,c) 은 grouping sets( (a,b,c),(a,b),(b,c),(a,c),(a),(b),(c),() ) 와 같다.
 
            group by cube(department_id, gender)
         == group by grouping sets( (department_id, gender), (department_id), (gender), () )
  */


 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by rollup(department_id, gender);


-- 위의 결과물과 똑같은 것은 아래와 같다.
 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by grouping sets((department_id, gender), (department_id), ());
 

 
 --- *** cuble *** ---

 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by cube(department_id, gender);

 
-- 위의 결과물과 똑같은 것은 아래와 같다.
 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by grouping sets((department_id, gender),(department_id),(gender),());
 
 
 
 select decode(grouping(department_id), 0, nvl(to_char(department_id), '인턴'), '전체') AS 부서번호
      , decode(grouping(gender), 0, gender, '전체') AS 성별
      , count(*) AS 인원수 
      , to_char( round( (count(*)/(select count(*) from employees))*100, 1), '990.0') AS "퍼센티지(%)" 
 from 
 (
   select department_id
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
   from employees
 ) V 
 group by grouping sets((department_id),(gender),())
 order by department_id;
 
 
 
 --- ========= *** having 그룹함수조건절 *** ========= ---
 /*
    group by 절을 사용하여 그룹함수의 값을 나타내었을때
    그룹함수의 값이 특정 조건에 해당하는 것만 추출하고자 할 때는 where 절을 사용하는 것이 아니라
    having 그룹함수 조건절을 사용해야 한다.
 */
 
 --- employees 테이블에서 사원이 10명 이상 근무하는 부서번호와 그 인원수를 나타내세요.
 select department_id, count(*)
 from employees
 where count(*) >= 10
 group by department_id;
 
 
 select department_id as 부서번호, count(*) as 인원수 
                            -- 화면에 보여줄때는 department_id(부서번호)와 count(*) 개수를 나타내어준다.
 from employees             -- 메모리상에는 107개 행이 모두 올라간다.
 group by department_id     -- 메모리상에서 department_id 컬럼값이 동일한 것 끼리 group을 짓는다.
 having count(*) >= 10      -- group 을 지은 것들 중에 개수(count(*))가 10개 이상인 것만 보여라.
 order by 1;
 
 
-- employees 테이블에서 부서번호별로 월급의 합계를 나타내었을때 
-- 부서번호별 월급의 합계가 50000 이상인 부서에 대해서만
-- 부서번호, 월급의 합계를 나타내세요.
select department_id as 부서번호, 
       sum(nvl(salary+(salary*commission_pct),salary)) as 월급의합계
from employees
group by department_id
having  sum(nvl(salary+(salary*commission_pct),salary)) >= 50000
order by 2 desc;


---- *** !!! 누적(누계)에 대해서 알아봅시다 !!! *** ----
/*
    sum(누적되어야 할 컬럼명) over(order by 누적되어야질 기준이 되는 컬럼명 asc[desc])
    
    sum(누적되어야 할 컬럼명) over(partition by 그룹화 되어질 컬럼명
                                order by 누적되어질 기준이 되는 컬럼명 asc[desc])
    
*/

create table tbl_panmae
 (panmaedate  date
 ,jepumname   varchar2(20)
 ,panmaesu    number
 );

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-2), '새우깡', 10);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-2)+1, '새우깡', 15); 

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-2)+2, '감자깡', 20);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-2)+3, '새우깡', 10);
 
 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-2)+3, '새우깡', 3);
 
 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-1), '고구마깡', 7);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-1)+1, '새우깡', 8); 

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-1)+2, '감자깡', 10);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( add_months(sysdate,-1)+3, '감자깡', 5);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate - 4, '허니버터칩', 30);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate - 3, '고구마깡', 15);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate - 2, '고구마깡', 10);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate - 1, '허니버터칩', 20);


 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '새우깡', 10);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '새우깡', 10);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '감자깡', 5);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '허니버터칩', 15);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '고구마깡', 20);

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '감자깡', 10); 

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values( sysdate, '새우깡', 10);

 commit;
   
 select *
 from tbl_panmae;


 select to_Char(panmaedate, 'yyyy-mm-dd hh24:mi:ss') as panmaedate, panmaesu
 from tbl_panmae
 where jepumname = '새우깡';
 
 
 -- *** tbl_panmae 테이블에서 새우깡에 대한 일별판매량과 일별누적판매량을 나타내세요. *** --
 -----------------------------------------
 판매일자       일별판매량       일별누적판매량
 -----------------------------------------
 2020-12-16      10              10
 2020-12-17      15              25
 2020-12-19      13              38
 2021-01-17       8              46
 2021-02-16      30              76
 -----------------------------------------

 select to_char(panmaedate,'yyyy-mm-dd') as 판매일자, 
        sum(panmaesu) as 일별판매량, 
        sum(sum(panmaesu)) over(order by to_char(panmaedate,'yyyy-mm-dd') asc) as 일별누적판매량
 from tbl_panmae
 where jepumname = '감자깡'
 group by to_char(panmaedate,'yyyy-mm-dd')
 order by 1;



 -- *** tbl_panmae 테이블에서 모든 제품에 대한 일별판매량과 일별누적판매량을 나타내세요. *** --
  ------------------------------------------------------
 제품명    판매일자       일별판매량       일별누적판매량
 -------------------------------------------------------
 감자깡   2020-12-18      20              20
 .....  ............   ......          .....
 새우깡   2020-12-16      10              10
         2020-12-17      15              25
         2020-12-19      13              38
         2021-01-17       8              46
         2021-02-16      30              76
 .....  ............   ......          .....
 --------------------------------------------------------


 select jepumname as 제품명, 
        to_char(panmaedate,'yyyy-mm-dd') as 판매일자, 
        sum(panmaesu) as 일별판매량, 
        sum(sum(panmaesu)) over(partition by jepumname
                                order by to_char(panmaedate,'yyyy-mm-dd') asc) as 일별누적판매량
 from tbl_panmae
 group by jepumname, to_char(panmaedate,'yyyy-mm-dd');

/*
    감자깡	    2020-12-18	20	20
    감자깡	    2021-01-18	10	30
    감자깡	    2021-01-19	5	35
    감자깡	    2021-02-16	15	50
    고구마깡	    2021-01-16	7	7
    고구마깡	    2021-02-13	15	22
    고구마깡	    2021-02-14	10	32
    고구마깡	    2021-02-16	20	52
    새우깡	    2020-12-16	10	10
    새우깡	    2020-12-17	15	25
    새우깡	    2020-12-19	13	38
    새우깡	    2021-01-17	8	46
    새우깡	    2021-02-16	30	76
    허니버터칩	2021-02-12	30	30
    허니버터칩	2021-02-15	20	50
*/
    

----------------------------------------------------------------------------
--- *** 아래처럼 나오도록 하세요 *** ---

-------------------------------------------------------
 전체사원수  10대  20대  30대  40대  50대  60대
-------------------------------------------------------
 107        16   19    21    21   16    14


-- [방법1]
-- 오라클 11g 이전에는 아래와 같이 구했다.
-- 조건에 맞으면 1 주고 다 더하기, sum 활용
select count(ageline) as 전체사원수,
       sum(decode(ageline,10,1)) as "10대",
       sum(decode(ageline,20,1)) as "20대",
       sum(decode(ageline,30,1)) as "30대",
       sum(decode(ageline,40,1)) as "40대",
       sum(decode(ageline,50,1)) as "50대",
       sum(decode(ageline,60,1)) as "60대"       
from
(
     select trunc(extract(year from sysdate) - ( case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2) +1 ), -1) as ageline
     from employees
) V;


-- [방법2] 
-- **** PIVOT **** --
-- ==> Oracle 11g부터 제공하는 것으로써, 행을 열로 변환하고자 할 때 사용하는 방법으로서 기존의 GROUP BY 와 집계함수(MAX, SUM 등), DECODE 나 CASE 를 사용하는 방법 대신 좀 더 간결하게 해준다.
--      1. PIVOT 절은 그룹함수가 적용될 컬럼을 정의하는 것으로서 마치 GROUP BY가 들어간 쿼리에서 SELECT SUM(SALARY), AVG(SALARY), COUNT(SALARY) 구절과 같다.
--      2. PIVOT FOR 절은 피봇의 기준의 되는 컬럼을 정의하는 것으로서 마치 GROUP BY 절에 뒤따르는 컬럼과 같은 역할로 이해하면 된다.
--         SELECT 절의 SUM(SALARY), AVG(SALARY), COUNT(SALARY) 가 PIVOT 절의 역할이라면, GROUP BY DEPARTMENT_ID 는 PIVOT FOR의 역할이다.
--      3. PIVOT IN 절은 PIVOT FOR 절에서 정의한 컬럼에서 필터링을 정의하는 것으로서 마치 SQL 중 WHERE DEPARTMENT_ID IN(10, 20)은 PIVOT IN 절의 역할이다.
--         또한 PIVOT IN 절은 Subquery 는 포함 할 수 없으나 Alias 정의는 가능하다.

select ageline as 연령대, 
       count(ageline) as 인원수
from
(
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline
    from employees
)V
group by ageline
order by 1;


-----------------------------------
 10대  20대  30대  40대  50대  60대
-----------------------------------
  16   19    21    21   16    14

with V as (
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline
    from employees
)
select *
from V
PIVOT( COUNT(ageline) --   16   19    21    21   16    14   이러한 값들을 의미한다.
       FOR ageline --> V 의 ageline에서 보여지는 행들의 값들이 열로 들어온다는 의미이다.
       IN(10, 20, 30, 40, 50, 60) --> 열로 보여지는 것을 선택해주는 것이다.
      );


with V as (
    select trunc(extract(year from sysdate) 
           - (case when substr(jubun,7,1) in ('1','2') then 1900 else 2000 end + substr(jubun,1,2))+1, -1) as ageline
    from employees
)
select *
from V
PIVOT( COUNT(ageline) --   16   19    21    21   16    14   이러한 값들을 의미한다.
       FOR ageline --> V 의 ageline에서 보여지는 행들의 값들이 열로 들어온다는 의미이다.
       IN(10 as "10대", 20 as "20대", 30 as "30대", 40 as "40대", 50 as "50대", 60 as "60대")
       -- as "10대" 는 별칭이다.
      );
      
      

select department_id as 부서번호, 
       count(*) as 인원수
from employees
group by department_id
order by 1;

----------------------------------------------------------
10번부서 20번부서 30번부서 ......... 100번부서 110번부서 부서없음
----------------------------------------------------------
   1        2       6   ........    6       2        1

-- [방법1]  
select  sum(decode(department_id,10,1)) as "10번부서",
        sum(decode(department_id,20,1)) as "20번부서",
        sum(decode(department_id,30,1)) as "30번부서",
        sum(decode(department_id,40,1)) as "40번부서",
        sum(decode(department_id,50,1)) as "50번부서",
        sum(decode(department_id,60,1)) as "60번부서",
        sum(decode(department_id,70,1)) as "70번부서",
        sum(decode(department_id,80,1)) as "80번부서",
        sum(decode(department_id,90,1)) as "90번부서",
        sum(decode(department_id,100,1)) as "100번부서",
        sum(decode(department_id,110,1)) as "110번부서",
        sum(decode(nvl(department_id,-999),-999,1)) as "부서없음"
from employees;
  

-- [방법2]
select sum(case department_id when 10 then 1 end) AS "10번부서"
    , sum(case department_id when 20 then 1 end) AS "20번부서"
    , sum(case department_id when 30 then 1 end) AS "30번부서"
    , sum(case department_id when 40 then 1 end) AS "40번부서"
    , sum(case department_id when 50 then 1 end) AS "50번부서"
    , sum(case department_id when 60 then 1 end) AS "60번부서"
    , sum(case department_id when 70 then 1 end) AS "70번부서"
    , sum(case department_id when 80 then 1 end) AS "80번부서"
    , sum(case department_id when 90 then 1 end) AS "90번부서"
    , sum(case department_id when 100 then 1 end) AS "100번부서"
    , sum(case department_id when 110 then 1 end) AS "110번부서"
    , sum(case nvl(department_id, -9999) when -9999 then 1 end) AS "부서없음"
from employees;   
       

-- [방법3]  
with V as (select nvl(department_id,-999) as department_id
           from employees)
select *
from V
pivot(count(department_id) 
      for department_id 
      in(10 as "10번부서", 20 as "20번부서", 30 as "30번부서", 40 as "40번부서", 50 as "50번부서", 60 as "60번부서", 
         70 as "70번부서", 80 as "80번부서", 90 as "90번부서", 100 as "100번부서", 110 as "110번부서", -999 as "부서없음"));



--- employees 테이블에서 job_id 별, 성별 기본급여의 평균을 나타내세요.
with V as (select job_id, case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as gender, salary
           from employees)
select job_id as 직종ID, 
       gender as 성별, 
       to_char(trunc(avg(salary)),'99,999') as 기본급여평균
from V
group by job_id, gender
order by 1, 2; 



select job_id as 직종ID, trunc(avg(salary)) as 기본급여평균
from employees
group by job_id
order by 1;


-- ** 아래와 같이 나오도록 하세요 ** --
----------------------------------------------------------------------------------------------------------------
 직종ID       남자기본급여평균  여자기본급여평균   기본급여평균     남자기본급여평균-기본급여평균     여자기본급여평균-기본급여평균
----------------------------------------------------------------------------------------------------------------
 .....       ............  ............     .........
FI_ACCOUNT      7900           7950           7920              7900-7920                   7950-7920
IT_PROG         5700           6000           5760
 .....       ............  ............     .........
 
select job_id as 직종ID, 
      trunc(avg(decode(gender,'남',salary))) as 남자기본급여평균,
      -- gender 값이 남자이면 salary 를 주고, 그 외에는 null 값을 준다.
      trunc(avg(decode(gender,'여',salary))) as 여자기본급여평균,
      trunc(avg(salary)) as 기본급여평균
from
(
    select job_id, 
           case when substr(jubun,7,1) in ('1','3') then '남' else '여' end as gender, 
           salary
    from employees
) V     -- 필요한 것만 사용할 수 있도록 inline view로 작성한다.
group by job_id
order by 1;

/*
      trunc(avg(decode(gender,'남',salary,0))) as 남자기본급여평균
      남자이면 salary를 여자는 0 값이 주어지므로 평균값이 달라진다.
      
      남         100         100     100
      남          80          80      80
      여         100         NULL      0
      남자평균     90          90      60
*/


  select job_id AS 직종ID
       , nvl( to_char( trunc( avg( decode(GENDER,'남',salary) ) ), '99,999' ) , ' ') AS 남자기본급여평균
       , nvl( to_char( trunc( avg( decode(GENDER,'여',salary) ) ), '99,999' ) , ' ') AS 여자기본급여평균
       , to_char( trunc( avg( salary ) ), '99,999') AS 기본급여평균
  from 
  (
    select job_id 
         , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
         , salary
    from employees
  ) V 
  group by job_id
  order by 1;


--- *** 위의 것을 POVOT을 사용하여 구해봅니다. *** ---
with v as (
    select job_id 
         , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS GENDER
         , salary
    from employees
)
select job_id as 직종ID,
       nvl(to_char(trunc(manSalAvg),'99,999'),' ') as 남자기본급여평균,
       nvl(to_char(trunc(womanSalAvg),'99,999'),' ') as 여자기본급여평균
from V
pivot (avg(salary) -- 보여질 데이터 값을 정의한다.
       for gender -- 남, 여 로 보여지는 행의 값이 컬럼으로 보여지게 한다.
       in('남' as manSalAvg,'여' as womanSalAvg)
)
order by 1;


--- *** UNPIVOT *** ---
/*
    UNPIVOT 은 컬럼명을 행의 데이터값으로 변경하고자할 때 사용하는 것으로서,
    열을 행으로 변경하고자 하는 컬럼명과 데이터 영역을 선정해야 한다.    
*/


select first_name || ' ' || last_name as fullname,
       salary,
       salary*commission_pct as commission
from employees
order by 1;


--- 위의 결과물을 아래와 같이 보이고자 한다. ---
/*
    ----------------------------------------------
    fullname            colum_name    data_value  
    ----------------------------------------------
    ........             ........     .........
    Alberto Errazuriz     salary        12000
    Alberto Errazuriz     commission     3600
    ........             ........     .........
    Allan McEwen          salary         9000
    Allan McEwen          commission     3150
    ........             ........     .........
*/

with V as(
    select first_name || ' ' || last_name as fullname,
           salary,
           salary*commission_pct as commission
    from employees
)
select fullname as 사원명, colum_name as 컬럼명, to_char(data_value,'99,999') as 데이터값 
from V
UNPIVOT(data_value       -- 데이터영역의 "컬럼명"을 지정해주는 것
        FOR(colum_name)  -- 컬럼 영역의 "컬럼명"을 지정해주는 것
        IN(salary, commission)
)
order by 1;



------------------------------------------------------------------------------
    ---- !!!!! 중요   JOIN 은 면접에 가시면 무조건 물어봅니다. 중요 !!!!! ---- 
------------------------------------------------------------------------------

                 ------ ==== **** JOIN **** ==== -------
/*
    JOIN(조인)은 테이블(뷰)과 테이블(뷰)을 합치는 것을 말하는데 
    행(ROW)과 행(ROW)을 합치는 것이 아니라, 컬럼(COLUMN)과 컬럼(COLUMN)을 합치는 것을 말한다.
    위에서 말한 행(ROW)과 행(ROW)을 합치는 것은 UNION 연산자를 사용하는 것이다.
    
    -- 질문 : INNER JOIN 과 OUTER JOIN 의 차이점에 대해서 말해보세요.
    -- 면접질문 : JOIN 과 UNION 의 차이점에 대해서 말해보세요. 
    
    A = {1, 2, 3}  원소가 3개
    B = {a, b}     원소가 2개
    
    A ⊙ B = { (1,a), (1,b)
              ,(2,a), (2,b)
              ,(3,a), (3,b) } 
    
    데카르트곱(수학) ==> 원소의 곱 : 3*2 = 6개(모든 경우의 수)
    --> 수학에서 말하는 데카르트곱을 데이터베이스에서는 Catersian Product 라고 부른다. 
    
    JOIN => SQL 1992 CODE 방식 --> 테이블(뷰)과 테이블(뷰) 사이에 콤마(,)를 찍어주는 것.
                                  데이터베이스 밴더(회사) 제품마다 문법이 조금씩 다르다.
                                   
    JOIN => SQL 1999 CODE 방식(ANSI) --> 테이블(뷰)과 테이블(뷰) 사이에 JOIN 이라는 단어를 넣어주는 것.
                                         ANSI(표준화) SQL 
*/

select *
from employees; -- 107개 행

select count(*)
from employees;

select *
from departments;

select count(*)
from departments;   -- 27개 행

select *
from employees, departments;    -- SQL 1992 CODE 방식, Catersian Product

select count(*)
from employees, departments;    -- SQL 1992 CODE 방식
                                -- 2889개 행

select 107*27   -- 2889
from dual;


select *
from employees CROSS JOIN departments;    -- SQL 1999 CODE 방식(ANSI), Catersian Product

select count(*)
from employees CROSS JOIN departments;    -- SQL 1999 CODE 방식
                                          -- 2889개 행


-- 1. cross join 은 프로야구를 예를 들면 10개팀이 있는데 
--    각 1팀당 경기를 몇번해야 하는지 구할때 쓰인다. 1팀당 모든 팀과 경기를 펼쳐야 한다.
-- 2. cross join 은 그룹함수로 나온 1개의 행을 가지고 어떤 데이터 값을 얻으려고 할때 사용된다.

-- [cross join 사용예]
-- 사원번호  사원명  부서번호  기본급여  전체사원의평균급여  평균급여와의차액 --
-- 위와 같이 나오도록 구하세요...

-- 사원번호  사원명  부서번호  기본급여
select employee_id as 사원번호,
        first_name || ' ' || last_name as 사원명,
        department_id as 부서번호,
        salary as 기본급여
from employees;  -- 107개 행

-- 전체사원의평균급여  
select trunc(avg(salary)) as 전체사원의평균급여  -- 6461
from employees; -- 1개 행

-- 사원번호  사원명  부서번호  기본급여  (+)  전체사원의평균급여
select A.employee_id as 사원번호, 
       A.full_name as 사원명,
       A.department_id as 부서번호, 
       A.salary as 기본급여,
       B.avg_sal as 전체사원의평균급여,
       A.salary - B.avg_sal as 평균급여와의차이
from 
(
    select employee_id, first_name || ' ' || last_name as full_name,
            department_id, salary
    from employees
) A --  107개 행
CROSS JOIN
(
    select trunc(avg(salary)) as AVG_SAL  -- 6461
    from employees
) B -- 1개 행
order by 1;


--- *** EQUI JOIN [SQL 1992 CODE 방식] *** ---
-- department_id 값이 같은 것만 매칭을 할 때
  
/*
    [EQUI JOIN 예]
    부서번호 부서명 사원번호 사원명 기본급여
    을 나타내세요.
*/

  부서번호        부서명           사원번호 사원명 기본급여
-- #####        ------          ====================
  departments   departments         employees
  employees
  
  select *
  from employees, departments   -- SQL 1992 CODE 방식
  where employees.department_id = departments.department_id     -- 조인조건절
  order by employee_id;
  -- 106개 행
  -- null은 비교를 할 수 없다. 부서가 배정된 사람만 나온다.  
  
  
  -- 테이블 별칭 사용
  select *
  from employees E, departments D   -- SQL 1992 CODE 방식
  where E.department_id = D.department_id     -- 조인조건절
  order by E.employee_id;       --  106개행
  
  
  -- 테이블명에 별칭을 주면 반드시 별칭을 사용해야지 테이블명을 사용하면 오류가 발생한다.
  select *
  from employees E, departments D   -- SQL 1992 CODE 방식
  where employees.department_id = departments.department_id     -- 조인조건절
  order by E.employee_id;
  -- ORA-00904: "DEPARTMENTS"."DEPARTMENT_ID": invalid identifier
  -- 오류!! 별칭을 주는 순간 조인조건절에서 별칭을 사용해야 한다.
  
  
  
  select  department_id as 부서번호,     -- ORA-00918: column ambiguously defined
          department_name as 부서명,
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E, departments D   -- SQL 1992 CODE 방식
  where E.department_id = D.department_id     -- 조인조건절
  order by E.employee_id;
  
  
  select  E.department_id as 부서번호,     -- department_id 컬럼은 employees 테이블과 departments 테이블 양쪽에 모두 존재하므로 반드시 테이블의 소속을 밝혀주어야 한다.
          department_name as 부서명,       -- department_name 컬럼은 employees 테이블에만 존재하므로 테이블 소속을 생략하더라도 괜찮다. 나머지 이하 동일함.
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E, departments D             -- SQL 1992 CODE 방식
  where E.department_id = D.department_id     -- 조인조건절
  order by 1,3;
  
  
  -- *** 부서번호가 null인(없는) '킨벨리 그랜트' 도 출력하고자 한다. *** -- 
  select *
  from employees;   --  107개 행
  
  select *
  from departments; --  27개 행
  
  select *
  from employees E, departments D                -- SQL 1992 CODE 방식
  where E.department_id = D.department_id(+)     -- 조인조건절
  order by E.employee_id;                        -- 107개행
  /*
      조인조건절에서 (+) 가 없는 별칭 테이블인 E 즉, employees 테이블의 모든 행(107개행)들을
      출력한 다음에 where E.department_id = D.department_id 조건에 만족하는 행들을 참조해서
      짝짓기에 들어간다. 그러면 employees 테이블의 *킴벨리그랜트*는 E.department_id 값이 NULL 이므로
      E.department_id = D.department_id 조건에 만족하는 행이 없으므로 departments 테이블에 해당하느 모든 컬럼은 NULL 이 나온다.
  */
  
  -- ms와 오라클의 문법이 다르기 때문에 1992 code 대신 1999 code를 사용하는 것이 바람직하다.
  -- 이하는 ms에서 위와 같은 효과를 주는 문법
  /*
      select *
      from employees E, departments D                -- SQL 1992 CODE 방식
      where E.department_id =* D.department_id       -- 조인조건절
      order by E.employee_id;                        -- 107개행
  */
  
  select *
  from employees E, departments D                -- SQL 1992 CODE 방식
  where E.department_id(+) = D.department_id     -- 조인조건절
  order by E.employee_id;                        -- 122개행
  /*
      조인조건절에서 (+) 가 없는 별칭 테이블인 D 즉, departments 테이블의 모든 행(27개행)들을
      출력한 다음에 where E.department_id = D.department_id 조건에 만족하는 행들을 참조해서
      짝짓기에 들어간다. 
      그러면 employees 테이블의 존재하지 않고 departments 테이블에만 존재하는 부서번호 120번부터 270번 부서는
      where NULL = D.department_id 와 같이 되므로 
      departments 테이블에 해당하는 모든 컬럼은 NULL 이 나온다.
      
      departments 테이블의 department_id가 270번까지 있고,
      employees 테이블의 department_id가 110번까지 있다.
  */
  
  select  E.department_id as 부서번호,     -- department_id 컬럼은 employees 테이블과 departments 테이블 양쪽에 모두 존재하므로 반드시 테이블의 소속을 밝혀주어야 한다.
          department_name as 부서명,       -- department_name 컬럼은 employees 테이블에만 존재하므로 테이블 소속을 생략하더라도 괜찮다. 나머지 이하 동일함.
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E, departments D             -- SQL 1992 CODE 방식
  where E.department_id = D.department_id(+)  -- 조인조건절
  order by 1,3;                               -- 107개행
  
  
  -- **** SQL 1992 CODE 인 EQUI JOIN 을 SQL 1999 CODE 로 작성해봅니다. **** -- 
  
  -- 1. INNER JOIN (내부조인)
  select *
  from employees E INNER JOIN departments D   -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id        -- 조인조건절
  order by E.employee_id;                     --  106개행
  
  select *
  from employees E JOIN departments D   -- SQL 1999 CODE 방식. INNER 는 생략가능하다.
  ON E.department_id = D.department_id        -- 조인조건절
  order by E.employee_id;                     --  106개행
  
  select  E.department_id as 부서번호,     -- ORA-00918: column ambiguously defined
          department_name as 부서명,
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E JOIN departments D   -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id        -- 조인조건절
  order by E.employee_id;                     -- 106 개행
  
  
  --- 부서번호 30, 50, 60 번에 근무하는 사원들만 
  --- 부서번호, 부서명, 사원번호, 사원명, 기본급여를 나타내세요.
  select  E.department_id as 부서번호,     -- ORA-00918: column ambiguously defined
          department_name as 부서명,
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E , departments D               -- SQL 1992 CODE 방식
  WHERE E.department_id = D.department_id        -- 조인조건절
  AND E.department_id in (30,50,60)
  order by 1;                                    -- 106 개행
  
  
  select  E.department_id as 부서번호,     -- ORA-00918: column ambiguously defined
          department_name as 부서명,
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E JOIN departments D               -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id              -- 조인조건절
  WHERE E.department_id in (30,50,60)
  order by 1;            
  
  
  -- 2. OUTER JOIN (외부조인) ==> LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN
  
  -- *** 부서번호가 NULL 인(없는) '킴벌리그랜트' 도 출력하고자 한다. *** ---
  select *
  from employees E LEFT OUTER JOIN departments D     -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 107 개행
  
  select *
  from employees E LEFT JOIN departments D     -- SQL 1999 CODE, OUTER는 생략가능하다.
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 107 개행
  -- '킴벨리그랜트' 는 출력되지만 부서번호 120번부터 270번인 페이퍼부서는 출력되지 않는다.
  
  
  select *
  from employees E RIGHT OUTER JOIN departments D    -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 122개행

  select *
  from employees E RIGHT JOIN departments D    -- SQL 1999 CODE, OUTER는 생략가능하다.
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 122개행
  -- 부서번호 120번부터 270번인 페이퍼부서는 출력되지만 '킴벨리그랜트' 는 출력되지 않는다.
  
  
  -- '킴벨리그랜트' 도 출력되고, 부서번호 120번부터 270번인 페이퍼부서는 출력하고자 한다.
  select *
  from employees E FULL OUTER JOIN departments D    -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 123개행
 
  
  select *
  from employees E FULL JOIN departments D    -- SQL 1999 CODE, OUTER는 생략가능하다.
  ON E.department_id = D.department_id               -- 조인조건절
  order by E.employee_id;                            -- 123개행
 
  
  select *
  from employees E, departments D                          -- SQL 1992 CODE 방식
  where E.department_id(+) = D.department_id(+)            -- 조인조건절 오류!!
  order by E.employee_id;                                  -- 123개행
  -- ORA-01468: a predicate may reference only one outer-joined table
  -- (+) 를 1개만 사용해야 한다.
  
  --    CROSS JOIN   ==> 
  --    JOIN         ==> INNER JOIN  ==> 조인조건절에 사용되는 컬럼의 값이 NULL 은 출력되지 않는다.
  --    LEFT JOIN    ==> LEFT OUTER JOIN ==> 왼쪽 테이블에 있는 모든 행들은 출력한 후 조인조건절에 들어가서 짝짓기 한다.
  --    RIGHT JOIN   ==> RIGHT OUTER JOIN ==> 오른쪽 테이블에 있는 모든 행들은 출력한 후 조인조건절에 들어가서 짝짓기 한다.
  --    FULL JOIN    ==> FULL OUTER JOIN ==> 양쪽 테이블에 있는 모든 행들은 출력한 후 조인조건절에 들어가서 짝짓기 한다.
  
  
  
  select  E.department_id as 부서번호,     -- department_id 컬럼은 employees 테이블과 departments 테이블 양쪽에 모두 존재하므로 반드시 테이블의 소속을 밝혀주어야 한다.
          department_name as 부서명,       -- department_name 컬럼은 employees 테이블에만 존재하므로 테이블 소속을 생략하더라도 괜찮다. 나머지 이하 동일함.
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E LEFT JOIN departments D       -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id           -- 조인조건절
  order by 1,3;                                  -- 107개행
  
  
  -- 270번까지의 부서번호가 나오게 하려면 departments 테이블의 department_id 를 가져와야 한다.
  select  D.department_id as 부서번호,     -- department_id 컬럼은 employees 테이블과 departments 테이블 양쪽에 모두 존재하므로 반드시 테이블의 소속을 밝혀주어야 한다.
          department_name as 부서명,       -- department_name 컬럼은 employees 테이블에만 존재하므로 테이블 소속을 생략하더라도 괜찮다. 나머지 이하 동일함.
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E RIGHT JOIN departments D       -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id           -- 조인조건절
  order by 1,3;                                  -- 122개행                                  
  
  
  select  D.department_id as 부서번호,     -- department_id 컬럼은 employees 테이블과 departments 테이블 양쪽에 모두 존재하므로 반드시 테이블의 소속을 밝혀주어야 한다.
          department_name as 부서명,       -- department_name 컬럼은 employees 테이블에만 존재하므로 테이블 소속을 생략하더라도 괜찮다. 나머지 이하 동일함.
          employee_id as 사원번호,
          first_name||' '||last_name as 사원명,
          salary as 기본급여
  from employees E FULL JOIN departments D       -- SQL 1999 CODE 방식
  ON E.department_id = D.department_id           -- 조인조건절
  order by 1,3;                                  -- 123개행
  
  
  --- *** JOIN 을 활용한 응용문제 *** ---
  
  -- 아래와 같이 나오도록 하세요.
  -- 부서번호   사원번호    사원명     기본급여    부서평균기본급여    부서평균과의차액
  
  /*
    부서번호가 조인조건절에 쓰임
    ----------------------      ---------------------------------------------------------
    부서번호 부서평균기본급여   +   부서번호    사원번호    사원명     기본급여  
    ----------------------      ---------------------------------------------------------
      10        3500                10      1001      홍길동       3700        3500
      20        4000                10      1001      이순신       2500        3500
      30        2800                20      1001      엄정화       3500        4000
      ...      ......               20      2002      유관순       4500        4000
      110       3200                ..      .....     .....       ....        .....
  */
  
  
  select department_id, trunc(avg(salary)) as avg_deptid_sal
  from employees
  group by department_id
  order by 1;
  
  
  select department_id, employee_id, first_name||' '||last_name as full_name, salary
  from employees
  order by 1;
  

  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON A.department_id = B.department_id
  order by 1,4 desc;
  
  
  
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  LEFT JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON A.department_id = B.department_id
  order by 1,4 desc;
  
  
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  RIGHT JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON A.department_id = B.department_id
  order by 1,4 desc;
  
  
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  FULL JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON A.department_id = B.department_id      -- 108개행, null 은 짝을 지을 수 없다.
  order by 1,4 desc;
  
  
  --- [올바른 풀이] ---
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON nvl(A.department_id, -999) = nvl(B.department_id, -999)  
  order by 1,4 desc;
  
  
  
  -- [퀴즈] 아래와 같이 나오도록 하세요.
  -- 부서번호   사원번호    사원명   기본급여    부서평균기본급여   부서평균과의차액    부서내급여등수    전체급여등수
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
       , rank() over(partition by B.department_id order by salary desc) as 부서내급여등수
       , rank() over(order by salary desc) as 전체급여등수
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON nvl(A.department_id, -999) = nvl(B.department_id, -999)  
  order by 1,4 desc;
  
  
  
  -- [퀴즈] 부서번호가 10, 30, 50 번 부서에 근무하는 사원들만 아래와 같이 나오도록 하세요.
  -- 부서번호   사원번호    사원명   기본급여    부서평균기본급여   부서평균과의차액    부서내급여등수    전체급여등수
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
       , rank() over(partition by B.department_id order by salary desc) as 부서내급여등수
       , rank() over(order by salary desc) as 전체급여등수
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      group by department_id
  ) A
  JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
  ) B
  ON nvl(A.department_id, -999) = nvl(B.department_id, -999)  
  and B.department_id in (10,30,50)
  order by 1,4 desc;
  
  
  -- 아래의 방법을 권장한다. --
  select B.department_id as 부서번호, employee_id as 사원번호, full_name as 사원명, salary as 기본급여
       , avg_deptid_sal as 부서평균기본급여
       , salary - avg_deptid_sal as 부서평균과의차액
       , rank() over(partition by B.department_id order by salary desc) as 부서내급여등수
       , rank() over(order by salary desc) as 전체급여등수
  from
  (
      select department_id, trunc(avg(salary)) as avg_deptid_sal
      from employees
      where department_id in (10,30,50)
      group by department_id
  ) A
  JOIN
  (
      select department_id, employee_id, first_name||' '||last_name as full_name, salary
      from employees
      where department_id in (10,30,50)
  ) B
  ON nvl(A.department_id, -999) = nvl(B.department_id, -999)  
  order by 1,4 desc;  
  
  
  
  --- === *** NON-EQUI JOIN *** === ---
  --> 조인조건절에 사용되는 컬럼의 값이 특정한 범위에 속할 때 사용하는 JOIN 을 말한다.
  --> 조인조건절에 사용되는 컬럼은 = 을 사용하는 것이 아니라 between A and B 를 사용한다.
  
  
  -- 소득세율 지표 관련 테이블을 생성한다. 
  create table tbl_taxindex
  (lowerincome   number       -- 연봉의 최저
  ,highincome    number       -- 연봉의 최대
  ,taxpercent    number(2,2)  -- 세율  -0.99 ~ 0.99 
  );
  
  insert into tbl_taxindex(lowerincome,highincome,taxpercent)
  values(1, 99999, 0.02);

  insert into tbl_taxindex(lowerincome,highincome,taxpercent)
  values(100000, 149999, 0.05);

  insert into tbl_taxindex(lowerincome,highincome,taxpercent)
  values(150000, 199999, 0.08);

  insert into tbl_taxindex(lowerincome,highincome,taxpercent)
  values(200000, 10000000000000000, 0.1);

  commit;
  
  select *
  from tbl_taxindex;
  
  ---------------------------------------------------
  사원번호      사원명     연봉      세율      소득세액
  ---------------------------------------------------
   1001        홍길동    50000     0.02     50000*0.02
   1001        엄정화    150000    0.1      150000*0.1
   

  -- SQL 1992 CODE --
  /*
      사원번호  사원명   연봉    ==> employees    테이블
      세율                     ==> tbl_taxindex 테이블
  */
  
  select  employee_id as 사원번호, first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct), salary)*12 as 연봉, taxpercent as 세율
       , nvl(salary+(salary*commission_pct), salary)*12*taxpercent as 소득세율
  from employees E, tbl_taxindex T   -- SQL 1992 CODE
  where nvl(salary+(salary*commission_pct), salary)*12 between T.lowerincome and T.highincome
  order by 1;
  
  
  select  employee_id as 사원번호, first_name||' '||last_name as 사원명
       , nvl(salary+(salary*commission_pct), salary)*12 as 연봉, taxpercent as 세율
       , nvl(salary+(salary*commission_pct), salary)*12*taxpercent as 소득세율
  from employees E JOIN tbl_taxindex T   -- SQL 1999 CODE
  ON nvl(salary+(salary*commission_pct), salary)*12 between T.lowerincome and T.highincome
  order by 1;
  
  
  
  --- === *** SELF JOIN (자기조인) *** === ---
  /*
       자기자신의 테이블(뷰)을 자기자신의 테이블(뷰)과 JOIN 시키는 것을 말한다.
       이때 반드시 테이블(뷰)에 대한 alias(별칭)를 달리 주어서 실행해야 한다.
  */
  
    -------------------------------------------------------------------------------------------------------
    사원번호     사원명                        이메일    급여      직속상관번호      직속상관명
    employ_id  first_name||' '||last_name   email    salary   employee_id     first_name||' '||last_name          
    -------------------------------------------------------------------------------------------------------
     100        Steven   King               SKING     24000     null           null 
     102        Lex De Haan                 LDEHAAN   17000     100            Steven King
     103        Alexander   Hunold          AHUNOLD   9000      102            Lex De Haan
     104        Bruce Ernst                 BERNST    6000      103            Alexander Hunold
  
  select *
  from employees
  order by employee_id;
  
  select *
  from employees E1, employees E2;   -- SQL 1992 CODE
  
  select 107*107
  from dual;    -- 11449
  
  select count(*)
  from employees E1, employees E2;   -- 11449
  
  select *
  from employees E1, employees E2        -- SQL 1992 CODE
  where E1.manager_id = E2.employee_id;  -- 106 개행
  -- '스티븐 킹'의 manager_id 가 null 값이므로 대응 안 됨.
  
  select *
  from employees E1, employees E2           -- SQL 1992 CODE
  where E1.manager_id = E2.employee_id(+);  -- 107 개행
  
  
  select E1.employee_id as 사원번호, E1.first_name||' '||E1.last_name as 사원명, E1.email as 이메일
       , E1.salary as 급여, E2.employee_id as 직속상관번호, E2.first_name||' '||E2.last_name as 직속상관명
  from employees E1, employees E2          -- SQL 1992 CODE
  where E1.manager_id = E2.employee_id(+)  -- 107 개행
  order by 1;
  
  
  select E1.employee_id as 사원번호, E1.first_name||' '||E1.last_name as 사원명, E1.email as 이메일
       , E1.salary as 급여, E2.employee_id as 직속상관번호, E2.first_name||' '||E2.last_name as 직속상관명
  from employees E1 LEFT JOIN employees E2          -- SQL 1999 CODE
  ON E1.manager_id = E2.employee_id(+)              -- 107 개행
  order by 1;
  
  
  -- [퀴즈] --
   create table tbl_authorbook
   (bookname       varchar2(100)
   ,authorname     varchar2(20)
   ,loyalty        number(5)
   );
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('자바프로그래밍','조연재',1000);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('로빈슨크루소','한서연',800);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('로빈슨크루소','조연재',500);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('조선왕조실록','한수연',2500);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('그리스로마신화','김다님',1200);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('그리스로마신화','김성경',1300);
   
   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('그리스로마신화','김성빈',1700);

   insert into tbl_authorbook(bookname, authorname, loyalty)
   values('어린왕자','김정완',1800);
   
   commit;
   
   select *
   from tbl_authorbook;
   
   /*
      tbl_authorbook 테이블에서 공저(도서명은 동일하지만 작가명이 다른 도서)로 지어진
      도서정보를 나타내세요 (SELF JOIN 을 사용해서 풀이)
   */
   ----------------------------------------
     도서명             작가명     로얄티
   ----------------------------------------
     그리스로마신화       김다님      1200
     그리스로마신화       김성경      1300
     그리스로마신화       김성빈      1700
     로빈슨크루소         한서연       800
     로빈슨크루소         조연재       500
     -------------------------------------
  
  -- select 되어진 결과 행이 동일한 값을 가질 경우 중복된 행들을 모두 보여주지 않고 
  -- 중복된 행들은 1번만 보이도록 하려면 select 바로 다음에 distinct 를 쓰면 된다.
  select department_id
  from employees
  order by 1;
  
  select distinct department_id, job_id
  from employees
  order by 1;
  
  
  select distinct A.bookname as 도서명, A.authorname as 작가명, A.loyalty as 로얄티
  from tbl_authorbook  A, tbl_authorbook B  
  where A.bookname = B.bookname 
  and A.authorname != B.authorname;
  
  
  select distinct A.bookname as 도서명, A.authorname as 작가명, A.loyalty as 로얄티
  from tbl_authorbook  A join tbl_authorbook B  
  on A.bookname = B.bookname 
  and A.authorname != B.authorname;
  
  
  --- *** multi table join (다중테이블 조인) *** ---
  ---> 3개 이상의 테이블(뷰)을 가지고 조인 시켜주는 것이다.
  
  /*
        -------------------------------------------------------------------------------------------------------------------
         부서번호   부서명     국가명                           부서주소                       사원번호     사원명         기본급여
        -------------------------------------------------------------------------------------------------------------------
           90     Executive   United States of America        Seattle 2004 Charade Rd      100       Steven King    24000
  
         부서번호 => employees.department_id, departments.department_id 
         부서명 => departments.department_name
         국가명 => countiries.country_name
         부서주소 => locations.city  locations.street_address
         사원번호 => employees.employee_id
         사원명 => employees.first_name  employees.last_name
         기본급여 => employees.salary
         
         테이블 ==> employees, departments, locations, countries
         
                   employees E
                   + 
                   departments D => 조인조건 컬럼명
                                    E.department_id = D.department_id
                   +
                   locations L => 조인조건 컬럼명
                                  D.location_id = L.location_id
                   +
                   countries C => 조인조건 컬럼명
                                  L.country_id = C.country_id
         
  */
  
  select *
  from employees;
  
  select *
  from departments;
  
  select *
  from locations;
  
  select *
  from countries;
  
  
  -- SQL 1992 CODE
  select E.department_id as 부서번호, D.department_name as 부서명, C.country_name as 국가명,
         L.city||' '||L.street_address as 부서주소, E.employee_id as 사원번호,
         E.first_name||' '||last_name as 사원명, E.salary as 기본급여
  from employees E, departments D, locations L, countries C 
  where  E.department_id = D.department_id
         and D.location_id = L.location_id
         and L.country_id = C.country_id    -- 조인조건절
  order by 1,5;    -- 106 개행
  
  
   -- SQL 1999 CODE
   select E.department_id AS 부서번호
        , D.department_name AS 부서명
        , C.country_name AS 국가명
        , L.city || ' ' || L.street_address AS 부서주소
        , E.employee_id AS 사원번호
        , E.first_name || ' ' || E.last_name AS 사원명
        , E.salary AS 기본급여
   from employees E JOIN departments D 
   ON E.department_id = D.department_id  -- 조인조건절
   JOIN locations L
   ON D.location_id = L.location_id      -- 조인조건절
   JOIN countries C
   ON L.country_id = C.country_id        -- 조인조건절
   order by 1, 5;  -- 106 개행
 
   
  -- *** department_id 가 NULL 인 '킨벨리 그랜트'가 나오도록 하세요 *** ---
 
  -- SQL 1992 CODE
  select E.department_id as 부서번호, D.department_name as 부서명, C.country_name as 국가명,
         L.city||' '||L.street_address as 부서주소, E.employee_id as 사원번호,
         E.first_name||' '||last_name as 사원명, E.salary as 기본급여
  from employees E, departments D, locations L, countries C 
  where  E.department_id = D.department_id(+)
         and D.location_id = L.location_id(+)
         and L.country_id = C.country_id(+)    -- 조인조건절
  order by 1,5;    -- 107 개행
  
  
   -- SQL 1999 CODE
   select E.department_id AS 부서번호
        , D.department_name AS 부서명
        , C.country_name AS 국가명
        , L.city || ' ' || L.street_address AS 부서주소
        , E.employee_id AS 사원번호
        , E.first_name || ' ' || E.last_name AS 사원명
        , E.salary AS 기본급여
   from employees E LEFT JOIN departments D 
   ON E.department_id = D.department_id  -- 조인조건절
   LEFT JOIN locations L
   ON D.location_id = L.location_id      -- 조인조건절
   LEFT JOIN countries C
   ON L.country_id = C.country_id        -- 조인조건절
   order by 1, 5;  -- 107 개행
  
   
   --- [과제] --- 금요일까지 제출하기
   -- 풀이한 SQL문을 hanmailrg@naver.com 으로 제출하세요...
   -- 사원수가 107명이 나와야 합니다 !!!
   ----------------------------------------------------------------------------------------------------------
   부서번호   부서명   부서주소  부서장성명  사원번호  사원명  연봉  연봉소득세액  부서내연봉평균차액   부서내연봉등수
  ---------------------------------------------------------------------------------------------------------- 
 
  select V.department_id as 부서번호, 
         D.department_name as 부서명, 
         L.city||' '||L.street_address as 부서주소,
         D.full_name as 부서장성명, 
         V.employee_id as 사원번호, 
         V.full_name as 사원명,
         V.yr_salary as 연봉, 
         V.yr_salary * T.taxpercent as 연봉소득세액,
         V.yr_salary - V2.yr_avg_salary as 부서내연봉평균차액,
         rank() over(partition by V.department_id order by V.yr_salary desc) as 부서내연봉등수
  from 
  (
   select department_id, employee_id, first_name||' '||last_name as full_name, 
          nvl(salary+(salary*commission_pct), salary)*12 as yr_salary
   from employees
  ) V
  
  left join
  (
   select department_id, 
          trunc(avg(nvl(salary+(salary*commission_pct), salary)*12)) as yr_avg_salary
   from employees
   group by department_id
  ) V2
  on nvl(V.department_id,-999) = nvl(V2.department_id,-999)
  
  left join 
  (
  select dept.department_id, department_name, location_id, em.first_name||' '||em.last_name as full_name
  from departments dept join employees em
  on dept.manager_id = em.employee_id
  ) D
  on nvl(V2.department_id,-999) = nvl(D.department_id,-999)
  
  left join locations L
  on D.location_id = L.location_id
  
  left join tbl_taxindex T  
  on V.yr_salary between T.lowerincome and T.highincome
  
  order by 1,10;
  

  
 ----- **** SET Operator(SET 연산자, 집합연산자) **** -----
 ---- *** UNION / UNION ALL / INTERSECT / MINUS *** ---- 
 -- 면접시 JOIN 과 UNION 의 차이점에 대해서 말해보세요~~!! 
 -- JOIN 은 컬럼과 컬럼을 UNION 은 행과 행을 합친 결과를 보여줌
 
 
/*
    ==>  UNION 은 테이블(뷰)과 테이블(뷰)을 합쳐서 보여주는 것으로써,
         이것은 행(ROW)과 행(ROW)을 합친 결과를 보여주는 것이다.
    
        A = { a, x, b, e, g }
              -     -
        B = { c, d, a, b, y, k, m}    
                    -  -    
        A ∪ B = {a, b, c, d, e, g, k, m, x, y}  ==> UNION   -- 항상 오름차순 정렬되어 나옴            
                                                 {a, b, c, d, e, g, k, m, x, y}
    
                                                 / UNION ALL   -- 정렬없음
                                                 {a, x, b, e, g, c, d, a, b, y, k, m} 
    
        A ∩ B = {a,b}  ==> INTERSECT
                           {a,b}
    
        A - B = {x,e,g} ==> MINUS           -- 집합 A에만 존재
                            {x,e,g}
    
        B - A = {c,d,y,k,m} ==> MINUS       -- 집합 B에만 존재
                               {c,d,y,k,m}
   
*/

select *
from tbl_panmae;

-- 현재가 2021년 2월이므로 2달전은 2020년 12월이다.
-- 2020년 12월 판매되어진 정보는 tbl_panmae_202012 이라는 테이블을 생성하여 이 테이블 속으로 데이터를 옮기고자 한다.
-- 이렇게 하려면 먼저 2020년 12월에 판매되어진 정보를 추출해야 한다.
select to_char(add_months(sysdate,-2),'yymm')   -- 202012
from dual;

create table tbl_panmae_202012
as
select *
from tbl_panmae
-- where to_char(panmaedate,'yymm') = '2012';
where to_char(panmaedate,'yyyymm') = to_char(add_months(sysdate,-2),'yyyymm');

select *
from tbl_panmae_202012;


-- 현재가 2021년 2월이므로 1달전은 2021년 1월이다.
-- 2021년 1월 판매되어진 정보는 tbl_panmae_202101 이라는 테이블을 생성하여 이 테이블 속으로 데이터를 옮기고자 한다.
-- 이렇게 하려면 먼저 2021년 1월에 판매되어진 정보를 추출해야 한다.
select to_char(add_months(sysdate,-1),'yymm')   -- 202101
from dual;

create table tbl_panmae_202101
as
select *
from tbl_panmae
where to_char(panmaedate,'yyyymm') = to_char(add_months(sysdate,-1),'yyyymm');

select *
from tbl_panmae_202101;

select *
from tbl_panmae;

-- tbl_panmae 테이블에서 이번달에 판매되어진 것이 아닌 것들만 추출하세요.
select *
from tbl_panmae
where to_char(panmaedate,'yyyymm') != to_char(sysdate,'yyyymm');

select *
from tbl_panmae
where to_char(panmaedate,'yyyymm') < to_char(sysdate,'yyyymm');
-- 날짜도 크기 비교가 가능하다


-- tbl_panmae_202012 테이블 및 tbl_panmae_202101 테이블 속에 데이터를 이관 시켜두었으므로
-- tbl_panmae 테이블에서 이번달에 판매되어진 것이 아닌 것들은 삭제해야 한다.
-- tbl_panmae 테이블에서 이번달에 판매되어진 것이 아닌 것들은 삭제하세요.
delete from tbl_panmae
where to_char(panmaedate,'yyyymm') != to_char(sysdate,'yyyymm');
-- 9개 행 이(가) 삭제되었습니다.

commit; 

select *
from tbl_panmae;    -- tbl_panmae 테이블에는 이번달(2021년 2월)에 판매되어진 정보만 들어있다.


-- 최근 3개월간 판매되어진 정보를 가지고 제품별 판매량의 합계를 추출하세요.
select *
from tbl_panmae_202012;    -- 2달 전

select *
from tbl_panmae_202101;    -- 1달 전

select *
from tbl_panmae;    -- 이번달


select *
from tbl_panmae_202012
UNION
select *
from tbl_panmae_202101
UNION
select *
from tbl_panmae;



select *
from tbl_panmae_202101
UNION
select *
from tbl_panmae_202012
UNION
select *
from tbl_panmae;
-- UNION 을 하면 항상 첫번째 컬럼(지금은 panmaedate)을 기준으로 오름차순으로 정렬되어 나온다.
-- 그래서 2020년 12월 데이터부터 먼저 나온다.

-- 최근 3년간 판매되어진 정보를 가지고 제품별 판매량의 합계를 추출하세요.
select jepumname as 제품명, sum(panmaesu) as 판매량합계
from
(
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
) V
group by jepumname
order by 2 desc;
/*
    ----------------
    제품명     판매량
    ----------------
    새우깡	    76
    고구마깡	    52
    감자깡	    50
    허니버터칩	65
*/

with V as (
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
)
select jepumname as 제품명, sum(panmaesu)
from V
group by jepumname
order by 2 desc;


-- [퀴즈] 아래와 같이 나오도록 하세요...
-- 최근 3개월동안 판매되어진 정보를 가지고 제품명, 판매년월, 판매량의 합계 를 나타내세요.
    -----------------------------------
    제품명     판매년월     판매량의합계
    -----------------------------------
    감자깡     2020-12         10
    감자깡     2021-01         25
    감자깡     2021-02         15
    감자깡                     50
    새우깡     2020-12         20
    새우깡     2021-01         10
    새우깡     2021-02         30
    새우깡                     60
    .....    .........       ....
    전체                      153
    ---------------------------------

select decode(grouping(jepumname),0,jepumname,'전체') as 제품명
     , decode(grouping(to_char(panmaedate,'yyyy-mm')),0,to_char(panmaedate,'yyyy-mm'),' ') as 판매년월
     , sum(panmaesu)
from
(
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
) V
group by rollup(jepumname, to_char(panmaedate,'yyyy-mm'));
-- 전체 그룹 짓고 뒤애서부터 없어지면서 그룹짓는다.

-- 또는
with V as (
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
)
select decode(grouping(jepumname),0,jepumname,1,'전체') as 제품명, decode(grouping(to_char(panmaedate,'yyyy-mm')),0,to_char(panmaedate,'yyyy-mm'),1,' ') as 판매일자, sum(panmaesu) as 판매량
from V
group by rollup(jepumname,to_char(panmaedate,'yyyy-mm'));



-- [퀴즈] 아래와 같이 나오도록 하세요...
-- 최근 3개월동안 판매되어진 정보를 가지고 제품명, 판매년월, 판매량의합계, 퍼센티지(%) 를 나타내세요.
    ------------------------------------------------
    제품명     판매년월     판매량의합계     퍼센티지(%)
    ------------------------------------------------
    감자깡     2020-12         10           7.9
    감자깡     2021-01         25           5.9 
    감자깡     2021-02         15           5.9
    감자깡                     50          19.8
    새우깡     2020-12         38          15.0          
    새우깡     2021-01          8           3.2
    새우깡     2021-02         30          11.9
    새우깡                     76          30.0
    .....    .........       ....        ......
    전체                      153         100.0
    -----------------------------------------------

select decode(grouping(jepumname),0,jepumname,'전체') as 제품명
     , decode(grouping(to_char(panmaedate,'yyyy-mm')),0,to_char(panmaedate,'yyyy-mm'),' ') as 판매년월
     , sum(panmaesu) as 판매량의합계
     , to_char( round( sum(panmaesu)/(select sum(T.panmaesu) from (
                                                            select *
                                                            from tbl_panmae_202012
                                                            UNION
                                                            select *
                                                            from tbl_panmae_202101
                                                            UNION
                                                            select *
                                                            from tbl_panmae
                                                            ) T ) *100 , 1 ),'999.0') as "퍼센티지(%)"
from
(
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
) V
group by rollup(jepumname, to_char(panmaedate,'yyyy-mm'));


-- 또는
with V as (
    select *
    from tbl_panmae_202012
    UNION
    select *
    from tbl_panmae_202101
    UNION
    select *
    from tbl_panmae
)
select decode(grouping(jepumname),0,jepumname,1,'전체') as 제품명, decode(grouping(to_char(panmaedate,'yyyy-mm')),0,to_char(panmaedate,'yyyy-mm'),1,' ') as 판매일자, sum(panmaesu) as 판매량,
       to_char(round(sum(panmaesu)/(select sum(panmaesu) from V)*100,1),'999.0') as "퍼센티지(%)"
from V
group by rollup(jepumname,to_char(panmaedate,'yyyy-mm'));


        ----- **** INTERSECT(교집합) / MINUS(차집합) **** -----
 insert into tbl_panmae_202012(panmaedate, jepumname, panmaesu)
 values('2021-02-01', '쵸코파이', 10);

 insert into tbl_panmae_202101(panmaedate, jepumname, panmaesu)
 values(to_date('2021-02-01','yyyy-mm-dd'), '쵸코파이', 10);
 -- 원래는 형변환해야 하는게 원칙인데 자동형변환된다.

 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values(to_date('2021-02-01','yyyy-mm-dd'), '쵸코파이', 10);

 commit;
 
 select *
 from tbl_panmae_202012
 INTERSECT
 select *
 from tbl_panmae_202101 
 INTERSECT
 select *
 from tbl_panmae;


 select *
 from tbl_panmae_202012
 MINUS
 select *
 from tbl_panmae_202101;
 
 
 select *
 from tbl_panmae_202101
 MINUS
 select *
 from tbl_panmae_202012;


    --- *** UNION 과 UNION All 의 차이점 *** ---
select *
from tbl_panmae_202101
UNION
select *
from tbl_panmae_202012
UNION
select *
from tbl_panmae;
-- UNION 을 하면 항상 첫번째 컬럼(지금은 panmaedate)을 기준으로 오름차순으로 정렬되어 나온다.
-- 그래서 2020년 12월 데이터부터 먼저 나온다.
-- UNION 을 하면 중복된 행이 있을 경우(지금은 쵸코파이) 중복되게 안나오고 한 번만 나온다.
-- 그래서 쵸코파이는 1번만 나오게 된다.


select jepumname, panmaedate, panmaesu
from tbl_panmae_202101
UNION
select panmaesu, jepumname, panmaedate
from tbl_panmae_202012
UNION
select panmaesu, jepumname, panmaedate
from tbl_panmae;
-- ORA-01790: expression must have same datatype as corresponding expression

select jepumname, panmaedate, panmaesu
from tbl_panmae_202101
UNION
select panmaesu, jepumname
from tbl_panmae_202012
UNION
select panmaesu, jepumname, panmaedate
from tbl_panmae;
-- ORA-01789: query block has incorrect number of result columns

select jepumname as 제품명, panmaedate, panmaesu
from tbl_panmae_202101
UNION
select jepumname as 제품이름, panmaedate as 판매일자, panmaesu
from tbl_panmae_202012
UNION
select jepumname, panmaedate, panmaesu
from tbl_panmae;
-- UNION 을 하면 항상 첫번째 컬럼(지금은 jepumname)을 기준으로 오름차순으로 정렬되어 나온다.
-- 그래서 감자깡부터 먼저 나온다.
-- UNION 을 하면 중복된 행이 있을 경우(지금은 쵸코파이) 중복되게 안나오고 한 번만 나온다.
-- 그래서 쵸코파이는 1번만 나오게 된다.
-- 별칭(alias)은 첫번째 나타나는 select 절에서만 쓰여지고 나머지 두번째 이후부터는 적용이 안된다.


select *
from tbl_panmae_202101
UNION ALL
select *
from tbl_panmae_202012
UNION ALL
select *
from tbl_panmae;
-- UNION ALL을 하면 정렬없이 그대로 나온다.
-- 그래서 UNION ALL을 하면 중복된 행이 있을 경우(지금은 쵸코파이) 중복된 채로 그대로 나온다.
-- 그래서 쵸코파이는 3번만 나오게 된다.


select jepumname as 제품명, panmaedate, panmaesu
from tbl_panmae_202101
UNION ALL
select jepumname as 제품이름, panmaedate as 판매일자, panmaesu
from tbl_panmae_202012
UNION ALL
select jepumname, panmaedate, panmaesu
from tbl_panmae;
-- 별칭(alias)은 첫번째 나타나는 select 절에서만 쓰여지고 나머지 두번째 이후부터는 적용이 안된다.


-- UNION 과 UNION ALL 중에 결과값을 보여주는 속도는 UNION ALL 이 더 빠르다.
-- 왜냐하면 행의 중복제거도 없고 오름차순 정렬도 없기 때문이다.


 insert into tbl_panmae_202012(panmaedate, jepumname, panmaesu)
 values('2021-02-01', '쵸코파이', 20);

 insert into tbl_panmae_202101(panmaedate, jepumname, panmaesu)
 values(to_date('2021-02-02','yyyy-mm-dd'), '쵸코파이', 10);
 
 insert into tbl_panmae(panmaedate, jepumname, panmaesu)
 values(to_date('2021-02-03','yyyy-mm-dd'), '쵸코파이', 30);

 commit;

 select *
 from tbl_panmae_202101
 INTERSECT
 select *
 from tbl_panmae_202012
 INTERSECT
 select *
 from tbl_panmae;
 --> 결과값 21/02/01 쵸코파이 10
 
 --- *** tbl_panmae_202012 과 tbl_panmae_202101 과 tbl_panmae 에서 
 --      동일한 데이터를 가지는 행을 백업한 이후에 삭제하세요.  *** ---
 
 -- 동일한 데이터를 가지는 행을 백업하기
 create table tbl_panmae_intersect
 as
 select *
 from tbl_panmae_202101
 INTERSECT
 select *
 from tbl_panmae_202012
 INTERSECT
 select *
 from tbl_panmae;
 -- Table TBL_PANMAE_INTERSECT이(가) 생성되었습니다.
 
 select *
 from tbl_panmae_intersect;

 select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
 from tbl_panmae_202101
 INTERSECT
 select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
 from tbl_panmae_202012
 INTERSECT
 select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
 from tbl_panmae;
 -- 2021-02-01 00:00:00쵸코파이10
             
 select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
 from tbl_panmae_202012;


-- ***********************************
-- delete 3개 잘못됨!!! 나중에 코드받아서 복붙할 것
-- ***********************************

 delete from tbl_panmae_202012
 where to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaedu
        IN(
             select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
             from tbl_panmae_202012
             INTERSECT
             select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
             from tbl_panmae_202101
             INTERSECT
             select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
             from tbl_panmae
        );
  
 delete from tbl_panmae_202101
 where to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaedu
        IN(
             select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
             from tbl_panmae_202101
             INTERSECT
             select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
             from tbl_panmae
        );
      
 delete from tbl_panmae
 where to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaedu
        IN( select to_char(panmaedate,'yyyy-mm-dd hh24:mi:ss')||jepumname|| panmaesu
            from tbl_panmae_intersect );

 rollback;
 
 select *
 from tbl_panmae_202012;


         ----- ==== **** SUB Query **** ==== ------
/*
    -- SUB Query(서브쿼리)란?
    select 문속에 또 다른 select 문이 포함되어져 있을때 포함되어진 select 문을 
    SUB Query(서브쿼리)라고 부른다.

    select ....
    from ......  ==> Main Query(메인쿼리 == 외부쿼리)
    where ... in (select...
                  from ....) ==> SUB Query(서브쿼리 == 내부쿼리)
*/

/*
    employees 테이블에서 기본급여가 제일많은 사원과 
    기본급여가 제일적은 사원의 정보를   사원번호, 사원명, 기본급여로 나타내세요...
*/

select employee_id as 사원번호, first_name||' '||last_name as 사원명, salary as 기본급여
from employees
where salary = (select max(salary) from employees) or
      salary = (select min(salary) from employees);

/*
    ---------------------------
    사원번호 사원명       기본급여
    ---------------------------
    100 	Steven King	24000
    132	    TJ Olson	2100
*/



/*
   employees 테이블에서 부서번호가 60, 80번 부서에 근무하는 사원들중에
   월급이 50번 부서 직원들의 '평균월급' 보다 많은 사원들만 
   부서번호, 사원번호, 사원명, 월급을 나타내세요....
*/


select department
from employees
where department_id in(60,80) and
      nvl(salary + (salary * commission_pct), salary) > (50번 부서 직원들의 '평균월급');
      
50번 부서 직원들의 '평균월급' 
=> select AVG(nvl(salary + (salary * commission_pct), salary))  
   from employees where department_id = 50;
 
 
select department_id AS 부서번호
     , employee_id AS 사원번호
     , first_name || ' ' || last_name AS 사원명
     , nvl(salary + (salary * commission_pct), salary) AS 월급  
from employees
where department_id in(60,80) and
      nvl(salary + (salary * commission_pct), salary) > ( select AVG(nvl(salary + (salary * commission_pct), salary))  
                                                          from employees where department_id = 50 )   
order by 1 , 4;  



        --- *** ==== ANY, ALL ==== *** ---
    /*
        Sub Query 절에서 사용되어지는 ANY 는 OR 와 흡사하고, =ANY 는 in 과 동일 
        Sub Query 절에서 사용되어지는 ALL 은 AND 와 흡사하다. 
    */
    
    -- employees 테이블에서 salary가 30번 부서에 근무하는 사원들의 salary 와 동일한 사원들만 추출하세요
    -- 단, 30번 부서에 근무하는 사원은 제외하세요!
    select salary
    from employees
    where department_id = 30;
    /*
        11000
        3100
        2900
        2800
        2600
        2500
    */

    desc employees;
    
    select *
    from employees
    where nvl(department_id,-999) != 30 and
          select salary in (11000,3100,2900,2800,2600,2500);
    -- where 절 작성시 미리 desc 를 보고 null 값을 허용하는지 확인할 것!!!

    select *
    from employees
    where nvl(department_id,-999) != 30 and
          salary in (select salary from employees where department_id = 30);

    select department_id as 부서번호,
            first_name||' '||last_name as 사원명,
            salary as 기본급여
    from employees
    where nvl(department_id,-999) != 30 and
          salary =ANY (select salary from employees where department_id = 30)
    order by 1;


    /*
        기본급여(salary)가 제일 많은 사원을 제외한 나머지 모든 사원들만
        사원번호, 사원명, 기본급여(salary)를 나타내세요..
    */
    
    from employees
    where salary < (employees 테이블에서 salary 의 최대값);

    from employees
    where salary != (employees 테이블에서 salary 의 최대값);

    employees 테이블에서 salary 의 최대값
    => select max(salary) from employees;   -- 24000
    
    from employees
    where salary >=ALL (select salary from employees)
    -- 24000           ( 10500, 11500, 6100, 6200, 4100, 2900, 2800, 24000 )
    
    -- 24000 >= 10500 참 and 
    -- 24000 >= 11500 참 and 
    -- 24000 >=  6100 참 and 
    -- 24000 >=  6200 참 and 
    -- 24000 >=  4100 참 and 
    -- .............. 참 and 
    -- 24000 >= 24000 참

    -- 11500           ( 10500, 11500, 6100, 6200, 4100, 2900, 2800, 24000 )

    -- 11500 >= 10500 참 and 
    -- 11500 >= 11500 참 and 
    -- 11500 >=  6100 참 and 
    -- 11500 >=  6200 참 and 
    -- 11500 >=  4100 참 and 
    -- .............. 참 and 
    -- 11500 >= 24000 거짓
    
    select max(salary) from employees;
    -- 또는
    select salary
    from employees
    where salary >= ALL ( select salary from employees);
    
    
    --- ALL 을 사용시 조심해야할 경우
    select salary * commission_pct  from employees;   -- NULL 값이 나오는 것이 있다.
   
    select MAX(salary * commission_pct) from employees;    -- 5600

    select salary  * commission_pct
    from employees
    where salary  * commission_pct >= ALL ( select salary  * commission_pct from employees);
    -- 5600 >= (2625, 2875, 610, 620, NULL, 5600, ...... )
    -- 5600 >= 2625    참 and
    -- 5600 >= 2875    참 and
    -- 5600 >= 610     참 and    
    -- 5600 >= 620     참 and
    -- 5600 >= NULL    비교를 할 수 없다.
    -- 5600 >= 5600     참 and
    
    -- [해결책] ALL 를 사용하여 나온는 결과물에는 NULL 이 나오지 않도록 해야만 한다.
    select salary  * commission_pct
    from employees
    where salary  * commission_pct >= ALL ( select salary  * commission_pct 
                                            from employees
                                            where salary  * commission_pct IS NOT NULL );
    -- 5600    
    
    
    --    기본급여(salary)가 제일 많은 사원을 제외한 나머지 모든 사원들만
    --    사원번호, 사원명, 기본급여(salary)를 나타내세요..
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary as 기본급여           
    from employees
    where salary < (select max(salary) from employees) -- 24000
    order by 3 desc;
    
    -- 또는
     select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary as 기본급여           
    from employees
    where not salary >= ALL (select salary 
                        from employees
                        where salary is not null) -- 24000
    order by 3 desc;
    -- 1등을 뺀 나머지는 not 을 활용한다.
    
    
    
    --    기본급여(salary)가 제일 적은 사원을 제외한 나머지 모든 사원들만
    --    사원번호, 사원명, 기본급여(salary)를 나타내세요..
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary as 기본급여           
    from employees
    where salary > (select min(salary) from employees) -- 2100
    order by 3;
    
    -- 또는
     select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary as 기본급여           
    from employees
    where not salary <= ALL (select salary 
                        from employees
                        where salary is not null) -- 2100
    order by 3;
    -- 1등을 뺀 나머지는 not 을 활용한다.
    
    
    
    --    수당(salary*commission_pct)가 제일많은 사원을 제외한 나머지 모든 사원들만
    --    사원번호, 사원명, 수당(salary*commission_pct)를 나타내세요..
    select first_name, salary
    from employees
    where salary in (6100, 6200, null, 4100)
    order by 2 asc;
    
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary*commission_pct as 수당 
    from employees
    where salary*commission_pct < ANY (select salary*commission_pct from employees) -- NULL 포함
    order by 3 desc;
    /*
        salary*commission_pct < (2625    2875    610     620      NULL      5600    .....)  
            
            2875    <   2625  거짓 OR
            2875    <   2875  거짓 OR
            2875    <    610  거짓 OR
            2875    <    620  거짓 OR
            2875    <   NULL  연산불가 OR
            2875    <   5600  참
            
            5600    <   2625  거짓 OR
            5600    <   2875  거짓 OR
            5600    <    610  거짓 OR
            5600    <    620  거짓 OR
            5600    <   NULL  연산불가 OR
            5600    <   5600  거짓
    */


    --    수당(salary*commission_pct)가 제일적은 사원을 제외한 나머지 모든 사원들만
    --    사원번호, 사원명, 수당(salary*commission_pct)를 나타내세요..
    select employee_id as 사원번호,
           first_name||' '||last_name as 사원명,
           salary*commission_pct as 수당 
    from employees
    where salary*commission_pct > ANY (select salary*commission_pct from employees) -- NULL 포함
    order by 3;
   
   
   
   ------- ==== *** Pairwise Sub Query *** ==== --------  
    /*
       employees 테이블에서 
       부서번호별로 salary 가 최대인 사원과
       부서번호별로 salary 가 최소인 사원의 정보를
       부서번호, 사원번호, 사원명, 기본급여를 나타내세요...
    */
    
    select department_id, salary
    from employees
    order by 1, 2;
    
    /*                               결과물
    -----------------------         -----------------------
    department_id   salary          department_id   salary
    -----------------------         -----------------------
        ..          ....                 ..          ....
        30	        2500                 30	         2500
        30	        2600                 30         11000
        30	        2800                 ..          ....
        30      	2900                 50          2100
        30	        3100                 50          8200
        30	       11000                 ..          ....
        ..          ....                 80          6100
        50	        2100                 80         14000
        50      	2200
        50	        2200
        50	        2400
        50      	2400
        50      	2500
        50      	2500
        50       	2500
        50        	2500
        50      	2500
        50      	2600
        50       	2600
        50      	2600
        ..          ....
        50	        8000
        50	        8200
        ..          ....
    */
    
    select department_id, salary
    from employees
    where (department_id, salary) IN ((30,2500),(30,11000),(50,2100),(50,8200),(80,6100),(80,14000));
    
    select nvl(department_id,-9999) as 부서번호, employee_id as 사원번호, first_name||' '||last_name as 사원명,
           salary as 기본급여
    from employees
    where (nvl(department_id,-9999), salary) IN (select nvl(department_id,-9999), min(salary)
                                                from employees
                                                group by department_id
                                                UNION
                                                select nvl(department_id,-9999), max(salary)
                                                from employees
                                                group by department_id  
                                    )
    order by 1,4;
    
    
    /*
       employees 테이블에서 
       부서번호별로 salary 가 최대인 사원과
       부서번호별로 salary 가 최소인 사원의 제외한 나머지 사원들의 정보를
       부서번호, 사원번호, 사원명, 기본급여를 나타내세요...
    */
   
    select department_id, salary
    from employees
    where (department_id, salary) NOT IN ((30,2500),(30,11000),(50,2100),(50,8200),(80,6100),(80,14000));
    
    select department_id as 부서번호, employee_id as 사원번호, first_name||' '||last_name as 사원명,
           salary as 기본급여
    from employees
    where (nvl(department_id,-9999), salary) NOT IN (  select nvl(department_id,-9999), min(salary)
                                                        from employees
                                                        group by department_id
                                                        UNION
                                                        select nvl(department_id,-9999), max(salary)
                                                        from employees
                                                        group by department_id  
                                                    )
    order by 1,4;
    
    
    
    
   /*
      tbl_authorbook 테이블에서 공저(도서명은 동일하지만 작가명이 다른 도서)로 지어진
      도서정보를 나타내세요 (Sub Query 을 사용해서 풀이)
   */
   ----------------------------------------
     도서명             작가명      로얄티
   ----------------------------------------
     그리스로마신화       김다님      1200
     그리스로마신화       김성경      1300
     그리스로마신화       김성빈      1700
     로빈슨크루소         한서연       800
     로빈슨크루소         조연재       500
   ----------------------------------------
    
    select *
    from tbl_authorbook;
    
    select bookname
    from tbl_authorbook
    group by bookname
    having count(*)>1;
    
    select bookname as 도서명, authorname as 작가명, loyalty as 로얄티
    from tbl_authorbook
    where bookname in ( select bookname
                        from tbl_authorbook
                        group by bookname
                        having count(*)>1 );
    
    
    
    
      
  
  
  
  
  
   ------- ==== *** 상관서브쿼리(== 서브상관쿼리) *** ==== -------- 
   /*
      상관서브쿼리 이라함은 Main Query(== 외부쿼리)에서 사용된 테이블(뷰)에 존재하는 컬럼이
      Sub Query(== 내부쿼리)의 조건절(where절, having절)에 사용되어질때를 
      상관서브쿼리(== 서브상관쿼리)라고 부른다.
   */
   
   
   -- employees 테이블에서 기본급여에 대해 전체 등수 및 부서 내 등수를 구하세요..
   -- 첫번째 방법은 rank() 함수를 사용하여 구해본다.
   -- (오라클에서만)
   select department_id as 부서번호
        , employee_id as 사원번호
        , salary as 기본급여
        , rank() over(order by salary desc) as 전체등수
        , rank() over(partition by department_id order by salary desc) as 부서내등수
   from employees
   order by 1,3;
   
   
   -- employees 테이블에서 기본급여에 대해 전체 등수 및 부서 내 등수를 구하세요..
   -- 두번째 방법은 count(*)를 이용하여 상관서브쿼리를 사용하여 구해본다.
   -- (호환성 적용)
   select salary
   from employees;
   
   select salary
   from employees;  -- 24000
   
   select count(salary) +1
   from employees
   where salary > 10500;    -- 14
   
   
   select count(salary) +1
   from employees
   where salary > 24000;    -- 1
   
   
   select department_id as 부서번호
        , employee_id as 사원번호
        , salary as 기본급여
        , (select count(salary)+1
           from employees 
           where salary > E.salary) as 전체등수
           --    컬럼      데이터값(기본급여)
        , (select count(salary)+1
           from employees
           where department_id = E.department_id and
                 salary > E.salary) as 부서내등수
   from employees E
   order by 1, 3 desc;
   
   
   ---- !!! 꼭 알아두시길 바랍니다. !!! ----
   ---- === *** 상관서브쿼리(서브상관쿼리)를 사용한 UPDATE 처리하기 *** === ----
   ---- 회사에 가셔서 delete 또는 update를 할 때 먼저 반드시 해당 테이블을 백업해두시고 하시길 바랍니다.
   ---- 실수하면 복구하기 위한 것이다.
   
   --- *** 서브쿼리를 사용하여 테이블을 생성하는 것 *** ---
   create table tbl_employees_backup
   as
   select *
   from employees;
   -- Table TBL_EMPLOYEES_BACKUP이(가) 생성되었습니다.
   
   select *
   from tbl_employees_backup;
   
   update employees set first_name = '순신', last_name = '이';
   -- 107개 행 이(가) 업데이트되었습니다.
   
   commit;  -- 커밋 완료.
   
   select *
   from employees;
   
   
   -- tbl_employees_backup 테이블의 데이터를 읽어다가 employees 테이블의 데이터를 수정한다.
   -- 단, 전제조건은 employees 테이블의 행 중에 고유한 값을 가지는 컬럼이 존재해야 한다.
   -- employees 테이블에는 고유한 값을 가지는 컬럼은 employee_id 컬럼이다.
   
   update employees E set first_name = (select first_name
                                        from tbl_employees_backup
                                        where employee_id = E.employee_id)
                         , last_name = (select last_name
                                        from tbl_employees_backup
                                        where employee_id = E.employee_id);
   -- 107개 행 이(가) 업데이트되었습니다.
   -- 서브쿼리 조건절에 메인쿼리 컬럼을 이용
   
   /*
        employees 테이블의
        107개 행을 수정(변경)작업에 들어간다.
        
                EMPLOYEES 테이블                                        TBL_EMPLOYEES_BACKUP 테이블
               --------------------------------------------           --------------------------------------------
                employee_id     first_name      last_name               employee_id     first_name      last_name
               --------------------------------------------           --------------------------------------------
        1번째     162              순신             이                       162             Clara	     Vishney
        2번째     168              순신             이                       168             Lisa           Ozer
        3번째     173              순신             이                       173            Sundita	      Kumar
        ....     ....             ....             ..                      ....           ........        .....
        107번째   206              순신             이                       206            William	      Gietz
   */
   
   
   select *
   from employees;
   
   rollback;
  
   commit;  -- 커밋 완료.
  
  -- 내 PC 가 백업용이다?!!!!!!!!!!!!!!!
  
  update employees set first_name = '일표', last_name = '양'
  where employee_id = 100;
  -- 1 행 이(가) 업데이트되었습니다.
  commit;   -- 커밋 완료.
  
  select *
  from employees
  order by employee_id;
  -- 100	일표	양	SKING	515.123.4567	03/06/17	AD_PRES	24000			90	6010151234567
  -- 원격지에 있는 나한테 들어온다.
  
  --- **** 데이터베이스 링크 만들기 **** ---
  1. 탐색기에서 C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN 에 간다.
  2. tnsnames.ora 파일을 메모장으로 연다.
  3. TEACHER =
      (DESCRIPTION =
        (ADDRESS = (PROTOCOL = TCP)(HOST = 211.238.142.72)(PORT = 1521))
        (CONNECT_DATA =
          (SERVER = DEDICATED)
          (SERVICE_NAME = XE)
        )
      ) 
      을 추가한다.
      HOST = 211.238.142.72 이 연결하고자 하는 원격지 오라클서버의 IP 주소이다.
      그런데 전제조건은 원격지 오라클서버(HOST = 211.238.142.72)의 방화벽에서 포트번호 1521을 허용으로 만들어주어야 한다.
      TEACHER를 'Net Service Name 네트서비스네임(넷서비스명)' 이라고 부른다.
      
  4. 명령프롬포트를 열어서 원격지 오라클서버(HOST = 211.238.142.72)에 연결이 가능한지 테스트를 한다.
     C:\Users\ilpyo>tnsping TEACHER 5
     Used TNSNAMES adapter to resolve the alias
     Attempting to contact (DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = 211.238.142.72)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = XE)))
     OK (40 msec)
     OK (0 msec)
     OK (30 msec)
     OK (10 msec)
     OK (20 msec)
     
   5. 데이터베이스 링크 만들기
   create database link teacherServer
   connect to hr identified by cclass   -- 이 때 HR 과 암호 cclass 는 연결하고자 하는 원격오라클서버(211.238.142.72)의 계정명과 암호이다.
   using 'TEACHER';     -- TEACHER 는 Net Service Name 네트서비스네임(넷서비스명) 이다.
   -- Database link TEACHERSERVER이(가) 생성되었습니다.
  
   drop database link teacherServer;
   -- Database link TEACHERSERVER이(가) 삭제되었습니다.
   
   select *
   from employees   -- 로컬서버
   order by employee_id;
    
   select *
   from employees@teacherServer   -- 원격지서버의 테이블 @다음에 teacherServer는 데이터베이스링크이름이다.
   order by employee_id;
   -- 100	영학	서	SKING	515.123.4567	03/06/17	AD_PRES	24000			90	6010151234567
   
    
   --- *** 생성되어진 데이터베이스링크를 조회해봅니다. *** ---
   select *
   from dict
   where lower(table_name) like '%links%';

   select *
   from user_db_links;
   /*
         ---------------------------------------------------------------
         DB_LINK            USERNAME     PASSWORD    HOST      CREATED
         ---------------------------------------------------------------
         TEACHERSERVER	    HR		                 TEACHER   21/02/19
                                                     넷서비스명
   */
   
   desc employees;
   
   update employees set commission_pct = null, jubun = null;
   -- 107개 행 이(가) 업데이트되었습니다.
   
   commit;  -- 커밋 완료.
   
   select *
   from employees
   order by employee_id;
   
   select *
   from employees@TEACHERSERVER
   order by employee_id;
   
   
   -- 백업테이블이 원격지에 있는 경우
   update employees E set commission_pct = (select commission_pct
                                            from employees@TEACHERSERVER
                                            where employee_id = E.employee_id)
                         , jubun = (select jubun
                                    from employees@TEACHERSERVER
                                    where employee_id = E.employee_id);
   -- 107개 행 이(가) 업데이트되었습니다.
   
   commit;    -- 커밋 완료.
   
   
   
   ---- *** Sub Query 절을 사용하여 테이블을 생성할 수 있다. *** ----
   --- employees 테이블에서 부서번호 10번과 30번에 근무하는 직원들만 뽑아서 그 직원들만 보이도록
   --  tbl_employees_sub1 라는 테이블을 생성하세요...
   create table tbl_employees_sub1
   as
   select *
   from employees
   where department_id in (10,30)
   order by department_id, employee_id;
   -- Table TBL_EMPLOYEES_SUB1이(가) 생성되었습니다.
   
   
   
   select *
   from tbl_employees_sub1
   order by department_id, employee_id;

   
   -- employees 테이블에서 데이터 없이 테이블구조만 동일하도록
   --  tbl_employees_sub2 라는 테이블을 생성하세요...
   create table tbl_employees_sub2
   as
   select *
   from employees
   where 1=2;

   -- 또는
   create table tbl_employees_sub2
   as
   select *
   from employees;
   -- Table TBL_EMPLOYEES_SUB2이(가) 생성되었습니다.
   
   delete from tbl_employees_sub2; 
   -- 107개 행 이(가) 삭제되었습니다.
   
   select *
   from tbl_employees_sub2;
   
   desc tbl_employees_sub2;
   
   select count(*)
   from tbl_employees_sub2;
   -- 0   
   
   
   --- *** Sub Query 절을 사용하여 데이터를 입력할 수 있다. *** ---
   --- tbl_employees_sub2 테이블 속에 employees 테이블에 있는 여자인 사원들만 모두 입력하겠다.
   insert into tbl_employees_sub2
   select *
   from employees
   where substr(jubun,7,1) in ('2','4');
   -- 51개 행 이(가) 삽입되었습니다.
   
   select count(*)
   from tbl_employees_sub2;
   -- 51

   
   --- *** Sub Query 절을 사용하여 데이터를 수정할 수 있다. *** ---
   --- tbl_employees_sub2 테이블에서 부서번호 30번과 50번의 근무하는 사원들에 대해 
   --- salary 를 employees 테이블의 평균 salary와 같도록 변경하시고
   --- commission-pct 는 employees 테이블의 최대 commission_pct와 같도록 변경하세요.
   update tbl_employees_sub2 set salary = (select trunc(avg(salary)) from employees),           -- 6461
                                 commission_pct = (select max(commission_pct) from employees)   -- 0.4
   where department_id in (30,50);
   -- 24개 행 이(가) 업데이트되었습니다.
   
   commit;
   
   select *
   from tbl_employees_sub2
   order by department_id;
   
   select count(*)
   from tbl_employees_sub2;      -- 51
   
   
   --- *** Sub Query 절을 사용하여 데이터를 삭제할 수 있다. *** ---
   --- tbl_employees_sub2 에서 salary 가 employees 테이블의 50번에 근무하는 사원 중 최대 salary 보다 적은 사원들만 삭제하세요.
   delete from tbl_employees_sub2
   where salary < (select max(salary)   --8200
                   from employees
                   where department_id = 50);
   -- 35개 행 이(가) 삭제되었습니다.
   
   commit;
   
   select *
   from tbl_employees_sub2;      
   
   select count(*)
   from tbl_employees_sub2;      -- 16
   
   
   
   
   
   ------ *** Pseudo(의사, 유사, 모조) Column *** -------
   --- 의사컬럼은 rowid 와 rownum 이 있다.
   --- 1. rowid
   --     rowid 는 오라클이 내부적으로 사용하기 위해 만든 행에 대한 id 값으로서 
   --     오라클 전제내에서 고유한 값을 가진다.
  
   create table tbl_heowon
  (userid    varchar2(10) 
  ,name      varchar2(20)
  ,address   varchar2(100)
  );
  -- Table TBL_HEOWON이(가) 생성되었습니다.

   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   
   
   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   
   
   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   
   commit;
   
   select *
   from tbl_heowon;
   
   delete from tbl_heowon;
   
   rollback;
   
   select ROWID userid, name, address
   from tbl_heowon;
   
   
   -- ROWID 구조?!!!!!!!!!!!!!!!!!
   select ROWID userid, name, address
   from tbl_heowon
   where rowid in ('AAAFCLAAEAAAAHGAAA', 'AAAFCLAAEAAAAHGAAB', 'AAAFCLAAEAAAAHGAAC');
   -- 문자열이므로 ' ' 해주어야 한다.
   
   /*
        -----------------------------------
        USERID              NAME    ADDRESS
        -----------------------------------
        AAAFCLAAEAAAAHGAAA	이순신	서울
        AAAFCLAAEAAAAHGAAB	엄정화	인천
        AAAFCLAAEAAAAHGAAC	강감찬	수원
   */
   
   
   delete from tbl_heowon
   where ROWID > 'AAAFCLAAEAAAAHGAAC';
   -- 6개 행 이(가) 삭제되었습니다.
   
   commit;
   
   select *
   from tbl_heowon;
   
   delete from tbl_heowon;
   
   commit;


   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   insert into tbl_heowon(userid, name, address) values('kangkc','강감찬','수원');
   insert into tbl_heowon(userid, name, address) values('leess','이순신','서울');
   insert into tbl_heowon(userid, name, address) values('eomjh','엄정화','인천');
   
   commit;
   
   select ROWID userid, name, address
   from tbl_heowon;

   delete from tbl_heowon
   where ROWID NOT IN ('AAAFCLAAEAAAAHGAAA','AAAFCLAAEAAAAHGAAE','AAAFCLAAEAAAAHGAAF');
   -- 6개 행 이(가) 삭제되었습니다.

   commit;
   
   select *
   from tbl_heowon;

   
   --- 2. rownum (!!!!!!!!!! 게시판에서 아주 많이 사용됩니다. !!!!!!!!!)
   select boardno as 글번호
        , subject as 글제목
        , userid as 글쓴이
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as 작성일자
   from tbl_board;
   
   ----------------------------------------------------------------------------------------
   번호   글번호     글제목                                        글쓴이   작성일자
   ----------------------------------------------------------------------------------------
    1      6	   좋은 하루 되시고 건강하시고 부자되시고 늘 행복하세요	leess	2021-02-10 12:01:40 
    2      5	   오늘도 좋은하루되세요	                        hongkd	2021-02-10 12:01:33
    3      4	   기쁘고 감사함이 넘치는 좋은하루되세요 	            emojh	2021-02-10 12:01:27
    4      3	   건강하세요	                                    leess	2021-02-10 12:01:21
    5      2	   반갑습니다	                                    eomjh	2021-02-10 12:01:15
    6      1	   안녕하세요	                                    leess	2021-02-10 12:01:09
   
   
   select ROWNUM    -- ROWNUM(행번호)은 기본적으로 insert 되어진 순서대로 나온다.
        , boardno as 글번호
        , subject as 글제목
        , userid as 글쓴이
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as 작성일자
   from tbl_board;
   
   select ROWNUM AS RNO, boardno, subject, userid, registerday
   from
   (
   select boardno 
        , subject 
        , userid 
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
   from tbl_board
   order by boardno desc
   )V;
   
   --- 또는 ROWNUM 을 사용하지 않고 ROW_NUMBER() 함수를 사용해서 나타낼 수 있다.
   select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
        , boardno 
        , subject 
        , userid 
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
   from tbl_board;
   
   
   insert into tbl_board(boardno, subject, content, userid, registerday, readcount)
   values(7, '오늘은 즐거운 금요일','기분좋은 금요일 보내세요~~~~','leess',sysdate,0);
   
   commit;
   
   
   /*
        한 페이지당 2개씩 보여주고자 한다.
        
        1페이지 ==> rownum : 1 ~ 2   /  boardno : 7 ~ 6
        2페이지 ==> rownum : 3 ~ 4   /  boardno : 5 ~ 4
        3페이지 ==> rownum : 5 ~ 6   /  boardno : 2 ~ 3
        4페이지 ==> rownum : 7 ~ 8   /  boardno : 1
   */
   
   ----------------------------------------------------------------------------------------
   번호   글번호     글제목                                        글쓴이    작성일자
   ----------------------------------------------------------------------------------------
    1      7       오늘은 즐거운 금요일                             leess   2021-02-19 14:21:06
    2      6	   좋은 하루 되시고 건강하시고 부자되시고 늘 행복하세요	leess	2021-02-10 12:01:40 
    3      5	   오늘도 좋은하루되세요	                        hongkd	2021-02-10 12:01:33
    4      4	   기쁘고 감사함이 넘치는 좋은하루되세요 	            emojh	2021-02-10 12:01:27
    5      3	   건강하세요	                                    leess	2021-02-10 12:01:21
    6      2	   반갑습니다	                                    eomjh	2021-02-10 12:01:15
    7      1	   안녕하세요	                                    leess	2021-02-10 12:01:09
   ----------------------------------------------------------------------------------------    
        1   2   3   4   ==> 페이지바 


-- 1페이지 ==> rownum : 1 ~ 2   /  boardno : 7 ~ 6
   select ROWNUM AS RNO, boardno, subject, userid, registerday
   from
   (
   select boardno 
        , subject 
        , userid 
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
   from tbl_board
   order by boardno desc
   )V
   where rownum between 5 and 6;    -- ROWNUM 은 where 절에 바로 쓸 수가 없다!!!
                                    -- 그래서 ROWNUM 을 가지는 컬럼의 별칭을 만든 후 Inline View 를 사용해야만 된다 !!!!!!
                                    
   -- [올바른 SQL 문]
   select boardno, subject, userid, registerday
   from
   (
       select ROWNUM AS RNO, boardno, subject, userid, registerday
       from
       (
       select boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
       order by boardno desc
       )V
   )T
   where RNO between 1 and 2;
   
   
-- 2페이지 ==> rownum : 3 ~ 4   /  boardno : 5 ~ 4
   select boardno, subject, userid, registerday
   from
   (
       select ROWNUM AS RNO, boardno, subject, userid, registerday
       from
       (
       select boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
       order by boardno desc
       )V
   )T
   where RNO between 3 and 4;


-- 3페이지 ==> rownum : 5 ~ 6   /  boardno : 2 ~ 3
   select boardno, subject, userid, registerday
   from
   (
       select ROWNUM AS RNO, boardno, subject, userid, registerday
       from
       (
       select boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
       order by boardno desc
       )V
   )T
   where RNO between 5 and 6;
   

-- 4페이지 ==> rownum : 7 ~ 8   /  boardno : 1
   select boardno, subject, userid, registerday
   from
   (
       select ROWNUM AS RNO, boardno, subject, userid, registerday
       from
       (
       select boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
       order by boardno desc
       )V
   )T
   where RNO between 7 and 8;
   
        
   --- 또는 ROWNUM 을 사용하지 않고 ROW_NUMBER() 함수를 사용하여 페이징 처리를 해봅니다. ---

   -- 1페이지 ==> ROW_NUMBER() : 1 ~ 2   /  boardno : 7 ~ 6
   select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
        , boardno 
        , subject 
        , userid 
        , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
   from tbl_board
   where row_number() over(order by boardno desc) between 1 and 2;
   -- 오류!! row_number()over(order by boardno desc) 는 where 절에 바로 쓸 수가 없다!!!
   -- 그러므로 이것 또한 inline view 를 사용해야 한다.
   
   select boardno, subject, userid, registerday
   from
   (
       select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
            , boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
   )V
   where RNO between 1 and 2;   -- 1페이지
        
        
   -- 2페이지 ==> ROW_NUMBER() : 3 ~ 4   /  boardno : 5 ~ 4
   select boardno, subject, userid, registerday
   from
   (
       select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
            , boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
   )V
   where RNO between 3 and 4;   -- 2페이지
   
   
   -- 3페이지 ==> ROW_NUMBER() : 5 ~ 6   /  boardno : 3 ~ 2
   select boardno, subject, userid, registerday
   from
   (
       select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
            , boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
   )V
   where RNO between 5 and 6;   -- 3페이지


   -- 4페이지 ==> ROW_NUMBER() : 7 ~ 8   /  boardno : 1 
   select boardno, subject, userid, registerday
   from
   (
       select ROW_NUMBER() OVER(ORDER BY boardno desc) as RNO
            , boardno 
            , subject 
            , userid 
            , to_char(registerday,'yyyy-mm-dd hh24:mi:ss') as registerday
       from tbl_board
   )V
   where RNO between 7 and 8;   -- 4페이지     
        
   
      
   -------- **** 데이터 조작어(DML == Data Manuplation Language) **** ---------
   --- DML 문은 기본적으로 수동 commit 이다.
   --- 즉, DML 문을 수행한 다음에는 바로 디스크(파일)에 적용되지 않고 commit 해야만 적용된다.
   --- 그래서 DML 문을 수행한 다음에 디스크(파일)에 적용치 않고자 한다라면 rollback 하면 된다.
        
   1. insert --> 데이터 입력
   2. update --> 데이터 수정
   3. delete --> 데이터 삭제
   4. merge  --> 데이터 병합 (주로 회사 규모가 큰 경우에 사용됨)
        
   insert 는 문법이
   insert into 테이블명(컬럼명1,컬럼명2,...) values(값1,값2,...);
   
   ※ Unconditional insert all (==> 조건이 없는 insert)
    [문법] insert all 
           into 테이블명1(컬럼명1, 컬럼명2, ....)
           values(값1, 값2, .....)
           into 테이블명2(컬럼명3, 컬럼명4, ....)
           values(값3, 값4, .....)
           SUB Query문;    
   
   create table tbl_emp1
   (empno            number(6)
   ,ename            varchar2(50)
   ,monthsal         number(7)
   ,gender           varchar2(6)
   ,manager_id       number(6)
   ,department_id    number(4)
   ,department_name  varchar2(30)
   );
   
   drop table tbl_emp1 purge;
   
   create table tbl_emp1_backup
   (empno            number(6)
   ,ename            varchar2(50)
   ,monthsal         number(7)
   ,gender           varchar2(6)
   ,manager_id       number(6)
   ,department_id    number(4)
   ,department_name  varchar2(30)
   );
   
   drop table tbl_emp1_backup purge;
   
  
   insert all 
   into tbl_emp1(empno, ename, monthsal, gender, manager_id, department_id, department_name)
   values(employee_id, ename, month_sal+9, gender||'자', manager_id, department_id, department_name)    -- 넣어줄 컬럼명을 넣어준다. 수정가능!
   into tbl_emp1_backup(empno, ename, monthsal, gender, manager_id, department_id, department_name)
   values(employee_id, ename, month_sal+8, gender||'자', manager_id, department_id, department_name)     
   
   select employee_id
        , first_name || ' ' || last_name AS ename 
        , nvl(salary + (salary * commission_pct), salary) AS month_sal
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS gender
        , E.manager_id
        , E.department_id
        , department_name
   from employees E left join departments D 
   on E.department_id = D.department_id
   order by E.department_id asc, employee_id asc; 
   -- 214개 행 이(가) 삽입되었습니다.
   -- 107+107 => 214     
   
   select *
   from tbl_emp1;  
   
   select *
   from tbl_emp1_backup; 
   
   rollback;
   
   commit;
   
   
   
   
   ※ Conditional insert all (==> 조건이 있는 insert)
   조건(where절)에 일치하는 행들만 특정 테이블로 찾아가서 insert 하도록 하는 것이다.
   
   create table tbl_emp_dept30
   (empno            number(6)
   ,ename            varchar2(50)
   ,monthsal         number(7)
   ,gender           varchar2(4)
   ,manager_id       number(6)
   ,department_id    number(4)
   ,department_name  varchar2(30)
   );

   create table tbl_emp_dept50
   (empno            number(6)
   ,ename            varchar2(50)
   ,monthsal         number(7)
   ,gender           varchar2(4)
   ,manager_id       number(6)
   ,department_id    number(4)
   ,department_name  varchar2(30)
   );

   create table tbl_emp_dept80
   (empno            number(6)
   ,ename            varchar2(50)
   ,monthsal         number(7)
   ,gender           varchar2(4)
   ,manager_id       number(6)
   ,department_id    number(4)
   ,department_name  varchar2(30)
   );
   
   
   insert all 
   when department_id = 30 then
   into tbl_emp_dept30(empno, ename, monthsal, gender, manager_id, department_id, department_name)
   values(employee_id, ename, msal, gender, manager_id, department_id, department_name)
   when department_id = 50 then
   into tbl_emp_dept50(empno, ename, monthsal, gender, manager_id, department_id, department_name)
   values(employee_id, ename, msal, gender, manager_id, department_id, department_name)
   when department_id = 80 then
   into tbl_emp_dept80(empno, ename, monthsal, gender, manager_id, department_id, department_name)
   values(employee_id, ename, msal, gender, manager_id, department_id, department_name)
   select employee_id
        , first_name || ' ' || last_name AS ename 
        , nvl(salary + (salary * commission_pct), salary) AS msal
        , case when substr(jubun,7,1) in('1','3') then '남' else '여' end AS gender
        , E.manager_id
        , E.department_id
        , department_name
   from employees E left join departments D 
   on E.department_id = D.department_id
   where E.department_id in (30,50,80)
   order by E.department_id, employee_id;
   
   commit;
   
   select *
   from tbl_emp_dept30;
   
   select *
   from tbl_emp_dept50;
   
   select *
   from tbl_emp_dept80;