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