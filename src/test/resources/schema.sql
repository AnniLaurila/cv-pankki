create table if not exists henkilo (
henkilo_id int(5) not null auto_increment,
etunimi varchar(50) default null,
sukunimi varchar(50) default null,
puhelin varchar(15) default null,
email varchar(50) default null,
tehtavanimike varchar(30) default null,
kuvaus varchar(2000) default null,
oppiarvo varchar(200) default null,
oppilaitos varchar(200) default null,
valmistumisvuosi int(4) default null,
onkokaytettavissa boolean default false,
primary key(henkilo_id)
);


create table if not exists teknologiaosaaminen (
teknologia_id int(5) not null auto_increment,
teknologia varchar(100) default null,
vuodet int(2) default null,
kuukaudet int(2) default null,
henkilo_id int not null,
primary key(teknologia_id),
foreign key (henkilo_id) references henkilo(henkilo_id)
);


create table if not exists sertifikaatti (
sertifikaatti_id int(5) not null auto_increment,
nimi varchar(200) default null,
myontaja varchar(200) default null,
vuosi int(4) default null,
henkilo_id int not null,
primary key(sertifikaatti_id),
foreign key (henkilo_id) references henkilo(henkilo_id)
);


create table if not exists projekti (
projekti_id int(5) not null auto_increment,
projektinimi varchar(200) default null,
tehtava varchar(100) default null,
asiakas varchar(100) default null,
alkukk int(2) default null,
alkuvuosi int(4) default null,
paattymiskk int(2) default null,
paattymisvuosi int(4) default null,
avainsanat varchar(500) default null,
henkilo_id int not null,
primary key(projekti_id),
foreign key (henkilo_id) references henkilo(henkilo_id)
);



create table if not exists kayttaja (
id int(5) not null auto_increment,
username varchar(50) not null unique,
password varchar(200) not null,
role varchar(100) not null,
henkilo_id int not null,
primary key(id),
foreign key (henkilo_id) references henkilo(henkilo_id)
);



