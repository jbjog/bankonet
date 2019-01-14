drop database if exists  bankonet;
create database bankonet CHARACTER SET utf8;
use bankonet;

CREATE TABLE client(
	id int auto_increment not null primary key,
	nom varchar(30),
	prenom varchar(30)
)ENGINE=InnoDB;

CREATE TABLE compte(
	numero varchar(11) not null primary key,
	intitule varchar(30),
	solde decimal(15,2) default 0,
	id_client int not null,
	CONSTRAINT compte_client_FK FOREIGN KEY (id_client) REFERENCES client(id)
)ENGINE=InnoDB;

CREATE TABLE compte_courant(
	numero varchar(11) not null primary key,
	decouvert decimal(15,2) default 0,
	CONSTRAINT compte_courant_compte_FK FOREIGN KEY (numero) REFERENCES compte(numero)
)ENGINE=InnoDB;

CREATE TABLE compte_epargne(
	numero varchar(11) not null primary key,
	taux_interet decimal(4,3) not null,
	CONSTRAINT compte_epargne_compte_FK FOREIGN KEY (numero) REFERENCES compte(numero)
)ENGINE=InnoDB;


CREATE TABLE mouvement(
	id int auto_increment not null primary key,
	numero_compte_debite varchar(11) not null,
	numero_compte_credite varchar(11) not null,
	montant decimal(15,2),
	date_mvmt datetime,
	CONSTRAINT mouvement_compte_entrant_FK FOREIGN KEY (numero_compte_debite) REFERENCES compte(numero),
	CONSTRAINT mouvement_compte_sortant_FK FOREIGN KEY (numero_compte_credite) REFERENCES compte(numero)
)ENGINE=InnoDB;


INSERT INTO client (nom, prenom) VALUES ('nom1', 'prenom1');
INSERT INTO client (nom, prenom) VALUES ('nom2', 'prenom2');
INSERT INTO client (nom, prenom) VALUES ('nom3', 'prenom3');
INSERT INTO client (nom, prenom) VALUES ('nom4', 'prenom4');

INSERT INTO compte (numero, intitule, solde, id_client) VALUES
('1234567890A', 'Compte Epargne 1', '0.00', 1);

INSERT INTO compte_epargne (numero, taux_interet) VALUES ('1234567890A', '0.015');



INSERT INTO compte (numero, intitule, solde, id_client) VALUES
('00000000001', 'Compte Courant 1', '0.00', 1);

INSERT INTO compte_courant (numero, decouvert) VALUES ('00000000001', '200');


