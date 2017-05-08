-- Release 2.5 

-- change STGAP00009267 
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'Start date of the Safety Resource Placement cannot overlap the end date of the previous Safety Resource placement for child %s.'
WHERE NBR_MESSAGE = 60431;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'End date of the Safety Resource Placement cannot overlap the Start date of the next Safety Resource placement for child %s.'
WHERE NBR_MESSAGE = 60432;

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'End Date cannot be after the Custody removal date for child %s.'
WHERE NBR_MESSAGE = 60434;

-- change STGAP00009274
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, 
CD_STAGE_PROG_RSN_CLOSE, 
CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, 
CD_STAGE_PROG_EVENT_TYPE, 
CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('SUB', 'DJJ', 'CPS', '0', 'STG', 'COMP', 'Foster Care Child Stage Closed');

-- change STGAP00009275 
UPDATE CAPS.CODES_TABLES SET DECODE = SUBSTR(DECODE,1,1)||LOWER(SUBSTR(DECODE,2))
WHERE CODE_TYPE = 'CCOUNT';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Ben Hill'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = '017';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Jeff Davis'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = '161';

UPDATE CAPS.CODES_TABLES SET DECODE = 'McDuffie'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = '189';

UPDATE CAPS.CODES_TABLES SET DECODE = 'McIntosh'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = '191';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Out of State'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = '999';

UPDATE CAPS.CODES_TABLES SET DECODE = '-None-'
WHERE CODE_TYPE = 'CCOUNT' AND CODE = 'XXX';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (343, 'SacwisRev2', 'static table updates');                        
commit;
