-- All changes for version 2.4 of SHINES

-- change STGAP00008158
-- New Additional CDISP values for Intake Closure Page
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CDISP','OIE', 'Opened in Error', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CDISP','IC', 'ICPC', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CDISP','PA', 'PAD Payments', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CDISP','PF', 'PFC Payments', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CDISP','NI', 'Non-Incident DJJ', sysdate);

-- New Event Types for Intake Closures
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEVNTTYP','IDC', 'Disposition Change', sysdate);
insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CEVNTTYP','INC', 'Intake Closure Change', sysdate);

-- New Messages
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60410, 'MSG_INT_SAVE_DISP','Saving the page with the disposition selected will close the Intake. Click OK to Continue or Cancel to return to the page.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60411, 'MSG_DATE_CHANGED_CURR_DATE','The Date Changed must be less than or equal to the current date.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60412, 'MSG_REASON_CHANGED_REQ','Reason Changed is required when changing the response time.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60413, 'MSG_CMTS_REQ_RESP_TIME','Comments are required when changing the response time.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60414, 'MSG_CMTS_REQ_DISP','Comments are required when changing the disposition.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60415, 'MSG_CMTS_REQ_INT_SAVE','Comments are required to Save and Close.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60416, 'MSG_INT_SAVE_RESP_TIME_DISP','The most recent change of response time or disposition was not approved. Update the necessary fields and Save and Submit again.','700','500','N');
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60417, 'MSG_INT_SAVE_CLOSE_SUPERVISOR_REQ','You must be Supervisor or above to Save and Close a non-incident Intake other than Information and Referral.','700','500','N');

-- Update Metaphor table
UPDATE CAPS.METAPHOR set TXT_TAB='Intake Closure' where ID_TAB=720;

-- New Tasks for Intake Closure
INSERT INTO CAPS.TASK (CD_TASK,CD_TASK_EVENT_TYPE,CD_TASK_STAGE,
CD_TASK_STAGE_PROGRAM,IND_TASK_DETAIL_ENABLE,IND_TASK_EVENT_CREATE,
IND_TASK_EVENT_NAVIG,IND_TASK_MULTIPLE_INSTANCE,IND_TASK_NEW_ENABLE,
IND_TASK_NEW_USING,IND_TASK_NU_ACROSS_CASE,IND_TASK_RTRV_PRIOR_STAGE, 
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE,TXT_1ST_TAB,TXT_2ND_TAB,TXT_3RD_TAB,
TXT_EVENT_DETAIL_URL,IND_TASK_CODE_PREFER,IND_TASK_NEW_CASE_TODO_ENABLE,
IND_TASK_FORCE_EVENT_LINK,IND_STAGE_CLOSURE) VALUES ('1090','INC','INT','ALL',1,
0,1,0,0,0,0,0,1,'Intake Closure Change','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT',
'INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE','/workload/IntakePriorityClosure/displayPriorityClosure',2,0,0,0);

INSERT INTO CAPS.TASK (CD_TASK,CD_TASK_EVENT_TYPE,CD_TASK_STAGE,CD_TASK_STAGE_PROGRAM,
IND_TASK_EVENT_CREATE,IND_TASK_EVENT_NAVIG,IND_TASK_MULTIPLE_INSTANCE,
IND_TASK_NEW_USING,IND_TASK_NU_ACROSS_CASE,IND_TASK_RTRV_PRIOR_STAGE,
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE,TXT_1ST_TAB,TXT_2ND_TAB,TXT_3RD_TAB,TXT_EVENT_DETAIL_URL,
IND_TASK_CODE_PREFER,IND_TASK_NEW_CASE_TODO_ENABLE,IND_TASK_FORCE_EVENT_LINK,IND_STAGE_CLOSURE) 
VALUES ('1100','APP','INT','ALL',0,1,0,0,0,0,0,'Approve Intake Closure Change','CASE_CASESEARCH',
'CASE_MANAGEMENT_CASEMNT','INTAKE_PRIORITY_CLOSURE_INTAKEPRIORITYCLOSURE',
'/workload/IntakePriorityClosure/displayPriorityClosure',0,0,0,1);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (316, 'SacwisRev2', 'static table updates');                        
commit;

