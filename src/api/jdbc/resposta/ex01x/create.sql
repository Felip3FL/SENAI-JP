--<ScriptOptions statementTerminator=";"/>

CREATE TABLE amigos (
	idamigos INT NOT NULL primary key auto_increment,
	nome VARCHAR(45) NOT NULL,
	dataNascimento DATE NOT NULL,
	numTelefone VARCHAR(15) NOT NULL,
) ENGINE=InnoDB;

