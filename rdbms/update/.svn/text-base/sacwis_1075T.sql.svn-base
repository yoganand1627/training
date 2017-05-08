--STGAP00017038 - Release(5.0) MR-092 DBCR

--MR-092 Initial DBCR

CREATE TABLE CAPS.AA_FUNDING
(
  ID_AA_FUNDING_EVENT NUMBER(16) NOT NULL,
  ID_ELIG_EVENT NUMBER(16)  REFERENCES CAPS.ELIGIBILITY(ID_ELIG_EVENT),
  DT_LAST_UPDATE DATE NOT NULL,
  DT_CREATED DATE,
  DT_AA_FUNDING_VALIDATED DATE,
  ID_PERSON_LAST_UPDATED NUMBER(16) REFERENCES CAPS.EMPLOYEE(ID_PERSON),
  NBR_FFY NUMBER(4),
  ID_CHILD NUMBER(16) NOT NULL REFERENCES CAPS.PERSON(ID_PERSON),
  DT_CHILD_DOB DATE,
  NBR_CHILD_AGE NUMBER(3),
  IND_NON_RECURRING_REQ VARCHAR(1),
  CD_AA_FUNDING_TYPE VARCHAR(3),
  IND_AC_AGE_MET VARCHAR(1),
  IND_AC_TIME_IN_FOSTER_MET VARCHAR(1),
  NBR_CHILD_MTHS_IN_FOSTER NUMBER(3),
  IND_AC_SIBLING_MET VARCHAR(1),
  ID_AC_SIBLING NUMBER(16) REFERENCES CAPS.PERSON(ID_PERSON),
  NM_AC_SIBLING_FULL_NAME VARCHAR(100),
  DT_AC_SIBLING_DOB DATE,
  NBR_AC_SIBLING_AGE NUMBER(3),
  NBR_AC_SIBLING_MTHS_IN_FOSTER NUMBER(3),
  IND_AC_TPR_CTW_VS_MET VARCHAR(1),
  IND_AC_SSI_ELIG_MET VARCHAR(1),
  IND_AC_CHILD_OF_MINOR_MET VARCHAR(1),
  IND_AC_IVE_PRIOR_ADOPT_MET VARCHAR(1),
  IND_NAC_AFDC_MET VARCHAR(1),
  IND_NAC_SSI_ELIG_MET VARCHAR(1),
  IND_NAC_CHILD_OF_MINOR_MET VARCHAR(1),
  IND_NAC_IVE_PRIOR_ADOPT_MET VARCHAR(1),
  TXT_COMMENTS VARCHAR(4000),
constraint pk_aa_funding  PRIMARY KEY (id_aa_funding_event) using index tablespace index01,
constraint fk_aa_fund_event foreign key (id_aa_funding_event) REFERENCES CAPS.EVENT(ID_EVENT) 
) tablespace data01;

COMMENT ON COLUMN CAPS.AA_FUNDING.ID_AA_FUNDING_EVENT IS 'Primary key';
COMMENT ON COLUMN CAPS.AA_FUNDING.ID_ELIG_EVENT IS 'Id event of the latest initial or amended FCEA eligibility summary';
COMMENT ON COLUMN CAPS.AA_FUNDING.DT_LAST_UPDATE IS 'Date record last updated';
COMMENT ON COLUMN CAPS.AA_FUNDING.DT_CREATED IS 'Date record initially created';
COMMENT ON COLUMN CAPS.AA_FUNDING.DT_AA_FUNDING_VALIDATED IS 'Date Eligibility Specialist validated this AA Funding';
COMMENT ON COLUMN CAPS.AA_FUNDING.ID_PERSON_LAST_UPDATED IS 'Id Person of Eligiblity Specialist who last modified or validated this event';
COMMENT ON COLUMN CAPS.AA_FUNDING.NBR_FFY IS 'Federal Fiscal Year at the time of last modification or funding validation';
COMMENT ON COLUMN CAPS.AA_FUNDING.ID_CHILD IS 'Id person of primary child';
COMMENT ON COLUMN CAPS.AA_FUNDING.DT_CHILD_DOB IS 'Date of birth of the primary child at the time of last modification or funding validation';
COMMENT ON COLUMN CAPS.AA_FUNDING.NBR_CHILD_AGE IS 'Age of the primary child at the time of last modification or funding validation';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_NON_RECURRING_REQ IS 'Indicates if this funding is a Non-Recurring Requesting Only type';
COMMENT ON COLUMN CAPS.AA_FUNDING.CD_AA_FUNDING_TYPE IS 'AA Funding Type determined by system based on data at the time of funding validation';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_AGE_MET IS 'Indicates whether primary child has met the Fostering Connection Age criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_TIME_IN_FOSTER_MET IS 'Indicates whether primary child has met the Fostering Connection Time in Foster Care criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.NBR_CHILD_MTHS_IN_FOSTER IS 'Number of consecutive months child was in foster care, calculated based on child In DFCS Custody legal status';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_SIBLING_MET IS 'Indicates whether primary child has met the Fostering Connection Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.ID_AC_SIBLING IS 'Id person of the sibling that qualifies the primary child as an Applicable Child based on Fostering Connections Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.NM_AC_SIBLING_FULL_NAME IS 'Name of the sibling that qualifies the primary child as an Applicable Child based on Fostering Connections Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.DT_AC_SIBLING_DOB IS 'Date of birth of the sibling that qualifies the primary child as an Applicable Child based on Fostering Connections Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.NBR_AC_SIBLING_AGE IS 'Age of the sibling that qualifies the primary child as an Applicable Child based on Fostering Connections Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.NBR_AC_SIBLING_MTHS_IN_FOSTER IS 'Number of consecutive months in foster care for the sibling that qualifies the primary child as an Applicable Child based on Fostering Connections Sibling of an Applicable Child criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_TPR_CTW_VS_MET IS 'Indicates if the primary child, who has met Applicable Child criteria, has met the Involuntary Removal/CTW language or Voluntary Relinquishment/Surrender criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_SSI_ELIG_MET IS 'Indicates if the primary child, who has met Applicable Child criteria, has met the medical or disability requirements for SSI eligibility criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_CHILD_OF_MINOR_MET IS 'Indicates if the primary child, who has met Applicable Child criteria, has met the child of a minor parent criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_AC_IVE_PRIOR_ADOPT_MET IS 'Indicates if the primary child, who has met Applicable Child criteria, has met the AA IV-E eligibility in prior adoption criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_NAC_AFDC_MET IS 'Indicates if the primary child, who has NOT met Applicable Child criteria, has met the AFDC criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_NAC_SSI_ELIG_MET IS 'Indicates if the primary child, who has NOT met Applicable Child criteria, has met the SSI eligibility criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_NAC_CHILD_OF_MINOR_MET IS 'Indicates if the primary child, who has NOT met Applicable Child criteria, has met the child of a minor parent criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.IND_NAC_IVE_PRIOR_ADOPT_MET IS 'Indicates if the primary child, who has NOT met Applicable Child criteria, has met the AA IV-E eligibility in prior adoption criteria';
COMMENT ON COLUMN CAPS.AA_FUNDING.TXT_COMMENTS IS 'Comments entered by Eligibility Specialist(s) prior to funding validation';

grant select,update,insert,delete on CAPS.AA_FUNDING to capson,capsbat,ops$datafix;
grant select on caps.AA_FUNDING to operator,shinesdm;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_AA_FUNDING 
BEFORE INSERT
ON CAPS.AA_FUNDING
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  :new.DT_CREATED := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_AA_FUNDING 
BEFORE UPDATE
ON CAPS.AA_FUNDING
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

ALTER TABLE CAPS.special_needs_determination
ADD (
  ID_AA_FUNDING_EVENT NUMBER(16) REFERENCES CAPS.AA_FUNDING(ID_AA_FUNDING_EVENT) NULL
);

COMMENT ON COLUMN CAPS.special_needs_determination.ID_AA_FUNDING_EVENT IS 'Id event of latest validated AA Funding event used to determine funding eligibility';

CREATE TABLE CAPS.AA_FUNDING_REASON_ELIG
(
  ID_AA_FUNDING_REASON_ELIG NUMBER(16) NOT NULL PRIMARY KEY,
  DT_LAST_UPDATE DATE NOT NULL,
  ID_AA_FUNDING_EVENT NUMBER(16) NOT NULL REFERENCES CAPS.AA_FUNDING(ID_AA_FUNDING_EVENT),
  CD_AA_FUNDING_RSN VARCHAR(3) NOT NULL,
  CONSTRAINT UK_AA_FUNDING UNIQUE (ID_AA_FUNDING_EVENT, CD_AA_FUNDING_RSN)
);

grant select,update,insert,delete on CAPS.AA_FUNDING_REASON_ELIG to capson,capsbat,ops$datafix;
grant select on caps.AA_FUNDING_REASON_ELIG to operator,shinesdm;

COMMENT ON COLUMN CAPS.AA_FUNDING_REASON_ELIG.ID_AA_FUNDING_REASON_ELIG IS 'Primary Key';
COMMENT ON COLUMN CAPS.AA_FUNDING_REASON_ELIG.DT_LAST_UPDATE IS 'Date record was last updated';
COMMENT ON COLUMN CAPS.AA_FUNDING_REASON_ELIG.ID_AA_FUNDING_EVENT IS 'Id event of AA_FUNDING parent table';
COMMENT ON COLUMN CAPS.AA_FUNDING_REASON_ELIG.CD_AA_FUNDING_RSN IS 'Reason code for system determined AA Funding Type';

CREATE SEQUENCE CAPS.SEQ_AA_FUNDING_REASON_ELIG INCREMENT BY 1 MAXVALUE 999999999999999999999999999 MINVALUE 1 CACHE 20;
grant select on caps.SEQ_AA_FUNDING_REASON_ELIG to capson,capsbat,ops$datafix;

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_AA_FUNDING_REASON_ELIG
 BEFORE INSERT
  ON CAPS.AA_FUNDING_REASON_ELIG
  REFERENCING OLD AS OLD NEW AS NEW
  FOR EACH ROW
  declare
     dummy number(16);
  BEGIN
    :new.DT_LAST_UPDATE := SYSDATE;
    IF :new.ID_AA_FUNDING_REASON_ELIG = 0 THEN
      SELECT  CAPS.SEQ_AA_FUNDING_REASON_ELIG.NEXTVAL
      INTO  dummy
      FROM dual;
      :new.ID_AA_FUNDING_REASON_ELIG := dummy;
    END IF;
  END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_AA_FUNDING_REASON_ELIG 
BEFORE UPDATE
ON CAPS.AA_FUNDING_REASON_ELIG
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

ALTER TABLE CAPS.ADO_INFO
ADD(
  IND_HAS_SIBLING_EXT_CASE VARCHAR(1),
  IND_SIBLING_GRP_EXT_CASE VARCHAR(1)
);

COMMENT ON COLUMN CAPS.ADO_INFO.IND_HAS_SIBLING_EXT_CASE IS 'Indicates if primary child has sibling with an open ADO stage in a different case';
COMMENT ON COLUMN CAPS.ADO_INFO.IND_SIBLING_GRP_EXT_CASE IS 'Indicates if primary child and siblings with an open ADO stage in a different case is to be placed in same adoptive home';

CREATE TABLE CAPS.SIBLING_EXTERNAL_LINK
(
      ID_SIBLING_GROUP NUMBER(16) NOT NULL PRIMARY KEY REFERENCES CAPS.SIBLING_GROUP(ID_SIBLING_GROUP),
      DT_LAST_UPDATE DATE NOT NULL,
      ID_PERSON NUMBER(16) NOT NULL REFERENCES CAPS.PERSON(ID_PERSON),
      ID_SIBLING_EXTERNAL_STAGE NUMBER(16) NOT NULL REFERENCES CAPS.STAGE(ID_STAGE),
      CONSTRAINT UK_SIBLING_EXTERNAL UNIQUE(ID_SIBLING_GROUP, ID_PERSON)
) tablespace data01;
grant select,update,insert,delete on CAPS.SIBLING_EXTERNAL_LINK to capson,capsbat,ops$datafix;
grant select on caps.SIBLING_EXTERNAL_LINK to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SIBLING_EXTERNAL_LINK 
BEFORE INSERT
ON CAPS.SIBLING_EXTERNAL_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SIBLING_EXTERNAL_LINK 
BEFORE UPDATE
ON CAPS.SIBLING_EXTERNAL_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

INSERT INTO caps.codes_tables (code_type, code, decode) VALUES ('CYESNOUN','Y','Yes');
INSERT INTO caps.codes_tables (code_type, code, decode) VALUES ('CYESNOUN','N','No');
INSERT INTO caps.codes_tables (code_type, code, decode) VALUES ('CYESNOUN','U','Unknown');

-- New metaphor tab for AA Funding Summary List
Insert into caps.METAPHOR (ID_TAB,TXT_TAB_URL,TXT_TAB_CONSTANT,TXT_TAB,TXT_L1_IMG_INACTIVE,TXT_L1_IMG_ACTIVE,TXT_FILTER_PATH) 
  values ('1770','/workload/EventSearch/displayEventList','ADOPTION_ASSISTANCE_FUNDING_SUMMARY_EVENTLIST','AA Funding Summary',null,null,null);

-- Update existing Adoption Assistance page to be abbreviated  
UPDATE CAPS.METAPHOR
SET TXT_TAB = 'AA Agreement'
WHERE TXT_TAB_CONSTANT = 'ADOPTION_ASSISTANCE_3_EVENTLIST';

UPDATE CAPS.METAPHOR
SET TXT_TAB = 'AA Application'
WHERE TXT_TAB_CONSTANT = 'ADOPTION_ASSISTANCE_APPLICATION_EVENTLIST';

--New AA Funding Summary event type
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CEVNTTYP', 'AFS', 'AA Funding Summary');

--New lookup codes table for Fostering Connection Age Criteria
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2010', '16');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2011', '14');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2012', '12');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2013', '10');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2014', '08');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2015', '06');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2016', '04');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2017', '02');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CFCACCAC', '2018', '00');

--New codes table for AA Funding Reason Eligible
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CAAFRSNE', 'ACIVE', 'Applicable Child IV-E Criteria Met');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CAAFRSNE', 'FCIVE', 'FCC Eligibility is IV-E');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CAAFRSNE', 'RSNEF', 'Reasonable Efforts language not required for IV-E Adoption Assistance');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CAAFRSNE', 'NCIVE', 'Non-Applicable Child IV-E Criteria Met');
INSERT into caps.codes_tables (CODE_TYPE, CODE, DECODE) 
VALUES ('CAAFRSNE', 'NONRC', 'Non-Recurring Only Funding Request');


--New task for PAD AA FUNDING SUMMARY
Insert into caps.TASK (
  CD_TASK,  DT_LAST_UPDATE,  CD_TASK_EVENT_STATUS,
  CD_TASK_EVENT_TYPE,  CD_TASK_LIST_WINDOW,  CD_TASK_PRIOR,
  CD_TASK_STAGE,  CD_TASK_STAGE_PROGRAM,  CD_TASK_TOP_WINDOW,
  IND_TASK_DETAIL_ENABLE,  IND_TASK_EVENT_CREATE,  IND_TASK_EVENT_NAVIG,
  IND_TASK_LIST_ENABLE,  IND_TASK_MULTIPLE_INSTANCE,  IND_TASK_NEW_ENABLE,
  IND_TASK_NEW_USING,  IND_TASK_NU_ACROSS_CASE,  IND_TASK_RTRV_PRIOR_STAGE,
  IND_TASK_SHOW_IN_LIST,  IND_TASK_TODO_ENABLE,  TXT_TASK_DECODE,
  TXT_1ST_TAB,  TXT_2ND_TAB,  TXT_3RD_TAB,
  TXT_EVENT_DETAIL_URL,  IND_TASK_CODE_PREFER,  IND_TASK_NEW_CASE_TODO_ENABLE,
  IND_TASK_FORCE_EVENT_LINK,  IND_STAGE_CLOSURE,  IND_TASK_DELETE) 
values (
'9103',sysdate,null,
'AFS',null,null,
'PAD','CPS',null,
null,'0','1',
null,'1',null,
'0','0','0',
'0','1','AA Funding Summary',
'CASE_CASESEARCH','ADOPTION_ASSISTANCE_EVENTLIST','ADOPTION_ASSISTANCE_FUNDING_SUMMARY_EVENTLIST',
'/financials/AAFundingSummary/displayAAFundingSummary',0,'0',
'0','0',null
);

--New task for ADO AA FUNDING SUMMARY
Insert into caps.TASK (
  CD_TASK,  DT_LAST_UPDATE,  CD_TASK_EVENT_STATUS,
  CD_TASK_EVENT_TYPE,  CD_TASK_LIST_WINDOW,  CD_TASK_PRIOR,
  CD_TASK_STAGE,  CD_TASK_STAGE_PROGRAM,  CD_TASK_TOP_WINDOW,
  IND_TASK_DETAIL_ENABLE,  IND_TASK_EVENT_CREATE,  IND_TASK_EVENT_NAVIG,
  IND_TASK_LIST_ENABLE,  IND_TASK_MULTIPLE_INSTANCE,  IND_TASK_NEW_ENABLE,
  IND_TASK_NEW_USING,  IND_TASK_NU_ACROSS_CASE,  IND_TASK_RTRV_PRIOR_STAGE,
  IND_TASK_SHOW_IN_LIST,  IND_TASK_TODO_ENABLE,  TXT_TASK_DECODE,
  TXT_1ST_TAB,  TXT_2ND_TAB,  TXT_3RD_TAB,
  TXT_EVENT_DETAIL_URL,  IND_TASK_CODE_PREFER,  IND_TASK_NEW_CASE_TODO_ENABLE,
  IND_TASK_FORCE_EVENT_LINK,  IND_STAGE_CLOSURE,  IND_TASK_DELETE) 
values (
'9118',sysdate,null,
'AFS',null,null,
'ADO','CPS',null,
null,'0','1',
null,'1',null,
'0','0','0',
'0','1','AA Funding Summary',
'CASE_CASESEARCH','ADOPTION_ASSISTANCE_EVENTLIST','ADOPTION_ASSISTANCE_FUNDING_SUMMARY_EVENTLIST',
'/financials/AAFundingSummary/displayAAFundingSummary',0,'0',
'0','0',null
);

--New Event list message
INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60890, 'MSG_AA_FNDNG_SMMRY_NOT_EXISTS', 'Funding Summary event in APRV must exist before any AA Application can be added.', 700, 500, 'N');

--New AA Funding messages
INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60891, 'MSG_AA_FUND_INVLD_PWD', 'Valid password is required in order to validate.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60892, 'MSG_APPL_CHILD_REQ', 'Please make sure all results are selected as ''Not Met'' or that at least one result is selected as ''Met'' in the Applicable Child Criteria section.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60893, 'MSG_NON_APPL_IVE_REQ', 'Please make sure all results are selected as ''Not Met'' or that at least one result is selected as ''Met'' in the Non-Applicable Child IV-E Criteria section.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60894, 'MSG_APPL_IVE_REQ', 'Please make sure all results are selected as ''Not Met'' or that at least one result is selected as ''Met'' in the Applicable Child IV-E Criteria section.', 700, 500, 'N');

--New Adoption Information messages
INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60895, 'MSG_IND_SIBLING_PLACED_TOGETHER_REQ', 'You must indicate if it is the plan for sibling(s) with an open ADO stage in a different case to be placed in the same adoptive home as the child.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60896, 'MSG_SIBLING_DUPLICATED', 'Sibling could not be selected more than once.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60897, 'MSG_SIBLING_REQ', 'You have indicated that sibling(s) is to be placed in the same adoptive home, please select at least one sibling.', 700, 500, 'N');

--New Person Characteristics messages
INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60898, 'MSG_ADO_IVE_PRIOR_ADOPTION', 'Please indicate if child was determined IV-E eligible in prior adoption.', 700, 500, 'N');

--New Person Detail messages
INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60899, 'MSG_SSI_ELIGIBLE_REQ', 'Please indicate if SSA determined that the child has met the medical or disability requirements for SSI.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60900, 'MSG_RECV_SSI_PMT_REQ', 'Please indicate if child is currently receiving SSI payments.', 700, 500, 'N');

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60901, 'MSG_DFCS_SSI_PAYEE_REQ', 'Please indicate if DFCS is a representative payee for child''s SSI payment.', 700, 500, 'N');




insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1076, 'SacwisRev5', 'Release 5.0 - DBCR 17038');

commit;
