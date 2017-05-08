-- change STGAP00005622
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='Please ensure the following has been completed prior to entering or saving data, otherwise your data will not be saved:<br>- Child''s relationship must be ''Self'' on Person Detail page<br>- Indicate if child has been adopted on Person Characteristics page<br>- CRS ID must be obtained from Person Identifiers Detail page<br>- Child Citizenship and Mother Marital Status must be completed on Citizenship and Identity page' 
WHERE NBR_MESSAGE='99310';

-- change STGAP00005631
-- The following changes make up the first step to the fix for STGAP00005607:
-- (1) new 2nd level 'Assessments' tab for ONG stages
INSERT INTO CAPS.METAPHOR
(ID_TAB, TXT_TAB_URL, TXT_TAB_CONSTANT, TXT_TAB)
VALUES
(1590, '/workload/EventSearch/displayEventList', 'ONG_ASSESSMENT', 'Assessments');

-- (2) copy event and approval tasks for Safety Plan (2275, 2276) and
-- Safety Assessment (2285, 2286) 
INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
VALUES
('7330', 'SPL', 'FPR', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Safety Plan', 'CASE_CASESEARCH', 'ONG_ASSESSMENT', 'SAFETY_PLAN_EVENTLIST', '/investigation/SafetyPlan/displaySafetyPlan', 2);

INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
VALUES
('7335', 'APP', 'FPR', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve Safety Plan', 'CASE_CASESEARCH', 'ONG_ASSESSMENT', 'SAFETY_PLAN_EVENTLIST', '/investigation/SafetyPlan/displaySafetyPlan');

INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL, IND_TASK_CODE_PREFER)
VALUES
('7340', 'ASM', 'FPR', 'CPS', '1', '1', '1', '0', '0', '0', '1', 'Safety Assessment', 'CASE_CASESEARCH', 'ONG_ASSESSMENT', 'SAFETY_ASSESSMENT_EVENTLIST', '/assessment/SafetyAssessment/displaySafetyAssessment', 2);

INSERT INTO CAPS.TASK
(CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
VALUES
('7345', 'APP', 'FPR', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve Safety Assessment', 'CASE_CASESEARCH', 'ONG_ASSESSMENT', 'SAFETY_ASSESSMENT_EVENTLIST', '/assessment/SafetyAssessment/displaySafetyAssessment');

-- (3) update Safety Assessment message to make it stage generic
UPDATE CAPS.MESSAGE SET txt_message='Each principal must have an entered or estimated DOB.' WHERE txt_message_name='VICTIM_DOB_WARNING';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (244, 'SacwisRev2', 'static table updates');                        
commit;
