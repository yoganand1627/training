--STGAP00014442 - SQR Reports: Deactive old conversion reports

-- Hide old conversion reports. No longer used.

UPDATE CAPS.REPORTS
SET IND_RPT_PAGE = 'N' 
WHERE NM_RPT_SQR_NAME in ('ValidationStatus', 'StageValidationDetail')
and NM_RPT_SQR_VER = '00';


--STGAP00014443 - SQR Report: New reports ADAM Conv. Validation

-- Enable 2 new reports in Adoptions area

-- Status report
-- DEV#: STGAP00014409 
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('AdamConversionValidationStatus', '00', 7, 'A', 'Adoptions Conversion Validation Status', 'ondport', 'P', 'W', 'A list of adoptions validation statistics organized by region, county, unit, and/or case manager. Generated for optional region, county, unit and case manager parameters.', 'Adoptions', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationStatus', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');  

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationStatus', '00', 2, 3, 'COUNTYCD', 'CHAR', 'N', 'County');  

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationStatus', '00', 3, 2, 'UNIT', 'CHAR', 'N', 'Unit'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationStatus', '00', 4, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID'); 

------Detail report
-- DEV#: STGAP00014407
INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME, 
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE ) 
VALUES ('AdamConversionValidationDetail', '00', 7, 'A', 'Adoptions Conversion Validation Exception List', 'ondport', 'P', 'W', 'A detailed view of cases and stages that require conversion validation organized by region, county, unit, and/or case manager. Generated for optional region, county, unit and case manager parameters.', 'Adoptions', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationDetail', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');  

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, 
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationDetail', '00', 2, 3, 'COUNTYCD', 'CHAR', 'N', 'County');  

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationDetail', '00', 3, 2, 'UNIT', 'CHAR', 'N', 'Unit'); 

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'AdamConversionValidationDetail', '00', 4, 16, 'STAFFID', 'NUMBER', 'N', 'Staff ID'); 

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (485, 'SacwisRev3', 'Release 3.1 - DBCRs 14442,14443');

commit;


