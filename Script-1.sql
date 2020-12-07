SELECT * FROM DATAUSERS ;
CREATE TABLE DataAdmin (login varchar(20) NOT NULL , MDP varchar(20) NOT NULL );
INSERT INTO DATAadmin values ('admin','admin');
SELECT * FROM DataAdmin;
COMMIT ;
CREATE TABLE avion ( NoAvion NUMBER(5) PRIMARY KEY NOT NULL,Companie Varchar(10) NOT NULL , NbPlace number(4) NOT NULL );
INSERT INTO avion ( 1,'Bwing','100' );
INSERT INTO avion values ( 1,'Bwing','100');
CREATE TABLE vol ( NoVol NUMBER(5) PRIMARY KEY NOT NULL , VilleDepart Varchar(10) NOT NULL ,VilleArrivee Varchar(10) NOT NULL , DateDepart DATE NOT NULL , duree NUMBER NOT null) ;
INSERT INTO vol VALUES (1,'tanger','casa','2020-7-1',40 );
INSERT INTO vol VALUES (1,'tanger','casa', DATE '2020-01-10',40 );

select villeArrivee from vol;
ALTER TABLE vol ADD (heureDepart);
ALTER TABLE vol ADD (heureDepart Time NOT null);
SELECT * FROM VOL ;
SELECT * FROM avion;
INSERT INTO AVION VALUES (2,"Bwing",'108');
INSERT INTO avion values ( 2,'Bwing','108');
INSERT INTO avion values ( 3,'Emirates','108');
ALTER TABLE DATAUSERS ADD ( passport varchar(10) , nom varchar(10) ,prenom varchar(10) , adresse varchar(10));
SELECT * FROM DATAUSERS ;
UPDATE DATAUSERS SET PASSPORT ='PassePNo1', NOM ='EL OUAHABI' , PRENOM ='Reda' ,ADRESSE ='Taida-Larache' WHERE LOGIN ='reda';
ALTER TABLE DATAUSERS MODIFY ( passport varchar(20) ,adresse varchar(20));
ALTER TABLE DATAUSERS ADD PRIMARY KEY (passport);
UPDATE DATAUSERS SET PASSPORT ='PassePNo2', NOM ='MOUKRIM' , PRENOM ='Hamza' ,ADRESSE ='kalaat sraghna' WHERE LOGIN ='hamza';
ALTER TABLE DATAADMIN DROP MDP not NULL;
INSERT INTO dataadmin VALUES('a','a');
ALTER TABLE vol ADD PRIMARY KEY (NOVOL);
UPDATE VOL SET DATEDEPART ='2020-01-10 12:12:12' WHERE NOVOL =1;
--can't ACCESS TO time IN DATE depart 
UPDATE VOL SET DATEDEPART =TO_DATE('12:12:12','hh24:mm:ss')  WHERE NOVOL =1;
ALTER TABLE vol MODIFY datedepart DATE DEFAULT sysdate;
SELECT * FROM VOL ;
ALTER TABLE vol ADD NoAvion number(10);
UPDATE vol SET NoAvion=1 WHERE novol=1;
UPDATE vol SET NoAvion=2 WHERE novol=2;
ALTER TABLE vol DROP COLUMN datedepart;
ALTER TABLE vol DROP COLUMN heureDepart;
ALTER TABLE vol DROP COLUMN heurearriveé;
ALTER TABLE vol ADD heuredepart DATE  DEFAULT to_date('01-01-2020','dd-mm-yyyy');
UPDATE VOL SET HEUREDEPART =TO_DATE('12:12:12','hh24:mm:ss')  WHERE NOVOL =1;

UPDATE VOL SET HEUREDEPART =TO_DATE('12:00:00','hh24:mi:ss')  WHERE NOVOL =1;
UPDATE VOL SET HEUREDEPART =TO_DATE('12:00:00','hh24:Mi:SS')  WHERE NOVOL =2;
SELECT EXTRACT(MINUTE FROM heuredepart) FROM vol;
--i find that it is a little difficult do handle the time with oracle ,
-- especialy hour and minute , so i'm thinking to use numbers with arethmetic operations ;
--so my decision is to change time data type frome date to numbers ;
--date depart =date d'arrivee et il va apparaitre que dans le billet [comme les train ,meme vol chaque jour ]
--heure d'arrivee se calcule automatiquement dans l'insertion du vol

ALTER TABLE vol DROP COLUMN heureDepart;
--j'ai creer la classe Time hh24min pour la manipulation de temps sous format hh24:mi avec une entree String ;
ALTER TABLE vol ADD  heureDeDepart Varchar(10);--On va travailler avec Heure de depart et non pas heure depart
ALTER TABLE vol ADD  heureDepart Varchar(10);
ALTER TABLE vol ADD  heurearrivee Varchar(10);
UPDATE vol SET HEUREDéPART ='12:00' WHERE NOVOL =1;
UPDATE vol SET HEUREDéPART ='10:00' WHERE NOVOL =3;
UPDATE vol SET heurearrivee ='12:40' WHERE NOVOL =1;
UPDATE vol SET heurearrivee ='10:50' WHERE NOVOL =3;
COMMIT;
ALTER TABLE vol ADD  heureDeDepart Varchar(10);
COMMIT;
SELECT * FROM VOL ;
ALTER TABLE vol DROP COLUMN duree;
ALTER TABLE vol ADD  dureé Varchar(10);
SELECT * FROM VOL ;
UPDATE vol SET dureé ='00:40' WHERE NOVOL =1;
UPDATE vol SET dureé ='00:40' WHERE NOVOL =2;
ALTER TABLE vol RENAME COLUMN HEUREDedEPART TO HeureDépart;
ALTER TABLE vol RENAME COLUMN  heurearrivee TO HeureArrivée;
ALTER TABLE vol RENAME COLUMN dureé TO durée;
DELETE FROM vol WHERE NOVOL =3;
SELECT * FROM avion ;
select count(*) from vol where novol=9;
 alter table vol drop CONSTRAINT villedepart not null;
 ALTER TABLE vol ADD  Tarif number(7);
ALTER TABLE vol DROP COLUMN tarif;--le projet ne damande pas les prix .. 
CREATE TABLE Billet (NOBillet NUMBER(7),DateReservation Varchar(15),DateVoyage Varchar(15) ,HeureDepart Varchar(10) , HeureArrivee Varchar(10),Siege Varchar(10), NoPlace NUMBER(3));
 SELECT NoPlace,NOBILLET ,DATERESERVATION ,ETAT ,SIEGE ,DATEVOYAGE ,VILLEDEPART ,VILLEARRIVEE ,HEUREDEPART ,HEUREARRIVEE FROM billet;
 ALTER TABLE billet ADD VilleDepart Varchar(10);
  ALTER TABLE billet ADD VilleArrivee Varchar(10);
  ALTER TABLE billet ADD etat Varchar(10);
  ALTER TABLE billet MODIFY datereservation Varchar(30);
   ALTER TABLE billet MODIFY Siege Varchar(30);
   ALTER TABLE billet MODIFY etat Varchar(15);
   ALTER TABLE billet DROP COLUMN NoPlace;
   ALTER TABLE billet ADD NoPlace NUMBER(3);
   Select count(*) From billet where NoPlace=1;
   Select NoPlace From billet where NoPlace=1;
   DELETE FROM BILLET WHERE NOBILLET =1;
   DELETE FROM BILLET WHERE NOBILLET =2;
   ALTER TABLE billet MODIFY NoBillet NUMBER(30);
      DELETE FROM BILLET WHERE etat ='non Validé';
      UPDATE billet SET etat ='validé' WHERE Nobillet =174144317;
      SELECT * FROM billet ;