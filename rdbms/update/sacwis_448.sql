--STGAP00013021 - MR-026: New claim code and error message for TCM

--Note:  no impact on ado model


insert into caps.codes_tables values ('CTCMSTAT', 'NRB', 'Non Re-billable', null, sysdate);

insert into caps.message values (0, sysdate, 99321, 'MSG_TCM_MULTPL_CBX_VAL','Please select only one option - Resubmit or Non Re-billable.', '600', '740', 'N');



--STGAP00013037 - Update SHINES Financial Service Codes to Match COS

--Note: no impact ado model


--This SQL updates service codes to correct mismatches between SHINES and COSTAR.

--Service 25202

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '25202';
svcDesc := '25202 - Restricted Funds Children Add-On';
progCode := '252';
entCode := '02';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'DA2';
pay := 'URT';
amt := '1.75';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 25299

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '25299';
svcDesc := '25299 - Restricted Funds Children Waiver';
progCode := '252';
entCode := '99';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'DA2';
pay := 'URT';
amt := '1000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 45051

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '45051';
svcDesc := '45051 - County Paid Drug Screens ';
progCode := '450';
entCode := '51';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 45090

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '45090';
svcDesc := '45090 - Other School Expenses- Kids Under 14';
progCode := '450';
entCode := '90';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 45099

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '45099';
svcDesc := '45099 - Travel Rel Meals - Kids Under 14';
progCode := '450';
entCode := '99';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '100';


missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 46090

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '46090';
svcDesc := '46090 - Other School Expense - Kids 14 and Up';
progCode := '460';
entCode := '90';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 46099

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '46099';
svcDesc := '46099 - Travel Rel Meals - Kids 14 and Up';
progCode := '460';
entCode := '99';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '100';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50300

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50300';
svcDesc := '50300 - Other';
progCode := '503';
entCode := '00';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

-- Service 50308

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50308';
svcDesc := '50308 - In-Hospital Care';
progCode := '503';
entCode := '08';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'XXX';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50310a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50310a';
svcDesc := '50310a - Unusual Medical';
progCode := '503';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50310b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50310b';
svcDesc := '50310b - Unusual Dental';
progCode := '503';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50310c

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50310c';
svcDesc := '50310c - ICPC Interstate Travel';
progCode := '503';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50310d

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50310d';
svcDesc := '50310d - Burial Cost';
progCode := '503';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 50311

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '50311';
svcDesc := '50311 - Child Restraint Device ';
progCode := '503';
entCode := '11';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '500';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 51567

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51567';
svcDesc := '51567 - IMPACT Pre-Service Curriculum';
progCode := '515';
entCode := '67';
newProg := TRUE;
newEnt := FALSE;
progDesc := '515 - ICPC Foster and Adoptive Home Study';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('01/03/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 51570a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51570a';
svcDesc := '51570a - Home Study';
progCode := '515';
entCode := '70';
newProg := FALSE;
newEnt := TRUE;
progDesc := '515 - ICPC Foster and Adoptive Home Study';
entDesc := '70 - Home Study';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('01/03/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

-- 51570b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '51570b';
svcDesc := '51570b - Conversion of FH Study to Adoptive Study ';
progCode := '515';
entCode := '70';
newProg := FALSE;
newEnt := FALSE;
progDesc := '515 - ICPC Foster and Adoptive Home Study';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('01/03/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 55099

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '55099';
svcDesc := '55099 - Waiver';
progCode := '550';
entCode := '99';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := TRUE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

-- Service 55299

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '55299';
svcDesc := '55299 - Waiver';
progCode := '552';
entCode := '99';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2008','MM/DD/YYYY');
relCare := TRUE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

-- Service 57900

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '57900';
svcDesc := '57900 - Other';
progCode := '579';
entCode := '00';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 57910a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '57910a';
svcDesc := '57910a - Unusual Medical';
progCode := '579';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 57910b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '57910b';
svcDesc := '57910b - Unusual Dental';
progCode := '579';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 57910c

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '57910c';
svcDesc := '57910c - ICPC Interstate Travel';
progCode := '579';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 57910d

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '57910d';
svcDesc := '57910d - Burial Cost';
progCode := '579';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := TRUE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61210a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61210a';
svcDesc := '61210a - Unusual Medical';
progCode := '612';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

-- Service 61210b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61210b';
svcDesc := '61210b - Unusual Dental';
progCode := '612';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61210c

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61210c';
svcDesc := '61210c - ICPC Interstate Travel';
progCode := '612';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61210d

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61210d';
svcDesc := '61210d - Burial Cost';
progCode := '612';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := TRUE;
CPAcontract := FALSE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61310a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61310a';
svcDesc := '61310a - Unusual Medical';
progCode := '613';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61310b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61310b';
svcDesc := '61310b - Unusual Dental';
progCode := '613';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61310c

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61310c';
svcDesc := '61310c - ICPC Interstate Travel';
progCode := '613';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61310d

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61310d';
svcDesc := '61310d - Burial Cost';
progCode := '613';
entCode := '10';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('07/01/2007','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := TRUE;
adoType := '';
UNIT := 'ONE';
pay := 'VUR';
amt := '5000';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61700

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61700';
svcDesc := '61700 - Other';
progCode := '617';
entCode := '00';
newProg := TRUE;
newEnt := FALSE;
progDesc := '617 - Community Intergration State - State Funded';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61701a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61701a';
svcDesc := '61701a - Per Diem ';
progCode := '617';
entCode := '01';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61701b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61701b';
svcDesc := '61701b - Per Diem ';
progCode := '617';
entCode := '01';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61706

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61706';
svcDesc := '61706 - Support Services - Goods for Services';
progCode := '617';
entCode := '06';
newProg := FALSE;
newEnt := FALSE;
progDesc := '617 - Community Intergration State - State Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61771

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61771';
svcDesc := '61771 - Case Management Services';
progCode := '617';
entCode := '71';
newProg := FALSE;
newEnt := FALSE;
progDesc := '617 - Community Intergration State - State Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61774

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61774';
svcDesc := '61774 - Diversion Services';
progCode := '617';
entCode := '74';
newProg := FALSE;
newEnt := FALSE;
progDesc := '617 - Community Intergration State - State Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61778

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61778';
svcDesc := '61778 - Start-up Cost';
progCode := '617';
entCode := '78';
newProg := FALSE;
newEnt := FALSE;
progDesc := '617 - Community Intergration State - State Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61800

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61800';
svcDesc := '61800 - Other';
progCode := '618';
entCode := '00';
newProg := TRUE;
newEnt := FALSE;
progDesc := '618 - Community Intergration State - TANF Funded';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := TRUE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61801a

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61801a';
svcDesc := '61801a - Per Diem ';
progCode := '618';
entCode := '01';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61801b

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61801b';
svcDesc := '61801b - Per Diem ';
progCode := '618';
entCode := '01';
newProg := FALSE;
newEnt := FALSE;
progDesc := '';
entDesc := '';
sa := FALSE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61806

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61806';
svcDesc := '61806 - Support Services - Goods for Services';
progCode := '618';
entCode := '06';
newProg := FALSE;
newEnt := FALSE;
progDesc := '618 - Community Intergration State - TANF Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61871

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61871';
svcDesc := '61871 - Case Management Services  ';
progCode := '618';
entCode := '71';
newProg := FALSE;
newEnt := FALSE;
progDesc := '618 - Community Intergration State - TANF Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61874

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61874';
svcDesc := '61874 - Diversion Services';
progCode := '618';
entCode := '74';
newProg := FALSE;
newEnt := FALSE;
progDesc := '618 - Community Intergration State - TANF Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Service 61878

-- Add extra slash for java dbcr script
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
UNIT VARCHAR(3);
pay VARCHAR(3);
amt VARCHAR(7);

missingData BOOLEAN;

df BOOLEAN;
dfName VARCHAR(20);

BEGIN

svcCode := '61878';
svcDesc := '61878 - Start-up Cost';
progCode := '618';
entCode := '78';
newProg := FALSE;
newEnt := FALSE;
progDesc := '618 - Community Intergration State - TANF Funded';
entDesc := '';
sa := TRUE;
pssf := FALSE;
effective := TO_DATE('04/01/2008','MM/DD/YYYY');
relCare := FALSE;
fcAddOn := FALSE;
mileage := FALSE;
caseBudgetLimit := FALSE;
svcLineItemLimit := FALSE;
caseBudgetLimitAmt := '';
svcLineItemLimitAmt := '';
fosterContract := FALSE;
adoptContract := FALSE;
CCIcontract := FALSE;
CPAcontract := FALSE;
adoType := '';
UNIT := '';
pay := '';
amt := '';

missingData := FALSE;
df := FALSE;
dfName := '';
 
IF (svcDesc IS NULL) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service code description');

END IF;
END IF; 

IF ((newProg = TRUE) AND (progDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing program description');

END IF;

END IF; 

IF ((newEnt = TRUE) AND (entDesc IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing entitlement description');

END IF;

END IF; 

IF ((caseBudgetLimit = TRUE) AND (caseBudgetLimitAmt IS NULL)) THEN
IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing case budget limit information');

END IF;
END IF;

IF ((svcLineItemLimit = TRUE) AND (svcLineItemLimitAmt IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing service line item limit information');

END IF;
END IF;

IF ((fosterContract = TRUE) OR (adoptContract = TRUE) OR (CCIcontract = TRUE) OR (CPAcontract = TRUE)) AND ((UNIT IS NULL) OR (amt IS NULL) OR (pay IS NULL)) THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing default contract information');

END IF;
END IF;

IF adoptContract = TRUE AND adoType IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing adoption contract subsidy type information');

END IF;
END IF;

IF df = TRUE AND dfName IS NULL THEN

IF missingData <> TRUE THEN

missingData := TRUE;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Missing data on service code insert');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);

END IF;
END IF;

IF df = TRUE THEN

DBMS_OUTPUT.PUT_LINE('Missing data fix name');

END IF;
END IF;

--If datafix, print out validation results.  Reocmmended this be done for DBCR's as well during local testing

IF ((df = TRUE) AND (missingData = TRUE)) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

END IF;

--If no information is missing, create the service by updating all required codes tables and static tables

IF (missingData = FALSE) THEN

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
'CFOSUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CADOUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCCIUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
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
'CCPAUTYP',svcCode,UNIT FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAPTYP',svcCode,pay FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAPTYP' AND CODE = svcCode);

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CCPAUTRT',svcCode,amt FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CCPAUTRT' AND CODE = svcCode);

END IF;

--If datafix, complete scripting and insert row into data fix audit table
IF (df = TRUE) THEN

DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');  
DBMS_OUTPUT.PUT_LINE('Service code insert complete');
DBMS_OUTPUT.PUT_LINE('Service '||svcCode);
DBMS_OUTPUT.PUT_LINE(' -----------------------------------------------------------------------');

INSERT INTO caps.DATAFIX_AUDIT_TABLE(id_datafix,script_name,logfile_name,id_defect_cq,error_category,datafix_desc,dt_start,dt_completed) 
VALUES(0,DFNAME||'.sql',DFNAME||'.log',DFNAME,'N/A','Added service code '||svcCode, SYSDATE,SYSDATE);

END IF;
END IF;

END;

/

--Remove end date equivalency for previously existing codes
UPDATE CAPS.EQUIVALENCY SET DT_EQUIV_END_DATE = TO_DATE('12/31/4712','MM/DD/YYYY') 
WHERE CD_EQUIV_SVC_DTL_SERVICE IN ('45099','46099','50308','50310a','50310b','50310a','50310c','50310d','50311');

--Remove end date codes tables for previouslly existing codes
UPDATE CAPS.CODES_TABLES SET DT_END = NULL WHERE CODE IN 
('45099','46099','50308','50310a','50310b','50310a','50310c','50310d','50311');

--Update any changed values for foster care contracts

UPDATE CAPS.CODES_TABLES SET DECODE = 'XXX' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50308';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50308';
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50308';

UPDATE CAPS.CODES_TABLES SET DECODE = 'ONE' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50310a';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50310a';
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50310a';

UPDATE CAPS.CODES_TABLES SET DECODE = 'ONE' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50310b';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50310b';
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50310b';

UPDATE CAPS.CODES_TABLES SET DECODE = 'ONE' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50310c';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50310c';
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50310c';

UPDATE CAPS.CODES_TABLES SET DECODE = 'ONE' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50310d';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50310d';
UPDATE CAPS.CODES_TABLES SET DECODE = '5000' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50310d';

UPDATE CAPS.CODES_TABLES SET DECODE = 'ONE' WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '50311';
UPDATE CAPS.CODES_TABLES SET DECODE = 'VUR' WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '50311';
UPDATE CAPS.CODES_TABLES SET DECODE = '500' WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '50311';

--Correct description for 51248g

UPDATE CAPS.CODES_TABLES SET DECODE = '51248g - PUP Other' WHERE
CODE_TYPE = 'CSVCCODE' AND CODE = '52148g';

--Update descriptions for renewed codes

UPDATE CAPS.CODES_TABLES SET DECODE = '45099 - Travel Rel Meals - Children Under 14' WHERE
CODE_TYPE = 'CSVCCODE' AND CODE = '45099';

UPDATE CAPS.CODES_TABLES SET DECODE = '46099 - Travel Rel Meals - Children 14 and Up' WHERE
CODE_TYPE = 'CSVCCODE' AND CODE = '46099';

--Ensure 52200 is visible

UPDATE CAPS.CODES_TABLES SET DT_END = NULL WHERE CODE = '522' AND CODE_TYPE = 'CPRGCOD1';

--True up remaining foster care contract items

--51880

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','51880','51880' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '51880');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','51880','ONE' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '51880');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','51880','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '51880');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','51880','250' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '51880');

--53106a

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106a','53106a' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106a','STU' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106a','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106a','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106a');

--53106b

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106b','53106b' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106b','STU' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106b','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106b','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106b');

--53106c

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106c','53106c' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106c','STU' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106c','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106c','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106c');

--53106d

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106d','53106d' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106d');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106d','STU' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106d');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106d','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106d');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106d','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106d');

--53106e

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106e','53106e' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106e');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106e','STU' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106e');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106e','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106e');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106e','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106e');

--53106f

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106f','53106f' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106f');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106f','ONE' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106f');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106f','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106f');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106f','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106f');

--53106g

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53106g','53106g' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53106g');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53106g','ONE' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53106g');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53106g','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53106g');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53106g','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53106g');

--53167

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53167','53167' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53167');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53167','XXX' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53167');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53167','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53167');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53167','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53167');

--53168a

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53168a','53168a' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53168a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53168a','XXX' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53168a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53168a','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53168a');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53168a','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53168a');

--53168b

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53168b','53168b' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53168b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53168b','XXX' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53168b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53168b','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53168b');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53168b','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53168b');

--53168c

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSSVCD','53168c','53168c' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSSVCD' AND CODE = '53168c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTYP','53168c','ONE' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTYP' AND CODE = '53168c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSPTYP','53168c','VUR' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSPTYP' AND CODE = '53168c');

INSERT INTO CAPS.CODES_TABLES(CODE_TYPE,CODE,DECODE) SELECT
'CFOSUTRT','53168c','1000' FROM DUAL WHERE NOT EXISTS (SELECT 
CODE FROM CAPS.CODES_TABLES WHERE CODE_TYPE = 'CFOSUTRT' AND CODE = '53168c');

--End date codes as requested by Karen Hardy

UPDATE CAPS.EQUIVALENCY SET DT_EQUIV_END_DATE = TO_DATE('03/31/2009','MM/DD/YYYY') 
WHERE CD_EQUIV_SVC_DTL_SERVICE IN ('25300','46004');

UPDATE CAPS.EQUIVALENCY SET DT_EQUIV_END_DATE = TO_DATE('09/01/2007','MM/DD/YYYY') 
WHERE CD_EQUIV_SVC_DTL_SERVICE = '616SB';

UPDATE CAPS.CODES_TABLES SET DT_END = TO_DATE('03/31/2009','MM/DD/YYYY') WHERE 
CODE IN ('25300','46004') AND CODE_TYPE NOT IN ('CSVCCODE','CFLSVLNK');

UPDATE CAPS.CODES_TABLES SET DT_END = TO_DATE('09/01/2007','MM/DD/YYYY') WHERE 
CODE IN ('616SB') AND CODE_TYPE NOT IN ('CSVCCODE','CFLSVLNK');



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (449, 'SacwisRev3', 'Release 3.1 - DBCRs 13021,13037');

commit;


