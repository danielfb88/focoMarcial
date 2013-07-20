#!/bin/bash
sqlite3 focoMarcial.db "
INSERT INTO artemarcial (descricao, voz_path) VALUES ('Hapkido', 'sound/arteMarcial/hapkido.wav');



INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 10, 'Branca', 'sound/faixas/branca.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 9, 'Amarela', 'sound/faixas/amarela.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 8, 'Amarela ponteira Verde', 'sound/faixas/amarelaPonteiraVerde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 7, 'Verde', 'sound/faixas/verde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 6, 'Verde ponteira Azul', 'sound/faixas/verdePonteiraAzul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 5, 'Azul', 'sound/faixas/azul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 4, 'Azul ponteira Vermelha', 'sound/faixas/azulPonteiraVermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 3, 'Vermelha', 'sound/faixas/vermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 2, 'Vermelha ponteira Preta 1', 'sound/faixas/vermelhaPonteiraPreta1.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 1, 'Vermelha ponteira Preta 2', 'sound/faixas/vermelhaPonteiraPreta2.wav');



INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Montong Terigui', 'Soco com base Montong', 10, 1, 'sound/movimentos/montongterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Apakator', 'Soco no queixo', 10, 1, 'sound/movimentos/apacator.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptchaoligui', 'Perna sobe reta e desce reta', 10, 1, 'sound/movimentos/aptchaoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Burop Tchagui', 'Joelhada', 10, 1, 'sound/movimentos/buroptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptchagui', 'Chute frontal', 10, 1, 'sound/movimentos/aptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcholhô Tchagui', 'Chute semi-circular na altura da coxa', 10, 1, 'sound/movimentos/aptcholhôtchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcha Nagagui', 'Três Aptchagui (em baixo, no meio e em cima)', 10, 1, 'sound/movimentos/aptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcholhô Nagagui', 'Três Aptcholhô Tchagui (em baixo, no meio e em cima)', 10, 1, 'sound/movimentos/aptcholhonagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Tchungo Duban Terigui', 'Soco em base Kimá', 10, 1, 'sound/movimentos/thungodubanterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Ademissá', 'Soco com a faca da mão pelas costas', 10, 1, 'sound/movimentos/ademissa.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Aptchagô Duban Terigui', 'Aptchagui + 2 socos + base Kimá', 10, 1, 'sound/movimentos/aptchagodubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Radan Yop Tchagui', 'Chute lateral baixo', 10, 1, 'sound/movimentos/radanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute lateral médio', 10, 1, 'sound/movimentos/tchodanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Sandan Yop Tchagui', 'Chute lateral alto', 10, 1, 'sound/movimentos/sandanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Aptchagô Yop Tchagui', 'Aptchagui + Yop Tchagui', 10, 1, 'sound/movimentos/aptchagoyoptchagu.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yop Tchanagagui', 'Vai buscar o adversário com 2 yop tchagui', 10, 1, 'sound/movimentos/yoptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Antchagui', 'Arco de 180 graus com a perna de trás', 10, 1, 'sound/movimentos/antchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchungo Apaltkut', 'Cotovelada em base Tchungo', 10, 1, 'sound/movimentos/tchungoapalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchungo OliguiPalkut', 'Cotovelada em base Tchungo', 10, 1, 'sound/movimentos/tchungooliguipalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yoppalkut', 'Cotovelada em base Tchungo', 10, 1, 'sound/movimentos/yoppalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yan Yoppalkut', 'Cotovelada em base Tchungo', 10, 1, 'sound/movimentos/yanyopalkut.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, '', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, '', '', 10, 1, 'sound/movimentos/.wav');




"




