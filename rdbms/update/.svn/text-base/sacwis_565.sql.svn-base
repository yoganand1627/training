--STGAP00015496  New Service code -5 1863
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

svcCode := '51863';	
svcDesc := '51863 - Integrated Famity Supp Serv - CCFA W';	
progCode := '518';	
entCode := '63';	
newProg := FALSE;	
newEnt := FALSE;	
progDesc := '';	
entDesc := '';	
sa := TRUE;	
pssf := FALSE;	
effective := TO_DATE('09/01/2008','MM/DD/YYYY');	
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
unit := '';	
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


END IF;
END IF;

END;

/



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (566, 'SacwisRev3', 'Release 3.3 - DBCR 15496');

commit;


