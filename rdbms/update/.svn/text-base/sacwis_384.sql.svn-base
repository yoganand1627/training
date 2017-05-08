--STGAP00010198 - Changes to data model for design pt. 2

update CAPS.SPECIAL_NEEDS_DETERMINATION set CD_RATE_TYPE = null;
alter table caps.SPECIAL_NEEDS_DETERMINATION drop column CD_RATE_TYPE;

alter table CAPS.ADOPTION_SUBSIDY add IND_SCHOOL_VER VARCHAR2(1);
comment on column caps.ADOPTION_SUBSIDY.IND_SCHOOL_VER is 'Checkbox to hold if school enrollment was verified.';


--STGAP00010262 - unique constraint for Sibling table


alter table caps.SIBLING add constraint UK_SIBLING_1 UNIQUE (ID_PERSON);


--STGAP00010198 - Changes to data model for design pt. 2 - Continued


update caps.codes_tables
set dt_end = sysdate
where code_type = 'CSUBTYPE'
and code in ('06','11','12','19','20','26');

update caps.codes_tables
set decode = 'Spec Svc Asst - Child Care (Ent Cd 17)'
where code_type = 'CSUBTYPE'
and code = '18';

update caps.codes_tables
set decode = 'Dental/Orthodontics (UAS 512 Entitlement Code 58)'
where code_type = 'CSPLSERV'
and code = 'ORT';

update caps.codes_tables
set decode = 'Therapy/Counseling (UAS 512 Entitlement Code 58)'
where code_type = 'CSPLSERV'
and code = 'TCS';

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values
('CSPLSERV','MED','Medical (UAS 512 Entitlement Code 58)', sysdate);

Update caps.codes_tables
set decode = 'Child over 18 and Not in School Full Time'
where code_type = 'CSUBCLOS'
and code = 'SF';

Update caps.codes_tables
set decode = 'Child over 18 and Has Completed School'
where code_type = 'CSUBCLOS'
and code = 'OA';

Update caps.codes_tables
set decode = 'Child Turns 18 and not eligible for continued AA'
where code_type = 'CSUBCLOS'
and code = 'CT';

insert into caps.task
(CD_TASK, DT_LAST_UPDATE,CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,
 IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING,
 IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
values
('9116', sysdate, null, 'APP', null, null, 'ADO', 'CPS', 'CASV01C', null, 0, 1,
null, 1, null, 0, 0, 0, 0, null, 'Approve Adoption Assistance Agreement', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'ADOPTION_ASSISTANCE_3_EVENTLIST',
 '/financials/AdoptionAsstnc/displayAdoptionAsstnc', 0, 0, 0, 0);

insert into caps.task
(CD_TASK, DT_LAST_UPDATE,CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW,
 IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING,
 IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
values
('9106', sysdate, null, 'APP', null, null, 'PAD', 'CPS', 'CASV01C', null, 0, 1,
null, 1, null, 0, 0, 0, 0, null, 'Approve Adoption Assistance Agreement', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'ADOPTION_ASSISTANCE_3_EVENTLIST',
 '/financials/AdoptionAsstnc/displayAdoptionAsstnc', 0, 0, 0, 0);



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (385, 'SacwisRev3', 'Release 3.0 - DBCRs 10198,10262');

commit;

