--STGAP00015728 - Release(3.5) Task code -Children 1st Referral for FSU and PAD

 --Task code for Children 1st Referral in Foster Care Family stage
INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('5600',sysdate,'CFR','CCMN51W','FSU','CPS',
 'CINV03W', '1','1','1','0','0',
 '0','1','Children 1st Referral','CASE_CASESEARCH','PERSON_PERSONLIST','CHILDREN_FIRST_REFERRAL_EVENTLIST',
 '/investigation/ChildrenFirstReferral/displayChildrenFirstReferral',3,'1','0','0');

--Task code for Children 1st Referral in PFC (Post Adoption ) stage
 INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('5700',sysdate,'CFR','CCMN51W','PAD','CPS',
 'CINV03W', '1','1','1','0','0',
 '0','1','Children 1st Referral','CASE_CASESEARCH','PERSON_PERSONLIST','CHILDREN_FIRST_REFERRAL_EVENTLIST',
 '/investigation/ChildrenFirstReferral/displayChildrenFirstReferral',3,'1','0','0');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (703, 'SacwisRev3', 'Release 3.5 - DBCR 15728');

commit;


