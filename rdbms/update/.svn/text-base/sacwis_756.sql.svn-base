--STGAP00015805 - Release(3.5) SMS #44052: Insert a new message

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60684,
   'MSG_SPEC_SVC_ADO_PAD',
   'Special Services are only available for use in the ADO and PAD stages', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (757, 'SacwisRev3', 'Release 3.5 - DBCR 15805');

commit;

