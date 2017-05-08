--STGAP00010140 - Update UNIT_EMP_LINK trigger to set STAGE.ID_UNIT (2.6)

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_UNIT_EMP_LINK
BEFORE UPDATE
ON CAPS.UNIT_EMP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        ---
        --- GRD New dummies for EMPLOYEE denormalization
        ---
        dummy2          VARCHAR2(2);
        dummy3          VARCHAR2(3);
        zNM_PERSON_FIRST            PERSON.NM_PERSON_FIRST%TYPE;

        v_cntr_int NUMBER := 0;
        v_cntr_inv NUMBER := 0;
        v_cntr_div NUMBER := 0;
        v_cntr_ong NUMBER := 0;
        v_cntr_fc  NUMBER := 0;
        v_cntr_ado NUMBER := 0;
        v_cntr_pad NUMBER := 0;
        v_cntr_fad  NUMBER := 0;
        v_cntr_pfc NUMBER := 0;

        v_cd_int VARCHAR2(3) := 'INT';
        v_cd_inv VARCHAR2(3) := 'INV';
        v_cd_div VARCHAR2(3) := 'DIV';
        v_cd_ong VARCHAR2(3) := 'FPR';
        v_cd_fc  VARCHAR2(3) := 'SUB';
        v_cd_ado VARCHAR2(3) := 'ADO';
        v_cd_pad VARCHAR2(3) := 'PAD';
        v_cd_fad  VARCHAR2(3) := 'FAD';
        v_cd_pfc VARCHAR2(3) := 'PFC';

        v_err_num       NUMBER;
        v_err_msg       VARCHAR2(100);

        CURSOR c_get_stage_counts IS
         SELECT cd_wkld_stage, count(*) scnt
           FROM workload w
          WHERE id_wkld_person=:new.ID_PERSON AND id_wkld_unit=:new.ID_UNIT AND cd_wkld_stage_pers_role='PR'
          GROUP BY cd_wkld_stage;

        r_get_stage_counts c_get_stage_counts%ROWTYPE;

BEGIN
        :new.DT_LAST_UPDATE := SYSDATE;
        ---
        --- GRD If the new row is MEMBER IN then we need
        --- to update the denormalized EMPLOYEE table
        ---
        IF (:new.CD_UNIT_MEMBER_IN_OUT = 'IN')
        THEN
                SELECT NBR_UNIT,
                       CD_UNIT_REGION
                INTO   dummy2,
                       dummy3
                FROM UNIT
                WHERE ID_UNIT = :NEW.ID_UNIT;
                UPDATE EMPLOYEE
                SET NBR_EMP_UNIT_EMP_IN = dummy2,
                    CD_EMP_UNIT_REGION = dummy3,
                    ID_EMP_UNIT = :NEW.ID_UNIT
                WHERE ID_PERSON = :NEW.ID_PERSON;
                
                ---
                --- HJB If the employee's unit has changed, we need
                --- to update the employee's workload to the new 
                --- unit in order to keep the stage counts accurate
                ---
                IF (  (:NEW.ID_UNIT <> :OLD.ID_UNIT)  ) THEN
                   UPDATE WORKLOAD W 
                   SET   W.ID_WKLD_UNIT             = :NEW.ID_UNIT,
                   W.NBR_WKLD_UNIT            =  dummy2
                   WHERE W.ID_WKLD_PERSON           = :NEW.ID_PERSON;
                   -- STGAP00009841 - VVO:
                   -- also update the stage's unit id in STAGE table with this new unit id
		   UPDATE stage s 
		   SET s.ID_UNIT = :NEW.ID_UNIT
	           WHERE s.ID_STAGE IN ( SELECT w.ID_WKLD_STAGE
				         FROM workload w
					 WHERE w.ID_WKLD_PERSON = :NEW.ID_PERSON );
		   -- End STGAP00009841
                END IF;
        END IF;
        
        SELECT 
           NM_PERSON_FIRST 
        INTO  zNM_PERSON_FIRST 
        FROM PERSON 
        WHERE ID_PERSON = :NEW.ID_PERSON;
    
        IF ( zNM_PERSON_FIRST <> 'Conversion')
        THEN

         OPEN c_get_stage_counts;
         LOOP
              FETCH c_get_stage_counts INTO r_get_stage_counts;
              EXIT WHEN c_get_stage_counts%NOTFOUND;
 
              IF r_get_stage_counts.cd_wkld_stage = v_cd_int
             THEN
                 v_cntr_int := r_get_stage_counts.scnt;
              END IF;
 
              IF r_get_stage_counts.cd_wkld_stage = v_cd_inv
             THEN
                 v_cntr_inv := r_get_stage_counts.scnt;
              END IF;
   
              IF r_get_stage_counts.cd_wkld_stage = v_cd_div
             THEN
                 v_cntr_div := r_get_stage_counts.scnt;
             END IF;
   
             IF r_get_stage_counts.cd_wkld_stage = v_cd_ong
             THEN
                v_cntr_ong := r_get_stage_counts.scnt;
             END IF;
   
             IF r_get_stage_counts.cd_wkld_stage = v_cd_fc
            THEN
                v_cntr_fc := r_get_stage_counts.scnt;
            END IF;
   
            IF r_get_stage_counts.cd_wkld_stage = v_cd_ado
            THEN
                v_cntr_ado := r_get_stage_counts.scnt;
            END IF;
   
            IF r_get_stage_counts.cd_wkld_stage = v_cd_pad
            THEN
                v_cntr_pad := r_get_stage_counts.scnt;
            END IF;
   
            IF r_get_stage_counts.cd_wkld_stage = v_cd_fad
            THEN
               v_cntr_fad := r_get_stage_counts.scnt;
            END IF;
            
            IF r_get_stage_counts.cd_wkld_stage = v_cd_pfc
            THEN
               v_cntr_pfc := r_get_stage_counts.scnt;
            END IF;        

        END LOOP;
        CLOSE c_get_stage_counts;
        
        :new.nbr_int := v_cntr_int;
        :new.nbr_inv := v_cntr_inv;         
        :new.nbr_div := v_cntr_div;
        :new.nbr_ong := v_cntr_ong;
        :new.nbr_fc := v_cntr_fc;
        :new.nbr_ado := v_cntr_ado;
        :new.nbr_pad := v_cntr_pad;
        :new.nbr_fad := v_cntr_fad;
        :new.nbr_pfc := v_cntr_pfc;

     END IF;
END;
/


--STGAP00010151 - FA HOME fix for dbcr   (2.6)



UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'You do not have privileges to search for an Adoptive home.'
WHERE TXT_MESSAGE_NAME = 'MSG_NOT_ADO_USER';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (380, 'SacwisRev2', 'Release 2.6 - DBCRs 10140,10151');

commit;


