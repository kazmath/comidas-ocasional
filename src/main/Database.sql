CREATE DATABASE IF NOT EXISTS Comidas_Ocasional;

USE Comidas_Ocasional;

CREATE TABLE IF NOT EXISTS Cadastro (
    CodCadastro INT NOT NULL AUTO_INCREMENT,
    Login VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (CodCadastro)
);

CREATE TABLE IF NOT EXISTS Prato (
    Id INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Preco INT NOT NULL,
    PRIMARY KEY (Id)
);

CREATE TABLE IF NOT EXISTS Endereco (
    CodEndereco INT NOT NULL AUTO_INCREMENT,
    Bairro VARCHAR(255) NOT NULL,
    NumCasa VARCHAR(255) NOT NULL,
    Cidade VARCHAR(255) NOT NULL,
    Rua VARCHAR(255) NOT NULL,
    PRIMARY KEY (CodEndereco)
);

CREATE TABLE IF NOT EXISTS Pagamento (
    Pagamento_PK INT NOT NULL,
    Pagamento INT,
    PRIMARY KEY (Pagamento_PK)
);
 
CREATE TABLE IF NOT EXISTS Estabelecimento (
    CodEstabelecimento INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(11) NOT NULL,
    Aberto BINARY NOT NULL,
    CodEndereco INT NOT NULL,
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (CodEstabelecimento)
);

CREATE TABLE IF NOT EXISTS Cliente_PF (
    Nome VARCHAR(255) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    CodEndereco INT NOT NULL,
    CodCadastro INT NOT NULL,
    FOREIGN KEY (CodCadastro) REFERENCES Cadastro(CodCadastro),
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (CPF)
);

CREATE TABLE IF NOT EXISTS Cliente_PJ (
    Nome VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(11) NOT NULL,
    CodEndereco INT NOT NULL,
    CodCadastro INT NOT NULL,
    FOREIGN KEY (CodCadastro) REFERENCES Cadastro(CodCadastro),
    FOREIGN KEY (CodEndereco) REFERENCES Endereco(CodEndereco),
    PRIMARY KEY (CNPJ)
);

CREATE TABLE IF NOT EXISTS Cardapio (
    CodCardapio INT NOT NULL AUTO_INCREMENT,
    fk_Estabelecimento_Cod INT NOT NULL,
    Prato_Id INT NOT NULL,
    FOREIGN KEY (fk_Estabelecimento_Cod) REFERENCES Estabelecimento (CodEstabelecimento),
    FOREIGN KEY (Prato_Id) REFERENCES Prato (Id),
    PRIMARY KEY (CodCardapio)
);

CREATE TABLE IF NOT EXISTS Pedido (
    FK_Pagamento INT,
    Retira_Entrega BINARY,
    FOREIGN KEY (FK_Pagamento) REFERENCES Pagamento (Pagamento_PK)
);

CREATE TABLE IF NOT EXISTS Carrinho_Aplicativo (
    Quantidade_Item INT,
    Prato_Id INT,
    FOREIGN KEY (Prato_Id) REFERENCES Prato(Id)
);