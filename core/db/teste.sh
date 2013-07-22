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



INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 'false', 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Montong Terigui', 'Soco com base Montong', 10, 0, true, 'sound/movimento/hapkido/branca/montongterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Apakator', 'Soco no queixo', 10, 2, true, 'sound/movimento/hapkido/branca/apakator.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Patchagui Tchumbi', 'Base de luta', 0, 0, false, 'sound/movimento/hapkido/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Aptchaoligui', 'Perna sobe reta e desce reta', 10, 3, true, 'sound/movimento/hapkido/branca/aptchaoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Burop Tchagui', 'Joelhada', 10, 3, true, 'sound/movimento/hapkido/branca/buroptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Aptchagui', 'Chute frontal', 10, 4, true, 'sound/movimento/hapkido/branca/aptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Aptcholhô Tchagui', 'Chute semi-circular na altura da coxa', 10, 4, true, 'sound/movimento/hapkido/branca/aptcholhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Aptcha Nagagui', 'Três Aptchagui (em baixo, no meio e em cima)', 10, 4, true, 'sound/movimento/hapkido/branca/aptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Aptcholhô Nagagui', 'Três Aptcholhô Tchagui (em baixo, no meio e em cima)', 10, 4, true, 'sound/movimento/hapkido/branca/aptcholhonagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, false, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (1, 'Tchungo Duban Terigui', 'Soco em base Kimá', 10, 3, true, 'sound/movimento/hapkido/branca/thungodubanterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, false, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Ademissá', 'Soco com a faca da mão pelas costas', 10, 3, true, 'sound/movimento/hapkido/amarela/ademissa.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Aptchagô Duban Terigui', 'Aptchagui + 2 socos + base Kimá', 10, 3, true, 'sound/movimento/hapkido/amarela/aptchagodubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Patchagui Tchumbi', 'Base de luta', 0, 0, false, 'sound/movimento/hapkido/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Radan Yop Tchagui', 'Chute lateral baixo', 10, 4, true, 'sound/movimento/hapkido/amarela/radanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute lateral médio', 10, 4, true, 'sound/movimento/hapkido/amarela/tchodanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Sandan Yop Tchagui', 'Chute lateral alto', 10, 4, true, 'sound/movimento/hapkido/amarela/sandanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Aptchagô Yop Tchagui', 'Aptchagui + Yop Tchagui', 10, 4, true, 'sound/movimento/hapkido/amarela/aptchagoyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Yop Tchanagagui', 'Vai buscar o adversário com 2 yop tchagui', 10, 4, true, 'sound/movimento/hapkido/amarela/yoptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Antchagui', 'Arco de 180 graus com a perna de trás', 10, 4, true, 'sound/movimento/hapkido/amarela/antchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, false, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Tchungo Apaltkut', 'Cotovelada em base Tchungo', 10, 2, true, 'sound/movimento/hapkido/amarela/tchungoapalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Tchungo OliguiPalkut', 'Cotovelada em base Tchungo', 10, 2, true, 'sound/movimento/hapkido/amarela/tchungooliguipalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Yoppalkut', 'Cotovelada em base Tchungo', 10, 2, true, 'sound/movimento/hapkido/amarela/yoppalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, is_golpe, voz_path) VALUES (2, 'Yan Yoppalkut', 'Cotovelada em base Tchungo', 10, 2, true, 'sound/movimento/hapkido/amarela/yanyopalkut.wav');"
