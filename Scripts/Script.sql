create table diabetestype(
	id INT not null auto_increment,
	name VARCHAR(100),
	primary key(id)
);

select * from diabetestype

insert into diabetestype(name) VALUES("name1")