

-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_YOUTH_REPORT_DTL
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

-- Standard Alter Table SQL

ALTER TABLE CAPS.CASE_BUDGET_LIMIT DROP (CD_ENTITLEMENT)
;
ALTER TABLE CAPS.CASE_BUDGET_LIMIT RENAME COLUMN CD_UAS TO CD_SVC_CODE
;
ALTER TABLE CAPS.ELIGIBILITY ADD CD_FCE_ELIG_REASON VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.ELIGIBILITY ADD TXT_CHILD_SUPP_REF_COMMENT VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CHILD_RECEIVING_SSI VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_CERT_IND_BLOOD VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_DOC_IMMIG_NAT_ACT VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_SCHOOL_ID_PHOTO VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_CLINIC_DOC_HOS_DOC VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_DAYCARE_NURSE_RCRD VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_AFFIDAVIT_SIGNED VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.PAYMENT_OF_CARE DROP (NBR_PER_DIEM)
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.INITIAL_MEDICAID_APP
(
    ID_EVENT                  NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE            DATE          NOT NULL,
    IND_CHILD_PREGNANCY       VARCHAR2(1)       NULL,
    IND_CHILD_SUPPORT_ORDER   VARCHAR2(1)       NULL,
    IND_MEDICAL_ASST_CHILD    VARCHAR2(1)       NULL,
    TXT_MONTHS                VARCHAR2(50)      NULL,
    DT_EST_DELIVERY_DATE      DATE              NULL,
    IND_CASE_MANAGER_APPLY    VARCHAR2(1)       NULL,
    DT_PROCESSED              DATE              NULL,
    TXT_COMMENTS                  VARCHAR2(300)     NULL,
    IND_HEALTH_INSURANCE_CARD VARCHAR2(1)       NULL,
    CONSTRAINT PK_INITIAL_MEDICAID_APP
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.INITIAL_MEDICAID_APP IS
'Initial Medicaid Eligibility Application'
;
COMMENT ON COLUMN CAPS.INITIAL_MEDICAID_APP.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.INITIAL_MEDICAID_APP TO CAPSBAT
;
GRANT INSERT ON CAPS.INITIAL_MEDICAID_APP TO CAPSBAT
;
GRANT SELECT ON CAPS.INITIAL_MEDICAID_APP TO CAPSBAT
;
GRANT UPDATE ON CAPS.INITIAL_MEDICAID_APP TO CAPSBAT
;
GRANT DELETE ON CAPS.INITIAL_MEDICAID_APP TO CAPSON
;
GRANT INSERT ON CAPS.INITIAL_MEDICAID_APP TO CAPSON
;
GRANT SELECT ON CAPS.INITIAL_MEDICAID_APP TO CAPSON
;
GRANT UPDATE ON CAPS.INITIAL_MEDICAID_APP TO CAPSON
;
GRANT SELECT ON CAPS.INITIAL_MEDICAID_APP TO OPERATOR
;
CREATE TABLE CAPS.SPECIAL_NEEDS_DETERMINATION
(
    ID_EVENT                       NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE                 DATE          NOT NULL,
    CD_REASON_SPECIAL_REQUEST      VARCHAR2(1)       NULL,
    TXT_CMNTS_SPECIAL_REQUEST      VARCHAR2(300)     NULL,
    IND_CHILD_MNT_RETARDED         VARCHAR2(1)       NULL,
    TXT_CMNTS_MNT_RETARDED         VARCHAR2(300)     NULL,
    IND_CHILD_VIS_HEARING_IMPAIRED VARCHAR2(1)       NULL,
    TXT_CMNTS_VIS_HEARING_IMPAIRED VARCHAR2(300)     NULL,
    IND_CHILD_PHYSICALLY_DISABLED  VARCHAR2(1)       NULL,
    TXT_CMNTS_PHYSICALLY_DISABLED  VARCHAR2(300)     NULL,
    IND_CHILD_EMOTIONALLY_DISABLED VARCHAR2(1)       NULL,
    TXT_CMNTS_EMOTIONALLY_DISABLED VARCHAR2(300)     NULL,
    IND_CHILD_OTHER_MEDICAL        VARCHAR2(1)       NULL,
    TXT_CMNTS_OTHER_MEDICAL        VARCHAR2(300)     NULL,
    IND_SPECIALIZED_RATE_REQ       VARCHAR2(1)       NULL,
    IND_DOC_PSYCHOLOGICAL          VARCHAR2(1)       NULL,
    IND_DOC_DEVELOPMENTAL_ASSMT    VARCHAR2(1)       NULL,
    IND_DOC_TRTMNT_PRVDR           VARCHAR2(1)       NULL,
    IND_DOC_MENTAL_ASSMT           VARCHAR2(1)       NULL,
    IND_SPCL_SERVICE_REQ           VARCHAR2(1)       NULL,
    IND_ALL_SPECIAL_DOC_ATTACHED   VARCHAR2(1)       NULL,
    NBR_REQ_AMT                    NUMBER(8,2)       NULL,
    CD_SPCL_SER_TYPE               VARCHAR2(3)       NULL,
    TXT_PLEASE_SPECIFY             VARCHAR2(30)      NULL,
    IND_SPC_NEEDS_APPROVED         VARCHAR2(1)       NULL,
    CD_FUNDING_TYPE                VARCHAR2(3)       NULL,
    IND_APR_TYPE                   VARCHAR2(1)       NULL,
    IND_APPRV_MNT_RETARDED         VARCHAR2(1)       NULL,
    IND_APPRV_HEARING_IMPAIRED    VARCHAR2(1)       NULL,
    IND_APPRV_PHYSICALLY_DISABLED VARCHAR2(1)       NULL,
    IND_APPRV_EMOTIONAL_DIST      VARCHAR2(1)       NULL,
    IND_APPRV_OTHER               VARCHAR2(1)       NULL,
    TXT_APPRV_OTHER_CMT           VARCHAR2(300)     NULL,
    IND_SPCL_REQ_APPROVED          VARCHAR2(1)       NULL,
    CD_APPRV_SPCL_TYPE_FUNDING    VARCHAR2(3)       NULL,
    NBR_APPRV_AMT                  NUMBER(8,2)      NULL,
    DT_APPRV_DATE                  DATE              NULL,
    DT_EXPIRATION_DATE             DATE              NULL,
    TXT_COMMENTS                       VARCHAR2(300)     NULL,
    CONSTRAINT PK_SPECIAL_NEEDS_DET
    PRIMARY KEY (ID_EVENT)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.SPECIAL_NEEDS_DETERMINATION IS
'Table used for Special Needs Determination'
;
COMMENT ON COLUMN CAPS.SPECIAL_NEEDS_DETERMINATION.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSBAT
;
GRANT INSERT ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSBAT
;
GRANT SELECT ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSBAT
;
GRANT UPDATE ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSBAT
;
GRANT DELETE ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSON
;
GRANT INSERT ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSON
;
GRANT SELECT ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSON
;
GRANT UPDATE ON CAPS.SPECIAL_NEEDS_DETERMINATION TO CAPSON
;
GRANT SELECT ON CAPS.SPECIAL_NEEDS_DETERMINATION TO OPERATOR
;
CREATE TABLE CAPS.YOUTH_REPORT_DTL
(
    ID_YOUTH_REPORT_DTL NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE      DATE        NOT NULL,
    ID_PERSON           NUMBER(16)  NOT NULL,
    DT_RPT_PERIOD_END   DATE            NULL,
    DT_DOB              DATE            NULL,
    CD_AGE_CLASS        VARCHAR2(2)     NULL,
    CD_SEX              VARCHAR2(1)     NULL,
    IND_RACE_AA         VARCHAR2(1)     NULL,
    IND_RACE_AN         VARCHAR2(1)     NULL,
    IND_RACE_BK         VARCHAR2(1)     NULL,
    IND_RACE_HP         VARCHAR2(1)     NULL,
    IND_RACE_UD         VARCHAR2(1)     NULL,
    IND_RACE_WT         VARCHAR2(1)     NULL,
    IND_RACE_DECLINED   VARCHAR2(1)     NULL,
    CD_ETHINICITY       VARCHAR2(2)     NULL,
    IND_ETH_DECLINED    VARCHAR2(1)     NULL,
    IND_TRIBAL_MBR      VARCHAR2(1)     NULL,
    IND_ADJ_DELINQUENT  VARCHAR2(1)     NULL,
    CD_LAST_GRADE_COMP  VARCHAR2(2)     NULL,
    IND_SPC_EDU_STAT    VARCHAR2(1)     NULL,
    IND_IL_NEEDS_ASM    VARCHAR2(1)     NULL,
    IND_ACAD_SUPPORT    VARCHAR2(1)     NULL,
    IND_PS_EDU_SUPPORT  VARCHAR2(1)     NULL,
    IND_CAREER_PREP     VARCHAR2(1)     NULL,
    IND_EMP_PROG_VOC    VARCHAR2(1)     NULL,
    IND_BDGT_FIN_MGT    VARCHAR2(1)     NULL,
    IND_HOUSING_EDU     VARCHAR2(1)     NULL,
    IND_HEALTH_EDU      VARCHAR2(1)     NULL,
    IND_FAM_MARR_EDU    VARCHAR2(1)     NULL,
    IND_MENTORING       VARCHAR2(1)     NULL,
    IND_SUPER_IL        VARCHAR2(1)     NULL,
    IND_ROOM_BRD_FIN    VARCHAR2(1)     NULL,
    IND_EDU_FINANCE     VARCHAR2(1)     NULL,
    IND_OTH_FINANCE     VARCHAR2(1)     NULL,
    CD_OUTCOME_RPT_STAT VARCHAR2(2)     NULL,
    DT_OUTCOME_DATE     DATE            NULL,
    IND_FC_STATUS       VARCHAR2(1)     NULL,
    IND_CURR_FT_EMP     VARCHAR2(1)     NULL,
    IND_CFTE_DECLINED   VARCHAR2(1)     NULL,
    IND_CURR_PT_EMP     VARCHAR2(1)     NULL,
    IND_CPTE_DECLINED   VARCHAR2(1)     NULL,
    IND_EMP_SKILLS      VARCHAR2(1)     NULL,
    IND_ERS_DECLINED    VARCHAR2(1)     NULL,
    IND_SOCIAL_SEC      VARCHAR2(1)     NULL,
    IND_SS_DECLINED     VARCHAR2(1)     NULL,
    IND_EDUC_AID        VARCHAR2(1)     NULL,
    IND_EA_DECLINED     VARCHAR2(1)     NULL,
    CD_TANF             VARCHAR2(1)     NULL,
    IND_TANF_DECLINED   VARCHAR2(1)     NULL,
    CD_FOOD_STAMPS      VARCHAR2(1)     NULL,
    IND_FS_DECLINED     VARCHAR2(1)     NULL,
    CD_HOUSING_AST      VARCHAR2(1)     NULL,
    IND_HA_DECLINED     VARCHAR2(1)     NULL,
    IND_OTH_SUPPORT     VARCHAR2(1)     NULL,
    IND_OS_DECLINED     VARCHAR2(1)     NULL,
    CD_HIGH_EDU         VARCHAR2(2)     NULL,
    IND_HEDU_DECLINED   VARCHAR2(1)     NULL,
    IND_CURR_ATD_ENR    VARCHAR2(1)     NULL,
    IND_CAE_DECLINED    VARCHAR2(1)     NULL,
    IND_CONN_ADULT      VARCHAR2(1)     NULL,
    IND_CA_DECLINED     VARCHAR2(1)     NULL,
    IND_MEDICAID        VARCHAR2(1)     NULL,
    IND_MED_DECLINED    VARCHAR2(1)     NULL,
    CD_OTH_HLTH_INS_TYP VARCHAR2(2)     NULL,
    IND_OHIT_DECLINED   VARCHAR2(1)     NULL,
    IND_HOMELESS        VARCHAR2(1)     NULL,
    IND_HOM_DECLINED    VARCHAR2(1)     NULL,
    IND_SUB_ABUSE_REF   VARCHAR2(1)     NULL,
    IND_SAR_DECLINED    VARCHAR2(1)     NULL,
    IND_INCARCERATION   VARCHAR2(1)     NULL,
    IND_INC_DECLINED    VARCHAR2(1)     NULL,
    IND_CHILDREN        VARCHAR2(1)     NULL,
    IND_CHL_DECLINED    VARCHAR2(1)     NULL,
    CD_MARR_AT_BIRTH    VARCHAR2(1)     NULL,
    IND_MAB_DECLINED    VARCHAR2(1)     NULL,
    IND_FOLLOW_UP       VARCHAR2(1)     NULL,
    CONSTRAINT PK_YOUTH_REPORT_DTL
    PRIMARY KEY (ID_YOUTH_REPORT_DTL)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.YOUTH_REPORT_DTL IS
'Each record represents outcome reporting information for a child per reporting period (once a year).'
;
COMMENT ON COLUMN CAPS.YOUTH_REPORT_DTL.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.YOUTH_REPORT_DTL TO CAPSBAT
;
GRANT INSERT ON CAPS.YOUTH_REPORT_DTL TO CAPSBAT
;
GRANT SELECT ON CAPS.YOUTH_REPORT_DTL TO CAPSBAT
;
GRANT UPDATE ON CAPS.YOUTH_REPORT_DTL TO CAPSBAT
;
GRANT DELETE ON CAPS.YOUTH_REPORT_DTL TO CAPSON
;
GRANT INSERT ON CAPS.YOUTH_REPORT_DTL TO CAPSON
;
GRANT SELECT ON CAPS.YOUTH_REPORT_DTL TO CAPSON
;
GRANT UPDATE ON CAPS.YOUTH_REPORT_DTL TO CAPSON
;
GRANT SELECT ON CAPS.YOUTH_REPORT_DTL TO OPERATOR
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_YOUTH_RPT_DTL
    ON CAPS.YOUTH_REPORT_DTL(ID_PERSON)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.INITIAL_MEDICAID_APP 
    ADD CONSTRAINT FK_INIT_MEDICAID_APP_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION 
    ADD CONSTRAINT FK_SPCL_NEEDS_DETRM_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.YOUTH_REPORT_DTL 
    ADD CONSTRAINT FK_YOUTH_RPT_DTL_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_INITIAL_MEDICAID_APP
BEFORE UPDATE
ON CAPS.INITIAL_MEDICAID_APP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_INITIAL_MEDICAID_APP
BEFORE INSERT
ON CAPS.INITIAL_MEDICAID_APP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPECIAL_NEEDS_DETERMIN
BEFORE UPDATE
ON CAPS.SPECIAL_NEEDS_DETERMINATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPECIAL_NEEDS_DETERMIN
BEFORE INSERT
ON CAPS.SPECIAL_NEEDS_DETERMINATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_YOUTH_REPORT_DTL
BEFORE UPDATE
ON CAPS.YOUTH_REPORT_DTL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_YOUTH_REPORT_DTL
BEFORE INSERT
ON CAPS.YOUTH_REPORT_DTL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_YOUTH_REPORT_DTL IS NULL OR :new.ID_YOUTH_REPORT_DTL = 0) THEN
		SELECT	SEQ_YOUTH_REPORT_DTL.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_YOUTH_REPORT_DTL := dummy;
	END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001801
-- The script below updates the Task table with an approval event for the Diversion Conclusion page.

Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('2345', SYSDATE, 'APP', 'DIV', 'CPS', 'CCMN65W', '0', '1', '0', '0', '0', '0', '0', 'Approve Diversion Conclusion', 'CASE_CASESEARCH', 'CASE_MANAGEMENT_CASEMNT', 'DIVERSION_CONCLUSION_DIV_DVRSONCONCLSION', '/investigation/DiversionCnclsn/displayDiversionCnclsn', 0, '0', '0', '1');

-- change STGAP00001810
-- CAGECLSS (Age Class)
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CAGECLSS', '17', '17 and under', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CAGECLSS', '18', '18-19', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CAGECLSS', '20', '20-21', SYSDATE);

-- CEDUCOMP (Last Grade Completed)
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '05', 'Less than 6th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '06', '6th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '07', '7th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '08', '8th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '09', '9th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '10', '10th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '11', '11th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', '12', '12th Grade', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', 'PS', 'Post Secondary Education or Training', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CEDUCOMP', 'CL', 'College, at least one semester', SYSDATE);

-- COUTSTAT (Outcomes Reporting Status)
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'YP', 'Youth Participated', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'YD', 'Youth Declined', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'PD', 'Parent Declined', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'YI', 'Youth Incapacitated', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'IN', 'Incarcerated', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'RM', 'Runaway/Missing', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'UL', 'Unable to Locate/Invite', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('COUTSTAT', 'DE', 'Death', SYSDATE);

-- CHLTHINS (Other Health Insurance Type)
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'MD', 'Medical Only', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'MM', 'Medical and Mental', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'MP', 'Medical and Prescription', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'MR', 'Medical, Mental, and Prescription', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'NO', 'No', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CHLTHINS', 'NA', 'N/A', SYSDATE);

-- change STGAP00001811
DELETE FROM CAPS.CODES_TABLES WHERE code_type = 'OTH' 
AND code = '81';
DELETE FROM CAPS.CODES_TABLES WHERE code_type = 'OTH' 
AND code = '2';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (141, 'SacwisRev2', 'static updates, schema changes');
commit;                         