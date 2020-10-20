create table student(
stud_id int primary key,
name varchar(20),
class varchar(20)
);
create table competition(
c_no int primary key,
c_name varchar(20),
type varchar(20)
);
create table studentcompetition(
rank varchar(20),
year char(4),
c_no int references competition(c_no) on delete cascade,
stud_id int references student(stud_id) on delete cascade,
primary key(c_no,stud_id)
);
insert into student values(111,'abcd','fy');
insert into student values(222,'xyzw','sy');
insert into student values(333,'aaaa','ty');
insert into competition values(1,'cricket','icl');
insert into competition values(2,'football','ifl');
insert into competition values(3,'tenis','itl');
insert into studentcompetition values(1,2015,1,111);
insert into studentcompetition values(2,2015,2,111);
insert into studentcompetition values(3,2015,3,111);
insert into studentcompetition values(2,2015,1,222);
insert into studentcompetition values(1,2015,2,222);
insert into studentcompetition values(2,2015,3,222);
insert into studentcompetition values(3,2015,1,333);
insert into studentcompetition values(3,2015,2,333);
insert into studentcompetition values(1,2015,3,333);