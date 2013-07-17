/* IMPORTAR PARA SQLITE */

/* CATEGORIA */
CREATE TABLE categoria (
	id_categoria SERIAL PRIMARY KEY,
	id_categoriapai INT,
	descriacao VARCHAR(50) NOT NULL
);
ALTER TABLE categoria ADD CONSTRAINT fk_categoria_id_categoriapai__categoria_id_categoria 
FOREIGN KEY (id_categoriapai) REFERENCES categoria (id_categoria) 
ON DELETE CASCADE; 

/* INFORMACAO */
CREATE TABLE informacao (
	id_informacao SERIAL PRIMARY KEY,
	id_categoria INT NOT NULL,
	descricao TEXT NOT NULL
);
ALTER TABLE informacao ADD CONSTRAINT fk_informacao_id_categoria__categoria_id_categoria 
FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
ON DELETE CASCADE;

/* PERGUNTA */
CREATE TABLE pergunta (
	id_pergunta SERIAL PRIMARY KEY,
	id_categoria INT NOT NULL,
	descricao TEXT NOT NULL
);
ALTER TABLE pergunta ADD CONSTRAINT fk_pergunta_id_categoria__categoria_id_categoria 
FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
ON DELETE CASCADE;

/* RESPOSTA */
CREATE TABLE resposta (
	id_resposta SERIAL PRIMARY KEY,
	id_pergunta INT NOT NULL,
	descricao TEXT NOT NULL,
	correta smallint NOT NULL CHECK (correta = 0 or correta = 1)
);
ALTER TABLE resposta ADD CONSTRAINT fk_resposta_id_pergunta__pergunta_id_pergunta 
FOREIGN KEY (id_pergunta) REFERENCES pergunta(id_pergunta) 
ON DELETE CASCADE;