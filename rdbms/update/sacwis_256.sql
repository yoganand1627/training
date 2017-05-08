-- Change STGAP00006298
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
     VALUES (60370, 'MSG_CON_RATE_EXCEEDED','Unit Rate entered cannot exceed the Unit Rate on the Contract.',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (257, 'SacwisRev2', 'static table updates');    
commit;
