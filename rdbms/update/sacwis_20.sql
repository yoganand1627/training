
-- Standard Alter Table SQL

ALTER TABLE CAPS.EMP_JOB_HISTORY MODIFY(DT_JOB_START   NULL)
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 67
INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('3041', SYSDATE, 'APP', 'SUB', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('2366', SYSDATE, 'APP', 'INV', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('4361', SYSDATE, 'APP', 'FSU', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('5861', SYSDATE, 'APP', 'FRE', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('7221', SYSDATE, 'APP', 'FPR', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('8551', SYSDATE, 'APP', 'ADO', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Legal Action', -- decode 
'CASE_CASESEARCH', -- first tab 
'LEGAL_EVENTLIST', -- second tab 
'LEGAL_ACTIONS_EVENTLIST', -- third tab 
'/subcare/LegalActions/displayLegalActions' -- url 
);

-- change 68
UPDATE CAPS.CODES_TABLES SET DT_END = NULL  WHERE CODE = '0' AND CODE_TYPE = 'CINCCTYP'; 
UPDATE CAPS.CODES_TABLES SET DT_END = NULL  WHERE CODE = '2' AND CODE_TYPE = 'CINCCTYP';

-- change 70
INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'VL', 'Volunteer', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'FC', 'Foster Parent (CPA/CCI)', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'PF', 'Putative Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'LF', 'Legal Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'BF', 'Biological Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'LC', 'Legal Custodian', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CRELVICT', 'BM', 'Biological Mother to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'VL', 'Volunteer', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'FC', 'Foster Parent (CPA/CCI)', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'PF', 'Putative Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'LF', 'Legal Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'BF', 'Biological Father to Child', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'LC', 'Legal Custodian', NULL, SYSDATE); 

INSERT INTO caps.codes_tables 
VALUES('CSRCRPTR', 'BM', 'Biological Mother to Child', NULL, SYSDATE);

-- change 71
INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('2286', SYSDATE, 'APP', 'INV', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Safety Assessment', -- decode 
'CASE_CASESEARCH', -- first tab 
'RISK_ASSESSMENT_RISKASSMT', -- second tab 
'SAFETY_ASSESSMENT_EVENTLIST', -- third tab 
'/assessment/SafetyAssessment/displaySafetyAssessment' -- url 
);

INSERT INTO CAPS.TASK 
(cd_task, dt_last_update, cd_task_event_type, cd_task_stage, cd_task_stage_program, ind_task_event_create, ind_task_event_navig, ind_task_multiple_instance, ind_task_new_using, INd_task_nu_across_case, ind_task_rtrv_prior_stage, ind_task_show_in_list, txt_task_decode, txt_1ST_tab, txt_2nd_tab, txt_3rd_tab, txt_event_detail_url) 
VALUES 
('2321', SYSDATE, 'APP', 'INV', 'CPS', 
0, -- event create 
1, -- event navig 
1, -- mult instance 
0, -- new using 
0, -- nu across case 
0, -- rtrv prior stage 
0, -- show in list 
'Approve Policy Wavier', -- decode 
'CASE_CASESEARCH', -- first tab 
'CASE_MANAGEMENT_CASEMNT', -- second tab 
'POLICY_WAIVER_EVENTLIST', -- third tab 
'/investigation/PolicyWaiver/displayPolicyWaiver' -- url 
);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (21, 'SacwisRev1', 'make dt_job_start in emp_job_history nullable, static updates');
                         
commit;
