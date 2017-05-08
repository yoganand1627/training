--STGAP00016079 - Update TCM Denial Code Description

-- Correction of STGAP00016069
-- Decode in wrong format
-- Currently displays in application as "MEMBER COVERED BY PRIVATE INSURANCE"
-- Should be "0465 - MEMBER COVERED BY PRIVATE INSURANCE"


UPDATE 	CAPS.CODES_TABLES CT
SET	CT.DECODE = '0465 - MEMBER COVERED BY PRIVATE INSURANCE'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '0465';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (967, 'SacwisRev4', 'Release 4.1 - DBCR 16079');

commit;


