alter table public.Pessoa alter Column id INT auto_increment;

insert into public.Pessoa (cpf, email, nome, data_Nascimento) values
                        (42576980805, 'yannpereira@hotmail.com', 'Yann Pereira Garcia','2002-05-21'),
                        (12345678912, 'samueldasilva@hotmail.com', 'Samuel da Silva','2003-09-19'),
                        (98765432198, 'josecorreiapinto@hotmail.com', 'Jose Correia','2004-02-7'),
                        (65498732178, 'xayeniSilva@hotmail.com', 'Xayeni da Silva', '2005-04-02'),
                        (95184762384, 'adanastorRosa@hotmail.com', 'Adanastor Edmar de Rosa','2006-08-29'),
                        (26489517384, 'anaBananaSilva@hotmail.com', 'Ana Banana Silva','2007-001-01');

insert into public.sitio (id_Pessoa, Endereco_Sitio, Nome_Do_Sitio, Tamanho_Do_Produtor) values
                        (1,'Rua Surubão da Serra','Sitio Aguas Rosas','G'),
                        (2,'Rua Macetador de Picões','Sitio Novo-Horizonte','M'),
                        (3,'Rua Casa do Caralho','Sitio dos Mangais','P');

insert into public.cafe (id_Sitio, Tipo_De_Cafe) values
                        (1,'MN'),
                        (1,'BB'),
                        (2,'MN'),
                        (2,'BB');

INSERT INTO public.Tansacao_Cafe (valor_Da_Transacao, id_Cafe, quantidade_Transitada, tipo_Transacao) VALUES
                        (6000.00, 1, 4560, 'C'),
                        (10000.00, 1, 1105, 'V'),
                        (100000.00, 2, 9874, 'C'),
                        (5000.00, 2, 5195, 'V'),
                        (100000.00, 3, 9843, 'C'),
                        (1000.00, 3, 3895, 'V'),
                        (100000.00, 4, 8921, 'C'),
                        (2000.00, 4, 2348, 'V');

INSERT INTO public.REGISTRO_DE_TRANSACAO (data_Transacao, id_Transacao_Cafe) VALUES
                        ('2024-01-12 12:30:00', 1),
                        ('2024-02-23 13:50:00', 6),
                        ('2024-03-23 14:50:00', 8),
                        ('2024-04-23 15:50:00', 1),
                        ('2024-05-23 16:50:00', 7),
                        ('2024-06-23 17:50:00', 4),
                        ('2024-07-23 18:50:00', 2),
                        ('2024-08-23 19:50:00', 5),
                        ('2024-09-23 20:50:00', 4),
                        ('2024-10-23 21:50:00', 6),
                        ('2024-11-23 22:50:00', 2),
                        ('2024-12-23 23:50:00', 8);