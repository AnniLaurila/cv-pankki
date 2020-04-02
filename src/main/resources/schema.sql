create table if not exists henkilo (
henkilo_id serial primary key,
etunimi text default null,
sukunimi text default null,
puhelin text default null,
email text default null,
tehtavanimike text default null,
kuvaus text default null,
oppiarvo text default null,
oppilaitos text default null,
valmistumisvuosi integer default null,
onkokaytettavissa boolean default false
);


create table if not exists teknologiaosaaminen (
teknologia_id serial primary key,
teknologia text default null,
vuodet integer default null,
kuukaudet integer default null,
henkilo_id integer not null,
constraint teknologiaosaaminen_henkilo_fk foreign key (henkilo_id) references henkilo(henkilo_id)
);


create table if not exists sertifikaatti (
sertifikaatti_id serial primary key,
nimi text default null,
myontaja text default null,
vuosi integer default null,
henkilo_id integer not null,
constraint sertifikaatti_henkilo_fk foreign key (henkilo_id) references henkilo(henkilo_id)
);


create table if not exists projekti (
projekti_id serial primary key,
projektinimi text default null,
tehtava text default null,
asiakas text default null,
alkukk integer default null,
alkuvuosi integer default null,
paattymiskk integer default null,
paattymisvuosi integer default null,
avainsanat text default null,
henkilo_id int not null,
constraint projekti_henkilo_fk foreign key (henkilo_id) references henkilo(henkilo_id)
);



create table if not exists kayttaja (
id serial primary key,
username text not null unique,
password text not null,
role text not null,
henkilo_id integer not null,
constraint kayttaja_henkilo_fk foreign key (henkilo_id) references henkilo(henkilo_id)
);



insert into henkilo (etunimi, sukunimi, puhelin, email, tehtavanimike, kuvaus, oppiarvo, oppilaitos, valmistumisvuosi, onkokaytettavissa)
values ('Anni', 'Laurila', '0503952800', 'anninmeil@gmail.com', 'Järjestelmäsuunnittelija', 'Anni lorem ipsum blaa kuvaus', 'Filosofian maisteri', 'Helsingin yliopisto', 2016, true);

insert into teknologiaosaaminen (teknologia, vuodet, kuukaudet, henkilo_id)
values ('Java', 2, 6, 1);

insert into teknologiaosaaminen (teknologia, vuodet, kuukaudet, henkilo_id)
values ('SQL', 5, 1, 1);

insert into sertifikaatti (nimi, myontaja, vuosi, henkilo_id)
values ('Oracle certified professional (ocp) Java SE 8 programmer', 'Oracle', 2017, 1);

insert into sertifikaatti (nimi, myontaja, vuosi, henkilo_id)
values ('Certified ScrumMaster', 'Scrum Alliance', 2017, 1);


insert into projekti (projektinimi, tehtava, asiakas, alkukk, alkuvuosi, avainsanat, henkilo_id)
values ('Hippo projekti', 'Java-ohjelmistokehittäjä', 'Espoon kaupunki', 10, 2019, 'Java Sql Spring', 1);


insert into henkilo (etunimi, sukunimi, puhelin, email, tehtavanimike, kuvaus, oppiarvo, oppilaitos, valmistumisvuosi, onkokaytettavissa)
values ('Heidi', 'Hooär', '0503217724', 'heidi.hooar@gmail.com', 'HR-assistentti', 'Heidi lorem ipsum blaa kuvaus', 'Tradenomi', 'Haaga-Helia', 2015, false);


insert into kayttaja (username, password, role, henkilo_id)
values ('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER', 1);
insert into kayttaja (username, password, role, henkilo_id)
values ('admin','$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN', 2);