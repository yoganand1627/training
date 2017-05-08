
-- Standard Alter Table SQL

ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_CNTBL_RESOURCE_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_GROSS_EARNED_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_GROSS_UNEARNED_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_TOTAL_GROSS_INCOME_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_CNTBL_INC_STD_NEED_CHILD NUMBER(16,2)     NULL
;
ALTER TABLE CAPS.FCE_ELIGIBILITY ADD AMT_CNTBL_INC_30_ONE_CHILD NUMBER(16,2)     NULL
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_PLAN_SEC_GOAL_EVENT
    ON CAPS.PLAN_SEC_GOAL(ID_EVENT)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001678
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBTYPE' AND code = '05';
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBTYPE' AND code = '15';
UPDATE CAPS.CODES_TABLES SET DECODE = 'State Adpt Medicaid Assistance (D02)' WHERE CODE = '11' AND code_type = 'CSUBTYPE'; 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBTYPE','18','Spec Svc Asst - Supp Sprv (Ent Cd 17)',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBTYPE','10','Spec Svc Asst - Respite (Ent Cd 60)',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBTYPE','19','Spec Svc Asst - Purch of Svc (Ent Cd 57)',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBTYPE','20','Spec Svc Asst - FP Conv (Ent Cd 77)',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBTYPE','21','Spec Svc Asst - Othr Reimb Svc (Ent Cd 58)',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSPLSERV','DCR','Day Care',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSPLSERV','ORT','Orthodontics',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSPLSERV','RES','Respite',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSPLSERV','TCS','Therapy/Counseling/Surgery',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSPLSERV','XXX','Other',SYSDATE); 

UPDATE CAPS.CODES_TABLES SET decode = 'Child Emancipated' WHERE code_type = 'CSUBCLOS' AND CODE = 'CE';  
UPDATE CAPS.CODES_TABLES SET decode = 'Adoption Dissolution' WHERE code_type = 'CSUBCLOS' AND CODE = 'AD';  
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','SF','18 - Not in School Full Time',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','OA','Over Age/Completed School',SYSDATE); 
UPDATE CAPS.CODES_TABLES SET decode = 'Deceased Child' WHERE code_type = 'CSUBCLOS' AND CODE = 'CS'; 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','AR','Adoptive Parent Failed to Respond to Renewal',SYSDATE); 
UPDATE CAPS.CODES_TABLES SET decode = 'Deceased Parent' WHERE code_type = 'CSUBCLOS' AND CODE = 'DE';
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','PF','Parent Legal Fin Resp Cannot be Est',SYSDATE); 
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','CA','Child Turns 21',SYSDATE);
INSERT INTO CAPS.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSUBCLOS','XX','Other',SYSDATE); 

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'CC'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'CM'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'FC'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'NN'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'NP'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'SE'; 
UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE WHERE code_type = 'CSUBCLOS' AND code = 'SS'; 

-- change STGAP00001683
-- Codes table for TCM Eligible Programs
INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMPROG', 'SSM', 'Child Receiving SSI Medicaid', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMPROG', 'AAM', 'Child Receiving Adoption Assistance Medicaid', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMPROG', 'CMS', 'Child in the Children''s Medical Service Program', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMPROG', 'GPP', 'Child in Georgia Pediatric Program', SYSDATE);

-- Codes table for TCM (Medical) Services Provided
INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMSVCS', 'BEH', 'Client''s Behavioral Needs', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMSVCS', 'NUT', 'Client''s Nutritional Needs', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMSVCS', 'SBA', 'Client''s Substance Abuse Needs', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CTCMSVCS', 'XXX', 'Client''s Other Medical Needs', SYSDATE);

-- Add TCM to Contact Types 
INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CCNTCTYP', 'HTCM', 'TCM', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CCNTCTYP', 'LTCM', 'TCM', SYSDATE);

INSERT INTO CAPS.CODES_TABLES
(code_type, code, DECODE, dt_last_update)
VALUES
('CCNTCTYP', 'MTCM', 'TCM', SYSDATE);

-- change STGAP00001686
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CFCERNE','A13','The child has more than $10,000 equity in property or resources.',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CFCERNE','A14','The Child''s Income is greater than or equal to the IV-E Gross Income Limit.',SYSDATE); 
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CFCERNE','A15','The Child''s Net Countable Income (minus deductions) is greater than or equal to the IV-E Standard of Need Income Limit (based on Standard of Need Test).',SYSDATE);
INSERT INTO CAPS.CODES_TABLES(code_type,code,DECODE,dt_last_update) VALUES('CFCERNE','A16','The Child''s Net Countable Income (minus deductions) is greater than or equal to the IV-E Standard of Need Income Limit (based on $30 and 1/3 Test).',SYSDATE);

-- change STGAP00001687
-- Need new messages for adoption section in person characterstics detail page.

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60186, 'MSG_PER_PREV_ADOPT_REQ' 
,'Previously Adopted - This field is required.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60187, 'MSG_PER_ADOPT_TYPE_REQ' 
,'If Previously Adopted, Adoption Type is required.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60188, 'MSG_PER_ADO_STATE_REQ' 
,'Please select a state.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60189, 'MSG_PER_ADO_COUNTY_REQ' 
,'Please select a county.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60190, 'MSG_PER_ADO_COUNTRY_REQ' 
,'Please select a country.',500,700,'N');

-- change STGAP00001689
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
VALUES (60191, 'MSG_FCCP_GOAL_REQD', 'Please select a Goal from the Dropdown box.', 700, 500, 'N');

-- change STGAP00001690
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
VALUES (60192, 'MSG_SVC_AUTH_ERYIN_CASE_TYP_REQD', 'When the selected UAS Code is PUP, Early Intervention, Prevention Services, Homestead Services or Parent Aid Services the Early Intervention Case Type is required.', 700, 500, 'N');

-- change STGAP00001691
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
VALUES (60193, 'MSG_SVC_AUTH_PUP_OUTCM_TYP_REQD', 'When the selected UAS Code is PUP, Early Intervention, Prevention Services, Homestead Services or Parent Aid Services the PUP Outcome Type is required.', 700, 500, 'N');

-- change STGAP00001692
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60194, 'MSG_ADO_SP_NEEDS_MEMO_REQD','The Special Needs Determination Memo must be attached to the case record in the External Documentation Detail page.',760,500,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60195, 'MSG_ADO_MAN_INV_ADOP_ASST','A manual invoice may need to be created for the months prior to reinstatement.',760,500,'N');

update caps.message 
set TXT_MESSAGE ='Amount for non-recurring subsidy cannot exceed $2000.00'
where TXT_MESSAGE_NAME ='MSG_NONRECURR_SUB_AMT';

-- change STGAP00001696
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSVCQLTY','EX','Excellent',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSVCQLTY','GD','Good',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSVCQLTY','FR','Fair',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CSVCQLTY','PR','Poor',SYSDATE);

-- change STGAP00001698
update caps.message set TXT_MESSAGE ='You must enter a name in ''Other'' field if Address/Phone information for ''Other'' is entered.'
where TXT_MESSAGE_NAME ='MSG_OTHER_NOT_ENTERED';

-- change STGAP00001699
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','RFD','Regular Foster Care Per-Diem'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','EFD','Special Foster Care Per-Diem'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','LOC','RBWO'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','RWW','RBWO with Waiver'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','SFD','Specialized Foster Care Per-Diem');
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','ERR','Enhanced Relative Rate'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','RCS','Relative Care Subsidy'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','ERS','Enhanced Relative Care Subsidy'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','SUG','Subsidized Guardianship'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','ESG','Enhanced Subsidized Guardianship');
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','NSG','Non-Relative Subsidized Guardianship'); 
insert into caps.codes_tables  (code_type,code,decode)values('CPOCTYPE','NEG','Non-Relative Enhanced Subsidized Guardianship'); 

-- change STGAP00001700
INSERT INTO CAPS.TASK 
  ( CD_TASK,CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE,
CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE )
 VALUES 
   ( '9460','', 'POC', '', NULL, 'SUB', 'CPS', '', NULL, '1', '1', NULL, '1', NULL, '0', '0', '0', '1', NULL, 'Payment of Care', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PAYMENT_OF_CARE_EVENTLIST', '/casemgmt/PaymentOfCare/displayPOC', 3, '1', '0', '0'); 
INSERT INTO CAPS.TASK 
  ( CD_TASK,CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE ) 
 VALUES 
  ( '9470','', 'POC', '', NULL, 'PFC', 'CPS', '', NULL, '1', '1', NULL, '1', NULL, '0', '0', '0', '1', NULL, 'Payment of Care', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PAYMENT_OF_CARE_EVENTLIST', '/casemgmt/PaymentOfCare/displayPOC', 3, '1', '0', '0'); 
Insert into CAPS.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
 Values
   ('9475', 'APP', 'PFC', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve Payment of Care', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PAYMENT_OF_CARE_EVENTLIST', '/casemgmt/PaymentOfCare/displayPOC');
Insert into CAPS.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
 Values
   ('9465', 'APP', 'SUB', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve Payment of Care', 'CASE_CASESEARCH', 'PLACEMENT_EVENTLIST', 'PAYMENT_OF_CARE_EVENTLIST', '/casemgmt/PaymentOfCare/displayPOC');
INSERT INTO CAPS.METAPHOR ( ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, TXT_L1_IMG_INACTIVE,TXT_L1_IMG_ACTIVE, TXT_FILTER_PATH) VALUES ( 
1560, '/workload/EventSearch/displayEventList', 'PAYMENT_OF_CARE_EVENTLIST'
, 'Payment of Care', NULL, NULL, NULL); 

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (136, 'SacwisRev2', 'static updates and schema changes');

commit;
