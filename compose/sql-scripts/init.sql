
CREATE TABLE IF NOT EXISTS usuario(
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único do aluno
    nome VARCHAR(50) NOT NULL, -- Nome do aluno
    gmail VARCHAR(50) NOT NULL,
    senha VARCHAR(255) NOT NULL

);

CREATE TABLE IF NOT EXISTS produto (
   id INT AUTO_INCREMENT PRIMARY KEY,
   descricao VARCHAR(50) NOT NULL,
   valor DECIMAL (10,2) NOT NULL,
   caracteristica VARCHAR(36) NOT NULL,
   data_cadastro DATE,
   gamer TINYINT(1),
   foto LONGTEXT,
   CONSTRAINT uq_caracteristica UNIQUE (caracteristica)
);
-- NO INIT ESTÁ DANDO ERRO EXECUTAR CRIAÇÃO DE TO DO INIT NO WORKBENCH
CREATE TABLE IF NOT EXISTS caracteristica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    id_caracteristica VARCHAR (36) NOT NULL,
    FOREIGN KEY (id_caracteristica) REFERENCES caracteristica(caracteristica)
);

CREATE TABLE IF NOT EXISTS estoque (
    id INT AUTO_INCREMENT PRIMARY KEY,-- Identificador único do aluno
    descricao VARCHAR(255) NOT NULL,
    id_caracteristica VARCHAR (36) NOT NULL,
    FOREIGN KEY (id_caracteristica) REFERENCES caracteristica(caracteristica)
);