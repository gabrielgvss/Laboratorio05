USE lab05;

INSERT INTO pessoa_fisica (cpf, email, nome, telefone)
VALUES
    ('123.456.789-02', 'carlos.pereira@email.com', 'Carlos Pereira', '(11) 91234-5678'),
    ('987.654.321-10', 'fernanda.lima@email.com', 'Fernanda Lima', '(21) 92345-6789'),
    ('321.654.987-03', 'rafael.almeida@email.com', 'Rafael Almeida', '(31) 93456-7890'),
    ('456.789.123-04', 'juliana.santos@email.com', 'Juliana Santos', '(41) 94567-8901'),
    ('789.123.456-05', 'roberto.carvalho@email.com', 'Roberto Carvalho', '(51) 95678-9012');

INSERT INTO filial (endereco, nome, telefone)
VALUES
	('Rua das Flores, 123, São Paulo, SP', 'Filial São Paulo', '(11) 98765-4321'),
    ('Avenida Atlântica, 456, Rio de Janeiro, RJ', 'Filial Rio de Janeiro', '(21) 99876-5432'),
    ('Praça da Liberdade, 789, Belo Horizonte, MG', 'Filial Belo Horizonte', '(31) 91234-5678'),
    ('Rua XV de Novembro, 101, Curitiba, PR', 'Filial Curitiba', '(41) 93456-7890'),
    ('Avenida Paulista, 202, São Paulo, SP', 'Filial Paulista', '(11) 94567-8901');
    
INSERT INTO funcionario (matricula, id, filial_id)
VALUES 
	
