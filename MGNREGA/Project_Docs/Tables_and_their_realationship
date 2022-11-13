Table BDO:-

create table BDO(
id int primary key auto_increment,
username varchar(20),
password varchar(20)
)
=======================================

Table Employee:-

create table Employee(
id int primary key auto_increment,
name varchar(20) not null,
gender varchar(20) not null,
address varchar(20) not null,
phone varchar(20) not null,
no_duty_day int not null,
projAssigned int,
foreign key(projAssigned ) references Projects(projectNo),
gpossigned int, 
foreign key(gpossigned) references GPM(id),
wages int not null

)

========================================

Table GPM:-

create table GPM(
id int primary key auto_increment,
name varchar(20) not null,
address varchar(20) not null,
phone varchar(20) not null,
username varchar(20)not null unique,
password varchar(20)not null
)
========================================

========================================

Table Projects:-

create table Projects(
name varchar(20),
projectNo int primary key,
address varchar(20),
noOfEmployee int,
totalWages varchar(20)
)

========================================

Table allocate_project:-

create table allocate_project(
gid int,
pid int,
foreign key (gid) references gpm(id),
foreign key (pid) references projects(projectNo)
);