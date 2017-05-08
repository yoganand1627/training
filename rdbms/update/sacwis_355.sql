--METAPHOR table insert for Exchange search (STGAP00009464)

insert into CAPS.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, DT_LAST_UPDATE)
Values
   (1650, '/exchange/ExchangeChildSearch/displayExchangeChildSearch', 'EXCHANGE_CHILD_SEARCH', 'Exchange Child Search', sysdate);
   
insert into CAPS.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, DT_LAST_UPDATE)
Values
   (1655, '/exchange/ExchangeHomeSearch/displayExchangeHomeSearch', 'EXCHANGE_HOME_SEARCH', 'Exchange Home Search', sysdate);



-- Codes Table Changes for ADAM-- (STGAP00009469)


--Codes Table changes for Adoption Assistance Agreement --


-- Code Type CPAYMTHD --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPAYMTHD', 'DIR', 'Direct to Provider', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPAYMTHD', 'PAR', 'Adoptive Parent Reimbursement', null, sysdate);


-- Code Type CSUBTYPE --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '22', 'Non-Recurring Adoption Related Legal Fees', 

null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '23', 'Non-Recurring Travel', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '24', 'Non-Recurring Lodging and Meals', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '25', 'Non-Recurring Physicals for Adoptive Parents', 

null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSUBTYPE', '26', 'Non-Recurring Private Agency Assessment', null, 

sysdate);

update CAPS.CODES_TABLES set dt_end = SYSDATE where code_type = 'CSUBTYPE' and code = '17';


-- Code Type COSATYPE --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COSATYPE', '01', 'Receiving IV-E assistance from another state', 

null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COSATYPE', '02', 'Receiving non IV-E assistance from another state', 

null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COSATYPE', '03', 'Georgia IV-E case living out of state', null, 

sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COSATYPE', '04', 'Georgia non-IV-E case living out of state', null, 

sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('COSATYPE', '05', 'None of the Above', null, sysdate);




-- Codes Table changes for Adoption Assistance Application Detail page --


-- Code Type CAPPSTS --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CAPPSTS', 'Y', 'Approved', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CAPPSTS', 'N', 'Denied', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CAPPSTS', 'D', 'Deferred', null, sysdate);

-- Code Type CAPRTYPE --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CAPRTYPE', 'B', 'Basic', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CAPRTYPE', 'S', 'Specialized', null, sysdate);




-- Codes Table changes for Non-Incident AFCARS Information page --


-- Code Type CADSEVER --



insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADSEVER', '01', 'Mild', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADSEVER', '02', 'Moderate', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADSEVER', '03', 'Severe', null, sysdate);



-- Codes Table changes for Person Detail page --


-- Code Type CRPTRINT --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CRPTRINT', 'BB', 'Biological and Legal Father', null, sysdate);


-- Code Type CSRCRPTR --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CSRCRPTR', 'BB', 'Biological and Legal Father', null, sysdate);



-- Codes Table changes for Person Identifiers Detail page --


-- Code Type CNUMTYPE --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMTYPE', 'ICAMA Case#', '*', null, sysdate);


-- Codes Table changes for Exchange Child Detail page --


-- Code Type CADCHAR --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADCHAR', '01', 'Mental Retardation', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADCHAR', '02', 'Visual/hearing Impairment', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADCHAR', '03', 'Physically Disabled', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADCHAR', '04', 'Emotionally Disturbed', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADCHAR', '05', 'Other Medical Diagnoses', null, sysdate);


-- Code Type CADBKRNF --


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADBKRNF', '06', 'Family Hx of Drugs/Alchohol', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADBKRNF', '07', 'Family Hx of Mental Illness', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADBKRNF', '08', 'Family Hx of Mental Retardation', null, 

sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADBKRNF', '09', 'Family Hx of Sexual Abuse', null, sysdate);


-- Code Type CANONAV --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '00', 'Available', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '01', 'CTY. ID Resource', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '02', 'Plan Foster/Adopt Plcmnt', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '03', 'Consideration', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '04', 'Selected', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '05', 'Plan Foster Parent', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '06', 'Not Ready', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '07', 'Long Term Foster Care', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '08', 'Goal Not Adoption', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '09', 'Regular Placement', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '10', 'Foster Parent Placement', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '11', 'Closed/No Placement', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '12', 'Foster/Adopt Placement', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '13', 'Plan Relative', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '14', 'Plan Relative Fstr/Prnt', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '15', 'In Relative Placement', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '16', 'In Rel. Fstr-Prnt Plcmnt', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '17', 'Reunify W/Other Parent', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '18', 'Plan Ind. Rel. Custody', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '19', 'Custody Rel JV Crt', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CANONAV', '50', 'Uncoded', null, sysdate);



-- Codes Table changes for Exchange Child Search Detail page --

-- Code Type CADRACE --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'AA', 'American Indian/Alaska Native', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'AN', 'Asian', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'BK', 'Black/African American', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'BW', 'Black and White', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'HP', 'Native Hawaiian/Other Pacific Islander', null, 

sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'UD', 'Unable to Determine', null, sysdate);


insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CADRACE', 'WT', 'White', null, sysdate);




-- Codes Table changes for Foster Home Conversion page --

-- Code Type CFHCCLSR --

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CFHCCLSR', 'AF', 'Adoption Finalized', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CFHCCLSR', 'NO', 'No Longer Pursuing Adoption', null, sysdate);


-- Codes Table changes for Home Information page --

-- Code Type CINFCVRD --

update caps.codes_tables set decode = 'Non-Special Needs Waiting List' where code_type = 'CINFCVRD' and code = 'WTG';

-- Code Type CPRGMINT --

update caps.codes_tables set decode = 'Foster/Adopt' where code_type = 'CPRGMINT' and code = 'FOA';


-- Code Type CEVNTTYP --

Insert into caps.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) 
values ('CEVNTTYP','HCN','Home Conversion',null,sysdate);


-- Codes Table changes for FA Home Search page --

-- Code Type CPL --

update caps.Codes_Tables set decode = 'ADD/ADHD' where code_type = 'CPL' and code = '03';

update caps.Codes_Tables set decode = 'Animal Cruelty' where code_type = 'CPL' and code = '08';

update caps.Codes_Tables set decode = 'Depression' where code_type = 'CPL' and code = '14';

update caps.Codes_Tables set decode = 'Developmentally Disabled' where code_type = 'CPL' and code = '17';

update caps.Codes_Tables set decode = 'Enuresis/Encorpresis' where code_type = 'CPL' and code = '24';

update caps.Codes_Tables set decode = 'Fire Setting' where code_type = 'CPL' and code = '30';

update caps.Codes_Tables set decode = 'AIDS' where code_type = 'CPL' and code = '38';

update caps.Codes_Tables set decode = 'Infant Alcohol Addiction/Prenatal Exposure to Alcohol/Fetal Alcohol Syndrome or Effect' where code_type = 'CPL' and code = 

'40';

update caps.Codes_Tables set decode = 'Learning Disability' where code_type = 'CPL' and code = '44';

update caps.Codes_Tables set decode = 'Pregnant' where code_type = 'CPL' and code = '62';

update caps.Codes_Tables set decode = 'Speech Disability' where code_type = 'CPL' and code = '74';

update caps.Codes_Tables set decode = 'Terminal Illness' where code_type = 'CPL' and code = '80';

update caps.Codes_Tables set decode = 'Visually Impaired Diagnosed' where code_type = 'CPL' and code = '84';

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPL', '103', 'HIV Positive', null, sysdate);

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CPL', '123', 'Adjustment Disorder', null, sysdate);


-- Codes Table changes for Output Launch (Child Life History Checklist) -- 

-- Code Type CEVNTTYP --

Insert into caps.CODES_TABLES (CODE_TYPE,CODE,DECODE,DT_END,DT_LAST_UPDATE) 
values ('CEVNTTYP','CCK','Child Life History Checklist',null,sysdate);

-- New Messages for Foster Home Conversion Page --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60450, 'MSG_FAD_CONV_INQ_DATE', 'The Inquiry date should be different than the initial foster home inquiry date.', 700, 500, 'N');


Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60451, 'MSG_FAD_CONV_APP_DATE', 'The Applied date should be different than the Approval Begin date of the foster home.', 700, 500, 'N');



-- New Messages for Adoption Assistance Agreement --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60452, 'MSG_NO_APPROVED_AA_APP', 'In order to create an Agreement you must first complete the Adoption Assistance Application.', 700, 500, 

'N');


Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60453, 'MSG_NON_RECURRING_LIMIT', 'Adding this Non-Recurring Expenses will take the child over the spending limit of $2,000', 700, 500, 'N');


-- New Messages for Adoption Assistance Application page --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60454, 'MSG_NO_IVE_ON_SAVE', 'IV-E Determination is required before the Adoption Assistance Application can be submitted.', 700, 500, 'N');



-- New Messages for Stage Closure Detail page --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60455, 'MSG_CLOSE_ADO_NEW_NAME', 'The child??s new name is required if Adoption Finalized is the closure reason.', 700, 500, 'N');


-- New Messages for Stage Progression Detail page --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60456, 'MSG_ADO_STAGE_EXISTS', 'This child is already in ADO', 700, 500, 'N');


-- New Messages for Exchange Home Detail Page --


Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60457, 'MSG_NO_SEVERITY', 'One or more special needs have been selected without specifying a severity.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60458, 'MSG_REREG_DT_BEFORE_REG', 'Date Re-registered cannot be earlier than the date registered.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60459, 'MSG_REG_DT_BEFORE_APPROVED', 'Date Registered cannot occur before Date Approved.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60460, 'MSG_SAVE_BEFORE_MATCH', 'You must save the page before performing a match.', 700, 500, 'N');


-- New Messages for Home Information Page --

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60461, 'MSG_FAD_MARITAL_NOT_FOR_ADO', 'This marital status is not applicable for Adoptive Homes.', 700, 500, 'N');


-- New Messages for Person Characteristics Page --


Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60462, 'MSG_ADO_DISS_DATE_REQ', 'Please enter a dissolution date.', 700, 500, 'N');



-- New Messages for Sibling Group Information Page --


Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60463, 'MSG_ADD_NO_FCC', 'You have attempted to add a person without an FCC stage to the sibling group list.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60464, 'MSG_SIB_SELECT_ONE', 'One or more sibling groups have no selection and will not exist after the page is saved. Press OK to continue 

or Cancel to stay on the current page.', 700, 500, 'N');

Insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values(  SYSDATE, 60465, 'MSG_FND_RSRC_NO_GROUP', 'You must select a Sub Group to match by before selecting a resource.', 700, 500, 'N');


-- STGAP00009481
-- DB Updates for Output Launch page -- 

-- INSERTING into Metaphor table for Output Launch (Child Life History Checklist)

insert into caps.Metaphor (id_tab, txt_tab_url, txt_tab_constant, txt_tab, dt_last_update) 
values(665, '/workload/EventSearch/displayEventList', 'CHILD_LIFE_HISTORY_CHKLST_EVENTLIST', 'Child Life History<br>Checklist',sysdate);

-- INSERTING into TASK for Output Launch (Child Life History Checklist) --

Insert into caps.TASK (CD_TASK,DT_LAST_UPDATE,CD_TASK_EVENT_STATUS,CD_TASK_EVENT_TYPE,CD_TASK_LIST_WINDOW,CD_TASK_PRIOR,CD_TASK_STAGE,CD_TASK_STAGE_PROGRAM,CD_TASK_TOP_WINDOW,IND_TASK_DETAIL_ENABLE,IND_TASK_EVENT_CREATE,IND_TASK_EVENT_NAVIG,IND_TASK_LIST_ENABLE,IND_TASK_MULTIPLE_INSTANCE,IND_TASK_NEW_ENABLE,IND_TASK_NEW_USING,IND_TASK_NU_ACROSS_CASE,IND_TASK_RTRV_PRIOR_STAGE,IND_TASK_SHOW_IN_LIST,IND_TASK_TODO_ENABLE,TXT_TASK_DECODE,TXT_1ST_TAB,TXT_2ND_TAB,TXT_3RD_TAB,TXT_EVENT_DETAIL_URL,IND_TASK_CODE_PREFER,IND_TASK_NEW_CASE_TODO_ENABLE,IND_TASK_FORCE_EVENT_LINK,IND_STAGE_CLOSURE) 
values ('8720',sysdate,'COMP','CCK','CCMN51W',null,'ADO','CPS','CSUB09C',null,'1','1',null,'1',null,'1','0','0','1',null,'Child Life History Check List','CASE_CASESEARCH','HISTORY_EVENTLIST','CHILD_LIFE_HISTORY_CHKLST_EVENTLIST','/admin/OutputLaunch/displayInitOutputLaunch','3','1','0','0');

Insert into caps.task (CD_TASK,DT_LAST_UPDATE,CD_TASK_EVENT_STATUS,CD_TASK_EVENT_TYPE,CD_TASK_LIST_WINDOW,CD_TASK_PRIOR,CD_TASK_STAGE,CD_TASK_STAGE_PROGRAM,CD_TASK_TOP_WINDOW,IND_TASK_DETAIL_ENABLE,IND_TASK_EVENT_CREATE,IND_TASK_EVENT_NAVIG,IND_TASK_LIST_ENABLE,IND_TASK_MULTIPLE_INSTANCE,IND_TASK_NEW_ENABLE,IND_TASK_NEW_USING,IND_TASK_NU_ACROSS_CASE,IND_TASK_RTRV_PRIOR_STAGE,IND_TASK_SHOW_IN_LIST,IND_TASK_TODO_ENABLE,TXT_TASK_DECODE,TXT_1ST_TAB,TXT_2ND_TAB,TXT_3RD_TAB,TXT_EVENT_DETAIL_URL,IND_TASK_CODE_PREFER,IND_TASK_NEW_CASE_TODO_ENABLE,IND_TASK_FORCE_EVENT_LINK,IND_STAGE_CLOSURE) 
values ('8900',sysdate,null,'APP',null,null,'ADO','CPS','CCMN65W',null,'0','1',null,'1',null,'0','0','0','0',null,'Approve Child Life History Check List','CASE_CASESEARCH','HISTORY_EVENTLIST','CHILD_LIFE_HISTORY_CHKLST_EVENTLIST','/admin/OutputLaunch/displayInitOutputLaunch','0','0','0','0');


-- Task table update for Elligibility tab --

UPDATE CAPS.TASk 
SET TXT_TASK_DECODE = 'Eligibility Summary', 
TXT_2ND_TAB = 'FC_ASSISTANCE_EVENTLIST',
TXT_3RD_TAB = 'ELIGIBILITY_SUMMARY_EVENTLIST',
TXT_EVENT_DETAIL_URL = '/fce/EligibilitySummary/displayEligibilitySummary',
IND_TASK_NEW_CASE_TODO_ENABLE = '0',
IND_TASK_FORCE_EVENT_LINK = '1'
WHERE CD_TASK IN ('9110', '8620');

-- Add 3 columns to PERSON/PERSON_ENC to support Adoption Enhancements (STGAP00009467)

alter table caps.person_enc add dt_dissolution date;
alter table caps.person_enc add dt_prev_adoption date;
alter table caps.person_enc add txt_name_of_ado_agency varchar2(80);


  CREATE OR REPLACE VIEW CAPS.PERSON ("ID_PERSON", "DT_LAST_UPDATE", "CD_PERSON_SEX", "ADDR_PERSON_ST_LN_1", "ADDR_PERSON_CITY", "ADDR_PERSON_ZIP", "DT_PERSON_DEATH", "DT_PERSON_BIRTH", "CD_PERSON_RELIGION", "CD_PERSON_CHAR", "CD_PERSON_LIV_ARR", "CD_PERS_GUARD_CNSRV", "CD_PERSON_STATUS", "CD_PERSON_DEATH", "CD_PERSON_MARITAL_STATUS", "CD_PERSON_LANGUAGE", "CD_PERSON_ETHNIC_GROUP", "CD_PERSON_STATE", "CD_PERSON_COUNTY", "IND_PERSON_DOB_APPROX", "IND_PERS_CANCEL_HIST", "NBR_PERSON_AGE", "NBR_PERSON_PHONE", "NBR_PERSON_ID_NUMBER", "NM_PERSON_FIRST", "NM_PERSON_MIDDLE", "NM_PERSON_LAST", "NM_PERSON_FULL", "TXT_PERSON_OCCUPATION", "CD_PERSON_SUFFIX", "IND_AUTO_PERS_MERGE", "CD_DISASTER_RLF", "CD_PERSON_TITLE", "IND_PERSON_US_CITIZEN", "CD_PERSON_IMMIGRATION_STATUS", "CD_PERSON_COUNTRY_ORIGIN", "TXT_CHAR_CMNTS", "CD_PERS_NOT_YET_DIAG", "CD_PERSON_PROOF_CITIZENSHIP", "TXT_PERSON_OTHER_RELATIONSHIPS", "CD_MATCH_TYPE", "CD_SMILE_CLIENT", "TXT_IDS_NUMBER", "IND_PREV_ADOPTED", "IND_PRIVATE", "IND_PUBLIC", "IND_INTRNTL", "CD_ADOPT_STATE", "CD_ADOPT_COUNTY", "CD_ADOPT_CNTRY", "IND_ADOPT_DISLUTON", "TXT_PERSON_ADDL_CMNTS","DT_DISSOLUTION","DT_PREV_ADOPTION","TXT_NAME_OF_ADO_AGENCY") AS 
  SELECT
ID_PERSON,
DT_LAST_UPDATE,
CD_PERSON_SEX,
ADDR_PERSON_ST_LN_1,
ADDR_PERSON_CITY,
ADDR_PERSON_ZIP,
DT_PERSON_DEATH ,
DT_PERSON_BIRTH,
CD_PERSON_RELIGION,
CD_PERSON_CHAR,
CD_PERSON_LIV_ARR,
CD_PERS_GUARD_CNSRV,
CD_PERSON_STATUS,
CD_PERSON_DEATH,
CD_PERSON_MARITAL_STATUS,
CD_PERSON_LANGUAGE,
CD_PERSON_ETHNIC_GROUP,
CD_PERSON_STATE,
CD_PERSON_COUNTY,
IND_PERSON_DOB_APPROX,
IND_PERS_CANCEL_HIST,
NBR_PERSON_AGE,
NBR_PERSON_PHONE,
CAST(CAPS.DECRYPT(NBR_PERSON_ID_NUMBER) AS VARCHAR2(15))  NBR_PERSON_ID_NUMBER,
NM_PERSON_FIRST,
NM_PERSON_MIDDLE,
NM_PERSON_LAST,
NM_PERSON_FULL,
TXT_PERSON_OCCUPATION,
CD_PERSON_SUFFIX,
IND_AUTO_PERS_MERGE,
CD_DISASTER_RLF,
CD_PERSON_TITLE,
IND_PERSON_US_CITIZEN,
CD_PERSON_IMMIGRATION_STATUS,
CD_PERSON_COUNTRY_ORIGIN,
TXT_CHAR_CMNTS,
CD_PERS_NOT_YET_DIAG,
CD_PERSON_PROOF_CITIZENSHIP,
TXT_PERSON_OTHER_RELATIONSHIPS,
CD_MATCH_TYPE,
CD_SMILE_CLIENT,
TXT_IDS_NUMBER,
IND_PREV_ADOPTED,
IND_PRIVATE,
IND_PUBLIC,
IND_INTRNTL,
CD_ADOPT_STATE,
CD_ADOPT_COUNTY,
CD_ADOPT_CNTRY,
IND_ADOPT_DISLUTON,
TXT_PERSON_ADDL_CMNTS,
DT_DISSOLUTION,
DT_PREV_ADOPTION,
TXT_NAME_OF_ADO_AGENCY
FROM CAPS.PERSON_ENC;
 

grant select on caps.person to capson,capsbat,operator;
grant update on caps.person to capson,capsbat;
grant insert on caps.person to capson,capsbat;
grant delete on caps.person to capson,capsbat;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (356, 'SacwisRev2', 'Release 2.6 - DBCRs 9464,9467,9469,9481');
commit;
