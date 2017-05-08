--STGAP00017940 - Release(5.1) STGAP00017922-new profile and attribute and task

--Per STGAP00017922
-- create new security attribute for CDNFSI Alert
insert into CAPS.codes_tables
values('CSECATTR', 'PV', 'CDNFSI Alert', null, sysdate);

-- add new profiles, with all attributes defaulted to 0

insert into CAPS.security_class
values ('CDNFSI_ALERT', sysdate, '00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', 'N', NVL((SELECT id_person FROM caps.employee where id_person = 5607560), 2071));

-- turn on CDSI MIC Alert (102)  attributes for the new profile, the 103th position should be 1

update caps.security_class
set txt_security_class_profil = substr(txt_security_class_profil, 1, 102) || '1' || substr(txt_security_class_profil, 104)
where CD_SECURITY_CLASS_NAME = 'CDNFSI_ALERT';

--Add new task code for Intake with special investigation of Near Fatality
insert into caps.task
(cd_task, dt_last_update, cd_task_event_type,  cd_task_stage, cd_task_stage_program,
cd_task_top_window,  ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using,
ind_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list,txt_task_decode,
txt_1st_tab, txt_2nd_tab, txt_Event_detail_url,
ind_task_code_prefer, ind_task_new_case_todo_enable, ind_task_force_event_link, ind_stage_closure)
values(1045,sysdate,'APP','INT','ALL','CCMN65W','0','1','0','0','0','0','0','Approve Intake Report (Near Fatality)','INTAKE_INTAKE','INTAKE_ACTIONS_INTAKEACTIONS','/intake/IntakeActions/displayIntakeActions',0,'0','0','1');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1206, 'SacwisRev5', 'Release 5.1 - DBCR 17940');

commit;
