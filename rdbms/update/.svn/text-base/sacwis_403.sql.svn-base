--STGAP00011251 - MSG_FAD_CONV_CLOSURE_RSN Message Needed for FH Con

--Note:   no impact to ado model


Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60502,   'MSG_FAD_CONV_CLOSURE_RSN',
   'Closure reason is required when Foster Home Conversion is ended..', 500, 700, 'N');


--STGAP00011263 - DBCR to enddate VS-Father as Legal Action

--Note: no impact to ado model


Update caps.codes_tables
set dt_end = sysdate
where code_type = 'CLEGCPS'
and code = 'VLF';

--STGAP00011290 - Set filter tab for Foster Home Conversion

--Note:  no imapct to ado model


UPDATE caps.metaphor
SET TXT_FILTER_PATH = 'gov.georgia.dhr.dfcs.sacwis.web.metaphor.FHConversionShowTab'
WHERE TXT_TAB = 'Foster Home Conversion List' AND TXT_TAB_CONSTANT = 'HOMEINFRMTN_HOME_CONVERSION_3';

--STGAP00011291 - Stage Closure: Need a new Task table record

--Note:   no impact ado

--Need a new task for the PAD stage opened event.

INSERT INTO CAPS.TASK ( CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, 
IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, 
IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, 
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, 
TXT_3RD_TAB, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, 
IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE ) 
VALUES ('9999',  SYSDATE, 'STG', 'PAD', '0', '0', '0', '0', '0', '0', '1', 
'Post Adoptive Stage Opened', 'CASE_CASESEARCH', 'NEVER_A_TAB', 'NEVER_A_TAB', 
0, '0', '0', '0');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (404, 'SacwisRev3', 'Release 3.0 - DBCRs 11251,11263,11290,11291');

commit;

