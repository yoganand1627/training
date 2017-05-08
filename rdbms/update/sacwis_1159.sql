--STGAP00017535 - Release(5.0) Updating message text

-- Updating Child Search Message

UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Child Search - No child found with the given Person Id.'
Where txt_message_name = 'MSG_NO_CHILD_FOUND';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1160, 'SacwisRev5', 'Release 5.0 - DBCR 17535');

commit;
