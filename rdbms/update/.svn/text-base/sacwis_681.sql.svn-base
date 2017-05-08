--STGAP00015701 - Release(3.5) To make ChildrenwithOverdueCaseplan statewide

-- Add new report parameter region to enable statewide option
-- Defect# STGAP00014237

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of foster children in DFCS custody for more than 30 days without a case plan or whose most recent approved case plan has expired. Generated for optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'ChildrenWithOverdueCasePLan' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3 , NM_RPT_PARM_NAME = 'UNIT'
WHERE NM_RPT_PARM_NAME = 'UNITCD'
AND NM_RPT_SQR_NAME = 'ChildrenWithOverdueCasePLan' and NM_RPT_SQR_VER = '00';


UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'ChildrenWithOverdueCasePLan' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ChildrenWithOverdueCasePLan', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (682, 'SacwisRev3', 'Release 3.5 - DBCR 15701');

commit;


