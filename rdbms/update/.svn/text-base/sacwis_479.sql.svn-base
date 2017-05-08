--STGAP00014248 - Rename columns in case_review

--Note:   no impact to ado model


-- modified DBCR yesterday was not picked up, need to change the column names
alter table "CAPS"."CASE_REVIEW" rename column "ID_FIRST_ASSIGNED_TO" to "ID_CREATED_FOR_PERSON";
alter table "CAPS"."CASE_REVIEW" rename column "SAMPLE_TYPE" to "CD_BATCH_SAMPLE_TYPE";


--STGAP00014259 - Enable statewide for Children in FC over 18 mons

--Note:   no impact to ado model


-- Defect# 14166
-- Add region as optional parameter, update county to be optional, re-sequence inputs and update description.

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'The report displays a list of children in foster care for 18 months or more. Generated for optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'ChildrenInFCFOver18Months' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'ChildrenInFCFOver18Months' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'ChildrenInFCFOver18Months' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('ChildrenInFCFOver18Months', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (480, 'SacwisRev3', 'Release 3.1 - DBCRs 14248,14259');

commit;


