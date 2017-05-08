--STGAP00015956 - Release(4.0) MR-068 FCCP_FAMILY Trigger changed for CPRS


grant select on caps.person to capson;

/
CREATE OR REPLACE TRIGGER CAPS.TIAR_FCCP_FAMILY 
AFTER INSERT OR UPDATE
ON CAPS.FCCP_FAMILY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  DATA_PRESENT VARCHAR2(1);
  DATA_MODIFIED VARCHAR2(1);
  UPD_FLAG VARCHAR2(1);
  xCD_EVENT_STATUS EVENT.CD_EVENT_STATUS%TYPE;
  xCD_COUNTY VARCHAR2(3);
BEGIN
    UPD_FLAG := 'N';
    DATA_PRESENT := 'N';
    DATA_MODIFIED := 'N';
    IF ((:NEW.DT_ORIG_SUB IS NOT NULL) OR
        (:NEW.CD_PRIM_PERM_PLAN IS NOT NULL) OR
        (:NEW.CD_SECND_PERM_PLAN IS NOT NULL) OR
        (:NEW.CD_PLAN_TYPE IS NOT NULL) OR
        (:NEW.TXT_HARM IS NOT NULL) OR
        (:NEW.TXT_RSNS_PROT IS NOT NULL) OR
        (:NEW.NM_ASSGN_JUDGE IS NOT NULL) OR
        (:NEW.CD_ASSGN_JUDGE IS NOT NULL))
    THEN
       DATA_PRESENT := 'Y';
    END IF;
    IF (INSERTING AND DATA_PRESENT='Y') 
  THEN
      UPD_FLAG := 'Y';
    ELSIF (UPDATING AND DATA_PRESENT='Y') 
  THEN
      IF ((:NEW.DT_ORIG_SUB IS NOT NULL AND (:OLD.DT_ORIG_SUB IS NULL OR
            :NEW.DT_ORIG_SUB <> :OLD.DT_ORIG_SUB)) OR
          (:NEW.CD_PRIM_PERM_PLAN IS NOT NULL  AND (:OLD.CD_PRIM_PERM_PLAN IS NULL OR
            :NEW.CD_PRIM_PERM_PLAN <> :OLD.CD_PRIM_PERM_PLAN)) OR
          (:NEW.CD_SECND_PERM_PLAN IS NOT NULL  AND (:OLD.CD_SECND_PERM_PLAN IS NULL OR
            :NEW.CD_SECND_PERM_PLAN <> :OLD.CD_SECND_PERM_PLAN)) OR
          (:NEW.CD_PLAN_TYPE IS NOT NULL AND (:OLD.CD_PLAN_TYPE IS NULL OR
            :NEW.CD_PLAN_TYPE <> :OLD.CD_PLAN_TYPE))  OR
          (:NEW.TXT_HARM IS NOT NULL AND (:OLD.TXT_HARM IS NULL OR
            :NEW.TXT_HARM <> :OLD.TXT_HARM)) OR
          (:NEW.NM_ASSGN_JUDGE IS NOT NULL AND (:OLD.NM_ASSGN_JUDGE IS NULL OR
            :NEW.NM_ASSGN_JUDGE <> :OLD.NM_ASSGN_JUDGE)) OR
          (:NEW.CD_ASSGN_JUDGE IS NOT NULL AND (:OLD.CD_ASSGN_JUDGE IS NULL OR
            :NEW.CD_ASSGN_JUDGE <> :OLD.CD_ASSGN_JUDGE)) OR  
          (:NEW.TXT_RSNS_PROT IS NOT NULL  AND (:OLD.TXT_RSNS_PROT IS NULL OR
            :NEW.TXT_RSNS_PROT <> :OLD.TXT_RSNS_PROT)) )
      THEN
             DATA_MODIFIED := 'Y';
             SELECT CD_EVENT_STATUS
       INTO xCD_EVENT_STATUS
             FROM EVENT
             WHERE ID_EVENT = :NEW.ID_EVENT;
             -- If Plan has not been approved yet, it may not have been sent down to CPRS.
             -- So we will update CPRS with data we have so far on these fields.
             IF (xCD_EVENT_STATUS <> 'APRV')
             THEN
                UPD_FLAG := 'Y';
             END IF;
      END IF;
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
    DBMS_OUTPUT.put_line('IN TIAR_FCCP_FAMILY, SQLCODE: '||SQLCODE);
      IF SQL%NOTFOUND THEN
          xCD_COUNTY := NULL;
    END IF;
END;
/


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (864, 'SacwisRev3', 'Release 4.0 - DBCR 15956');

commit;


