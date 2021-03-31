CREATE TABLE Salarie(
	idSal int NOT NULL AUTO_INCREMENT,
	nom varchar(50) NOT NULL,
	prenoms varchar(50) NOT NULL,
	age int NOT NULL,
	fonction varchar(50) NOT NULL,
	service varchar(50) NOT NULL,
	grade varchar(50) NOT NULL,
	PRIMARY KEY (idSal)
);

CREATE TABLE Session(
	idSess int NOT NULL AUTO_INCREMENT,
	date_deb date NOT NULL,
	nbre_jours int  NOT NULL,
	module varchar(50) NOT NULL,
	idSal int NOT NULL,
	lieuForm varchar(50) NOT NULL,
	PRIMARY KEY (idSess),
	CONSTRAINT FOREIGN KEY (idSal) REFERENCES Salarie (idSal)
);

CREATE TABLE User(
	login varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	PRIMARY KEY (login)
);

INSERT INTO User VALUES ("nom", "pass");

INSERT INTO Salarie (nom, prenoms, age, fonction, service, grade) VALUES ("Lelong", "Antoine", 19, "étudiant", "informatique", "2 année");

INSERT INTO Session (date_deb, nbre_jours, module, idSal, lieuForm) VALUES ("02/02/2021", 30, "informatique", 1, "Paris");