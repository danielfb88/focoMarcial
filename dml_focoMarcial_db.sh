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



INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Montong Terigui', 'Soco com base Montong', 10, 0, 'sound/movimento/hapkido/branca/montongterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Apakator', 'Soco no queixo', 10, 2, 'sound/movimento/hapkido/branca/apakator.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 'sound/movimento/hapkido/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptchaoligui', 'Perna sobe reta e desce reta', 10, 3, 'sound/movimento/hapkido/branca/aptchaoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Burop Tchagui', 'Joelhada', 10, 3, 'sound/movimento/hapkido/branca/buroptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptchagui', 'Chute frontal', 10, 4, 'sound/movimento/hapkido/branca/aptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcholhô Tchagui', 'Chute semi-circular na altura da coxa', 10, 4, 'sound/movimento/hapkido/branca/aptcholhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcha Nagagui', 'Três Aptchagui (em baixo, no meio e em cima)', 10, 4, 'sound/movimento/hapkido/branca/aptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Aptcholhô Nagagui', 'Três Aptcholhô Tchagui (em baixo, no meio e em cima)', 10, 4, 'sound/movimento/hapkido/branca/aptcholhonagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (1, 'Tchungo Duban Terigui', 'Soco em base Kimá', 10, 3, 'sound/movimento/hapkido/branca/thungodubanterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 'sound/movimento/hapkido/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Ademissá', 'Soco com a faca da mão pelas costas', 10, 3, 'sound/movimento/hapkido/amarela/ademissa.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Aptchagô Duban Terigui', 'Aptchagui + 2 socos + base Kimá', 10, 3, 'sound/movimento/hapkido/amarela/aptchagodubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 'sound/movimento/hapkido/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Radan Yop Tchagui', 'Chute lateral baixo', 10, 4, 'sound/movimento/hapkido/amarela/radanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute lateral médio', 10, 4, 'sound/movimento/hapkido/amarela/tchodanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Sandan Yop Tchagui', 'Chute lateral alto', 10, 4, 'sound/movimento/hapkido/amarela/sandanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Aptchagô Yop Tchagui', 'Aptchagui + Yop Tchagui', 10, 4, 'sound/movimento/hapkido/amarela/aptchagoyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yop Tchanagagui', 'Vai buscar o adversário com 2 yop tchagui', 10, 4, 'sound/movimento/hapkido/amarela/yoptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Antchagui', 'Arco de 180 graus com a perna de trás', 10, 4, 'sound/movimento/hapkido/amarela/antchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchungo Apaltkut', 'Cotovelada em base Tchungo', 10, 2, 'sound/movimento/hapkido/amarela/tchungoapalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Tchungo OliguiPalkut', 'Cotovelada em base Tchungo', 10, 2, 'sound/movimento/hapkido/amarela/tchungooliguipalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yoppalkut', 'Cotovelada em base Tchungo', 10, 2, 'sound/movimento/hapkido/amarela/yoppalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (2, 'Yan Yoppalkut', 'Cotovelada em base Tchungo', 10, 2, 'sound/movimento/hapkido/amarela/yanyopalkut.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Sunal sul', '', 10, 1, 'sound/movimento/sunasul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Palkut Sul', '', 10, 1, 'sound/movimento/palkutsul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TigoTchagui', '', 10, 1, 'sound/movimento/tigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TicunTicha Dolligui', '', 10, 1, 'sound/movimento/ticuntichadoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TicunTicha Nerigui', '', 10, 1, 'sound/movimento/ticuntichanerigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Bakatari', '', 10, 1, 'sound/movimento/bakatari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TchigoTchagô Duban Terigui', 'Aptcholhô baixo + 2 socos + Tigo Tchagui', 10, 1, 'sound/movimento/tigotchagôdubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'TitTchagui', '', 10, 1, 'sound/movimento/titchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (3, 'Region Dorá Tchagui Kujari', '', 10, 1, 'sound/movimento/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Tigotchagô Dorá Yoptchagui', 'Tigo Tchagui + Dorá YopTchagui', 10, 1, 'sound/movimento/tigotchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Yop Tchagô Dorá Yop Tchagui', 'Yop Tchagui + Dorá Yop Tchagui', 10, 1, 'sound/movimento/yoptchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Radan Dorá Yop Tchagui', 'Tronco desce, perna sobe', 10, 1, 'sound/movimento/radandorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (4, 'Ydan Region Dorá Tchagui Kujari', 'Region pulando', 10, 1, 'sound/movimento/ydanregiondoratchaguikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Region Dorá Tchagui Nagagui', 'Region avançando', 10, 1, 'sound/movimento/regiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Ydan Dorá Yop Tchagui Kujari', 'Yop Tchagui pulando no mesmo lugar', 10, 1, 'sound/movimento/ydandorayoptchaguikujari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (5, 'Ydan Bakatari Kujari', 'Bakatari pulando', 10, 1, 'sound/movimento/ydanbakatarikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'TigoTchagô Region Dorá Tchagui', 'TigoTchagui + Region', 10, 1, 'sound/movimento/tigotchagodoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'AntariTchagô Region Dorá Tchagui', 'Antchagui + Region', 10, 1, 'sound/movimento/antaritchagoregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'Aptchanô Tchagui', 'Chute frontal com calcanhar no queixo do oponente', 10, 1, 'sound/movimento/aptchanotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (6, 'YopTchanô Tchagui', 'Chute lateral de frente com o peito do pé', 10, 1, 'sound/movimento/.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Antari Tchanoki', 'Defesa contra aptchagui + defesa no rosto', 10, 1, 'sound/movimento/antaritchanoki.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Drigui', '', 10, 1, 'sound/movimento/ticuntichadrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Nerigui Radan', '', 10, 1, 'sound/movimento/ticuntichaneriguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Ticunticha Doligui Radan', 'Tcunticha Doligui baixo', 10, 1, 'sound/movimento/ticuntichadoliguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Tchunki Drigui', 'Chute no testículo com tronco descendo para trás', 10, 1, 'sound/movimento/tchunkidrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Mirô Tchagui', 'Chute Frontal com planta do pé', 10, 1, 'sound/movimento/mirotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Radan Region TigoTchagui', 'Rasteira de frente', 10, 1, 'sound/movimento/radanregiontigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (7, 'Radan Region Dorá Tchagui', 'Rasteira de costa', 10, 1, 'sound/movimento/radanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Anchagui Ydan Antchagui Nagagui', '3 Antchagui pulando e avançando. No final pisa atrás', 10, 1, 'sound/movimento/antchaguiydanantchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Ydan Antchagui Region Dorá Tchagui', '', 10, 1, 'sound/movimento/ydanantchaguiregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Radan Region Tigotchagô Radan Region Dorá Tchagui', 'Rasteira de frente + rasteira de costa', 10, 1, 'sound/movimento/radanregiontigotchagoradanregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (8, 'Radan Region Dorá Tchagui Ydan Region Dorá Tchagui', 'Rasteira de costas + Ydan Region', 10, 1, 'sound/movimento/radanregiondoratchaguiydanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Region Dorá Tchagui Nagagui', '', 10, 1, 'sound/movimento/ydanregiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Dorá Yop Tchagui Nagagui', '', 10, 1, 'sound/movimento/ydandorayoptchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Antari Nagagui', '', 10, 1, 'sound/movimento/ydanantarinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Ticunticha Nerigui Nagagui', '', 10, 1, 'sound/movimento/ydanticuntichaneriguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (9, 'Ydan Bakatari Nagagui', '', 10, 1, 'sound/movimento/ydanbakatarinagagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Ydan Bolhô Tchagui', '', 10, 1, 'sound/movimento/ydanbolhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Ydan Dubal Tchagui', '', 10, 1, 'sound/movimento/ydandubaltchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, voz_path) VALUES (10, 'Expartchagui', '', 10, 1, 'sound/movimento/expartchagui.wav');
"




