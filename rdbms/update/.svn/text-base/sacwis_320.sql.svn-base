-- Release 2.5 changes
-- change STGAP00008545
UPDATE caps.CODES_TABLES 
SET dt_end = sysdate
WHERE code_type = 'CCTZNSTA' 
AND code = 'VES';

-- change STGAP00008595
Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
 Values
   ('7331', sysdate, 'SPL', 'FPR', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Safety Resource', 'CASE_CASESEARCH', 'ONG_ASSESSMENT', 'SAFETY_RESOURCE_EVENTLIST', '/investigation/SafetyResource/displaySafetyResource', 3);

Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
 Values
   ('2277', sysdate, 'SPL', 'INV', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Safety Resource', 'CASE_CASESEARCH', 'RISK_ASSESSMENT_RISKASSMT', 'SAFETY_RESOURCE_EVENTLIST', '/investigation/SafetyResource/displaySafetyResource', 3);

-- change STGAP00008596
Insert into CAPS.METAPHOR
   (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB, DT_LAST_UPDATE)
 Values
   (1616, '/workload/EventSearch/displayEventList', 'SAFETY_RESOURCE_EVENTLIST', 'Safety Resource', sysdate);
   
-- change STGAP00008639

update caps.codes_tables
set dt_end = sysdate
where code_type = 'CLEGSTAT'
and code = 'JCD';

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values ('CLEGSTAT','NCS','Not in DFCS Custody - Custody With Other State',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values ('CLEGSTAT','NDJ','Not In DFCS Custody - No Longer Committed to DJJ',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values ('CLEGSTAT','DJA','DJJ Aftercare',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values ('CLEGSTAT','JCP','JCP  Joint Commitment With DJJ - Permanent Court',sysdate);

insert into caps.codes_tables
(code_type, code, decode, dt_last_update)
values ('CLEGSTAT','JCT','Joint Commitment With DJJ - Temporary Court',sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (321, 'SacwisRev2', 'update static tables');                        
commit;


