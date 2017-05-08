--STGAP00011538 - Update TUBR_STAGE trigger

--Note:  no impact to ado model

--needed to catch exception that could occur in trigger as a result of implementing reopen stage functionality into SHINES.

-- bogus grant statement to make this script executable for both SQLPlus and DBCR apply script

grant select on caps.person to capson;
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE 
BEFORE UPDATE
ON CAPS.STAGE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW

DECLARE

     zNBR_UNIT       VARCHAR2(2);
   xID_PERSON    UNIT_EMP_LINK.ID_PERSON%TYPE;
   v_cd_int VARCHAR2(3) := 'INT';
     v_cd_inv VARCHAR2(3) := 'INV';
     v_cd_div VARCHAR2(3) := 'DIV';
     v_cd_ong VARCHAR2(3) := 'FPR';
     v_cd_fc  VARCHAR2(3) := 'SUB';
     v_cd_ado VARCHAR2(3) := 'ADO';
     v_cd_pad VARCHAR2(3) := 'PAD';
     v_cd_fad  VARCHAR2(3) := 'FAD';
     v_cd_pfc VARCHAR2(3) := 'PFC';

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

	begin
      SELECT ID_WKLD_PERSON
      INTO xID_PERSON
      FROM WORKLOAD
      WHERE ID_WKLD_STAGE = :NEW.ID_STAGE
      AND CD_WKLD_STAGE_PERS_ROLE = 'PR';
	exception
	  when NO_DATA_FOUND then 
	  null;
	  when OTHERS then
	  null;
	end;


         IF :NEW.CD_STAGE = v_cd_int
             THEN
                 UPDATE UNIT_EMP_LINK
              SET NBR_INT = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_INT = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
              END IF;

             IF :NEW.CD_STAGE = v_cd_div
             THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_DIV = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_DIV = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
              END IF;

             IF :NEW.CD_STAGE = v_cd_inv
             THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_INV = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_INV = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
             END IF;

             IF :NEW.CD_STAGE = v_cd_ong
             THEN
                  UPDATE UNIT_EMP_LINK
            SET NBR_ONG = 1
            WHERE ID_PERSON = xID_PERSON
            AND CD_UNIT_MEMBER_IN_OUT = 'IN';

            UPDATE UNIT_EMP_LINK
            SET NBR_ONG = 1
            WHERE ID_PERSON = xID_PERSON
            AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
             END IF;

            IF :NEW.CD_STAGE = v_cd_fc
            THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_FC = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_FC = 1
           WHERE ID_PERSON = xID_PERSON
          AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;

            IF :NEW.CD_STAGE = v_cd_ado
            THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_ADO = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_ADO = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;

            IF :NEW.CD_STAGE = v_cd_pad
            THEN
                 UPDATE UNIT_EMP_LINK
          SET NBR_PAD = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_PAD = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;

            IF :NEW.CD_STAGE = v_cd_fad
            THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_FAD = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_FAD = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;

            IF :NEW.CD_STAGE = v_cd_pfc
            THEN
                 UPDATE UNIT_EMP_LINK
           SET NBR_PFC = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'IN';

           UPDATE UNIT_EMP_LINK
           SET NBR_PFC = 1
           WHERE ID_PERSON = xID_PERSON
           AND CD_UNIT_MEMBER_IN_OUT = 'OUT';
            END IF;

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


--STGAP00011562 - Re-Activate The Foster Care Discharges Report

--Note:  no impact to ado model


--This is sql below necessary to activate the Foster Care Discharges report in the 3.0 schema.


update caps.reports set reports.ind_rpt_page = 'Y' where reports.NM_RPT_SQR_NAME = 'AfcarsDischarge';



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (413, 'SacwisRev3', 'Release 3.0 - DBCRs 11538,11562');

commit;



