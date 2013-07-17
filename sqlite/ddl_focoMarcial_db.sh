#!/bin/bash
sqlite3 focoMarcial.db "CREATE TABLE artemarcial ( 
id_artemarcial INTEGER PRIMARY KEY, 
descricao VARCHAR(100) NOT NULL 
);

CREATE TABLE faixa ( 
id_faixa INTEGER PRIMARY KEY, 
id_artemarcial INTEGER NOT NULL, 
gub INTEGER NOT NULL, 
descricao VARCHAR(50) NOT NULL, 
FOREIGN KEY (id_artemarcial) REFERENCES artemarcial (id_artemarcial) ON DELETE CASCADE 
);

CREATE TABLE movimento ( 
id_movimento INTEGER PRIMARY KEY, 
id_faixa INTEGER NOT NULL, 
descricao VARCHAR(50) NOT NULL, 
observacao VARCHAR(200), 
qtd_repeticao INTEGER NOT NULL, 
intervalo_segundos INTEGER NOT NULL, 
FOREIGN KEY (id_faixa) REFERENCES faixa (id_faixa) ON DELETE CASCADE
);

CREATE TABLE vozcomando ( id_vozcomando INTEGER PRIMARY KEY, 
id_movimento INTEGER NOT NULL, 
encoded_data BLOB NOT NULL, 
filename VARCHAR(50) NOT NULL, 
FOREIGN KEY (id_movimento) REFERENCES movimento (id_movimento) ON DELETE CASCADE
); "



