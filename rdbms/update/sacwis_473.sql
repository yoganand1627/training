--STGAP00014004 - Hide UDR Resource Development Link on Reports Page

--Note:  no impact to conversion 


UPDATE CAPS.REPORTS SET IND_RPT_PAGE = 'N' WHERE NM_RPT_SQR_NAME = 'UDRResourceDevRept' AND NM_RPT_SQR_VER = '00';


--STGAP00014009 - Reports: made Re-determination report statewide

--Note:  no impact to conversion


--DBCR for defect STGAP00013752 to enable statewide option

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of children in foster care with a IV-E redetermination due within the next 45 days. Also includes cases without an eligibility review date entered. Generated for optional region, county, and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'RedeterminationDue' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'RedeterminationDue' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'RedeterminationDue' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('RedeterminationDue', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


--STGAP00014018 - Reports: Enable statewide option (3 reports)

--Note:   no impact to conversion

--DBCR for defect STGAP00013753 to enable report to run statewide

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'List of approved, active eligibility records for the reporting month. Generated for a specific month with optional region and county parameters.', 
TXT_RPT_FULL_NAME = 'Eligibility Monthly'
WHERE NM_RPT_SQR_NAME = 'EligibilityMonthly' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'EligibilityMonthly' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('EligibilityMonthly', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


--DBCR for defect STGAP00013750 to enable report to run statewide

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of foster care cases that have been opened for more than 45 days without an approved eligibility determination. Generated for optional region, county, and unit parameters.' 
WHERE NM_RPT_SQR_NAME = 'OverStandardofPromptness' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'OverStandardofPromptness' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'OverStandardofPromptness' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('OverStandardofPromptness', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

--DBCR for defect STGAP00013749 to enable report to run statewide

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of children who exited foster care during the reporting month.  Generated for a specific month with optional region and county parameters.'
WHERE NM_RPT_SQR_NAME = 'AfcarsDischarge' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'AfcarsDischarge' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('AfcarsDischarge', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


--STGAP00014033 - Add new Message for Adoption Agreement

--Note:  no impact to conversion

INSERT INTO CAPS.MESSAGE(DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES(SYSDATE,99329,'MSG_AGMT_PAYMENT_MTHD_REQD','Please Specify a Payment Method when saving a Special Service or Non-Recurring Agreement.',700,500,'N');


--STGAP00014048 - Reports: Make Pending Incidents statewide

--Note:  no impact to conversion

-- Add new report parameter region dropdn to enable statewide option
-- Defect# STGAP00013736

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of open investigations and the days pending from the intake date.  Generated for optional region, county, and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'PendingIncidents' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'PendingIncidents' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'PendingIncidents' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('PendingIncidents', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

alter table caps.RISK_ASSESSMENT add CD_CURRENT_LVL_RISK varchar2(3);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (474, 'SacwisRev3', 'Release 3.1 - DBCRs 14004,14009,14018,14033,14048');

commit;


