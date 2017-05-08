--STGAP00012138 - Insert Missing Code for Special Needs Mapping

--Note:  no impact to ado model


--Per defect STGAP00011876, the following code was unintentionally left out

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CADOOMD', '105', 'Rheumatic Fever, Heart Disease, Heart Murmur', NULL,SYSDATE);

--STGAP00012152 - Updated required training hours for Nov and Dec

--Note:

--no impact to ado model


--Reason
---------
--This defect is needed for resolution of defect STGAP00010494

-- The required training hours for homes approved in November and December  is 10,
-- but the homes have until December 31 of the following year to complete the training.  
-- Therefore these home are not required to complete any training hours in the year 
-- they are  approved.  But  these homes are allowed to complete training hours in November 
-- and December after their approval. In these cases to avoid confusion in displaying 
-- the amount of remaining hours in the current year,  the CODES_TABLE need to set the 
-- the amount of required hours to 10 for November and December.

UPDATE CAPS.CODES_TABLES
  SET DECODE='10'
   WHERE CODE_TYPE = 'CFAYRTRN'
     AND (CODE = '11'
        OR CODE = '12');


--STGAP00012189 - Add single quote to a label in CODES_TABLES

--Note:  no impact to ado model


UPDATE caps.CODES_TABLES
SET  DECODE = 'Wednesday''s Child'
WHERE CODE_TYPE = 'CADRACS' AND CODE = 'WED';


--STGAP00012192 - Modify Label for State Funded AA (Ado Asst App)

--Note: no impact to ado model

UPDATE caps.CODES_TABLES
SET  DECODE = 'State Funded Adoption Assistance (UAS Code 508)'
WHERE CODE_TYPE = 'CAAFDTYP' AND CODE = 'PST';


--STGAP00012204 - Correct invalid characters in static tables

update caps.codes_tables set decode=replace(decode,chr(191)) where
instr(decode,chr(191)) <> 0;

update caps.message set txt_message=replace(txt_message,chr(191))
where instr(txt_message,chr(191)) <> 0;

update caps.message set txt_message_name=replace(txt_message_name,chr(191))
where instr(txt_message_name,chr(191)) <> 0;

update caps.risk_factors_lookup 
set AREA_CONCERN_TXT=replace(AREA_CONCERN_TXT,chr(191))
where instr(AREA_CONCERN_TXT,chr(191)) <> 0;

-- STGAP00012206 - new entries for stage progression
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('ADO', 'VSR', 'CPS', '0', 'STG', 'COMP', 'Adoption Stage Closed');

update caps.task set IND_TASK_CODE_PREFER = 0, IND_TASK_NEW_CASE_TODO_ENABLE = 0, IND_TASK_FORCE_EVENT_LINK = 0, IND_STAGE_CLOSURE = 0 where CD_TASK in ('9071', '9075');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (427, 'SacwisRev3', 'Release 3.0 - DBCRs 12138,12152,12189,12192,12204');

commit;

