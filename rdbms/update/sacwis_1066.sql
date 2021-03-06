--STGAP00017017 - Release(5.0) Adding new row to Metaphor and Task tables

-- Adding entry into metaphor for new Permanency roundtable page.
INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab,  dt_last_update )
VALUES
(1767, '/workload/EventSearch/displayEventList' ,       'PERMANENCY_ROUNDTABLE_EVENTLIST' ,
'Roundtable' ,    sysdate);

-- Adding new row for ADO Permanency Round Table tasks.
INSERT INTO CAPS.TASK ( CD_TASK, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE,
CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,
IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE,
TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER,
IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK,
IND_STAGE_CLOSURE ) VALUES (
'8655', 'COMP', 'PER'
, 'CCMN51W', NULL, 'ADO', 'CPS', 'CSUB06C', NULL, '1', '1', NULL, '1', NULL, '0', '0'
, '0', '1', NULL, 'Roundtable', 'CASE_CASESEARCH', 'CHILD_PLANS_EVENTLIST'
, 'PERMANENCY_ROUNDTABLE_EVENTLIST', '/admin/OutputLaunch/displayInitOutputLaunch', 3, '0', '0'
, '0');

-- Adding row for FCC stage
INSERT INTO CAPS.TASK ( CD_TASK, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE,
CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,
IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE,
IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE,
IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE,
TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER,
IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK,
IND_STAGE_CLOSURE ) VALUES (
'8650', 'COMP', 'PER'
, 'CCMN51W', NULL, 'SUB', 'CPS', 'CSUB06C', NULL, '1', '1', NULL, '1', NULL, '0', '0'
, '0', '1', NULL, 'Roundtable', 'CASE_CASESEARCH', 'CHILD_PLANS_EVENTLIST'
, 'PERMANENCY_ROUNDTABLE_EVENTLIST', '/admin/OutputLaunch/displayInitOutputLaunch', 3, '0', '0'
, '0');



insert into caps.codes_tables (code_type, code, decode )
values('CEVNTDOC' , 'PER' , 'PERMROUNDTABLE');

insert into caps.codes_tables (code_type, code, decode)
values ( 'CEVNTTBL', 'PER', 'PERM_ROUNDTABLE_NARR');





insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1067, 'SacwisRev5', 'Release 5.0 - DBCR 17017');

commit;

