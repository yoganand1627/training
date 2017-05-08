
-- Standard Alter Table SQL

ALTER TABLE CAPS.INCOME_RESOURCE_INBOUND DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.INCOME_RESOURCE_INBOUND ADD CONSTRAINT PK_INCOME_RESOURCE_INBOUND
PRIMARY KEY (ID_INCOME_RESOURCE_INBOUND)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;
ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION ADD NBR_TOTAL_IVE_IVB_AMT NUMBER(8,2)     NULL
;
ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION ADD NBR_IVE_AMT NUMBER(8,2)     NULL
;
ALTER TABLE CAPS.SPECIAL_NEEDS_DETERMINATION ADD NBR_IVB_AMT NUMBER(8,2)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00002183
Insert into caps.Metaphor
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
 Values
   (25, '/workload/EventSearch/displayEventList', 'SPECIAL_NEEDS_DETERMINATION_EVENTLIST', 'Special Needs Determination');

Insert into caps.Metaphor
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
 Values
   (26, '/workload/EventSearch/displayEventList', 'ADOPTION_ASSISTANCE_3_EVENTLIST', 'Adoption Assistance');

Insert into caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('9105', 'ADP', 'CCMN51W', 'PAD', 'CPS', 'CASV01C', '1', '1', '1', '0', '0', '0', '1', 'Adoption Assistance', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'ADOPTION_ASSISTANCE_3_EVENTLIST', '/financials/AdoptionAsstnc/displayAdoptionAsstnc', 2, '1', '0', '0');

Insert into caps.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE)
 Values
   ('9115', 'ADP', 'CCMN51W', 'ADO', 'CPS', 'CASV01C', '1', '1', '1', '0', '0', '0', '1', 'Adoption Assistance', 'CASE_CASESEARCH', 'ADOPTION_ASSISTANCE_EVENTLIST', 'ADOPTION_ASSISTANCE_3_EVENTLIST', '/financials/AdoptionAsstnc/displayAdoptionAsstnc', 2, '1', '0', '0');

update caps.Task
set TXT_3RD_TAB = 'SPECIAL_NEEDS_DETERMINATION_EVENTLIST',
TXT_EVENT_DETAIL_URL = '/financials/SpecialNeedsDetermination/displaySpecialNeedsDetermination',
cd_task_event_type = 'SND'
where cd_task in ('8610','9100');

-- change STGAP00002144
update caps.codes_tables
set DT_END = to_date('01/01/2006','MM/DD/YYYY')
where code_type = 'CUNMBRRL'
and code in ('20','30');

-- change STGAP00002151
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CREMFRHR','RLM','Relinquishment',SYSDATE);

-- change STGAP00002168
UPDATE CAPS.CODES_TABLES SET DT_END=sysdate WHERE CODE='FA';

-- change STGAP00002174
UPDATE CAPS.CODES_TABLES SET DT_END=SYSDATE WHERE CODE_TYPE='CREGIONS' AND CODE IN ('3A','3B');

-- change STGAP00002184
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CEVNTTYP','SND','Special Needs Determination',SYSDATE);

-- change STGAP00002192
update CAPS.CODES_TABLES set DECODE = 'Team Meetings/Reviews' where DECODE = 'PPT' and CODE = 'DO' and CODE_TYPE = 'CSECATTR';

-- change STGAP00002201
update caps.message m 
set m.TXT_MESSAGE_NAME='MSG_MAX_FEMALE_RANGE_INTEREST'
where m.NBR_MESSAGE=60317;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (167, 'SacwisRev2', 'static updates');
commit;
