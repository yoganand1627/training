--STGAP00013756 - Reports: Additional parameters to Response Time

-- Per client request to allow Response Time List report run statewide
-- Defect# STGAP00012097

--Note: no impact to ado conversion

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of investigations with response time details where the associated intake record was received during the reporting month. Generated for a specific month with optional region, county, unit number and case manager ID parameters.'
WHERE NM_RPT_SQR_NAME = 'InvestigationResponseTimeList' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 5
WHERE NM_RPT_PARM_NAME = 'STAFFID'
AND NM_RPT_SQR_NAME = 'InvestigationResponseTimeList' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4
WHERE NM_RPT_PARM_NAME = 'UNITCD'
AND NM_RPT_SQR_NAME = 'InvestigationResponseTimeList' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'InvestigationResponseTimeList' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'InvestigationResponseTimeList', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region'); 

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME, 
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH) 
VALUES(SYSDATE,60544,'MSG_ADO_EXH_APRV_FH_CONV_REQ','Must have an active adoptive home or an active and approved FH Conversion.', 
700,500,'N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (469, 'SacwisRev3', 'Release 3.1 - DBCR 13756');

commit;


