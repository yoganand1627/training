--STGAP00016103 - Release(4.1) Modify codes tables to reflect the new TCM decode

--TCM Denial Codes had definitions that were too long and stretched out the drop-down menu
--beyond the page borders. This data fix is to shorten the decode with new wording provided
--by the client

UPDATE  CAPS.CODES_TABLES CT
SET     CT.DECODE = '2665 - A CONFLICT EXISTS BETWEEN THE AID CATEGORY'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '2665';

UPDATE  CAPS.CODES_TABLES CT
SET     CT.DECODE = '6386 - CASE MANAGEMENT CLAIM CANT BE BILLED SAME CALENDAR MONTH AS PAID'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '6386';

UPDATE  CAPS.CODES_TABLES CT
SET     CT.DECODE = '9955 - PRICING ADJUSTMENT CALCULATED ALLOWED AMOUNT GREATER THAN BILLED AMOUNT'
WHERE CT.CODE_TYPE = 'CTCMDEN' AND CODE = '9955';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (987, 'SacwisRev4', 'Release 4.1 - DBCR 16103');

commit;

