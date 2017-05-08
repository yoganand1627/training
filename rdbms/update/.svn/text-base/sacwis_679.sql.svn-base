--STGAP00015699 - Release(3.5) To make CaseWorker Child Visit report statewide

-- Add new report parameter region to enable statewide option
-- Defect# STGAP00014163

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of foster care cases with face to face contacts made with the child during the month. Generated for a specific reporting month and optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'CaseWorkerChildVisit' and NM_RPT_SQR_VER = '00';


UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'CaseWorkerChildVisit' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'CaseWorkerChildVisit' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('CaseWorkerChildVisit', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (680, 'SacwisRev3', 'Release 3.5 - DBCR 15699');

commit;

