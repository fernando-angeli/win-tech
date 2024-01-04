INSERT INTO state(state, abbreviation) VALUES ('Rio Grande do Sul', 'RS');
INSERT INTO state(state, abbreviation) VALUES ('Santa Catarina', 'SC');
INSERT INTO state(state, abbreviation) VALUES ('São Paulo', 'SP');

INSERT INTO city(city, state_id) VALUES ('Porto Alegre', 1);
INSERT INTO city(city, state_id) VALUES ('Caxias do Sul', 1);
INSERT INTO city(city, state_id) VALUES ('Florianopolis', 2);
INSERT INTO city(city, state_id) VALUES ('São Paulo', 3);

INSERT INTO address(street, number, district, zip_code, city_id) VALUES ('Rua teste 1', 1010, 'Bairro 1', '00022000', 1);
INSERT INTO address(street, number, district, zip_code, city_id) VALUES ('Rua teste 2', 10, 'Bairro 2', '00022111', 2);

INSERT INTO company_or_person(type_company_or_person, type, name, telephone1, telephone2, email, cpf_or_cnpj, rg_or_ie, address_id, delivery_address_id) VALUES ('JURIDICA', 'FORNECEDOR', 'Empresa de Fornecimento de ferragem', '51858595588', '6652565889', 'company@gmail.com', '15256658000155', '2450022556', 1, 1);
INSERT INTO company_or_person(type_company_or_person, type, name, telephone1, telephone2, email, cpf_or_cnpj, rg_or_ie, address_id, delivery_address_id) VALUES ('FISICA', 'INSTALADOR', 'Carlos Instalador', '51999999988', '5135434855', 'pesso@gmail.com', '00011122233', '11R5852', 2, 2);
INSERT INTO company_or_person(type_company_or_person, type, name, telephone1, telephone2, email, cpf_or_cnpj, rg_or_ie, address_id, delivery_address_id) VALUES ('JURIDICA', 'CLIENTE', 'Construtora', '51858595333', '6652565222', 'companyteste2@gmail.com', '15256658000177', '2450022599', 1, 2);
