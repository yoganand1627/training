--STGAP00015815 - Release(3.43) MR-62: Update Task codes for Contact Standard

--Need to update the event type to 'CSS' from 'PCS'

UPDATE caps.TASK set CD_TASK_EVENT_TYPE = 'CSS' WHERE CD_TASK IN ('6540', '7025');

UPDATE caps.TASK set IND_TASK_CODE_PREFER = '3' WHERE CD_TASK IN ('6540', '7025');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (766, 'SacwisRev3', 'Release 3.43 - DBCR 15815');

commit;


