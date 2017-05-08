--STGAP00016043 - Release(4.1) MR-074 AFCARS Phase 1 Update MESSAGE

-- STGAP00016043
-- MR-074 AFCARS Phase 1 Update MESSAGE

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Group Home is no longer a placement type option. Please select Child Care Institution instead.'
WHERE TXT_MESSAGE_NAME = 'MSG_PLCMT_GROUP_HOME_ERR'
and NBR_MESSAGE = '60813';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (935, 'SacwisRev4', 'Release 4.1 - DBCR 16043');

commit;

