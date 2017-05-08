--STGAP00015886 - Release(3.44) MR-62: Update contact creation days codes table

UPDATE CAPS.CODES_TABLES SET DECODE =  '-1' WHERE CODE_TYPE = 'PMCNTCTS' AND CODE = 'DAYS';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (812, 'SacwisRev3', 'Release 3.44 - DBCR 15886');

commit;


