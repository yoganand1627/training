--STGAP00014829 - Update Decode for CLHECOT

UPDATE CAPS.CODES_TABLES SET DECODE = 'TPR - Mother' where CODE_TYPE = 'CLHECOT' AND CODE = 'TPM';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (510, 'SacwisRev3', 'Release 3.2 - DBCR 14829');

commit;


