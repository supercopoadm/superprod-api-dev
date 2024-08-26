create table chamado 
(id integer not null auto_increment, primary key (id))
 engine=InnoDB default charset=utf8MB4;

create table classepermissao 
(id integer not null auto_increment, nome varchar(255), primary key (id))
engine=InnoDB default charset=utf8MB4;

create table codigo 
(id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id))
engine=InnoDB default charset=utf8MB4;

create table empresa
(id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), tenant_id integer, uf varchar(255), valor decimal(19,2), whats varchar(255), primary key (id))
engine=InnoDB default charset=utf8MB4;

create table log_sistema 
(id integer not null auto_increment, comando varchar(10000), datagravacao datetime, loginusuario varchar(255), status bit, chamado_id integer null, empresa_id integer null, maquina_id integer null, molde_id integer null, operador_id integer null, producao_id integer null, produto_id integer null, tenant_id integer, usuario_id integer null, primary key (id))
engine=InnoDB default charset=utf8MB4;

create table maquina 
(id integer not null auto_increment, nome varchar(255), numero integer, peso varchar(255), tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table molde 
(id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, produto_id integer, tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table molde_maquina 
(status bit, molde_id integer not null, maquina_id integer not null,  primary key (maquina_id, molde_id)) 
engine=InnoDB default charset=utf8MB4;

create table operador 
(id integer not null auto_increment, nome varchar(255), status bit, tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table permissao 
(id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table producao 
(id integer not null auto_increment, dataprevicao datetime(6), dataproducao datetime(6), horafinal integer, horainicio integer, obs varchar(255), perda integer, piguimento varchar(255), quantidade integer, tempomaquina integer, turno varchar(255), maquina_id integer, operador_id integer, produto_id integer, tenant_id integer,  status bit, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table produto 
(id integer not null auto_increment, nome varchar(255), sku varchar(255), tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table tenant 
(id integer not null auto_increment, descricao varchar(255), primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table usuario 
(id integer not null auto_increment, gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, tenantativo integer, tenant_id integer, primary key (id)) 
engine=InnoDB default charset=utf8MB4;

create table usuario_permissao 
(id_usuario integer not null, id_permissao integer not null) 
engine=InnoDB default charset=utf8MB4;

create table usuario_empresa 
(empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) 
engine=InnoDB default charset=utf8MB4;

alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj);

alter table log_sistema add constraint
FK_logsistemaChamado foreign key (chamado_id) references chamado (id);

alter table log_sistema add constraint 
FK_logsistemaEmpresa foreign key (empresa_id) references empresa (id);

alter table log_sistema add constraint 
FK_logsistemaMaquina foreign key (maquina_id) references maquina (id);

alter table log_sistema add constraint 
FK_logsistemaMolde foreign key (molde_id) references molde (id);

alter table log_sistema add constraint 
FK_logsistemaOperador foreign key (operador_id) references operador (id);

alter table log_sistema add constraint 
FK_logsistemaProducao foreign key (producao_id) references producao (id);

alter table log_sistema add constraint 
FK_logsistemaProduto foreign key (produto_id) references produto (id);

alter table log_sistema add constraint 
FK_logsistemaTenant foreign key (tenant_id) references tenant (id);

alter table log_sistema add constraint 
FK_logsistemaUsuario foreign key (usuario_id) references usuario (id);

alter table maquina add constraint 
FK_maquinaTenant foreign key (tenant_id) references tenant (id);

alter table molde add constraint 
FK_moldeProduto foreign key (produto_id) references produto (id);

alter table molde add constraint 
FK_moldeTenant foreign key (tenant_id) references tenant (id);

alter table molde_maquina add constraint 
FK_moldemaquinaMolde foreign key (molde_id) references molde (id);

alter table molde_maquina add constraint 
FK_moldemaquinaMaquina foreign key (maquina_id) references maquina (id);

alter table operador add constraint 
FK_operadorTenant foreign key (tenant_id) references tenant (id);

alter table permissao add constraint 
FK_permissaoClassepermissao foreign key (classepermissao_id) references classepermissao (id);

alter table producao add constraint 
FK_producaoMaquina foreign key (maquina_id) references maquina (id);

alter table producao add constraint 
FK_producaoOperador foreign key (operador_id) references operador (id);

alter table producao add constraint 
FK_producaoProduto foreign key (produto_id) references produto (id);

alter table producao add constraint 
FK_producaoTenant foreign key (tenant_id) references tenant (id);

alter table produto add constraint 
FK_produtoTenant foreign key (tenant_id) references tenant (id);

alter table usuario_permissao add constraint 
FK_usuariopermissaoPermissao foreign key (id_permissao) references permissao (id);

alter table usuario_permissao add constraint 
FK_usuariopermissaoUsuario foreign key (id_usuario) references usuario (id);

alter table usuario_empresa add constraint 
FK_usuarioempresaEmpresa foreign key (id_empresa) references empresa (id);

alter table usuario_empresa add constraint 
FK_usuarioempresaUsuario foreign key (id_usuario) references usuario (id);
