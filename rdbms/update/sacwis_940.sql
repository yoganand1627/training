--STGAP00016049 - Release(4.1) MR-074 PLACEMENT Trigger Change for CPRS

-- STGAP00016049
-- MR-074 PLACEMENT Trigger changed for CPRS
-- Added CD_PLCMT_TYPE to the condition

grant select on caps.stage to operator;
/
create or replace
TRIGGER CAPS.TIAR_PLACEMENT
AFTER INSERT OR UPDATE
ON CAPS.PLACEMENT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  DATA_PRESENT VARCHAR2(1);
  DATA_MODIFIED VARCHAR2(1);
  UPD_FLAG VARCHAR2(1);
  xCD_EVENT_STATUS EVENT.CD_EVENT_STATUS%TYPE;
  xCD_COUNTY VARCHAR2(3);
  xID_CASE CAPS_CASE.ID_CASE%TYPE;
BEGIN
    -- DBMS_OUTPUT.put_line('IN TIAR_PLACEMENT');
    UPD_FLAG := 'N';
    DATA_PRESENT := 'N';
    DATA_MODIFIED := 'N';
    IF ((:NEW.ADDR_PLCMT_CITY IS NOT NULL) OR
       (:NEW.CD_PLCMT_TYPE IS NOT NULL))
    THEN
       DATA_PRESENT := 'Y';
     -- DBMS_OUTPUT.put_line('IN TIAR_PLACEMENT - DATA PRESENT');
    END IF;
    IF (INSERTING AND DATA_PRESENT='Y')
  THEN
      UPD_FLAG := 'Y';
    -- DBMS_OUTPUT.put_line('IN TIAR_PLACEMENT - INSERT HAS DATA PRESENT');
    SELECT CD_EVENT_STATUS, ID_CASE
    INTO xCD_EVENT_STATUS, xID_CASE
      FROM EVENT
      WHERE ID_EVENT = :NEW.ID_PLCMT_EVENT;
    ELSIF (UPDATING AND DATA_PRESENT='Y')
  THEN
      IF ((:NEW.ADDR_PLCMT_CITY IS NOT NULL AND (:OLD.ADDR_PLCMT_CITY IS NULL OR
            :NEW.ADDR_PLCMT_CITY <> :OLD.ADDR_PLCMT_CITY)) OR
          (:NEW.ADDR_PLCMT_ST IS NOT NULL AND (:OLD.ADDR_PLCMT_ST IS NULL OR
            :NEW.ADDR_PLCMT_ST <> :OLD.ADDR_PLCMT_ST)) OR
          (:NEW.ADDR_PLCMT_CNTY IS NOT NULL AND (:OLD.ADDR_PLCMT_CNTY IS NULL OR
            :NEW.ADDR_PLCMT_CNTY <> :OLD.ADDR_PLCMT_CNTY)) OR
          (:NEW.ADDR_PLCMT_ZIP IS NOT NULL AND (:OLD.ADDR_PLCMT_ZIP IS NULL OR
            :NEW.ADDR_PLCMT_ZIP <> :OLD.ADDR_PLCMT_ZIP)) OR
          (:NEW.ADDR_PLCMT_LN1 IS NOT NULL AND (:OLD.ADDR_PLCMT_LN1 IS NULL OR
            :NEW.ADDR_PLCMT_LN1 <> :OLD.ADDR_PLCMT_LN1)) OR
          (:NEW.ADDR_PLCMT_LN2 IS NOT NULL AND (:OLD.ADDR_PLCMT_LN2 IS NULL OR
            :NEW.ADDR_PLCMT_LN2 <> :OLD.ADDR_PLCMT_LN2)) OR
          (:NEW.CD_PLCMT_TYPE IS NOT NULL AND (:OLD.CD_PLCMT_TYPE IS NULL OR
            :NEW.CD_PLCMT_TYPE <> :OLD.CD_PLCMT_TYPE)))
      THEN
             DATA_MODIFIED := 'Y';
             SELECT CD_EVENT_STATUS, ID_CASE
             INTO xCD_EVENT_STATUS, xID_CASE
             FROM EVENT
             WHERE ID_EVENT = :NEW.ID_PLCMT_EVENT;
             UPD_FLAG := 'Y';
      END IF;
    END IF;
    IF (UPD_FLAG = 'Y')
    THEN
         -- DBMS_OUTPUT.put_line('IN TIAR_PLACEMENT - Update CPRS is a go. Case is ' || xID_CASE);
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
    DBMS_OUTPUT.put_line('IN TIAR_PLACEMENT, SQLCODE: '||SQLCODE);
      IF SQL%NOTFOUND THEN
          xCD_COUNTY := NULL;
    END IF;
END;
/



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (941, 'SacwisRev4', 'Release 4.1 - DBCR 16049');

commit;


