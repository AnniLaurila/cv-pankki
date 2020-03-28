
CREATE TABLE IF NOT EXISTS HENKILO (
HENKILO_ID int(5) NOT NULL AUTO_INCREMENT,
ETUNIMI varchar(50) DEFAULT NULL,
SUKUNIMI varchar(50) DEFAULT NULL,
PUHELIN varchar(15) DEFAULT NULL,
EMAIL varchar(50) DEFAULT NULL,
TEHTAVANIMIKE varchar(30) DEFAULT NULL,
KUVAUS varchar(2000) DEFAULT NULL,
OPPIARVO varchar(200) DEFAULT NULL,
OPPILAITOS varchar(200) DEFAULT NULL,
VALMISTUMISVUOSI int(4) DEFAULT NULL,
ONKOKAYTETTAVISSA boolean DEFAULT FALSE,
PRIMARY KEY(HENKILO_ID)
);


CREATE TABLE IF NOT EXISTS TEKNOLOGIAOSAAMINEN (
TEKNOLOGIA_ID int(5) NOT NULL AUTO_INCREMENT,
TEKNOLOGIA varchar(100) DEFAULT NULL,
VUODET int(2) DEFAULT NULL,
KUUKAUDET int(2) DEFAULT NULL,
HENKILO_ID INT NOT NULL,
PRIMARY KEY(TEKNOLOGIA_ID),
FOREIGN KEY (HENKILO_ID) REFERENCES HENKILO(HENKILO_ID)
);


CREATE TABLE IF NOT EXISTS SERTIFIKAATTI (
SERTIFIKAATTI_ID int(5) NOT NULL AUTO_INCREMENT,
NIMI varchar(200) DEFAULT NULL,
MYONTAJA varchar(200) DEFAULT NULL,
VUOSI int(4) DEFAULT NULL,
HENKILO_ID INT NOT NULL,
PRIMARY KEY(SERTIFIKAATTI_ID),
FOREIGN KEY (HENKILO_ID) REFERENCES HENKILO(HENKILO_ID)
);


CREATE TABLE IF NOT EXISTS PROJEKTI (
PROJEKTI_ID int(5) NOT NULL AUTO_INCREMENT,
PROJEKTINIMI varchar(200) DEFAULT NULL,
TEHTAVA varchar(100) DEFAULT NULL,
ASIAKAS varchar(100) DEFAULT NULL,
ALKUKK int(2) DEFAULT NULL,
ALKUVUOSI int(4) DEFAULT NULL,
PAATTYMISKK int(2) DEFAULT NULL,
PAATTYMISVUOSI int(4) DEFAULT NULL,
AVAINSANAT varchar(500) DEFAULT NULL,
HENKILO_ID INT NOT NULL,
PRIMARY KEY(PROJEKTI_ID),
FOREIGN KEY (HENKILO_ID) REFERENCES HENKILO(HENKILO_ID)
);


CREATE TABLE IF NOT EXISTS USER (
ID int(5) NOT NULL AUTO_INCREMENT,
USERNAME varchar(50) NOT NULL UNIQUE,
PASSWORD varchar(200) NOT NULL,
ROLE varchar(100) NOT NULL,
PRIMARY KEY(ID)
);



