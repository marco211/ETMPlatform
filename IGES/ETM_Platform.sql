Drop database if exists ETM_PLATFORM;
create database ETM_PLATFORM;
use ETM_PLATFORM;
set global max_allowed_packet=100*1024*1024;

drop table if exists Utente;
create table Utente(
Email varchar(40) primary key,
Nome varchar(30) not null,
Cognome varchar(30) not null,
Password varchar(16) not null,
Data_Nascita varchar(16) not null,
PropostaTesi_ID int,
Matricola varchar(11) ,
Ufficio varchar(50),
Tipo varchar(1) not null,
Validazione varchar(40)
);

drop table if exists Insegnamento;

create table if not exists Insegnamento(
Nome varchar(50) primary key,
Cfu int
);

drop table if exists Amministratore;

create table if not exists Amministratore(
Email varchar(40) primary key,
Nome varchar(30) not null,
Cognome varchar(30) not null,
Password varchar(16) not null
);

drop table if exists PropostaTesi;

create table if not exists PropostaTesi(
Id int primary key auto_increment,
Utente_Email varchar(40) not null,
Titolo varchar(100) not null,
Chiuso boolean not null,
Ambito varchar(40) not null, 
Tempo int not null,
Descrizione varchar(5000) not null,
Archiviato boolean not null,
Materia varchar(50) not null,
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists RichiestaPartecipazione;

create table if not exists RichiestaPartecipazione(
Id int primary key auto_increment,
Data date not null,
PropostaTesi_Id int not null,
Utente_Email varchar(40) not null,
foreign key (PropostaTesi_Id) references PropostaTesi(Id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists File;

create table if not exists File(
Nome varchar(30) not null,
PropostaTesi_Id int not null,
File longblob null,
Descrizione varchar(1000) not null,
Voto int null,
Descrizione_Voto varchar(1000) null,
Utente_Email varchar(40) not null,
primary key (Nome, PropostaTesi_Id),
foreign key (PropostaTesi_Id) references PropostaTesi(Id),
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists Attivita;

create table if not exists Attivita(
Id int auto_increment not null,
Utente_Email varchar(40) not null,
Nome varchar(30) not null,
Data varchar(15) not null,
Tipo varchar(2) null,
PropostaTesi_Id int,
primary key (Id, Utente_Email),
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists UtenteSegueUtente;

create table if not exists UtenteSegueUtente(
Utente_Email_Seguace varchar(40) not null,
Utente_Email_Seguito varchar(40) not null,
SegueAggiuntaPropostaTesi boolean not null,
SegueModificaPropostaTesi boolean not null,
SegueDisabilitaPropostaTesi boolean not null,
primary key (Utente_Email_Seguace, Utente_Email_Seguito),
foreign key (Utente_Email_Seguace) references Utente(Email),
foreign key (Utente_Email_Seguito) references Utente(Email)
);

drop table if exists AttivitaNotificataUtente;

create table if not exists AttivitaNotificataUtente(
IdAttivita int not null,
Utente_Email varchar(40) not null,
Letto boolean not null,
primary key (IdAttivita, Utente_Email),
foreign key (IdAttivita) references Attivita(Id),
foreign key (Utente_Email) references Utente(Email)
);


drop table if exists Consegna;

create table if not exists Consegna(
Id int primary key auto_increment,
Scadenza date not null,
Nome varchar(30) not null,
Descrizione varchar(1000) not null,
PropostaTesi_Id int not null,
foreign key (PropostaTesi_Id) references PropostaTesi(Id)
);

drop table if exists Ha;

create table if not exists Ha(
Utente_Email varchar(40) not null,
Consegna_Id int not null,
stato boolean,
primary key (Utente_Email, Consegna_Id),
foreign key (Consegna_Id) references Consegna(Id),
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists Partecipa;

create table if not exists Partecipa(
Utente_Email varchar(40) not null,
PropostaTesi_Id int not null,
primary key (Utente_Email, PropostaTesi_Id),
foreign key (PropostaTesi_Id) references PropostaTesi(Id),
foreign key (Utente_Email) references Utente(Email)
);

drop table if exists Insegna;

create table if not exists Insegna(
Utente_Email varchar(40) not null,
Insegnamento_Nome varchar(50) not null,
primary key (Utente_Email, Insegnamento_Nome),
foreign key (Insegnamento_Nome) references Insegnamento(Nome),
foreign key (Utente_Email) references Utente(Email)
);


insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione)  values("etm.docente@unisa.it", "Clelia", "De Felice", "ciao", "22/02/1992", "Stecca C 39", 'd', "valido");
insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione)  values("etm.docenteuno@unisa.it", "Francesco", "De Felice", "ciao", "22/02/1992", "Stecca C 39", 'd', "valido");
insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione)  values("etm.docentedue@unisa.it", "Alfonso", "Ambrosino", "ciao", "22/02/1992", "Stecca C zdcomalsa39", 'd', "valido");
insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione)  values("etm.docentetre@unisa.it", "Nicola", "Scala", "ciao", "22/02/1992", "Steccaaaa9", 'd', "valido");
insert into utente (email, nome, cognome, password, data_nascita, ufficio,  tipo, validazione)  values("etm.docentequattro@unisa.it", "Docente Quattro", "Di Prova", "ciao", "22/02/1992", "Stecca C 39", 'd', "valido");
insert into utente (email, nome, cognome, password, data_nascita, propostaTesi_id,matricola, tipo, validazione) values("etm.utente@studenti.unisa.it", "Utente", "Di Provaaaaa", "ciao", "22/02/1992",1,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita,propostaTesi_id,matricola, tipo, validazione) values("etm.utenteuno@studenti.unisa.it", "Utente", "Di Provaaaaa", "ciao", "22/02/1992", 1,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, propostaTesi_id,matricola, tipo, validazione) values("etm.utentedue@studenti.unisa.it", "Utente Due", "Di Prova", "ciao", "22/02/1992", 1,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, propostaTesi_id,matricola, tipo, validazione) values("etm.utentetre@studenti.unisa.it", "Utente tre", "Di Prova", "ciao", "22/02/1992", 1,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita,propostaTesi_id, matricola, tipo, validazione) values("etm.utentequattro@studenti.unisa.it", "Utente quattrooo", "Di Prova", "ciao", "22/02/1992", 2,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita,propostaTesi_id, matricola, tipo, validazione) values("etm.utentecinque@studenti.unisa.it", "Utente cinque", "Di Prova", "ciao", "22/02/1992",2, "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita,propostaTesi_id, matricola, tipo, validazione) values("etm.utentesei@studenti.unisa.it", "Utente seiiiii", "Di Prova", "ciao", "22/02/1992", 2,"0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utentesette@studenti.unisa.it", "Utente sette", "Di Provaaaaa", "ciao", "22/02/1992", "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utenteotto@studenti.unisa.it", "Utente otto ss", "Di Prova", "ciao", "22/02/1992", "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utentenove@studenti.unisa.it", "Utente nuevveeee", "Di Prova", "ciao", "22/02/1992", "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utentedieci@studenti.unisa.it", "Utente dieci", "Di Prova", "ciao", "22/02/1992", "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utenteundici@studenti.unisa.it", "Utente undici", "Di Prova", "ciao", "22/02/1992", "0512122112", 's', "valido");
insert into utente (email, nome, cognome, password, data_nascita, matricola, tipo, validazione) values("etm.utentedodici@studenti.unisa.it", "utente", "uno", "ciao", "22/02/1992", "0512122112", 's', "valido");

insert into Amministratore values ("boss@admin.it", "Marco", "Della Medaglia", "qwert");
insert into Amministratore values ("boss2@admin.it", "Fabio", "Esposito", "qwert");

insert into insegnamento (nome) values("MMI");
insert into insegnamento (nome) values("ETC");
insert into insegnamento (nome) values("CPSM");
insert into insegnamento (nome) values("Analisi");
insert into insegnamento (nome) values("Ricerca operativa");
insert into insegnamento (nome) values("Matematica Discreta");
insert into insegnamento (nome) values("Analisi numerica");

insert into insegna (utente_email, insegnamento_nome) values("etm.docente@unisa.it","ETC");
insert into insegna (utente_email, insegnamento_nome) values("etm.docentedue@unisa.it","MMI");
insert into insegna (utente_email, insegnamento_nome) values("etm.docentetre@unisa.it","Analisi");
insert into insegna (utente_email, insegnamento_nome) values("etm.docentequattro@unisa.it","Ricerca operativa");
insert into insegna (utente_email, insegnamento_nome) values("etm.docentetre@unisa.it","CPSM");
insert into insegna (utente_email, insegnamento_nome) values("etm.docenteuno@unisa.it","Matematica Discreta");
insert into insegna (utente_email, insegnamento_nome) values("etm.docenteuno@unisa.it","Analisi numerica");

insert into PropostaTesi values (1, "etm.docente@unisa.it", "Descrizione primitive crittografiche", 1, "Cifratura", 200, "Bisogna implementare ..", 0, "MMI");
insert into PropostaTesi values (2, "etm.docenteuno@unisa.it", "Descrizione automi docente 1", 0, "Macchine di turing", 100, "Bisogna implementare ..", 0, "ETC");
insert into PropostaTesi values (3, "etm.docentedue@unisa.it", "Visualizzazione delle tecniche di biliardo 2", 0, "Cifratura", 100, "Bisogna implementare ..", 0, "CPSM");
insert into PropostaTesi values (4, "etm.docentetre@unisa.it", "Studio delle cose strane di docente 3", 0, "Funzioni bicurve", 50, "Bisogna implementare ..", 0, "Analisi numerica");
insert into PropostaTesi values (5, "etm.docentequattro@unisa.it", "Descrizione primitive crittografiche docente 4", 0, "Induzione", 200, "Bisogna implementare ..", 0, "Matematica Discreta");
insert into PropostaTesi values (6, "etm.docenteuno@unisa.it", "Cose belle docente 1", 0, "Funzioni quinte", 100, "Bisogna implementare ..", 0, "Analisi");
insert into PropostaTesi values (7, "etm.docenteuno@unisa.it", "Cose più belle delle vecchie1", 0, "Cifratura", 200, "Bisogna implementare ..", 0, "MMI");
insert into PropostaTesi values (8, "etm.docentedue@unisa.it", "Descrizione primitive crittografiche 2", 0, "Cifratura", 10, "Bisogna implementare ..", 0, "MMI");
insert into PropostaTesi values (9, "etm.docentedue@unisa.it", "Finalmente docente 2", 0, "Cifratura", 200, "Bisogna implementare ..", 0, "ETC");
insert into PropostaTesi values (10, "etm.docentetre@unisa.it", "Dopodomani da docente 3", 0, "Cifratura", 200, "Bisogna implementare ..", 0, "MMI");
insert into PropostaTesi values (11, "etm.docentetre@unisa.it", "wow 3 parte 5 docente 3", 0, "Cifratura", 200, "Bisogna implementare ..", 0, "ETC");
insert into PropostaTesi values (12, "etm.docentetre@unisa.it", "crittogra 3", 0, "Cifratura", 200, "Bisogna implementare ..", 0, "MMI");

insert into richiestapartecipazione values(1, "1994/11/02", 1, "etm.utente@studenti.unisa.it");
insert into richiestapartecipazione values(2, "1994/11/02", 2, "etm.utentedue@studenti.unisa.it");
insert into richiestapartecipazione values(3, "1994/11/02", 2, "etm.utentetre@studenti.unisa.it");
insert into richiestapartecipazione values(4, "1994/11/02", 1, "etm.utentequattro@studenti.unisa.it");
insert into richiestapartecipazione values(5, "1994/11/02", 1, "etm.utentecinque@studenti.unisa.it");
insert into richiestapartecipazione values(6, "1994/11/02", 1, "etm.utentesei@studenti.unisa.it");

insert into partecipa values ("etm.utente@studenti.unisa.it", 1);
insert into partecipa values ("etm.utenteuno@studenti.unisa.it", 1);
insert into partecipa values ("etm.utentedue@studenti.unisa.it", 1);
insert into partecipa values ("etm.utentetre@studenti.unisa.it", 1);
insert into partecipa values ("etm.utentequattro@studenti.unisa.it", 2);
insert into partecipa values ("etm.utentecinque@studenti.unisa.it", 2);
insert into partecipa values ("etm.utentesei@studenti.unisa.it", 2);

insert into utentesegueutente values ("etm.utente@studenti.unisa.it", "etm.docentetre@unisa.it", true, true, true);