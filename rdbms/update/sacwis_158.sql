--change STGAP00002001
INSERT INTO caps.METAPHOR (ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB) 
     VALUES (545,'/workload/EventSearch/displayEventList', 'RISK_REASSESSMENTS_EVENTLIST', 'Risk ReAssessment') ;
 
INSERT INTO caps.TASK ( CD_TASK, DT_LAST_UPDATE, CD_TASK_EVENT_STATUS, CD_TASK_EVENT_TYPE, CD_TASK_LIST_WINDOW, CD_TASK_PRIOR, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, CD_TASK_TOP_WINDOW, IND_TASK_DETAIL_ENABLE, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_LIST_ENABLE, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_ENABLE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, IND_TASK_TODO_ENABLE, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER, IND_TASK_NEW_CASE_TODO_ENABLE, IND_TASK_FORCE_EVENT_LINK, IND_STAGE_CLOSURE ) VALUES ( 
'7385',  sysdate, NULL, 'ASM', 'CCMN51W', NULL, 'FPR', 'CPS', 'CSVC08W', NULL, '0', '1', NULL, '1', '0', '0', '0', '0', '1', NULL, 'Risk ReAssessment', 'CASE_CASESEARCH', 'FAMILY_PLANS_EVENTLIST', 'RISK_REASSESSMENT_EVENTLIST', '/investigation/RiskAssmt/displayRiskAssmt', 3, '0', '0', '0') ;

-- change STGAP00002030
INSERT INTO caps.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60307, 'MSG_INV_wvr_SLPARNGMNTS'
,'Sleeping arrangements are required for this waiver reason.',760,500,'N');

INSERT INTO caps.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60308, 'MSG_INV_WVR_APPPERDM'
,'The approved per diem amount is required for a financial waiver.',760,500,'N');

INSERT INTO caps.MESSAGE (NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION, IND_BATCH) 
  VALUES (60309, 'MSG_INV_WVR_PER_OTH'
,'Select a person or enter a person name in Other.',760,500,'N');



insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (159, 'SacwisRev2', 'static updates');
                         
commit;