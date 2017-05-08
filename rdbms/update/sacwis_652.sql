--STGAP00015661- Adding new message for Safety Assessment

--Adding new message to prevent users from adding Safety Assessment with all principals marked as 'No' 
--for the question on person detail " Member of Primary Caretaker's Household"


INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) VALUES (60642, 'MSG_NO_PK_HH_MBR', 'A Safety Assessment can not be added because ''No'' has been selected for Member of Primary Caretaker''s Household on Person Detail for all principals', 500, 700,'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (653, 'SacwisRev3', 'Release 3.5 - DBCR 15661');

commit;

