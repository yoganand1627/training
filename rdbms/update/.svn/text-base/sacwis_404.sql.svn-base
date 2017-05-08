--STGAP00011317 - MR-ADO - Un End Date Home Info Characteristics

--Note:  no impact to ado model

--The 'Homosexual' and 'Transgender' characteristics were end-dated as part of  ADAM.  However, per the Resource SME, they were never approved by her to be end -dated, and she would like to keep them.

--These values need to be un-end-dated:

UPDATE CAPS.CODES_TABLES SET DT_END=NULL WHERE CODE_TYPE='CLNCHAR2' AND CODE IN ( '200', '201');


--STGAP00011331 - DBCR to fix the decode value of TPR - Ado Mother

--Note:  no impact to ado model

Update caps.Codes_tables
set decode = 'TPR - Adoptive Mother'
where code_type = 'CLHECOT'
and code = 'TPA';


--STGAP00011344 - Reports: Add parameter to Inv Response Time

--Note:  no impact to ado model

--Per client review the Investigation Response Time needs to have case manager  parameter and title updated.

DELETE FROM CAPS.REPORT_PARAMETER WHERE NM_RPT_SQR_NAME = 'InvestigationResponseTimeList';

UPDATE CAPS.REPORTS SET TXT_RPT_FULL_NAME = 'Investigation Response Time'
WHERE NM_RPT_SQR_NAME = 'InvestigationResponseTimeList';

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'InvestigationResponseTimeList', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Intake Month (MM/YYYY)' from dual;

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'InvestigationResponseTimeList', '00', 2, 3, 'COUNTYCD', 'CHAR', 'Y', 'County' from dual;

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'InvestigationResponseTimeList', '00', 3 A, 3 B, 'UNITCD', 'CHAR', 'N', 'Unit' from dual;

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=4) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'InvestigationResponseTimeList', '00', 4, 16, 'PERSONID' pid1, 'NUMBER', 'N', 'Person ID' pid2 from dual;




--STGAP00011346 - Reports: Cases without TCM (New)

--Note:  no impact ado model


-- This is to insert rows for new report Cases Without A Billable TCM Contact ( 3.0)

-- DEV#: STGAP00011008

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='CasesWithoutBillableTCMContact'
and NM_RPT_SQR_VER='00') THEN
 INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
select 'CasesWithoutBillableTCMContact', '00', 7, 'A', 'Cases Without A Billable TCM Contact', 'ondport', 'P', 'W', 'A list of all foster care, adoption and ongoing cases without a billable TCM contact recorded for the month. Generated for a specific month with optional region and county parameters.', 'TCM', 'Y' from dual;

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='CasesWithoutBillableTCMContact'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'CasesWithoutBillableTCMContact', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Contact Month (MM/YYYY)' from dual; 

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='CasesWithoutBillableTCMContact'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'CasesWithoutBillableTCMContact', '00', 2 A, 2 B, 'REGIONCD', 'CHAR', 'N', 'Region' from dual; 

insert all when not exists(select 'x' from caps.REPORT_PARAMETER where nm_rpt_sqr_name='CasesWithoutBillableTCMContact'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) THEN
 INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'CasesWithoutBillableTCMContact', '00', 3 A, 3 B, 'COUNTYCD', 'CHAR', 'N', 'County' from dual; 



--STGAP00011353 - new messages

--Note:  new messages no impact to ado model


Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60503,   'MSG_AA_AGR_APPRV_PRIV',
   'The person selected does not have sufficient privileges to approve the Adoption Assistance Agreement.', 500, 700, 'N');

Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60504,   'MSG_AA_AGR_SCHOOL_VER',
   'School enrollment must be verified quarterly if the child is between 18 and 21 years old.', 500, 700, 'N');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (405, 'SacwisRev3', 'Release 3.0 - DBCRs 11317,11331,11344,11346,11353');

commit;


