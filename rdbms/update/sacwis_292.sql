-- All changes for version 2.3 of SHINES

-- Drop Constraint, Rename and Create Table SQL
/
DECLARE 
  
  table_count    NUMBER(5);

BEGIN
  select count(*) into table_count from all_tables where table_name='AFCARS_HISTORY' and owner='CAPS';
  
  IF table_count > 0 THEN
     DBMS_OUTPUT.PUT_LINE(' TABLE COUNT IS  ' || table_count || ' ------');
  ELSE
     DBMS_OUTPUT.PUT_LINE('AFCARS_HISTORY NOT PRESENT - TIME TO CREATE IT');
  
EXECUTE IMMEDIATE 'CREATE TABLE CAPS.AFCARS_HISTORY
(
    ID_PERSON                   NUMBER(16)   NOT NULL,
    ID_AFCARS                   VARCHAR2(12)     NULL,
    DT_LAST_UPDATE              DATE         NOT NULL,
    DT_IDS_UPDATE               DATE             NULL,
    DT_CONVERSION               DATE             NULL,
    CD_AGE_PREV_ADOPT           VARCHAR2(1)      NULL,
    DT_FIRST_REMOVAL            DATE             NULL,
    NBR_REMOVALS                NUMBER(2)        NULL,
    DT_DISCHARGE                DATE             NULL,
    DT_RECENT_REMOVAL_TRANS     DATE             NULL,
    NBR_PLACEMENTS_THIS_EPISODE NUMBER(2)        NULL,
    CONSTRAINT PK_AFCARS_HISTORY
    PRIMARY KEY (ID_PERSON)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE'
;
EXECUTE IMMEDIATE 'COMMENT ON TABLE CAPS.AFCARS_HISTORY IS
''Table used to house additional data used by AFCARS reporting.'' '
;
EXECUTE IMMEDIATE 'COMMENT ON COLUMN CAPS.AFCARS_HISTORY.DT_LAST_UPDATE IS
''Date of insert or last update'' '
;
EXECUTE IMMEDIATE 'GRANT DELETE ON CAPS.AFCARS_HISTORY TO CAPSBAT'
;
EXECUTE IMMEDIATE 'GRANT INSERT ON CAPS.AFCARS_HISTORY TO CAPSBAT'
;
EXECUTE IMMEDIATE 'GRANT SELECT ON CAPS.AFCARS_HISTORY TO CAPSBAT'
;
EXECUTE IMMEDIATE 'GRANT UPDATE ON CAPS.AFCARS_HISTORY TO CAPSBAT'
;
EXECUTE IMMEDIATE 'GRANT DELETE ON CAPS.AFCARS_HISTORY TO CAPSON'
;
EXECUTE IMMEDIATE 'GRANT INSERT ON CAPS.AFCARS_HISTORY TO CAPSON'
;
EXECUTE IMMEDIATE 'GRANT SELECT ON CAPS.AFCARS_HISTORY TO CAPSON'
;
EXECUTE IMMEDIATE 'GRANT UPDATE ON CAPS.AFCARS_HISTORY TO CAPSON'
;
EXECUTE IMMEDIATE 'GRANT SELECT ON CAPS.AFCARS_HISTORY TO OPERATOR'
;

-- Add Referencing Foreign Keys SQL

EXECUTE IMMEDIATE 'ALTER TABLE CAPS.AFCARS_HISTORY 
ADD CONSTRAINT FK_AFCARS_HISTORY_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON_ENC (ID_PERSON)
ENABLE'
;

dbms_utility.compile_schema('CAPS');
dbms_utility.compile_schema('CAPSON');
dbms_utility.compile_schema('CAPSBAT');
dbms_utility.compile_schema('OPERATOR');
dbms_utility.compile_schema('SACWISIFC');

END IF;
END;
/

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_AFCARS_HISTORY
BEFORE UPDATE
ON CAPS.AFCARS_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_AFCARS_HISTORY
BEFORE INSERT
ON CAPS.AFCARS_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- change STGAP00007470
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE IN ('CCPAUTRT',
'CFOSUTRT','CCCIUTRT') AND CODE IN ('50410d','52910d','57610d','60410d')
AND DECODE <> '5000';

-- change STGAP00007498
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CNUMTYPE','UID Tool ID', '*', sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CNUMTYPE','AFCARS ID', '*', sysdate);

-- change STGAP00007500
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60385, 'MSG_FC_PDM_DT_MISSMATCH', 'An approved Regular Foster Care Per Diem, Special Foster Care Per Diem, or Specialized Foster Care Per Diem Exists, but does not cover the start date of the placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60386, 'MSG_RBWO_DT_MISMATCH', 'An approved RBWO or RBWO w. Waiver Per Diem exists, but does not cover the start date of the placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60387, 'MSG_SUB_DT_MISSMATCH', 'An approved Enhanced Relative Care Subsidy, Relative Care Subsidy, Enhanced Subsidized Guardianship, or Subsidized Guardianship payment of care exists, but does not cover the start date of the placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60388, 'MSG_SUB_RSRC_MISSMATCH', 'Resource on the subsidy Payment of Care does not match the placement resource.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60389, 'MSG_PLCMT_CPA_PRGM_REQ', 'A CPA placement requires that the approved payment of care indicate a CPA program.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60390, 'MSG_PLCMT_CCI_PRGM_REQ', 'A CCI type placement requires that the approved payment of care indicate a CCI program.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60391, 'MSG_PLCMT_CTZSHIP_REQ', 'Please enter citizenship status for the child.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60392, 'MSG_PLCMT_RSRC_TYP_INVALID', 'Only resources OF TYPE Home/Other Facility OR MHMR Facility are valid FOR PLACEMENT payments THROUGH this page.  Please confirm THE PLACEMENT TYPE AND CONTACT your RESOURCE maintainer AS appropriate. ', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60393, 'MSG_CHLD_NOT_ELLIGIBLE', 'The child''s current Eligibility is marked ''Not Eligible''. Payments will not be processed for this child until the eligibility record is updated.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60394, 'MSG_CONCUR_POC_REQ', 'Respite Day, Respite Night, or Concurrent placements require a Concurrent Payment of Care.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60395, 'MSG_NO_SVC_IN_HM_CNTRCT', 'The home contract does not have the service needed for this placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60396, 'MSG_NO_SVC_IN_SUB_CNTRCT', 'The subsidy contract does not have the service needed for this placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60397, 'MSG_NO_SVC_IN_FACIL_CNTRCT', 'The facility contract does not have the service needed for this placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60398, 'MSG_CCI_PRGM_CONFIRM', 'The facility is set up for CCI services, but does not service the program indicated on the payment of care.  Please confirm the child''s RBWO program.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60399, 'MSG_CPA_PRGM_CONFIRM', 'The facility is set up for CPA services, but does not service the program indicated on the payment of care.  Please confirm the child''s RBWO program.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60400, 'MSG_RSRC_SVC_NOT_IN_CNTY', 'The resource has the service for this placement, but does not offer it in the county indicated.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60401, 'MSG_CPA_REQ', 'A child placing agency must be indicated in the Agency ID and Name fields when saving and submitting a CPA placement.', 700, 500, 'N');

INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60402, 'MSG_RSRC_PEND_APRV', 'This placement resource is pending or in temporary approval status.  Please ensure that child''s IV-E reimbursability is correct.', 700, 500, 'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (293, 'SacwisRev2', 'static table updates');                        
commit;


