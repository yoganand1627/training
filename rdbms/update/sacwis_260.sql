-- Standard Alter Table SQL
ALTER TABLE CAPS.REPORTS ADD NM_RPT_DESC VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.REPORTS ADD NM_RPT_AREA_TYPE VARCHAR2(50)     NULL
;
ALTER TABLE CAPS.REPORTS ADD IND_RPT_PAGE VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.REPORT_PARAMETER ADD IND_REQUIRED VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.REPORT_PARAMETER ADD NM_RPT_PARM_LABEL VARCHAR2(50)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- Change STGAP00006466
UPDATE CAPS.CODES_TABLES
SET DECODE = '55382 - Relative Care Subsidy Payments - Undocumented Children'
WHERE CODE_TYPE = 'CRELCODE'
AND CODE = '55382';

-- Change STGAP00006497 update service authorization codes

--This update hides UAS progam codes which are used rarely enough that they
--only clutter Service Authorization

UPDATE CAPS.CODES_TABLES SET DT_END = SYSDATE, DT_LAST_UPDATE = SYSDATE
WHERE CODE_TYPE = 'CPRGCOD1' AND CODE IN ('510','512','522','531','547',
'598','597','698','252','253','450','460');

--The following insert statements update the CRELCODE codes table to allow
--the services no longer able to be service authed due to the above to now
--be added directly to delivered services invoices

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25200','25200 - Child Incidentals',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25201','25201 - Child Board (Per Diem)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25205','25205 - Child Clothing - Annual',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25210','25210 - Child Medical',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25217','25217 - Child Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '25300','25300 - Donation Funds Expenses',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45000','45000 - County Miscellaneous',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45001','45001 - County Board (Per Diem)',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45005','45005 - County Clothing - Annual',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45010','45010 - County Medical',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45017','45017 - County Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45091','45091 - Mileage Cost',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45092','45092 - School Pictures',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45093','45093 - Birthdays',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45094','45094 - Haircuts',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45095','45095 - Diapers',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45096','45096 - School Supplies',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45097','45097 - Allowance',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '45098','45098 - Christmas',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46000','46000 - County Miscellaneous',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46001','46001 - County Board',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46004','46004 - County Clothing',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46005','46005 - County Clothing - Annual',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46010','46010 - County Medical',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46017','46017 - County Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46091','46091 - Mileage Cost',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46092','46092 - School Pictures',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46093','46093 - Birthdays',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46094','46094 - Haircuts',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46095','46095 - Diapers',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46096','46096 - School Supplies',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46097','46097 - Allowance',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '46098','46098 - Christmas',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033a','51033a - Court Costs',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033b','51033b - Attorney Fees',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033c','51033c - Physicals for Adopting parents',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033d','51033d - Travel and Lodging during pre placement period',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033e','51033e - Adoption Assessment',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51033f','51033f - Other non-recurring costs',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51217','51217 - Supplemental Supervision',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51257','51257 - Adoptive Placement Reimbursement',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51258a','51258a - Therapy',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51258b','51258b - Orthodontics',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51258c','51258c - Surgery',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51258d','51258d - Other Reimbursable Services',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51260','51260 - Respite Care',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '51277','51277 - Adoptive Placement Reimbursement Foster Parent Conversion',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '52200','52200 - Overnight Stay in Hotels',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106a','53106a - Support Services - Drug Screens',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106b','53106b - Support Services - Physicals',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106c','53106c - Support Services - Lab Tests',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106d','53106d - Support Services - Background checks',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106e','53106e - Environmental Inspections',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106f','53106f - Septic Tanks Pumped',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53106g','53106g - Additional Training and IMPACT Materials',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53167','53167 - IMPACT Training Costs',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53168a','53168a - Continued Parent Development',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53168b','53168b - CPR and First Aid Training',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '53168c','53168c - Annual Adoptive and Foster Parent Conference Costs',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '54796','54796 - Family FC Emergency Beds',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '54797','54797 - IFC Emergency Beds',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '597W1','597W1 - Wraparound Level 1',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '597W2','597W2 - Wraparound Level 2',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '598W1','598W1 - Wraparound Level 1',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '598W2','598W2 - Wraparound Level 2',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CRELCODE', '69841','69841 - Emergency Benefits',SYSDATE);

--The following statements update text involved in service auths to clarify
--certain code selections for case managers

UPDATE CAPS.CODES_TABLES SET DECODE = '511 - CCFA Assessment and Former PPST',
DT_LAST_UPDATE = SYSDATE WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = '511';

UPDATE CAPS.CODES_TABLES SET DECODE = 'Other Reimbursable Services - Former PPST',
DT_LAST_UPDATE = SYSDATE WHERE CODE_TYPE = 'CSVCCODE' AND CODE = '51112';

--The following insert new service codes into service authorization to better
--support Georgia's business

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871d','51871d - Drug Screens - Hair Follicide',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871e','51871e - Drug Screens - Urine',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871f','51871f - Drug Screens - Breath Scan',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871g','51871g - Drug Screens - Other',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871h','51871h - Substance Abuse Assessment',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871i','51871i - Domestic Violence Assessment',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871j','51871j - Relative Home Evaluation',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871k','51871k - Mental Health Assessments',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871l','51871l - Paternity Testing - First Child',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871m','51871m - Paternity Testing - Additional Child',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871n','51871n - Background Checks',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51871o','51871o - Other In Home Case Management',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '51895c','51895c - In Home Intensive Treatment - Other Services',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '52151a','52151a - Drug Screens - Hair Follicide',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '52151b','52151b - Drug Screens - Urine',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '52151c','52151c - Drug Screens - Breath Scan',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '52151d','52151d - Drug Screens - Other',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '55179e','55179e - Other Early Intervention and Prevention Services',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CSVCCODE', '57372h','57372h - Other Parent Aide Services',SYSDATE);

--The following insert the relationships between the new service codes and 
--UAS program codes

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871d','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871e','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871f','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE)
VALUES ('CFLSVLNK', '51871g','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871h','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871i','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871j','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871k','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871l','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871m','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871n','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51871o','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '51895c','518',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '52151a','521',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '52151b','521',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '52151c','521',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '52151d','521',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '55179e','551',SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES ('CFLSVLNK', '57372h','573',SYSDATE);

--The following insert the new services into the EQUIVALENCY table to support
--payment of the new services

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871d','518','ALL','ALL','51871d',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871e','518','ALL','ALL','51871e',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871f','518','ALL','ALL','51871f',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871g','518','ALL','ALL','51871g',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871h','518','ALL','ALL','51871h',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871i','518','ALL','ALL','51871i',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871j','518','ALL','ALL','51871j',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) VALUES 
(0,'71','51871k','518','ALL','ALL','51871k',TO_DATE('09/01/2007','MM/DD/YYYY'),
TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871l','518','ALL','ALL','51871l',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871m','518','ALL','ALL','51871m',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871n','518','ALL','ALL','51871n',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'71','51871o','518','ALL','ALL','51871o',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'95','51895c','518','ALL','ALL','51895c',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'51','52151a','521','ALL','ALL','52151a',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'51','52151b','521','ALL','ALL','52151b',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'51','52151c','521','ALL','ALL','52151c',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'51','52151d','521','ALL','ALL','52151d',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'79','55179e','551','ALL','ALL','55179e',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

INSERT INTO CAPS.EQUIVALENCY (ID_EQUIV, CD_EQUIV_FUNDING_STREAM, 
CD_EQUIV_OBJ_ALW, CD_EQUIV_PAC, CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE, 
CD_EQUIV_SVC_DTL_SERVICE, DT_EQUIV_START_DATE, DT_EQUIV_END_DATE, 
NBR_EQUIV_OBJ_ALW, NBR_EQUIV_OBJ_CERT, NBR_EQUIV_OBJ_PURE) 
VALUES (0,'72','57372h','573','ALL','ALL','57372h',
TO_DATE('09/01/2007','MM/DD/YYYY'),TO_DATE('12/31/4712','MM/DD/YYYY'), 1,0,0);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (261, 'SacwisRev2', 'static table updates');                        
commit;
