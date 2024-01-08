INSERT INTO tb_role (role_name) VALUES ('ROLE_SUPERVISOR'), ('ROLE_ADMIN'), ('ROLE_OPERATOR');

INSERT INTO tb_user (login, email, password) VALUES ('admin', 'admin@admin.com.br', '$2a$10$86EspnppzSYEX2iobyViE.MZjqLokLGj1EDhVuz6MPaAGmh0y41eu');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1), (1, 2), (1, 3);