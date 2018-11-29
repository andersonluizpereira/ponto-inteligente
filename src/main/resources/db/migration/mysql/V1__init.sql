CREATE TABLE empresa (
     id               BIGINT(20) NOT NULL auto_increment,
     cnpj             VARCHAR(255) NOT NULL,
     data_atualizacao DATETIME NOT NULL,
     data_criacao     DATETIME NOT NULL,
     razao_social     VARCHAR(255) NOT NULL,
      primary KEY(id)
     );

CREATE TABLE funcionario
  (
     id                     BIGINT(20) NOT NULL auto_increment,
     cpf                    VARCHAR(255) NOT NULL,
     data_atualizacao       DATETIME NOT NULL,
     data_criacao           DATETIME NOT NULL,
     email                  VARCHAR(255) NOT NULL,
     nome                   VARCHAR(255) NOT NULL,
     perfil                 VARCHAR(255) NOT NULL,
     qtd_horas_almoco       FLOAT DEFAULT NULL,
     qtd_horas_trabalho_dia FLOAT DEFAULT NULL,
     senha                  VARCHAR(255) NOT NULL,
     valor_hora             DECIMAL(19, 2) DEFAULT NULL,
     empresa_id             BIGINT(20) DEFAULT NULL,
     PRIMARY KEY(id)
  );


 CREATE TABLE lancamento
  (
     id               BIGINT(20) NOT NULL auto_increment,
     data             DATETIME NOT NULL,
     data_atualizacao DATETIME NOT NULL,
     data_criacao     DATETIME NOT NULL,
     descricao        VARCHAR(255) DEFAULT NULL,
     localizacao      VARCHAR(255) DEFAULT NULL,
     tipo             VARCHAR(255) NOT NULL,
     funcionario_id   BIGINT(20) DEFAULT NULL,
     PRIMARY KEY(id)
  )
engine = innodb
DEFAULT charset = utf8;


ALTER TABLE funcionario ADD CONSTRAINT fk_empresa FOREIGN KEY (empresa_id) REFERENCES empresa (id);
--
-- Constraints for table lancamento
--
ALTER TABLE lancamento ADD CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionario (id);