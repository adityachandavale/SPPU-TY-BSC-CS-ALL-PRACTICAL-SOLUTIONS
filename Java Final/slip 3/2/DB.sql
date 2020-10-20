create table billmaster(
billno	int primary key,
custname varchar(20),
billdate date
);

create table billdetails(
itemname varchar(20),
qty int,
rate float,
billno int references billmaster(billno) on delete cascade,
primary key(billno,itemname)
);

insert into billmaster values(111,'abcd','2015-12-12');
insert into billmaster values(112,'mnop','2016-01-01');
insert into billmaster values(113,'qrst','2016-02-15');
insert into billmaster values(114,'uvwx','2016-03-05');

insert into billdetails values('pen',10,5,111);
insert into billdetails values('pencil',20,10,111);

insert into billdetails values('notebook',15,20,112);
insert into billdetails values('pencil',5,5,112);

insert into billdetails values('pen',2,20,113);

insert into billdetails values('pencil',2,5,114);
insert into billdetails values('pen',7,8,114);
insert into billdetails values('notebook',4,30,114);
