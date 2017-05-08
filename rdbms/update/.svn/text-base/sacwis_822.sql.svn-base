--STGAP00015899 - Release(3.6) SMS #50286: insert a new message

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60747,
   'MSG_CON_STDS_NO_CHILDREN',
   'This Contact Standard cannot be saved because no children were found to be applicable.  Please exit the page and verify the Person List if this is incorrect.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (823, 'SacwisRev3', 'Release 3.6 - DBCR 15899');

commit;

