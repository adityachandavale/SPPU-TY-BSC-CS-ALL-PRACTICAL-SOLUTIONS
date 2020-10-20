create table hospital(hno serial primary key,hname text,city text);

create table doctor(dno serial primary key,dname text,addr text,city text, hno int references hospital(hno));

insert into hospital(hname,city) values('Lokmanya','Chinchwad'),('Sancheti','Pune'),('Aditya Birla','Pimpri');

insert into doctor(dname,addr,city,hno) values('AJIT KALE','Shop no:22 Nigdi','Pune',1), ('MAYANK SHARMA','Morwadi Chicnhwad 19','Pune',3),('ANGAD MEHTA','Shubhshree Akurdi','Pradhikaran',2),('RAJA RAM','Chakan Road','Pune',1),('ASHISH CHUGH','Opp Swimming Pool','Pradhikaran',1),('SURENDRA CHUGH','Pimpri Kalewadi Bridge','Pune',3);

