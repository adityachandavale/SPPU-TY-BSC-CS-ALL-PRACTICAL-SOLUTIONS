create table employee(
eno int primary key,
ename varchar(30),
address varchar(30),
phone varchar(40),
salary numeric(12,2)
);
create table department(
dno int primary key,
dname varchar(40),
location varchar(40)
);
create table emp_dept(
eno int references employee on delete cascade on update cascade,
dno int references department on delete cascade on update cascade
);
insert into employee values(1,'anant','pune','9090909090',50000);
insert into employee values(2,'kailash','mumbai','8080808080',40000);
insert into employee values(3,'rahul','thane','7070707070',30000);
insert into employee values(4,'suresh','nasik','6060606060',20000);
insert into employee values(5,'ramesh','kolhapur','5050505050',10000);
insert into department values(101,'physics','pune');
insert into department values(102,'chemistry','mumbai');
insert into department values(103,'maths','thane');
insert into department values(104,'cs','rajasthan');
insert into department values(105,'computer','kanyakumari');
insert into emp_dept values(1,101);
insert into emp_dept values(1,102);
insert into emp_dept values(2,102);
insert into emp_dept values(3,103);
insert into emp_dept values(4,103);
insert into emp_dept values(5,104);
insert into emp_dept values(5,105);