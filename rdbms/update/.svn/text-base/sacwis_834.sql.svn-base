--STGAP00015912 - Release(3.6) Changing verbiage for system informational message

update caps.message set txt_message = 'External Documentation can not be added on the same day as the stage closure, if it is added after the closure' where TXT_MESSAGE_NAME = 'MSG_EXT_DOC_CLOSURE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (835, 'SacwisRev3', 'Release 3.6 - DBCR 15912');

commit;


