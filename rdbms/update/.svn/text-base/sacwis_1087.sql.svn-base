--STGAP00017071 - Release(5.0) create new messages for contract period

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values (60904, SYSDATE, 'MSG_ACTIVE_NO_END_DT', 'When the status of the Period is Active, the end date must be in the future.', 500, 700, 'N');

Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
Values (60905, SYSDATE, 'MSG_NEW_PERIOD', 'You are creating a new contract period. Continue?', 500, 700, 'N');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1088, 'SacwisRev5', 'Release 5.0 - DBCR 17071');

commit;
