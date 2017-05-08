--STGAP00015410 - Updates to CODES_TABLES

--Updates to Code_Type CEXDOTYP

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Non-DFCS Notes'
WHERE CODE = 'VO' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'TPR Petition'
WHERE CODE = 'TP' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Other Legal Documents'
WHERE CODE = 'LD' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Dental Report'
WHERE CODE = 'DE' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DT_END = '09/18/2009'
WHERE CODE = 'RC' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DT_END = '09/18/2009'
WHERE CODE = 'RS' AND CODE_TYPE = 'CEXDOTYP';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Physical Evidence'
WHERE CODE = 'PI' AND CODE_TYPE = 'CEXDOTYP';

DELETE FROM CAPS.CODES_TABLES
WHERE CODE = 'PE' AND CODE_TYPE = 'CEXDOTYP';


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (548, 'SacwisRev3', 'Release Undetermined - DBCR 15410');

commit;
