--STGAP00016144 - Release(4.3) MR-087 Update new code and add additional code

-- MR-087 Update new code and add additional code
UPDATE caps.codes_tables
SET code = 'RG'
WHERE code_type = 'CEXDOCCD'
AND decode = 'Relative Care Subsidy Application and Agreement';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CEXDOTYP', 'RG', 'Relative Care Subsidy Application and Agreement');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1020, 'SacwisRev4', 'Release 4.3 - DBCR 16144');

commit;

