--STGAP00015493 - DBCR - Per STGAP00012977 End Date ADI in CCLOSADO


UPDATE CAPS.codes_tables 
SET dt_end = sysdate
WHERE code_type = 'CCLOSADO' AND code = 'ADI';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (568, 'SacwisRev3', 'Release Undetermined - DBCR 15493');

--commit;
