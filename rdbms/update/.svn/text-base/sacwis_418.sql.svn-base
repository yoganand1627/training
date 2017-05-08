--STGAP00011787 - Reports: Insert rows to enable new report

--Note:  no impact ado model


--New SQR report for 3.0: Cases Without 6 Months Review

--Dev#: STGAP00011009
--Datafix for 2.6: STGAP00011424

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='CasesWithoutPeriodicReview'
and NM_RPT_SQR_VER='00') then
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, 
txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
select 'CasesWithoutPeriodicReview', '00', 31, 'A', 
'Cases Without 6 Months Review', 'ondport', 'L', 'W', 
'A list of children in DFCS custody in foster care and adoption stages where the most recent case review for the child is either more than 5 months from the report run date or past due. Generated for a specific County with an optional Unit parameter.', 
'Foster Care', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='CasesWithoutPeriodicReview'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name,
 txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CasesWithoutPeriodicReview', '00', 1, 3, 'COUNTYCD', 'CHAR', 'Y', 'County' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='CasesWithoutPeriodicReview'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name,
 txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CasesWithoutPeriodicReview', '00', 2 A, 2 B, 'UNIT' C, 'NUMBER', 'N', 'Unit' D from dual;


--STGAP00011790 - Reports: enable new SQR report

--Note: no impact to ado model


--New SQR report: Overdue Child Life History - Scorecard

--DEV#: STGAP00010327

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE, CD_SEC_ATTR )
VALUES ('Scorecard', '00', 7, 'A', 'Overdue Child Life History - Scorecard', 'ondport', 'P', 'W', 'A list of counties and compliant level toward the Adoption Policy 103.16 regarding timely registration of a child within 60 calendar days of the surrender or termination of parental right. Generated for a specific date range parameter. This report requires SAU staff security attribute.', 
'Adoptions', 'Y', '91');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('Scorecard', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Start Date');

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('Scorecard', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'End Date');


--STGAP00011792 - Reports: update report desc with sec. attr. needed

--Note: no impact to ado model

UPDATE CAPS.REPORTS
SET NM_RPT_DESC = 'A list of registered children that have not been adoption-finalized or finalization happened in the past 60 calendar days. Generated for an optional region and county parameter. This report requires SAU sealed security attribute.' WHERE NM_RPT_SQR_NAME = 'MonthlyChildMangement';

UPDATE CAPS.REPORTS
SET NM_RPT_DESC = 'A list of registered children being considered whose date out is more than 31 calendar days. Generated for an optional region and county parameter. This report requires SAU staff security attribute.' WHERE NM_RPT_SQR_NAME = 'ConsiderationOverdue';


--STGAP00011812 - Update Message text for MSG_FAD_ADPT_NOT_CONSUM

--Note: no impact to ado model

--As per STGAP00011598

UPDATE caps.message
SET TXT_MESSAGE = 'The adoption must be finalized for a non-recurring subsidy to be approved.'
WHERE NBR_MESSAGE = 8127 AND TXT_MESSAGE_NAME = 'MSG_FAD_ADPT_NOT_CONSUM';



--STGAP00011842 - Update task codes for PAD

--Note: no impact to ado model


--Update task codes for PAD stage tab ordering

update CAPS.TASK set IND_TASK_CODE_PREFER = 3 where CD_TASK = 9050; 
update CAPS.TASK set IND_TASK_CODE_PREFER = 2 where CD_TASK in (9070, 9075, 9071);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (419, 'SacwisRev3', 'Release 3.0 - DBCRs 11787,11790,11792,11812,11833,11842');

commit;

