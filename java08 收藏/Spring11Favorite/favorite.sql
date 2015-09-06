-- 以system登录
create user fav identified by bdqn;
grant dba to fav;

-- 以fav登录
create table FAVORITE
(
  F_ID    NUMBER(19) not null,
  F_LABEL VARCHAR2(200 CHAR) not null,
  F_URL   VARCHAR2(200 CHAR) not null,
  F_TAGS  VARCHAR2(200 CHAR),
  F_DESC  VARCHAR2(500 CHAR)
);

alter table FAVORITE
  add primary key (F_ID);

create table TAG
(
  T_ID    NUMBER(19) not null,
  T_NAME  VARCHAR2(100 CHAR) not null,
  T_COUNT NUMBER(19) not null
);

alter table TAG
  add primary key (T_ID);
 
-- 建了默认的序列
create sequence hibernate_sequence;

insert into FAVORITE (F_ID, F_LABEL, F_URL, F_TAGS, F_DESC)
values (hibernate_sequence.nextval, 'Spring', 'http://www.spring.org', 'spring', 'Spring官网');
commit;

insert into TAG (T_ID, T_NAME, T_COUNT)
values (hibernate_sequence.nextval, 'spring', 1);
commit;
