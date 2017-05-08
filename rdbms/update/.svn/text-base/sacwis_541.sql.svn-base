--STGAP00015367 - Updates to CODES_TABLES

--Updates to correct DECODE values for Code Types CEXDOCAI and CEXDOCCL

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Other Adoption Asst'
WHERE CODE = 'XA' AND CODE_TYPE = 'CEXDOCAI';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Court Order - TPR'
WHERE CODE = 'OT' AND CODE_TYPE = 'CEXDOCCL';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Court Order - Other'
WHERE CODE = 'OX' AND CODE_TYPE = 'CEXDOCCL';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Court Order - Custody'
WHERE CODE = 'OC' AND CODE_TYPE = 'CEXDOCCL';


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (542, 'SacwisRev3', 'Release Undetermined - DBCR 15367');

commit;


