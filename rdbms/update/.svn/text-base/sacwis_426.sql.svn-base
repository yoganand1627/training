--STGAP00012088 - DBCR: add adoptive contracts for Legal risk homes

--Note:

--no impact on ado model

/
DECLARE

-- Declare variables
	   
contractID NUMBER(16);
serviceCd VARCHAR(6);
paymentCd VARCHAR(3);
unitCd VARCHAR(3);
unitRt NUMBER(6,2);
countyCd VARCHAR(3);
regionCd VARCHAR(2);
resourceId NUMBER(16);
resAddId NUMBER(16);
numberLi NUMBER(4);
defaultUser NUMBER(16);
progCd VARCHAR(3);
dtStart DATE;
varDtStart VARCHAR(10);
dtEnd DATE;
cntPlcmt NUMBER(4);
cntCtrctSvc NUMBER(2);
cntRsrcSvc NUMBER(2);
cntCntrct NUMBER(2);
cntAddr NUMBER(2);
dfName VARCHAR(20);

-- resources needing adoptive contracts

CURSOR caps_resource_cur IS SELECT id_resource FROM CAPS.Caps_resource WHERE 
CD_RSRC_CATEGORY = 'L' AND CD_RSRC_FA_HOME_STATUS IN ('AFA', 'ASA','ATA');

caps_resource_cur_rec caps_resource_cur%rowtype;


CURSOR serviceInfo IS
SELECT RTRIM(C1.DECODE), RTRIM(C2.DECODE), RTRIM(C3.DECODE), CAST(RTRIM(C4.DECODE) AS NUMBER(6,2)),
SUBSTR(C1.DECODE,1,3)
FROM CAPS.CODES_TABLES C1, CAPS.CODES_TABLES C2, CAPS.CODES_TABLES C3, CAPS.CODES_TABLES C4
WHERE C1.CODE_TYPE = 'CADOSVCD'
AND C2.CODE_TYPE = 'CADOUTYP'
AND C3.CODE_TYPE = 'CADOPTYP'
AND C4.CODE_TYPE = 'CADOUTRT'
AND C1.CODE = C2.CODE
AND C1.CODE = C3.CODE
AND C1.CODE = C4.CODE
AND C1.DT_END IS NULL
ORDER BY C1.CODE;

BEGIN

--Set to conversion user
defaultUser := 102960;
dfName := 'Adoptive Hm Cont';
--All end 2108
dtEnd := TO_DATE('07/01/2108','MM/DD/YYYY');
	   
FOR caps_resource_cur_rec IN caps_resource_cur LOOP

resourceId := caps_resource_cur_rec.id_resource;	   
varDtStart := '12/12/1912';

cntPlcmt :=0;
cntCntrct :=0;
cntAddr :=0;

--If non-default date was provided, use it
IF varDtStart <> '12/12/1912' THEN

dtStart := TO_DATE(varDtStart,'MM/DD/YYYY');

ELSE 

SELECT COUNT(ID_PLCMT_EVENT) INTO cntPlcmt FROM CAPS.PLACEMENT
WHERE ID_RSRC_FACIL = resourceId AND CD_PLCMT_TYPE = 'ADH';

--Otherwise find the earliest adoptive placement date
IF cntPlcmt >0 THEN

SELECT MIN(DT_PLCMT_START) INTO dtStart FROM CAPS.PLACEMENT
WHERE ID_RSRC_FACIL = resourceId AND CD_PLCMT_TYPE = 'ADH';

ELSE 

SELECT COUNT(DT_LIC_BEGIN) INTO cntPlcmt FROM CAPS.RESOURCE_HISTORY
WHERE ID_RESOURCE = resourceId AND CD_RSHS_CATEGORY IN ('L','A')
AND DT_LIC_BEGIN IS NOT NULL AND DT_LIC_BEGIN <> TO_DATE('12/12/1912','MM/DD/YYYY');

-- Otherwise find the earliest licensing date for adoptive or foster adopt
IF cntPlcmt >0 THEN

SELECT MIN(DT_LIC_BEGIN) INTO dtStart FROM CAPS.RESOURCE_HISTORY
WHERE ID_RESOURCE = resourceId AND CD_RSHS_CATEGORY IN ('L','A')
AND DT_LIC_BEGIN IS NOT NULL AND DT_LIC_BEGIN <> TO_DATE('12/12/1912','MM/DD/YYYY');

ELSE 

dtStart := TO_DATE('07/01/2008','MM/DD/YYYY');

END IF;

END IF;

END IF;

SELECT COUNT(ID_RSRC_ADDRESS) INTO cntAddr FROM
CAPS.RESOURCE_ADDRESS WHERE ID_RESOURCE = resourceId AND CD_RSRC_ADDR_TYPE = '01'
AND CD_RSRC_ADDR_COUNTY IS NOT NULL;

SELECT COUNT(DISTINCT ID_CONTRACT) INTO cntCntrct FROM CAPS.CONTRACT_COUNTY WHERE ID_RESOURCE = resourceId
AND CD_CNCNTY_SERVICE IN ('50807','50813','50913');


IF cntAddr > 0 AND cntCntrct < 1 THEN  

SELECT ID_RSRC_ADDRESS,CD_RSRC_ADDR_COUNTY INTO resAddId, countyCd FROM
CAPS.RESOURCE_ADDRESS WHERE ID_RESOURCE = resourceId 
AND CD_RSRC_ADDR_TYPE = '01' AND CD_RSRC_ADDR_COUNTY IS NOT NULL;
	   
SELECT RTRIM(DECODE) INTO regionCd FROM CAPS.CODES_TABLES
WHERE CODE_TYPE = 'CCNTYREG'
AND CODE = countyCd
AND DT_END IS NULL;
		   
--Get next contract ID

SELECT  CAPS.SEQ_CONTRACT.NEXTVAL INTO contractId FROM DUAL;
		   
-- Insert new contract header		   
		   
INSERT INTO CAPS.CONTRACT (ID_CONTRACT,ID_CNTRCT_WKR,ID_CNTRCT_MANAGER,ID_RESOURCE,ID_RSRC_ADDRESS,
CD_CNTRCT_FUNC_TYPE,CD_CNTRCT_PROGRAM_TYPE,CD_CNTRCT_PROCURE_TYPE,CD_CNTRCT_REGION,IND_CNTRCT_BUDG_LIMIT)
VALUES (contractId,defaultUser,defaultUser,resourceId,resAddId,'FAD','CPS','NCN',regionCd,'N'); 
		   
-- Insert new contract period (new contract, so will always be period 1)		   
		   
INSERT INTO CAPS.CONTRACT_PERIOD (ID_CONTRACT,ID_CNTRCT_WKR,NBR_CNPER_PERIOD,CD_CNPER_STATUS, 
DT_CNPER_START,DT_CNPER_TERM,DT_CNPER_CLOSURE,IND_CNPER_RENEWAL,IND_CNPER_SIGNED)
VALUES (contractId,defaultUser,1,'ACT',dtStart, dtEnd, dtEnd,'N','Y');

-- Insert new contract version (new contract, so will always be version 1)
						  
INSERT INTO CAPS.CONTRACT_VERSION(ID_CNVER,ID_CONTRACT,ID_CNTRCT_WKR,NBR_CNVER_PERIOD,NBR_CNVER_VERSION,
IND_CNVER_VER_LOCK,DT_CNVER_CREATE,DT_CNVER_EFFECTIVE,DT_CNVER_END)
VALUES (0,contractId,defaultUser,1,1,'Y',SYSDATE,dtStart,dtEnd);

-- Open adoptive service cursor to insert CONTRACT_SERVICE, RESOURCE_SERVICE, and CONTRACT_COUNTY 
						  
OPEN serviceInfo;
		   
numberLi := 1;

LOOP
		   
FETCH serviceInfo INTO serviceCd,unitCd,paymentCd,unitRt,progCd;
		   
EXIT WHEN serviceInfo%NOTFOUND;
		        
cntCtrctSvc :=0;
cntRsrcSvc :=0;

SELECT COUNT(CD_CNCNTY_SERVICE) INTO cntCtrctSvc FROM CAPS.CONTRACT_COUNTY WHERE
CD_CNCNTY_SERVICE = serviceCd AND ID_RESOURCE = resourceId AND CD_CNCNTY_COUNTY = countyCd
AND DT_CNCNTY_END > SYSDATE; 

SELECT COUNT(CD_RSRC_SVC_SERVICE) INTO cntRsrcSvc FROM CAPS.RESOURCE_SERVICE WHERE
CD_RSRC_SVC_SERVICE = serviceCd AND ID_RESOURCE = resourceId AND CD_RSRC_SVC_CNTY = countyCd; 

IF cntCtrctSvc < 1 THEN

INSERT INTO CAPS.CONTRACT_SERVICE (ID_CNSVC,ID_CONTRACT,ID_CNTRCT_WKR,NBR_CNSVC_PERIOD,
NBR_CNSVC_VERSION,NBR_CNSVC_LINE_ITEM,CD_CNSVC_SERVICE,
CD_CNSVC_PAYMENT_TYPE,IND_CNSVC_NEW_ROW,CD_CNSVC_UNIT_TYPE,NBR_CNSVC_UNIT_RATE)
VALUES (0,contractId,defaultUser,1,1,numberLi,serviceCd,paymentCd,'Y',unitCd,unitRt);
					   
INSERT INTO CAPS.CONTRACT_COUNTY (ID_CNCNTY,ID_CONTRACT,NBR_CNCNTY_PERIOD,NBR_CNCNTY_VERSION,
NBR_CNCNTY_LINE_ITEM,CD_CNCNTY_COUNTY,ID_CNTRCT_WKR,ID_RESOURCE,CD_CNCNTY_SERVICE,DT_CNCNTY_EFFECTIVE,DT_CNCNTY_END)
VALUES (0,contractId,1,1,numberLi,countyCd,defaultUser,resourceID,serviceCd,dtStart,dtEnd);

numberLi := numberLi + 1;

END IF;

IF cntRsrcSvc < 1 THEN
	
INSERT INTO CAPS.RESOURCE_SERVICE (ID_RESOURCE_SERVICE,ID_RESOURCE,IND_RSRC_SVC_SHOW_ROW,
IND_RSRC_SVC_INCOME_BSED,CD_RSRC_SVC_CATEG_RSRC,CD_RSRC_SVC_CNTY,CD_RSRC_SVC_REGION,CD_RSRC_SVC_SERVICE,
CD_RSRC_SVC_STATE,IND_RSRC_SVC_CNTY_PARTIAL,CD_RSRC_SVC_SERVICE_TYPE)
VALUES(0,resourceId,'Y','N',progCd,countyCd,regionCd,serviceCd,'GA','N','F');

END IF;		   
		   
-- Close loop for inserting services
		   
END LOOP;
		   
CLOSE serviceInfo;

--Update any adoptive placements with the newly created contract
		   
UPDATE CAPS.PLACEMENT SET ID_PLCMT_CONTRACT = contractId
WHERE ID_RSRC_FACIL = resourceId AND CD_PLCMT_TYPE = 'ADH';
		   
UPDATE CAPS.CAPS_RESOURCE SET IND_RSRC_CONTRACTED = 'Y'
WHERE ID_RESOURCE = resourceId;


END IF;

END LOOP;

END;

/



--STGAP00012138 - Insert Missing Code for Special Needs Mapping

--Note:  no impact to ado model


--Per defect STGAP00011876, the following code was unintentionally left out

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE)
VALUES ('CADOOMD', '105', 'Rheumatic Fever, Heart Disease, Heart Murmur', NULL,SYSDATE);

--STGAP00012152 - Updated required training hours for Nov and Dec

--Note:

--no impact to ado model


--Reason
---------
--This defect is needed for resolution of defect STGAP00010494

-- The required training hours for homes approved in November and December  is 10,
-- but the homes have until December 31 of the following year to complete the training.  
-- Therefore these home are not required to complete any training hours in the year 
-- they are  approved.  But  these homes are allowed to complete training hours in November 
-- and December after their approval. In these cases to avoid confusion in displaying 
-- the amount of remaining hours in the current year,  the CODES_TABLE need to set the 
-- the amount of required hours to 10 for November and December.

UPDATE CAPS.CODES_TABLES
  SET DECODE='10'
   WHERE CODE_TYPE = 'CFAYRTRN'
     AND (CODE = '11'
        OR CODE = '12');


--STGAP00012189 - Add single quote to a label in CODES_TABLES

--Note:  no impact to ado model


UPDATE caps.CODES_TABLES
SET  DECODE = 'Wednesday''s Child'
WHERE CODE_TYPE = 'CADRACS' AND CODE = 'WED';


--STGAP00012192 - Modify Label for State Funded AA (Ado Asst App)

--Note: no impact to ado model

UPDATE caps.CODES_TABLES
SET  DECODE = 'State Funded Adoption Assistance (UAS Code 508)'
WHERE CODE_TYPE = 'CAAFDTYP' AND CODE = 'PST';


--STGAP00012204 - Correct invalid characters in static tables

update caps.codes_tables set decode=replace(decode,chr(191)) where
instr(decode,chr(191)) <> 0;

update caps.message set txt_message=replace(txt_message,chr(191))
where instr(txt_message,chr(191)) <> 0;

update caps.message set txt_message_name=replace(txt_message_name,chr(191))
where instr(txt_message_name,chr(191)) <> 0;

update caps.risk_factors_lookup 
set AREA_CONCERN_TXT=replace(AREA_CONCERN_TXT,chr(191))
where instr(AREA_CONCERN_TXT,chr(191)) <> 0;

-- STGAP00012206 - new entries for stage progression
INSERT INTO CAPS.STAGE_PROG (CD_STAGE_PROG_STAGE, CD_STAGE_PROG_RSN_CLOSE, CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE, CD_STAGE_PROG_EVENT_TYPE, CD_STAGE_PROG_STATUS,
TXT_STAGE_PROG_EVNT_DESC)
VALUES ('ADO', 'VSR', 'CPS', '0', 'STG', 'COMP', 'Adoption Stage Closed');

update caps.task set IND_TASK_CODE_PREFER = 0, IND_TASK_NEW_CASE_TODO_ENABLE = 0, IND_TASK_FORCE_EVENT_LINK = 0, IND_STAGE_CLOSURE = 0 where CD_TASK in ('9071', '9075');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (427, 'SacwisRev3', 'Release 3.0 - DBCRs 12088,12138,12152,12189,12192,12204');

commit;

