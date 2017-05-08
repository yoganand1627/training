--STGAP00013222 - Alter table CASE_REVIEW
-- Drop column IND_SAMPLE from the CASE_REVIEW and Add CD_REVIEW_TYPE from the CASE_REVIEW

--NOTE:  no impact to ado conversion

alter table caps.case_review drop column ind_sample;
alter table caps.case_review add (cd_review_type varchar2(3));


--STGAP00013228 - Reports: TCM Denied Claim: update paramater label

--NOTE:  no impact to ado conversion

--Cosmetic update on report parameter page for TCM Denied Claims report per review meeting with Bryant Jenkins and Susan Morgan on 4/6/09
-- Original dbcr STGAP00013160
-- DEV#: STGAP00013184 (MR026)

update CAPS.REPORT_PARAMETER 
set NM_RPT_PARM_LABEL = 'Service Date From (MM/DD/YYYY)'
where NM_RPT_SQR_NAME = 'TCMDeniedClaimList' and NM_RPT_SQR_VER = '00' and NBR_RPT_PARM_SEQ = '1';

update CAPS.REPORT_PARAMETER 
set NM_RPT_PARM_LABEL = 'Service Date To (MM/DD/YYYY)'
where NM_RPT_SQR_NAME = 'TCMDeniedClaimList' and NM_RPT_SQR_VER = '00' and NBR_RPT_PARM_SEQ = '2';


--STGAP00013241 - Udpate Event Type Label

--NOTE:  no impact to ado conversion

-- For Defect STGAP00013083
UPDATE caps.codes_tables c
SET c.DECODE='Adoption Assistance Agreement'
WHERE c.code_type='CEVNTTYP'
AND c.code='ADP';



--STGAP00013240 - PerSTGAP00012281: Update TODO_INFO table

--NOTE:  no impact to ado conversion

--Per STGAP00012281 need to change value for NBR_TODO_INFO_DUE_MM and NBR_TODO_INFO_TASK_DUE_DD so that correct Task Due Date is displayed on the ToDo list.

UPDATE CAPS.todo_info t
SET t.NBR_TODO_INFO_DUE_MM = 6, t.NBR_TODO_INFO_TASK_DUE_DD = null
WHERE t.ID_TODO_INFO = 3012887;



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (453, 'SacwisRev3', 'Release 3.1 - DBCRs 13222,13228,13241,13240');

commit;


