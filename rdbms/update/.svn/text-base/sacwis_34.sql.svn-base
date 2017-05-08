
-- change 121
update caps.codes_tables 
set code = 'EX' 
where code_type = 'CLVLRSK' 
and code = 'EX ';

-- change 122
Insert into CAPS.TASK 
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE) 
 Values 
   ('1043', sysdate, 'APP', 'INT', 'ALL', 'CCMN65W', ' ', '0', '1', '0', '0', '0', '0', '0', ' ', 'Approve Intake Report - Response Time', 'INTAKE_INTAKE', 'INTAKE_ACTIONS_INTAKEACTIONS', '/intake/IntakeActions/displayIntakeActions', 0, '0', '0', '1'); 


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (35, 'SacwisRev1', 'static updates');
                         
commit;                       
