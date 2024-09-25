create table maquina1 
(id integer not null auto_increment, atributo_id integer, quantidade integer, ordem integer, status varchar(255), tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

alter table maquina1 add constraint 
fk_atributomaquina1 foreign key (atributo_id) references atributo (id);

alter table maquina1 add constraint 
FK_maquina1Tenant foreign key (tenant_id) references tenant (id);