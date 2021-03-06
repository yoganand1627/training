-- STGAP00017156 - Release(5.0) MR-094 Visitaion Pln output event link trigger

-- STGAP00017156 MR-094 Visitaion Plan output launch event link CPRS trigger
/
CREATE OR REPLACE TRIGGER CAPS.TIAR_OUTPUT_LAUNCH_EVENT_LINK
  AFTER INSERT OR UPDATE ON CAPS.OUTPUT_LAUNCH_EVENT_LINK 
  REFERENCING OLD AS OLD NEW AS NEW 
  
  FOR EACH ROW

  DECLARE 
  UPD_FLAG VARCHAR2(1);
  xCD_EVENT_STATUS EVENT.CD_EVENT_STATUS%TYPE;
  xCD_EVENT_TYPE EVENT.CD_EVENT_TYPE%TYPE;
  xID_CASE CAPS_CASE.ID_CASE%TYPE;
  xCD_COUNTY CAPS_CASE.CD_CASE_COUNTY%TYPE;
  
  BEGIN
    UPD_FLAG  := 'N';

    SELECT CD_EVENT_STATUS,
      CD_EVENT_TYPE,
      ID_CASE
    INTO xCD_EVENT_STATUS,
      xCD_EVENT_TYPE,
      xID_CASE
    FROM EVENT
    WHERE ID_EVENT = :NEW.ID_EVENT;

    -- On change of Visitation Plan Current indicator
    IF (:OLD.IND_CURRENT <> :NEW.IND_CURRENT 
          AND xCD_EVENT_TYPE = 'VIS' 
          AND xCD_EVENT_STATUS IN ('COMP', 'APRV')) THEN
      UPD_FLAG := 'Y';
    END IF;
    
    IF (UPD_FLAG = 'Y') THEN
      SELECT CD_CASE_COUNTY
      INTO xCD_COUNTY
      FROM CAPS_CASE C
      WHERE C.ID_CASE = xID_CASE;
      
      IF (xCD_COUNTY IS NOT NULL) THEN
        UPDATE_CASEPLAN (xCD_COUNTY, xID_CASE);
      END IF;
    END IF;
  EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.put_line('IN TIAR_OUTPUT_LAUNCH_EVENT_LINK, SQLCODE: '||SQLCODE);
    IF SQL%NOTFOUND THEN
      xCD_COUNTY := NULL;
    END IF;
  END;
  
/

insert into caps.schema_version(id_schema_version,application_version,comments)
values (1130, 'SacwisRev5', 'Release 5.0 - DBCR 17156');

commit;
