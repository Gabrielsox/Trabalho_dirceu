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


create table categoria (
id int auto_increment,
nomeCategoria varchar(25) not null,
constraint pk_categoria primary key (id)
);

create table unidadeMedida (
id int auto_increment,
nomeUnidade varchar(25) not null,
constraint pk_categoria primary key (id)
);

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

insert into produto values(1,"capacete",3,6,3,20,10,200,220,"azul tamanho 48");
select * from produto;

SELECT id, nomeProduto, nomeFornecedor , nomeCategoria c,nomeUnidade, qtdAtual, qtdMinima, valorCusto, ValorVenda, observacao 
FROM produto p, fornecedor f, categoria c, unidadeMedida u
WHERE p.id = f.id 
and f.id = c.id
and c.id = u.id










create table despesa (
id int auto_increment,
descricao varchar(25) not null,
dataDespesa date not null,
valor double not null,
observacao varchar(100),
constraint pk_categoria primary key (id)
);




create table formaPagamento (
id int auto_increment,
nomeForma varchar(25) not null,
observacao varchar(100),
constraint pk_categoria primary key (id)
);



CREATE TABLE vendas (
id int auto_increment,
nomeCliente_idCliente int not null,
dataVenda date not null,
formaPagamento_idPagamento int not null,
valorTotal double(10,2) not null default 0.00,
constraint pk_vendas primary key (id),
FOREIGN KEY (nomeCliente_idCliente) REFERENCES cliente(id),
FOREIGN KEY (formaPagamento_idPagamento) REFERENCES formaPagamento(id)
);

CREATE TABLE itens (
id int auto_increment,
venda_idVendas int not null,
produto_idProduto int not null,
valor decimal(10,2) not null default 0.00,
quantidade int not null,
constraint pk_itens primary key (id),
FOREIGN KEY (venda_idVendas) REFERENCES vendas(id),
FOREIGN KEY (produto_idProduto) REFERENCES produto(id)

);

select id, nome, email, endereco, telefone,observacao from cliente
order by nome;


select * from cliente;