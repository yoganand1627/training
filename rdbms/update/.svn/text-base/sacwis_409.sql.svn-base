--STGAP00011502 - PerSTGAP00009163 Insert new row in Task table

--Note: no impact to ado model


--Per Defect STGAP00009163, we need to add a task code for Heath Log tasks in the DIV stage.

--This will display correct events for Health Log in DIV stage.

INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, 
t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM, t.CD_TASK_TOP_WINDOW,
 t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE,
t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, 
t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE,
 t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('8195',sysdate,'MED','CCMN51W','DIV','CPS','CINV03W',
 '1','1','1','0','0',
 '0','1','Medical/Mental Assessment','CASE_CASESEARCH','PERSON_PERSONLIST',
'MEDICAL_MENTAL_ASSESSMENT_EVENTLIST',
 '/investigation/MdclMentalAssmt/displayMdclMentalAssmt',3,'1','0','0');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (410, 'SacwisRev3', 'Release 3.1 - DBCRs 11502');

commit;


