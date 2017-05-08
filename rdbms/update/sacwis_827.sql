--STGAP00015905 - Release(3.6) To enable OverdueHealthcheck rpt statewide

-- Add new report parameter region to enable statewide option
-- SMS #53183

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of foster children in DFCS custody with overdue health check(s) or upcoming due in the next 60 calendar days. Generated for optional Region, County, Unit and Case manager parameters.'
WHERE NM_RPT_SQR_NAME = 'ChildrenWithOverdueHealthchecks' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'STAFFID'
AND NM_RPT_SQR_NAME = 'ChildrenWithOverdueHealthchecks' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'ChildrenWithOverdueHealthchecks' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'ChildrenWithOverdueHealthchecks' and NM_RPT_SQR_VER = '00';


INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ChildrenWithOverdueHealthchecks', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (828, 'SacwisRev3', 'Release 3.6 - DBCR 15905');

commit;


