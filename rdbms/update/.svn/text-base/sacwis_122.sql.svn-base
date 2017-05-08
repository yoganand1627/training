
-- Standard Alter Table SQL

ALTER TABLE CAPS.CAPS_RESOURCE MODIFY(TXT_RSRC_ADDR_CMNTS  VARCHAR2(300))
;
ALTER TABLE CAPS.RESOURCE_ADDRESS MODIFY(TXT_RSRC_ADDR_COMMENTS  VARCHAR2(300))
;
ALTER TABLE CAPS.RESOURCE_HISTORY MODIFY(TXT_RSHS_ADDR_CMNTS  VARCHAR2(300))
;
ALTER TABLE CAPS.RESOURCE_HISTORY_AUDIT MODIFY(TXT_RSHS_AUD_ADDR_CMNTS  VARCHAR2(300))
;
ALTER TABLE CAPS.RESOURCE_PHONE MODIFY(TXT_RSRC_PHONE_COMMENTS  VARCHAR2(300))
;

-- Drop Referencing Constraint SQL

ALTER TABLE CAPS.NEEDS_OUTCOMES_DETAIL DROP CONSTRAINT FK_NEEDS_OUTS_DET_NO
;

-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.NEEDS_OUTCOMES DROP CONSTRAINT FK_NEEDS_OUTS_EVENT
;
ALTER TABLE CAPS.NEEDS_OUTCOMES DROP CONSTRAINT FK_NEEDS_OUTS_RESOURCE
;
ALTER TABLE CAPS.NEEDS_OUTCOMES DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.NEEDS_OUTCOMES RENAME TO NEEDS_OUTC_01112007203745000
;
CREATE TABLE CAPS.NEEDS_OUTCOMES
(
    ID_EVENT           NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE     DATE          NOT NULL,
    NM_AGENCY          VARCHAR2(30)      NULL,
    ID_RESOURCE        NUMBER(16)        NULL,
    NM_ASSESSOR        VARCHAR2(20)      NULL,
    TXT_ASSESSOR_TITLE VARCHAR2(30)      NULL,
    DT_REFERRAL        DATE              NULL,
    DT_ASST_CMPLT      DATE              NULL,
    TXT_GEN_REC        VARCHAR2(300)     NULL,
    TXT_PLCMT_REC      VARCHAR2(300)     NULL,
    TXT_CCFA_REC       VARCHAR2(300)     NULL,
    IND_CCFA_AGENCY    VARCHAR2(1)       NULL,
    IND_CCFA_EDU_ASSMT VARCHAR2(1)       NULL,
    TXT_CCFA_EDU_ASSMT VARCHAR2(300)     NULL,
    DT_CCFA_EDU_ASSMT  DATE              NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.NEEDS_OUTCOMES IS
'Holds the Needs and Outcomes Data'
;
COMMENT ON COLUMN CAPS.NEEDS_OUTCOMES.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.NEEDS_OUTCOMES TO CAPSBAT
;
GRANT INSERT ON CAPS.NEEDS_OUTCOMES TO CAPSBAT
;
GRANT SELECT ON CAPS.NEEDS_OUTCOMES TO CAPSBAT
;
GRANT UPDATE ON CAPS.NEEDS_OUTCOMES TO CAPSBAT
;
GRANT DELETE ON CAPS.NEEDS_OUTCOMES TO CAPSON
;
GRANT INSERT ON CAPS.NEEDS_OUTCOMES TO CAPSON
;
GRANT SELECT ON CAPS.NEEDS_OUTCOMES TO CAPSON
;
GRANT UPDATE ON CAPS.NEEDS_OUTCOMES TO CAPSON
;
GRANT SELECT ON CAPS.NEEDS_OUTCOMES TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.NEEDS_OUTCOMES(
                                ID_EVENT,
                                DT_LAST_UPDATE,
                                NM_AGENCY,
                                ID_RESOURCE,
                                NM_ASSESSOR,
                                TXT_ASSESSOR_TITLE,
                                DT_REFERRAL,
                                DT_ASST_CMPLT,
                                TXT_GEN_REC,
                                TXT_PLCMT_REC,
                                TXT_CCFA_REC,
                                IND_CCFA_AGENCY,
                                IND_CCFA_EDU_ASSMT,
                                TXT_CCFA_EDU_ASSMT,
                                DT_CCFA_EDU_ASSMT
                               )
                         SELECT 
                                ID_EVENT,
                                DT_LAST_UPDATE,
                                NM_AGENCY,
                                ID_RESOURCE,
                                SUBSTR(NM_ASSESSOR, 1, 20),
                                TXT_ASSESSOR_TITLE,
                                DT_REFERRAL,
                                DT_ASST_CMPLT,
                                TXT_GEN_REC,
                                TXT_PLCMT_REC,
                                TXT_CCFA_REC,
                                IND_CCFA_AGENCY,
                                IND_CCFA_EDU_ASSMT,
                                TXT_CCFA_EDU_ASSMT,
                                DT_CCFA_EDU_ASSMT
                           FROM CAPS.NEEDS_OUTC_01112007203745000 
;
COMMIT
;
ALTER TABLE CAPS.NEEDS_OUTCOMES LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.NEEDS_OUTCOMES ADD CONSTRAINT PK_NEEDS_OUTCOMES
PRIMARY KEY (ID_EVENT)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;


-- Add Dependencies SQL
/
DROP TRIGGER CAPS.TIBR_NEEDS_OUTCOMES
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_NEEDS_OUTCOMES
BEFORE INSERT
ON CAPS.NEEDS_OUTCOMES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
DROP TRIGGER CAPS.TUBR_NEEDS_OUTCOMES
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_NEEDS_OUTCOMES
BEFORE UPDATE
ON CAPS.NEEDS_OUTCOMES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/


-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.NEEDS_OUTCOMES_DETAIL ADD CONSTRAINT FK_NEEDS_OUTS_DET_NO
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.NEEDS_OUTCOMES (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD CONSTRAINT FK_NEEDS_OUTS_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.NEEDS_OUTCOMES ADD CONSTRAINT FK_NEEDS_OUTS_RESOURCE
FOREIGN KEY (ID_RESOURCE)
REFERENCES CAPS.CAPS_RESOURCE (ID_RESOURCE)
ENABLE
;

DROP TABLE CAPS.NEEDS_OUTC_01112007203745000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

commit;

-- change 298
INSERT INTO CAPS.CODES_TABLES VALUES ('CSTAGES', 'DIV', 'Diversion', NULL, SYSDATE); 

-- change 299
UPDATE CAPS.STAGE_PROG SET CD_STAGE_PROG_RSN_CLOSE = 'SUB' WHERE CD_STAGE_PROG_PROGRAM = 'CPS' 
AND CD_STAGE_PROG_OPEN = 'ADO' AND CD_STAGE_PROG_STAGE = 'SUB'; 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('INT', 'SNM', 'CPS', '1', 'SUB', 'STG', 'COMP', 'Intake Stage Closed'); 

INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('DIV', 'DIV', 'CPS', '1', 'DIV', 'STG', 'Diversion Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('SUB', 'SNM', 'CPS', '1', 'SUB', 'STG', 'Foster Care Child Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('SUB', 'SUB', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('SUB', 'ADO', 'CPS', '0', 'SUB', 'STG', 'COMP', 'Foster Care Child Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('FSU', 'FSU', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Family Care Stage Opened');
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('FSU', 'FSU', 'CPS', '0', 'FPR', 'STG', 'COMP', 'Family Preservation Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN) 
VALUES ('FPR', 'FPR', 'CPS', '0', 'PFC'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN) 
VALUES ('FPR', 'FSU', 'CPS', '0', 'FPR'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN) 
VALUES ('PFC', 'SUB', 'CPS', '0', 'PFC'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('PFC', 'FSU', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS, 
TXT_STAGE_PROG_EVNT_DESC) 
VALUES ('PFC', 'FPR', 'CPS', '0', 'PFC', 'STG', 'COMP', 'Post Foster Care Stage Opened'); 
INSERT INTO CAPS.STAGE_PROG(CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM, 
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN) 
VALUES ('ADO', 'ADO', 'CPS', '0', 'SUB'); 

-- request 300
UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'This child is already in Foster Care Family.' 
WHERE NBR_MESSAGE = '8069'; 

UPDATE CAPS.MESSAGE SET TXT_MESSAGE = 'A PFC Stage already exists for this child.', 
TXT_MESSAGE_NAME = 'MSG_PFC_STAGE_EXISTS' WHERE NBR_MESSAGE = '8419'; 

-- request 301
UPDATE CAPS.CODES_TABLES 
SET DECODE='Best Interest/Contrary To The Welfare Of The Child' 
WHERE code_type='CCRTLANG' 
AND code='CWC'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Reasonable Efforts Were Made To Prevent Removal' 
WHERE code_type='CCRTLANG' 
AND code='RPR'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Reasonable Efforts Were Made To Finalize Permanency Plan' 
WHERE code_type='CCRTLANG' 
AND code='RFP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Reasonable Efforts Were Made To Reunify Child and Family [For Pre-3/27/00 Only]' 
WHERE code_type='CCRTLANG' 
AND code='RCF'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE='Reasonable Efforts Were Not Required' 
WHERE code_type='CCRTLANG' 
AND code='RNN';

-- request 302
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60094, 'MSG_REA_EFF_COMP' 
,'Reasonable efforts are required to complete the Child Detail.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60095, 'MSG_DIL_SEAR_COMP' 
,'You must record if the Diligent Search was completed in 90 days to complete the Child Detail.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60096, 'MSG_DIL_COMP_REQ' 
,'Enter the Diligent Search Completion Date.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60097, 'MSG_CHILD_ADJ_COMP' 
,'Enter the Diligent Search Completion Date.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60098, 'MSG_NOT_ADJ_REASON' 
,'Explanation of why the child is adjusting in care is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60099, 'MSG_ASFA_DETAILS' 
,'Details are required when ASFA conditions exist.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60100, 'MSG_TPR_DEC_REQ' 
,'Whether or not DFCS will file TPR must be entered when a Non Reunification flag condition exists.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60101, 'MSG_TPR_DATE_REQ' 
,'Please enter the date DFCS will file for TPR.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60102, 'MSG_TPR_NO_EXPL_REQ' 
,'Non reunification condition exists, explain why DFCS will not file TPR.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60103, 'MSG_IMMU_DATE_COMP' 
,'Record if immunizations are up to date.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60104, 'MSG_IMMU_DATE_EXP_REQ' 
,'If immunizations are not up to date, an explanation is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60105, 'MSG_IMMU_REC_COMP' 
,'Record if the immunization record is on file.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60106, 'MSG_IMMU_REC_EXP_REQ' 
,'If the immunization record is not on file, explanation is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60107, 'MSG_ONG_MED_PROB_COMP' 
,'Record if there are ongoing medical or psychological problems.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60108, 'MSG_ONG_MED_PROB_EXP_REQ' 
,'If there are ongoing medical or psychological problems, explanation is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60109, 'MSG_MED_REC_COMP' 
,'Record if the medical record is on file.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60110, 'MSG_MED_REC_EXP_REQ' 
,'If the medical record is not on file, explanation is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60111, 'MSG_PSY_REC_COMP' 
,'Record if the psychological record is on file.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60112, 'MSG_PSY_REC_EXP_REQ' 
,'If the psychological record is not on file, explanation is required.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60113, 'MSG_ONG_TREAT_COMP' 
,'Record if the child is receiving ongoing medical or psychological treatment.',500,700); 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60114, 'MSG_ONG_TREAT_FILE' 
,'Record if the ongoing medical treatment is documented in the case record.',500,700); 

-- request 304
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','501','501 - IV-E Family Foster Care',SYSDATE); 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','502','502 - State Family Foster Care',SYSDATE); 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','503','503 - Initial Family Foster Care',SYSDATE); 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','504','504 - State Related Family Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','522','522 - State CW Family Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','550','550 - Non-Relative Subsidized Guardianship and Enhanced Subsidized Guardianship',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','529','529 - Undocumented Immigrant Children in Family Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','560','560 - IV-E Voluntary Family Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','505','505 - IV-E Institutional Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','506','506 - State Child Welfare - Institutional Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','507','507 - Initial TANF Institutional Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','530','530 - State undocumented Immigrant Children in IFC',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','561','561 - IV-E Voluntary Institutional Foster Care (CCI)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','563','563 - Iv-E Privately Supervised Family Foster Care (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','564','564 - IV-B Privately Supervised Family Foster Care (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','565','565 - Initial Privately Supervised Family Foster Care (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','574','574 - Specialized Foster Care - State Approved Per Diem Waivers',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','575','575 - IV-E Voluntary Specialized Foster Care - State Approve Per Diem Waivers',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','577','577 - IV-B Child Welfare Specialized Foster Care - State Approve Per Diem Waivers',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','579','579 - Initial Child Welfare Specialized Foster Care - State Approve Per Diem Waivers',SYSDATE); 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','595','595 - CCI Parental Custody/Purchased Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','596','596 - CPA Parental Custody/Purchased Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','604','604 - State Related Foster Care Expenses',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','605','605 - IV-E Institutional Foster Care (CCI)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','606','606 - State CW - Intuitional Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','607','607 - Initial Institutional Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','608','608 - IV-E Voluntary Institutional Foster Care (CCI)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','609','609 - IV-E Privately Supervised FFC (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','610','610 - State Privately Supervised FFC (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','611','611 - Initial TANF Privately Supervised FFC (CPA)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','513','513 - Return of Runaways',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','511','511 - Comprehensive child and Family assessment',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','518','518 - CCFA Wrap Around Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','520','520 - Respite Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','521','521 - PUP',SYSDATE)  ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','525','525 - Medical Exams and Records',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','531','531 - Foster/Adoptive Parent Support Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','547','547 - Emergency Foster Care Beds',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','551','551 - Early Intervention and Prevention Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','571','571 - Homestead Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','573','573 - Parent Aide Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','576','576 - State Related Specialized Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','578','578 - State Child Welfare Related Specialized Foster Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','588','588 - Family Services (CPPC)',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','597','597 - Wraparound Parental Custody',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','598','598 - Wraparound DFCS Custody',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','698','698 - Emergency/ Disasters',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','773','773 - PSSF - Crisis Intervention',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','774','774 - PSSF - Family Support Services',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','783','783 - PSSF - Time Limited Reunification',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','784','784 - PSSF - Adoption Promotion',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','873','873 - PSSF - C/M Crisis Intervention',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','874','874 - PSSF - C/M Family Support',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','883','883 - PSSF- C/M Time Limited Reunification',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','884','884 - PSSF - C/M  Adoption Promotion',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','542','542 - Enhanced Relative Care',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','552','552 - Subsidized Guardianship and Enhanced Subsidized Guardianship',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','553','553 - Relative Care Subsidy RCS',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','508','508 - State Adoption Assistance',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','509','509 - IV-E Adoption Assistance',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','510','510 - Adoption Related State Expenses',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','512','512 - Special Services Adoption Assistance',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','587','587 - Adoption Incentives - Second Grant',SYSDATE)  ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','583','583 - College Related Expenses',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','584','584 - College/Vocational Related Expenses',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','585','585 - Educational and Enrichment Expenses',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','586','586 - Transitional Living Program',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','591','591 - Education and Training Voucher',SYSDATE)  ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','252','252 - Children Restricted Funds',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','253','253 - Donated Restricted Funds',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','450','450 - County Funds - Foster Care Children under age 14',SYSDATE) ; 
insert into caps.codes_tables(code_type,code,decode,dt_last_update) values('CPRGAREA','460','460 - County Funds - Foster Care Children 14 and over',SYSDATE) ; 

-- change 305
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60115, 'MSG_SEC_PERM_CON_REQ', 'Court plan type must be concurrent to save a Secondary Permanency Plan.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60116, 'MSG_NO_PAR_PART_EXPL', 'Explain why there is no parental participation in this development of this case plan.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60117, 'MSG_HEAR_DATE_REQ', 'Please record the date the hearing was requested.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60118, 'MSG_AFTERCARE_DUR', 'Aftercare duration is greater than one year.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60119, 'MSG_GOAL_TYPE_EXISTS', 'The selected Goal already exists in the Goal list.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60120, 'MSG_CHILD_COMP_SUBMIT', 'All children on the plan must have completed Child Details before the case plan can be submitted for Approval.', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60121, 'MSG_WTLP_APRV_SUBMIT', 'Latest WTLP must be approved before the case plan can be submitted for Approval.', 500, 700, 'N');

-- change 306
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CCTPLNTY','REU', 'Reunification', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CCTPLNTY','NRE', 'Nonreunification', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CCTPLNTY','CON','Concurrent', SYSDATE);

insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','RUI','Reunification (01)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','LLR','Live with Fit and Living Relatives (02)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','ADA','Adoption (03)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','FCO','Another Planned Permanent Living Arrangement Through Long Term Foster Care (04)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','LAE','Another Planned Permanent Living Arrangement Through Emancipation (05)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','GDS','Guardianship (06)', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CPERMPLN','NOS','Non Selected (07)', SYSDATE); 

insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CREVWTYP','JDR','Judicial Review', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CREVWTYP','PCR','Panel Case Review', SYSDATE);
insert into CAPS.CODES_TABLES (code_type, code, decode, dt_last_update) VALUES ('CREVWTYP','JCR','Judicial Citizen Review', SYSDATE);

-- change 309
INSERT INTO CAPS.METAPHOR(ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_FILTER_PATH,DT_LAST_UPDATE) 
 VALUES(1490,'/fce/ThirdPartyHealthInsurance/displayThirdPartyHealthInsurance' 
,'THIRD_PARTY_HEALTH_INSURANCE_DETAIL_THIRDPARTYHEALTHINSURANCEDETAIL' 
,'Health Insurance' 
,'gov.georgia.dhr.dfcs.sacwis.web.metaphor.FCEAppDetailPagesShowTab' 
,SYSDATE);

-- change 310
UPDATE CAPS.METAPHOR 
SET  TXT_TAB = 'Redetermination' 
WHERE ID_TAB = '560';

-- change 311
UPDATE CAPS.METAPHOR 
SET TXT_TAB = 'Deprivation' 
WHERE ID_TAB = '420';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (123, 'SacwisRev2', 'static updates, updates to CAPS_RESOURCE and NEEDS_OUTCOMES');

commit;