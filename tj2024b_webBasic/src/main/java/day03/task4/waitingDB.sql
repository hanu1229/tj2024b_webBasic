drop database if exists waitingdb;
create database waitingdb;
use waitingdb;

create table waiting_table(
	num int auto_increment,
    phone varchar(13),
    people int,
    constraint primary key(num)
);

select * from waiting_table;