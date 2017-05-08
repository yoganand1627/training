
-- Standard Alter Table SQL

ALTER TABLE CAPS.CASE_BUDGET_LIMIT ADD AMT_PEND_AUTH NUMBER(13,2)     NULL
;
ALTER TABLE CAPS.COLLEGE_EXAM DROP CONSTRAINT FK_COLL_EXAM_WTLP
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD IND_CTZNSHP_CERT_REPORT_BIRTH VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD ID_OTHER_RELATIVE_PERSON NUMBER(16)     NULL
;
ALTER TABLE CAPS.TCM_CLAIM MODIFY(CD_DENIAL  VARCHAR2(30))
;
ALTER TABLE CAPS.TCM_CLAIM ADD DT_PAY DATE     NULL
;
ALTER TABLE CAPS.TCM_CLAIM ADD NBR_RA VARCHAR2(8)     NULL
;

-- Drop Constraint, Rename and Create Table SQL

DROP TABLE CAPS.WTLP_DETAIL CASCADE CONSTRAINTS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00002012
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60305, 'MSG_ONE_TEST' ,'Enter either an SAT test or ACT test.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60306, 'MSG_TEST_DATE' ,'Enter a test taken date.',500,700,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (158, 'SacwisRev2', 'static updates, schema changes');
                         
commit;
