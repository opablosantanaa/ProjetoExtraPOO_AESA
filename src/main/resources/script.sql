create database if not exists infos;
use infos;
create table paciente(
id int unique not null auto_increment,
nome varchar(50) not null,
telefone varchar(15),
cep varchar(12) not null,
descricao varchar(25) not null,
preco double not null,
dataservico varchar(12) not null,
primary key (id)
);
