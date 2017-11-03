
use test;

create table account (id int primary key auto_increment not null, account_info_id int, money int);

create index account_id_index on account (account_info_id);

create table account_info (id int primary key auto_increment, account_id int, aname varchar(50), password varchar(50), bank_id int, status int);

create table bank_info (id int primary key auto_increment, bank_name varchar(50), location varchar(50));

create table log (id int primary key auto_increment, liushui varchar(50), in_id int, out_id int, money int, time varchar(50), location varchar(50));

insert into account_info (1, 1111, 'zhangshan', '123', 999);

insert into account_info (2, 2222, 'lisi', '456', 999);

insert into account values(1, 1, 100);

insert into account values(2, 2, 200);

