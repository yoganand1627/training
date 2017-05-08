--STGAP00015350 - DBCR- per STGAP00015345, remove FTM as a Purpose

--per STGAP00015345, remove FTM as a Purpose on the Contact Detail page.

UPDATE CAPS.codes_tables
SET dt_end = sysdate
WHERE code_type = 'CCNTPURP' AND code = 'FTM';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (534, 'SacwisRev3', 'Release 3.2 - DBCR 15350');

commit;


