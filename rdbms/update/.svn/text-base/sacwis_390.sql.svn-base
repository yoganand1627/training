-- STGAP00010377 - Reports: Updates to TCM billing counts report

----------------Denied Claims
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('TCMStatewideBillingCountsDenied', '00', 7, 'A', 'Denied TCM Statewide Billing Counts', 'ondport', 'P', 'W', 'A count of all denied TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specific service month between two specified billing dates, with an optional region parameter.', 'TCM', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDenied', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Billing Start (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDenied', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'Billing End (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDenied', '00', 3, 7, 'MONTHYEAR', 'CHAR', 'Y', 'TCM Billing Month (MM/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDenied', '00', 4, 3, 'REGIONCD', 'CHAR', 'N', 'Region'); 

-----------------Re-billed Claims
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('TCMStatewideBillingCountsRebilled', '00', 7, 'A', 'Re-billed TCM Statewide Billing Counts', 'ondport', 'P', 'W', 'A count of all re-billed TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specific service month between two specified billing dates, with an optional region parameter.', 'TCM', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsRebilled', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Billing Start (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsRebilled', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'Billing End (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsRebilled', '00', 3, 7, 'MONTHYEAR', 'CHAR', 'Y', 'TCM Billing Month (MM/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsRebilled', '00', 4, 3, 'REGIONCD', 'CHAR', 'N', 'Region'); 

------------------Denied Re-billed Claims
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('TCMStatewideBillingCountsDeniedRebilled', '00', 7, 'A', 'Denied Re-billed TCM Statewide Billing Counts', 'ondport', 'P', 'W', 'A count of all denied re-billed TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specific service month between two specified billing dates, with an optional region parameter.', 'TCM', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDeniedRebilled', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Billing Start (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDeniedRebilled', '00', 2, 10, 'ENDDATE', 'DATE', 'Y', 'Billing End (MM/DD/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDeniedRebilled', '00', 3, 7, 'MONTHYEAR', 'CHAR', 'Y', 'TCM Billing Month (MM/YYYY)'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'TCMStatewideBillingCountsDeniedRebilled', '00', 4, 3, 'REGIONCD', 'CHAR', 'N', 'Region'); 

-----------------Update the existing one to be the Original TCM claim  billing counts

UPDATE CAPS.REPORTS SET TXT_RPT_FULL_NAME = 'Original TCM Statewide Billing Counts',
NM_RPT_DESC = 'A count of all new TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specific service month between two specified billing dates, with an optional region parameter.'
WHERE NM_RPT_SQR_NAME = 'TCMStatewideBillingCounts';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (391, 'SacwisRev2', 'Release 2.6 - DBCR 10377');
commit;