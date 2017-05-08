
-- Alter Index SQL

CREATE INDEX CAPS.IND_STAGE_4
    ON CAPS.STAGE(CD_STAGE)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_STAGE_PERSON_LINK_6
    ON CAPS.STAGE_PERSON_LINK(CD_STAGE_PERS_ROLE)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

DROP TRIGGER CAPS.TAUR_CPRS_EVENT;
DROP TRIGGER CAPS.TAIR_CPRS_STAGE;

/
CREATE OR REPLACE TRIGGER CAPS.TUAR_CPRS_EVENT
AFTER UPDATE
ON CAPS.EVENT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  SND_FLAG VARCHAR2(1);
  xCD_COUNTY VARCHAR2(3);
  xCD_STAGE  VARCHAR2(3);
BEGIN
    -- DBMS_OUTPUT.put_line('IN TUAR_CPRS_EVENT trigger');
    SND_FLAG := 'N';
    xCD_STAGE := '   ';
    IF ( (:NEW.ID_CASE IS NOT NULL AND :NEW.ID_CASE > 0 ) 
       AND (:NEW.CD_EVENT_TYPE='CSP' OR :NEW.CD_EVENT_TYPE='PLA' OR
             (:NEW.CD_EVENT_TYPE='PLN' AND :NEW.CD_TASK='7065'))
       AND
      (
       (:NEW.CD_EVENT_STATUS='APRV' AND 
            (:OLD.CD_EVENT_STATUS IS NULL OR :OLD.CD_EVENT_STATUS <> 'APRV')
           AND(:NEW.CD_EVENT_TYPE='PLA' OR
             (:NEW.CD_EVENT_TYPE='PLN' AND :NEW.CD_TASK='7065')))
           OR (:NEW.CD_EVENT_STATUS='COMP' AND :OLD.CD_EVENT_STATUS <> 'COMP'
         AND :NEW.CD_EVENT_TYPE='CSP')))
    THEN
  -- DBMS_OUTPUT.put_line('TUAR_CPRS_EVENT - this event is interesting');
        SELECT CD_STAGE
        INTO xCD_STAGE
        FROM STAGE S
        WHERE S.ID_STAGE = :NEW.ID_EVENT_STAGE;
        IF (xCD_STAGE = 'SUB' OR xCD_STAGE = 'FSU')
        THEN
            SND_FLAG := 'Y';
        END IF;
    END IF;
    -- DBMS_OUTPUT.put_line('SND_FLAG is ' || SND_FLAG);
    IF (SND_FLAG = 'Y')
    THEN
       SELECT CD_CASE_COUNTY
       INTO   xCD_COUNTY
       FROM   CAPS_CASE C
       WHERE  C.ID_CASE = :NEW.ID_CASE;
       IF (xCD_COUNTY IS NOT NULL)
       THEN
          UPDATE_CASEPLAN (xCD_COUNTY, :NEW.ID_CASE);  
       END IF;    
    END IF;
  
    EXCEPTION
      WHEN OTHERS THEN
        -- DBMS_OUTPUT.put_line(SQLCODE);
        IF SQL%NOTFOUND THEN
      -- DBMS_OUTPUT.put_line('KABOOM - record not found');
          xCD_COUNTY := NULL;
    END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUAR_CPRS_PERSON
AFTER UPDATE
ON CAPS.PERSON
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  UPD_FLAG VARCHAR2(1);
  xCD_COUNTY VARCHAR2(3);
  v_cntr_case	NUMBER := 0;
  xID_CASE  CAPS_CASE.ID_CASE%TYPE;
  
  CURSOR c_get_child_cases IS
  	SELECT c.id_case, c.CD_CASE_COUNTY
  	 FROM STAGE_PERSON_LINK spl, STAGE s, CAPS_CASE C
  	 WHERE spl.ID_STAGE=s.ID_STAGE
  	    AND s.ID_CASE=c.ID_CASE
	    AND spl.ID_PERSON = :NEW.ID_PERSON
	    AND spl.CD_STAGE_PERS_ROLE = 'PC'
	    AND s.CD_STAGE='SUB' 
      	AND s.IND_STAGE_CLOSE='N'
      	AND C.CD_CASE_COUNTY IS NOT NULL;
  
  r_get_child_cases	c_get_child_cases%ROWTYPE;
  
BEGIN
    UPD_FLAG := 'N';
	-- DBMS_OUTPUT.put_line('IN TUAR_CPRS_PERSON');
    -- IF gender, birth date, or name changes, CPRS needs to know if this
    -- is a child in care
    IF ( (:NEW.CD_PERSON_SEX IS NOT NULL AND (:OLD.CD_PERSON_SEX IS NULL OR
         :NEW.CD_PERSON_SEX <> :OLD.CD_PERSON_SEX)) OR
         (:NEW.DT_PERSON_BIRTH IS NOT NULL AND (:OLD.DT_PERSON_BIRTH IS NULL OR
         :NEW.DT_PERSON_BIRTH <> :OLD.DT_PERSON_BIRTH)) OR
         (:NEW.NM_PERSON_FIRST IS NOT NULL AND (:OLD.NM_PERSON_FIRST IS NULL OR
         :NEW.NM_PERSON_FIRST <> :OLD.NM_PERSON_FIRST)) OR
         (:NEW.NM_PERSON_MIDDLE IS NOT NULL AND (:OLD.NM_PERSON_MIDDLE IS NULL OR
         :NEW.NM_PERSON_MIDDLE <> :OLD.NM_PERSON_MIDDLE)) OR
         (:NEW.NM_PERSON_LAST IS NOT NULL AND (:OLD.NM_PERSON_LAST IS NULL OR
         :NEW.NM_PERSON_LAST <> :OLD.NM_PERSON_LAST)) )
    THEN
	  -- DBMS_OUTPUT.put_line('IN TUAR_CPRS_PERSON - Data Changed');
      SELECT COUNT(*)
      	  INTO v_cntr_case
      	  FROM STAGE_PERSON_LINK spl, STAGE s
      	  WHERE spl.ID_STAGE=s.ID_STAGE
      	  AND spl.ID_PERSON = :NEW.ID_PERSON
      	  AND spl.CD_STAGE_PERS_ROLE = 'PC'
      	  AND s.CD_STAGE='SUB' 
      	  AND s.IND_STAGE_CLOSE='N';
	  -- DBMS_OUTPUT.put_line('IN TUAR_CPRS_PERSON - found in cases '||v_cntr_case);	  
      IF v_cntr_case > 0
      THEN
         UPD_FLAG := 'Y';
      END IF;
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
       OPEN c_get_child_cases;
       LOOP
  	  FETCH c_get_child_cases INTO r_get_child_cases;
  	  EXIT WHEN c_get_child_cases%NOTFOUND;
  	  UPDATE_CASEPLAN (r_get_child_cases.CD_CASE_COUNTY, r_get_child_cases.ID_CASE);
       END LOOP;
       CLOSE c_get_child_cases;
    END IF;
	
    EXCEPTION
    	WHEN OTHERS THEN
		DBMS_OUTPUT.put_line('IN TUAR_CPRS_PERSON, SQLCODE: '||SQLCODE);
    		IF SQL%NOTFOUND THEN
    			xCD_COUNTY := NULL;
		END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIAR_CPRS_STAGE
AFTER INSERT
ON CAPS.STAGE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  UPD_FLAG VARCHAR2(1);
  xCD_COUNTY VARCHAR2(3);
BEGIN
    UPD_FLAG := 'N';
    IF (:NEW.CD_STAGE='SUB' AND :NEW.IND_STAGE_CLOSE='N')
    THEN
      UPD_FLAG := 'Y';
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
     SELECT CD_CASE_COUNTY
       INTO   xCD_COUNTY
       FROM   CAPS_CASE C
       WHERE  C.ID_CASE = :NEW.ID_CASE;
       IF (xCD_COUNTY IS NOT NULL)
       THEN
          UPDATE_CASEPLAN (xCD_COUNTY, :NEW.ID_CASE);  
       END IF;     
    END IF;
  
    EXCEPTION
      WHEN OTHERS THEN
        -- DBMS_OUTPUT.put_line(SQLCODE);
        IF SQL%NOTFOUND THEN
          xCD_COUNTY := NULL;
    END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003106
UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_STATUS = 'COMP'
WHERE CD_STAGE_PROG_STAGE = 'DIV'
AND CD_STAGE_PROG_RSN_CLOSE = 'DIV'
AND CD_STAGE_PROG_OPEN = 'DIV'
AND CD_STAGE_PROG_EVENT_TYPE = 'STG';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'ADF'
WHERE
CD_STAGE_PROG_STAGE = 'ADO'
AND
CD_STAGE_PROG_RSN_CLOSE = '010';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'ADI'
WHERE
CD_STAGE_PROG_STAGE = 'ADO'
AND
CD_STAGE_PROG_RSN_CLOSE = '020';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CDE'
WHERE
CD_STAGE_PROG_STAGE = 'ADO'
AND
CD_STAGE_PROG_RSN_CLOSE = '050';

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'ADO','RUN','CPS',0,'STG','COMP','Adoption Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'ADO','APD','CPS',0,'STG','COMP','Adoption Stage Closed');

DELETE FROM CAPS.STAGE_PROG
WHERE
CD_STAGE_PROG_STAGE = 'ADO'
AND
CD_STAGE_PROG_RSN_CLOSE IN ('10','20','30','030','02','040');

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'OA', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '05'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'ARR', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '07'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'NLN', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '15'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'NLT', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '20'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RTC', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '26'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RPC', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '31'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RGU', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '35'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'NLA', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '40'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'FCO', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '46'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'UTL', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '49'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'COO', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '85'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'XXX', TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Closed'
WHERE
CD_STAGE_PROG_STAGE = 'FPR'
AND
CD_STAGE_PROG_RSN_CLOSE = '90'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'Foster Care Family Stage Opened'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Family Subcare Stage Opened';

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'Foster Care Family Stage Closed'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Family Subcare Stage Closed';

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'CPS Ongoing Stage Opened'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Family Preservation Stage Opened';

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'Post Foster Care Stage Opened'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Post Family Care Stage Opened';

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'Foster Care Child Stage Opened'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Subcare Stage Opened';

UPDATE CAPS.STAGE_PROG
SET TXT_STAGE_PROG_EVNT_DESC = 'Foster Care Child Stage Closed'
WHERE TXT_STAGE_PROG_EVNT_DESC = 'Subcare Stage Closed';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'REU'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '10'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'EMA'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '20'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RTC'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '30'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RPC'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '010'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RGU'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '020'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'TAA'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '030'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'LG'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '040'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RUN'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '050'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CD'
WHERE
CD_STAGE_PROG_STAGE = 'FSU'
AND
CD_STAGE_PROG_RSN_CLOSE = '060'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'FSU','ACA','CPS',0,'STG','COMP','Foster Care Family Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'FSU','CPS','CPS',0,'STG','COMP','Foster Care Family Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'FSU','COO','CPS',0,'STG','COMP','Foster Care Family Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'FSU','UTL','CPS',0,'STG','COMP','Foster Care Family Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'FSU','OOS','CPS',0,'STG','COMP','Foster Care Family Stage Closed');

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'REU'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '10'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'C18'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '20'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'EMA'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '30'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'TAA'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '010'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RTC'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '020'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RPC'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '030'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RGU'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '040'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'LG'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '050'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'RUN'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '060'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CD'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '070'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'ADO'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '080'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CPS'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '090'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'PFC'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = '100'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'AD'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = '20'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'ECP'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = '30'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CNE'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = '010'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'CD'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = '020'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_RSN_CLOSE = 'PD'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = '030'
AND
IND_STAGE_PROG_CLOSE = '0'
AND
CD_STAGE_PROG_OPEN IS NULL;

DELETE FROM CAPS.STAGE_PROG
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE IN ('040','050','060','070','080');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'PFC','SND','CPS',0,'STG','COMP','Post Foster Care Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'PFC','CD','CPS',0,'STG','COMP','Post Foster Care Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'PFC','RUN','CPS',0,'STG','COMP','Post Foster Care Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'PFC','STA','CPS',0,'STG','COMP','Post Foster Care Stage Closed');

INSERT INTO CAPS.STAGE_PROG
(ID_STAGE_PROG,DT_LAST_UPDATE,CD_STAGE_PROG_STAGE,CD_STAGE_PROG_RSN_CLOSE,CD_STAGE_PROG_PROGRAM,
IND_STAGE_PROG_CLOSE,CD_STAGE_PROG_EVENT_TYPE,CD_STAGE_PROG_STATUS,TXT_STAGE_PROG_EVNT_DESC)
VALUES
(0,SYSDATE,'PFC','MAS','CPS',0,'STG','COMP','Post Foster Care Stage Closed');

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_STATUS = 'COMP'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = 'IC'
AND
IND_STAGE_PROG_CLOSE = '1'
AND
CD_STAGE_PROG_OPEN = 'SUB';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_STATUS = 'COMP'
WHERE
CD_STAGE_PROG_STAGE = 'PAD'
AND
CD_STAGE_PROG_RSN_CLOSE = 'PA'
AND
IND_STAGE_PROG_CLOSE = '1'
AND
CD_STAGE_PROG_OPEN = 'PAD';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_STATUS = 'COMP'
WHERE
CD_STAGE_PROG_STAGE = 'PFC'
AND
CD_STAGE_PROG_RSN_CLOSE = 'PF'
AND
IND_STAGE_PROG_CLOSE = '1'
AND
CD_STAGE_PROG_OPEN = 'PFC';

UPDATE CAPS.STAGE_PROG
SET CD_STAGE_PROG_STATUS = 'COMP'
WHERE
CD_STAGE_PROG_STAGE = 'SUB'
AND
CD_STAGE_PROG_RSN_CLOSE = 'NI'
AND
IND_STAGE_PROG_CLOSE = '1'
AND
CD_STAGE_PROG_OPEN = 'SUB';

-- change STGAP00003118
UPDATE CAPS.CODES_TABLES
SET
CODE = 'CCI', DT_LAST_UPDATE = SYSDATE
WHERE
CODE_TYPE = 'CPLCMTRU'
AND 
CODE = 'CCL';

-- change STGAP00003142
UPDATE CAPS.TASK SET txt_task_decode = 'Approve Child Life History'
WHERE txt_task_decode = 'Approve HSEGH';

-- change STGAP00003144
update CAPS.TASK
SET CD_TASK_EVENT_STATUS = 'APRV',
CD_TASK_LIST_WINDOW = 'CCMN51W',
CD_TASK_TOP_WINDOW='CSUB01C',
IND_TASK_DETAIL_ENABLE=0,
IND_TASK_EVENT_CREATE=0,
IND_TASK_EVENT_NAVIG=0,
IND_TASK_LIST_ENABLE=1,
IND_TASK_NEW_ENABLE=0,
IND_TASK_NU_ACROSS_CASE=1,
IND_TASK_TODO_ENABLE=0,
IND_TASK_NEW_CASE_TODO_ENABLE=0,
IND_TASK_NEW_USING=0
where cd_task in (2315,7110,8535,4195,9030,2010,3025);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (185, 'SacwisRev2', 'static updates, CPRS triggers, two new indexes');

commit;

