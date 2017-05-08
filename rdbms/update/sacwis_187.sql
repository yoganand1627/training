-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIAR_CPRS_PLAN_GOAL
AFTER INSERT
ON CAPS.PLAN_GOAL
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  UPD_FLAG VARCHAR2(1);
  xCD_EVENT_STATUS EVENT.CD_EVENT_STATUS%TYPE;
  xCD_COUNTY VARCHAR2(3);
  xID_CASE CAPS_CASE.ID_CASE%TYPE;
BEGIN
    -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_PLAN_GOAL');
    UPD_FLAG := 'N';
    -- IF this IS a Reunification OR Non-reunification goal, download TO CPRS
    IF (:NEW.CD_GOAL_TYP IS NOT NULL AND
        (:NEW.CD_GOAL_TYP = 'REU' OR :NEW.CD_GOAL_TYP='NRE'))
    THEN
       UPD_FLAG := 'Y';
       -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_PLAN_GOAL - INSERT HAS DATA PRESENT');
       SELECT CD_EVENT_STATUS, ID_CASE
       INTO xCD_EVENT_STATUS, xID_CASE
       FROM EVENT
       WHERE ID_EVENT = :NEW.ID_EVENT;
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
	   -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_PLAN_GOAL - Update CPRS is a go. Case is ' || xID_CASE);
    	   SELECT CD_CASE_COUNTY
           INTO   xCD_COUNTY
           FROM   CAPS_CASE C
           WHERE  C.ID_CASE = xID_CASE;
           IF (xCD_COUNTY IS NOT NULL)
           THEN
              UPDATE_CASEPLAN (xCD_COUNTY, xID_CASE);  
           END IF;     
    END IF;
    
    EXCEPTION
    	WHEN OTHERS THEN
		DBMS_OUTPUT.put_line('IN TIAR_CPRS_PLAN_GOAL, SQLCODE: '||SQLCODE);
    	IF SQL%NOTFOUND THEN
    			xCD_COUNTY := NULL;
		END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIAR_CPRS_STAGE_PERS_LINK
AFTER INSERT OR UPDATE
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  DATA_PRESENT VARCHAR2(1);
  UPD_FLAG VARCHAR2(1);
  xCD_EVENT_STATUS EVENT.CD_EVENT_STATUS%TYPE;
  xCD_COUNTY VARCHAR2(3);
  xCD_STAGE STAGE.CD_STAGE%TYPE;
BEGIN
    -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_STAGE_PERS_LINK');
    UPD_FLAG := 'N';
    DATA_PRESENT := 'N';
    IF (:NEW.CD_STAGE_PERS_ROLE IS NOT NULL)
    THEN
	   SELECT CD_STAGE
	   INTO xCD_STAGE
	   FROM STAGE
	   WHERE ID_STAGE = :NEW.ID_STAGE;
	   IF (xCD_STAGE='SUB' OR xCD_STAGE='FSU')
	   THEN
          DATA_PRESENT := 'Y';
         -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_STAGE_PERS_LINK - DATA PRESENT');
	   END IF;
    END IF;
    IF (INSERTING AND DATA_PRESENT='Y') 
    THEN
      -- For now, we only care about the Primary Case Manager
      IF (:NEW.CD_STAGE_PERS_ROLE='PR')
      THEN
         UPD_FLAG := 'Y';
      END IF;
    ELSIF (UPDATING AND DATA_PRESENT='Y') 
	THEN
      IF (:NEW.CD_STAGE_PERS_ROLE='PR' AND (:OLD.CD_STAGE_PERS_ROLE IS NULL OR
            :NEW.CD_STAGE_PERS_ROLE <> :OLD.CD_STAGE_PERS_ROLE))
      THEN
             UPD_FLAG := 'Y';
      END IF;
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
	   -- DBMS_OUTPUT.put_line('IN TIAR_CPRS_STAGE_PERS_LINK - Update CPRS is a go. Case is ' || :NEW.ID_CASE);
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
		DBMS_OUTPUT.put_line('IN TIAR_CPRS_STAGE_PERS_LINK, SQLCODE: '||SQLCODE);
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

-- change STGAP00003251
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPRGCOD1','252','252 - Restricted Funds',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPRGCOD1','253','253 - Donated Restricted Funds',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPRGCOD1','450','450 - County Funds under 14',SYSDATE);
INSERT INTO caps.codes_tables (code_type, code, DECODE,dt_last_update) VALUES('CPRGCOD1','460','460 - County Funds over 14',SYSDATE);

-- change STGAP00003266
UPDATE caps.codes_tables
SET DECODE = 'Manage Service Contracts'
WHERE code = 'CA'
AND code_type = 'CSECATTR';

UPDATE caps.codes_tables
SET DECODE = 'Manage Facility Contracts'
WHERE code = 'CB'
AND code_type = 'CSECATTR';

UPDATE caps.codes_tables
SET DECODE = 'Manage F/A Home Contracts'
WHERE code = 'EJ'
AND code_type = 'CSECATTR';

UPDATE caps.CODES_TABLES
SET dt_end=NULL,
DECODE='FAD Worker'
WHERE code_type='CSECATTR' AND code='PB';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (188, 'SacwisRev2', 'static updates, CPRS triggers'); 

commit;
