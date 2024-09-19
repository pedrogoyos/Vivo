
insert into TB_USER (id, phone_number, user_name) values (1, '+5511967648282', 'Joselino Kelvin')

insert into tb_product (id, subscription_type, product_type, product_name, status, start_date, user_id) values ('24522345245sfgas', 'prepaid', 'bundle', 'Vivo Total 700 Mega + Netflix', 'active', TO_TIMESTAMP_TZ('2024-03-14T23:00:00+01:00','YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), 1)

insert into tb_product (id, product_type, product_name, status, start_date, product_id) values ('24523asfgaswtrwetr', 'mobile', 'Vivo pós 20GB', 'active', TO_TIMESTAMP_TZ('2024-03-14T23:00:00+01:00','YYYY-MM-DD"T"HH24:MI:SSTZH:TZM'), '24522345245sfgas')

insert into tb_descriptions (id, text, product_id) values (1, 'Linha móvel com 20GB de franquia', '24523asfgaswtrwetr')

insert into tb_identifiers (id, identifier, product_id) values (1, '+51939791073', '24522345245sfgas')
insert into tb_identifiers (id, identifier, product_id) values (2, '+51939791073', '24523asfgaswtrwetr')