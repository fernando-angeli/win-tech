INSERT INTO tb_role (role_name) VALUES ('ROLE_SUPERVISOR'), ('ROLE_ADMIN'), ('ROLE_OPERATOR');

INSERT INTO tb_user (name, email, password) VALUES ('admin', 'admin@admin.com.br', '$$2a$10$TiZBS4okIVD/xpl9/GL5mOwkcWbcBbiivmncdttM81vapo0VPhmxO');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1), (1, 2), (1, 3);