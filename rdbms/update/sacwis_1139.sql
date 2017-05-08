--STGAP00017218 - Release(5.0) update codes table value

update caps.codes_tables
set decode = 'Other Medically Diagnosed Conditions Requiring Special Care(Specify)'
where code_type = 'MED1'
and code = '90';

update caps.codes_tables
set decode = 'Spina Bifida'
where code_type = 'MED2'
and code = '75';

update caps.codes_tables
set decode = 'Spina Bifida'
where code_type = 'MED1'
and code = '75';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1140, 'SacwisRev5', 'Release 5.0 - DBCR 17218');

commit;
