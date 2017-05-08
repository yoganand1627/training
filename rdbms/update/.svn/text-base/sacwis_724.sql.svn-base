--STGAP00015758 - Release(3.5) CAPTA: Insert new message

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60666,
   'MSG_ASSIGN_UNASSIGN_DATE_FUTURE',
   'Date assigned or unassigned should not be greater than the current date', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (725, 'SacwisRev3', 'Release 3.5 - DBCR 15758');

commit;



