-- change STGAP00007084 

-----TCM Statewide Billing Counts
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('TCMStatewideBillingCounts', '00', 7, 'A', 'TCM Statewide Billing Counts', 'ondport', 'P', 'W', 'A count of all TCM claims actually billed BY program TYPE (CPS, Safety RESOURCE, Placement, AND YPS). GENERATED FOR a specific service MONTH BETWEEN two specified billing dates, WITH an optional region parameter', 'TCM', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCounts', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Billing Start (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCounts', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'Billing End (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCounts', '00', 3, 7, 'MONTHYEAR', 'CHAR', 'Y', 'TCM Billing Month (MM/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCounts', '00', 4, 3, 'REGIONCD', 'CHAR', 'N', 'Region'); 

----Validation Status
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('ValidationStatus', '00', 7, 'A', 'Conversion Validation Status', 'ondport', 'P', 'W', 'A list of case manager conversion validation statistics orgarnized by region, county, unit and case manager. Generated for an optional region parameter', 'Administration', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'ValidationStatus', '00', 4, 3, 'REGIONCD', 'CHAR', 'N', 'Region'); 

-- Stage Validation Detail
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('StageValidationDetail', '00', 7, 'A', 'Conversion Validation Detail', 'ondport', 'P', 'W', 'A detailed view of cases and stages that require conversion validation organized by county, unit, and case manager. Generated for a specific county with optional case manager parameter', 'Administration', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'StageValidationDetail', '00', 4, 3, 'REGIONCD', 'CHAR', 'Y', 'Region'); 

insert into CAPS.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('StageValidationDetail', '00', 3, 16, 'STAFFID', 'CHAR', 'N', 'Staff ID');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (278, 'SacwisRev2', 'static table updates - Report tables');                        
commit;

