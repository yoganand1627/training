
-- change STGAP00001536
UPDATE CAPS.CODES_TABLES SET DECODE = 'Service' WHERE 
code_type = 'CCONFUNC' AND code = 'CPS';

-- change STGAP00001540
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60147, 'MSG_RESPON_STEP_REQ' 
,'Responsibility is required to save a selected Step.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60148, 'MSG_STEP_STEP_REQ' 
,'Step instructions are required to save a selected Step.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60149, 'MSG_STEP_STAT_REQ' 
,'Status is required to save a selected Step.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60150, 'MSG_ANT_COMP_REQ' 
,'Anticipated Completion is required to save a selected Step.',500,700,'N');
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60151, 'MSG_GOAL_OTH_EXP_REQ' 
,'If the reason is Other, explanation is required.',500,700,'N');

-- change STGAP00001541
update CAPS.TASK set IND_TASK_CODE_PREFER = 3 where CD_TASK = 4150;
update CAPS.METAPHOR set TXT_TAB_URL = '/workload/EventSearch/displayEventList', TXT_TAB_CONSTANT = 'FAMILY_CASE_PLAN_EVENTLIST' where ID_TAB = 525;

-- change STGAP00001543
INSERT INTO CAPS.MESSAGE
(id_message, nbr_message, txt_message_name, 
txt_message)
VALUES
(0, 60153, 'MSG_REQ_RESERVED_REASON', 
'A Reserved Reason is required when reserving an amount other than $0');

INSERT INTO CAPS.MESSAGE
(id_message, nbr_message, txt_message_name, 
txt_message)
VALUES
(0, 60154, 'MSG_INV_RESERVED_AMOUNT', 
'Please enter a valid Reserved Amount');

-- change STGAP00001544
INSERT INTO CAPS.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60152, 'MSG_DILSEARCH_ADD' 
,'Cannot add a contact for the current Child.',500,700,'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (131, 'SacwisRev2', 'static updates');
                         
commit;