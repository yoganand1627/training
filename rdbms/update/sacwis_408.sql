--STGAP00011510 - Update AFCARS VIEW - Revised To Handle Alpha Chars

--Note:  no impact to ado model

--This revised AFCARS VIEW properly handles alpha numeric characters provided (rarely) in the Record Number of the AFCARS table.

CREATE OR REPLACE FORCE VIEW "CAPS"."AFCARS_VIEW" ("STATE", "REPORT_DATE", "DT_LAST_UPDATE", 
"LOCAL_AGENCY_FIPS_CODE", "RECORD_NUMBER", "DATE_OF_PERIODIC_REVIEW", "CHILDS_DATE_OF_BIRTH", 
"SEX", "RACE_A", "RACE_B", "RACE_C", "RACE_D", "RACE_E", "RACE_F", "HISPANIC_OR_LATINO_ORIGIN",
 "CHILD_DISABILITY", "MENTAL_RETARDATION", "VISUALLY_OR_HEARING_IMPAIRED", 
"PHYSICALLY_DISABLED", "EMOTIONALLY_DISTURBED", "OTHER_DIAGNOSED_CONDITION", 
"EVER_ADOPTED", "AGE_ADOPTED", "DATE_OF_FIRST_REMOVAL", "TOTAL_NUMBER_OF_REMOVALS", 
"LAST_FOSTER_CARE_DISCHARGE", "LATEST_REMOVAL_FROM_HOME", "REMOVAL_TRANSACTION_DATE",
 "DATE_OF_CURRENT_PLACEMENT", "NUMBER_PLACEMENT_SETTINGS", "MANNER_OF_REMOVAL", 
"PHYSICAL_ABUSE", "SEXUAL_ABUSE", "NEGLECT", "ALCOHOL_ABUSE_PARENT", "DRUG_ABUSE_PARENT", 
"ALCOHOL_ABUSE_CHILD", "DRUG_ABUSE_CHILD", "CHILDS_DISABILITY", "CHILDS_BEHAVIOR_PROBLEM", 
"DEATH_OF_PARENTS", "INCARCERATION_OF_PARENTS", "INABILITY_TO_COPE", "ABANDONMENT", 
"RELINQUISHMENT", "INADEQUATE_HOUSING", "CURRENT_PLACEMENT_SETTING", "OUT_OF_STATE", 
"MOST_RECENT_CASE_PLAN_GOAL", "CARETAKER_FAMILY_STRUCTURE", "YOB_1ST_PRIN_CARETAKER", 
"YOB_2ND_PRIN_CARETAKER", "RIGHTS_TERMINATION_MOTHER", "RIGHTS_TERMINATION_FATHER", 
"FOSTER_FAMILY_STRUCTURE", "YOB_1ST_FOSTER_CARETAKER", "YOB_2ND_FOSTER_CARETAKER", 
"RACE_1ST_FOSTER_CARETAKER_A", "RACE_1ST_FOSTER_CARETAKER_B", "RACE_1ST_FOSTER_CARETAKER_C", 
"RACE_1ST_FOSTER_CARETAKER_D", "RACE_1ST_FOSTER_CARETAKER_E", "RACE_1ST_FOSTER_CARETAKER_F", 
"HL_ORIGIN_1ST_FOS_CARETAKER", "RACE_2ND_FOSTER_CARETAKER_A", "RACE_2ND_FOSTER_CARETAKER_B", 
"RACE_2ND_FOSTER_CARETAKER_C", "RACE_2ND_FOSTER_CARETAKER_D", "RACE_2ND_FOSTER_CARETAKER_E", 
"RACE_2ND_FOSTER_CARETAKER_F", "HL_ORIGIN_2ND_FOS_CARETAKER", "DATE_OF_DISCHARGE", 
"DISCHARGE_TRANSACTION_DATE", "REASON_FOR_DISCHARGE", "TITLE_IV_E_FOSTER_CARE", 
"TITLE_IV_E_ADOPTION", "TITLE_IV_A", "TITLE_IV_D", "TITLE_XIX", "SSI", "NO_FED", 
"AMT_OF_FOSTER_CARE_PAYMENT", "PERSON_ID") AS 
Select
AFCARS.STATE,
AFCARS.REPORT_DATE,
AFCARS.DT_LAST_UPDATE,
AFCARS.LOCAL_AGENCY_FIPS_CODE,
AFCARS.RECORD_NUMBER,
AFCARS.DATE_OF_PERIODIC_REVIEW,
AFCARS.CHILDS_DATE_OF_BIRTH,
AFCARS.SEX,
AFCARS.RACE_A,
AFCARS.RACE_B,
AFCARS.RACE_C,
AFCARS.RACE_D,
AFCARS.RACE_E,
AFCARS.RACE_F,
AFCARS.HISPANIC_OR_LATINO_ORIGIN,
AFCARS.CHILD_DISABILITY,
AFCARS.MENTAL_RETARDATION,
AFCARS.VISUALLY_OR_HEARING_IMPAIRED,
AFCARS.PHYSICALLY_DISABLED,
AFCARS.EMOTIONALLY_DISTURBED,
AFCARS.OTHER_DIAGNOSED_CONDITION,
AFCARS.EVER_ADOPTED,
AFCARS.AGE_ADOPTED,
AFCARS.DATE_OF_FIRST_REMOVAL,
AFCARS.TOTAL_NUMBER_OF_REMOVALS,
AFCARS.LAST_FOSTER_CARE_DISCHARGE,
AFCARS.LATEST_REMOVAL_FROM_HOME,
AFCARS.REMOVAL_TRANSACTION_DATE,
AFCARS.DATE_OF_CURRENT_PLACEMENT,
AFCARS.NUMBER_PLACEMENT_SETTINGS,
AFCARS.MANNER_OF_REMOVAL,
AFCARS.PHYSICAL_ABUSE,
AFCARS.SEXUAL_ABUSE,
AFCARS.NEGLECT,
AFCARS.ALCOHOL_ABUSE_PARENT,
AFCARS.DRUG_ABUSE_PARENT,
AFCARS.ALCOHOL_ABUSE_CHILD,
AFCARS.DRUG_ABUSE_CHILD,
AFCARS.CHILDS_DISABILITY,
AFCARS.CHILDS_BEHAVIOR_PROBLEM,
AFCARS.DEATH_OF_PARENTS,
AFCARS.INCARCERATION_OF_PARENTS,
AFCARS.INABILITY_TO_COPE,
AFCARS.ABANDONMENT,
AFCARS.RELINQUISHMENT,
AFCARS.INADEQUATE_HOUSING,
AFCARS.CURRENT_PLACEMENT_SETTING,
AFCARS.OUT_OF_STATE,
AFCARS.MOST_RECENT_CASE_PLAN_GOAL,
AFCARS.CARETAKER_FAMILY_STRUCTURE,
AFCARS.YOB_1ST_PRIN_CARETAKER,
AFCARS.YOB_2ND_PRIN_CARETAKER,
AFCARS.RIGHTS_TERMINATION_MOTHER,
AFCARS.RIGHTS_TERMINATION_FATHER,
AFCARS.FOSTER_FAMILY_STRUCTURE,
AFCARS.YOB_1ST_FOSTER_CARETAKER,
AFCARS.YOB_2ND_FOSTER_CARETAKER,
AFCARS.RACE_1ST_FOSTER_CARETAKER_A,
AFCARS.RACE_1ST_FOSTER_CARETAKER_B,
AFCARS.RACE_1ST_FOSTER_CARETAKER_C,
AFCARS.RACE_1ST_FOSTER_CARETAKER_D,
AFCARS.RACE_1ST_FOSTER_CARETAKER_E,
AFCARS.RACE_1ST_FOSTER_CARETAKER_F,
AFCARS.HL_ORIGIN_1ST_FOS_CARETAKER,
AFCARS.RACE_2ND_FOSTER_CARETAKER_A,
AFCARS.RACE_2ND_FOSTER_CARETAKER_B,
AFCARS.RACE_2ND_FOSTER_CARETAKER_C,
AFCARS.RACE_2ND_FOSTER_CARETAKER_D,
AFCARS.RACE_2ND_FOSTER_CARETAKER_E,
AFCARS.RACE_2ND_FOSTER_CARETAKER_F,
AFCARS.HL_ORIGIN_2ND_FOS_CARETAKER,
AFCARS.DATE_OF_DISCHARGE,
AFCARS.DISCHARGE_TRANSACTION_DATE,
AFCARS.REASON_FOR_DISCHARGE,
AFCARS.TITLE_IV_E_FOSTER_CARE,
AFCARS.TITLE_IV_E_ADOPTION,
AFCARS.TITLE_IV_A,
AFCARS.TITLE_IV_D,
AFCARS.TITLE_XIX,
AFCARS.SSI,
AFCARS.NO_FED,
AFCARS.AMT_OF_FOSTER_CARE_PAYMENT, 
(
  NVL(to_char(
  (SELECT AH.ID_PERSON 
  FROM CAPS.AFCARS_HISTORY AH
  WHERE AFCARS.RECORD_NUMBER = AH.ID_AFCARS
  AND NOT EXISTS ( SELECT 'x'
               FROM CAPS.PERSON_MERGE
               WHERE AH.ID_PERSON = PERSON_MERGE.ID_PERS_MERGE_CLOSED 
               AND PERSON_MERGE.ID_PERS_MERGE_CLOSED <> person_merge.ID_PERS_MERGE_FORWARD
               AND PERSON_MERGE.DT_PERS_MERGE_SPLIT IS NULL
  ))),
  (SUBSTR(AFCARS.RECORD_NUMBER,6,1)||SUBSTR(AFCARS.RECORD_NUMBER,2,4)||
  SUBSTR(AFCARS.RECORD_NUMBER,1,1)||SUBSTR(AFCARS.RECORD_NUMBER,10,1)||SUBSTR(AFCARS.RECORD_NUMBER,8,2)||SUBSTR(AFCARS.RECORD_NUMBER,7,1)||
  SUBSTR(AFCARS.RECORD_NUMBER,11,2)))
) as PERSON_ID
FROM CAPS.AFCARS;


--STGAP00011466 - New Report: Children in FC 18+ Months

--Note:  no impact to ado model

--New Report: Children in Foster Care for 18 Months or More


insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='ChildrenInFCFOver18Months'
and NM_RPT_SQR_VER='00') THEN 
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, 
nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, 
txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
select 'ChildrenInFCFOver18Months', '00', 31, 'A', 
'Children In Foster Care Over 18 Months', 'ondport', 'L', 'W', 
' The report displays a list of children in foster care for 18 months or more. Generated for a specific County and Optional U
nit parameter.', 'Foster Care', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenInFCFOver18Months'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) THEN 
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, 
nm_rpt_parm_label)
select 'ChildrenInFCFOver18Months', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'county' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='ChildrenInFCFOver18Months'
and NM_RPT_SQR_VER='00'AND nbr_rpt_parm_seq=2) THEN 
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'ChildrenInFCFOver18Months', '00', 2, 3, 'UNIT' A, 'CHAR', 'N', 'unit' B from dual;


--STGAP00011485 - DBCR For DFCS Foster Home Monthly Status Report

--Note:  no impact to ado model


insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='DFCSFosterHomeMonthlyStatus'
and NM_RPT_SQR_VER='00') THEN
 into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, 
nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, 
txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
select 'DFCSFosterHomeMonthlyStatus', '00', 31, 'A', 
'DFCS Foster Home MonthlyStatus Report', 'ondport', 'L', 'W', 
'Monthly status view of the number of Active- Approved(Full),Approved(Special) and Approved(Temp)- DFCS Foster Homes in the
 County, Region or Statewide. Generated for specific Month and optional Region and County parameters.', 'Resource Development', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyStatus'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) THEN 
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'DFCSFosterHomeMonthlyStatus', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyStatus'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) THEN  
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'DFCSFosterHomeMonthlyStatus', '00', 2 A, 2 B, 'REGIONCD', 'CHAR', 'N', 'Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='DFCSFosterHomeMonthlyStatus'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) THEN 
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
 nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'DFCSFosterHomeMonthlyStatus', '00', 3 A, 3 B, 'COUNTYCD', 'CHAR', 'N', 'County' from dual;


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (409, 'SacwisRev3', 'Release 3.0 - DBCRs 11510,11466,11485');

commit;


