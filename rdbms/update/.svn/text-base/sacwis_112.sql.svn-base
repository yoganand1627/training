
-- Standard Alter Table SQL

ALTER TABLE CAPS.PERSON ADD CD_SMILE_CLIENT VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD CD_SMILE_CLIENT VARCHAR2(3)     NULL
;

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
    TXT_PERS_HIST_OTHER_RELATIONS,
    CD_SMILE_CLIENT
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
    :NEW.TXT_PERSON_OTHER_RELATIONSHIPS,
    :NEW.CD_SMILE_CLIENT);
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
    TXT_PERS_HIST_OTHER_RELATIONS,
    CD_SMILE_CLIENT
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
    :NEW.TXT_PERSON_OTHER_RELATIONSHIPS,
    :NEW.CD_SMILE_CLIENT);
   END IF;

  --Must always set this field to NULL regardless what the user enters.
  :NEW.IND_PERS_CANCEL_HIST := NULL;
    --See the bottom of UPDATE trigger below for reason.

END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change 207

UPDATE caps.codes_tables 
SET DECODE='Adult in Household' 
WHERE CODE='CCT' 
and code_type = 'CCHRTCAT';

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (113, 'SacwisRev2', 'Add new field to PERSON and PERSON_HISTORY for SMILE');

commit;                         

