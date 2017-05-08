--STGAP00012845 - New SQR ECEM report

--Note:  new report no impact on ADO model


-- DEV CQ# STGAP00012846

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,
NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE )
VALUES ('EveryChildEveryMonth', '00', 7, 'A', 'Every Child Every Month', 'ondport', 'L', 'W', 
'A list of children in care and statistics on whether and where they were seen every month they were required to be seen. This report is used to support the ECEM program. Generated for a specific date range with optional region and county parameters.', 'Foster Care', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('EveryChildEveryMonth', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Begin Month');

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('EveryChildEveryMonth', '00', 2, 7, 'MONTHYEAR', 'CHAR', 'Y', 'End Month');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('EveryChildEveryMonth', '00', 3, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('EveryChildEveryMonth', '00', 4, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (446, 'SacwisRev3', 'Release 3.0 - DBCR 12845');

commit;


