
-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_PERSON_CITIZENSHIP
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;

-- Standard Alter Table SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_DRIVER_LIC_OR_ID VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_SCHOOL_REC VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_MILITARY_DEPDNT_ID VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD IND_CHILD_CARE_COURT_ORDER VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD IND_BEST_INTEREST_LANG VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD IND_RESNABL_EFRT_REUNIFY VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD IND_RESNABL_EFRT_PRVNT_RMVAL VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD NBR_MHN_NUMBER VARCHAR2(15)     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD DT_PRMNCY_HRNGS_12_MONTH DATE     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD DT_COURT_ORDER DATE     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD DT_BEST_INTEREST_LANG DATE     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD DT_RESNABL_EFRT_REUNIFY DATE     NULL
;
ALTER TABLE CAPS.FCE_REVIEW ADD DT_RESNABL_EFRT_PRVNT_RMVAL DATE     NULL
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.PERSON_CITIZENSHIP
(
    ID_PERSON_CITIZENSHIP NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE        DATE        NOT NULL,
    ID_PERSON             NUMBER(16)  NOT NULL,
    CD_CBX                VARCHAR2(3)     NULL,
    CD_CBX_CODE_TYPE      VARCHAR2(8)     NULL,
    CONSTRAINT PK_PERSON_CITIZENSHIP
    PRIMARY KEY (ID_PERSON_CITIZENSHIP)
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
COMMENT ON TABLE CAPS.PERSON_CITIZENSHIP IS
'Citizenship and Identity Information for a Person'
;
COMMENT ON COLUMN CAPS.PERSON_CITIZENSHIP.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.PERSON_CITIZENSHIP TO CAPSBAT
;
GRANT INSERT ON CAPS.PERSON_CITIZENSHIP TO CAPSBAT
;
GRANT SELECT ON CAPS.PERSON_CITIZENSHIP TO CAPSBAT
;
GRANT UPDATE ON CAPS.PERSON_CITIZENSHIP TO CAPSBAT
;
GRANT DELETE ON CAPS.PERSON_CITIZENSHIP TO CAPSON
;
GRANT INSERT ON CAPS.PERSON_CITIZENSHIP TO CAPSON
;
GRANT SELECT ON CAPS.PERSON_CITIZENSHIP TO CAPSON
;
GRANT UPDATE ON CAPS.PERSON_CITIZENSHIP TO CAPSON
;
GRANT SELECT ON CAPS.PERSON_CITIZENSHIP TO OPERATOR
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_PERSON_CITIZENSHIP_1
    ON CAPS.PERSON_CITIZENSHIP(ID_PERSON)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.PERSON_CITIZENSHIP 
    ADD CONSTRAINT FK_PERSON_CTZNSHIP_PERSON
FOREIGN KEY (ID_PERSON)
REFERENCES CAPS.PERSON (ID_PERSON)
ENABLE
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PERSON_CITIZENSHIP
BEFORE UPDATE
ON CAPS.PERSON_CITIZENSHIP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PERSON_CITIZENSHIP
BEFORE INSERT
ON CAPS.PERSON_CITIZENSHIP
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:NEW.ID_PERSON_CITIZENSHIP IS NULL OR :new.ID_PERSON_CITIZENSHIP = 0) THEN
		SELECT	SEQ_PERSON_CITIZENSHIP.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_PERSON_CITIZENSHIP := dummy;
	END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001768
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
     VALUES (60202, 'MSG_FCE_CHILD_NON_DFCS_PAID_ELIGIBILITY','The child does not have an open eligibility summary with an actual eligibility of Title IV-E or Title IV-B.',500,700,'N'); 

-- change STGAP00001771
Update caps.codes_tables
set dt_end = sysdate
where code_type = 'CSTAGES'
and code in ('ONG','AFC','FCC','FCF','ARF','FRE','I&R','PAL','SPC','FC');

update caps.codes_tables
set dt_end = null
where code_type = 'CSTAGES'
and code = 'SUB';

update caps.codes_tables
set decode = 'CPS Ongoing'
where code_type = 'CSTAGES'
and code = 'FPR';

update caps.codes_tables
set decode = 'Foster Care Family'
where code_type = 'CSTAGES'
and code = 'FSU';

update caps.codes_tables
set decode = 'Foster Care Child'
where code_type = 'CSTAGES'
and code = 'SUB';

--change STGAP00001772
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60203, 'MSG_FCE_SIGN_INIT_MA' 
,'The Initial Medicaid Application must be electronically-signed prior to submission.', 760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60204, 'MSG_FCE_ACK_INIT_MA' 
,'Please indicate acknowledge of application for Medicaid prior to submission.',760,500,'N');

--change STGAP00001773
INSERT INTO CAPS.METAPHOR(ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_FILTER_PATH,DT_LAST_UPDATE) 
 VALUES(1571,'/fce/InitialMedicaid/displayInitialMedicaid' 
,'INITIAL_MEDICAID_INITIALMEDICAID' 
,'Initial Medicaid' 
,'gov.georgia.dhr.dfcs.sacwis.web.metaphor.IsEventListFCShowTab' 
,SYSDATE);

-- change STGAP00001778
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','A3','Assessment'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L1','Level 1'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L2','Level 2'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L3','Level 3'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L4','Level 4'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L5','Level 5'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','L6','Level 6'); 

-- change STGAP00001779
insert into caps.codes_tables  (code_type,code,decode)values('CAAFDTYP','PST','Private State Funded Adoption Assistance (UAS Code 508)');
insert into caps.codes_tables  (code_type,code,decode)values('CAAFDTYP','IVE','Title IV-E Adoption Assistance (UAS Code 509)'); 
insert into caps.codes_tables  (code_type,code,decode)values('CAAFDTYP','NRC','Non-recurring Adoption Assistance (UAS Code 510)');

-- change STGAP00001780
 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60205, 'MSG_ADO_SPC_DIAGNOSES_REQD' 
,'Please enter the corresponding diagnoses',760,500);
 
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60206, 'MSG_ADO_SPC_RATE_DOC' 
,'If specialized rate is requested, provide documentation',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60207, 'MSG_ADO_SPC_SVC_RQST_AMT' 
,'If special service is requested, please provide the amount',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60208, 'MSG_ADO_SPC_SVC_RQST_TYPE' 
,'If special service is requested, please provide the type',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60209, 'MSG_ADO_SPC_SVC_RQST_SPEC' 
,'If special service is requested, please specify the details of the service type',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60210, 'MSG_ADO_SPC_DISA_TYPE' 
,'Please provide type of special needs for this Approval type',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60211, 'MSG_ADO_SPC_RATE_AMT' 
,'Please fill in amount of approved Specialized Rate',760,500); 

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION) 
  VALUES (60212, 'MSG_ADO_SPC_SVCS_AMT' 
,'Please fill in amount, approval date and expiration date for Special Services.',760,500); 

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (139, 'SacwisRev2', 'static updates, schema changes');

commit;
