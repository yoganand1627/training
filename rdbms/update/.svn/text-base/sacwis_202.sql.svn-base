
-- Standard Alter Table SQL

ALTER TABLE CAPS.PERSON ADD TXT_PERSON_ADDL_CMNTS VARCHAR2(300)     NULL
;
ALTER TABLE CAPS.PERSON_HISTORY ADD TXT_PERSON_ADDL_CMNTS VARCHAR2(300)     NULL
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
    CD_SMILE_CLIENT,
    TXT_IDS_NUMBER,
    IND_PREV_ADOPTED,
    IND_PRIVATE,
    IND_PUBLIC,
    IND_INTRNTL,
    CD_ADOPT_STATE,
    CD_ADOPT_COUNTY,
    CD_ADOPT_CNTRY,
    IND_ADOPT_DISLUTON,
    TXT_PERSON_ADDL_CMNTS
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
    :NEW.CD_SMILE_CLIENT,
    :NEW.TXT_IDS_NUMBER,
    :NEW.IND_PREV_ADOPTED,
    :NEW.IND_PRIVATE,
    :NEW.IND_PUBLIC,
    :NEW.IND_INTRNTL,
    :NEW.CD_ADOPT_STATE,
    :NEW.CD_ADOPT_COUNTY,
    :NEW.CD_ADOPT_CNTRY,
    :NEW.IND_ADOPT_DISLUTON,
    :NEW.TXT_PERSON_ADDL_CMNTS);
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
    CD_SMILE_CLIENT,
    TXT_IDS_NUMBER,
    IND_PREV_ADOPTED,
    IND_PRIVATE,
    IND_PUBLIC,
    IND_INTRNTL,
    CD_ADOPT_STATE,
    CD_ADOPT_COUNTY,
    CD_ADOPT_CNTRY,
    IND_ADOPT_DISLUTON,
    TXT_PERSON_ADDL_CMNTS
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
    :NEW.CD_SMILE_CLIENT,
    :NEW.TXT_IDS_NUMBER,
    :NEW.IND_PREV_ADOPTED,
    :NEW.IND_PRIVATE,
    :NEW.IND_PUBLIC,
    :NEW.IND_INTRNTL,
    :NEW.CD_ADOPT_STATE,
    :NEW.CD_ADOPT_COUNTY,
    :NEW.CD_ADOPT_CNTRY,
    :NEW.IND_ADOPT_DISLUTON,
    :NEW.TXT_PERSON_ADDL_CMNTS
    );
   END IF;

  --Must always set this field to NULL regardless what the user enters.
  :NEW.IND_PERS_CANCEL_HIST := NULL;
    --See the bottom of UPDATE trigger below for reason.

END;
/

-- SACWISIFC CHANGES - watch out Charles
-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND DROP CONSTRAINT FK_AG_CUST_PAR_CSUP_REF
;
ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND RENAME TO CHILDSUP_R_07022007184853000
;
CREATE TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND
(
    ID_CHILDSUP_REF_OUTBOUND     NUMBER(16)   NOT NULL,
    DT_LAST_UPDATE               DATE         NOT NULL,
    INTERFACE_STATUS             VARCHAR2(3)  NOT NULL,
    DT_PROCESS                   DATE             NULL,
    CD_ERROR                     VARCHAR2(40)     NULL,
    ID_INITIATOR                 NUMBER(16)   NOT NULL,
    SHINES_LOGON_SHORT           VARCHAR2(8)      NULL,
    DT_CSUP_REQUESTED            DATE             NULL,
    ID_CASE                      NUMBER(16)   NOT NULL,
    ID_STAGE                     NUMBER(16)   NOT NULL,
    ID_CHILD                     NUMBER(16)   NOT NULL,
    NBR_CHILD_CRS_ID             NUMBER(9)    NOT NULL,
    IND_CHILD_PATERNITY_EST      VARCHAR2(1)      NULL,
    NBR_PER_DIEM                 NUMBER(5,2)      NULL,
    NBR_PER_MONTH                NUMBER(5,2)      NULL,
    DT_EFF_PER_DIEM              DATE             NULL,
    IND_CHILD_SUPPORT_ORDER      VARCHAR2(1)      NULL,
    CD_MED_COA                   VARCHAR2(3)      NULL,
    ID_NONCUST_PARENT            NUMBER(16)   NOT NULL,
    NBR_NONCUST_CRS_ID           NUMBER(9)    NOT NULL,
    ADDR_NONCUST_ADDR_ST_LN_1    VARCHAR2(25)     NULL,
    ADDR_NONCUST_ADDR_ST_LN_2    VARCHAR2(25)     NULL,
    ADDR_NONCUST_ADDR_CITY       VARCHAR2(20)     NULL,
    CD_NONCUST_ADDR_STATE        VARCHAR2(2)      NULL,
    ADDR_NONCUST_ADDR_ZIP        VARCHAR2(10)     NULL,
    TXT_INC_RSRC_DESC            VARCHAR2(80)     NULL,
    TXT_INC_RSRC_SRC_ADDR_ST_LN1 VARCHAR2(25)     NULL,
    TXT_INC_RSRC_SRC_ADDR_ST_LN2 VARCHAR2(25)     NULL,
    TXT_INC_RSRC_SRC_ADDR_CITY   VARCHAR2(20)     NULL,
    TXT_INC_RSRC_SRC_ADDR_STATE  VARCHAR2(2)      NULL,
    TXT_INC_RSRC_SRC_ADDR_ZIP    VARCHAR2(10)     NULL,
    IND_SSI_NONCUST              VARCHAR2(1)      NULL,
    CD_NONCUST_MARITAL_STATUS    VARCHAR2(2)      NULL,
    ID_AGENCY_CUSTODIAL_PARENTS  NUMBER(16)   NOT NULL,
    NBR_CUST_CRS_ID              NUMBER(9)        NULL,
    CD_COUNTY                    VARCHAR2(3)      NULL,
    ID_OFFICE                    NUMBER(16)       NULL,
    NM_OFFICE_NAME               VARCHAR2(15)     NULL,
    NM_CASEMANAGER_FIRST         VARCHAR2(12)     NULL,
    NM_CASEMANAGER_MIDDLE        VARCHAR2(12)     NULL,
    NM_CASEMANAGER_LAST          VARCHAR2(22)     NULL,
    NBR_CASEMANAGER_PHONE        VARCHAR2(10)     NULL,
    NBR_CASEMANAGER_FAX          VARCHAR2(10)     NULL,
    ADDR_CASEMAN_ADDR_ST_LN_1    VARCHAR2(25)     NULL,
    ADDR_CASEMAN_ADDR_ST_LN_2    VARCHAR2(25)     NULL,
    ADDR_CASEMAN_ADDR_CITY       VARCHAR2(20)     NULL,
    CD_CASEMAN_ADDR_STATE        VARCHAR2(2)      NULL,
    ADDR_CASEMAN_ADDR_ZIP        VARCHAR2(10)     NULL
)
TABLESPACE DATA01
NOLOGGING
PCTFREE 10
INITRANS 1
MAXTRANS 255
STORAGE(INITIAL 1M
        NEXT 1M
        MINEXTENTS 1
        MAXEXTENTS UNLIMITED
        PCTINCREASE 0
        BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
GRANT DELETE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPS
;
GRANT INSERT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPS
;
GRANT SELECT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPS
;
GRANT UPDATE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPS
;
GRANT DELETE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSBAT
;
GRANT INSERT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSBAT
;
GRANT SELECT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSBAT
;
GRANT UPDATE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSBAT
;
GRANT DELETE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSON
;
GRANT INSERT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSON
;
GRANT UPDATE ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO CAPSON
;
GRANT SELECT ON SACWISIFC.CHILDSUP_REF_OUTBOUND TO OPERATOR
;

-- Add Constraint SQL

ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND ADD CONSTRAINT PK_CHILDSUP_REF
PRIMARY KEY (ID_CHILDSUP_REF_OUTBOUND)
USING INDEX TABLESPACE INDEX01
            PCTFREE 10
            INITRANS 2
            MAXTRANS 255
            STORAGE(INITIAL 1M
                    NEXT 1M
                    MINEXTENTS 1
                    MAXEXTENTS UNLIMITED
                    PCTINCREASE 0
                    BUFFER_POOL DEFAULT)
    LOGGING
    ENABLE
    VALIDATE
;

-- Add Dependencies SQL
/
DROP TRIGGER SACWISIFC.TIBR_CHILDSUP_REF_OUTBOUND
/
/
CREATE OR REPLACE TRIGGER SACWISIFC.TIBR_CHILDSUP_REF_OUTBOUND
BEFORE INSERT
ON SACWISIFC.CHILDSUP_REF_OUTBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  dummy    NUMBER;
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
  IF (:NEW.ID_CHILDSUP_REF_OUTBOUND IS NULL OR :new.ID_CHILDSUP_REF_OUTBOUND = 0) THEN
    SELECT  SEQ_CHILDSUP_REF_OUTBOUND.NEXTVAL
    INTO  dummy
    FROM  DUAL;
    :new.ID_CHILDSUP_REF_OUTBOUND := dummy;
  END IF;
END; 
-- END PL/SQL BLOCK (do not remove this line) ----------------------------------
/
/
DROP TRIGGER SACWISIFC.TUBR_CHILDSUP_REF_OUTBOUND
/
/
CREATE OR REPLACE TRIGGER SACWISIFC.TUBR_CHILDSUP_REF_OUTBOUND
BEFORE UPDATE
ON SACWISIFC.CHILDSUP_REF_OUTBOUND
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END; 
-- END PL/SQL BLOCK (do not remove this line) ----------------------------------
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE SACWISIFC.CHILDSUP_REF_OUTBOUND ADD CONSTRAINT FK_AG_CUST_PAR_CSUP_REF
FOREIGN KEY (ID_AGENCY_CUSTODIAL_PARENTS)
REFERENCES SACWISIFC.AGENCY_CUSTODIAL_PARENTS (ID_AGENCY_CUSTODIAL_PARENTS)
ENABLE
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003721

UPDATE CAPS.METAPHOR SET txt_tab = 'Child Plan for<br>Case' WHERE id_tab = 230;
UPDATE CAPS.METAPHOR SET txt_tab = 'Needs and<br> Outcomes' WHERE id_tab = 1480;
UPDATE CAPS.METAPHOR SET txt_tab = 'Team<br>Meeting/Reviews' WHERE id_tab = 960;
UPDATE CAPS.METAPHOR SET txt_tab = 'Visitation<br>Plan' WHERE id_tab = 1390;
UPDATE CAPS.METAPHOR SET txt_tab = 'Visitation Plan for<br>Case' WHERE id_tab = 1395;
UPDATE CAPS.METAPHOR SET txt_tab = 'WTLP for<br>Case' WHERE id_tab = 1486;

-- change STGAP00003723
UPDATE CAPS.MESSAGE SET txt_message = 'Warning - there is no approved CCFA assessment for this child. To continue without CCFA assessment, click Save and Submit again.' 
WHERE txt_message_name = 'MSG_NO_CCFA_REL_SUB' AND NBR_MESSAGE=60249;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (203, 'SacwisRev2', 'static updates, SACWISIFC changes, add field to PERSON'); 

commit;
