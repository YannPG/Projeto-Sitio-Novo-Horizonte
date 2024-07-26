alter table public.Pessoa alter Column id INT auto_increment;

insert into public.email (email, data_Cadastro) values
      ('yannpereira@hotmail.com', '2024-12-23 23:50:00'),
      ('samueldasilva@hotmail.com','2024-02-23 13:50:00'),
      ('josecorreiapinto@hotmail.com','2024-02-23 13:50:00'),
      ('xayeniSilva@hotmail.com','2024-02-23 13:50:00'),
      ('adanastorRosa@hotmail.com','2024-02-23 13:50:00'),
      ('edinaldoPereiraSilvahotmail.com','2024-02-23 13:50:00'),
      ('uelington@fema.edu.br','2024-02-23 13:50:00'),
      ('anaBananaSilva@hotmail.com','2024-02-23 13:50:00');

insert into public.Pessoa (cpf, nome, data_Nascimento, id_Usuario) values
                                                                  (42576980805, 'Yann Pereira Garcia','2002-05-21',1),
                                                                  (12345678912, 'Samuel da Silva','2003-09-19',2),
                                                                  (98765432198, 'Jose Correia','2004-02-7',3),
                                                                  (65498732178, 'Xayeni da Silva', '2005-04-02',4),
                                                                  (95184762384, 'Adanastor Edmar de Rosa','2006-08-29',5),
                                                                  (26489517384, 'Ana Banana Silva','2007-001-01',6);
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