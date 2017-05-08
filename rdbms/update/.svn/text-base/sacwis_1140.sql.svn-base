--STGAP00017260 - Release(5.0) ECEM 5.0: updated triggers for program code mtnt                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                                            
-- 10132011: update relate to service auth header
-- TIBR_UAS_ENT_CODE_MTNT: added insert to CENTCODE if header checked, if the record is not already in there, no case sensitive because CodesTables.java is not, for code
--                         added condition to only insert to CSVCCODE, CFLSVLNK is it is NOT a header row
-- TUBR_UAS_ENT_CODE_MTNT: added update to SVC_AUTH_UAS_ENT_CODE if header checked and uas program code or ent code changed
--                         added delete CENTCODE, CSVCCODE, CFLSVLNK if an actual service row is made into header row 
--                         added update to code and decode to other related codes tables when service code changed
--                         removed unused var declare
-- TIBR_UAS_PROGRAM_CODE_MTNT: added insert to CPRGCOD1 if SA checked
--                             removed unused var declare
-- TUBR_UAS_PROGRAM_CODE_MTNT: added comment that it will update the SA related codes tables regardless, if not found, nothing happens 
--                             removed uppper because cd_uas is number
--                             added delete CPRGCOD1 if sa is not checked and it was checked
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_ENT_CODE_MTNT
-- KEEP THIS COMMENT IN THE TRIGGER CODE: REVIEW UAS PROGRAM CODE MAINTENANCE DESIGN WHEN UDPATE THIS TRIGGER TO AVOID POSSIBLE CIRCULAR TRIGGER.
BEFORE INSERT
ON CAPS.UAS_ENT_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
   zCdSvcCode VARCHAR2(3);
   zTxtSvcDesc VARCHAR2(370);
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_UAS_ENT_CODE_MTNT=0 then
      SELECT CAPS.SEQ_UAS_ENT_CODE_MTNT.NEXTVAL INTO dummy  FROM DUAL;
      :NEW.ID_UAS_ENT_CODE_MTNT := dummy;
  end if;
  -- IF THIS IS NOT AN ACTUAL SVC CODE BUT A HEADER CODE, 
  IF (:NEW.IND_ENT_HEADER = 'Y') THEN
    -- ENTER INTO THE CENTCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CENTCODE', :NEW.CD_ENT_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from codes_tables where upper(code) = upper(:new.cd_ent_code) and code_type = 'CENTCODE');    
  ELSE
    -- INSERT INTO CSCVCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CSCVCODE', :NEW.CD_SVC_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE FROM DUAL
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CSCVCODE');
    -- INSERT INTO CFLSVLNK
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CFLSVLNK', :NEW.CD_SVC_CODE, substr(:NEW.CD_SVC_CODE,1,3), NULL, SYSDATE FROM DUAL 
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CFLSVLNK');
  END IF;  
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_ENT_CODE_MTNT
-- KEEP THIS COMMENT IN THE TRIGGER CODE: REVIEW UAS PROGRAM CODE MAINTENANCE DESIGN WHEN UDPATE THIS TRIGGER TO AVOID POSSIBLE CIRCULAR TRIGGER.
BEFORE UPDATE
ON CAPS.UAS_ENT_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  -- IF SCV DESC IS UPDATED, 
  IF (:old.TXT_ENT_DESC <> :new.TXT_ENT_DESC) THEN
  -- UPDATE DESC ON THE MASTER SVC CODES TABLES
      UPDATE CAPS.CODES_TABLES
      SET DECODE = :NEW.TXT_ENT_DESC
      WHERE CODE_TYPE IN ('CSVCCODE','CMILEAGE','CRELCODE','CADDONLI') 
      AND CODE = :OLD.CD_SVC_CODE;
    -- COMPARE TO OLD.CD_ENT_CODE BECAUSE USER CAN CHANGE CODE  
    IF (:NEW.IND_ENT_HEADER = 'Y') THEN
      UPDATE CAPS.CODES_TABLES
      SET DECODE = :NEW.TXT_ENT_DESC
      WHERE CODE_TYPE = 'CENTCODE' AND CODE = :OLD.CD_ENT_CODE;
    END IF;
  END IF;
  -- IF SVC CODE IS UPDATED, UPDATE THE LINK, MASTER SVC, AND 13 OTHER CODES TABLES
  IF (upper(:old.CD_SVC_CODE) <> upper(:new.CD_SVC_CODE)) THEN
      -- UPDATE CODE 
      UPDATE CAPS.CODES_TABLES
      SET CODE = :NEW.CD_SVC_CODE
      WHERE CODE_TYPE IN ('CFLSVLNK','CSVCCODE','CMILEAGE','CRELCODE','CSBGTLMT','CADDONLI','CSAMTLMT','CCCISVCD','CCCIUTRT','CCCIPTYP','CCCIUTYP','CCPASVCD','CCPAUTRT','CCPAPTYP','CCPAUTYP')
      AND CODE = :OLD.CD_SVC_CODE;
      -- UPDATE DECODE (THESE CODES TABLES HAVE DECODE THE SAME WITH CODE)
      UPDATE CAPS.CODES_TABLES
      SET DECODE = :NEW.CD_SVC_CODE
      WHERE CODE_TYPE IN ('CCCISVCD','CCPASVCD')
      AND CODE = :OLD.CD_SVC_CODE;
      
      -- UPDATE TO SVC AUTH AREA 
      -- IF UPDATE NOT FOUND, IT IS INSERT AND THIS ACTION IS HANDLED BY THE APPLICATION
      -- UPDATE BOTH UAS AND ENT, EVEN IF ONLY ONE OF THEM CHANGED
      IF (:NEW.IND_ENT_HEADER = 'Y') THEN
        UPDATE CAPS.SVC_AUTH_UAS_ENT_CODE
        SET CD_ENT = :NEW.CD_ENT_CODE, CD_UAS = substr(:new.CD_SVC_CODE, 1, 3)
        WHERE (CD_UAS || CD_ENT) = :OLD.CD_SVC_CODE;
      END IF;
  END IF;
  -- IF A HEADER CODE IS UPDATED TO BE A SVC CODE : DELETE FROM CODES TABLES CENTCODE, 
  -- INSERT INTO THE MASTER SERVICE CODE, AND SERVICE CODE LINK. 
  IF (:OLD.IND_ENT_HEADER = 'Y' AND :NEW.IND_ENT_HEADER = 'N') THEN
    DELETE CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = :OLD.CD_ENT_CODE;
    -- INSERT INTO CSCVCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CSVCCODE', :NEW.CD_SVC_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE FROM DUAL
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CSVCCODE');
    -- INSERT INTO CFLSVLNK
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CFLSVLNK', :NEW.CD_SVC_CODE, substr(:NEW.CD_SVC_CODE,1,3), NULL, SYSDATE FROM DUAL 
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CFLSVLNK');
  END IF;
  -- IF A SVC CODE IS MADE INTO A HEADER CODE INSERT INTO CENTCODE AND 
  -- REMOVE IT FROM THE SVC CODE AND SVC LINK CODES TABLES
  IF ((:OLD.IND_ENT_HEADER = 'N' or :OLD.IND_ENT_HEADER is null) AND :NEW.IND_ENT_HEADER = 'Y') THEN
    -- ENTER INTO THE CENTCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CENTCODE', :NEW.CD_ENT_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from codes_tables where upper(code) = upper(:new.cd_ent_code) and code_type = 'CENTCODE');  
    -- DELETE THE SVC CODE FROM THE SVC CODE AND SVC LINK CODES TABLES
    DELETE CAPS.CODES_TABLES WHERE CODE_TYPE IN ('CSVCCODE','CFLSVLNK') AND CODE = :OLD.CD_SVC_CODE;

  END IF;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_UAS_PROGRAM_CODE_MTNT
-- KEEP THIS COMMENT IN THE TRIGGER CODE: REVIEW UAS PROGRAM CODE MAINTENANCE DESIGN WHEN UDPATE THIS TRIGGER TO AVOID POSSIBLE CIRCULAR TRIGGER.
BEFORE INSERT
ON CAPS.UAS_PROGRAM_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
   dummy number;
BEGIN
:NEW.DT_LAST_UPDATE := sysdate;
  -- TIMESTAMP
  if :NEW.ID_UAS_PROGRAM_CODE_MTNT=0 then
    SELECT CAPS.SEQ_UAS_PROGRAM_CODE_MTNT.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_UAS_PROGRAM_CODE_MTNT := dummy;
  end if;
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CPRGCODE', :NEW.CD_UAS, :NEW.TXT_PROGRAM_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from codes_tables where code = :new.cd_uas and code_type = 'CPRGCODE');   
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CPROGCDE', :NEW.CD_UAS, :NEW.TXT_PROGRAM_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from codes_tables where code = :new.cd_uas and code_type = 'CPROGCDE');  
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CPRGAREA', :NEW.CD_UAS, :NEW.TXT_PROGRAM_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from codes_tables where code = :new.cd_uas and code_type = 'CPRGAREA');
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UAS_PROGRAM_CODE_MTNT
-- KEEP THIS COMMENT IN THE TRIGGER CODE: REVIEW UAS PROGRAM CODE MAINTENANCE DESIGN WHEN UDPATE THIS TRIGGER TO AVOID POSSIBLE CIRCULAR TRIGGER.
BEFORE UPDATE
ON CAPS.UAS_PROGRAM_CODE_MTNT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;

  IF (:old.TXT_PROGRAM_DESC <> :new.TXT_PROGRAM_DESC) THEN
  BEGIN
    UPDATE CAPS.CODES_TABLES
    SET DECODE = :NEW.TXT_PROGRAM_DESC
    WHERE CODE_TYPE = 'CPRGCODE' AND CODE = :OLD.CD_UAS;
    UPDATE CAPS.CODES_TABLES
    SET DECODE = :NEW.TXT_PROGRAM_DESC
    WHERE CODE_TYPE = 'CPROGCDE' AND CODE = :OLD.CD_UAS;
    UPDATE CAPS.CODES_TABLES
    SET DECODE = :NEW.TXT_PROGRAM_DESC
    WHERE CODE_TYPE = 'CPRGAREA' AND CODE = :OLD.CD_UAS;
    -- this table is for SA only, if the record does not exists, nothing happens
    UPDATE CAPS.CODES_TABLES
    SET DECODE = :NEW.TXT_PROGRAM_DESC
    WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = :OLD.CD_UAS;
  END;
  END IF;
  -- Update code in codes tables, duplicates handled in app, ignore and do not raise exception
  IF (:old.CD_UAS <> :new.CD_UAS) THEN
  BEGIN
    UPDATE CAPS.CODES_TABLES
    SET CODE = :NEW.CD_UAS
    WHERE CODE_TYPE = 'CPRGCODE' AND CODE = :OLD.CD_UAS;
    UPDATE CAPS.CODES_TABLES
    SET CODE = :NEW.CD_UAS
    WHERE CODE_TYPE = 'CPROGCDE' AND CODE = :OLD.CD_UAS;
    UPDATE CAPS.CODES_TABLES
    SET CODE = :NEW.CD_UAS
    WHERE CODE_TYPE = 'CPRGAREA' AND CODE = :OLD.CD_UAS;
    -- this table is for SA only, if the record does not exists, nothing happens
    UPDATE CAPS.CODES_TABLES
    SET CODE = :NEW.CD_UAS
    WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = :OLD.CD_UAS;
  END;
  END IF;  
  -- DELETE FROM SA CODES TABLES CPRGCOD1. EITHER NOT SA OR NOT ENT HEADER
  -- SO DELETE REGRADLESS ENT HEADER VALUE 
  IF (:OLD.IND_SERV_AUTH = 'Y' AND :NEW.IND_SERV_AUTH = 'N') THEN
    DELETE CAPS.CODES_TABLES WHERE CODE_TYPE = 'CPRGCOD1' AND CODE = :OLD.CD_UAS;
  END IF;
END;
/
                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                            
insert into caps.schema_version(id_schema_version,application_version,comments)                                                                                                                                                                                                                             
            values (1141, 'SacwisRev5', 'Release 5.0 - DBCR 17260');                                                                                                                                                                                                                                         
                                                                                                                                                                                                                                                                                                  
commit;                                                                                                                                                                                                                                                                                                   
