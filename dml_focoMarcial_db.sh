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

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (1, 'Montong Terigui', 'Soco na
base Montong', 10, 1, '/home/daniel/montongterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (1, 'Aptchagui', 'Chute frontal',
10, 1, '/home/daniel/aptchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (1, 'Aptchaoligui', 'Perna sobe
reta e desce reta', 10, 3, '/home/daniel/aptchaoligui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (2, 'Radan Yop Tchagui', 'Chute
lateral baixo', 10, 3, '/home/daniel/montongterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute
lateral médio',
10, 3, '/home/daniel/aptchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao,
intervalo_segundos, voz_path) VALUES (2, 'Sandan Yop Tchagui', 'Chute
lateral alto', 10, 3, '/home/daniel/aptchaoligui.wav');

"




