ALTER TABLE producao
ADD atributo_id INT;

ALTER TABLE producao
ADD CONSTRAINT fk_atributo
FOREIGN KEY (atributo_id) REFERENCES atributo(id);



