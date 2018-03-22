--############################## DROP TABLE IN DATABASE #####################################
DROP TABLE conference;
DROP TABLE inscription;
DROP TABLE seminaire;
DROP TABLE salle;
DROP TABLE prestataire;
DROP TABLE conferencier;
DROP TABLE participant;
DROP TABLE animateur;



--################################ CREATION DE LA TABLE ANIMATEUR ###########################
create table animateur(idAnim number(3) primary key, 
						nomA varchar2(45) not null,
						prenomA varchar2(45) not null,
						adrA varchar2(45) not null,
						telA number(10) not null, 
						emailA varchar2(45) not null);


--############################### CREATION DE LA TABLE PARTICIPANT ##########################
create table participant(idPart number(3) primary key,
						nomP varchar2(45) not null,
						prenomP varchar2(45) not null,
						adrP varchar2(45) not null,
						telP number(10) not null, 
						emailP varchar2(45) not null);


--############################### CREATION DE LA TABLE CONFERENCIER #########################
create table conferencier(idConf number (3) primary key,
						 idAnim number (3),
						 nomC varchar2(45) not null,
						 prenomC varchar2(45) not null,
						 adrC varchar2(45) not null,
						 telC number(10) not null, 
						 emailC varchar2(45) not null,
						 constraint c_c1 foreign key (idAnim) references animateur(idAnim));


--############################### CREATION DE LA TABLE PRESTATAIRE ##########################
create table prestataire(idPrest number(3) primary key,
						 nomP varchar2(45) not null,
						 adrP varchar2(45) not null,
						 telP number(10) not null, 
						 emailP varchar2(45) not null,
						 tarifRepas NUMBER(7,2),
						 tarifPause NUMBER(7,2) ,
						 constraint prest_c1 check (tarifRepas > 0),
						 constraint prest_c2 check (tarifPause > 0) );


--################################## CREATION DE LA TABLE SALLE #############################
create table salle(numSalle number(3), 
					idPrest number(3),
					tarifSalle NUMBER(7,2) not null,
					constraint salle_pk primary key (numSalle, idPrest),
					constraint salle_fk1 foreign key (idPrest) references prestataire(idPrest),
					constraint salle_fk2 check (tarifSalle > 0) );


--################################ CREATION DE LA TABLE SEMINAIRE ###########################
create table seminaire(idSem number(3) primary key,
						idAnim number (3),
						idPrest number (3),
						numSalle number(3),
						theme varchar2(45) not null,
						nbMaxPart integer not null,
						tarif NUMBER(7,2) not null, 
						duree varchar2(10) check (duree in ('MATIN','APRES-MIDI','JOURNEE')),
						dateSem date,
						constraint sem_fk1 foreign key (idAnim) references animateur(idAnim),
						constraint sem_fk2 foreign key (numSalle,idPrest) references salle(numSalle,idPrest),
						constraint sem_fk3 check (nbMaxPart > 0),
						constraint sem_fk4 check (tarif > 0) );


--############################### CREATION DE LA TABLE INSCRIPTION ##########################
create table inscription(idPart number(3) references participant(idPart),
						 idSem number(3) references seminaire(idSem),
						 dateIns date ,
						 etat varchar2(8)  check (etat in ('confirme','attente','desister')),
						 constraint insc_c1 primary key (idPart, idSem),
						 constraint insc_c2 foreign key (idPart) references participant(idpart),
						 constraint insc_c3 foreign key (idSem) references seminaire(idSem) );


--################################ CREATION DE LA TABLE CONFERENCE ###########################
create table conference( idConf number (3),
						 idSem number(3),
						 titreConf varchar(45) not null,
						 supports varchar2(100),
						 montant NUMBER(7,2) not null,
						 activites varchar2(100),
						 constraint conf_c1 primary key (idConf, idSem),
						 constraint conf_c2 foreign key (idConf) references conferencier(idConf),
						 constraint conf_c3 foreign key (idSem) references seminaire(idSem),
						 constraint conf_c4 check (montant > 0) );

