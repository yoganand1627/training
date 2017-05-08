--STGAP00015935 - Release(3.6) MR-066 Message update for questions required

update caps.message set TXT_MESSAGE = 'Foster Parent notification regarding an advocate and State Office notification regarding removal of children are required for Maltreatment in Care.'
where TXT_MESSAGE_NAME = 'MSG_INV_SPCL_NOTIFICATION';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (852, 'SacwisRev3', 'Release 3.6 - DBCR 15935');

commit;



