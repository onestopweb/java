create table BOOK
(
  id      VARCHAR2(100 CHAR) not null,  --编号
  isbn    VARCHAR2(50 CHAR),    --书号
  title   VARCHAR2(1024 CHAR),    -- 标题
  price   FLOAT not null,    -- 价格  
  pubdate TIMESTAMP(6) not null,  -- 出版日期
  intro   VARCHAR2(2000 CHAR)    -- 简介
);

alter table BOOK add primary key (ID);

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '9-787302-274469', 'JavaServer Faces 2.0完全参考手册', 98.00, to_date('2012-1-5','yyyy-mm-dd'), '全面介绍JSF2.0，详细如何使用Ajax，以及按照JSF2.0的方式构建组件');

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '978-7-115-21542-0', 'jQuery基础教程（第2版）', 49.00, to_date('2009-11-2','yyyy-mm-dd'), '涵盖了jQuery1.3的全部新特性');

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '9-787111-251767', 'ExtJS Web应用程序开发指南', 59.00, to_date('2010-08-5','yyyy-mm-dd'), '通过大量的实例讲解技术');

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '9787111291954', 'Android应用开发揭秘', 69.00, to_date('2011-05-25','yyyy-mm-dd'), '如果你也在思考下面这些问题，也许本书就是你想要的');

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '5674302-274459', 'Java Swing程序设计', 55.34, to_date('2009-12-15','yyyy-mm-dd'), '从浅入深的介绍了Java的Swing开发，成为一个Java桌面应用程序的行家');

insert into book (id, isbn, title, price, pubdate, intro) values
(book_seq.nextval, '345345-232-131', 'Java编程思想', 99.80, to_date('2009-5-4','yyyy-mm-dd'), '一本全面介绍Java的书籍，适合任何层次的读者');

-- Create sequence 
create sequence BOOK_SEQ
minvalue 100
nomaxvalue
start with 100
increment by 1
cache 20;

commit;  

select * from book


select count(*) from book
