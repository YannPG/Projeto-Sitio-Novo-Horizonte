alter table public.Pessoa alter Column id INT auto_increment;

insert into public.Pessoa (cpf, email, nome) values
                        (42576980805, 'yannpereira@hotmail.com', 'Yann Pereira Garcia'),
                        (12345678912, 'samueldasilva@hotmail.com', 'Samuel da Silva'),
                        (98765432198, 'josecorreiapinto@hotmail.com', 'Jose Correia');

insert into public.sitio (id_Pessoa, Endereco_Sitio, Nome_Do_Sitio, Tamanho_Do_Produtor) values
                        (1,'Rua Surubão da Serra','Sitio Aguas Rosas','G'),
                        (2,'Rua Macetador de Picões','Sitio Novo-Horizonte','M'),
                        (3,'Rua Casa do Caralho','Sitio dos Mangais','P');

insert into public.cafe (id_Sitio ,quantidade, Tipo_De_Cafe) values
                        (1, 7,'MN'),
                        (2, 5,'BB');

INSERT INTO public.Tansacao_Cafe (valor_Da_Transacao, id_Cafe, quantidade_Transitada, tipo_Transacao) VALUES
                        (600.00, 1, 5, 'C'),
                        (800.00, 2, 3, 'V'),
                        (800.00, 2, 50, 'V');

INSERT INTO public.REGISTRO_DE_TRANSACAO (data_Transacao, descricao, id_Transacao_Cafe) VALUES
                        ('2024-07-12 15:30:00', 'Venda de cafe', 1);

