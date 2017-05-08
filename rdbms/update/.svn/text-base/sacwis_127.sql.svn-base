
-- change STGAP00001503
Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
 Values
   ('9515', sysdate, 'APP', 'SUB', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve WTLP', 'CASE_CASESEARCH', 'CHILD_PLANS_EVENTLIST', 'WTLP_EVENTLIST', '/subcare/WTLP/displayWTLP');

-- change STGAP00001504
INSERT INTO CAPS.CODES_TABLES
(code_type,code,DECODE)
VALUES('CLOCMAL','011', 'Residential Treatment Facility');

-- change STGAP00001507
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Enter if the child is adjusting in care.'
WHERE TXT_MESSAGE_NAME = 'MSG_CHILD_ADJ_COMP';

-- change STGAP00001508
update caps.task set IND_TASK_NEW_USING = 1 where cd_task=9510;

-- change STGAP00001511
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60137, 'MSG_DILSEARCH_CARE'
,'This person was the caretaker prior to removal; please describe why the child was removed from their care.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60138, 'MSG_DILSEARCH_CONTACT'
,'Please explain why this person was not contacted.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60139, 'MSG_DILSEARCH_OUTCOME'
,'Please indicate the current outcome of contact.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60140, 'MSG_DILSEARCH_VISIT'
,'Please indicate whether this person is a willing visitation resource.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60141, 'MSG_DILSEARCH_PLACE'
,'Please indicate whether this person is a potential placement resource.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60142, 'MSG_DILSEARCH_NWHY'
,'Please indicate why this person is not a potential placement resource.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60143, 'MSG_DILSEARCH_REVCAR'
,'Please indicate the date when relative care subsidies were discussed with this person.',500,700,'N');

INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60144, 'MSG_DILSEARCH_COPY'
,'Cannot copy a contact for the current Child.',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (128, 'SacwisRev2', 'static updates');
                         