Create database Comidas_Ocasional;

CREATE TABLE Cadastro (
    Login VARCHAR(255),
    Email VARCHAR(255),
    Senha VARCHAR(255),
    Cod INT PRIMARY KEY,
    fk_Cliente_CPF int,
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR(11),
    fk_Estabelecimento_CNPJ VARCHAR(11),
    fk_Estabelecimento_Cod INT
);

CREATE TABLE Estabelecimento (
    Nome VARCHAR(11),
    CNPJ VARCHAR(11),
    Horario INT,
    Cod INT,
    Aberto BINARY,
    PRIMARY KEY (CNPJ, Cod)
);

CREATE TABLE Cardapio (
    Tamanho INT,
    fk_Estabelecimento_CNPJ VARCHAR(11),
    fk_Estabelecimento_Cod INT
);

CREATE TABLE Prato (
    Nome VARCHAR(255),
    Preco INT,
    Id INT PRIMARY KEY
);

CREATE TABLE Endereco (
    Bairro VARCHAR(255),
    NumCasa VARCHAR(255),
    Cidade VARCHAR(255),
    Rua VARCHAR(255),
    Cod INT PRIMARY KEY
);

CREATE TABLE Pedido (
    fk_Pagamento_Pagamento_PK INT,
    Retira_Entrega BINARY
);

CREATE TABLE Carrinho_Aplicativo (
    Quantidade_Item INT
);

CREATE TABLE Pagamento (
    Pagamento_PK INT NOT NULL PRIMARY KEY,
    Pagamento INT
);

CREATE TABLE Possui (
    fk_Estabelecimento_CNPJ VARCHAR(255),
    fk_Estabelecimento_Cod INT,
    fk_Endereco_Cod INT
);

CREATE TABLE Possui (
    fk_Cliente_CPF VARCHAR(255),
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR(11),
    fk_Endereco_Cod INT
);

CREATE TABLE Faz (
    fk_Cliente_CPF VARCHAR(11),
    fk_Cliente_Cod INT,
    fk_Cliente_CNPJ VARCHAR(11)
);

CREATE TABLE Tem (
    fk_Prato_Id INT
);


CREATE TABLE Cliente_PF (
    Nome VARCHAR(255),
    CPF VARCHAR(11) PRIMARY KEY
);

CREATE TABLE Cliente_PJ (
    Nome VARCHAR(255),
    CPF VARCHAR(11) PRIMARY KEY
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