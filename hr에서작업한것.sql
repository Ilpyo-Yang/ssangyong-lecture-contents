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
     
    
    
    
    