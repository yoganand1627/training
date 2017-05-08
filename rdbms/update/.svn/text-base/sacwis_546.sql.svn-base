--STGAP00015400 - Update to correct DECODE value for CEXDOTYP

--Update to correct DECODE value for Code_Type CEXDOTYP

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Auto Insurance'
WHERE CODE = 'AI' AND CODE_TYPE = 'CEXDOTYP';

insert into caps.schema_version (id_schema_version, application_version, comments)
            values (547, 'SacwisRev3', 'Release Undetermined - DBCR 15400');

commit;

