ALTER TABLE producao
ADD funcionario_id INT;


ALTER TABLE producao
ADD CONSTRAINT fk_funcionario
FOREIGN KEY (funcionario_id) REFERENCES funcionario (id);
