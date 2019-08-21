create database Trabalho02;
use Trabalho02;
create table marca(
	idMarca integer not null auto_increment,
    nome varchar(55),
    nrModelos varchar(55),
    anoLancamento Year(4),
    primary key (idMarca)
);
create table endereco(
	cep varchar(9),
	rua varchar(55),
    bairro varchar(55),
    cidade varchar(55),
    estado varchar(55),
    complemento varchar(55),
    primary key (cep)
);
create table proprietario(
	cpf varchar(11),
    nome varchar(55),
    rg varchar(10),
    dataDeNascimento date,
    cep varchar(9),
    primary key (cpf),
    constraint fk_endereco foreign key (cep) references endereco (cep)
);

create table carro(
	modelo varchar(55),
    cor varchar(55),
    ano year(4),
    idMarca integer,
    chassi varchar(55) not null,
    cpf varchar(11),
    velocidadeMaxima double,
    nrPorta integer,
    tetoSolar boolean,
    nrMarchas integer,
    cambioAutomatico  boolean,
    volumeCombustivel double,
    primary key (chassi),
    constraint fk_modelo foreign key (idMarca) references marca (idMarca),
    constraint fk_proprietario foreign key (cpf) references proprietario (cpf)
);

alter table proprietario modify cpf varchar(11) not null;
alter table marca modify anoLancamento integer;