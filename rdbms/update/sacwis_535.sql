--STGAP00014833 - MR-036 Need to add date last prebill dates to serv

UPDATE CAPS.SVC_AUTH_DETAIL 
SET DT_SA_LAST_PREBILL = TRUNC(TO_DATE(SYSDATE), 'MONTH');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (536, 'SacwisRev3', 'Release 3.2 - DBCR 14833');

commit;


