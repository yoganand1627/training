--STGAP00015766 - Release(3.5) per CAPTA - end date NT in CSEVERTY


UPDATE CAPS.codes_tables
SET dt_end = sysdate
WHERE code_type = 'CSEVERTY' AND code = 'NT';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (730, 'SacwisRev3', 'Release 3.5 - DBCR 15766');



commit;
 
