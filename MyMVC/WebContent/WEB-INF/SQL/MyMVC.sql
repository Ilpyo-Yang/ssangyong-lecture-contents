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