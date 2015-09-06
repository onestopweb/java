create user OnlineDB identified by 123456;
grant connect,resource to OnlineDB;

-- Oracle 删除用户
--drop user OnlineDB cascade;

--问题表
create table questions (
       id number(10) primary key not null,--问题 id
       title varchar2(100) not null,-- 问题名
       detailDesc varchar2(300) null,-- 问题描述
       ansewerCount number(10) not null,--回答次数
       lastModidfied date null--最后修改时间
);
--应答表
create table answers (
       id number(10) primary key not null,--答案 id
       ansContent varchar2(300) not null,--答案内容
       ansDate date null,--回答时间
       qid number(10) not null,--问题 id
       foreign key(qid) references questions(id)--约束
);

create sequence seq_questions increment by 1 start with 1 cache 10;
create sequence seq_answers  increment by 1 start with 1 cache 10;

insert into questions
  (id, title, detaildesc, ansewercount, lastmodidfied)
values
  (seq_questions.nextval, '这是问题1', '这是描述1', 1, to_date('1999-10-16','yyyy-mm-dd'));
insert into questions
  (id, title, detaildesc, ansewercount, lastmodidfied)
values
  (seq_questions.nextval, '这是问题2', '这是描述2', 1, to_date('1999-10-16','yyyy-mm-dd'));
insert into questions
  (id, title, detaildesc, ansewercount, lastmodidfied)
values
  (seq_questions.nextval, '这是问题3', '这是描述3', 1, to_date('1999-10-16','yyyy-mm-dd'));
insert into questions
  (id, title, detaildesc, ansewercount, lastmodidfied)
values
  (seq_questions.nextval, '这是问题4', '这是描述4', 1, to_date('1999-10-16','yyyy-mm-dd'));
insert into questions
  (id, title, detaildesc, ansewercount, lastmodidfied)
values
  (seq_questions.nextval, '这是问题5', '这是描述5', 1, to_date('1999-10-16','yyyy-mm-dd'));

insert into answers
  (id, anscontent, ansdate, qid)
values
  (seq_answers.nextval, '这是回答1', to_date('1999-10-16','yyyy-mm-dd'), 2);
insert into answers
  (id, anscontent, ansdate, qid)
values
  (seq_answers.nextval, '这是回答2', to_date('1999-10-16','yyyy-mm-dd'), 3);
insert into answers
  (id, anscontent, ansdate, qid)
values
  (seq_answers.nextval, '这是回答3', to_date('1999-10-16','yyyy-mm-dd'), 4);

select id, anscontent, ansdate, qid from answers;
select id, title, detaildesc, ansewercount, lastmodidfied from questions
