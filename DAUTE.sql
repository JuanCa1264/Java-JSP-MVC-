create database inventario2;

use inventario2;

create table proveedor 
(
codigoProveedor int primary key,
nombre varchar (50),
direccion varchar(50),
telefono varchar(50)

);

create table producto
(
codigoProducto int primary key,
nombre varchar(50),
categoria varchar(50),
precio double,
anioFabricacion int,
anioVencimiento int,
codigoProveedor int,
foreign key (codigoProveedor) references proveedor (codigoProveedor) on delete cascade on update cascade
);

create table usuarios
(
codigoUsuario int primary key not null,
username varchar(50),
clave varchar(50),
nivel int
);

insert into proveedor values (1,'Proveedor A', 'Santa Ana', '2545-2345');
insert into proveedor values (2,'Proveedor B', 'San Miguel', '2545-2945');
insert into proveedor values (3,'Proveedor C', 'Sonsonate', '2545-2045');

select * from proveedor;

insert into producto values (1,'Producto A', 'Ropa', 2.25, 2015, 2016, 3);
insert into producto values (2,'Producto B', 'Comida', 2.90, 2016, 2016, 2);
insert into producto values (3,'Producto C', 'Herramientas', 2.10, 2016, 2018, 1);

select * from producto;

insert into usuarios values (1,'Sonia', '123',1);
insert into usuarios values (2,'Juan', '12345',2);
insert into usuarios values (3,'Alirio', '12345678',3);

select * from usuarios;