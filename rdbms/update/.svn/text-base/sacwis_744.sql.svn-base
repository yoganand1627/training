--STGAP00015787 - Release(3.43) MR-62: Add Metaphor, Task and EventType for page

--Add row to METAPHOR table
INSERT INTO caps.METAPHOR
(id_tab, txt_tab_url, txt_tab_constant, txt_tab, txt_filter_path, dt_last_update )
VALUES
(1763, '/workload/EventSearch/displayEventList' , 'CONTACT_STANDARDS_EVENTLIST' , 'Contact Standards' , 'null' , sysdate);


 --Task code for Contact Standards in Foster Care Family stage
INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('6540',sysdate,'PCS','NULL','FSU','CPS',
 'NULL', '1','1','1','0','0',
 '0','1','Contact Standards','CASE_CASESEARCH','CONTACTS_SUMMARIES_CONTACTSEARCH','CONTACT_STANDARDS_EVENTLIST',
 '/contacts/ContactStandards/displayContactStandards',2,'1','0','0');

--Task code for Contact Standards in Ongoing stage
 INSERT INTO caps.task t
(t.CD_TASK,t.DT_LAST_UPDATE,t.CD_TASK_EVENT_TYPE, t.CD_TASK_LIST_WINDOW, t.CD_TASK_STAGE, t.CD_TASK_STAGE_PROGRAM,
t.CD_TASK_TOP_WINDOW, t.IND_TASK_EVENT_CREATE, t.IND_TASK_EVENT_NAVIG, t.IND_TASK_MULTIPLE_INSTANCE, t.IND_TASK_NEW_USING, t.IND_TASK_NU_ACROSS_CASE,
 t.IND_TASK_RTRV_PRIOR_STAGE, t.IND_TASK_SHOW_IN_LIST, t.TXT_TASK_DECODE, t.TXT_1ST_TAB, t.TXT_2ND_TAB, t.TXT_3RD_TAB,
 t.TXT_EVENT_DETAIL_URL, t.IND_TASK_CODE_PREFER, t.IND_TASK_NEW_CASE_TODO_ENABLE, t.IND_TASK_FORCE_EVENT_LINK, t.IND_STAGE_CLOSURE)
 VALUES
('7025',sysdate,'PCS','NULL','FPR','CPS',
 'NULL', '1','1','1','0','0',
 '0','1','Contact Standards','CASE_CASESEARCH','CONTACTS_SUMMARIES_CONTACTSEARCH','CONTACT_STANDARDS_EVENTLIST',
 '/contacts/ContactStandards/displayContactStandards',2,'1','0','0');


 INSERT INTO CAPS.CODES_TABLES VALUES('CEVNTTYP', 'CSS', 'Contact Standards', NULL, SYSDATE);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (745, 'SacwisRev3', 'Release 3.43 - DBCR 15787');




commit;
 
