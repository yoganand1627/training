--STGAP00014814 - DBCR-PerSTGAP00014455 End Date SafetyResource Cont

--PerSTGAP00014455 End Date SafetyResource Contant Type.

UPDATE CAPS.codes_tables
SET dt_end = sysdate
WHERE code_type = 'CCNTCTYP' AND code IN ('LSRA' , 'ASRA');


--STGAP00014826 - Stage Reopen Messages

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60563,'MSG_CONFRM_SAVE','Upon save this page becomes read only and this stage will be reopened. Please click Ok to continue or cancel to cancel this action.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60564,'MSG_STG_CANNOT_REOPEN','The selected stage cannot be reopened. Please contact GA Shines Help Desk for further assistance.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60565,'MSG_REQUESTED_BY_REQ','The Requested By Person is required.',700,500,'N');

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,60566,'MSG_REOPEN_REASONS_REQ','Reopen Reasons are required.',700,500,'N');


--STGAP00014828 - Stage reopen other tables

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1681, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_ADOPTION_STAGE_STAGEREOPEN', 
'Reopen Adoption Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1682, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_ONGOING_STAGE_STAGEREOPEN', 
'Reopen CPS Ongoing Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1683, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_FOSTER_CARE_FAM_STAGE_STAGEREOPEN', 
'Reopen Foster Care Family Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1684, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_FOSTER_CARE_CHILD_STAGE_STAGEREOPEN', 
'Reopen Foster Care Child Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1685, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_POST_ADOPTION_STAGE_STAGEREOPEN', 
'Reopen Post-Adoption Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1686, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_POST_FOSTER_CARE_STAGE_STAGEREOPEN', 
'Reopen Post Foster Care Stage', 
SYSDATE); 

INSERT INTO CAPS.METAPHOR 
(ID_TAB, 
TXT_TAB_URL, 
TXT_TAB_CONSTANT, 
TXT_TAB, 
DT_LAST_UPDATE) 
VALUES 
(1687, 
'/workload/StageReopen/displayStageReopen', 
'REOPEN_DIVERSION_STAGE_STAGEREOPEN', 
'Reopen Diversion Stage', 
SYSDATE); 


INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9941',SYSDATE, 'CRP','CCMN51W','ADO','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Adoption Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_ADOPTION_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9942',SYSDATE, 'CRP','CCMN51W','FPR','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen CPS Ongoing Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_ONGOING_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9943',SYSDATE, 'CRP','CCMN51W','FSU','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Foster Care Family Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_FOSTER_CARE_FAM_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9944',SYSDATE, 'CRP','CCMN51W','FCC','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Foster Care Child Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_FOSTER_CARE_CHILD_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9945',SYSDATE, 'CRP','CCMN51W','PAD','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Post-Adoption Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_POST_ADOPTION_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9946',SYSDATE, 'CRP','CCMN51W','PFC','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Post Foster Care Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_POST_FOSTER_CARE_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

INSERT INTO caps.TASK (cd_task, dt_last_update, cd_Task_event_type, cd_task_list_window, cd_task_stage, cd_task_stage_program, cd_task_top_window,
ind_Task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,
txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_Task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
VALUES 
('9947',SYSDATE, 'CRP','CCMN51W','DIV','CPS','CSUB50W',1,1,0,0,0,0,1,'Reopen Diversion Stage','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT', 'REOPEN_DIVERSION_STAGE_STAGEREOPEN',
'/workload/StageReopen/displayStageReopen',3,1,0,1);

--STGAP00014967 - Stage Reopen Message update

update caps.message set txt_message = 'The selected stage cannot be reopened. Please contact GA SHINES Help Desk for further assistance.' where txt_message_name = 'MSG_STG_CANNOT_REOPEN';

--STGAP00014867 - Add new column to ADO_NEW_NAME for Stage close date
alter table caps.stage add DT_STAGE_CLOSE_TEMP date;
comment on column caps.stage.DT_STAGE_CLOSE_TEMP is 'Holds the stage closure date' ;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (500, 'SacwisRev3', 'Release 3.2 - DBCRs 14814,14826,14828, 14967, 14867');

commit;


