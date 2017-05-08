--STGAP00010107 - FA HOME SEARCH: CODES TAB. MESSAGE

UPDATE  CAPS.CODES_TABLES
SET DECODE = 'ICPC Foster'
WHERE CODE_TYPE  = 'CFACATEG'
AND CODE = 'I';

UPDATE  CAPS.CODES_TABLES
SET DT_END = SYSDATE
WHERE CODE_TYPE  = 'CFAHMSTA'
AND CODE = 'PTA';

UPDATE  CAPS.CODES_TABLES
SET DT_END = SYSDATE
WHERE CODE_TYPE  = 'CFAHMSTA'
AND CODE = 'ATA';

INSERT INTO  CAPS.CODES_TABLES (DECODE, CODE_TYPE, CODE)
VALUES ('ICPC Adopt','CFACATEG', 'J');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES (60471, 'MSG_NOT_ADO_USER', 'You do not have privileges to search for anAdoptive home.', 700, 500, 'N');


--STGAP00010110 - Exchange Child Detail - Update Task Table

UPDATE CAPS.TASK
SET TXT_3RD_TAB = 'EXCHANGE_CHILD_EVENTLIST'
WHERE CD_TASK IN ('9530','9531');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (376, 'SacwisRev3', 'Release 3.0 - DBCRs 10107,10110');

-- commit;


