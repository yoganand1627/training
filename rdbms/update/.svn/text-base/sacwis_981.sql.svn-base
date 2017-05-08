--STGAP00016098 - Release(4.2) MR-075 Correcting new decodes value

-- MR-075 Correcting new decodes value
-- STGAP00016098

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Pending Unapproved'
WHERE CODE = 'PUN'
and CODE_TYPE = 'CFAHMSTA';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Special Approval 30 Day Grace'
WHERE CODE = 'FSG'
and CODE_TYPE = 'CFAHMSTA';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Pending Special Approval 30 Day Grace'
WHERE CODE = 'PSG'
and CODE_TYPE = 'CFAHMSTA';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Full Approval 30 Day Grace'
WHERE CODE = 'FLG'
and CODE_TYPE = 'CFAHMSTA';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Pending Full Approval 30 Day Grace'
WHERE CODE = 'PFG'
and CODE_TYPE = 'CFAHMSTA';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Tuberculosis (TB)'
WHERE CODE = 'PTB'
and CODE_TYPE = 'CARSAPPT';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (982, 'SacwisRev4', 'Release 4.2 - DBCR 16098');

commit;

