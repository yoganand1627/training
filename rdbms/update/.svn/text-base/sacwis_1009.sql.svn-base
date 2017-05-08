--STGAP00016132 - Release(4.3) CAPTA-4.3:Spcl Inv add tables codes, and messages

--Per CAPTA - MIC: CPS Investigation Conclusion add columns
alter table CAPS.CPS_INVST_DETAIL add IND_POLICY_VIOLATION VARCHAR2(1) null;
alter table CAPS.CPS_INVST_DETAIL add DT_DETERM_LETTER_SENT Date null;

comment on column CAPS.CPS_INVST_DETAIL.IND_POLICY_VIOLATION is 'Indicates if this is a Policy Violation' ; 
comment on column CAPS.CPS_INVST_DETAIL.DT_DETERM_LETTER_SENT is 'Records the date the Determination Letter was sent' ; 


--Per CAPTA - MIC: Special Investigation add new table SPCL_INVESTIGATION

CREATE TABLE CAPS.SPCL_INVESTIGATION
(ID_SPCL_INV_EVENT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
DT_SPCL_INV_SENT Date null,
DT_SPCL_INV_APPROVED Date null,
IND_CONCUR_ASSMNT_DISP Varchar2(1) null,
IND_CONCUR_ACTION_RECMND Varchar2(1) null,
TXT_CONCUR_COMMENTS Varchar2(500) null,
IND_RCMND_PLCMNT_RSRC_CLOSED Varchar2(1) null,
IND_RCMND_CHLDRN_REMOVED Varchar2(1) null,
IND_RCMND_ACTION_PLAN_DVLPD Varchar2(1) null,
IND_RCMND_NO_CHANGE_STATUS Varchar2(1) null,
IND_RCMND_WAIVER_ATTACHED Varchar2(1) null,
IND_RCMND_OTHER Varchar2(1) null,
TXT_RCMND_OTHER_COMMENTS Varchar2(500) null,
TXT_RESULTS_48HR_STAFFING Varchar2(300) not null,
TXT_NAMES_AGNCY_REP_STAFFING Varchar2(300) not null,
TXT_JUST_HME_REMAIN_OPEN Varchar2(500) null,
TXT_STEPS_ASSURE_SAFETY Varchar2(500) null,
CONSTRAINT PK_ID_EVENT PRIMARY KEY(ID_SPCL_INV_EVENT) using index tablespace index01,
CONSTRAINT FK_EVENT FOREIGN KEY (ID_SPCL_INV_EVENT)
   REFERENCES CAPS.EVENT(ID_EVENT)
 ) tablespace data01;

comment on table CAPS.SPCL_INVESTIGATION is 'The table containing the data for Special Investigation' ;
comment on column CAPS.SPCL_INVESTIGATION.ID_SPCL_INV_EVENT is 'Primary Key' ;
comment on column CAPS.SPCL_INVESTIGATION.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.SPCL_INVESTIGATION.DT_SPCL_INV_SENT is 'records the date the Special Investigation was sent to the  Policay Unit' ;
comment on column CAPS.SPCL_INVESTIGATION.DT_SPCL_INV_APPROVED is 'records the date the Special Investigation was approved by the  Policay Unit' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_CONCUR_ASSMNT_DISP is 'Indicates whether the state office concurs with the assessment disposition' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_CONCUR_ACTION_RECMND is 'Indicates whether the state office concurs with the action that the county has recommended' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_CONCUR_COMMENTS is 'Comments regarding the State Office Concurrence' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_PLCMNT_RSRC_CLOSED is 'Indicates whether the placement resource will be closed' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_CHLDRN_REMOVED is 'Indicates whether the children in the legal custody of DHR/DFCS have been removed from the placement resource in order to assure safety/well being needs are met' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_ACTION_PLAN_DVLPD is 'Indicates whether a corrective action plan has been developed and is attached to this memorandum' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_NO_CHANGE_STATUS is 'Indicates that no change in the status of the resource is recommended' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_WAIVER_ATTACHED is 'Indicates whether a policy waiver or other request on behalf of a child in DHR/DFCS custody is attached to this memorandum' ;
comment on column CAPS.SPCL_INVESTIGATION.IND_RCMND_OTHER is 'Indicates whether the county has another recommendation' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_RCMND_OTHER_COMMENTS is 'Comments regarding the county''s other recommendation' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_RESULTS_48HR_STAFFING is 'Comments regarding the results of the 48 hour Case Staffing' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_NAMES_AGNCY_REP_STAFFING is 'Comments regarding the names and agencies represented at Case Staffing' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_JUST_HME_REMAIN_OPEN is 'Comments regarding justification for the DFCS home to remain open' ;
comment on column CAPS.SPCL_INVESTIGATION.TXT_STEPS_ASSURE_SAFETY is 'Comments regarding the steps that will be taken to assure the safety of the foster children placed in the home' ;

grant select,update,insert,delete on caps.SPCL_INVESTIGATION to capson,capsbat,ops$datafix;
grant select on caps.SPCL_INVESTIGATION to operator,shinesdm;

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPCL_INVESTIGATION
BEFORE UPDATE
ON CAPS.SPCL_INVESTIGATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPCL_INVESTIGATION
BEFORE INSERT
ON CAPS.SPCL_INVESTIGATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/


--Per CAPTA - MIC: Special Investigation add new table SPCL_INV_HME_WAIVER_CHILD_HIST


CREATE TABLE CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST
(ID_CHILD Number(16,0) not null,
ID_SPCL_INV_EVENT Number(16,0) not null,
DT_LAST_UPDATE Date not null,
CD_CHILD_LEGAL_COUNTY Varchar2(3) null,
CD_CHILD_LEGAL_STATUS Varchar2(3) null,
CD_CHILD_PERMNCY_PLAN Varchar2(3) null,
CD_CHILD_PLCMNT_TYPE Varchar2(3) null,
NUM_YEAR_IN_PLCMNT Number(2,0) null,
NUM_MONTHS_IN_PLCMNT Number(3,0) null,
CONSTRAINT PK_SPCL_INV_HME_WVR_CHILD_HIST PRIMARY KEY(ID_CHILD,ID_SPCL_INV_EVENT) using index tablespace index01,
CONSTRAINT FK_SPCL_INV_HME_WAIVER_PERSON FOREIGN KEY (ID_CHILD)
   REFERENCES CAPS.PERSON_ENC(ID_PERSON),
CONSTRAINT FK_HME_WAIVER_SPCL_INV FOREIGN KEY (ID_SPCL_INV_EVENT)
 REFERENCES CAPS.SPCL_INVESTIGATION(ID_SPCL_INV_EVENT)
 ) tablespace data01;

create index caps.IND_SPCL_INV_HM_WVR_CHD_HST_1 on CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST(ID_CHILD) tablespace index01;

comment on table CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST is 'The table containing the children whom the Home Waiver is allowing to stay in the home during a Special Investigation' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.ID_CHILD is 'Composite Primary Key' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.ID_SPCL_INV_EVENT is 'Composite Primary Key' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.DT_LAST_UPDATE is 'Used to record the last updated date' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.CD_CHILD_LEGAL_COUNTY is 'records the child''s legal county code' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.CD_CHILD_LEGAL_STATUS is 'records the child''s legal status code' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.CD_CHILD_PERMNCY_PLAN is 'records the child''s permanency plan code' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.CD_CHILD_PLCMNT_TYPE is 'records the child''s placement type code' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.NUM_YEAR_IN_PLCMNT is 'records the number of years the child has been in the placement' ;
comment on column CAPS.SPCL_INV_HME_WAIVER_CHILD_HIST.NUM_MONTHS_IN_PLCMNT is 'records the number of mopnths the child has been in the placement' ;

grant select,update,insert,delete on caps.SPCL_INV_HME_WAIVER_CHILD_HIST to capson,capsbat,ops$datafix;
grant select on caps.SPCL_INV_HME_WAIVER_CHILD_HIST to operator,shinesdm;


/
CREATE OR REPLACE TRIGGER CAPS.TUBR_SPCL_INV_HME_WVR_CHLD_HST
BEFORE UPDATE
ON CAPS.CONTACT_FOR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
END;
/

/
CREATE OR REPLACE TRIGGER CAPS.TIBR_SPCL_INV_HME_WVR_CHLD_HST
BEFORE INSERT
ON CAPS.CONTACT_FOR
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
END;
/
 
 
--Add row to METAPHOR table
INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab, txt_filter_path, dt_last_update )
VALUES
(776, '/investigation/SpecialInvestigation/displaySpclInvestigation' , 'SPECIAL_INVESTIGATION_SPCLINV' , 'Special Investigation' , 'null' , sysdate);


--Task code for Special Investigation in Investigation stage
 INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('2270',sysdate,'SPI','NULL','INV','CPS',
 'NULL', '1','1','0','0','0',
 '0','1','Special Investigation','CASE_CASESEARCH','RISK_ASSESSMENT_RISKASSMT','SPECIAL_INVESTIGATION_SPCLINV',
 '/investigation/SpecialInvestigation/displaySpclInvestigation',0,'0','0','0');
 
--Task code for Approve Special Investigation in Investigation stage
 INSERT INTO caps.task t
 (t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
 t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
  t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
  t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
  VALUES
 ('2265',sysdate,'APP','NULL','INV','CPS',
  'NULL', '0','1','0','0','0',
  '0','0','Approve Special Investigation','CASE_CASESEARCH','RISK_ASSESSMENT_RISKASSMT','SPECIAL_INVESTIGATION_SPCLINV',
  '/investigation/SpecialInvestigation/displaySpclInvestigation',0,'0','0','0');

 INSERT INTO CAPS.CODES_TABLES VALUES('CEVNTTYP', 'SPI', 'Special Investigation', NULL, SYSDATE);


--Per CAPTA - MIC: CPS Investigation Conclusion add new Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60831, SYSDATE, 'MSG_DT_DET_LETTER_REQ', 'Please enter the date that the Determination Letter was sent.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60832, SYSDATE, 'MSG_DT_DET_LETTER_INVAL', 'The Date Determination Letter sent cannot be a future date and must occur after the date that the investigation started.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60833, SYSDATE, 'MSG_INV_POLICY_VIOL_REQ', '''Is this a Policy Violation?'' response is a required when there is a Special Investigation that is not Maltreatment in Care', 500, 700, 'N');



--Per CAPTA - MIC: Special Investigation add new Codes Tables
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCA', 'The Special Investigations Summary Report was not submitted to the state office within ten (10) calendar days from the conclusion of the investigation.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCB', 'The foster parent (s) were not provided with notification of Bill of Rights and right to have advocate during the investigation.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCC', 'The investigation was not initiated in a timely manner.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCD', 'The documentation did not reflect an adequate safety assessment at the initial contact with the children to determine whether they were threat of immediate harm.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCE', 'The children were removed from the home during the investigation although there were no indication that they were unsafe.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCF', 'There was inadequate screening for previous CPS history, prior policy violations, etc.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCG', 'The interview with the child was not conducted separately and in private, a way from the caregiver and other household members.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCH', 'Separate interviews with all children in the home to observe for abuse/neglect were not conducted.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCI', 'The documentation did not reflect whether observation of the home environment for evidence to support/refute the allegations.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCJ', 'The caregiver (s) and other adults frequently in the home were not interviewed during the investigation.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCK', 'The foster parent.s spouse was not interviewed during the investigation.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCL', 'The Resource Development staff was not notified/interviewed regarding the abuse/neglect allegations.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCM', 'The private agency director/staff and/or oversight agency was not notified/interviewed regarding the abuse/neglect allegations.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCN', 'The documentation did not indicate whether the home conditions were observed to assess whether there are conditions that may affect the safety of the children.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCO', 'The DFCS CM was not contacted/interviewed regarding the abuse/neglect allegations, to assess their knowledge of the family in relationship to the allegation.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCP', 'The documentation did not indicate that a review of any physical evidence (as applicable) was done to support/refute allegations.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCQ', 'Contacts with at least two (appropriate) collateral sources (preferably mandated reporters, i.e. medical and school personnel, therapists, etc.) were not conducted to verify or refute or obtain additional information.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCR', 'Law Enforcement was not provided with the neglect/abuse report, as required in such cases.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCS', 'The required Case Staffing at the conclusion of the investigation-within 48 hours was not conducted, or was not conducted timely.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE ) VALUES ('CPUNOCR', 'NCT', 'The required Case Staffing at the conclusion of the investigation did not include all relevant parties to discuss findings and recommendations.');


--Per CAPTA - MIC: Special Investigation add new Messages
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60834, SYSDATE, 'MSG_SO_CONCURR_REQ', 'A State Office Concurrence decision must be entered in order to approve this Special Investigation.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60835, SYSDATE, 'MSG_SO_NON_CONCURR_REQ', 'A reason for Non-Concurrence must be entered in order to approve this Special Investigation.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60836, SYSDATE, 'MSG_CR_PLAN_REQ', 'Please enter a recommended plan for the Placement Resource/Adoptive Home.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60837, SYSDATE, 'MSG_CR_PLAN_COMMENTS_REQ', 'Please provide comments regarding the recommended plan for the placement resource/adoptive home.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60838, SYSDATE, 'MSG_CR_CASE_STAFF_RESULTS_REQ', 'Please document the results of the 48 Hour Case Staffing.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60839, SYSDATE, 'MSG_CR_CASE_STAFF_NAMES_AGENC_REQ', 'Please document the names and agencies that were represented at the Case Staffing.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60840, SYSDATE, 'MSG_HR_OPN_HM_JUSTIF_REQ', 'Please document justification for why the DFCS home should remain open.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60841, SYSDATE, 'MSG_HR_OPN_HM_SAFET_STEPS_REQ', 'Please document steps to be taken to ensure the safety of children placed in the home.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60842, SYSDATE, 'MSG_HR_OPN_HM_CHILD_REMAIN_REQ', 'Please identify the children that will remain in the foster home.', 500, 700, 'N');
Insert into caps.message (NBR_MESSAGE, DT_LAST_UPDATE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) Values (60843, SYSDATE, 'MSG_CR_POL_WVR_REQ', 'The policy waiver option must be selected from the County Recommendation section if entering a Home Waiver.', 500, 700, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1010, 'SacwisRev4', 'Release 4.3 - DBCR 16132');

commit;

