INSERT INTO tipo_componente(descricao) VALUES ('perfil');
INSERT INTO acabamento_componente(descricao) VALUES ('Branco'), ('Jet Black'), ('Golden Oak'), ('Grafito');
INSERT INTO tipo_componente_acabamento_componentes (tipo_componente_id, acabamento_componentes_id) VALUES (1, 1), (1, 2), (1, 3), (1, 4);

INSERT INTO tipo_componente(descricao) VALUES ('acessórios');
INSERT INTO acabamento_componente(descricao) VALUES ('Branco'), ('Preto'), ('Marrom') ;
INSERT INTO tipo_componente_acabamento_componentes (tipo_componente_id, acabamento_componentes_id) VALUES (2, 5), (2,6), (2,7);

INSERT INTO tipo_componente(descricao) VALUES ('ferragem');
INSERT INTO acabamento_componente(descricao) VALUES ('Sem acabamento'), ('Epoxi branco'), ('Epoxi preto'), ('Inox');
INSERT INTO tipo_componente_acabamento_componentes (tipo_componente_id, acabamento_componentes_id) VALUES (3, 8), (3, 9), (3, 10), (3, 11);

INSERT INTO tipo_componente(descricao) VALUES ('vidros');
INSERT INTO acabamento_componente(descricao) VALUES ('Incolor'), ('Fumê'), ('Verde'), ('Boreal');
INSERT INTO tipo_componente_acabamento_componentes (tipo_componente_id, acabamento_componentes_id) VALUES (4, 12), (4, 13), (4, 14), (4, 15);

INSERT INTO grupo_componente(descricao) VALUES ('marco'), ('folha'), ('reforço'), ('corta vento'), ('tapa deságue'), ('cremona'), ('roldana'), ('contra-fecho'), ('float'), ('temperado'), ('laminado'), ('duplo');
INSERT INTO tipo_componente_grupo_componentes(tipo_componente_id, grupo_componentes_id) VALUES (1, 1), (1, 2), (1, 3), (2, 4), (2, 5), (3, 6), (3, 7), (3, 8), (4, 9), (4, 10), (4, 11), (4, 12);

INSERT INTO subgrupo_componente(descricao) VALUES ('correr'), ('giro'), ('fixo'), ('externo');
INSERT INTO grupo_componente_subgrupo_componentes(grupo_componente_id, subgrupo_componentes_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4);

INSERT INTO ferragem (id, codigo, codigo_fornecedor, descricao, tipo_componente_id, grupo_componente_id, subgrupo_componente_id, acabamento_componente_id, unidade_de_medida, preco, peso, pedido_minimo, entrada, largura, altura, comprimento, quantidade_pontos, lado) VALUES (1, 300001, 'ROL1','Roldana simples 30kg - advance', 3, 7, 1, 8, 'UNIDADE', 8.50, 0.050, 1, 0, 12, 12, 20, 0, 'AMBIDESTRA');