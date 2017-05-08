--STGAP00015721 - Release(3.5) Monthly Family Team Meetings

--DBCR to add new parameters (Region)( and change the sequence for the County
--and Unit Parameters  and change county to an optional parameter
-- Defect# STGAP00013956


UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of cases that have had a family team meeting conducted within the reporting month. Generated for a specific reporting month with optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'MonthlyFamilyTeamMeetings'
and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME =  'MonthlyFamilyTeamMeetings'  and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'MonthlyFamilyTeamMeetings' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) VALUES (
'MonthlyFamilyTeamMeetings', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (695, 'SacwisRev3', 'Release 3.5 - DBCR 15721');

commit;


