--STGAP00015437 - Update to CODES_TABLES

--Updates to Code_Type CEXDOTYP

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Foster/Adoptive Home Approvals'
WHERE CODE = 'FC' AND CODE_TYPE = 'CEXDOTYP';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (551, 'SacwisRev3', 'Release Undetermined - DBCR 15437');

commit;


