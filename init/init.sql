-- Criar tabela usuarios
CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email_usuario VARCHAR(100) UNIQUE NOT NULL,
    hash_usuario VARCHAR(100) UNIQUE NOT NULL
); 

-- Criando tabela admin 
CREATE TABLE admin (
    id_admin SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    nivel_acesso_admin INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Criando a tabela clientes
CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    endereco_cliente VARCHAR(200) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
); 

-- Inserir um usuário
INSERT INTO usuarios (nome_usuario, email_usuario, hash_usuario) 
VALUES ('João da Silva', 'joao@email.com', 'sasdafdfjeuhaudgTDAODAJD')
RETURNING id_usuario;
