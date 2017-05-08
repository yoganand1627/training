
--STGAP00002548
update caps.Task
set TXT_TASK_DECODE = 'Special Needs Determination'
 where cd_task in ('8610','9100');
 
--STGAP00002554 
INSERT INTO caps.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60330, 'MSG_ADO_SPC_RATE_IVE_IVB_AMT', 'Total Specialized Rate approved amount must be sum of IV-E and IV-B amounts.', '600', '700', 'N');

--STGAP00002555 
UPDATE caps.MESSAGE SET TXT_MESSAGE='You must have at least one home type checked in order to save.' WHERE NBR_MESSAGE='8099';

--STGAP00002574 
UPDATE caps.METAPHOR SET txt_tab = 'Close Foster Care Child Stage' WHERE id_tab = 330;

--STGAP00002583 
UPDATE caps.CODES_TABLES SET DECODE='None (Non-Special Needs)' WHERE CODE='00' AND  code_type = 'CLNCHAR2';

--STGAP00002588 
Insert into caps.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
 Values (1486, '/workload/EventSearch/displayEventList', 'WTLP_FOR_CASE_EVENTLIST', 'WTLP for Case');

--STGAP00002590 
Insert into caps.TASK
   (CD_TASK, 
    CD_TASK_PRIOR, 
    CD_TASK_EVENT_TYPE, 
    CD_TASK_STAGE, 
    CD_TASK_STAGE_PROGRAM, 
    IND_TASK_EVENT_CREATE, 
    IND_TASK_EVENT_NAVIG, 
    IND_TASK_MULTIPLE_INSTANCE, 
    IND_TASK_NEW_USING, 
    IND_TASK_NU_ACROSS_CASE, 
    IND_TASK_RTRV_PRIOR_STAGE, 
    IND_TASK_SHOW_IN_LIST, 
    TXT_TASK_DECODE, 
    TXT_1ST_TAB, 
    TXT_2ND_TAB, 
    TXT_3RD_TAB, 
    TXT_EVENT_DETAIL_URL, 
    IND_TASK_CODE_PREFER, 
    IND_TASK_NEW_CASE_TODO_ENABLE, 
    IND_TASK_FORCE_EVENT_LINK, 
    IND_STAGE_CLOSURE)
 Values
   ('9505', 
    '9500', 
    'WTL', 
    'PFC', 
    'CPS', 
    '1', 
    '1', 
    '1', 
    '1', 
    '0', 
    '0', 
    '1', 
    'WTLP for Case', 
    'CASE_CASESEARCH', 
    'CHILD_PLANS_EVENTLIST', 
    'WTLP_FOR_CASE_EVENTLIST', 
    '/subcare/WTLP/displayWTLP', 
    3, 
    '0', 
    '0', 
    '0');
    
    
    
Insert into caps.TASK
   (CD_TASK, 
    CD_TASK_PRIOR, 
    CD_TASK_EVENT_TYPE, 
    CD_TASK_STAGE, 
    CD_TASK_STAGE_PROGRAM, 
    IND_TASK_EVENT_CREATE, 
    IND_TASK_EVENT_NAVIG, 
    IND_TASK_MULTIPLE_INSTANCE, 
    IND_TASK_NEW_USING, 
    IND_TASK_NU_ACROSS_CASE, 
    IND_TASK_RTRV_PRIOR_STAGE, 
    IND_TASK_SHOW_IN_LIST, 
    TXT_TASK_DECODE, 
    TXT_1ST_TAB, 
    TXT_2ND_TAB, 
    TXT_3RD_TAB, 
    TXT_EVENT_DETAIL_URL, 
    IND_TASK_CODE_PREFER, 
    IND_TASK_NEW_CASE_TODO_ENABLE, 
    IND_TASK_FORCE_EVENT_LINK, 
    IND_STAGE_CLOSURE)
 Values
   ('9511', 
    '9510', 
    'WTL', 
    'SUB', 
    'CPS', 
    '1', 
    '1', 
    '1', 
    '1', 
    '0', 
    '0', 
    '1', 
    'WTLP for Case', 
    'CASE_CASESEARCH', 
    'CHILD_PLANS_EVENTLIST', 
    'WTLP_FOR_CASE_EVENTLIST', 
    '/subcare/WTLP/displayWTLP', 
    3, 
    '1', 
    '0', 
    '0');

--STGAP00002603 
UPDATE caps.STAGE_PROG  
SET IND_STAGE_PROG_CLOSE = '0', 
CD_STAGE_PROG_OPEN = null 
WHERE CD_STAGE_PROG_RSN_CLOSE = '01' 
AND CD_STAGE_PROG_stage = 'INV' 
AND cd_stage_prog_program = 'CPS';

--STGAP00002605 
UPDATE caps.CODES_TABLES 
SET DECODE='Transfer to Another Agency' 
WHERE CODE='TAA' 
and decode = 'CCLOSFCC';

--STGAP00002615 
INSERT INTO caps.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60331, 'MSG_RSRC_PROXIMITY_SEARCH_PARAM'
,'Full Address must be entered when performing a proximity search.',760,500,'N');

--STGAP00002646 
UPDATE caps.message
SET txt_message='The Start Date and Time of this entry cannot overlap the End Date and Time of the previous'
WHERE txt_message_name='MSG_SUB_PERIOD_OVERLAP_1';

UPDATE caps.message
SET txt_message='The End Date and Time of this entry cannot overlap the Start Date and Time of the next entry'
WHERE txt_message_name='MSG_SUB_PERIOD_OVERLAP_2';

UPDATE caps.message
SET txt_message='You must select a resource which is a DFCS Family Foster Home'
WHERE txt_message_name='MSG_SUB_NOT_FA_HOME';


UPDATE caps.message
SET txt_message='Use Placement Type of DFCS Family Foster Home to record this placement'
WHERE txt_message_name='MSG_FA_HOME_CONTRACT';


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (173, 'SacwisRev2', 'static updates to tasks, messages, stage_prog, metaphor, and codes_tables');   
commit;
