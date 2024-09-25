ALTER TABLE maquina_pcp RENAME TO producao_pcp;

create table maquina_pcp 
(id integer not null auto_increment, produto_id integer, maquina integer, tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

alter table maquina_pcp add constraint 
fk_produtomaquina_pcp foreign key (produto_id) references produto (id);

alter table maquina_pcp add constraint 
FK_maquina_pcpTenant foreign key (tenant_id) references tenant (id);

