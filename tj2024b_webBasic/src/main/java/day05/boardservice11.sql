drop database if exists boardservice11;
create database boardservice11;
use boardservice11;

create table board(
	bno int unsigned auto_increment,
    btitle varchar(100) not null,
    bcontent text not null,
    bwriter varchar(30) not null,
    bview int default 0,
    bpwd varchar(30) not null,
    bdate datetime default now(),
    constraint primary key(bno)
);

# [1] 게시물 등록
-- insert into board(btitle, bcontent, bwriter, bpwd)
-- values('제목1', '내용1', '작성자1', 'a123456');
-- insert into board(btitle, bcontent, bwriter, bpwd)
-- values('제목2', '내용2', '작성자1', 'a123456');
-- insert into board(btitle, bcontent, bwriter, bpwd)
-- values('제목3', '내용3', '작성자1', 'a123456');

# [2] 게시물 전체 조회
-- select * from board;

# [3] 게시물 개별 조회
-- select * from board where bno = 1;

# [4] 게시물 수정
-- update board set btitle = '수정제목1', bcontent = '수정내용1' where bno = 1;

# [5] 게시물 삭제
-- delete from board where bno = 1;

select * from board;