/
create or replace
TRIGGER CAPS.TUBR_STAGE 
BEFORE UPDATE
ON STAGE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW

DECLARE

     zNBR_UNIT       VARCHAR2(2);
     -- 4/9/09 HTVO - Removed DBCR 11273 code

BEGIN
      ---
      --- KJM: Altered trigger to update the WORKLOAD table with
      --- relevant data where ID_STAGE=ID_STAGE  (provided that the
      --- stage is open).
      --- The exception handling has no special cases.
      --- Mitschke 05/19/03 SIR #17193 - during IMPACT testing, it was
      --- noticed by Carolyn Douglass that the comparison to 12/31/4712
      --- was not being handled.  This is being added.

        :NEW.DT_LAST_UPDATE := SYSDATE;

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

             IF ( (:NEW.ID_UNIT <> :OLD.ID_UNIT) OR
                  ( (:OLD.ID_UNIT IS NULL) AND
                    (:NEW.ID_UNIT <> 0)        ) )
             THEN
                   SELECT NBR_UNIT
                   INTO   zNBR_UNIT
                   FROM   UNIT  U
                   WHERE  U.ID_UNIT = :NEW.ID_UNIT;

                   UPDATE WORKLOAD W
                   SET    W.NBR_WKLD_UNIT  = zNBR_UNIT,
                          W.ID_WKLD_UNIT   = :NEW.ID_UNIT
                   WHERE  W.ID_WKLD_STAGE  = :NEW.ID_STAGE;

             END IF;

             UPDATE WORKLOAD W
             SET  W.CD_WKLD_STAGE                    = :NEW.CD_STAGE,
                  W.CD_WKLD_STAGE_TYPE               = :NEW.CD_STAGE_TYPE,
                  W.CD_WKLD_STAGE_CNTY               = :NEW.CD_STAGE_CNTY,
                  W.CD_WKLD_STAGE_REGION             = :NEW.CD_STAGE_REGION,
                  W.CD_WKLD_STAGE_PROGRAM            = :NEW.CD_STAGE_PROGRAM,
                  W.CD_WKLD_STAGE_RSN_CLS      = :NEW.CD_STAGE_REASON_CLOSED,
                  W.NM_WKLD_STAGE                    = :NEW.NM_STAGE
             WHERE  W.ID_WKLD_STAGE                  = :NEW.ID_STAGE;

      -- DBCR 11273 ON 11/17/2008 - Retrieves primary case manager's
      -- person ID from the workload table and uses that id_person
      -- to trigger a count on the workload to update unit_emp_link
      -- table.
      -- 4/9/09 HTVO - Removed DBCR 11273 code


        END IF;
        ---
        ---     Mitschcg 03/10/97 SIR request #11028 from Krista Moy/Tim Overend
        ---     to add the following trigger.  On update of stage table,
        ---     if DT_STAGE_CLOSE is max date ('12/31/4712') or is null,
        ---     then set the IND_STAGE_CLOSE to 'N' (the stage is
        ---     not closed), else set the IND_STAGE_CLOSE to 'Y' (the stage
        ---     is closed).

        IF ((:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/4712','MM/DD/YYYY'))
           OR (:NEW.DT_STAGE_CLOSE = TO_DATE('12/31/3500','MM/DD/YYYY'))
       OR (:NEW.DT_STAGE_CLOSE IS NULL))
        THEN
           :NEW.IND_STAGE_CLOSE := 'N';
        ELSE
           :NEW.IND_STAGE_CLOSE := 'Y';
        END IF;

EXCEPTION
   WHEN OTHERS THEN RAISE;

END;
/


-- STGAP0000XXXX - Description goes here

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (454, 'SacwisRev3', 'Release 3.01 - DBCR 13303');

commit;


