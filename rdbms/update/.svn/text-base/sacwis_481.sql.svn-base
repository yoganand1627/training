--STGAP00014281 - SQR Reports: Enable statewide for 3 reports

--Note:  no impact to conversion


-- Make report able to run statewide: adding optional region parameter, make county option, re-sequence inputs
-- Open Diversion Cases report - Defect# STGAP00013953

UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'A list of all open diversion cases. Generated for optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'OpenDiversionCases' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'OpenDiversionCases' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'OpenDiversionCases' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('OpenDiversionCases', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

--On Call report - Defect# STGAP00013951
UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'On Call schedule with staff contact information. Generated for a specific date range, optional region and county parameters.'
WHERE NM_RPT_SQR_NAME = 'OnCall' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 4, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'OnCall' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('OnCall', '00', 3, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

-- IV-E Determination report - Defect# STGAP00013954
UPDATE CAPS.REPORTS SET NM_RPT_DESC = 'Initial IV-E determination for children who entered foster care within the past 45 days. Generated for optional region, county and unit parameters.'
WHERE NM_RPT_SQR_NAME = 'InitialIVEDetermination' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 3
WHERE NM_RPT_PARM_NAME = 'UNIT'
AND NM_RPT_SQR_NAME = 'InitialIVEDetermination' and NM_RPT_SQR_VER = '00';

UPDATE CAPS.REPORT_PARAMETER
SET NBR_RPT_PARM_SEQ = 2, IND_REQUIRED = 'N'
WHERE NM_RPT_PARM_NAME = 'COUNTYCD'
AND NM_RPT_SQR_NAME = 'InitialIVEDetermination' and NM_RPT_SQR_VER = '00';

INSERT INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ, NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME, TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL ) 
VALUES ('InitialIVEDetermination', '00', 1, 2, 'REGIONCD', 'CHAR', 'N', 'Region');

--STGAP00014282 - Do Not Alow Stg Progression from FCF(FSU)->PFC

--Note:  no impact to conversion

--Do not allow Stage Progression from FSU(FCF) to PFC
DELETE FROM CAPS.STAGE_PROG WHERE CD_STAGE_PROG_STAGE = 'FSU' AND CD_STAGE_PROG_RSN_CLOSE = 'FSU' AND CD_STAGE_PROG_OPEN = 'PFC';
DELETE FROM CAPS.STAGE_PROG WHERE CD_STAGE_PROG_STAGE = 'PFC' AND CD_STAGE_PROG_RSN_CLOSE = 'FSU' AND CD_STAGE_PROG_OPEN = 'PFC';

--STGAP00014347 - Update Text Help for CR question STGAP00014317

--Note:   no impact to conversion

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail (open each child)
Records Check.
Narrative Launch
Case Summary
'
WHERE CD_QUESTION  = 'Q09';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Person Characteristics 
Services and Referral Checklist
Service Authorizations
Log of Contacts
Safety Assessment
Family Plans
'
WHERE CD_QUESTION  = 'Q14';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCP-Family Plan (identify current permanency plan)
Legal Action
FCC-Child Plan-Case Plan Topics
External Documentation
'
WHERE CD_QUESTION  = 'Q49';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCP-Family Plan (identify current permanency plan)
Legal Action
FCC-Child Plan-Case Plan Topics
'
WHERE CD_QUESTION  = 'Q50';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Review both the FCF and FCC stages
Person Detail-diligent search
Person Detail-Person Characteristics-special needs
Legal Actions Page
'
WHERE CD_QUESTION  = 'Q69';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Child Plan-Case plan Topics-non-reunification
Legal Actions
'
WHERE CD_QUESTION  = 'Q70';


UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Case record Review
'
WHERE CD_QUESTION  = 'Q73';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-diligent search
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q116';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'FCC-Placement-Relative Care Assessment
External Documentation
Contact Detail 
Contact Narrative
Search FA Home for assessment
'
WHERE CD_QUESTION  = 'Q118';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'Person Detail-Education
FCC-Child Plan -Education
FCC-WTLP-Education
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q121';

UPDATE CAPS.CASE_REVIEW_QUES_LOOKUP 
SET TXT_QUES_HELP = 
'ONG-Family Plan Client Comments
Contact Detail 
Contact Narrative
'
WHERE CD_QUESTION  = 'Q140';



--STGAP00014378 - Update ADO_SUBSIDY_RATE

--Note:  no impact to conversion


update CAPS.ADO_SUBSIDY_RATE set AMT_ADPT_SUB = 441.04 where CD_RATE_TYPE = 'A1';
update CAPS.ADO_SUBSIDY_RATE set AMT_ADPT_SUB = 463.85 where CD_RATE_TYPE = 'A2';
update CAPS.ADO_SUBSIDY_RATE set AMT_ADPT_SUB = 486.67 where CD_RATE_TYPE = 'A3';



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (482, 'SacwisRev3', 'Release 3.1 - DBCRs 14281,14282,14347,14378');

commit;


