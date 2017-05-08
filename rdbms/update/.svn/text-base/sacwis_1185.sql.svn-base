--STGAP00017846 - Release(5.1) PerSTGAP00017827(MR-085-Add metaphor and task rows

--PerSTGAP00017827(MR-085-Add metaphor and task rows

INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab,  dt_last_update )
VALUES
(1776, '/workload/EventSearch/displayEventList' ,  'ICPC_LIST' ,
'ICPC' ,        sysdate
);

INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab,  dt_last_update )
VALUES
(1777, '/workload/EventSearch/displayEventList' ,  'ICPC_FOR_CASE_EVENTLIST' ,
'ICPC for Case' ,       sysdate
);

--Task code for ICPC in FCC(SUB) stage
INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('5000',sysdate,'ICP','CCMN51W','SUB','CPS',
 'CINV03W', '1','1','1','0','0',
 '0','1','ICPC','CASE_CASESEARCH','PLACEMENT_EVENTLIST','ICPC_LIST',
 '/subcare/Icpc/displayIcpcDetail',3,'1','0','0');

  --Task code for ICPC for Case in FCC(SUB) stage
INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW,
t.CD_TASK_PRIOR, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW,
t.IND_TASK_DETAIL_ENABLE, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG,
t.IND_TASK_LIST_ENABLE,
t.IND_TASK_MULTIPLE_INSTANCE,
t.IND_TASK_NEW_ENABLE,
t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('5555',sysdate,'ICP','CCMN51W','5000','SUB','CPS',
 'CINV03W',
 '0','0','0',
 '1',
 '1',
 '0',
 '0','1',
 '0','1','ICPC','CASE_CASESEARCH','PLACEMENT_EVENTLIST','ICPC_FOR_CASE_EVENTLIST',
 '/subcare/Icpc/displayIcpcDetail',3,'0','0','0');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1186, 'SacwisRev5', 'Release 5.1 - DBCR 17846');

commit;
