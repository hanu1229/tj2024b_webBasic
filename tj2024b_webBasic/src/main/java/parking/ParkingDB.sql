drop database if exists parkingservice;
create database parkingservice;
use parkingservice;

create table parking(
	pno int not null unique,
    constraint primary key( pno ),
    car varchar(8) not null unique,
    time datetime default now()
);

create table inout_log(
	lno int auto_increment,
    constraint primary key( lno ),
    car varchar(8) not null,
    state tinyint not null,
    time datetime default now(),
    price int default 0
);

insert into parking value( 1 , '12가1234' , '2025-01-23 07:00:00' );
insert into parking value( 4 , '12나4567' , '2025-01-23 05:00:00' );
insert into parking value( 7 , '12다5678' , '2025-01-23 15:00:00' );

insert into inout_log( car , state , time , price ) value( '12가1234' , 0 , '2025-01-23 05:00:00' , 0 );
insert into inout_log( car , state , time , price ) value( '12가1234' , 1 , '2025-01-23 05:10:00' , 1000 );
insert into inout_log( car , state , time , price ) value( '12가4567' , 0 , '2025-01-23 05:00:00' , 0 );
insert into inout_log( car , state , time , price ) value( '12가1234' , 0 , '2025-01-23 07:00:00' , 0 );
insert into inout_log( car , state , time , price ) value( '12다5678' , 0 , '2025-01-23 15:00:00' , 0 );


select * from parking; 
select * from inout_log;