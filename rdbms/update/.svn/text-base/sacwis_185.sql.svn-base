
-- Alter Trigger SQL
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
        (:NEW.TXT_RSNS_PROT IS NOT NULL))
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

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003145
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60345, 'MSG_FIN_DSD_EXISTS', 'A Delivered Service line item already exists for the associated Service Authorization in the given Month and Year.', '560', '730', 'N');

-- change STGAP00003149
update caps.TASK
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
IND_TASK_NEW_CASE_TODO_ENABLE=0
where cd_task in (3195,8695);

update caps.task
set CD_TASK_TOP_WINDOW = ''
where CD_TASK_EVENT_TYPE='VIS';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (186, 'SacwisRev2', 'static updates, CPRS trigger');
commit;
