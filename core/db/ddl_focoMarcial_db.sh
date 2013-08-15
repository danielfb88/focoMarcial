#!/bin/bash
sqlite3 focoMarcial.db "CREATE TABLE artemarcial ( 
id_artemarcial INTEGER PRIMARY KEY, 
descricao VARCHAR(100) NOT NULL, 
path VARCHAR(200) NOT NULL
);

CREATE TABLE faixa ( 
id_faixa INTEGER PRIMARY KEY, 
id_artemarcial INTEGER NOT NULL, 
gub INTEGER NOT NULL, 
descricao VARCHAR(50) NOT NULL, 
path VARCHAR(200) NOT NULL,
FOREIGN KEY (id_artemarcial) REFERENCES artemarcial (id_artemarcial) ON DELETE CASCADE 
);

CREATE TABLE movimento ( 
id_movimento INTEGER PRIMARY KEY, 
id_faixa INTEGER NOT NULL, 
descricao VARCHAR(50) NOT NULL, 
observacao VARCHAR(200), 
qtd_repeticao INTEGER NOT NULL, 
intervalo_segundos INTEGER NOT NULL, 
eh_golpe SMALLINT NOT NULL,
path VARCHAR(200) NOT NULL,
FOREIGN KEY (id_faixa) REFERENCES faixa (id_faixa) ON DELETE CASCADE
);

CREATE TABLE exercicio ( 
id_exercicio INTEGER PRIMARY KEY, 
descricao VARCHAR(50) NOT NULL, 
qtd_repeticao INTEGER NOT NULL, 
intervalo_segundos INTEGER NOT NULL, 
path VARCHAR(200) NOT NULL
);


CREATE TABLE grito ( 
id_grito INTEGER PRIMARY KEY, 
path VARCHAR(200) NOT NULL
);
"


chmod +x focoMarcial.db;

