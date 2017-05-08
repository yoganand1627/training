--STGAP00014701 - SQR: add new parameter to PIP18: Parent - ONG

-- Add month parameter to report per CFSR request (Susan Denney)
-- CQ#: STGAP00014651

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of active Ongoing cases that did not have parent involvement in case planning (CP). Generated for a specific month with optional region, county, and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2
WHERE NM_RPT_PARM_NAME = 'REGIONCD'
AND NM_RPT_SQR_NAME = 'ParentInvolvementInCasePlanningONG' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES ( 
'ParentInvolvementInCasePlanningONG', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (495, 'SacwisRev3', 'Release 3.13 - DBCR 14701');

commit;



