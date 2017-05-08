--STGAP00015994 - Release(4.0) MR-67 Update message wording

--MR-67 Update message wording

UPDATE caps.message
SET txt_message = 'Your survey will close within %ld days. Please complete by %s.'
WHERE txt_message_name = 'MSG_SURVEY_EST_CLOSE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (899, 'SacwisRev4', 'Release 4.0 - DBCR 15994');

commit;

