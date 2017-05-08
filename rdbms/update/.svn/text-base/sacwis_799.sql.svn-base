--STGAP00015865 - Release(3.43) MR-62: Update contact creation date codes table


UPDATE CAPS.CODES_TABLES SET DECODE =  '04/01/2010' WHERE CODE_TYPE = 'PMCNTCTS' AND CODE = 'DEPDATE';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (800, 'SacwisRev3', 'Release 3.43 - DBCR 15865');

commit;


