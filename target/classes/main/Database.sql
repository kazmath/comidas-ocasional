/* Comidas_Ocasional_atualizado: */

CREATE TABLE Cadastro (
    Login VARCHAR,
    Email VARCHAR,
    Senha VARCHAR,
    Cod INT PRIMARY KEY,
    fk_Cliente_CPF VARCHAR,
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR,
    fk_Estabelecimento_CNPJ VARCHAR,
    fk_Estabelecimento_Cod INT
);

CREATE TABLE Estabelecimento (
    Nome VARCHAR,
    CNPJ VARCHAR,
    Horario INT,
    Cod INT,
    Aberto BINARY,
    PRIMARY KEY (CNPJ, Cod)
);

CREATE TABLE Cardapio (
    Tamanho INT,
    fk_Estabelecimento_CNPJ VARCHAR,
    fk_Estabelecimento_Cod INT
);

CREATE TABLE Prato (
    Nome VARCHAR,
    Preco INT,
    Id INT PRIMARY KEY
);

CREATE TABLE Endereco (
    Bairro VARCHAR,
    NumCasa VARCHAR,
    Cidade VARCHAR,
    Rua VARCHAR,
    Cod INT PRIMARY KEY
);

CREATE TABLE Pedido (
    fk_Pagamento_Pagamento_PK INT,
    Retira_Entrega BINARY
);

CREATE TABLE Carrinho_Aplicativo (
    Quantidade_Item INT,
    Database INT
);

CREATE TABLE Pagamento (
    Pagamento_PK INT NOT NULL PRIMARY KEY,
    Pagamento INT
);

CREATE TABLE Possui (
    fk_Estabelecimento_CNPJ VARCHAR,
    fk_Estabelecimento_Cod INT,
    fk_Endereco_Cod INT
);

CREATE TABLE Possui (
    fk_Cliente_CPF VARCHAR,
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR,
    fk_Endereco_Cod INT
);

CREATE TABLE Faz (
    fk_Cliente_CPF VARCHAR,
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR
);

CREATE TABLE Tem (
    fk_Prato_Id INT
);

CREATE TABLE Relacionamento_1 (
);

CREATE TABLE Cliente_PF (
    Nome VARCHAR,
    CPF VARCHAR PRIMARY KEY
);

CREATE TABLE Cliente_PJ (
    Nome VARCHAR,
    CPF VARCHAR PRIMARY KEY
);
 
ALTER TABLE Cadastro ADD CONSTRAINT FK_Cadastro_2
    FOREIGN KEY (fk_Cliente_CPF???, fk_Cliente_Cod???, fk_Cliente_CNPJ???)
    REFERENCES ??? (???)
    ON DELETE CASCADE;
 
ALTER TABLE Cadastro ADD CONSTRAINT FK_Cadastro_3
    FOREIGN KEY (fk_Estabelecimento_CNPJ, fk_Estabelecimento_Cod)
    REFERENCES Estabelecimento (CNPJ, Cod)
    ON DELETE RESTRICT;
 
ALTER TABLE Cadastro ADD CONSTRAINT FK_Cadastro_4
    FOREIGN KEY (Senha)
    REFERENCES Cliente_PF (CPF);
 
ALTER TABLE Cardapio ADD CONSTRAINT FK_Cardapio_1
    FOREIGN KEY (fk_Estabelecimento_CNPJ, fk_Estabelecimento_Cod)
    REFERENCES Estabelecimento (CNPJ, Cod)
    ON DELETE RESTRICT;
 
ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_1
    FOREIGN KEY (fk_Pagamento_Pagamento_PK)
    REFERENCES Pagamento (Pagamento_PK)
    ON DELETE NO ACTION;
 
ALTER TABLE Possui ADD CONSTRAINT FK_Possui_1
    FOREIGN KEY (fk_Estabelecimento_CNPJ, fk_Estabelecimento_Cod)
    REFERENCES Estabelecimento (CNPJ, Cod)
    ON DELETE RESTRICT;
 
ALTER TABLE Possui ADD CONSTRAINT FK_Possui_2
    FOREIGN KEY (fk_Endereco_Cod)
    REFERENCES Endereco (Cod)
    ON DELETE RESTRICT;
 
ALTER TABLE Possui ADD CONSTRAINT FK_Possui_1
    FOREIGN KEY (fk_Cliente_CPF, fk_Cliente_Cod, fk_Cliente_CNPJ)
    REFERENCES Cliente (CPF, Cod, CNPJ)
    ON DELETE RESTRICT;
 
ALTER TABLE Possui ADD CONSTRAINT FK_Possui_2
    FOREIGN KEY (fk_Endereco_Cod)
    REFERENCES Endereco (Cod)
    ON DELETE RESTRICT;
 
ALTER TABLE Faz ADD CONSTRAINT FK_Faz_1
    FOREIGN KEY (fk_Cliente_CPF???, fk_Cliente_Cod???, fk_Cliente_CNPJ???)
    REFERENCES ??? (???)
    ON DELETE RESTRICT;
 
ALTER TABLE Tem ADD CONSTRAINT FK_Tem_1
    FOREIGN KEY (fk_Prato_Id)
    REFERENCES Prato (Id)
    ON DELETE RESTRICT;
