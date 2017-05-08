--STGAP00014097 - Reports: Make Pending Incidents statewide

--Note:  no impact to ado model


-- Add new report parameter region dropdn to enable statewide option
-- Defect# STGAP00013748

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of overdue investigations (more than 45 days) and the days pending from the intake date. Generated for optional region, county, unit and staff parameters.'
WHERE NM_RPT_SQR_NAME = 'OverduePendingIncidents' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4
WHERE NM_RPT_PARM_NAME = 'STAFFID'
AND NM_RPT_SQR_NAME = 'OverduePendingIncidents' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'OverduePendingIncidents' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'OverduePendingIncidents' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('OverduePendingIncidents', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');



--STGAP00014125 - Reports: Enable new report PIP18 - Parent (ONG)

--Note:  no impact to ado model

-- To enable new PIP report - PIP#18: Parent Involvement in Case Planning in ONG stage
-- Dev# STGAP00014123

INSERT INTO CAPS.REPORTS ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_RETAINAGE, NM_RPT_TYPE, TXT_RPT_FULL_NAME,NM_RPT_TEMPLATE_NAME, NM_RPT_ORIENTATION, TXT_RPT_EMAIL_OPTIONS, NM_RPT_DESC, NM_RPT_AREA_TYPE, IND_RPT_PAGE )
VALUES ('ParentInvolvementInCasePlanningONG', '00', 7, 'A', 'Parent Involvement in Case Planning - ONG', 'ondport', 'L', 'W', 'A list of active Ongoing cases that did not have parent pariticipation in case planning. Generated optional region, county, and unit parameters.', 'CFSR', 'Y');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ParentInvolvementInCasePlanningONG', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

INSERT INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ParentInvolvementInCasePlanningONG', '00', 2, 3, 'COUNTYCD', 'CHAR', 'N', 'County');

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ParentInvolvementInCasePlanningONG', '00', 3, 2, 'UNIT', 'CHAR', 'N', 'Unit');


--STGAP00014132 - Allow Stage Prog from SUB->PFC w/ no close reason

--Note:  no impact to ado model


-- Allow Stage Progression from SUB to PFC without stage closure reason

INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_OPEN)
VALUES ('SUB', 'SUB', 'CPS', '0', 'PFC');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (476, 'SacwisRev3', 'Release 3.1 - DBCRs 14097,14125,14132');

commit;


