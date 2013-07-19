#!/bin/bash
sqlite3 focoMarcial.db "
INSERT INTO artemarcial (descricao) VALUES ('Hapkido');
INSERT INTO artemarcial (descricao) VALUES ('Tae Kwon Do');
INSERT INTO artemarcial (descricao) VALUES ('Kung Fu');
INSERT INTO artemarcial (descricao) VALUES ('Jet Kune Do'); 

INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 10, 'Branca');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 9, 'Amarela');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 8, 'Amarela ponteira Verde');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 7, 'Verde');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 6, 'Verde ponteira Azul');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 5, 'Azul');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 4, 'Azul ponteira Vermelha');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 3, 'Vermelha');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 2, 'Vermelha ponteira Preta 1');
INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES (1, 1, 'Vermelha ponteira Preta 2');
"




