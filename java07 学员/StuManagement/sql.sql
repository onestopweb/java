--创建用户及授权
CREATE USER stuDB IDENTIFIED BY 123456;
GRANT CONNECT,RESOURCE to stuDB;

--drop user stuDB cascade

--班级信息表
create table classes(
        id number(10) primary key not null,--班级编号
        cname varchar2(30) not null--班级名称
)

--学生信息表
create table student(
       id number(10) primary key not null,--学员编号
       sname varchar2(30) not null,--学员姓名
       birthday date not null,--生日
       gender varchar2(10) not null,--性别
       telephone varchar2(20) not null,--电话
       email varchar2(50) not null,--Email
       classid number(10) not null,--班级编号
       foreign key(classid) references classes(id)
)



--创建序列
CREATE SEQUENCE seq_student INCREMENT BY 1 START WITH 1 CACHE 10;
CREATE SEQUENCE seq_classes INCREMENT BY 1 START WITH 1 CACHE 10;

--插入班级信息表
insert into classes
  (id, cname)
values
  (seq_classes.nextval, 'Y2E315');
insert into classes
  (id, cname)
values
  (seq_classes.nextval, 'S2E234');
insert into classes
  (id, cname)
values
  (seq_classes.nextval, 'S1E271');
insert into classes
  (id, cname)
values
  (seq_classes.nextval, 'Y2E123');
insert into classes
  (id, cname)
values
  (seq_classes.nextval, 'Y2E695');
  
--插入学生信息表
insert into student
  (id, sname, birthday, gender, telephone, email, classid)
values
  (seq_student.nextval, '景临境', to_date('1991-10-18','yyyy-mm-dd'), '男', '15123456789', 'chaoyi@qq.com', 2);
insert into student
  (id, sname, birthday, gender, telephone, email, classid)
values
  (seq_student.nextval, '何开', to_date('1992-5-4','yyyy-mm-dd'), '男', '15123456789', 'chaoyi@qq.com', 3);
insert into student
  (id, sname, birthday, gender, telephone, email, classid)
values
  (seq_student.nextval, '赵柔', to_date('1989-5-4','yyyy-mm-dd'), '女', '15123456789', 'chaoyi@qq.com', 4);
insert into student
  (id, sname, birthday, gender, telephone, email, classid)
values
  (seq_student.nextval, '左阻', to_date('1989-5-4','yyyy-mm-dd'), '男', '15123456789', 'chaoyi@qq.com', 5);
insert into student
  (id, sname, birthday, gender, telephone, email, classid)
values
  (seq_student.nextval, '陆梦', to_date('1996-5-4','yyyy-mm-dd'), '女', '15123456789', 'chaoyi@qq.com', 2);


--查看
select id, cname from classes;
select id, sname, birthday, gender, telephone, email, classid from student

