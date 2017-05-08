--STGAP00011909 - Reports: Insert rows to enable new report

--Note:   no impact to ado model

--New SQR report for 3.0: My Turn Now Exception List

--Dev# STGAP00010326

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='MyTurnNowException'
and NM_RPT_SQR_VER='00') then
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page,cd_sec_attr)
select 'MyTurnNowException', '00', 31, 'A', 'My Turn Now Exception List', 'ondport', 'L',
'W', 'A list of children free for adoption who has not been registered with My Turn Now. Generated for an Optional Region or County parameters. This report requires SAU staff security attribute', 'Adoptions', 'Y', '91' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='MyTurnNowException'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=1) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length,
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'MyTurnNowException', '00', 1, 2, 'RegionCD', 'CHAR', 'N', 'Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='MyTurnNowException'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=2) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length,
nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'MyTurnNowException', '00', 2, 3, 'CountyCD' C, 'NUMBER', 'N', 'County' D from dual;


--STGAP00011911 - Reports: Insert statements to enable new report

--Note:  no impact to ado model

--New SQR report for 3.0: Period Finalization List Report

--Dev#: STGAP00010329

insert all when not exists(select 'x' from caps.reports where nm_rpt_sqr_name='PeriodFinalizationList'
and NM_RPT_SQR_VER='00') then
into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc,
 nm_rpt_area_type, ind_rpt_page,cd_sec_attr)
select 'PeriodFinalizationList', '00', 31, 'A', 'Period Finalization List Report', 'ondport', 'L',
'W', 'A list of all finalized adoptions that were in DFCS custody in County, Region or Statewide. Generated for optional Region and County parameters.This report requires SAU sealed security attribute.', 'Adoptions', 'Y',90 from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='PeriodFinalizationList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) then
INTO CAPS.REPORT_PARAMETER (NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,
TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'PeriodFinalizationList', '00', 1, 10, 'BEGINDATE', 'DATE', 'Y', 'Start Date' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='PeriodFinalizationList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) then
INTO CAPS.REPORT_PARAMETER ( NM_RPT_SQR_NAME, NM_RPT_SQR_VER, NBR_RPT_PARM_SEQ,
NBR_RPT_PARM_LENGTH, NM_RPT_PARM_NAME,TXT_RPT_PARM_TYPE, IND_REQUIRED, NM_RPT_PARM_LABEL )
select 'PeriodFinalizationList', '00', 2, 10, 'ENDDATE' a, 'DATE', 'Y', 'End Date' b from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='PeriodFinalizationList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=3) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name,
txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'PeriodFinalizationList', '00', 3, 2, 'REGIONCD', 'CHAR', 'N', 'Region' from dual;

insert all when not exists(select 'x' from caps.report_parameter where nm_rpt_sqr_name='PeriodFinalizationList'
and NM_RPT_SQR_VER='00' AND nbr_rpt_parm_seq=4) then
into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name,
txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'PeriodFinalizationList', '00', 4 ,3, 'COUNTYCD' C, 'CHAR', 'N', 'County' from dual;


--STGAP00011921 - Combine the term Check List into one word for Task

--Note:  no impact to ado model

UPDATE caps.TASK
SET TXT_TASK_DECODE = 'Child Life History Checklist'
WHERE CD_TASK = 8720;

UPDATE caps.TASK
SET TXT_TASK_DECODE = 'Approve Child Life History Checklist'
WHERE CD_TASK = 8900;


--STGAP00011923 - DBCR: Perform Adoptions Code Clean-up

--Note:  no impact to ado model

--The attached file corrects several items tied to adoptions codes in SHINES:

--1) Restores entitlement code 57 and 77
--2) Ends codes for 57 and 77 that are now further broken down (57a, 77a), etc.
--3) Corrects codes tables for adoptive home contract generation to match COSTAR updates for SFY '09
--4) Adds codes 51257a, 51257b, 51277a, 51277b

--None of these items are expected to affect the current conversion scope.




--STGAP00011923 - Adoption Codes Clean up

--End date codes that have been removed or broken down into more detailed codes
UPDATE CAPS.CODES_TABLES SET DT_END = TO_DATE('07/01/2008','MM/DD/YYYY')
WHERE CODE IN ('51257','51277','51033d','51033e','51033f');

UPDATE CAPS.EQUIVALENCY SET DT_EQUIV_END_DATE = TO_DATE('07/01/2008','MM/DD/YYYY')
WHERE CD_EQUIV_SVC_DTL_SERVICE IN ('51257','51277','51033d','51033e','51033f');

--Remove end date for entitlement codes 57 and 77 for purchase of service
UPDATE CAPS.CODES_TABLES SET DT_END = NULL WHERE CODE_TYPE = 'CENTCODE'
AND CODE IN ('57','77');

--Fix records existing for 51033 instead of subcodes

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES ('CLADPT','51033a','NONREC');
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES ('CLADPT','51033b','NONREC');
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES ('CLADPT','51033c','NONREC');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) VALUES ('CADOUTYP','51258d','SUB');

--Perform full insert of codes 51257a,51257b,51277a,51277b

--51257a

/
DECLARE

svcCode VARCHAR(6);
svcDesc VARCHAR(370);
progCode VARCHAR(3);
entCode VARCHAR(2);
newProg BOOLEAN;
newEnt BOOLEAN;
progDesc VARCHAR(370);
entDesc VARCHAR(370);
sa BOOLEAN;
pssf BOOLEAN;
effective DATE;
relCare BOOLEAN;
fcAddOn BOOLEAN;
mileage BOOLEAN;
caseBudgetLimit BOOLEAN;
svcLineItemLimit BOOLEAN;
caseBudgetLimitAmt VARCHAR(7);
svcLineItemLimitAmt VARCHAR(7);
fosterContract BOOLEAN;
adoptContract BOOLEAN;
CCIcontract BOOLEAN;
CPAcontract BOOLEAN;
adoType VARCHAR(6);
unit VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);
missingData BOOLEAN;
df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51257a';
progCode := SUBSTR(svcCode,1,3);
entCode := SUBSTR(svcCode,4,2);
svcDesc := '51257a - Purchase of Service - Adoptive Placement Cost';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := TRUE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '2500.00';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
unit := '';
pay := '';
amt := '';
 
--INSERT INTO CSVCCODE for all codes
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSVCCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSVCCODE' AND CODE = svcCode);

--INSERT INTO CFLSVLNK FOR ALL CODES 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFLSVLNK',svcCode,progCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFLSVLNK' AND CODE = svcCode);

IF newEnt = TRUE THEN

--Only if a new entitlement code, add to CENTCODE
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CENTCODE',entCode,entDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = entCode);

END IF;

IF newProg = TRUE THEN

--Only if a new program code, add to the required program codes tables
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCODE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCODE' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGAREA',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGAREA' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPROGCDE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPROGCDE' AND CODE = progCode);

END IF;

IF sa = TRUE THEN

--If program is to be used on service authorization, add to CPRGCOD1 if it does not already exist
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCOD1',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = progCode);

END IF;

--Insert into EQUIVALENCY, using rules for PSSF
IF pssf = TRUE THEN

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_OBJ_CERT,CD_EQUIV_OBJ_PURE,CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode, progCode||'r', progCode||'00',progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,-0.25,0.25 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

ELSE  

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode,progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,0,0 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

END IF;

--If an add on line item for FC invoices the service must be in CADDONLI to prevent 
--rejection by invoice validation
IF fcAddOn = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADDONLI',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADDONLI' AND CODE = svcCode);

END IF;

--If an item to be added to delievered services invoices w/o service auth
--for either relative care or mileage, must add to CRELCODE
IF relCare = TRUE OR mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CRELCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CRELCODE' AND CODE = svcCode);

END IF; 


--If specifically a mileage reimbursement not requiring service authorization
--add to CMILEAGE
IF mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CMILEAGE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CMILEAGE' AND CODE = svcCode);

END IF;

--If case budget limit, insert code and amount into CSBGTLMT
IF caseBudgetLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSBGTLMT',svcCode,caseBudgetLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSBGTLMT' AND CODE = svcCode);

END IF;

--If service authorization line item limit, insert code and amount into CSAMTLMT
IF svcLineItemLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSAMTLMT',svcCode,svcLineItemLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSAMTLMT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a foster home
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF fosterContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a adoptive homes
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF adoptContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CLADPT',svcCode,adoType FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CLADPT' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CCI contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CCIcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCISVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCISVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CPA contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CPAcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPASVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPASVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

END;

/

/
--51257b

DECLARE

svcCode VARCHAR(6);
svcDesc VARCHAR(370);
progCode VARCHAR(3);
entCode VARCHAR(2);
newProg BOOLEAN;
newEnt BOOLEAN;
progDesc VARCHAR(370);
entDesc VARCHAR(370);
sa BOOLEAN;
pssf BOOLEAN;
effective DATE;
relCare BOOLEAN;
fcAddOn BOOLEAN;
mileage BOOLEAN;
caseBudgetLimit BOOLEAN;
svcLineItemLimit BOOLEAN;
caseBudgetLimitAmt VARCHAR(7);
svcLineItemLimitAmt VARCHAR(7);
fosterContract BOOLEAN;
adoptContract BOOLEAN;
CCIcontract BOOLEAN;
CPAcontract BOOLEAN;
adoType VARCHAR(6);
unit VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);
missingData BOOLEAN;
df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51257b';
progCode := SUBSTR(svcCode,1,3);
entCode := SUBSTR(svcCode,4,2);
svcDesc := '51257b - Purchase of Service - Adoptive Finalization Cost';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := TRUE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '2500.00';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
unit := '';
pay := '';
amt := '';
 
--INSERT INTO CSVCCODE for all codes
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSVCCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSVCCODE' AND CODE = svcCode);

--INSERT INTO CFLSVLNK FOR ALL CODES 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFLSVLNK',svcCode,progCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFLSVLNK' AND CODE = svcCode);

IF newEnt = TRUE THEN

--Only if a new entitlement code, add to CENTCODE
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CENTCODE',entCode,entDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = entCode);

END IF;

IF newProg = TRUE THEN

--Only if a new program code, add to the required program codes tables
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCODE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCODE' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGAREA',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGAREA' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPROGCDE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPROGCDE' AND CODE = progCode);

END IF;

IF sa = TRUE THEN

--If program is to be used on service authorization, add to CPRGCOD1 if it does not already exist
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCOD1',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = progCode);

END IF;

--Insert into EQUIVALENCY, using rules for PSSF
IF pssf = TRUE THEN

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_OBJ_CERT,CD_EQUIV_OBJ_PURE,CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode, progCode||'r', progCode||'00',progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,-0.25,0.25 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

ELSE  

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode,progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,0,0 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

END IF;

--If an add on line item for FC invoices the service must be in CADDONLI to prevent 
--rejection by invoice validation
IF fcAddOn = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADDONLI',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADDONLI' AND CODE = svcCode);

END IF;

--If an item to be added to delievered services invoices w/o service auth
--for either relative care or mileage, must add to CRELCODE
IF relCare = TRUE OR mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CRELCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CRELCODE' AND CODE = svcCode);

END IF; 


--If specifically a mileage reimbursement not requiring service authorization
--add to CMILEAGE
IF mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CMILEAGE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CMILEAGE' AND CODE = svcCode);

END IF;

--If case budget limit, insert code and amount into CSBGTLMT
IF caseBudgetLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSBGTLMT',svcCode,caseBudgetLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSBGTLMT' AND CODE = svcCode);

END IF;

--If service authorization line item limit, insert code and amount into CSAMTLMT
IF svcLineItemLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSAMTLMT',svcCode,svcLineItemLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSAMTLMT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a foster home
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF fosterContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a adoptive homes
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF adoptContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CLADPT',svcCode,adoType FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CLADPT' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CCI contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CCIcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCISVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCISVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CPA contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CPAcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPASVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPASVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

END;

/

/
--51277a

DECLARE

svcCode VARCHAR(6);
svcDesc VARCHAR(370);
progCode VARCHAR(3);
entCode VARCHAR(2);
newProg BOOLEAN;
newEnt BOOLEAN;
progDesc VARCHAR(370);
entDesc VARCHAR(370);
sa BOOLEAN;
pssf BOOLEAN;
effective DATE;
relCare BOOLEAN;
fcAddOn BOOLEAN;
mileage BOOLEAN;
caseBudgetLimit BOOLEAN;
svcLineItemLimit BOOLEAN;
caseBudgetLimitAmt VARCHAR(7);
svcLineItemLimitAmt VARCHAR(7);
fosterContract BOOLEAN;
adoptContract BOOLEAN;
CCIcontract BOOLEAN;
CPAcontract BOOLEAN;
adoType VARCHAR(6);
unit VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);
missingData BOOLEAN;
df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51277a';
progCode := SUBSTR(svcCode,1,3);
entCode := SUBSTR(svcCode,4,2);
svcDesc := '51277a - Foster Home Conversion - Placement Cost';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := TRUE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '500.00';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
unit := '';
pay := '';
amt := '';
 
--INSERT INTO CSVCCODE for all codes
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSVCCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSVCCODE' AND CODE = svcCode);

--INSERT INTO CFLSVLNK FOR ALL CODES 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFLSVLNK',svcCode,progCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFLSVLNK' AND CODE = svcCode);

IF newEnt = TRUE THEN

--Only if a new entitlement code, add to CENTCODE
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CENTCODE',entCode,entDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = entCode);

END IF;

IF newProg = TRUE THEN

--Only if a new program code, add to the required program codes tables
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCODE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCODE' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGAREA',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGAREA' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPROGCDE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPROGCDE' AND CODE = progCode);

END IF;

IF sa = TRUE THEN

--If program is to be used on service authorization, add to CPRGCOD1 if it does not already exist
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCOD1',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = progCode);

END IF;

--Insert into EQUIVALENCY, using rules for PSSF
IF pssf = TRUE THEN

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_OBJ_CERT,CD_EQUIV_OBJ_PURE,CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode, progCode||'r', progCode||'00',progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,-0.25,0.25 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

ELSE  

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode,progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,0,0 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

END IF;

--If an add on line item for FC invoices the service must be in CADDONLI to prevent 
--rejection by invoice validation
IF fcAddOn = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADDONLI',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADDONLI' AND CODE = svcCode);

END IF;

--If an item to be added to delievered services invoices w/o service auth
--for either relative care or mileage, must add to CRELCODE
IF relCare = TRUE OR mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CRELCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CRELCODE' AND CODE = svcCode);

END IF; 


--If specifically a mileage reimbursement not requiring service authorization
--add to CMILEAGE
IF mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CMILEAGE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CMILEAGE' AND CODE = svcCode);

END IF;

--If case budget limit, insert code and amount into CSBGTLMT
IF caseBudgetLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSBGTLMT',svcCode,caseBudgetLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSBGTLMT' AND CODE = svcCode);

END IF;

--If service authorization line item limit, insert code and amount into CSAMTLMT
IF svcLineItemLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSAMTLMT',svcCode,svcLineItemLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSAMTLMT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a foster home
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF fosterContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a adoptive homes
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF adoptContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CLADPT',svcCode,adoType FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CLADPT' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CCI contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CCIcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCISVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCISVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CPA contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CPAcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPASVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPASVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

END;

/

/
--51277b

DECLARE

svcCode VARCHAR(6);
svcDesc VARCHAR(370);
progCode VARCHAR(3);
entCode VARCHAR(2);
newProg BOOLEAN;
newEnt BOOLEAN;
progDesc VARCHAR(370);
entDesc VARCHAR(370);
sa BOOLEAN;
pssf BOOLEAN;
effective DATE;
relCare BOOLEAN;
fcAddOn BOOLEAN;
mileage BOOLEAN;
caseBudgetLimit BOOLEAN;
svcLineItemLimit BOOLEAN;
caseBudgetLimitAmt VARCHAR(7);
svcLineItemLimitAmt VARCHAR(7);
fosterContract BOOLEAN;
adoptContract BOOLEAN;
CCIcontract BOOLEAN;
CPAcontract BOOLEAN;
adoType VARCHAR(6);
unit VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);
missingData BOOLEAN;
df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51277b';
progCode := SUBSTR(svcCode,1,3);
entCode := SUBSTR(svcCode,4,2);
svcDesc := '51277b - Foster Home Conversion - Finalization Cost';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := TRUE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '2500.00';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
unit := '';
pay := '';
amt := '';
 
--INSERT INTO CSVCCODE for all codes
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSVCCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSVCCODE' AND CODE = svcCode);

--INSERT INTO CFLSVLNK FOR ALL CODES 
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFLSVLNK',svcCode,progCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFLSVLNK' AND CODE = svcCode);

IF newEnt = TRUE THEN

--Only if a new entitlement code, add to CENTCODE
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CENTCODE',entCode,entDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = entCode);

END IF;

IF newProg = TRUE THEN

--Only if a new program code, add to the required program codes tables
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCODE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCODE' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGAREA',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGAREA' AND CODE = progCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPROGCDE',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPROGCDE' AND CODE = progCode);

END IF;

IF sa = TRUE THEN

--If program is to be used on service authorization, add to CPRGCOD1 if it does not already exist
INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CPRGCOD1',progCode,progDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = progCode);

END IF;

--Insert into EQUIVALENCY, using rules for PSSF
IF pssf = TRUE THEN

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_OBJ_CERT,CD_EQUIV_OBJ_PURE,CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode, progCode||'r', progCode||'00',progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,-0.25,0.25 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

ELSE  

INSERT INTO CAPS.EQUIVALENCY(ID_EQUIV,CD_EQUIV_FUNDING_STREAM,CD_EQUIV_OBJ_ALW,
CD_EQUIV_PAC,CD_EQUIV_STAGE, CD_EQUIV_STAGE_TYPE,
CD_EQUIV_SVC_DTL_SERVICE,DT_EQUIV_START_DATE,DT_EQUIV_END_DATE,NBR_EQUIV_OBJ_ALW,
NBR_EQUIV_OBJ_CERT,NBR_EQUIV_OBJ_PURE)
SELECT 0, entCode, svcCode,progCode,'ALL','ALL',
svcCode,effective,TO_DATE('12/31/4712','MM/DD/YYYY'),1,0,0 FROM DUAL
WHERE NOT EXISTS (SELECT CD_EQUIV_SVC_DTL_SERVICE FROM CAPS.EQUIVALENCY
WHERE CD_EQUIV_SVC_DTL_SERVICE = svcCode AND DT_EQUIV_END_DATE > effective);

END IF;

--If an add on line item for FC invoices the service must be in CADDONLI to prevent 
--rejection by invoice validation
IF fcAddOn = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADDONLI',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADDONLI' AND CODE = svcCode);

END IF;

--If an item to be added to delievered services invoices w/o service auth
--for either relative care or mileage, must add to CRELCODE
IF relCare = TRUE OR mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CRELCODE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CRELCODE' AND CODE = svcCode);

END IF; 


--If specifically a mileage reimbursement not requiring service authorization
--add to CMILEAGE
IF mileage = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CMILEAGE',svcCode,svcDesc FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CMILEAGE' AND CODE = svcCode);

END IF;

--If case budget limit, insert code and amount into CSBGTLMT
IF caseBudgetLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSBGTLMT',svcCode,caseBudgetLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSBGTLMT' AND CODE = svcCode);

END IF;

--If service authorization line item limit, insert code and amount into CSAMTLMT
IF svcLineItemLimit = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CSAMTLMT',svcCode,svcLineItemLimitAmt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CSAMTLMT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a foster home
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF fosterContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of contracts added on approval of a adoptive homes
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF adoptContract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CLADPT',svcCode,adoType FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CLADPT' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOSVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOSVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CADOUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CADOUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CCI contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CCIcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCISVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCISVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCCIUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCCIUTRT' AND CODE = svcCode);

END IF;

--If the service is to be a part of base CPA contracts added using the RBWO contract DF
--add service code, payment code, unit rate, and unit type to relevant codes tables
--used during the contract generation
IF CPAcontract = TRUE THEN

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPASVCD',svcCode,svcCode FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPASVCD' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTYP',svcCode,unit FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

END;

/

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (422, 'SacwisRev3', 'Release 3.0 - DBCRs 11893,11899,11909,11911,11921,11923');

commit;

