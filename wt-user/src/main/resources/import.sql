INSERT INTO tb_role (role_name) VALUES ('ROLE_SUPERVISOR'), ('ROLE_ADMIN'), ('ROLE_OPERATOR');

INSERT INTO tb_user (name, email, password) VALUES ('admin', 'admin@admin.com.br', 'password');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1), (1, 2), (1, 3);