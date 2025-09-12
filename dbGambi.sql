create database pooGambi;
use pooGambi;

create table cliente(
idCliente int primary key auto_increment,
nome varchar(200) not null,
email varchar(200) not null,
idade int not null,
cpf varchar(14) not null
);

create table vendedor(
idVendedor int primary key auto_increment,
nome varchar(200) not null,
email varchar(200) not null,
idade int not null,
cpf varchar(14) not null
);

create table venda(
idVenda int primary key auto_increment,
dataVenda datetime not null,
valorTotal decimal(10, 2) not null,
FKidVendedor int,
FkidCliente int,
foreign key(FKidVendedor) references vendedor(idVendedor),
foreign key(FkidCliente) references cliente(idCliente)
);

create table categoria(
idCategoria int primary key auto_increment,
nome varchar(150) not null
);


create table produto(
idProduto int primary key auto_increment,
nome varchar(150) not null,
estoque int not null,
preco decimal(10, 2) not null,
FkidCategoria int,
foreign key(FkidCategoria) references categoria(idCategoria)
);

create table catalogo(
idCatalogo int primary key auto_increment,
nome varchar(200) not null,
dataValidade datetime 
);

create table itemVenda(
precoTotal decimal(10, 2) null,
precoUnitario decimal(10, 2) not null,
quantidadeProduto int not null,
FkidVenda int,
FkidProduto int,
foreign key(FkidVenda) references venda(idVenda),
foreign key(FkidProduto) references produto(idProduto)
);

create table itemCatalogo(
FkidProduto int,
FkidCatalogo int,
foreign key(FkidProduto) references produto(idProduto),
foreign key(fkidCatalogo) references catalogo(idCatalogo)
);