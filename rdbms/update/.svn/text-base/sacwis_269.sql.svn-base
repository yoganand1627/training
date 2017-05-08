-- Alter Trigger SQL
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
        v_cntr_rd  NUMBER := 0;

        v_cd_int VARCHAR2(3) := 'INT';
        v_cd_inv VARCHAR2(3) := 'INV';
        v_cd_div VARCHAR2(3) := 'DIV';
        v_cd_ong VARCHAR2(3) := 'FPR';
        v_cd_fc  VARCHAR2(3) := 'SUB';
        v_cd_ado VARCHAR2(3) := 'ADO';
        v_cd_pad VARCHAR2(3) := 'PAD';
        v_cd_rd  VARCHAR2(3) := 'FAD';

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
   
            IF r_get_stage_counts.cd_wkld_stage = v_cd_rd
            THEN
               v_cntr_rd := r_get_stage_counts.scnt;
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
        :new.nbr_rd := v_cntr_rd;

     END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- chagne STGAP00006834 
UPDATE CAPS.CODES_TABLES SET DECODE = 'YYYNNNYNNNN' WHERE CODE_TYPE = 'CCPSCLED' AND CODE = '01';
UPDATE CAPS.CODES_TABLES SET DECODE = 'YYYNNNNNNNN' WHERE CODE_TYPE = 'CCPSCLED' AND CODE = '02';
UPDATE CAPS.CODES_TABLES SET DECODE = 'YYYNNNNNNNN' WHERE CODE_TYPE = 'CCPSCLED' AND CODE = '03';
UPDATE CAPS.CODES_TABLES SET DECODE = 'YYYNNNNNNNN' WHERE CODE_TYPE = 'CCPSCLED' AND CODE = '04';
UPDATE CAPS.CODES_TABLES SET DECODE = 'YYYNNNNNNNN' WHERE CODE_TYPE = 'CCPSCLED' AND CODE = '05';

-- change STGAP00006830
INSERT INTO CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES 
(60380, 'MSG_SAVE_COPIED_INVOICE', 'You must save the copied invoice before updating the line item information.', 700, 500, 'N');


-- change STGAP00006821 
INSERT INTO CAPS.MESSAGE
(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) 
VALUES 
(60379, 'MSG_NOT_AUTH_TO_APPROVE', 'The selected staff member is not authorized to approve tasks.', 700, 500, 'N');


--change STGAP00006804 
INSERT INTO CAPS.CODES_TABLES (code_type, code, DECODE, dt_last_update) 
VALUES ('CSECATTR', 'PC', 'Authorized to Approve', SYSDATE);


-- change STGAP00006803 

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'CASE_MANAGER'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACT_LEAD'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'CONTRACTED_CBO'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'COUNTY_MGMNT'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'DJJ_AFCARS'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'DPTY_CNTY_DRCTR'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'FSCL_SVC_ST_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_01'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_02'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_03'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_04'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_05'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_06'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_07'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_08'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_09'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_10'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_11'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_12'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_13'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_14'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_15'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_16'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_17'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MAINTAIN_REG_99'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'MED_BILL_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'MED_BILL_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'MES_PROG_ASST'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_ACCT_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_ACCT_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'REGNL_SS_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'REG_FAM_IND_MGT'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'REG_FAM_IND_STF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'RSRC_DVLPR'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'SHINES_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '0'
WHERE CD_SECURITY_CLASS_NAME = 'SS_ADMIN_STAFF'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'STATE_OFC_CONS'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'STATE_OFC_MGMT'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'SUPERVISOR'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'SYS_ADMIN'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;

UPDATE CAPS.SECURITY_CLASS 
SET TXT_SECURITY_CLASS_PROFIL = TXT_SECURITY_CLASS_PROFIL || '1'
WHERE CD_SECURITY_CLASS_NAME = 'UNIT_TEAM_LEAD'
and length(TXT_SECURITY_CLASS_PROFIL) = 85;





insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (270, 'SacwisRev2', 'static table updates');                        
commit;

