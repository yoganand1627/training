-- All changes for version 2.4 of SHINES

-- change STGAP00008004
Insert into CAPS.TASK
   (CD_TASK, CD_TASK_EVENT_TYPE, CD_TASK_STAGE, CD_TASK_STAGE_PROGRAM, IND_TASK_EVENT_CREATE, IND_TASK_EVENT_NAVIG, IND_TASK_MULTIPLE_INSTANCE, IND_TASK_NEW_USING, IND_TASK_NU_ACROSS_CASE, IND_TASK_RTRV_PRIOR_STAGE, IND_TASK_SHOW_IN_LIST, TXT_TASK_DECODE, TXT_1ST_TAB, TXT_2ND_TAB, TXT_3RD_TAB, TXT_EVENT_DETAIL_URL)
 Values
   ('2035', 'APP', 'PFC', 'CPS', '0', '1', '1', '0', '0', '0', '0', 'Approve Legal Action', 'CASE_CASESEARCH', 'LEGAL_EVENTLIST', 'LEGAL_ACTIONS_EVENTLIST', '/subcare/LegalActions/displayLegalActions');

-- change STGAP00008007
UPDATE CAPS.CODES_TABLES
SET DECODE = 'Submitted for approval'
WHERE CODE ='SBA' AND CODE_TYPE = 'CINCMGST';

-- change STGAP00008009
UPDATE CAPS.METAPHOR M
SET M.TXT_TAB = 'Medicaid Application'
WHERE M.ID_TAB = 1571;

-- change STGAP00008010
UPDATE CAPS.METAPHOR M
SET M.TXT_TAB = 'IV-E Application/NOC'
WHERE M.ID_TAB = 65;

-- change STGAP00008018
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'FosterCareAge14AndOlder', '00', 31, 'A', 'Foster Care Age 14 And Older', 'ondport', 'L', 'W', 'A list of children in foster care age 14 and older in the County. Generated for a specific county with an optional case manager parameter.', 'Foster Care', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='FosterCareAge14AndOlder' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'FosterCareAge14AndOlder', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='FosterCareAge14AndOlder' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'FosterCareAge14AndOlder', '00', 2, 16, 'PERSONID', 'NUMBER', 'N', 'StaffID'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='FosterCareAge14AndOlder' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (310, 'SacwisRev2', 'static table updates');                        
commit;

