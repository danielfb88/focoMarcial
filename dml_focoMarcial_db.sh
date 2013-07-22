#!/bin/bash
sqlite3 focoMarcial.db "
INSERT INTO artemarcial (descricao, voz_path) VALUES ('Hapkido', 'sound/artemarcial/hapkido.wav');



INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 10, 'Branca', 'sound/faixa/branca.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 9, 'Amarela', 'sound/faixa/amarela.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 8, 'Amarela ponteira Verde', 'sound/faixa/amarelaponteiraverde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 7, 'Verde', 'sound/faixa/verde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 6, 'Verde ponteira Azul', 'sound/faixa/verdeponteiraazul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 5, 'Azul', 'sound/faixa/azul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 4, 'Azul ponteira Vermelha', 'sound/faixa/azulponteiravermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 3, 'Vermelha', 'sound/faixa/vermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 2, 'Vermelha ponteira Preta 1', 'sound/faixa/vermelhaponteirapreta1.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 1, 'Vermelha ponteira Preta 2', 'sound/faixa/vermelhaponteirapreta2.wav');
"




