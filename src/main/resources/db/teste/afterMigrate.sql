set foreign_key_checks = 0;
set sql_safe_updates=0;
delete from molde;
delete from maquina;
delete from operador;
delete from produto;
delete from empresa;
delete from molde_maquina;
delete from producao;
delete from log_sistema;
delete from permissao;
delete from tenant;
delete from usuario; 
delete from usuario_permissao;
delete from usuario_empresa;


set foreign_key_checks = 1;
alter table producao auto_increment = 1000;
alter table classepermissao auto_increment = 1;
alter table classepermissao auto_increment = 1;
alter table molde auto_increment = 1;
alter table maquina auto_increment = 1;
alter table log_sistema auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;
alter table operador auto_increment = 1;
alter table produto auto_increment = 1;

INSERT INTO classepermissao  VALUES (1, 'Molde');
INSERT INTO classepermissao  VALUES (2,'Maquina');
INSERT INTO classepermissao  VALUES (3,'Produto');
INSERT INTO classepermissao  VALUES (4 ,'Producao');
INSERT INTO classepermissao  VALUES (5 ,'Usuario');
INSERT INTO classepermissao  VALUES (6 ,'Relatorio');
INSERT INTO classepermissao  VALUES (7 ,'Empresa');
INSERT INTO classepermissao  VALUES (8 ,'Operador');


INSERT INTO permissao  VALUES (1,'C_MOL', NULL);
INSERT INTO permissao  VALUES (2,'U_MOL', NULL);
INSERT INTO permissao  VALUES (3 ,'D_MOL', NULL);
INSERT INTO permissao  VALUES (4 ,'R_MOL', NULL);
INSERT INTO permissao  VALUES (5 ,'S_MOL', NULL);

INSERT INTO permissao  VALUES (6,'C_MAQ', NULL);
INSERT INTO permissao  VALUES (7,'U_MAQ', NULL);
INSERT INTO permissao  VALUES (8 ,'D_MAQ', NULL);
INSERT INTO permissao  VALUES (9 ,'R_MAQ', NULL);
INSERT INTO permissao  VALUES (10 ,'S_MAQ', NULL);

INSERT INTO permissao  VALUES (11,'C_PROD', NULL);
INSERT INTO permissao  VALUES (12,'U_PROD', NULL);
INSERT INTO permissao  VALUES (13 ,'D_PROD', NULL);
INSERT INTO permissao  VALUES (14 ,'R_PROD', NULL);
INSERT INTO permissao  VALUES (15 ,'S_PROD', NULL);

INSERT INTO permissao  VALUES (16,'C_PRODU', NULL);
INSERT INTO permissao  VALUES (17,'U_PRODU', NULL);
INSERT INTO permissao  VALUES (18 ,'D_PRODU', NULL);
INSERT INTO permissao  VALUES (19 ,'R_PRODU', NULL);
INSERT INTO permissao  VALUES (20 ,'S_PRODU', NULL);

INSERT INTO permissao  VALUES (21,'C_USU', NULL);
INSERT INTO permissao  VALUES (22,'U_USU', NULL);
INSERT INTO permissao  VALUES (23 ,'D_USU', NULL);
INSERT INTO permissao  VALUES (24 ,'R_USU', NULL);
INSERT INTO permissao  VALUES (25 ,'S_USU', NULL);

INSERT INTO permissao  VALUES (26,'R_REL', NULL);

INSERT INTO permissao  VALUES (27,'C_EMP', NULL);
INSERT INTO permissao  VALUES (28,'U_EMP', NULL);
INSERT INTO permissao  VALUES (29 ,'D_EMP', NULL);
INSERT INTO permissao  VALUES (30 ,'R_EMP', NULL);
INSERT INTO permissao  VALUES (31 ,'S_EMP', NULL);

INSERT INTO permissao  VALUES (32,'C_OPE', NULL);
INSERT INTO permissao  VALUES (33,'U_OPE', NULL);
INSERT INTO permissao  VALUES (34 ,'D_OPE', NULL);
INSERT INTO permissao  VALUES (35 ,'R_OPE', NULL);
INSERT INTO permissao  VALUES (36 ,'S_OPE', NULL);


INSERT INTO tenant  VALUES (1 ,'INJEXPROD SERVIÇOS DE INJEÇÃO PLASTICA LTDA ME');

INSERT INTO usuario  VALUES (1 ,0, 'LPASTUCH', 'LORENZO PASTUCH', '$2a$10$ihfCkl04DbK.2KEsji5SXO7.hHlEe4kCAMoxq.No48GrYpTtH/3.O', 1, 1, 1);
INSERT INTO usuario  VALUES (3, 1, 'CONTROLE', 'CONTROLE', 1, 0, 1, 1);


INSERT INTO usuario_permissao VALUES 
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),
(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),
(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),
(1,31),(1,32),(1,33),(1,34),(1,35),(1,36);


INSERT INTO empresa (id, cidade, razaosocial, cpfoucnpj, naturezapessoa, uf, cep, logradouro, numero, bairro, whats, tenant_id,status, editar) 
VALUES (1, 'SABÁUDIA', 'INJEXPROD SERVIÇOS DE INJEÇÃO PLASTICA LTDA ME', '480972140001543', 'JURIDICA', 'PR', '86720000', 'RICARDO DE ABREU ', '317', 'ARAMBUL', '(43)9986-73474', 1, 1, 1);

INSERT INTO usuario_empresa (id_usuario, id_empresa, empresapadrao, tenant_id) VALUES (1, 1, 1, 1);

set foreign_key_checks = 1;


