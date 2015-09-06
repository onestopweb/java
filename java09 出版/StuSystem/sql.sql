create user standDB identified by 123456;
grant connect,resource to standDB;

-- Oracle 删除用户
--drop user standDB cascade;

--标准信息表
create table standards (
       std_id number(10) primary key not null,--标准 id
       std_num varchar2(50) not null,--标准号
       zhname varchar2(40) not null,--中文名称
       std_version varchar2(10) not null,--版本
       keys varchar2(50) not null,--关键字/词
       release_date date null,--发布日期
       impl_date date null,--实施日期
       package_path varchar2(100) not null--//附件路径
);

create sequence seq_standards increment by 1 start with 1 cache 10;

insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (1, 'GB 2312-1511', 'Java 典型', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1511', 'Java 典型1', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1512', 'Java 典型2', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1541', 'Java 典型3', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1551', 'Java 典型4', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1561', 'Java 典型5', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1511', 'Java 典型6', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1511', 'Java 典型7', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1511', 'Java 典型8', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');
insert into standards
  (std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path)
values
  (seq_standards.nextval, 'GB 2312-1511', 'Java 典型9', '1999', 'Java',
   to_date('1991-10-16','yyyy-mm-dd'),  to_date('1999-10-16','yyyy-mm-dd'), 'xxx.jpg');

select std_id, std_num, zhname, std_version, keys, release_date, impl_date, package_path from standards

