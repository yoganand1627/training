--STGAP00015568 - Release(3.32) MR-058 Update Message

update caps.message
set txt_message = 'The date entered can not be before the Date Review Began.'
where txt_message_name = 'MSG_CSR_NOT_BEFORE_DT_REVIEW';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (590, 'SacwisRev3', 'Release 3.32 - DBCR 15568');

commit;

