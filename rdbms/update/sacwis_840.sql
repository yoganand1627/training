--STGAP00015921 - Release(3.6) MR-066 Change the codes table for Operated dropdow

update caps.codes_tables set decode = 'Other/Specialty' where code_type = 'CERTIFBY' and code = 'TH';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (841, 'SacwisRev3', 'Release 3.6 - DBCR 15921');

commit;


