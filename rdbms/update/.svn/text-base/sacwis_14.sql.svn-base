
-- Standard Alter Table SQL

ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_SUFFIX VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_TITLE VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_PERS_HIST_MATCH_TYPE VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD TXT_PERS_HIST_OTHER_RELATIONS VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.RELATIONSHIP DROP UNIQUE (ID_PERSON, ID_RELATED_PERSON) DROP INDEX
;

-- Alter Index SQL

CREATE INDEX CAPS.IND_RELATIONSHIP
    ON CAPS.RELATIONSHIP(ID_PERSON,ID_RELATED_PERSON)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;
CREATE INDEX CAPS.IND_WORKLOAD_4
    ON CAPS.WORKLOAD(ID_WKLD_PERSON,ID_WKLD_UNIT,CD_WKLD_STAGE_PERS_ROLE,CD_WKLD_STAGE)
TABLESPACE INDEX01
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Alter Procedure SQL
/
CREATE OR REPLACE PROCEDURE CAPS.UPDATE_WORKLOAD_COUNTS(xID_PERSON NUMBER, xID_UNIT NUMBER)
AS

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
  WHERE id_wkld_person=xID_PERSON AND id_wkld_unit=xID_UNIT AND cd_wkld_stage_pers_role='PR'
  GROUP BY cd_wkld_stage;

r_get_stage_counts c_get_stage_counts%ROWTYPE;

BEGIN

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
  
--  dbms_output.put_line('Intake count: ' || to_char(v_cntr_int));
--  dbms_output.put_line('Investigation count: ' || to_char(v_cntr_inv));
--  dbms_output.put_line('DIV count: ' || to_char(v_cntr_div));
--  dbms_output.put_line('ONG count: ' || to_char(v_cntr_ong));
--  dbms_output.put_line('FC count: ' || to_char(v_cntr_fc));
--  dbms_output.put_line('ADO count: ' || to_char(v_cntr_ado));
--  dbms_output.put_line('PAD count: ' || to_char(v_cntr_pad));
--  dbms_output.put_line('RD count: ' || to_char(v_cntr_rd));
  
  update unit_emp_link set nbr_int = v_cntr_int, nbr_inv = v_cntr_inv,
  nbr_div = v_cntr_div, nbr_ong = v_cntr_ong, nbr_fc = v_cntr_fc,
  nbr_ado = v_cntr_ado, nbr_pad = v_cntr_pad, nbr_rd = v_cntr_rd
  where id_person = xID_PERSON and id_unit=xID_UNIT;
  

EXCEPTION
   WHEN OTHERS THEN RAISE;
      
END UPDATE_WORKLOAD_COUNTS;
/

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_PERSON
BEFORE UPDATE
ON CAPS.PERSON
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  --------------------------------------------------------------------------------------
  -- PURPOSE of UPDATE trigger: for most cases create a record in table PERSON_HISTORY
  --   for every update of PERSON record.  Follow these 3 criteria:
  --
  --   1. if user sets field IND_PERSON_CANCEL_HIST='Y' in UPDATE statement
  --      then do NOT create a record in table PERSON_HISTORY
  --
  --   2. if user sets field IND_PERSON_CANCEL_HIST to NULL or any value other than Y
  --      in UPDATE statement, then create a record in table PERSON_HISTORY
  --
  --   3. If user did NOT set field IND_PERSON_CANCEL_HIST at all (not in UPDATE
  --      stmt) then it is considered a NULL, and hence create a PERSON_HISTORY record
  --
  -- In anyway, field IND_PERSON_CANCEL_HIST will ALWAYS be set to NULL right before
  -- update into table PERSON regardless of what the user specifies.
  --
  -- Mike Bui: Changes 11-JAN-95
  --------------------------------------------------------------------------------------
  dummy2   NUMBER;
  v_ind_input_type person_merge_pending.ind_input_type%TYPE;
        v_id_person person_merge_pending.id_person%TYPE;
        v_id_group person_merge_pending.id_group%TYPE;
BEGIN
   :NEW.DT_LAST_UPDATE := sysdate;
   --insert into table PERSON_HISTORY if field :NEW.IND_PERSON_CANCEL_HIST is not 'Y':
   IF :NEW.IND_PERS_CANCEL_HIST <> 'Y' OR
      :NEW.IND_PERS_CANCEL_HIST IS NULL THEN

  -- 1st: set END DATE of previous record:
  UPDATE PERSON_HISTORY  PH
  SET    PH.DT_PERS_HIST_END    = :NEW.DT_LAST_UPDATE
  WHERE  PH.ID_PERS_HIST_PERSON  = :OLD.ID_PERSON
  AND    DT_PERS_HIST_END = to_date('12/31/4712','MM/DD/YYYY');

  -- 2nd: Insert new record in PERSON_HISTORY:

  -- get next sequence value:
  SELECT SEQ_PERSON_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

  -- (very similar to insert trigger above)
  INSERT  INTO  PERSON_HISTORY  (
    NBR_PERS_HIST_AGE,
    DT_PERS_HIST_DEATH,
    DT_PERS_HIST_BIRTH,
    CD_PERS_HIST_RELIGION,
    CD_PERS_HIST_CHAR,
    CD_PERS_HIST_GUARD_CNSRV,
    CD_PERS_HIST_STATUS,
    CD_PERS_HIST_DEATH,
    CD_PERS_HIST_MARITAL_STAT,
    TXT_PERS_HIST_OCCUPATION,
    IND_PERS_HIST_DOB_APPROX,
    CD_PERS_HIST_LIV_ARR,
    CD_PERS_HIST_LANGUAGE,
    CD_PERS_HIST_SEX,
    NM_PERS_HIST_FULL,
    CD_PERS_HIST_ETHNIC,
    ID_PERS_HIST_PERSON,
    ID_PERSON_HISTORY,
    DT_LAST_UPDATE,
    DT_PERS_HIST_EFFECT,
    DT_PERS_HIST_END,
    CD_DISASTER_RLF,
    TXT_CHAR_CMNTS,
    CD_PERS_HIST_NOT_YET_DIAG,
    IND_PERS_HIST_US_CITIZEN,
    CD_PERS_HIST_IMMG_STATUS,
    CD_PERS_HIST_COUNTRY_ORIGIN,
    CD_PERS_HIST_PROOF_CITIZEN,
    CD_PERS_HIST_SUFFIX,
    CD_PERS_HIST_TITLE,
    CD_PERS_HIST_MATCH_TYPE,
    TXT_PERS_HIST_OTHER_RELATIONS
  )VALUES  (
    :NEW.NBR_PERSON_AGE,
    :NEW.DT_PERSON_DEATH,
    :NEW.DT_PERSON_BIRTH,
    :NEW.CD_PERSON_RELIGION,
    :NEW.CD_PERSON_CHAR,
    :NEW.CD_PERS_GUARD_CNSRV,
    :NEW.CD_PERSON_STATUS,
    :NEW.CD_PERSON_DEATH,
    :NEW.CD_PERSON_MARITAL_STATUS,
    :NEW.TXT_PERSON_OCCUPATION,
    :NEW.IND_PERSON_DOB_APPROX,
    :NEW.CD_PERSON_LIV_ARR,
    :NEW.CD_PERSON_LANGUAGE,
    :NEW.CD_PERSON_SEX,
    :NEW.NM_PERSON_FULL,
    :NEW.CD_PERSON_ETHNIC_GROUP,
    :NEW.ID_PERSON,
    dummy2,
    sysdate,
    :NEW.DT_LAST_UPDATE,
    NULL,
    :NEW.CD_DISASTER_RLF,
    :NEW.TXT_CHAR_CMNTS,
    :NEW.CD_PERS_NOT_YET_DIAG,
    :NEW.IND_PERSON_US_CITIZEN,
    :NEW.CD_PERSON_IMMIGRATION_STATUS,
    :NEW.CD_PERSON_COUNTRY_ORIGIN,
    :NEW.CD_PERSON_PROOF_CITIZENSHIP,
    :NEW.CD_PERSON_SUFFIX,
    :NEW.CD_PERSON_TITLE,
    :NEW.CD_MATCH_TYPE,
    :NEW.TXT_PERSON_OTHER_RELATIONSHIPS);
   END IF;

  --Must always set this field to NULL regardless what the user enters.
  :NEW.IND_PERS_CANCEL_HIST := NULL;
  --Reason: If user specifies this field in the SET clause of UPDATE statement then
  --   :NEW.IND_PERS_CANCEL_HIST = specified value, and
  --   :OLD.IND_PERS_CANCEL_HIST = old value in database.
  --
  --But if user did NOT specify it it the UPDATE state, then
  --   :NEW.IND_PERS_CANCEL_HIST = old value in database, and
  --   :OLD.IND_PERS_CANCEL_HIST = old value in database.
  -- That's righ! both :old and :new value are the same.  This will mess up the IF
  -- statement above because the current value of that record in the database will
  -- determine the path of this IF statement instead of what we really want: if user
  -- did not specify a value for this it should be NULL.  The only way to
  -- guarantee this is to always set this field to NULL.  It is a reasonable action
  -- because the main purpose of this field is determine what to do with table
  -- PERSON_HISTORY.  It has no meaning in table PERSON, therefore it will ALWAYS be
  -- set to NULL in both BEFORE INSERT and BEFORE UPDATE trigger

  BEGIN
                SELECT  id_person, ind_input_type, id_group
                INTO    v_id_person, v_ind_input_type, v_id_group
                FROM    person_merge_pending
                WHERE   id_person=:NEW.id_person;

        EXCEPTION
        WHEN NO_DATA_FOUND THEN
                NULL;
        END;


-- SIR  15787

  IF (  (:OLD.DT_PERSON_BIRTH <> :NEW.DT_PERSON_BIRTH) OR
        (:OLD.DT_PERSON_BIRTH IS NOT NULL AND :NEW.DT_PERSON_BIRTH IS NULL)) THEN

        INSERT INTO adjustment_request
                        (ID_ADJ_REQ,
                        DT_LAST_UPDATE,
                        ID_ADJ_REQ_EVENT,
                        ID_ADJ_REQ_PERSON,
                        ID_CASE,
                        DT_ADJ_REQ_START,
                        DT_ADJ_REQ_END,
                        CD_ADJ_REQ_TYPE)
                        VALUES
                        (0,
                        SYSDATE,
                        NULL,
                        :NEW.ID_PERSON,
                        NULL,
                        :OLD.DT_PERSON_BIRTH,
                        :NEW.DT_PERSON_BIRTH,
                        'PER');

  IF v_id_person is NOT NULL THEN

   BEGIN

  IF v_ind_input_type IS NULL THEN

                        DELETE FROM person_merge_pending
                        WHERE id_person = :NEW.id_person;

         ELSIF v_ind_input_type =1 THEN

      DELETE FROM PERSON_MERGE_PENDING
        WHERE id_group = v_id_group;

  END IF;

                  EXCEPTION
                  WHEN NO_DATA_FOUND THEN
                          NULL;
        END;

  END IF;
    END IF;


  IF v_id_person is NOT NULL THEN

  IF   ((:OLD.NM_PERSON_FIRST <> :NEW.NM_PERSON_FIRST) OR
    (:OLD.NM_PERSON_MIDDLE <> :NEW.NM_PERSON_MIDDLE) OR
    (:OLD.NM_PERSON_LAST <> :NEW.NM_PERSON_LAST) OR
    (:OLD.NM_PERSON_FULL <> :NEW.NM_PERSON_FULL)) THEN

    BEGIN

  IF v_ind_input_type IS NULL THEN

                        DELETE FROM person_merge_pending
                        WHERE id_person = :NEW.id_person;

        ELSIF v_ind_input_type =1 THEN

       DELETE FROM PERSON_MERGE_PENDING
                        WHERE id_group = v_id_group;

  END IF;

                        EXCEPTION
                        WHEN NO_DATA_FOUND THEN
                                NULL;
          END;


  END IF;
  END IF;



END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_PERSON
BEFORE INSERT
ON CAPS.PERSON
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  --------------------------------------------------------------------------------------
  -- PURPOSE of INSERT trigger: for most cases create a record in table PERSON_HISTORY
  --   for every new PERSON record.  Follow these 3 criteria:
  --
  --   1. if user sets field IND_PERSON_CANCEL_HIST='Y' in Insert statement
  --      then do NOT create a record in table PERSON_HISTORY
  --
  --   2. if user sets field IND_PERSON_CANCEL_HIST to NULL or any value other than Y
  --      in Insert statement, then create a record in table PERSON_HISTORY
  --
  --   3. If user did NOT set field IND_PERSON_CANCEL_HIST at all (not in Insert
  --      stmt) then it is considered a NULL, and hence create a PERSON_HISTORY record
  --
  -- In anyway, field IND_PERSON_CANCEL_HIST will ALWAYS be set to NULL right before
  -- insertion into table PERSON regardless of what the user specifies.
  -- See reason for this decision at bottom of next UPDATE trigger.
  --
  -- Mike Bui: Changes on 11-JAN-95
  --------------------------------------------------------------------------------------
  dummy  NUMBER;
  dummy2 NUMBER;
  dummy_date DATE;
BEGIN
  :NEW.DT_LAST_UPDATE := sysdate;
  if :NEW.ID_PERSON=0 then
    SELECT SEQ_PERSON.NEXTVAL INTO dummy  FROM DUAL;
    :NEW.ID_PERSON := dummy;
  end if;

  --insert into table PERSON_HISTORY if field :NEW.IND_PERSON_CANCEL_HIST is not 'Y':
   IF nvl(:NEW.IND_PERS_CANCEL_HIST,' ') <> 'Y' THEN

  -- Get next sequence value:
  SELECT SEQ_PERSON_HISTORY.NEXTVAL INTO dummy2 FROM DUAL;

  INSERT INTO PERSON_HISTORY (
    NBR_PERS_HIST_AGE,
    DT_PERS_HIST_DEATH,
    DT_PERS_HIST_BIRTH,
    CD_PERS_HIST_RELIGION,
    CD_PERS_HIST_CHAR,
    CD_PERS_HIST_GUARD_CNSRV,
    CD_PERS_HIST_STATUS,
    CD_PERS_HIST_DEATH,
    CD_PERS_HIST_MARITAL_STAT,
    TXT_PERS_HIST_OCCUPATION,
    IND_PERS_HIST_DOB_APPROX,
    CD_PERS_HIST_LIV_ARR,
    CD_PERS_HIST_LANGUAGE,
    CD_PERS_HIST_SEX,
    NM_PERS_HIST_FULL,
    CD_PERS_HIST_ETHNIC,
    ID_PERS_HIST_PERSON,
    ID_PERSON_HISTORY,
    DT_LAST_UPDATE,
    DT_PERS_HIST_EFFECT,
    DT_PERS_HIST_END,
    CD_DISASTER_RLF,
    TXT_CHAR_CMNTS,
    CD_PERS_HIST_NOT_YET_DIAG,
    IND_PERS_HIST_US_CITIZEN,
    CD_PERS_HIST_IMMG_STATUS,
    CD_PERS_HIST_COUNTRY_ORIGIN,
    CD_PERS_HIST_PROOF_CITIZEN,
    CD_PERS_HIST_SUFFIX,
    CD_PERS_HIST_TITLE,
    CD_PERS_HIST_MATCH_TYPE,
    TXT_PERS_HIST_OTHER_RELATIONS
  )  VALUES  (
    :NEW.NBR_PERSON_AGE,
    :NEW.DT_PERSON_DEATH,
    :NEW.DT_PERSON_BIRTH,
    :NEW.CD_PERSON_RELIGION,
    :NEW.CD_PERSON_CHAR,
    :NEW.CD_PERS_GUARD_CNSRV,
    :NEW.CD_PERSON_STATUS,
    :NEW.CD_PERSON_DEATH,
    :NEW.CD_PERSON_MARITAL_STATUS,
    :NEW.TXT_PERSON_OCCUPATION,
    :NEW.IND_PERSON_DOB_APPROX,
    :NEW.CD_PERSON_LIV_ARR,
    :NEW.CD_PERSON_LANGUAGE,
    :NEW.CD_PERSON_SEX,
    :NEW.NM_PERSON_FULL,
    :NEW.CD_PERSON_ETHNIC_GROUP,
    :NEW.ID_PERSON,
    dummy2,
    sysdate,
    :NEW.DT_LAST_UPDATE,
    NULL,
    :NEW.CD_DISASTER_RLF,
    :NEW.TXT_CHAR_CMNTS,
    :NEW.CD_PERS_NOT_YET_DIAG,
    :NEW.IND_PERSON_US_CITIZEN,
    :NEW.CD_PERSON_IMMIGRATION_STATUS,
    :NEW.CD_PERSON_COUNTRY_ORIGIN,
    :NEW.CD_PERSON_PROOF_CITIZENSHIP,
    :NEW.CD_PERSON_SUFFIX,
    :NEW.CD_PERSON_TITLE,
    :NEW.CD_MATCH_TYPE,
    :NEW.TXT_PERSON_OTHER_RELATIONSHIPS);
   END IF;

  --Must always set this field to NULL regardless what the user enters.
  :NEW.IND_PERS_CANCEL_HIST := NULL;
    --See the bottom of UPDATE trigger below for reason.

END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STAGE_PERSON_LINK
BEFORE UPDATE OR DELETE
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        xNM_STAGE                     STAGE.NM_STAGE%TYPE;
        xCD_STAGE                     STAGE.CD_STAGE%TYPE;
        xCD_STAGE_CNTY                STAGE.CD_STAGE_CNTY%TYPE;
        xCD_STAGE_TYPE                STAGE.CD_STAGE_TYPE%TYPE;
        xCD_STAGE_REGION              STAGE.CD_STAGE_REGION%TYPE;
        xCD_STAGE_REASON_CLOSED       STAGE.CD_STAGE_REASON_CLOSED%TYPE;
        xCD_STAGE_PROGRAM             STAGE.CD_STAGE_PROGRAM%TYPE;
        xID_UNIT                      UNIT.ID_UNIT%TYPE;
        oldID_UNIT                    UNIT.ID_UNIT%TYPE;
        newID_UNIT                    UNIT.ID_UNIT%TYPE;
        yNBR_UNIT                     UNIT.NBR_UNIT%TYPE;
        zNM_CASE                      CAPS_CASE.NM_CASE%TYPE;
        zIND_CASE_SENSITIVE           CAPS_CASE.IND_CASE_SENSITIVE%TYPE;
        zID_CASE                      CAPS_CASE.ID_CASE%TYPE;
  xID_WKLD_PERSON          WORKLOAD.ID_WKLD_PERSON%TYPE;
  xID_WKLD_CASE          WORKLOAD.ID_WKLD_CASE%TYPE;
  v_ml_user_cntr      NUMBER :=0;
  v_workload_row      workload%rowtype;

BEGIN

    SELECT ID_UNIT
    INTO   newID_UNIT
    FROM   STAGE  S
    WHERE  S.ID_STAGE = :NEW.ID_STAGE;
    
    SELECT ID_UNIT
    INTO   oldID_UNIT
    FROM   STAGE  S
    WHERE  S.ID_STAGE = :OLD.ID_STAGE;

    IF UPDATING
    THEN
           :new.DT_LAST_UPDATE := SYSDATE;

        ---
        --- BSG: Added trigger to populate primary/secondary indicator column
        ---
        ---
        --- KJM  10/03/96:
        ---      Added trigger to update the WORKLOAD table based on the
        ---      stage person role. If the role in the update row is PR or SE,
        ---      update all the associated columns where ID_STAGE = ID_WKLD_STAGE
        ---      and old.ID_PERSON = WKLOAD.ID_WKLD_PERSON.
        ---      If the previous role was PR and the new role
        ---      is HP, then the workload row should be deleted altogether.
        ---      10/21/96
        ---      new ELSE IF to handle when role changes from HP to PR -
        ---      in which case a row must be inserted into workload.
        ---
        --- CGM  3/14/2000:
        ---      Added trigger to update the STAGE_ASSIGN_HISTORY if
        ---      the role in the update row is HP and the previous record
        ---      was a PR.  Additionally, it will insert a new 12/31/4612
        ---      ended record in STAGE_ASSIGN_HISTORY for the HP assignment.
        ---
        --- CGM  3/27/2000:
        ---      Added an addition to the trigger to update STAGE_ASSIGN_HISTORY
        ---      if the id_person in the update row is different than the
        ---      previous record.  Additionally, it will insert a new record
  ---
        --- NGK  7/27/2005:
  ---      SIR 23796 - Added section to insert row into DELETE_WORKLOAD_HIST
  ---      if id_person is APS worker that uses MPS. When APS worker synch,
  ---   the DELETE_WORKLOAD_HIST table would be referred to get a refresh list
  ---      of MPS's workload page.
  ---


            IF (:new.CD_STAGE_PERS_TYPE = 'STF') THEN
               IF ((:old.CD_STAGE_PERS_ROLE = 'PR') AND
                   (:new.CD_STAGE_PERS_ROLE = 'HP')) THEN
                  BEGIN
                      UPDATE STAGE_ASSIGN_HISTORY SSH
                      SET SSH.DT_UNASSGND  = SYSDATE
                      WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
                      AND   SSH.DT_UNASSGND IS NULL
                      AND   SSH.ID_PERSON = :old.ID_PERSON;

                  INSERT INTO STAGE_ASSIGN_HISTORY
             (ID_STG_ASSGN_HSTRY,
              ID_STAGE_PERSON_LINK,
          DT_LST_UPDT,
          ID_STAGE,
          ID_PERSON,
          ID_CASE,
          CD_ROLE,
          DT_ASSGND,
          DT_UNASSGND)
      VALUES  (0,
              :new.ID_STAGE_PERSON_LINK,
              :new.DT_LAST_UPDATE,
              :new.ID_STAGE,
              :new.ID_PERSON,
              :new.ID_CASE,
              :new.CD_STAGE_PERS_ROLE,
              SYSDATE, TO_DATE('12/31/4712','MM/DD/YYYY'));

                  EXCEPTION
                      WHEN OTHERS THEN RAISE;
                  END;

            END IF;
            END IF;

            IF (:new.CD_STAGE_PERS_TYPE = 'STF') THEN
               IF  (:old.ID_PERSON != :new.ID_PERSON) THEN
                   BEGIN
                   UPDATE STAGE_ASSIGN_HISTORY SSH
                   SET SSH.DT_UNASSGND  = SYSDATE
                   WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
                   AND SSH.DT_UNASSGND IS NULL
                   AND SSH.ID_PERSON = :old.ID_PERSON;

                   INSERT INTO STAGE_ASSIGN_HISTORY
                          (ID_STG_ASSGN_HSTRY,
                           ID_STAGE_PERSON_LINK,
                     DT_LST_UPDT,
                     ID_STAGE,
                     ID_PERSON,
                     ID_CASE,
                     CD_ROLE,
                     DT_ASSGND)
                   VALUES  (0,
                          :new.ID_STAGE_PERSON_LINK,
                          :new.DT_LAST_UPDATE,
                          :new.ID_STAGE,
                          :new.ID_PERSON,
                          :new.ID_CASE,
                          :new.CD_STAGE_PERS_ROLE,
                          SYSDATE);

                   EXCEPTION
                   WHEN OTHERS THEN RAISE;
               END;
            END IF;
            END IF;

            IF ( ((:new.CD_STAGE_PERS_ROLE = 'SE') OR
                  (:new.CD_STAGE_PERS_ROLE = 'PR'))
                   AND (:old.CD_STAGE_PERS_ROLE <> 'HP') )
            THEN

               :new.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                IF (  (:new.ID_CASE <> :old.ID_CASE)   OR
                     ( (:old.ID_CASE IS NULL) AND (:new.ID_CASE <> 0)) )
                THEN
                    BEGIN

                    SELECT NM_CASE,
                           IND_CASE_SENSITIVE
                    INTO   zNM_CASE,
                           zIND_CASE_SENSITIVE
                    FROM   CAPS_CASE  C
                    WHERE  C.ID_CASE  = :new.ID_CASE;



                    UPDATE WORKLOAD W
                    SET   W.NM_WKLD_CASE               = zNM_CASE,
                          W.IND_WKLD_CASE_SENSITIVE    = zIND_CASE_SENSITIVE
                    WHERE W.ID_WKLD_STAGE              = :old.ID_STAGE;
                    END;

                 END IF;



                UPDATE  WORKLOAD W
                SET     W.ID_WKLD_PERSON               = :new.ID_PERSON,
                        W.CD_WKLD_STAGE_PERS_ROLE      = :new.CD_STAGE_PERS_ROLE,
                        W.DT_WKLD_STAGE_PERS_LINK      = :new.DT_STAGE_PERS_LINK,
                        W.DT_LAST_UPDATE               = :new.DT_LAST_UPDATE,
                        W.IND_WKLD_STAGE_PERS_NEW      = :new.IND_STAGE_PERS_EMP_NEW,
                        W.ID_WKLD_CASE                 = :new.ID_CASE
                WHERE   W.ID_WKLD_STAGE                = :old.ID_STAGE
                AND     W.ID_WKLD_PERSON               = :old.ID_PERSON;

            END IF;


        ---
        --- When the role changes from PR to HP, then the STAGE
        --- itself has been closed, and should no longer appear
        --- on someone's workload. Delete workload row.
        ---


        IF (  (:old.CD_STAGE_PERS_ROLE = 'PR') AND
              (:new.CD_STAGE_PERS_ROLE = 'HP')    )
        THEN
            DELETE FROM WORKLOAD W
            WHERE  W.ID_WKLD_STAGE  =        :old.ID_STAGE
            AND    W.ID_WKLD_PERSON =        :old.ID_PERSON;

        END IF;

        ---
        --- If a worker has been changed from HP back to Primary
        --- on a stage/home/etc, then a row needs to be inserted
        --- on Workload table - similar code used here as used in
        --- TIBR.     KJM 10/21/96
        ---


        IF (:old.CD_STAGE_PERS_ROLE = 'HP' AND
              (  :new.CD_STAGE_PERS_ROLE = 'PR' OR
                 :new.CD_STAGE_PERS_ROLE = 'SE' )  )
        THEN

            BEGIN

               :new.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                --- Get all the relevant workload data
                --- together, then insert one complete row
                --- into the WORKLOAD table.

                BEGIN
                  SELECT          ID_CASE
                  INTO            :new.ID_CASE
                  FROM            STAGE
                  WHERE           ID_STAGE = :new.ID_STAGE;

                  zID_CASE := :new.ID_CASE;

                EXCEPTION
                    WHEN OTHERS THEN
                        IF SQL%NOTFOUND THEN
                        :new.ID_CASE := NULL;
                        END IF;
                END;

                SELECT CD_STAGE,
                       CD_STAGE_TYPE,
                       ID_UNIT,
                       CD_STAGE_REASON_CLOSED,
                       CD_STAGE_CNTY,
                       NM_STAGE,
                       CD_STAGE_REGION,
                       CD_STAGE_PROGRAM
                INTO   xCD_STAGE,
                       xCD_STAGE_TYPE,
                       xID_UNIT,
                       xCD_STAGE_REASON_CLOSED,
                       xCD_STAGE_CNTY,
                       xNM_STAGE,
                       xCD_STAGE_REGION,
                       xCD_STAGE_PROGRAM
                FROM   STAGE  S
                WHERE  S.ID_STAGE = :new.ID_STAGE;

        ---
        --- Get the unit number based on the id unit.
        ---

                SELECT NBR_UNIT
                INTO   yNBR_UNIT
                FROM   UNIT U
                WHERE  U.ID_UNIT = xID_UNIT;

                IF (zID_CASE <> 0)
                THEN
                    SELECT NM_CASE,
                           IND_CASE_SENSITIVE
                INTO       zNM_CASE,
                           zIND_CASE_SENSITIVE
                FROM       CAPS_CASE C
                WHERE      C.ID_CASE = zID_CASE;

                ELSE
                           zNM_CASE               := NULL;
                           zIND_CASE_SENSITIVE    := NULL;
                END IF;

                INSERT INTO WORKLOAD(ID_WKLD_STAGE,
                                     ID_WKLD_PERSON,
                                     DT_LAST_UPDATE,
                                     ID_WKLD_CASE,
                                     CD_WKLD_STAGE_PERS_ROLE,
                                     DT_WKLD_STAGE_PERS_LINK,
                                     IND_WKLD_STAGE_PERS_NEW,
                                     NM_WKLD_STAGE,
                                     CD_WKLD_STAGE,
                                     CD_WKLD_STAGE_CNTY,
                                     CD_WKLD_STAGE_TYPE,
                                     CD_WKLD_STAGE_REGION,
                                     CD_WKLD_STAGE_RSN_CLS,
                                     CD_WKLD_STAGE_PROGRAM,
                                     ID_WKLD_UNIT,
                                     NBR_WKLD_UNIT,
                                     NM_WKLD_CASE,
                                     IND_WKLD_CASE_SENSITIVE
                                     )
                VALUES(:new.ID_STAGE,
                                     :new.ID_PERSON,
                                     :new.DT_LAST_UPDATE,
                                     zID_CASE,
                                     :new.CD_STAGE_PERS_ROLE,
                                     :new.DT_STAGE_PERS_LINK,
                                     :new.IND_STAGE_PERS_EMP_NEW,
                                     xNM_STAGE,
                                     xCD_STAGE,
                                     xCD_STAGE_CNTY,
                                     xCD_STAGE_TYPE,
                                     xCD_STAGE_REGION,
                                     xCD_STAGE_REASON_CLOSED,
                                     xCD_STAGE_PROGRAM,
                                     xID_UNIT,
                                     yNBR_UNIT,
                                     zNM_CASE,
                                     zIND_CASE_SENSITIVE);

            END;

        END IF;

    ELSIF DELETING

        THEN

        --- :new.DT_LAST_UPDATE := SYSDATE;

    IF :OLD.ID_CASE IS NOT NULL THEN
  BEGIN
    SELECT ID_WKLD_PERSON, ID_WKLD_CASE
    INTO xID_WKLD_PERSON, xID_WKLD_CASE
    FROM WORKLOAD
    WHERE ID_WKLD_STAGE = :OLD.ID_STAGE
    AND CD_WKLD_STAGE IN ('INV','SVC')
    AND CD_WKLD_STAGE_PERS_ROLE = 'PR'
    AND CD_WKLD_STAGE_PROGRAM = 'APS';
  EXCEPTION
  WHEN OTHERS THEN
  NULL;
  END;
  IF (xID_WKLD_PERSON IS NOT NULL AND xID_WKLD_CASE IS NOT NULL) THEN


  INSERT INTO DELETE_CASE_HIST
    (
    ID_DELETE_CASE_HIST,
    DT_LAST_UPDATE,
    TABLE_NAME,
    PK_COLUMN_NAME,
    PK_VALUE,
    ID_CASE,
    ID_PERSON
    )
    VALUES
    (
    NULL,
    NULL,
    'STAGE_PERSON_LINK',
    'ID_STAGE_PERSON_LINK',
    :OLD.ID_STAGE_PERSON_LINK,
    xID_WKLD_CASE,
    xID_WKLD_PERSON
    );
   END IF;

    END IF;

        --- If not updating, then deleting. On a delete, if the ROLE is "SE"
        --- or 'PR' then delete from the WORKLOAD table
        --- where ID_WKLD_STAGE = ID_STAGE and ID_WKLD_PERSON = ID_PERSON
        --- (unique key on WORKLOAD table).
        ---

        ---
        --- Additionally, upon delete, if the TYPE is "STF" then
        --- update the STAGE_ASSIGN_HISTORY table setting the
        --- DT_STAGE_PERS_UNASSIGNED to SYSDATE (today's date)
        ---

        IF (:old.CD_STAGE_PERS_TYPE = 'STF') THEN
            BEGIN
            UPDATE STAGE_ASSIGN_HISTORY SSH
            SET SSH.DT_UNASSGND  = SYSDATE
            WHERE SSH.ID_STAGE_PERSON_LINK = :old.ID_STAGE_PERSON_LINK
            AND SSH.ID_PERSON =  :old.ID_PERSON
            AND SSH.DT_UNASSGND is null;

            EXCEPTION
               WHEN OTHERS THEN RAISE;
            END;

        END IF;



        IF ( (:old.CD_STAGE_PERS_ROLE = 'SE') OR
             (:old.CD_STAGE_PERS_ROLE = 'PR') )
        THEN

            BEGIN
            DELETE FROM WORKLOAD W
            WHERE  W.ID_WKLD_STAGE         = :old.ID_STAGE
            AND    W.ID_WKLD_PERSON        = :old.ID_PERSON;

            EXCEPTION
               WHEN OTHERS THEN RAISE;
            END;

        END IF;

    END IF;

    --- This is the end if associated with the IF/THEN at the top
    --- of trigger where it says "IF UPDATING"
    
    IF ( (:old.ID_PERSON IS NOT NULL) AND (:old.ID_PERSON <> 0) )
    THEN
        UPDATE_WORKLOAD_COUNTS(:old.ID_PERSON, oldID_UNIT);
    END IF;
    
    IF ( (:new.ID_PERSON IS NOT NULL) AND (:new.ID_PERSON <> 0) )
    THEN
        UPDATE_WORKLOAD_COUNTS(:new.ID_PERSON, newID_UNIT);
    END IF;

END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STAGE_PERSON_LINK
BEFORE INSERT
ON CAPS.STAGE_PERSON_LINK
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        dummy                       NUMBER;
        xNM_STAGE                   VARCHAR2(25);
        xCD_STAGE                   VARCHAR2(3);
        xCD_STAGE_CNTY              VARCHAR2(3);
        xCD_STAGE_TYPE              VARCHAR2(5);
        xCD_STAGE_REGION            VARCHAR2(2);
        xCD_STAGE_REASON_CLOSED     VARCHAR2(3);
        xCD_STAGE_PROGRAM           VARCHAR2(3);
        xID_UNIT                    NUMBER(16);
        yNBR_UNIT                   VARCHAR2(2);
        zNM_CASE                    VARCHAR2(25);
        zIND_CASE_SENSITIVE         VARCHAR2(1);
        zID_CASE                    NUMBER(16);

BEGIN
        :NEW.DT_LAST_UPDATE := SYSDATE;

        ---
        --- BSG: Added trigger to populate primary/secondary indicator column
        ---
        --- KJM: Added to this trigger code to write to the WORKLOAD table.
        ---

        IF (:NEW.ID_STAGE_PERSON_LINK = 0) THEN
                SELECT  SEQ_STAGE_PERSON_LINK.NEXTVAL
                INTO    dummy
                FROM    DUAL;
                :NEW.ID_STAGE_PERSON_LINK := dummy;
        END IF;

   BEGIN

        SELECT          ID_CASE
        INTO            :NEW.ID_CASE
        FROM            STAGE
        WHERE           ID_STAGE = :NEW.ID_STAGE;

        zID_CASE := :NEW.ID_CASE;

    EXCEPTION
        WHEN OTHERS THEN
                IF SQL%NOTFOUND THEN
                        :NEW.ID_CASE := NULL;
                END IF;
    END;

        --- mitschcg - 3/6/2000
        --- added a history table of all staff assignments
        --- to a particular stage for reporting purposes

    IF (:NEW.CD_STAGE_PERS_TYPE = 'STF')    THEN
               INSERT INTO STAGE_ASSIGN_HISTORY
                      (ID_STG_ASSGN_HSTRY,
                       ID_STAGE_PERSON_LINK,
	                   DT_LST_UPDT,
	                   ID_STAGE,
	                   ID_PERSON,
	                   ID_CASE,
	                   CD_ROLE,
	                   DT_ASSGND)
              VALUES  (0,
                       :NEW.ID_STAGE_PERSON_LINK,
                       :NEW.DT_LAST_UPDATE,
                       :NEW.ID_STAGE,
                       :NEW.ID_PERSON,
                       :NEW.ID_CASE,
                       :NEW.CD_STAGE_PERS_ROLE,
                       :NEW.DT_STAGE_PERS_LINK);

    END IF;


    IF ((:NEW.CD_STAGE_PERS_ROLE = 'SE') OR
            (:NEW.CD_STAGE_PERS_ROLE = 'PR'))
    THEN

                :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'Y';

                --- Get all the relevant workload data
                --- together, then insert one complete row
                --- into the WORKLOAD table.

                BEGIN

                  SELECT CD_STAGE,
                       CD_STAGE_TYPE,
                       ID_UNIT,
                       CD_STAGE_REASON_CLOSED,
                       CD_STAGE_CNTY,
                       NM_STAGE,
                       CD_STAGE_REGION,
                       CD_STAGE_PROGRAM
                  INTO   xCD_STAGE,
                       xCD_STAGE_TYPE,
                       xID_UNIT,
                       xCD_STAGE_REASON_CLOSED,
                       xCD_STAGE_CNTY,
                       xNM_STAGE,
                       xCD_STAGE_REGION,
                       xCD_STAGE_PROGRAM
                   FROM   STAGE  S
                   WHERE  S.ID_STAGE = :NEW.ID_STAGE;

                    --- If no row is found, this is an error

                   END;
        ---
        --- Get the unit number based on the id unit.
        ---

        SELECT NBR_UNIT
                INTO   yNBR_UNIT
                FROM   UNIT U
                WHERE  U.ID_UNIT = xID_UNIT;

        IF (zID_CASE <> 0)
          THEN
             SELECT NM_CASE,
                    IND_CASE_SENSITIVE
             INTO   zNM_CASE,
                    zIND_CASE_SENSITIVE
             FROM   CAPS_CASE C
             WHERE  C.ID_CASE = zID_CASE;
          ELSE
             zNM_CASE               := NULL;
             zIND_CASE_SENSITIVE    := NULL;

          END IF;


        INSERT INTO WORKLOAD(ID_WKLD_STAGE,
                                     ID_WKLD_PERSON,
                                     DT_LAST_UPDATE,
                                     ID_WKLD_CASE,
                                     CD_WKLD_STAGE_PERS_ROLE,
                                     DT_WKLD_STAGE_PERS_LINK,
                                     IND_WKLD_STAGE_PERS_NEW,
                                     NM_WKLD_STAGE,
                                     CD_WKLD_STAGE,
                                     CD_WKLD_STAGE_CNTY,
                                     CD_WKLD_STAGE_TYPE,
                                     CD_WKLD_STAGE_REGION,
                                     CD_WKLD_STAGE_RSN_CLS,
                                     CD_WKLD_STAGE_PROGRAM,
                                     ID_WKLD_UNIT,
                                     NBR_WKLD_UNIT,
                                     NM_WKLD_CASE,
                                     IND_WKLD_CASE_SENSITIVE
                                     )
        VALUES(:NEW.ID_STAGE,
                                     :NEW.ID_PERSON,
                                     :NEW.DT_LAST_UPDATE,
                                     zID_CASE,
                                     :NEW.CD_STAGE_PERS_ROLE,
                                     :NEW.DT_STAGE_PERS_LINK,
                                     :NEW.IND_STAGE_PERS_EMP_NEW,
                                     xNM_STAGE,
                                     xCD_STAGE,
                                     xCD_STAGE_CNTY,
                                     xCD_STAGE_TYPE,
                                     xCD_STAGE_REGION,
                                     xCD_STAGE_REASON_CLOSED,
                                     xCD_STAGE_PROGRAM,
                                     xID_UNIT,
                                     yNBR_UNIT,
                                     zNM_CASE,
                                     zIND_CASE_SENSITIVE);

        UPDATE_WORKLOAD_COUNTS(:NEW.ID_PERSON, xID_UNIT);

     ELSE
            :NEW.IND_STAGE_PERS_PR_SEC_ASGN := 'N';
     END IF;

EXCEPTION
WHEN OTHERS THEN RAISE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 38

UPDATE CAPS.UNIT 
SET CD_COUNTY=121 
WHERE ID_PERSON=4466 AND NBR_UNIT=78;

UPDATE CAPS.UNIT 
SET CD_COUNTY='001' 
WHERE ID_PERSON=1988 AND NBR_UNIT=36;

-- change 39
UPDATE CAPS.MESSAGE 
SET TXT_MESSAGE='No Unit exists for the County-Region/Division-Unit combination entered.' 
WHERE NBR_MESSAGE=2008;

-- change 43
UPDATE CAPS.TASK 
SET ind_task_code_prefer = 3 
WHERE cd_task = 2280; 

UPDATE CAPS.TASK 
SET ind_task_code_prefer = 2 
WHERE cd_task = 2285; 

DELETE FROM CAPS.TASK 
WHERE cd_task = 2300; 

DELETE FROM CAPS.TASK 
WHERE cd_task = 2210; 

DELETE FROM CAPS.TASK 
WHERE cd_task = 2290; 

UPDATE CAPS.METAPHOR 
SET txt_tab_url = '/workload/EventSearch/displayEventList' 
WHERE id_tab = 1180;

-- change 40
/
declare
   v_id_person       varchar2(16) ;
   v_id_unit         varchar2(16) ;
cursor all_emp_unit_cursor is
  select id_person, id_unit FROM CAPS.UNIT_EMP_LINK;
begin

 

for all_emp_unit_rec in all_emp_unit_cursor loop
                v_id_person := all_emp_unit_rec.id_person;
                v_id_unit := all_emp_unit_rec.id_unit;
  UPDATE CAPS.UNIT_EMP_LINK

 

SET NBR_INT = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person 

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'INT'),

      NBR_INV = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'INV'),

      NBR_DIV = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'DIV'),

      NBR_ONG = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'FPR'),

      NBR_FC = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'SUB'),

      NBR_ADO = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'ADO'),

      NBR_PAD = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'PAD'),

      NBR_RD = (SELECT COUNT(*) FROM CAPS.WORKLOAD

      WHERE id_wkld_person = v_id_person

      AND id_wkld_unit = v_id_unit

      AND cd_wkld_stage = 'FAD') 

WHERE id_person = v_id_person

AND id_unit = v_id_unit ;
 end loop;

end;
/

--change 45
UPDATE caps.codes_tables 
SET DECODE = 'Physical health (medical and dental, i.e., Medicaid, PeachCare for Kids, local health resources, etc.' 
WHERE code_type = 'CSRCKLST' 
AND code = 210; 

UPDATE caps.codes_tables 
SET DECODE = 'Runaway shelter or services, Youth Hotline or Runaway Hotline, etc.' 
WHERE code_type = 'CSRCKLST' 
AND code = 200;

--change 46
insert into caps.message (nbr_message,txt_message_name,txt_message) 
values (60047,'MSG_CSE_SRCH_CM_LAST_NM_ID_REQ','If Assigned Date is entered, Case Manager''s Last name and /or Case Manager''s ID is required to perform the search');

insert into caps.message (nbr_message,txt_message_name,txt_message) 
values (60048,'MSG_CSE_SRCH_UNIT_LAST_NM_REQ','If Unit is entered, Case''s Last name is required to perform the search');

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (15, 'SacwisRev1', 'Remove Unique Constraint on RELATIONSHIPS, compute unit_emp_links data, misc updates');
                         
commit;
