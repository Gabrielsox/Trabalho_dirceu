create database controle;
use controle;

create table cliente (
id int auto_increment,
nome varchar(50) not null,
email varchar(50) not null,
endereco varchar(200) not null,
telefone varchar(20) not null,
observacao varchar(100),
constraint pk_cliente primary key (id)
);
insert into cliente values(1,"Comercio ltds","comercio@gmail.com","rua a bairro x","35866084","investidor");

create table receber (
id int auto_increment,
id_cliente int not null,
descricao varchar(100) not null,
valor double not null,
dataVencimento date not null,
observacao varchar(100),
constraint pk_receber primary key (id),
FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

insert into receber values (1,1,"balas",50,now(),"cartão");

create table despesa (
id int auto_increment,
descricao varchar(25) not null,
dataDespesa date not null,
valor double not null,
observacao varchar(100),
constraint pk_categoria primary key (id)
);
insert into despesa values(1,"balas",now(),100,"chocolate");


create table fornecedor (
id int auto_increment,
nomeFornecedor varchar(50) not null,
cnpj char(15) not null,
email varchar(50) not null,
endereco varchar(200) not null,
telefone varchar(20) not null,
observacao varchar(100),
constraint pk_cliente primary key (id)
);
insert into fornecedor values(1,"mercearia","3055029555","mercearia@gmail.com","rua a","658596542","preço em conta");

create table categoria (
id int auto_increment,
nomeCategoria varchar(25) not null,
constraint pk_categoria primary key (id)
);

insert into categoria values(1,"Balas");

create table unidadeMedida (
id int auto_increment,
nomeUnidade varchar(25) not null,
constraint pk_categoria primary key (id)
);

insert into unidadeMedida values(1,"Unidade");

create table produto (
id int auto_increment,
nomeProduto varchar(50) not null,
fornecedor_idFornecedor int not null,
categoria_idCategoria int not null,
unidadeMedida_idUnidadeMedida int not null,
qtdAtual int not null,
qtdMinima int not null,
valorCusto double not null,
ValorVenda double not null,
observacao varchar(100),
constraint pk_cliente primary key (id),
FOREIGN KEY (fornecedor_idFornecedor) REFERENCES fornecedor(id),
FOREIGN KEY (categoria_idCategoria) REFERENCES categoria(id),
FOREIGN KEY (unidadeMedida_idUnidadeMedida) REFERENCES unidadeMedida(id)

);
insert into produto values(1,"Bala",1,1,1,200,50,0.05,0.10,"chocolate");



