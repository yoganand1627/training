--STGAP00015860 - Release(3.5) SMS #46734: Insert a new message

--Message 1

Insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (SYSDATE, 60728,
   'MSG_CON_NO_ACTIVE_SERVICE',
   'The contract for this resource does not have the service specified.', 700, 500, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (795, 'SacwisRev3', 'Release 3.5 - DBCR 15860');


commit;


