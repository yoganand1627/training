-- STGAP00011863 - Add Person views to training env
-- NOTE: These SQL Statements only go in a TRAINING script (sacwis_xxxT.sql)

create or replace view CAPS.PERSON_ENC
as select * from PERSON;

create or replace view CAPS.PERSON_ID_ENC
as select * from PERSON_ID;

/
create or replace Function CAPS.ENCRYPT
   ( ID_IN IN varchar2 )
   RETURN varchar2
IS
    ID_OUT varchar2(30);
BEGIN
ID_OUT := ID_IN;
RETURN ID_OUT;
END;
/


--STGAP00012640 - Per MR-037 we need to add ServiceAuthorization to the FAD stage, for this we need to add Task Codes to Task Table.
-- Clear Quest defect for this issue  is STGAP00012636 

--Task code for ServiceAuthorization in FAD stage
INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM, 
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB, 
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('9040',sysdate,'AUT','CCMN51W','FAD','CPS',
 'CCON02C', '0','1','1','1','0',
 '0','1','Service Authorization','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTHORIZATION_3_EVENTLIST',
 '/financials/ServiceAuth/accessServiceAuth',2,'1','0','0');


--Task code for Service Auth for Case in FAD stage

INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_STATUS,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW,t.CD_TASK_PRIOR, t.CD_TASK_STAGE, 
t.CD_TASK_STAGE_PROGRAM, t.CD_TASK_TOP_WINDOW,
t.IND_TASK_DETAIL_ENABLE, t.IND_TASK_EVENT_CREATE,     t.IND_TASK_EVENT_NAVIG,
t.IND_TASK_LIST_ENABLE,   t.IND_TASK_MULTIPLE_INSTANCE,t. IND_TASK_NEW_ENABLE,
t.IND_TASK_NEW_USING,     t.IND_TASK_NU_ACROSS_CASE,   t.IND_TASK_RTRV_PRIOR_STAGE,
t.IND_TASK_SHOW_IN_LIST,  t.IND_TASK_TODO_ENABLE,
t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB, 
t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE,t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
VALUES
('9041',sysdate,'APRV','AUT','CCMN51W','9040','FAD',
'CPS','CSUB01C',
'0','0','0',
'1','1','0',
'1','1','0',
'1','0',
'Service Auth for Case','CASE_CASESEARCH','SERVICE_AUTHORIZATION_EVENTLIST','SERVICE_AUTH_FOR_CASE_EVENTLIST',
'/financials/ServiceAuth/accessServiceAuth',3,'0','0','0');
 

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (440, 'SacwisRev3', 'Release 3.1 - DBCRs 11863,12640');

commit;


