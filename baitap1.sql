create database Student_manager;
use Student_manager;
create table Student(
id int primary key not null,
name varchar(30) not null
);
create table Teacher(
id int primary key not null,
name varchar(30) not null,
age int not null,
country varchar(100) not null
);