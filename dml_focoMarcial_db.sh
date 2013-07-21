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

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Sunal sul', '', 10, 1, 'sound/movimentos/sunasul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Palkut Sul', '', 10, 1, 'sound/movimentos/palkutsul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TigoTchagui', '', 10, 1, 'sound/movimentos/tigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TicunTicha Dolligui', '', 10, 1, 'sound/movimentos/ticuntichadoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TicunTicha Nerigui', '', 10, 1, 'sound/movimentos/ticuntichanerigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Bakatari', '', 10, 1, 'sound/movimentos/bakatari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TchigoTchagô Duban Terigui', 'Aptcholhô baixo + 2 socos + Tigo Tchagui', 10, 1, 'sound/movimentos/tigotchagôdubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TitTchagui', '', 10, 1, 'sound/movimentos/titchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Region Dorá Tchagui Kujari', '', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Tigotchagô Dorá Yoptchagui', 'Tigo Tchagui + Dorá YopTchagui', 10, 1, 'sound/movimentos/tigotchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Yop Tchagô Dorá Yop Tchagui', 'Yop Tchagui + Dorá Yop Tchagui', 10, 1, 'sound/movimentos/yoptchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Radan Dorá Yop Tchagui', 'Tronco desce, perna sobe', 10, 1, 'sound/movimentos/radandorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Ydan Region Dorá Tchagui Kujari', 'Region pulando', 10, 1, 'sound/movimentos/ydanregiondoratchaguikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Region Dorá Tchagui Nagagui', 'Region avançando', 10, 1, 'sound/movimentos/regiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Ydan Dorá Yop Tchagui Kujari', 'Yop Tchagui pulando no mesmo lugar', 10, 1, 'sound/movimentos/ydandorayoptchaguikujari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Ydan Bakatari Kujari', 'Bakatari pulando', 10, 1, 'sound/movimentos/ydanbakatarikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'TigoTchagô Region Dorá Tchagui', 'TigoTchagui + Region', 10, 1, 'sound/movimentos/tigotchagodoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'AntariTchagô Region Dorá Tchagui', 'Antchagui + Region', 10, 1, 'sound/movimentos/antaritchagoregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'Aptchanô Tchagui', 'Chute frontal com calcanhar no queixo do oponente', 10, 1, 'sound/movimentos/aptchanotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'YopTchanô Tchagui', 'Chute lateral de frente com o peito do pé', 10, 1, 'sound/movimentos/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Antari Tchanoki', 'Defesa contra aptchagui + defesa no rosto', 10, 1, 'sound/movimentos/antaritchanoki.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Drigui', '', 10, 1, 'sound/movimentos/ticuntichadrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Nerigui Radan', '', 10, 1, 'sound/movimentos/ticuntichaneriguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Doligui Radan', 'Tcunticha Doligui baixo', 10, 1, 'sound/movimentos/ticuntichadoliguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Tchunki Drigui', 'Chute no testículo com tronco descendo para trás', 10, 1, 'sound/movimentos/tchunkidrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Mirô Tchagui', 'Chute Frontal com planta do pé', 10, 1, 'sound/movimentos/mirotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Radan Region TigoTchagui', 'Rasteira de frente', 10, 1, 'sound/movimentos/radanregiontigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Radan Region Dorá Tchagui', 'Rasteira de costa', 10, 1, 'sound/movimentos/radanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Anchagui Ydan Antchagui Nagagui', '3 Antchagui pulando e avançando. No final pisa atrás', 10, 1, 'sound/movimentos/antchaguiydanantchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Ydan Antchagui Region Dorá Tchagui', '', 10, 1, 'sound/movimentos/ydanantchaguiregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Radan Region Tigotchagô Radan Region Dorá Tchagui', 'Rasteira de frente + rasteira de costa', 10, 1, 'sound/movimentos/radanregiontigotchagoradanregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Radan Region Dorá Tchagui Ydan Region Dorá Tchagui', 'Rasteira de costas + Ydan Region', 10, 1, 'sound/movimentos/radanregiondoratchaguiydanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Region Dorá Tchagui Nagagui', '', 10, 1, 'sound/movimentos/ydanregiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Dorá Yop Tchagui Nagagui', '', 10, 1, 'sound/movimentos/ydandorayoptchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Antari Nagagui', '', 10, 1, 'sound/movimentos/ydanantarinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Ticunticha Nerigui Nagagui', '', 10, 1, 'sound/movimentos/ydanticuntichaneriguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Bakatari Nagagui', '', 10, 1, 'sound/movimentos/ydanbakatarinagagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Ydan Bolhô Tchagui', '', 10, 1, 'sound/movimentos/ydanbolhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Ydan Dubal Tchagui', '', 10, 1, 'sound/movimentos/ydandubaltchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Expartchagui', '', 10, 1, 'sound/movimentos/expartchagui.wav');
"




