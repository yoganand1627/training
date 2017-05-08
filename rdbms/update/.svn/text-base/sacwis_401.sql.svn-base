--STGAP00011031 - (ADAM) Un End-Date UAS Program/Entitlement Code

UPDATE CAPS.CODES_TABLES SET DT_END=NULL WHERE CODE_TYPE='CPRGCOD1' AND CODE IN ('510', '512');



--STGAP00011083 - FH Conv Narrative Required Message Needed


Insert into caps.message
   ( DT_LAST_UPDATE, NBR_MESSAGE,
    TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (  SYSDATE, 60493,   'MSG_FAD_CONV_NARR_REQD',
   'Please complete the Foster Home Conversion Narrative when submitting a Foster Home Conversion for approval.', 500, 700, 'N');


--STGAP00011084 - New Codes needed to search for Narratives

INSERT INTO CAPS.CODES_TABLES VALUES('CEVNTTBL', 'FCD', 'DISRUPTION_NARRATIVE', NULL, SYSDATE);
INSERT INTO CAPS.CODES_TABLES VALUES('CEVNTTBL', 'HCN', 'FH_CONV_NARRATIVE', NULL, SYSDATE);


--STGAP00011110 - New Message and Task Code Metaphor Change

insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 values(SYSDATE, 60494, 'MSG_AA_APP_APROVE','Please provide your approval for the rate or service requested.', 500, 700, 'N');

update CAPS.task set ind_task_code_prefer=3 where cd_task in ('9105', '9115');


--STGAP00011111 - Change Message for FH Applied Date Error

UPDATE caps.message
SET TXT_MESSAGE = 'Applied date should be after the Inquiry date, and is the date the foster parents submitted the application to adopt a specific child or children in their home.'
WHERE NBR_MESSAGE = 60451 AND TXT_MESSAGE_NAME = 'MSG_FAD_CONV_APP_DATE';


--STGAP00011113 - new codes tables for ado agenecy

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '01', 'All Gods Children', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '02', 'Bethany Christian Services', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '03', 'Families First', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '04', 'The Giving Tree', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '05', 'Georgia Mentor', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '06', 'Lutheran Ministries of Georgia', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
values ('CADOAGEN', '07', 'ROOTS', null, sysdate);


--STGAP00011116 - new messages for adoption agreement

insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
values
   (SYSDATE, 60495, 'MSG_REQ_AMT_REQ', 'Requested Amount required when selecting Special Service Type Class of Assistance.', 500, 730, 'N');

insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
values
   (SYSDATE, 60496, 'MSG_AGMT_START_END_REQ', 'Both an Agreement Start and Agreement End date are required when an Approved Date has been entered.', 500, 730,'N');

insert into caps.message
   (DT_LAST_UPDATE, NBR_MESSAGE,TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
values
   (SYSDATE, 60497, 'MSG_ADO_SCHOOL_VER_REQ', 'Both an Agreement Start and Agreement End date are required when an Approved Date has been entered.', 500, 730, 'N');


-- STGAP00011146 - New Mesage for AA Application Approval

insert into caps.message( DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 values(SYSDATE, 60498, 'MSG_AA_APP_APPRV_PRIV','The person selected does not have sufficient privileges to approve the Adoption Assistance Application.', 500, 700, 'N');

--STGAP00011140 - Reports: Investigation Response Time List (New)

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00') then
INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
select 'InvestigationResponseTimeList' X, '00', 7, 'A', 'Investigation Response Time List', 'ondport', 'L', 'W', 'A list of investigations with response time details where the associated intake record was received during the reporting month. Generated for a specific month and county with an optional unit number parameters.', 'Investigations', 'Y' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) then
INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'InvestigationResponseTimeList', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Intake Month (MM/YYYY)' from dual; 

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) then
INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'InvestigationResponseTimeList', '00', 2, 3, 'COUNTYCD', 'CHAR', 'Y', 'County' from dual; 

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='InvestigationResponseTimeList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) then
INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
select 'InvestigationResponseTimeList', '00', 3 A, 3 B, 'UNITCD', 'CHAR', 'N', 'Unit' from dual; 



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (402, 'SacwisRev3', 'Release 3.0 - DBCRs 11031,11083,11084,11110,11111,11113,11116,11140,11146');

commit;

