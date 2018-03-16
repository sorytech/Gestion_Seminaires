--####################################### CREATION DES TRIGGERS : GESTION SEMINAIRE #############################
--################################### CREATION DU TRIGGER NOMBRE DE SEMINAIRE PAR JOUR  #########################
Create or replace trigger NbrSeminairePossibleParJour
Before insert on LesReservations
For each row
Declare
	NbDisponible integer;
	NbPlaceReserve integer;
Begin
	select nbplacespossibles into NbDisponible from LesRepresentations 
	where dateRep=:new.dateRep and numS=:new.numS;
	select sum(nbplaces) into NbPlaceReserve from LesReservations where dateRep=:new.dateRep and numS=:new.numS;
	If NbDisponible - NbPlaceReserve < :new.nbplaces 
		then raise_application_error(-20100,'Impossible, Plus de place disponible'); end if;
end;
/ 
