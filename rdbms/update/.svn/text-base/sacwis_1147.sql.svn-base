--STGAP00017342 - Release(5.0) ECEM 5.0: misc updates for UAS Program code page

-- TIBR_UAS_ENT_CODE_MTNT: CORRECT THE CODES TABLES NAME (TYPE) CSVCCODE
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
    where not exists (select 1 from caps.codes_tables where upper(code) = upper(:new.cd_ent_code) and code_type = 'CENTCODE');    
  ELSE
    -- INSERT INTO CSVCCODE
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CSVCCODE', :NEW.CD_SVC_CODE, :NEW.TXT_ENT_DESC, NULL, SYSDATE FROM DUAL
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CSVCCODE');
    -- INSERT INTO CFLSVLNK
    INSERT INTO CAPS.CODES_TABLES(code_type, code, decode, dt_end, dt_last_update) 
    SELECT 'CFLSVLNK', :NEW.CD_SVC_CODE, substr(:NEW.CD_SVC_CODE,1,3), NULL, SYSDATE FROM DUAL 
    where not exists (select 1 from caps.codes_tables where code = :new.CD_SVC_CODE and code_type = 'CFLSVLNK');
  END IF;  
END;
/

-- set the program effective date to be the earliest among it ENT dates
update caps.uas_program_code_mtnt p
set p.dt_effective = (select min(e.dt_effective) from caps.uas_ent_code_mtnt e
 where e.id_uas_program_code_mtnt = p.id_uas_program_code_mtnt
);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1148, 'SacwisRev5', 'Release 5.0 - DBCR 17342');

commit;
