CREATE DATABASE Comidas_Ocasional;

USE Comidas_Ocasional;

CREATE TABLE Cadastro (
    CodCadastro INT NOT NULL AUTO_INCREMENT,
    LOGIN VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (CodCadastro)
);

CREATE TABLE Prato (
    Id INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Preco INT NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE Endereco (
    CodEndereco INT NOT NULL AUTO_INCREMENT,
    Bairro VARCHAR(255) NOT NULL,
    NumCasa VARCHAR(255) NOT NULL,
    Cidade VARCHAR(255) NOT NULL,
    Rua VARCHAR(255) NOT NULL,
    PRIMARY KEY (CodEndereco)
);

CREATE TABLE Pagamento (
    Pagamento_PK INT NOT NULL,
    Pagamento INT,
    PRIMARY KEY (Pagamento_PK)
);
 
CREATE TABLE Estabelecimento (
    CodEstabelecimento INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(11) NOT NULL,
    CNPJ VARCHAR(11) NOT NULL,
    Horario INT NOT NULL,
    Aberto BINARY NOT NULL,
    CodEndereco INT NOT NULL,
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (CodEstabelecimento),
);

CREATE TABLE Cliente_PF (
    Nome VARCHAR(255),
    CPF VARCHAR(11),
    CodEndereco INT NOT NULL,
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (Pagamento_PK)
);

CREATE TABLE Cliente_PJ (
    Nome VARCHAR(255),
    CNPJ VARCHAR(11),
    CodEndereco INT NOT NULL,
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (CNPJ)
);

CREATE TABLE Cardapio (
    fk_Estabelecimento_Cod INT NOT NULL,
    Prato_Id INT NOT NULL,
    FOREIGN KEY (fk_Estabelecimento_Cod) REFERENCES Estabelecimento (CodEstabelecimento),
    FOREIGN KEY (Prato_Id) REFERENCES Prato (Id)
);

CREATE TABLE Pedido (
    FK_Pagamento INT,
    Retira_Entrega BINARY,
    FOREIGN KEY (FK_Pagamento) REFERENCES Pagamento (Pagamento_PK)
);

CREATE TABLE Carrinho_Aplicativo (
    Quantidade_Item INT,
    Prato_Id INT,
    FOREIGN KEY (Prato_Id) REFERENCES Prato(Id)
);