--####################################### CREATION DES TRIGGERS : GESTION SEMINAIRE #############################

--################################### CREATION DU TRIGGER NOMBRE DE SEMINAIRE PAR JOUR  #########################
Create or replace trigger NbSeminairePossibleParJour
Before insert on SEMINAIRE
For each row
Declare
	NbSeminaire integer;
Begin
	select count(*) into NbSeminaire from SEMINAIRE where dateSem = :new.dateSem group by dateSem;
	If (NbSeminaire >=3) then raise_application_error(-20100,'IMPOSSIBLE D ORGANISER PLUS DE 3 SEMINAIRE PAR JOUR'); end if;
	exception 
	WHEN NO_DATA_FOUND then DBMS_OUTPUT.PUT_LINE('OK');
end;
/

--################################### INCRIPTION IMPOSSIBLE A UNE SEMAINE DU SEMINAIRE #########################
Create or replace trigger GestionInscription
Before delete or update or insert on inscription
For each row
Declare
     dateSeminaire Date;
Begin
	select dateSem into dateSeminaire from Seminaire where idSem = :new.idsem;
	If (sysdate + 7 >= dateSeminaire )
		then raise_application_error(-20100,'INCRIPTION IMPOSSIBLE A UNE SEMAINE DU SEMINAIRE'); end if;
	exception 
	WHEN NO_DATA_FOUND then DBMS_OUTPUT.PUT_LINE('OK');
end;
/ 


--################################### IMPOSSIBLE DE FAIRE PLUSIEURS SEMINAIRES DANS UNE MEME SALLE A LA MEME DATE ET PERIODE #########################
Create or replace trigger GestionSalle
Before  update or insert on seminaire
For each row
Declare
     NB integer;
Begin
	select count(*) into NB from seminaire where idPrest = :new.idPrest and numSalle = :new.numSalle and dateSem = :new.dateSem and duree = :new.duree;
	If (NB > 0)
		then raise_application_error(-20100,'IL Y A DEJA UN SEMINAIRE DANS CETTE SALLE'); end if;
	exception 
	WHEN NO_DATA_FOUND then DBMS_OUTPUT.PUT_LINE('OK');
end;
/ 


--###################### INCRIPTION IMPOSSIBLE SI LE NOMBRE MAXIMUM DE PARTICIPANT EST ATTEINT #################

/*Create or replace trigger AnnulerInscriptionNombreMaxAtteint
Before update or insert on inscription
For each row
Declare
     NbrePartSeminaire integer;
Begin
	select count(*) into NbrePartSeminaire from inscription where etat='confirme' and idSem=:new.idSem group by idSem;
	If (NbrePartSeminaire = nbMaxPart )
		then raise_application_error(-20100,'INCRIPTION IMPOSSIBLE, LE NOMBRE MAXIMUM DE PARTICIPANT EST ATTEINT'); end if;
end;
/ */


--###################IMPOSSIBLE POUR UN ANIMATEUR D'ORGANISER 2 SEMINAIRES A LA MEME DATE ET A LA MEME PERIODE #####################
Create or replace trigger GestionAnimateur
Before update or insert on seminaire
For each row
Declare
idAnimateur integer;
Begin
select count(idAnim) into idAnimateur from seminaire where dateSem =:new.dateSem and duree =:new.duree;
if(idAnimateur > 1)
    then raise_application_error(-20100,'IMOSSIBLE D ORGANISER 2 SEMINAIRES EN MEME TEMPS'); end if;
end;
/ 
