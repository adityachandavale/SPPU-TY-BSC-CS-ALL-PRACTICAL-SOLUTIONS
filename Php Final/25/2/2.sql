create table movie(mno serial primary key, mname text, release_year int);
create table actor(ano serial primary key, aname text, mno int references movie(mno));

insert into movie(mname,release_year) values('Bajirao Mastani',2015),('Dilwale',2015),('Nata Smarat',2016);

insert into actor(aname, mno) values('Ranvir Singh',1),('Deepika Padukone',1),('Priyanka Chopra',1),('Shahrukh Khan',2),('Kajol',2),('Nana Patekar',3),('Vikaram Gokhale',3);
