--STGAP00016020 - Release(4.1) MR-053 Add new fields & codes and update messages.

-- MR-053 Eligibility DBCR Add new fields & codes and update messages

-- Add new columns to FCE_ELIBILITY
ALTER TABLE CAPS.FCE_ELIGIBILITY
ADD ( CD_VERIF_METHOD VARCHAR2(3),
      CD_VERIF_DOC_TYPE VARCHAR(3),
      IND_RECV_100_PCT_VA VARCHAR2(1),
      IND_RECV_RR_RSDI VARCHAR2(1),
      ID_PRN_EARNER NUMBER(16,0),
      IND_PE_RECV_UNEMP VARCHAR2(1),
      IND_PE_NOT_ACPT_EMP_TRN VARCHAR2(1),
      IND_PE_WRK_ENG_EDU_TRN VARCHAR2(1)
    );

COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_VERIF_METHOD IS 'Code representing verfication method of parent disability or incapacity.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.CD_VERIF_DOC_TYPE IS 'Code representing type of documentation used for verification of parent disability or incapacity.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_RECV_100_PCT_VA IS 'Indicates that disabled/inpacitated parent is receiving 100% Veteran''s Disability compensation.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_RECV_RR_RSDI IS 'Indicates that disabled/inpacitated parent is receiving RSDI or Railroad Retirement based on a disability.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.ID_PRN_EARNER IS 'Id person of the parent who is the Principal Earner for household.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PE_RECV_UNEMP IS 'Indicates that the Principal Earner is receiving Unemployment Compensation.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PE_NOT_ACPT_EMP_TRN IS 'Indicates that the Principal Earner failed to accept employment or education training 30 consecutive days prior to removal.';
COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.IND_PE_WRK_ENG_EDU_TRN IS 'Indicates that the Principal Earner has worked or engaged in educational training activities.';

-- Add new columns to FCE_APPLICATION
ALTER TABLE CAPS.FCE_APPLICATION
ADD ( DT_REMOVAL_DATE DATE,
      IND_SPECIFIED_RELATIVE VARCHAR2(1)
    );

COMMENT ON COLUMN CAPS.FCE_APPLICATION.DT_REMOVAL_DATE IS 'Most recent custody removal date at the time of application.';
COMMENT ON COLUMN CAPS.FCE_APPLICATION.IND_SPECIFIED_RELATIVE IS 'Indicates that the other relative whom child last lived with prior to removal meet criteria as a specified relative.';



-- Update messages
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'You have indicated that the other parent''s absence was due to employment outside the community or active military duty. In this situation, complete the section for Living with Both Legal or Biological Parents.'
WHERE NBR_MESSAGE = 55161
AND TXT_MESSAGE_NAME = 'MSG_LIVING_MILITARY_ABSENCE';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'You must specify the Applicant''s living arrangements at the time of removal.'
WHERE NBR_MESSAGE = 25400
AND TXT_MESSAGE_NAME = 'MSG_SPCFY_LVG_ARRGMNT';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'The person you have selected as the other relative the child last lived with prior to removal must be listed as living in the home of removal on the List of Principals.'
WHERE NBR_MESSAGE = 25416
AND TXT_MESSAGE_NAME = 'MSG_NOT_LIVING_AT_HOME';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'You have indicated both legal or biological parents are now living together.  Please complete the section.'
WHERE NBR_MESSAGE = 25183
AND TXT_MESSAGE_NAME = 'MSG_BOTH_TGTH';

UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'This child does not have a current Foster Care Eligibility Application.  Foster Care Reimbursability Determination is not available until an Application has been completed for this child.'
WHERE NBR_MESSAGE = 25493
AND TXT_MESSAGE_NAME = 'MSG_NO_APPLICATION_REVIEW_NOT_AVAILABLE';

-- Add new code type to CODES_TABLES
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CVERMETH', 'D', 'Documentation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CVERMETH', 'M', 'Medical Evidence');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CVERMETH', 'O', 'Observation');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CDOCTYPE', 'RR', 'Railroad Retirement');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CDOCTYPE', 'RS', 'RSDI');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CDOCTYPE', 'SS', 'SSI');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CDOCTYPE', 'VA', 'Veteran''s Disability');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE)
VALUES ('CDOCTYPE', 'WC', 'Worker''s Compensation');

-- Update decode in CODES_TABLES
UPDATE CAPS.CODES_TABLES
SET DECODE = 'Both Legal or Biological Parents'
WHERE CODE_TYPE = 'CFCELIV'
AND CODE = 'B';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Both Legal or Biological Parents'
WHERE CODE_TYPE = 'CFCELIV6'
AND CODE = 'B';

UPDATE CAPS.CODES_TABLES
SET DECODE = 'Other Relative'
WHERE CODE_TYPE = 'CFCELIV6'
AND CODE = 'R';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (916, 'SacwisRev4', 'Release 4.1 - DBCR 16020');

commit;




