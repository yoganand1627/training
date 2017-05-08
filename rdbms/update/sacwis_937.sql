--STGAP00016046 - Release(4.1) MR-074 AFCARS Phase 1 Update CODES_TABLES

-- MR-074 AFCARS Phase 1 Update CODES_TABLES
-- End-date the 'Group Home'

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE
WHERE CODE_TYPE = 'CPLMNTYP'
AND CODE = 'GRH';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (938, 'SacwisRev4', 'Release 4.1 - DBCR 16046');

commit;


