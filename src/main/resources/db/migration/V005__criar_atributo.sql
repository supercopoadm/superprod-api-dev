create table atributo (
id integer not null auto_increment,
nome varchar(255),
status bit, tenant_id integer,
primary key (id)
)engine=InnoDB default charset=utf8MB4;



ALTER TABLE log_sistema ADD COLUMN atributo_id INT NULL DEFAULT NULL AFTER funcionario_id;

