-- Release 2.5 

-- change STGAP00009314
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CCLOSFCC', 'ICC', 'ICPC - Child Not Placed');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CCLOSFCC', 'ICN', 'ICPC - Supervision No Longer Needed');

-- change STGAP00009315
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES ('CCNTPURP', 'COI', 'Courtesy Interview');

-- change STGAP00009317
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, 
CD_STAGE_PROG_RSN_CLOSE, 
CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, 
CD_STAGE_PROG_EVENT_TYPE, 
CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('SUB', 'ICC', 'CPS', '0', 'STG', 'COMP', 'Foster Care Child Stage Closed');

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, 
CD_STAGE_PROG_RSN_CLOSE, 
CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, 
CD_STAGE_PROG_EVENT_TYPE, 
CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('SUB', 'ICN', 'CPS', '0', 'STG', 'COMP', 'Foster Care Child Stage Closed');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (346, 'SacwisRev2', 'static table updates');                        
commit;
