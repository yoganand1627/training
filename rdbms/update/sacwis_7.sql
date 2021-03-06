
-- Role Alter SQL


-- User Alter SQL


-- Tablespace Alter SQL


-- Rollback Segment Alter SQL


-- Sequence Alter SQL


-- Dictionary Object Alter SQL


-- Standard Alter Table SQL

ALTER TABLE CAPS.LEGAL_ACTION ADD NBR_CRT_FILE NUMBER(10)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD CD_CRT_TYPE VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_NXT_HEAR_DATE DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_CONTIN_DATE DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_CRT_ORD_DATE DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_PUB_DATE DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD CD_COUNTY VARCHAR2(3)     NULL
;
COMMENT ON COLUMN CAPS.LEGAL_ACTION.CD_COUNTY IS
'County Code'
;
ALTER TABLE CAPS.LEGAL_ACTION ADD DT_CRT_ACT_DATE DATE     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD CD_HR_TYP_CRT_ORD VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.LEGAL_ACTION ADD CRT_CASE_NBR VARCHAR2(15)     NULL
;
ALTER TABLE CAPS.SECURITY_CLASS_AUDIT DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.SECURITY_CLASS_AUDIT ADD CONSTRAINT PK_SECURITY_CLASS_AUDIT
PRIMARY KEY (ID_SECURITY_CLASS_AUDIT)
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
ALTER TABLE CAPS.STAGE MODIFY(CD_STAGE_CURR_PRIORITY  VARCHAR2(3))
;
ALTER TABLE CAPS.STAGE MODIFY(CD_STAGE_INITIAL_PRIORITY  VARCHAR2(3))
;

-- Drop Referencing Constraint SQL


-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.ATTENDEES DROP CONSTRAINT FK_ATTENDEES_EVENT
;
ALTER TABLE CAPS.ATTENDEES DROP CONSTRAINT FK_ATTENDEES_PERSON
;
ALTER TABLE CAPS.ATTENDEES DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.ATTENDEES RENAME TO ATTENDEES_09012006170248000
;
CREATE TABLE CAPS.ATTENDEES
(
    ID_ATTENDEES       NUMBER(16)  NOT NULL,
    ID_LEGAL_ACT_EVENT NUMBER(16)  NOT NULL,
    ID_ATTD_PERSON     NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE     DATE        NOT NULL,
    CD_ATTD_TYPE       VARCHAR2(3)     NULL,
    CD_ATTD_ROLE       VARCHAR2(3)     NULL,
    CD_ATTD_RELATION   VARCHAR2(3)     NULL
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
COMMENT ON TABLE CAPS.ATTENDEES IS
'Attendess at a court hearing?'
;
COMMENT ON COLUMN CAPS.ATTENDEES.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.ATTENDEES TO CAPSBAT
;
GRANT INSERT ON CAPS.ATTENDEES TO CAPSBAT
;
GRANT SELECT ON CAPS.ATTENDEES TO CAPSBAT
;
GRANT UPDATE ON CAPS.ATTENDEES TO CAPSBAT
;
GRANT DELETE ON CAPS.ATTENDEES TO CAPSON
;
GRANT INSERT ON CAPS.ATTENDEES TO CAPSON
;
GRANT SELECT ON CAPS.ATTENDEES TO CAPSON
;
GRANT UPDATE ON CAPS.ATTENDEES TO CAPSON
;
GRANT SELECT ON CAPS.ATTENDEES TO OPERATOR
;
ALTER TABLE CAPS.LEGAL_STATUS DROP CONSTRAINT FK_LEGAL_STAT_PERSON
;
ALTER TABLE CAPS.LEGAL_STATUS DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_LEGAL_STATUS_3
;
DROP INDEX CAPS.IND_LEGAL_STATUS_1
;
DROP INDEX CAPS.IND_LEGAL_STATUS_2
;
ALTER TABLE CAPS.LEGAL_STATUS RENAME TO LEGAL_STAT_09012006170249000
;
CREATE TABLE CAPS.LEGAL_STATUS
(
    ID_LEGAL_STAT_EVENT          NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE               DATE         NOT NULL,
    ID_PERSON                    NUMBER(16)   NOT NULL,
    ID_CASE                      NUMBER(16)       NULL,
    CD_LEGAL_STAT_CNTY           VARCHAR2(3)      NULL,
    CD_LEGAL_STAT_STATUS         VARCHAR2(3)      NULL,
    DT_LEGAL_STAT_STATUS_DT      DATE             NULL,
    IND_CSUP_SEND                CHAR(1)          NULL,
    CD_COURT_NBR                 VARCHAR2(10)     NULL,
    DT_LEGAL_STAT_CRT_ODR_EXP_DT DATE             NULL,
    DT_LEGAL_STAT_CUS_EXP_DT     DATE             NULL
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
GRANT DELETE ON CAPS.LEGAL_STATUS TO CAPSBAT
;
GRANT INSERT ON CAPS.LEGAL_STATUS TO CAPSBAT
;
GRANT SELECT ON CAPS.LEGAL_STATUS TO CAPSBAT
;
GRANT UPDATE ON CAPS.LEGAL_STATUS TO CAPSBAT
;
GRANT DELETE ON CAPS.LEGAL_STATUS TO CAPSON
;
GRANT INSERT ON CAPS.LEGAL_STATUS TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_STATUS TO CAPSON
;
GRANT UPDATE ON CAPS.LEGAL_STATUS TO CAPSON
;
GRANT SELECT ON CAPS.LEGAL_STATUS TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.ATTENDEES(
                           ID_ATTENDEES,
                           ID_LEGAL_ACT_EVENT,
                           ID_ATTD_PERSON,
                           DT_LAST_UPDATE,
                           CD_ATTD_TYPE,
                           CD_ATTD_ROLE,
                           CD_ATTD_RELATION
                          )
                    SELECT 
                           ID_ATTENDEES,
                           0,
                           ID_ATTD_PERSON,
                           DT_LAST_UPDATE,
                           CD_ATTD_TYPE,
                           CD_ATTD_ROLE,
                           CD_ATTD_RELATION
                      FROM CAPS.ATTENDEES_09012006170248000 
;
COMMIT
;
ALTER TABLE CAPS.ATTENDEES LOGGING
;
ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.LEGAL_STATUS(
                              ID_LEGAL_STAT_EVENT,
                              DT_LAST_UPDATE,
                              ID_PERSON,
                              ID_CASE,
                              CD_LEGAL_STAT_CNTY,
                              CD_LEGAL_STAT_STATUS,
                              DT_LEGAL_STAT_STATUS_DT,
                              IND_CSUP_SEND,
                              CD_COURT_NBR,
                              DT_LEGAL_STAT_CRT_ODR_EXP_DT,
                              DT_LEGAL_STAT_CUS_EXP_DT
                             )
                       SELECT 
                              ID_LEGAL_STAT_EVENT,
                              DT_LAST_UPDATE,
                              ID_PERSON,
                              ID_CASE,
                              CD_LEGAL_STAT_CNTY,
                              CD_LEGAL_STAT_STATUS,
                              DT_LEGAL_STAT_STATUS_DT,
                              IND_CSUP_SEND,
                              CD_COURT_NBR,
                              DT_LEGAL_STAT_CRT_ODR_EXP_DT,
                              NULL
                         FROM CAPS.LEGAL_STAT_09012006170249000 
;
COMMIT
;
ALTER TABLE CAPS.LEGAL_STATUS LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.ATTENDEES ADD CONSTRAINT PK_ATTENDEES
PRIMARY KEY (ID_ATTENDEES)
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
ALTER TABLE CAPS.LEGAL_STATUS ADD CONSTRAINT PK_LEGAL_STATUS
PRIMARY KEY (ID_LEGAL_STAT_EVENT)
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

-- Add Indexes SQL

CREATE INDEX CAPS.IND_LEGAL_STATUS_3
    ON CAPS.LEGAL_STATUS(IND_CSUP_SEND,ID_LEGAL_STAT_EVENT)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_LEGAL_STATUS_1
    ON CAPS.LEGAL_STATUS(ID_PERSON)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_LEGAL_STATUS_2
    ON CAPS.LEGAL_STATUS(ID_CASE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Dependencies SQL

/
DROP TRIGGER CAPS.TIBR_ATTENDEES
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_ATTENDEES
BEFORE INSERT
ON CAPS.ATTENDEES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:new.ID_ATTENDEES = 0) THEN
		SELECT	SEQ_ATTENDEES.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_ATTENDEES := dummy;
	END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_ATTENDEES
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_ATTENDEES
BEFORE UPDATE
ON CAPS.ATTENDEES
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
ALTER VIEW CAPS.LEGAL_STATUS_CSUB_VIEW COMPILE
/
/
DROP TRIGGER CAPS.TIBR_LEGAL_STATUS
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_LEGAL_STATUS
BEFORE INSERT
ON CAPS.LEGAL_STATUS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	SELECT	ID_CASE
	INTO		:new.ID_CASE
	FROM		EVENT
	WHERE		ID_EVENT = :new.ID_LEGAL_STAT_EVENT;
EXCEPTION
	WHEN OTHERS THEN
		IF SQL%NOTFOUND THEN
			:new.ID_CASE := NULL;
		END IF;
END;
/
/
DROP TRIGGER CAPS.TUBR_LEGAL_STATUS
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_LEGAL_STATUS
BEFORE UPDATE
ON CAPS.LEGAL_STATUS
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Update Views SQL


-- Add Privileges SQL


-- Alter Index SQL


-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.RISK_ASSESSMENT ADD CONSTRAINT FK_RISK_ASS_EVENT
FOREIGN KEY (ID_EVENT)
REFERENCES CAPS.EVENT (ID_EVENT)
ENABLE
;
ALTER TABLE CAPS.ATTENDEES ADD CONSTRAINT FK_ATTENDEES_LEGAL_ACT
FOREIGN KEY (ID_LEGAL_ACT_EVENT)
REFERENCES CAPS.LEGAL_ACTION (ID_LEGAL_ACT_EVENT)
ENABLE
;
ALTER TABLE CAPS.ATTENDEES ADD CONSTRAINT FK_ATTENDEES_PERSON
FOREIGN KEY (ID_ATTD_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;
ALTER TABLE CAPS.LEGAL_STATUS ADD CONSTRAINT FK_LEGAL_STAT_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

-- Materialized View Alter SQL


-- Alter Procedure SQL


-- Alter Package SQL


-- Alter Oracle Object Type SQL


-- Alter Trigger SQL


-- Synonym Alter SQL

drop table CAPS.ATTENDEES_09012006170248000;
drop table CAPS.LEGAL_STAT_09012006170249000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('PUBLIC') };


update CAPS.CODES_TABLES set DECODE = 'Self-Employed Income' where CODE = 'SLF' and CODE_TYPE = 'CINC'; 
delete from CAPS.CODES_TABLES where CODE_TYPE = 'CFREQ' and CODE = 'BMN';

UPDATE caps.OFFICE SET cd_office_region='0' || cd_office_region 
WHERE LENGTH(cd_office_region) < 3 ;

UPDATE caps.CODES_TABLES SET DECODE='0' || DECODE 
WHERE LENGTH(DECODE) < 3 
AND CODE_TYPE = 'CCNTYREG';

INSERT INTO CAPS.METAPHOR 
(id_tab, 
txt_tab_url, 
txt_tab_constant, 
txt_tab, 
dt_last_update) 
VALUES 
(1450, 
'/investigation/PolicyWaiver/displayPolicyWaiver', 
'POLICY_WAIVER', 
'Policy Waiver', 
SYSDATE); 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Intake Information' 
WHERE id_tab IN (100,110); 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Intake Report Log' 
WHERE id_tab = 120; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Record/<br>Review Intake' 
WHERE id_tab = 1070; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Review<br>Intake' 
WHERE id_tab = 1140; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Intake Person Detail' 
WHERE id_tab = 113; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Health Detail' 
WHERE id_tab = 890; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Assessments' 
WHERE id_tab = 1180; 

UPDATE CAPS.METAPHOR 
SET txt_tab = 'Custody' 
WHERE id_tab = 350; 

INSERT INTO CAPS.TASK 
(cd_task, 
dt_last_update, 
cd_task_event_type, 
cd_task_stage, 
cd_task_stage_program, 
ind_task_event_create, 
ind_task_event_navig, 
ind_task_multiple_instance, 
ind_task_new_using, 
INd_task_nu_across_case, 
ind_task_rtrv_prior_stage, 
ind_task_show_in_list, 
txt_task_decode, 
txt_1ST_tab, 
txt_2nd_tab, 
txt_3rd_tab, 
txt_event_detail_url) 
VALUES 
('2320', 
SYSDATE, 
'WVR', 
'INV', 
'CPS', 
1, 
1, 
1, 
0, 
0, 
0, 
1, 
'Policy Waiver', 
'CASE_CASESEARCH', 
'CASE_MANAGEMENT_CASEMNT', 
'POLICY_WAIVER_EVENTLIST', 
'/investigation/PolicyWaiver/displayPolicyWaiver' 
);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (8, 'SacwisRev1', 'Move fields from LEGAL_STATUS to LEGAL_ACTION, change ATTENDEES relationship, misc updates.');
                         
commit;
