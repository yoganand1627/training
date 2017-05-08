--STGAP00017677 - Release(5.0) ECEM 5.0: updated triggers for program code mtnt

-- Updated ent mtnt table to not delete CENTCODE as business changes
-- Fixed updates when user change code and desc/decode at the same time

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
  -- IF SVC CODE IS UPDATED, UPDATE THE LINK, MASTER SVC, AND 13 OTHER CODES TABLES
  -- 10302011: THIS IS CAUSED BY EITHER PROGRAM OR ENT CODE CHANGES. CODE IS PART OF ROW ID. 
  -- IT SHOULD BE DONE AS LAST AS POSSIBLE AFTER ALL NON-ID CHANGES HAVE TAKEN PLACE.
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
      AND CODE = :NEW.CD_SVC_CODE;
      --11152011: ent header code changes: 
      -- insert new code if the code is available (not exists)
      IF (upper(:old.CD_ENT_CODE) <> upper(:new.CD_ENT_CODE) AND :NEW.IND_ENT_HEADER = 'Y') THEN
        INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
        select 'CENTCODE', :NEW.CD_ENT_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE from dual 
        where not exists (select 1 from CAPS.codes_tables where upper(code) = upper(:new.cd_ent_code) and code_type = 'CENTCODE');  
        -- NO delete from header codes tables, because it would leave other program with same header orphan
        -- The current program can be disassociated from the header group by changing the code.
        -- DELETE CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = :OLD.CD_ENT_CODE;
      END IF;
      -- END 11152011 CHANGES
      -- UPDATE TO SVC AUTH AREA 
      -- IF UPDATE NOT FOUND, IT IS INSERT AND THIS ACTION IS HANDLED BY THE APPLICATION
      -- UPDATE BOTH UAS AND ENT, EVEN IF ONLY ONE OF THEM CHANGED
      IF (:NEW.IND_ENT_HEADER = 'Y') THEN
        UPDATE CAPS.SVC_AUTH_UAS_ENT_CODE
        SET CD_ENT = :NEW.CD_ENT_CODE, CD_UAS = substr(:new.CD_SVC_CODE, 1, 3)
        WHERE (CD_UAS || CD_ENT) = :OLD.CD_SVC_CODE;
      END IF;
  END IF;
  -- 11152011: move the desc update after the code update and change lookup from OLD to NEW
  IF (:old.TXT_ENT_DESC <> :new.TXT_ENT_DESC) THEN
  -- UPDATE DESC ON THE MASTER SVC CODES TABLES
      UPDATE CAPS.CODES_TABLES
      SET DECODE = :NEW.TXT_ENT_DESC
      WHERE CODE_TYPE IN ('CSVCCODE','CMILEAGE','CRELCODE','CADDONLI') 
      AND CODE = :NEW.CD_SVC_CODE;
  -- 
    IF (:NEW.IND_ENT_HEADER = 'Y') THEN
      UPDATE CAPS.CODES_TABLES
      SET DECODE = :NEW.TXT_ENT_DESC
      WHERE CODE_TYPE = 'CENTCODE' AND CODE = :NEW.CD_ENT_CODE;
    END IF;    

  END IF;
  -- CHANGE IN UNIT RATE, TYPE, PAYMENT TYPE FOR CCI/CPA
  IF NOT(:OLD.AMT_UNIT_RATE = :NEW.AMT_UNIT_RATE) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.AMT_UNIT_RATE
     WHERE CODE_TYPE IN ('CCCIUTRT','CCPAUTRT') AND CODE = :NEW.CD_SVC_CODE;
  END IF;
  IF NOT(:OLD.CD_UNIT_TYPE = :NEW.CD_UNIT_TYPE) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.CD_UNIT_TYPE
     WHERE CODE_TYPE IN ('CCCIUTYP','CCPAUTYP') AND CODE = :NEW.CD_SVC_CODE;
  END IF;
  IF NOT(:OLD.CD_PAYMENT_TYPE = :NEW.CD_PAYMENT_TYPE) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.CD_PAYMENT_TYPE
     WHERE CODE_TYPE IN ('CCCIPTYP','CCPAPTYP') AND CODE = :NEW.CD_SVC_CODE;
  END IF;
  -- CHANGE IN CASE BUDGET OR LINE ITEM LIMIT
  IF NOT(:OLD.AMT_CASE_BUDGET_LIMIT = :NEW.AMT_CASE_BUDGET_LIMIT) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.AMT_CASE_BUDGET_LIMIT
     WHERE CODE_TYPE IN ('CSBGTLMT','CSAMTLMT') AND CODE = :NEW.CD_SVC_CODE;  
  END IF;  
  IF NOT(:OLD.AMT_LINE_ITEM_LIMIT = :NEW.AMT_LINE_ITEM_LIMIT) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.AMT_LINE_ITEM_LIMIT
     WHERE CODE_TYPE IN ('CSAMTLMT') AND CODE = :NEW.CD_SVC_CODE;  
  END IF;
  IF NOT(:OLD.AMT_CASE_BUDGET_LIMIT = :NEW.AMT_CASE_BUDGET_LIMIT) THEN
     UPDATE CAPS.CODES_TABLES
     SET DECODE = :NEW.AMT_CASE_BUDGET_LIMIT
     WHERE CODE_TYPE IN ('CSBGTLMT') AND CODE = :NEW.CD_SVC_CODE;  
  END IF;  
  
  -- 10302011: THIS IS OK TO BE AFTER THE CODE CHANGE UPDATE AS IT DELETES ON OLD CODE AND INSERT BY NEW CODE.
  -- IF A HEADER CODE IS UPDATED TO BE A SVC CODE : DELETE FROM CODES TABLES CENTCODE, 
  -- INSERT INTO THE MASTER SERVICE CODE, AND SERVICE CODE LINK. 
  IF (:OLD.IND_ENT_HEADER = 'Y' AND :NEW.IND_ENT_HEADER = 'N') THEN
    -- 11152011: NO delete from header codes tables, because it would leave other program with same header orphan
    -- uncheck header can just mean breaking off the tie between the current program and thid header, but this header can still be
    -- valid for other programs
    --DELETE CAPS.CODES_TABLES WHERE CODE_TYPE = 'CENTCODE' AND CODE = :OLD.CD_ENT_CODE;
    -- INSERT INTO CSCVCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CSVCCODE', :NEW.CD_SVC_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE FROM DUAL
    where not exists (select 1 from CAPS.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CSVCCODE');
    -- INSERT INTO CFLSVLNK
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CFLSVLNK', :NEW.CD_SVC_CODE, substr(:NEW.CD_SVC_CODE,1,3), NULL, SYSDATE FROM DUAL 
    where not exists (select 1 from CAPS.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CFLSVLNK');
  END IF;
  -- IF A SVC CODE IS MADE INTO A HEADER CODE INSERT INTO CENTCODE AND 
  -- REMOVE IT FROM THE SVC CODE AND SVC LINK CODES TABLES
  IF ((:OLD.IND_ENT_HEADER = 'N' or :OLD.IND_ENT_HEADER is null) AND :NEW.IND_ENT_HEADER = 'Y') THEN
    -- ENTER INTO THE CENTCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    select 'CENTCODE', :NEW.CD_ENT_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE from dual 
    where not exists (select 1 from CAPS.codes_tables where upper(code) = upper(:new.cd_ent_code) and code_type = 'CENTCODE');  
    -- DELETE THE SVC CODE FROM THE SVC CODE AND SVC LINK CODES TABLES
    DELETE CAPS.CODES_TABLES WHERE CODE_TYPE IN ('CSVCCODE','CFLSVLNK') AND CODE = :OLD.CD_SVC_CODE;

  END IF;
END;
/

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1167, 'SacwisRev5', 'Release 5.0 - DBCR 17677');

commit;
