/*  SQLITE */

/* VERIFICAR COMO FAZER AUTO-INCREMENT - DELETAR O ARQUIVO ATUAL E CONTRUIR OUTRO. CONEXAO OK*/
/* CATEGORIA */
CREATE TABLE categoria (
	id_categoria PRIMARY KEY,
	id_categoriapai INT,
	descriacao VARCHAR(50) NOT NULL,
	FOREIGN KEY (id_categoriapai) REFERENCES categoria (id_categoria) 
ON DELETE CASCADE
);

/* INFORMACAO */
CREATE TABLE informacao (
	id_informacao SERIAL PRIMARY KEY,
	id_categoria INT NOT NULL,
	descricao TEXT NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
ON DELETE CASCADE
);

/* PERGUNTA */
CREATE TABLE pergunta (
	id_pergunta SERIAL PRIMARY KEY,
	id_categoria INT NOT NULL,
	descricao TEXT NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
ON DELETE CASCADE
);

/* RESPOSTA */
CREATE TABLE resposta (
	id_resposta SERIAL PRIMARY KEY,
	id_pergunta INT NOT NULL,
	descricao TEXT NOT NULL,
	correta smallint NOT NULL CHECK (correta = 0 or correta = 1),
	FOREIGN KEY (id_pergunta) REFERENCES pergunta(id_pergunta) 
ON DELETE CASCADE
);
