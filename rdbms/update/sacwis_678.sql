--STGAP00015698 - Release(3.5) To make Cases Without Periodic Review report state

-- Add new report parameter region to enable statewide option
-- Defect# STGAP00014164

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of children in DFCS custody in foster care and adoption stages where the most recent case review for the child is either more than 5 months from the report run date or past due. Generated for optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'CasesWithoutPeriodicReview' and NM_RPT_SQR_VER = '00';


UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'CasesWithoutPeriodicReview' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'CasesWithoutPeriodicReview' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('CasesWithoutPeriodicReview', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (679, 'SacwisRev3', 'Release 3.5 - DBCR 15698');

commit;

