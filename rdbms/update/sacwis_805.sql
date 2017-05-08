--STGAP00015873 - Release(3.5) CAPTA Additional messages for admin review

--New message for admin review

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60735,
   'MSG_ARI_LEVEL_REQ',
   'Administrative Review Level Field is required. Please enter a value.', 700, 500, 'N');


Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60736,
   'MSG_ARI_FIRST_LEVEL_DES',
   'A first level ARI stage has been indicated.  Please de-select the ''No 1st Level ARI Stage'' checkbox', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (806, 'SacwisRev3', 'Release 3.5 - DBCR 15873');

commit;



