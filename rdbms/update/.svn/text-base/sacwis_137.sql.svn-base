
/
declare
	contact_constraint varchar2(30);
	ddl_statement varchar2(255);
begin
      SELECT constraint_name INTO contact_constraint FROM dba_constraints WHERE owner='CAPS' AND constraint_type='R'
      AND table_name='CONTACT' AND generated='GENERATED NAME';
      ddl_statement := 'ALTER TABLE CAPS.CONTACT DROP CONSTRAINT ' || contact_constraint; 
      dbms_utility.exec_ddl_statement(ddl_statement);

commit;
end;
/

-- ALTER TABLE CAPS.CONTACT DROP CONSTRAINT SYS_C0013562;

ALTER TABLE CAPS.CONTACT_CBX DROP PRIMARY KEY DROP INDEX
;
/
declare
	contact_cbx_constraint varchar2(30);
	ddl_statement_cbx varchar2(255);
begin
      SELECT constraint_name INTO contact_cbx_constraint FROM dba_constraints WHERE owner='CAPS' AND constraint_type='R'
      AND table_name='CONTACT_CBX' AND generated='GENERATED NAME';
      ddl_statement_cbx := 'ALTER TABLE CAPS.CONTACT_CBX DROP CONSTRAINT ' || contact_cbx_constraint;
      dbms_utility.exec_ddl_statement(ddl_statement_cbx);
commit;
end;
/

-- ALTER TABLE CAPS.CONTACT_CBX DROP CONSTRAINT SYS_C0013560;

ALTER TABLE CAPS.CONTACT_CBX ADD CONSTRAINT PK_CONTACT_CBX
PRIMARY KEY (ID_CONTACT_CBX)
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
ALTER TABLE CAPS.FCE_APPLICATION ADD DT_LEGAL_DOCS_SENT_ES DATE     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_GROSS_INCOME_CEILING_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_STD_OF_NEED_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_DEP_CARE_DEDUC_CHILD NUMBER(16,2)     NULL
;

-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_EXAM_DETAIL
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
CREATE SEQUENCE CAPS.SEQ_FCE_IVE_INCOME_LIMIT
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;


-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.YOUTH_DETAIL DROP CONSTRAINT FK_YOUTH_DETAIL_PERSON
;
ALTER TABLE CAPS.YOUTH_DETAIL DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.YOUTH_DETAIL RENAME TO YOUTH_DETA_03202007231200000
;
CREATE TABLE CAPS.YOUTH_DETAIL
(
    ID_PERSON             NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE        DATE          NOT NULL,
    ADDR_GED_ADDR_1       VARCHAR2(30)      NULL,
    ADDR_GED_ADDR_2       VARCHAR2(30)      NULL,
    ADDR_GED_ADDR_CITY    VARCHAR2(20)      NULL,
    ADDR_GED_ADDR_STATE   VARCHAR2(2)       NULL,
    ADDR_GED_ADDR_ZIP     VARCHAR2(10)      NULL,
    CD_ACAD_TRACK         VARCHAR2(3)       NULL,
    CD_CLASSIF            VARCHAR2(3)       NULL,
    CD_EDU_GOAL           VARCHAR2(3)       NULL,
    CD_PAR_STAT           VARCHAR2(3)       NULL,
    DT_EMNC_DISC          DATE              NULL,
    DT_GED_EXP_PROG_COMP  DATE              NULL,
    DT_GED_PROG_COMP      DATE              NULL,
    DT_SCH_GRAD           DATE              NULL,
    DT_POST_EXP_GRAD      DATE              NULL,
    DT_POST_GRAD          DATE              NULL,
    IND_EMP_SVC           VARCHAR2(1)       NULL,
    IND_GED_PROG          VARCHAR2(1)       NULL,
    IND_HEALTH_SVC        VARCHAR2(1)       NULL,
    IND_LIFE_SKILLS       VARCHAR2(1)       NULL,
    IND_SCH_GRAD          VARCHAR2(1)       NULL,
    NBR_GED_FAX           VARCHAR2(10)      NULL,
    NBR_GED_PHONE         VARCHAR2(10)      NULL,
    NBR_POST_CUMM_GPA     NUMBER(6,3)       NULL,
    NBR_POST_CURR_GPA     NUMBER(6,3)       NULL,
    NBR_POST_REQ_CRED     NUMBER(4)         NULL,
    NBR_POST_REQ_EAR      NUMBER(4)         NULL,
    NBR_SCH_CREDIT_EARNED NUMBER(4)         NULL,
    NBR_SCH_CREDIT_REQD   NUMBER(4)         NULL,
    NBR_SCH_CURR_GPA      NUMBER(6,3)       NULL,
    NBR_SCH_CUM_GPA       NUMBER(6,3)       NULL,
    NM_GED_PROG           VARCHAR2(20)      NULL,
    NM_INST               VARCHAR2(50)      NULL,
    NM_SCH                VARCHAR2(50)      NULL,
    TXT_AREA_STUDY        VARCHAR2(20)      NULL,
    TXT_EMNC_DISC         VARCHAR2(300)     NULL,
    TXT_EMP_SVC           VARCHAR2(300)     NULL,
    TXT_HLTH_SVC          VARCHAR2(300)     NULL,
    TXT_LIFE_SKILLS       VARCHAR2(300)     NULL,
    TXT_SCH_CMMTS         VARCHAR2(300)     NULL
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
COMMENT ON TABLE CAPS.YOUTH_DETAIL IS
'This table hold Youth Develpment information for children 14 and older (formerly known as WTLP Detail).'
;
COMMENT ON COLUMN CAPS.YOUTH_DETAIL.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.YOUTH_DETAIL TO CAPSBAT
;
GRANT INSERT ON CAPS.YOUTH_DETAIL TO CAPSBAT
;
GRANT SELECT ON CAPS.YOUTH_DETAIL TO CAPSBAT
;
GRANT UPDATE ON CAPS.YOUTH_DETAIL TO CAPSBAT
;
GRANT DELETE ON CAPS.YOUTH_DETAIL TO CAPSON
;
GRANT INSERT ON CAPS.YOUTH_DETAIL TO CAPSON
;
GRANT SELECT ON CAPS.YOUTH_DETAIL TO CAPSON
;
GRANT UPDATE ON CAPS.YOUTH_DETAIL TO CAPSON
;
GRANT SELECT ON CAPS.YOUTH_DETAIL TO OPERATOR
;
CREATE TABLE CAPS.EXAM_DETAIL
(
    ID_EXAM_DETAIL  NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE  DATE        NOT NULL,
    ID_PERSON       NUMBER(16)  NOT NULL,
    CD_EXAM_TYP     VARCHAR2(3) NOT NULL,
    DT_EXAM         DATE        NOT NULL,
    NBR_SCORE       NUMBER(6)       NULL,
    IND_FIRST_ATMPT VARCHAR2(1)     NULL,
    IND_PASSED      VARCHAR2(1)     NULL,
    IND_GED         VARCHAR2(1)     NULL,
    CONSTRAINT PK_EXAM_DETAIL
    PRIMARY KEY (ID_EXAM_DETAIL)
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
COMMENT ON TABLE CAPS.EXAM_DETAIL IS
'This table is used to store information from the  examination detail page'
;
COMMENT ON COLUMN CAPS.EXAM_DETAIL.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.EXAM_DETAIL TO CAPSBAT
;
GRANT INSERT ON CAPS.EXAM_DETAIL TO CAPSBAT
;
GRANT SELECT ON CAPS.EXAM_DETAIL TO CAPSBAT
;
GRANT UPDATE ON CAPS.EXAM_DETAIL TO CAPSBAT
;
GRANT DELETE ON CAPS.EXAM_DETAIL TO CAPSON
;
GRANT INSERT ON CAPS.EXAM_DETAIL TO CAPSON
;
GRANT SELECT ON CAPS.EXAM_DETAIL TO CAPSON
;
GRANT UPDATE ON CAPS.EXAM_DETAIL TO CAPSON
;
GRANT SELECT ON CAPS.EXAM_DETAIL TO OPERATOR
;
CREATE TABLE CAPS.FCE_IVE_INCOME_LIMIT
(
    ID_FCE_IVE_INCOME_LIMIT  NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE           DATE         NOT NULL,
    NBR_AGE                  NUMBER(3)        NULL,
    AMT_GROSS_INCOME_CEILING NUMBER(10,2)     NULL,
    AMT_STANDARD_OF_NEED     NUMBER(10,2)     NULL,
    CONSTRAINT PK_FCE_IVE_INCOME_LIMIT
    PRIMARY KEY (ID_FCE_IVE_INCOME_LIMIT)
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
COMMENT ON TABLE CAPS.FCE_IVE_INCOME_LIMIT IS
'This table has the unique IV-E GIC and SON limit values.'
;
COMMENT ON COLUMN CAPS.FCE_IVE_INCOME_LIMIT.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSBAT
;
GRANT INSERT ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSBAT
;
GRANT SELECT ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSBAT
;
GRANT UPDATE ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSBAT
;
GRANT DELETE ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSON
;
GRANT INSERT ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSON
;
GRANT SELECT ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSON
;
GRANT UPDATE ON CAPS.FCE_IVE_INCOME_LIMIT TO CAPSON
;
GRANT SELECT ON CAPS.FCE_IVE_INCOME_LIMIT TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.YOUTH_DETAIL(
                              ID_PERSON,
                              DT_LAST_UPDATE,
                              ADDR_GED_ADDR_1,
                              ADDR_GED_ADDR_2,
                              ADDR_GED_ADDR_CITY,
                              ADDR_GED_ADDR_STATE,
                              ADDR_GED_ADDR_ZIP,
                              CD_ACAD_TRACK,
                              CD_CLASSIF,
                              CD_EDU_GOAL,
                              CD_PAR_STAT,
                              DT_EMNC_DISC,
                              DT_GED_EXP_PROG_COMP,
                              DT_GED_PROG_COMP,
                              DT_SCH_GRAD,
                              DT_POST_EXP_GRAD,
                              DT_POST_GRAD,
                              IND_EMP_SVC,
                              IND_GED_PROG,
                              IND_HEALTH_SVC,
                              IND_LIFE_SKILLS,
                              IND_SCH_GRAD,
                              NBR_GED_FAX,
                              NBR_GED_PHONE,
                              NBR_POST_CUMM_GPA,
                              NBR_POST_CURR_GPA,
                              NBR_POST_REQ_CRED,
                              NBR_POST_REQ_EAR,
                              NBR_SCH_CREDIT_EARNED,
                              NBR_SCH_CREDIT_REQD,
                              NBR_SCH_CURR_GPA,
                              NBR_SCH_CUM_GPA,
                              NM_GED_PROG,
                              NM_INST,
                              NM_SCH,
                              TXT_AREA_STUDY,
                              TXT_EMNC_DISC,
                              TXT_EMP_SVC,
                              TXT_HLTH_SVC,
                              TXT_LIFE_SKILLS,
                              TXT_SCH_CMMTS
                             )
                       SELECT 
                              ID_PERSON,
                              DT_LAST_UPDATE,
                              ADDR_GED_ADDR_1,
                              ADDR_GED_ADDR_2,
                              ADDR_GED_ADDR_CITY,
                              ADDR_GED_ADDR_STATE,
                              ADDR_GED_ADDR_ZIP,
                              CD_ACAD_TRACK,
                              CD_CLASSIF,
                              CD_EDU_GOAL,
                              CD_PAR_STAT,
                              DT_EMNC_DISC,
                              DT_GED_EXP_PROG_COMP,
                              DT_GED_PROG_COMP,
                              DT_SCH_GRAD,
                              DT_POST_EXP_GRAD,
                              DT_POST_GRAD,
                              IND_EMP_SVC,
                              IND_GED_PROG,
                              IND_HEALTH_SVC,
                              IND_LIFE_SKILLS,
                              IND_SCH_GRAD,
                              NBR_GED_FAX,
                              NBR_GED_PHONE,
                              NBR_POST_CUMM_GPA,
                              NBR_POST_CURR_GPA,
                              NBR_POST_REQ_CRED,
                              NBR_POST_REQ_EAR,
                              NBR_SCH_CREDIT_EARNED,
                              NBR_SCH_CREDIT_REQD,
                              NBR_SCH_CURR_GPA,
                              NBR_SCH_CUM_GPA,
                              NM_GED_PROG,
                              NM_INST,
                              NM_SCH,
                              TXT_AREA_STUDY,
                              TXT_EMNC_DISC,
                              TXT_EMP_SVC,
                              TXT_HLTH_SVC,
                              TXT_LIFE_SKILLS,
                              TXT_SCH_CMMTS
                         FROM CAPS.YOUTH_DETA_03202007231200000 
;
COMMIT
;
ALTER TABLE CAPS.YOUTH_DETAIL LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.YOUTH_DETAIL ADD CONSTRAINT PK_YOUTH_DETAIL
PRIMARY KEY (ID_PERSON)
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
DROP TRIGGER CAPS.TIBR_YOUTH_DETAIL
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_YOUTH_DETAIL
BEFORE INSERT
ON CAPS.YOUTH_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
DROP TRIGGER CAPS.TUBR_YOUTH_DETAIL
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_YOUTH_DETAIL
BEFORE UPDATE
ON CAPS.YOUTH_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Alter Index SQL

CREATE INDEX CAPS.IND_CONTACT_CBX_1
    ON CAPS.CONTACT_CBX(ID_CONTACT_EVENT)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_EXAM_DETAIL_1
    ON CAPS.EXAM_DETAIL(ID_PERSON)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.EXAM_DETAIL 
    ADD CONSTRAINT FK_EXAM_DTL_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.CONTACT ADD CONSTRAINT FK_CONTACT_PERSON_TCM_CL
FOREIGN KEY (ID_CONTACT_TCM_CLIENT)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.CONTACT_CBX ADD CONSTRAINT FK_CONTACT_CBX_CONTACT
FOREIGN KEY (ID_CONTACT_EVENT)
REFERENCES CAPS.CONTACT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.YOUTH_DETAIL ADD CONSTRAINT FK_YOUTH_DETAIL_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_CONTACT_CBX
BEFORE UPDATE
ON CAPS.CONTACT_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_CONTACT_CBX
BEFORE INSERT
ON CAPS.CONTACT_CBX
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_CONTACT_CBX IS NULL OR :new.ID_CONTACT_CBX = 0) THEN
		SELECT	SEQ_CONTACT_CBX.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_CONTACT_CBX := dummy;
	END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_YOUTH_DETAIL
BEFORE UPDATE
ON CAPS.YOUTH_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_YOUTH_DETAIL
BEFORE INSERT
ON CAPS.YOUTH_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXAM_DETAIL
BEFORE UPDATE
ON CAPS.EXAM_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXAM_DETAIL
BEFORE INSERT
ON CAPS.EXAM_DETAIL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_EXAM_DETAIL IS NULL OR :new.ID_EXAM_DETAIL = 0) THEN
		SELECT	SEQ_EXAM_DETAIL.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_EXAM_DETAIL := dummy;
	END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_FCE_IVE_INCOME_LIMIT
BEFORE UPDATE
ON CAPS.FCE_IVE_INCOME_LIMIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_FCE_IVE_INCOME_LIMIT
BEFORE INSERT
ON CAPS.FCE_IVE_INCOME_LIMIT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_FCE_IVE_INCOME_LIMIT IS NULL OR :new.ID_FCE_IVE_INCOME_LIMIT = 0) THEN
		SELECT	SEQ_FCE_IVE_INCOME_LIMIT.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_FCE_IVE_INCOME_LIMIT := dummy;
	END IF;
END;
/

DROP TABLE CAPS.YOUTH_DETA_03202007231200000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001731
UPDATE caps.codes_tables SET DECODE='Sibling Group'
WHERE code_type='CPLCMTIN' AND code = '060';
UPDATE caps.codes_tables SET DECODE='Placement Services to Parents'
WHERE code_type='CPLCMTIN' AND code = '080';
UPDATE caps.codes_tables SET DT_END=SYSDATE
WHERE code_type='CPLCMTIN' AND code = '040';

-- change STGAP00001734

INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CADBTPR','LPB','Lack of Publication',sysdate);
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CADBTPR','SIS','SAAG Issues',sysdate);
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CADBTPR','XXX','Other',sysdate);

-- change STGAP00001736

INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE,DT_LAST_UPDATE ) VALUES
      ('CGRAD','WRT','Writing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE) VALUES
      ('CGRAD','MAT','Math',SYSDATE);	  
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE) VALUES
      ('CGRAD','SCI','Science',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE) VALUES
      ('CGRAD','SSC','Social Science',SYSDATE);  
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGRAD','REA','Reading',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GOV','GED Overall',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GWR','GED Writing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GSS','GED Social Studies',SYSDATE);	  
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GSC','GED Science',SYSDATE);	  
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GLA','GED Language Arts/Reading',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE ) VALUES
      ('CGED','GMA','GED Math',SYSDATE);
      
-- change STGAP00001740
update CAPS.METAPHOR set TXT_FILTER_PATH = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.PersonDtlShowTab' where ID_TAB = 1505;

-- change STGAP00001742
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60196, 'MSG_CMN_YDP_SCORE','Score is required when the examination is marked passed.',500,700,'N');
  
-- change STGAP00001744
insert into caps.codes_tables  (code_type,code,decode)values('CNUMTYPE','CRS ID#','*'); 
insert into caps.codes_tables  (code_type,code,decode)values('CNUMTYPE','CMO ID#','*'); 
insert into caps.codes_tables  (code_type,code,decode)values('CNUMTYPE',
'Medicaid/MHN #','999999999999'); 
insert into caps.codes_tables  (code_type,code,decode)values('CNUMTYPE','Probation ID#','*'); 
insert into caps.codes_tables  (code_type,code,decode)values('CNUMTYPE','SMILE Client ID#','*');

-- change STGAP00001746
insert into caps.task (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE,
CD_TASK_STAGE_PROGRAM, DT_LAST_UPDATE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE,
IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST,
TXT_TASK_DECODE, IND_TASK_NEW_CASE_TODO_ENABLE )
values(2335,'DIV', 'DIV', 'CPS', SYSDATE, 'CASE_CASESEARCH', 'CASE_MANAGEMENT_CASEMNT',
'DIVERSION_CONCLUSION_DIV_DVRSONCONCLSION', '/investigation/DiversionCnclsn/displayDiversionCnclsn', 1, 1, 0,
0, 0, 0, 1, 'Diversion Conclusion', 1);

insert into caps.codes_tables ct (ct.CODE, ct.CODE_TYPE, ct.DECODE, ct.DT_LAST_UPDATE) 
values('DIV', 'CEVNTTYP', 'Diversion', SYSDATE);

insert into caps.stage_prog (id_stage_prog, cd_stage_prog_stage, cd_stage_prog_rsn_close,
cd_stage_prog_program, cd_stage_prog_event_type, cd_stage_prog_status, cd_stage_prog_task,
txt_stage_prog_evnt_desc)
values(0,'DIV', 'DIV', 'CPS', 'DIV', 'NEW', 2335, 'Diversion Conclusion');

-- change STGAP00001748
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129a','150.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129b','300.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129c','75.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129d','150.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129e','600.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129f','300.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129g','350.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129h','450.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51129j','350.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','51871c','750.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','52153','500.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','52156c','500.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','55179a','20.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','55179c','30.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','55179d','150.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','57610a','5,000.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','57610d','1,000.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','57810a','5,000.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','57810d','1,000.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','58375h','650.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','58580','252.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','58576g','350.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','58629','400.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','58678','8,000.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','59175c','650.00',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSAMTLMT','59175h','650.00',SYSDATE);

-- change STGAP00001750
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE,DT_LAST_UPDATE ) VALUES
      ('CREMT','DP','Court Ordered',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE) VALUES
      ('CREMT','VP','Voluntary placement',SYSDATE);  
INSERT INTO CAPS.CODES_TABLES (code_type ,code,DECODE ,DT_LAST_UPDATE) VALUES
      ('CREMT','VO','Voluntary Surrender',SYSDATE);
      
-- change STGAP00001733
update caps.codes_tables
set dt_end = sysdate
where code_type = 'CLIVARR'
and code in ('BCF', 'CFH','CGH','CFV','CGV','HCS');

UPDATE CAPS.CODES_TABLES 
set  decode = 'Adult Correct Facility/Jail'
where code = 'CFA'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'Battered Women''s Shelter'
where code = 'BWS'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'BOA', 'Boarding School');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'CPS', 'CPS Safety Resource');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'DFA', 'DFCS Adoptive Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'DFC', 'DFCS Family Foster Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'NOA', 'Non-DFCS Adoptive Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'NON', 'Non-DFCS Family Foster Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'DJC', 'DJJ Contract Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'DJG', 'DJJ Group Home');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'DJR', 'DJJ Residential Program');

UPDATE CAPS.CODES_TABLES 
set  decode = 'Emergency Shelter'
where code = 'ESH'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'FAM', 'With Family (Not Foster Care)');

UPDATE CAPS.CODES_TABLES 
set  decode = 'With Friend'
where code = 'FRN'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'GHI', 'Group Home/Institution-under DFCS Supervision');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'GHN', 'Group Home/Institution-no DFCS Supervision');

UPDATE CAPS.CODES_TABLES 
set  decode = 'General Hospital'
where code = 'HOS'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'Homeless Shelter'
where code = 'HSH'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'Maternity Home'
where code = 'MHO'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'MRF', 'MR/MH Foster Home');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'MRG', 'MR/MH Group Home');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'NRP', 'With Non Related Person (not boarding)');

UPDATE CAPS.CODES_TABLES 
set  decode = 'Private Psych Hospital'
where code = 'PPH'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'Unrelated Roomer/Boarder'
where code = 'RAB'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'REL', 'Relative Home');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'REF', 'Relative FH');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'RCP', 'Relative Custody Placement');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'NRG', 'Non-Related Guardian Home');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'UNP', 'Unrelated Person(s)');

UPDATE CAPS.CODES_TABLES 
set  decode = 'Adult Residential Treatment Center'
where code = 'RTC'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'RDC', 'Regional Detention Center DJJ');

UPDATE CAPS.CODES_TABLES SET DECODE='Sub Abs Treatment Center' WHERE CODE_TYPE = 'CLIVARR' AND CODE = 'SAT';

UPDATE CAPS.CODES_TABLES 
set  decode = 'State Facility'
where code = 'SCE'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'State Hospital'
where code = 'SHO'
and CODE_TYPE='CLIVARR';

UPDATE CAPS.CODES_TABLES 
set  decode = 'State School'
where code = 'SST'
and CODE_TYPE='CLIVARR';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'YDC', 'Youth Detention Center DJJ');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'UNK', 'Unknown');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'FCR', 'Foster Care Relative');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'FCN', 'Foster Care Non-Relative');

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) 
VALUES('CLIVARR', 'YDV', 'Youth Development');

-- change STGAP00001739
INSERT INTO caps.codes_tables(code_type,code,DECODE)
VALUES('CRSPRSTA','AC', 'Active');
INSERT INTO caps.codes_tables(code_type,code,DECODE)
VALUES('CRSPRSTA','EX', 'Expired');

-- change STGAP00001752
--Update non-incident requestes code entries
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'GC' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'FP' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'PQ' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'AN' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'GI' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'CI' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'AP' and CODE_TYPE = 'CNIRTYPE';
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'RR' and CODE_TYPE = 'CNIRTYPE';

insert into caps.codes_tables values ('CNIRTYPE','PA','PAD Payments',null,to_date('08/30/2006','MM/DD/YYYY'));
insert into caps.codes_tables values ('CNIRTYPE','PF','PFC Payments',null,to_date('08/30/2006','MM/DD/YYYY'));

-- Special Investigation Types
update CAPS.CODES_TABLES set DT_END = to_date('03/19/2007','MM/DD/YYYY') where CODE = 'CI' and CODE_TYPE = 'CSPECREQ';

--Program Area
insert into caps.codes_tables values ('CCLASS','PAD','Post Adoptions',null,to_date('08/30/2006','MM/DD/YYYY'));

-- change STGAP00001753
UPDATE CAPS.METAPHOR SET TXT_FILTER_PATH = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.PersonDtlShowTab' WHERE ID_TAB =1500;

-- change STGAP00001754
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPARSTAT','YES','Yes',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPARSTAT','NO','No',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPARSTAT','PUT','Putative Father',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPARSTAT','LEG','Legal Father',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPARSTAT','PRG','Pregnant',SYSDATE);

insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CATRACK','CPP','College Preparatory',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CATRACK','CPD','College Preparatory with Distinction',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CATRACK','TCP','Technology/Career Preparation',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CATRACK','TCD','Technology/Career Preparation with Distinction',SYSDATE);

insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEDUGOAL','DEG','Degree',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEDUGOAL','DIP','Diploma',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEDUGOAL','CER','Certificate',SYSDATE);

insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCLSSFCT','FRS','Freshman',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCLSSFCT','SOP','Sophomore',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCLSSFCT','JNR','Junior',SYSDATE);
insert into caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CCLSSFCT','SNR','Senior',SYSDATE);

-- change STGAP00001755
INSERT INTO CAPS.METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
VALUES('1570', '/person/PersonDetailIdentity/displayPersonDetailIdentity', 'PERSON_DETAIL_IDENTITY', 'Citizenship and Identity');

-- change STGAP00001756  Depends on addition of the new table
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(1,SYSDATE,0,786.99, 425.40);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(2,SYSDATE,1,786.99, 425.40);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(3,SYSDATE,2,786.99, 425.40);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(4,SYSDATE,3,786.99, 425.40);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(5,SYSDATE,4,786.99, 425.40);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(6,SYSDATE,5,786.99, 425.40); 
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(7,SYSDATE,6,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(8,SYSDATE,7,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(9,SYSDATE,8,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(10,SYSDATE,9,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(11,SYSDATE,10,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(12,SYSDATE,11,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(13,SYSDATE,12,888.00, 480.00);
INSERT INTO CAPS.FCE_IVE_INCOME_LIMIT(ID_FCE_IVE_INCOME_LIMIT,dt_last_update, nbr_age,amt_gross_income_ceiling, amt_standard_of_need ) VALUES(14,SYSDATE,13,1012.88, 547.50);

-- change STGAP00001759
UPDATE CAPS.MESSAGE set TXT_MESSAGE = 'Verification of disability required for person receiving care who is 13 years of age or older.' where TXT_MESSAGE_NAME 
  = 'MSG_FCE_VERIF_DISABL' ;
  
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
    VALUES (60197, 'MSG_FCE_DT_LEGAL_DOCS_SENT' 
,'You have indicated legal documents have been provided to the Eligibility Specialist.  Please enter the date which these documents have been sent to the Eligibility Specialist.',500,700,'N'); 

-- change STGAP00001760
insert into caps.message m (m.ID_MESSAGE, m.DT_LAST_UPDATE, m.NBR_MESSAGE,m.TXT_MESSAGE_NAME, m.TXT_MESSAGE)
values(0, SYSDATE, 60198, 'MSG_DIV_DSPSTN_REQ', 'Disposition is required when submitting for approval');
insert into caps.message m (m.ID_MESSAGE, m.DT_LAST_UPDATE, m.NBR_MESSAGE,m.TXT_MESSAGE_NAME, m.TXT_MESSAGE)
values(0, SYSDATE, 60199, 'MSG_DIV_NO_EXISTS', 'A diversion does not exist for this situation.');
insert into caps.message m (m.ID_MESSAGE, m.DT_LAST_UPDATE, m.NBR_MESSAGE,m.TXT_MESSAGE_NAME, m.TXT_MESSAGE)
values(0, SYSDATE, 60200, 'MSG_DIV_NOT_BEGUN', 'An initial contact must be recorded before concluding the diversion.');
insert into caps.message m (m.ID_MESSAGE, m.DT_LAST_UPDATE, m.NBR_MESSAGE,m.TXT_MESSAGE_NAME, m.TXT_MESSAGE)
values(0, SYSDATE, 60201, 'MSG_DIV_TASKS_COMP_DATE_REQ', 'Diversion Tasks Completed Date is required in order to Save and Submit the Diversion Conclusion.');

-- change STGAP00001761
UPDATE CAPS.CODES_TABLES
SET dt_end = SYSDATE WHERE code_type = 'CSVATYP2' AND code = 'UPD';
UPDATE CAPS.CODES_TABLES
SET dt_end = SYSDATE WHERE code_type = 'CSVATYPE' AND code = 'UPD';

-- change STGAP00001766
-- CCNTCTYP additions
-- > DIV stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'NREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'NTRN', 'Transfer Summary', SYSDATE);
-- > ONG stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'LREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'LTRN', 'Transfer Summary', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'LSRA', 'Safety Resource Assessment', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'LPTC', 'Physician Taking Child into Custody', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'LPVC', 'Parent/Child Visit', SYSDATE);
-- > FCC stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'MREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'MTRN', 'Transfer Summary', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'MPVC', 'Parent/Child Visit', SYSDATE);
-- > FCF stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'OREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'OTRN', 'Transfer Summary', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'OPVC', 'Parent/Child Visit', SYSDATE);
-- > PFC stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'PREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'PTRN', 'Transfer Summary', SYSDATE);
-- > ADO stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'HTRN', 'Transfer Summary', SYSDATE);
-- > PAD stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'QREG', 'Contact', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'QTRN', 'Transfer Summary', SYSDATE);
-- > FAD stage
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'ITRN', 'Transfer Summary', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) VALUES ('CCNTCTYP', 'IINQ', 'Inquiry Follow Up', SYSDATE);

-- CCNTCTYP modifications
-- > ADO stage
UPDATE CAPS.CODES_TABLES SET DECODE = 'Contact', dt_end = '' WHERE code_type = 'CCNTCTYP' AND code = 'HREG';
-- > FAD stage
UPDATE CAPS.CODES_TABLES SET dt_end = '' WHERE code_type = 'CCNTCTYP' AND code = 'IREG';

-- CCNTCTYP end-dates
-- > INT stage
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DINQ';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DPTC';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DPVC';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DSRA';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DTCM';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'DTRN';
-- > INV stage
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'AINQ';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'APVC';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'ATCM';
-- > ARI stage
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KINQ';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KPTC';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KPVC';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KSRA';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KTCM';
UPDATE CAPS.CODES_TABLES SET dt_end = '01/01/2007' WHERE code_type = 'CCNTCTYP' AND code = 'KTRN';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (138, 'SacwisRev2', 'static updates, schema changes');
commit;

