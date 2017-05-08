
-- Standard Alter Table SQL

ALTER TABLE CAPS.SA_SAFETY_ASSESSMENT MODIFY(CD_OV_SF_DECISION   NULL)
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE
BEFORE INSERT
ON CAPS.STAGE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        dummy           NUMBER;
BEGIN
        :NEW.DT_LAST_UPDATE := SYSDATE;
        IF (:NEW.ID_STAGE = 0) THEN
                SELECT  SEQ_STAGE.NEXTVAL
                INTO    dummy
                FROM    DUAL;
                :NEW.ID_STAGE := dummy;
        END IF;

        ---
        ---     Mitschcg 03/10/97 SIR request #11028 from Krista Moy/Tim Overend
        ---     to add the following trigger.  On insert into stage table,
        ---     if DT_STAGE_CLOSE is max date ('12/31/4712') or is null,
        ---     then set the IND_STAGE_CLOSE to 'N' (the stage is
        ---     not closed), else set the IND_STAGE_CLOSE to 'Y' (the stage
        ---     is closed).
        ---

-- SIR#22851
        IF (:NEW.cd_stage_type IS NOT NULL AND :NEW.cd_stage_program IS NULL) THEN
        IF (:NEW.cd_stage_classification = 'LCC') THEN
            :NEW.cd_stage_program :=  'CCL';
        ELSIF (:NEW.cd_stage_classification = 'LRC') THEN
            :NEW.cd_stage_program :=  'RCL';
        ELSE
            :NEW.cd_stage_program :=  :NEW.cd_stage_classification;
        END IF;
        END IF;
-- SIR#22851


        IF ((:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/4712','MM/DD/YYYY'))
		   OR (:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/3500','MM/DD/YYYY')) 
           OR (:NEW.DT_STAGE_CLOSE IS NULL))
        THEN
           :NEW.IND_STAGE_CLOSE := 'N';
        ELSE
           :NEW.IND_STAGE_CLOSE := 'Y';
        END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 86
UPDATE caps.codes_tables SET code = 'FHV' 
WHERE code_type =  'CCNTMETH' 
AND CODE = 'FHFV';

UPDATE caps.codes_tables SET code = 'CLC' 
WHERE code_type =  'CCNTMETH' 
AND CODE = 'COL/C';

UPDATE caps.codes_tables SET code = 'COR' 
WHERE code_type =  'CCNTMETH' 
AND CODE = 'CORR';

-- change 87
UPDATE CAPS.CODES_TABLES 
SET DECODE = 'Emotional Abuse' 
WHERE CODE_TYPE = 'CABALTYP' 
AND CODE = 'EE'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE = 'Physical Abuse' 
WHERE CODE_TYPE = 'CABALTYP' 
AND CODE = 'PP'; 

UPDATE CAPS.CODES_TABLES 
SET DECODE = 'Sexual Abuse' 
WHERE CODE_TYPE = 'CABALTYP' 
AND CODE = 'SS';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (24, 'SacwisRev1', 'alter TIBR_STAGE, make CD_OV_SF_DECISION nullable, static updates');

commit;