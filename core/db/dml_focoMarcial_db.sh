#!/bin/bash
sqlite3 focoMarcial.db "
INSERT INTO artemarcial (descricao, voz_path) VALUES ('Hapkido', 'sound/hapkido/hapkido.wav');



INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 10, 'Branca', 'sound/hapkido/branca.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 9, 'Amarela', 'sound/hapkido/amarela.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 8, 'Amarela ponteira Verde', 'sound/hapkido/amarelaponteiraverde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 7, 'Verde', 'sound/hapkido/verde.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 6, 'Verde ponteira Azul', 'sound/hapkido/verdeponteiraazul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 5, 'Azul', 'sound/faixa/azul.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 4, 'Azul ponteira Vermelha', 'sound/hapkido/azulponteiravermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 3, 'Vermelha', 'sound/hapkido/vermelha.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 2, 'Vermelha ponteira Preta 1', 'sound/hapkido/vermelhaponteirapreta1.wav');
INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES (1, 1, 'Vermelha ponteira Preta 2', 'sound/hapkido/vermelhaponteirapreta2.wav');



INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Montong Terigui', 'Soco com base Montong', 20, 0, 1, 'sound/hapkido/branca/montongterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Apakator', 'Soco no queixo', 20, 1, 1, 'sound/hapkido/branca/apakator.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Aptchaoligui', 'Perna sobe reta e desce reta', 20, 2, 1, 'sound/hapkido/branca/aptchaoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Burop Tchagui', 'Joelhada', 20, 2, 1, 'sound/hapkido/branca/buroptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Aptchagui', 'Chute frontal', 20, 3, 1, 'sound/hapkido/branca/aptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Aptcholhô Tchagui', 'Chute semi-circular na altura da coxa', 15, 3, 1, 'sound/hapkido/branca/aptcholhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Aptcha Nagagui', 'Três Aptchagui (em baixo, no meio e em cima)', 15, 4, 1, 'sound/hapkido/branca/aptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Aptcholhô Nagagui', 'Três Aptcholhô Tchagui (em baixo, no meio e em cima)', 15, 4, 1, 'sound/hapkido/branca/aptcholhonagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (1, 'Tchungo Duban Terigui', 'Soco em base Kimá', 25, 2, 1, 'sound/hapkido/branca/thungodubanterigui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Ademissá', 'Soco com a faca da mão pelas costas', 10, 1, 1, 'sound/hapkido/amarela/ademissa.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Aptchagô Duban Terigui', 'Aptchagui + 2 socos + base Kimá', 20, 3, 1, 'sound/hapkido/amarela/aptchagodubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Radan Yop Tchagui', 'Chute lateral baixo', 20, 4, 1, 'sound/hapkido/amarela/radanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute lateral médio', 20, 4, 1, 'sound/hapkido/amarela/tchodanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Sandan Yop Tchagui', 'Chute lateral alto', 20, 4, 1, 'sound/hapkido/amarela/sandanyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Aptchagô Yop Tchagui', 'Aptchagui + Yop Tchagui', 25, 4, 1, 'sound/hapkido/amarela/aptchagoyoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Yop Tchanagagui', 'Vai buscar o adversário com 2 yop tchagui', 20, 4, 1, 'sound/hapkido/amarela/yoptchanagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Antchagui', 'Arco de 180 graus com a perna de trás', 20, 3, 1, 'sound/hapkido/amarela/antchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Tchungo Apaltkut', 'Cotovelada em base Tchungo', 15, 2, 1, 'sound/hapkido/amarela/tchungoapalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Tchungo OliguiPalkut', 'Cotovelada em base Tchungo', 15, 1, 1, 'sound/hapkido/amarela/tchungooliguipalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Yoppalkut', 'Cotovelada em base Tchungo', 15, 5, 1, 'sound/hapkido/amarela/yoppalkut.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (2, 'Yan Yoppalkut', 'Cotovelada em base Tchungo', 10, 1, 1, 'sound/hapkido/amarela/yanyopalkut.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Sunal sul', '', 5, 3, 1, 'sound/hapkido/amarelaponteiraverde/sunasul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Palkut Sul', '', 5, 3, 1, 'sound/hapkido/amarelaponteiraverde/palkutsul.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'TigoTchagui', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/tigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'TicunTicha Dolligui', '', 20, 4, 1, 'sound/hapkido/amarelaponteiraverde/ticuntichadoligui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'TicunTicha Nerigui', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/ticuntichanerigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Bakatari', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/bakatari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'TchigoTchagô Duban Terigui', 'Aptcholhô baixo + 2 socos + Tigo Tchagui', 20, 4, 1, 'sound/hapkido/amarelaponteiraverde/tigotchagodubanterigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'TitTchagui', '', 10, 5, 1, 'sound/hapkido/amarelaponteiraverde/titchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (3, 'Region Dorá Tchagui Kujari', '', 10, 5, 1, 'sound/hapkido/amarelaponteiraverde/regiondoratchaguikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Tigotchagô Dorá Yoptchagui', 'Tigo Tchagui + Dorá YopTchagui', 15, 5, 1, 'sound/hapkido/verde/tigotchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Yop Tchagô Dorá Yop Tchagui', 'Yop Tchagui + Dorá Yop Tchagui', 15, 5, 1, 'sound/hapkido/verde/yoptchagodorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Radan Dorá Yop Tchagui', 'Tronco desce, perna sobe', 10, 6, 1, 'sound/hapkido/verde/radandorayoptchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (4, 'Ydan Region Dorá Tchagui Kujari', 'Region pulando', 1, 10, 1, 'sound/hapkido/verde/ydanregiondoratchaguikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (5, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (5, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (5, 'Region Dorá Tchagui Nagagui', 'Region avançando', 4, 5, 1, 'sound/hapkido/verdeponteiraazul/regiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (5, 'Ydan Dorá Yop Tchagui Kujari', 'Yop Tchagui pulando no mesmo lugar', 2, 5, 1, 'sound/hapkido/verdeponteiraazul/ydandorayoptchaguikujari.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (5, 'Ydan Bakatari Kujari', 'Bakatari pulando', 2, 7, 1, 'sound/hapkido/verdeponteiraazul/ydanbakatarikujari.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'TigoTchagô Region Dorá Tchagui', 'TigoTchagui + Region', 2, 6, 1, 'sound/hapkido/azul/tigotchagoregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'AntariTchagô Region Dorá Tchagui', 'Antchagui + Region', 2, 6, 1, 'sound/hapkido/azul/antaritchagoregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'Aptchanô Tchagui', 'Chute frontal com calcanhar no queixo do oponente', 5, 4, 1, 'sound/hapkido/azul/aptchanotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (6, 'YopTchanô Tchagui', 'Chute lateral de frente com o peito do pé', 3, 4, 1, 'sound/hapkido/azul/yoptchanoyoptchagui.wav');







INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Antari Tchanoki', 'Defesa contra aptchagui + defesa no rosto', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/antaritchanoki.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Ticunticha Drigui', '', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/ticuntichadrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Ticunticha Nerigui Radan', '', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/ticuntichaneriguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Ticunticha Doligui Radan', 'Tcunticha Doligui baixo', 5, 4, 1, 'sound/hapkido/azulponteiravermelha/ticuntichadoliguiradan.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Tchunki Drigui', 'Chute no testículo com tronco descendo para trás', 2, 3, 1, 'sound/hapkido/azulponteiravermelha/tchunkidrigui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Mirô Tchagui', 'Chute Frontal com planta do pé', 10, 4, 1, 'sound/hapkido/azulponteiravermelha/mirotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Radan Region TigoTchagui', 'Rasteira de frente', 10, 5, 1, 'sound/hapkido/azulponteiravermelha/radanregiontigotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (7, 'Radan Region Dorá Tchagui', 'Rasteira de costa', 10, 5, 1, 'sound/hapkido/azulponteiravermelha/radanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Anchagui Ydan Antchagui Nagagui', '3 Antchagui pulando e avançando. No final pisa atrás', 5, 10, 1, 'sound/hapkido/vermelha/antchaguiydanantchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Ydan Antchagui Region Dorá Tchagui', '', 5, 5, 1, 'sound/hapkido/vermelha/ydanantchaguiregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Radan Region Tigotchagô Radan Region Dorá Tchagui', 'Rasteira de frente + rasteira de costa', 2, 5, 1, 'sound/hapkido/vermelha/radanregiontigotchagoradanregiondoratchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (8, 'Radan Region Dorá Tchagui Ydan Region Dorá Tchagui', 'Rasteira de costas + Ydan Region', 2, 5, 1, 'sound/hapkido/vermelha/radanregiondoratchaguiydanregiondoratchagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Ydan Region Dorá Tchagui Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanregiondoratchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Ydan Dorá Yop Tchagui Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydandorayoptchaguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Ydan Antari Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanantarinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Ydan Ticunticha Nerigui Nagagui', '', 10, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanticuntichaneriguinagagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (9, 'Ydan Bakatari Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanbakatarinagagui.wav');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (10, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (10, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (10, 'Ydan Bolhô Tchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/ydanbolhotchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (10, 'Ydan Dubal Tchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/ydandubaltchagui.wav');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (10, 'Expartchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/expartchagui.wav');
"




