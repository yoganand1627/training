-- All changes for version 2.4 of SHINES

-- change STGAP00007980
-- for defect STGAP00007315
insert into caps.task
(cd_task, dt_last_update, cd_task_event_status, cd_task_event_type, cd_task_stage, cd_task_stage_program, cd_task_top_window, ind_task_detail_enable, ind_task_event_create, ind_task_event_navig, ind_task_list_enable, ind_task_multiple_instance, ind_task_new_enable, ind_task_new_using, ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1st_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url, ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
values
('2307',sysdate,'COMP','CHK','DIV','CPS','CINV25W','1','1','1','0','0','0','0','0','0','1','Services and Referrals Checklist','CASE_CASESEARCH','CASE_MANAGEMENT_CASEMNT','SERVICES_AND_REFERRALS_CHECKLIST_SRVCSRFRRLSCHECKLIST','/investigation/SrvcsRfrrlsChecklist/displaySrvcsRfrrlsChecklist',3,'1','0','0');

-- change STGAP00007981
UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '10'
WHERE CD_SECURITY_CLASS_NAME = 'DPTY_CNTY_DRCTR'
and length(TXT_SECURITY_CLASS_PROFIL) = 86;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '11'
WHERE CD_SECURITY_CLASS_NAME = 'SYS_ADMIN'
and length(TXT_SECURITY_CLASS_PROFIL) = 86;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '01'
WHERE CD_SECURITY_CLASS_NAME = 'REG_FAM_IND_MGT'
and length(TXT_SECURITY_CLASS_PROFIL) = 86;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (308, 'SacwisRev2', 'static table updates');                        
commit;

