--STGAP00017080 - Release(5.0) create message

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE,
CD_PRESENTATION, IND_BATCH) Values (60912, SYSDATE, 'MSG_NO_CHARS',
'There are no characteristics exhibited by the children currently placed in the home.', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1096, 'SacwisRev5', 'Release 5.0 - DBCR 17080');

commit;
