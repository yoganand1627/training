--STGAP00015798 - Release(3.5) MR-061:  New Message

--I need a new message for MR-061.  Please note that I have not included the NBR_MESSAGE.



INSERT INTO CAPS.MESSAGE (dt_last_update,NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
VALUES ( sysdate,60683,'MSG_SVC_TOO_MANY_CONTACTS_FOUND', 'Too many results are included in the search criteria.  Please narrow your search criteria to generate the Log of Contact Narratives.', 700, 500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (750, 'SacwisRev3', 'Release 3.5 - DBCR 15798');


 
commit;
 
