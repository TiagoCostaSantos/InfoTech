
CREATE TABLE IF NOT EXISTS usuario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Identificador único do aluno
    nome VARCHAR(50) NOT NULL, -- Nome do aluno
    gmail VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS produto (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   uuid VARCHAR(36) UNIQUE NOT NULL,
   descricao VARCHAR(50) NOT NULL,
   valor DECIMAL (10,2) NOT NULL,
   data_cadastro DATE
);

-- NO INIT ESTÁ DANDO ERRO EXECUTAR CRIAÇÃO DE TO DO INIT NO WORKBENCH
CREATE TABLE IF NOT EXISTS caracteristica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
     uuid VARCHAR(36) UNIQUE NOT NULL,
    produto_id BIGINT,
    CONSTRAINT FK_caracteristica_produto FOREIGN KEY (produto_id)
                REFERENCES produto(id)
                ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,-- Identificador único do aluno
    produto_id BIGINT,
    CONSTRAINT FK_estoque_produto FOREIGN KEY (produto_id)
            REFERENCES produto(id)
            ON DELETE CASCADE
);