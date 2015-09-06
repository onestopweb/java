--创建用户及授权
CREATE USER A_hr IDENTIFIED BY 123456;
GRANT CONNECT,RESOURCE to A_hr;

--会员信息表
CREATE TABLE MEMBERSINFO(
       MID NUMBER(10) PRIMARY KEY NOT NULL,
       MNAME VARCHAR2(30) NOT NULL,
       MGENDER VARCHAR2(2) NOT NULL,
       MAGE NUMBER(10) NOT NULL,
       MADDRESS VARCHAR2(100) NULL,
       MEMAIL VARCHAR2(50) NULL
)

--drop table MEMBERSINFO

--会员信息表序列
CREATE SEQUENCE seq_membersinfo INCREMENT BY 1 START WITH 1 CACHE 10;


--插入
insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '何开', '男', 18, '新凤凰直街1号', '963AA@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '景临境', '男', 15, '新凤凰直街2号', '1111@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '暴天明', '男', 18, '新凤凰直街3号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '车行径', '男', 19, '新凤凰直街4号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '赵柔', '女', 21, '新凤凰直街5号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '陆梦', '女', 18, '新凤凰直街6号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '赵血儿', '男', 19, '新凤凰直街7号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '墨学之', '男', 16, '新凤凰直街8号', '963@qq.com');

insert into membersinfo (MID, MNAME, MGENDER, MAGE, MADDRESS, MEMAIL)
values (seq_membersinfo.nextval, '吴者然', '男', 21, '新凤凰直街9号', '963@qq.com');


  
  
--查看
select mid, mname, mgender, mage, maddress, memail from membersinfo for update

--导出
exp A_hr/123456@localhost/oracle11  file=D:\A_hr.dmp tables=(MEMBERSINFO)  


