
-- change STGAP00002351
update CAPS.TASK set TXT_3RD_TAB = 'FAMILY_CASE_PLAN_EVENT_LIST', TXT_EVENT_DETAIL_URL = '/serviceDelivery/FCCPFamilyDetail/displayFCCPFamilyDetail', TXT_TASK_DECODE = 'Approve Foster Care Case Plan Family' where CD_TASK = '4320';

-- change STGAP00002382
Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, 
IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, 
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
 Values
   ('7310', SYSDATE, 'WVR', 'FSU', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Policy Waiver', 'CASE_CASESEARCH', 
'CASE_MANAGEMENT_CASEMNT', 'POLICY_WAIVER_EVENTLIST', '/investigation/PolicyWaiver/displayPolicyWaiver', 3);

Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, 
IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, 
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
 Values
   ('7815', SYSDATE, 'WVR', 'FPR', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Policy Waiver', 'CASE_CASESEARCH', 
'CASE_MANAGEMENT_CASEMNT', 'POLICY_WAIVER_EVENTLIST', '/investigation/PolicyWaiver/displayPolicyWaiver', 3);

Insert into CAPS.TASK
   (CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, 
IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, 
IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
 Values
   ('7916', SYSDATE, 'WVR', 'PFC', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Policy Waiver', 'CASE_CASESEARCH', 
'CASE_MANAGEMENT_CASEMNT', 'POLICY_WAIVER_EVENTLIST', '/investigation/PolicyWaiver/displayPolicyWaiver', 3);


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (170, 'SacwisRev2', 'static updates'); 
commit;