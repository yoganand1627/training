/
create or replace TRIGGER CAPS.TIBR_UNIT_EMP_LINK
BEFORE INSERT
ON CAPS.UNIT_EMP_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        dummy           NUMBER;
        ---
        --- GRD New dummies for EMPLOYEE denormalization
        ---
        dummy2          VARCHAR2(2);
        dummy3          VARCHAR2(3);
        zNM_PERSON_FIRST      PERSON.NM_PERSON_FIRST%TYPE;

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
        IF (:new.ID_UNIT_EMP_LINK = 0) THEN
                SELECT  SEQ_UNIT_EMP_LINK.NEXTVAL
                INTO    dummy
                FROM    DUAL;
                :new.ID_UNIT_EMP_LINK := dummy;
        END IF;
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
/
create or replace TRIGGER CAPS.TUBR_UNIT_EMP_LINK
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

-- change STGAP00005763

insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60368, 'MSG_NM_MULTIPLE_ACTN_ERR', 'Please select only one of either Primary or Invalid checkbox for this action', 500, 700, 'N');
insert into CAPS.MESSAGE(NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) values (60367, 'MSG_NM_INVALID_PRIMARY_ERR', 'Name cannot be marked as invalid, at least one row must be primary.  Please add a new primary row before marking this one as invalid.', 500, 700, 'N');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (247, 'SacwisRev2', 'static table updates');                                    
commit;


