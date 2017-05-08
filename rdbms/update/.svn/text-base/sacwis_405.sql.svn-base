--STGAP00011357 - Need to end date Barrier to recruitment Code

--Note:  new messages no impact to ado model

UPDATE caps.CODES_TABLES SET DT_END = SYSDATE WHERE CODE_TYPE = 'CADBREC' AND 
CODE='RFA';


--STGAP00011373 - MR-ADO - Correct UAS values to match COSTAR Manual

--Note:  new messages no impact to ado model

-- Remove 51277 and 51257 since these are Purchase of Service and are no longer used

UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CENTCODE' AND CODE='77';

UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CENTCODE' AND CODE='57';

-- Remove these, since they no longer exist in the COSTAR manual

UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CSVCCODE' AND CODE IN('51033d', '51033e', '51033f');

-- Update the description on these to match COSTAR manual and AA Agreement/Application
UPDATE CAPS.CODES_TABLES SET DECODE='51033a - Adoption Related Legal Fees' WHERE CODE='51033a' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51033b - Physicals for Adoptive Parents' WHERE CODE='51033b' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51033c - Travel/Lodging' WHERE CODE='51033c' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51258a - Medical' WHERE CODE='51258a' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51258b - Therapy/Counseling' WHERE CODE='51258b' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51258c - Dental/Orthodontics' WHERE CODE='51258c' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51258d - Other' WHERE CODE='51258d' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='51217 - Child Care' WHERE CODE='51217' AND CODE_TYPE='CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='58 - Special Services Adoption Assistance - Medical, Therapy, Etc.' WHERE CODE='58' AND CODE_TYPE='CENTCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='60 - Special Services Adoption Assistance - Respite Care' WHERE CODE='60' AND CODE_TYPE='CENTCODE';

UPDATE CAPS.CODES_TABLES SET DECODE='17 - Child Care' WHERE CODE='17' AND CODE_TYPE='CENTCODE';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (406, 'SacwisRev3', 'Release 3.0 - DBCRs 11357,11373');

commit;


