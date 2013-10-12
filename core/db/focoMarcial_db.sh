#!/bin/bash
sqlite3 focoMarcial.db "

CREATE TABLE faixa ( 
id_faixa INTEGER PRIMARY KEY, 
gub INTEGER NOT NULL, 
descricao VARCHAR(50) NOT NULL, 
path VARCHAR(200) NOT NULL
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
qtd_serie INTEGER NOT NULL, 
intervalo_segundos INTEGER NOT NULL, 
path VARCHAR(200) NOT NULL
);


CREATE TABLE config ( 
id_config INTEGER PRIMARY KEY, 
perfil VARCHAR(20) NOT NULL,
tempo_descanso_curto INTEGER NOT NULL,
tempo_descanso_medio INTEGER NOT NULL,
tempo_descanso_longo INTEGET NOT NULL,
tempo_alongamento INTEGER NOT NULL,
path_descanso VARCHAR(200) NOT NULL,
path_alongamento VARCHAR(200) NOT NULL,
path_atencao VARCAHR(200) NOT NULL,
path_comando VARCAHR(200) NOT NULL,
path_contagem VARCAHR(200) NOT NULL,
aulacomexercicio INT NOT NULL
);
"


chmod +x focoMarcial.db;

## DML

sqlite3 focoMarcial.db "


INSERT INTO faixa (gub, descricao, path) VALUES (10, 'Branca', 'sound/hapkido/branca.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (9, 'Amarela', 'sound/hapkido/amarela.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (8, 'Amarela ponteira Verde', 'sound/hapkido/amarelaponteiraverde.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (7, 'Verde', 'sound/hapkido/verde.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (6, 'Verde ponteira Azul', 'sound/hapkido/verdeponteiraazul.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (5, 'Azul', 'sound/faixa/azul.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (4, 'Azul ponteira Vermelha', 'sound/hapkido/azulponteiravermelha.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (3, 'Vermelha', 'sound/hapkido/vermelha.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (2, 'Vermelha ponteira Preta 1', 'sound/hapkido/vermelhaponteirapreta1.mp3');
INSERT INTO faixa (gub, descricao, path) VALUES (1, 'Vermelha ponteira Preta 2', 'sound/hapkido/vermelhaponteirapreta2.mp3');



INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Apakator', 'Soco no queixo', 20, 1, 1, 'sound/hapkido/branca/apakator.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Aptchaoligui', 'Perna sobe reta e desce reta', 20, 2, 1, 'sound/hapkido/branca/aptchaoligui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Burop Tchagui', 'Joelhada', 20, 2, 1, 'sound/hapkido/branca/buroptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Aptchagui', 'Chute frontal', 20, 3, 1, 'sound/hapkido/branca/aptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Aptcholhô Tchagui', 'Chute semi-circular na altura da coxa', 15, 3, 1, 'sound/hapkido/branca/aptcholhotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Aptcha Nagagui', 'Três Aptchagui (em baixo, no meio e em cima)', 15, 4, 1, 'sound/hapkido/branca/aptchanagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Aptcholhô Nagagui', 'Três Aptcholhô Tchagui (em baixo, no meio e em cima)', 15, 4, 1, 'sound/hapkido/branca/aptcholhonagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (1, 'Tchungo Duban Terigui', 'Soco em base Kimá', 25, 2, 1, 'sound/hapkido/branca/thungodubanterigui.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Ademissá', 'Soco com a faca da mão pelas costas', 10, 1, 1, 'sound/hapkido/amarela/ademissa.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Aptchagô Duban Terigui', 'Aptchagui + 2 socos + base Kimá', 20, 3, 1, 'sound/hapkido/amarela/aptchagodubanterigui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Radan Yop Tchagui', 'Chute lateral baixo', 20, 4, 1, 'sound/hapkido/amarela/radanyoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Tchodan Yop Tchagui', 'Chute lateral médio', 20, 4, 1, 'sound/hapkido/amarela/tchodanyoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Sandan Yop Tchagui', 'Chute lateral alto', 20, 4, 1, 'sound/hapkido/amarela/sandanyoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Aptchagô Yop Tchagui', 'Aptchagui + Yop Tchagui', 25, 4, 1, 'sound/hapkido/amarela/aptchagoyoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Yop Tchanagagui', 'Vai buscar o adversário com 2 yop tchagui', 20, 4, 1, 'sound/hapkido/amarela/yoptchanagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Antchagui', 'Arco de 180 graus com a perna de trás', 20, 3, 1, 'sound/hapkido/amarela/antchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Tchungo Apaltkut', 'Cotovelada em base Tchungo', 15, 2, 1, 'sound/hapkido/amarela/tchungoapalkut.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Tchungo OliguiPalkut', 'Cotovelada em base Tchungo', 15, 1, 1, 'sound/hapkido/amarela/tchungooliguipalkut.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Yoppalkut', 'Cotovelada em base Tchungo', 15, 5, 1, 'sound/hapkido/amarela/yoppalkut.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (2, 'Yan Yoppalkut', 'Cotovelada em base Tchungo', 10, 1, 1, 'sound/hapkido/amarela/yanyopalkut.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Sunal sul', '', 5, 3, 1, 'sound/hapkido/amarelaponteiraverde/sunasul.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Palkut Sul', '', 5, 3, 1, 'sound/hapkido/amarelaponteiraverde/palkutsul.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'TigoTchagui', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/tigotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'TicunTicha Dolligui', '', 20, 4, 1, 'sound/hapkido/amarelaponteiraverde/ticuntichadoligui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'TicunTicha Nerigui', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/ticuntichanerigui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Bakatari', '', 20, 3, 1, 'sound/hapkido/amarelaponteiraverde/bakatari.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'TchigoTchagô Duban Terigui', 'Aptcholhô baixo + 2 socos + Tigo Tchagui', 20, 4, 1, 'sound/hapkido/amarelaponteiraverde/tigotchagodubanterigui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'TitTchagui', '', 10, 5, 1, 'sound/hapkido/amarelaponteiraverde/titchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (3, 'Region Dorá Tchagui Kujari', '', 10, 5, 1, 'sound/hapkido/amarelaponteiraverde/regiondoratchaguikujari.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Tigotchagô Dorá Yoptchagui', 'Tigo Tchagui + Dorá YopTchagui', 15, 5, 1, 'sound/hapkido/verde/tigotchagodorayoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Yop Tchagô Dorá Yop Tchagui', 'Yop Tchagui + Dorá Yop Tchagui', 15, 5, 1, 'sound/hapkido/verde/yoptchagodorayoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Radan Dorá Yop Tchagui', 'Tronco desce, perna sobe', 10, 6, 1, 'sound/hapkido/verde/radandorayoptchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (4, 'Ydan Region Dorá Tchagui Kujari', 'Region pulando', 1, 10, 1, 'sound/hapkido/verde/ydanregiondoratchaguikujari.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (5, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (5, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (5, 'Region Dorá Tchagui Nagagui', 'Region avançando', 4, 5, 1, 'sound/hapkido/verdeponteiraazul/regiondoratchaguinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (5, 'Ydan Dorá Yop Tchagui Kujari', 'Yop Tchagui pulando no mesmo lugar', 2, 5, 1, 'sound/hapkido/verdeponteiraazul/ydandorayoptchaguikujari.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (5, 'Ydan Bakatari Kujari', 'Bakatari pulando', 2, 7, 1, 'sound/hapkido/verdeponteiraazul/ydanbakatarikujari.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'TigoTchagô Region Dorá Tchagui', 'TigoTchagui + Region', 2, 6, 1, 'sound/hapkido/azul/tigotchagoregiondoratchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'AntariTchagô Region Dorá Tchagui', 'Antchagui + Region', 2, 6, 1, 'sound/hapkido/azul/antaritchagoregiondoratchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'Aptchanô Tchagui', 'Chute frontal com calcanhar no queixo do oponente', 5, 4, 1, 'sound/hapkido/azul/aptchanotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (6, 'YopTchanô Tchagui', 'Chute lateral de frente com o peito do pé', 3, 4, 1, 'sound/hapkido/azul/yoptchanoyoptchagui.mp3');







INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Antari Tchanoki', 'Defesa contra aptchagui + defesa no rosto', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/antaritchanoki.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Ticunticha Drigui', '', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/ticuntichadrigui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Ticunticha Nerigui Radan', '', 5, 3, 1, 'sound/hapkido/azulponteiravermelha/ticuntichaneriguiradan.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Ticunticha Doligui Radan', 'Tcunticha Doligui baixo', 5, 4, 1, 'sound/hapkido/azulponteiravermelha/ticuntichadoliguiradan.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Tchunki Drigui', 'Chute no testículo com tronco descendo para trás', 2, 3, 1, 'sound/hapkido/azulponteiravermelha/tchunkidrigui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Mirô Tchagui', 'Chute Frontal com planta do pé', 10, 4, 1, 'sound/hapkido/azulponteiravermelha/mirotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Radan Region TigoTchagui', 'Rasteira de frente', 10, 5, 1, 'sound/hapkido/azulponteiravermelha/radanregiontigotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (7, 'Radan Region Dorá Tchagui', 'Rasteira de costa', 10, 5, 1, 'sound/hapkido/azulponteiravermelha/radanregiondoratchagui.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Anchagui Ydan Antchagui Nagagui', '3 Antchagui pulando e avançando. No final pisa atrás', 5, 10, 1, 'sound/hapkido/vermelha/antchaguiydanantchaguinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Ydan Antchagui Region Dorá Tchagui', '', 5, 5, 1, 'sound/hapkido/vermelha/ydanantchaguiregiondoratchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Radan Region Tigotchagô Radan Region Dorá Tchagui', 'Rasteira de frente + rasteira de costa', 2, 5, 1, 'sound/hapkido/vermelha/radanregiontigotchagoradanregiondoratchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (8, 'Radan Region Dorá Tchagui Ydan Region Dorá Tchagui', 'Rasteira de costas + Ydan Region', 2, 5, 1, 'sound/hapkido/vermelha/radanregiondoratchaguiydanregiondoratchagui.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Ydan Region Dorá Tchagui Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanregiondoratchaguinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Ydan Dorá Yop Tchagui Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydandorayoptchaguinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Ydan Antari Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanantarinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Ydan Ticunticha Nerigui Nagagui', '', 10, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanticuntichaneriguinagagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (9, 'Ydan Bakatari Nagagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta1/ydanbakatarinagagui.mp3');

INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (10, 'Tchariô....Tchumbi', 'Atenção - Prepara', 0, 0, 0, 'sound/hapkido/comum/tchario_tchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (10, 'Patchagui Tchumbi', 'Base de luta', 0, 0, 0, 'sound/hapkido/comum/patchaguitchumbi.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (10, 'Ydan Bolhô Tchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/ydanbolhotchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (10, 'Ydan Dubal Tchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/ydandubaltchagui.mp3');
INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, path) VALUES (10, 'Expartchagui', '', 1, 1, 1, 'sound/hapkido/vermelhaponteirapreta2/expartchagui.mp3');



INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ABDOMINAL', 30, 2, 1, 'core/sound/exercicios/abdominal.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ABDOMINAL INFERIOR', 30, 2, 3, 'core/sound/exercicios/abdominal_inferior.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ABDOMINAL INFERIOR CURTO ALTERNADO VERTICAL', 30, 2, 3, 'core/sound/exercicios/abdominal_inferior_curto_alternado_vertical.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ABDOMINAL INFERIOR CURTO ALTERNADO HORIZONTAL', 30, 2, 3, 'core/sound/exercicios/abdominal_inferior_curto_alternado_horizontal.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('FLEXÃO ABERTO', 12, 2, 1, 'core/sound/exercicios/flexao_aberta.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('FLEXÃO FECHADO', 12, 2, 1, 'core/sound/exercicios/flexao_fechada.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ROSCA DIRETA COM ALTERES (BÍCEPS)', 15, 3, 1, 'core/sound/exercicios/rosca_alteres.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('ROSCA MARTELO COM ALTERES (BÍCEPS)', 15, 3, 1, 'core/sound/exercicios/rosca_martelo_alteres.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('DESENVOLVIMENTO COM ALTERES (OMBROS)', 15, 3, 2, 'core/sound/exercicios/desenvolvimento_alteres.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('LEVANTAMENTO FRONTAL (OMBROS)', 15, 3, 2, 'core/sound/exercicios/levantamento_frontal.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('LEVANTAMENTO LATERAL (OMBROS)', 15, 3, 2, 'core/sound/exercicios/levantamento_lateral.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('SUPINO RETO COM ALTERES', 20, 2, 2, 'core/sound/exercicios/supino_reto_alteres.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('CRUXIFIXO', 20, 2, 2, 'core/sound/exercicios/supino_reto_alteres.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('AGACHAMENTO', 20, 2, 2, 'core/sound/exercicios/agachamento_aptchagui.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('YOPTCHAGUI SENTADO', 20, 2, 1, 'core/sound/exercicios/yoptchagui_sentado.mp3');

INSERT INTO exercicio (descricao, qtd_repeticao, qtd_serie, intervalo_segundos, path) VALUES ('JAB DIRETO', 60, 2, 0, 'core/sound/exercicios/jab_direto.mp3');



INSERT INTO config 
(perfil, tempo_descanso_curto, tempo_descanso_medio, tempo_descanso_longo, tempo_alongamento, path_descanso, path_alongamento, path_atencao, path_comando, path_contagem, aulacomexercicio) 
VALUES
('default', 30, 60, 120, 180, 'core/sound/exercicios/descansar.mp3', 'core/sound/exercicios/alongamento.mp3', 'core/sound/exercicios/atencao.mp3', 'core/sound/comando/', 'core/sound/contagem/', 1);

"






