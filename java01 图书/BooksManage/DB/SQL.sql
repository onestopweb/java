CREATE USER book IDENTIFIED BY accp;

GRANT CONNECT,RESOURCE TO book;

CREATE TABLE  BookManage(
       b_Id number(10) PRIMARY KEY,
       b_name VARCHAR2(40) NOT NULL,
       b_author VARCHAR2(40) NOT NULL,
       b_time date NOT NULL,
       b_type varchar2(4) not null
);

select * from BookManage for update;

-- Create sequence 
create sequence SEQ_BOOKMANAGE
minvalue 1
maxvalue 9999999999999999999999999999
start with 4
increment by 1
cache 10;

insert into BookManage (B_ID, B_NAME, B_AUTHOR, B_TIME, B_TYPE)
values (SEQ_BOOKMANAGE.Nextval, 'java 基础', 'chaoyi', to_date('15-02-2014', 'dd-mm-yyyy'), '1');

insert into BookManage (B_ID, B_NAME, B_AUTHOR, B_TIME, B_TYPE)
values (SEQ_BOOKMANAGE.Nextval, 'java 核心', 'chaoyv', to_date('16-02-2014', 'dd-mm-yyyy'), '2');

insert into BookManage (B_ID, B_NAME, B_AUTHOR, B_TIME, B_TYPE)
values (SEQ_BOOKMANAGE.Nextval, 'java 精通', 'chaoyi77', to_date('14-02-2014', 'dd-mm-yyyy'), '3');

--查询图书对象
select b_id, b_name, b_author, to_char(b_time,'yyyy-mm-dd'), b_type from bookmanage where b_id=?
--添加图书
insert into BookManage (B_ID, B_NAME, B_AUTHOR, B_TIME, B_TYPE)
values (SEQ_BOOKMANAGE.Nextval,?,?, to_date(?, 'yyyy-mm-dd'), ?);
--删除图书
delete bookmanage where b_id = ?
--更新图书
update bookmanage
   set b_name = ?,
       b_author = ?,
       b_time =to_date(?,'yyyy-mm-dd'),
       b_type =?
 where b_id = ?
