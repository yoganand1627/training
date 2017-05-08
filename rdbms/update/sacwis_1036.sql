--STGAP00016155 - Release(4.3) Add new message

update caps.message
set txt_message = 'For %s, Please enter a date in the format MM/DD/YYYY.'
where txt_message_name = 'MSG_REC_CONSTR_DATE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1037, 'SacwisRev4', 'Release 4.3 - DBCR 16155');

commit;


