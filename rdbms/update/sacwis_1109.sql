--STGAP00017119 - Release(5.0) update codes_tables vals

update caps.codes_tables
set code = '3'
where code_type = 'EBD1'
and code = '03';

update caps.codes_tables
set code = '7'
where code_type = 'EBD1'
and code = '07';

update caps.codes_tables
set code = '8'
where code_type = 'EXB1'
and code = '08';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1110, 'SacwisRev5', 'Release 5.0 - DBCR 17119');

commit;
