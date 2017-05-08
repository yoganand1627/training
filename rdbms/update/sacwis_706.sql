--STGAP00015732 - Release(3.5) MR-057 Update to codes table

update caps.codes_tables set decode = ' Adoption (03)' where code = 'ADA' and code_type = 'CPERMPLN';

update caps.codes_tables set decode = ' Guardianship (06)' where code = 'GDS' and code_type = 'CPERMPLN';

update caps.codes_tables set decode = ' Live with Fit and Willing Relatives (02)' where code = 'LLR' and code_type = 'CPERMPLN';

update caps.codes_tables set decode = ' Reunification (01)' where code = 'RUI' and code_type = 'CPERMPLN';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (707, 'SacwisRev3', 'Release 3.5 - DBCR 15732');

commit;

