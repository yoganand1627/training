--STGAP00016062 - Release(4.1) MR-053 Update CFCERNE codes table message

-- MR-053 Remove quotes from decode

Update caps.codes_tables
set decode = 'Reasonable Efforts determination was not made within 60 days.'
where code_type = 'CFCERNE'
and code = 'A09';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (954, 'SacwisRev4', 'Release 4.1 - DBCR 16062');

commit;

