-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.EXT_DOCUMENTATION DROP CONSTRAINT FK_EXT_DOCUMENTATION_CASE
;
ALTER TABLE CAPS.EXT_DOCUMENTATION DROP PRIMARY KEY DROP INDEX
;
DROP INDEX CAPS.IND_EXT_DOCUMENTATION_1
;
ALTER TABLE CAPS.EXT_DOCUMENTATION RENAME TO EXT_DOCUME_07112007203052000
;
CREATE TABLE CAPS.EXT_DOCUMENTATION
(
    ID_EXT_DOCUMENTATION NUMBER(16)    NOT NULL,
    DT_LAST_UPDATE       DATE          NOT NULL,
    ID_CASE              NUMBER(16)    NOT NULL,
    DT_EXT_DOC_OBTAINED  DATE              NULL,
    TXT_EXT_DOC_DETAILS  VARCHAR2(300)     NULL,
    CD_EXT_DOC_TYPE      VARCHAR2(2)       NULL,
    TXT_EXT_DOC_LOCATION VARCHAR2(80)      NULL,
    CD_EXT_DOC_SORT      VARCHAR2(2)       NULL,
    IND_EXT_DOC_SIGNED   VARCHAR2(1)       NULL,
    DT_EXT_DOC_UPLOADED  DATE              NULL,
    BL_EXT_DOC           BLOB              NULL,
    TXT_FILE_NAME        VARCHAR2(300)     NULL,
    TXT_FORMAT_TYPE      VARCHAR2(80)      NULL
)
LOB(BL_EXT_DOC) STORE AS 
(
    TABLESPACE DATA01
    ENABLE STORAGE IN ROW
    NOCACHE
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
GRANT DELETE ON CAPS.EXT_DOCUMENTATION TO CAPSBAT
;
GRANT INSERT ON CAPS.EXT_DOCUMENTATION TO CAPSBAT
;
GRANT SELECT ON CAPS.EXT_DOCUMENTATION TO CAPSBAT
;
GRANT UPDATE ON CAPS.EXT_DOCUMENTATION TO CAPSBAT
;
GRANT DELETE ON CAPS.EXT_DOCUMENTATION TO CAPSON
;
GRANT INSERT ON CAPS.EXT_DOCUMENTATION TO CAPSON
;
GRANT SELECT ON CAPS.EXT_DOCUMENTATION TO CAPSON
;
GRANT UPDATE ON CAPS.EXT_DOCUMENTATION TO CAPSON
;
GRANT SELECT ON CAPS.EXT_DOCUMENTATION TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.EXT_DOCUMENTATION(
                                   ID_EXT_DOCUMENTATION,
                                   DT_LAST_UPDATE,
                                   ID_CASE,
                                   DT_EXT_DOC_OBTAINED,
                                   TXT_EXT_DOC_DETAILS,
                                   CD_EXT_DOC_TYPE,
                                   TXT_EXT_DOC_LOCATION,
                                   CD_EXT_DOC_SORT,
                                   IND_EXT_DOC_SIGNED,
                                   DT_EXT_DOC_UPLOADED,
                                   BL_EXT_DOC,
                                   TXT_FILE_NAME,
                                   TXT_FORMAT_TYPE
                                  )
                            SELECT 
                                   ID_EXT_DOCUMENTATION,
                                   DT_LAST_UPDATE,
                                   ID_CASE,
                                   DT_EXT_DOC_OBTAINED,
                                   TXT_EXT_DOC_DETAILS,
                                   CD_EXT_DOC_TYPE,
                                   TXT_EXT_DOC_LOCATION,
                                   CD_EXT_DOC_SORT,
                                   IND_EXT_DOC_SIGNED,
                                   DT_EXT_DOC_UPLOADED,
                                   TXT_EXT_DOC,
                                   TXT_FILE_NAME,
                                   TXT_FORMAT_TYPE
                              FROM CAPS.EXT_DOCUME_07112007203052000 
;
COMMIT
;
ALTER TABLE CAPS.EXT_DOCUMENTATION LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.EXT_DOCUMENTATION ADD CONSTRAINT PK_EXT_DOCUMENTATION
PRIMARY KEY (ID_EXT_DOCUMENTATION)
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

-- Add Indexes SQL

CREATE INDEX CAPS.IND_EXT_DOCUMENTATION_1
    ON CAPS.EXT_DOCUMENTATION(ID_CASE)
TABLESPACE INDEX01
LOGGING
PCTFREE 10
INITRANS 2
MAXTRANS 255
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCOMPRESS
;

-- Add Dependencies SQL

DROP TRIGGER CAPS.TIBR_EXT_DOCUMENTATION;
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EXT_DOCUMENTATION
BEFORE INSERT
ON CAPS.EXT_DOCUMENTATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
	IF (:new.ID_EXT_DOCUMENTATION = 0) THEN
		SELECT	SEQ_EXT_DOCUMENTATION.NEXTVAL
		INTO	dummy
		FROM	DUAL;
		:new.ID_EXT_DOCUMENTATION := dummy;
	END IF;
END;
/
DROP TRIGGER CAPS.TUBR_EXT_DOCUMENTATION;
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_EXT_DOCUMENTATION
BEFORE UPDATE
ON CAPS.EXT_DOCUMENTATION
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
	:new.DT_LAST_UPDATE := SYSDATE;
END;
/

-- Add Referencing Foreign Keys SQL

ALTER TABLE CAPS.EXT_DOCUMENTATION ADD CONSTRAINT FK_EXT_DOCUMENTATION_CASE
FOREIGN KEY (ID_CASE)
REFERENCES CAPS.CAPS_CASE (ID_CASE)
ENABLE
;

/
CREATE OR REPLACE PACKAGE CAPS.COMPLEX_DELETE AS

   PROCEDURE DELETE_SUBCARE_EVENT (xID_EVENT NUMBER, xDATE DATE);
      ---------------------------------------------------------------------
      -- PURPOSE: For a given xID_EVENT and xDATE, must delete from these
      --          tables:
      --    TODO
      --    EVENT_PERSON_LINK
      --    EVENT
      ---------------------------------------------------------------------


   PROCEDURE DELETE_EMPLOYEE (xID_PERSON NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: For each EMPLOYEE to be deleted, must delete from these
      --          tables all records having the same ID_PERSON as the input
      --          parameter:
      --    EMP_JOB_HISTORY
      --    EMPLOYEE_SKILL
      --    UNIT_EMP_LINK
      --    EMP_ON_CALL_LINK
      --    EMP_TEMP_ASSIGN
      --    EMPLOYEE
      --    PERSON_CATEGORY
      --    EMP_SEC_CLASS_LINK
      ---------------------------------------------------------------------

   PROCEDURE DELETE_PERSON (xID_PERSON NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: For a xID_PERSON specified delete all the following tables:
      --    RECORDS_CHECK
      --    PERSON_PHONE
      --    PERSON_ID
      --    NAME
      --    PERSON_CATEGORY
      --    PERSON_HISTORY
      --    *SIR 15512*
      --    PERSON_RACE
      --    PERSON_ETHNICITY
      --    *SIR 15512*
      --    *SIR 15787
      --    ADJUSTMENT_REQUEST
      --    *SIR 15787
      --    *SIR 15933
      --    RECORDS_CHECK
      --    INCOME_AND_RESOURCES
      --    PERSON_ELIGIBILITY_DETAIL
      --    PERSON_ELIGIBILITY
      --    *SIR 15933
      --    PERSON_ADDRESS
      --    ADDRESS_PERSON_LINK
      --    *SIR 22637
      --    EDUCATIONAL_HISTORY
      --    FA_INDIV_TRAINING
      --    FIN_ACCT_TRANSACTION
      --    FINANCIAL_ACCOUNT
      --    PERSON_DTL
      --    PERSON_MATCH_REQUEST
      --    CHARACTERISTICS
      --    *SIR 22637
      --    PERSON
      --    *STGAP00003956
      --    PERSON_CITIZENSHIP
      --    MEDICATION
      --    TRIBAL
      ---------------------------------------------------------------------


   PROCEDURE DELETE_INTAKE_PERSON (xID_PERSON NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: For each PERSON to be deleted, must delete these tables
      --          all records having the same ID_PERSON as the input
      --          parameter:
      --    INCOMING_ADDRESS
      --    INCOMING_NAME
      --    INCOMING_PERSON_ID
      --    INCOMING_PHONE
      --    INCOMING_PERSON
      --    PERSON_PHONE
      --    PERSON_ID
      --    NAME
      --    CHARACTERISTICS
      --    PERSON_CATEGORY
      --    PERSON_HISTORY
      --    *SIR 15512*
      --    PERSON_RACE
      --    PERSON_ETHNICITY
      --    *SIR 15512*
      --    *SIR 15787
      --    ADJUSTMENT_REQUEST
      --    *SIR 15787
      --    *SIR 15933
      --    RECORDS_CHECK
      --    INCOME_AND_RESOURCES
      --    PERSON_ELIGIBILITY_DETAIL
      --    PERSON_ELIGIBILITY
      --    *SIR 15933
      --    PERSON_ADDRESS
      --    ADDRESS_PERSON_LINK
      --    *SIR 22637
      --    EDUCATIONAL_HISTORY
      --    FA_INDIV_TRAINING
      --    FIN_ACCT_TRANSACTION
      --    FINANCIAL_ACCOUNT
      --    PERSON_DTL
      --    PERSON_MATCH_REQUEST
      --    *SIR 22637
      --    PERSON
      --        The logic for deleting from PERSON_ADDRESS is a little
      --        complicated:
      --            PERSON -->> ADDRESS_PERSON_LINK -->> PERSON_ADDRESS
      --        If an address is shared by others, do not delete
      --            PERSON_ADDRESS
      --        If an address is NOT shared by other people, then delete
      --            PERSON_ADDRESS
      --        Either case, delete all ADDRESS_PERSON_LINK records
      --    *STGAP00003956
      --    PERSON_CITIZENSHIP
      --    MEDICATION
      --    TRIBAL
      ---------------------------------------------------------------------


   PROCEDURE DELETE_INCOMING_PERSON (xID_PERSON NUMBER, xID_STAGE NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: Delete from the following tables given xID_PERSON and
      --          xID_STAGE:
      --    INCOMING_ADDRESS
      --    INCOMING_NAME
      --    INCOMING_PERSON_ID
      --    *SIR 15512*
      --    PERSON_RACE
      --    PERSON_ETHNICITY
      --    *SIR 15512*
      --    INCOMING_PHONE
      --    INCOMING_PERSON
      ---------------------------------------------------------------------

   PROCEDURE DELETE_INCOMING_DETAIL (xID_STAGE NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: Delete from the following tables given xID_STAGE:
      --    INCOMING_DETAIL
      --    INCOMING_NARRATIVE
      --    INCOMING_FACILITY
      --    INCMG_DETERM_FACTORS
      --    CONTACT_NARRATIVE
      --    CONTACT
      --    EVENT_PERSON_LINK
      --    EVENT
      --    calls DELETE_INCOMING_PERSON()  -- stored procedure
      --    TODO
      --    INTAKE_ALLEGATION
      --    calls DELETE_INTAKE_PERSON()    -- stored procedure
      --    STAGE
      --    SITUATION
      --    CAPS_CASE
      ---------------------------------------------------------------------


   PROCEDURE DELETE_SERVICE_AUTH (xID_SVC_AUTH NUMBER);
      ---------------------------------------------------------------------
      -- PURPOSE: For a given xID_SVC_AUTH, must delete from these tables:
      --    DELVRD_SVC_DTL
      --    FMIS_BREAKOUT
      --    SVC_AUTH_VALID
      --    APS_IN_HOME_TASKS
      --    TODO
      --    EVENT
      --    SVC_AUTH_EVENT_LINK
      --    SVC_AUTH_DETAIL
      --    SERVICE_AUTHORIZATION
      ---------------------------------------------------------------------


END COMPLEX_DELETE;
/
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO CAPSBAT;
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO CAPSON;
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO OPERATOR;

/
CREATE OR REPLACE PACKAGE BODY CAPS.COMPLEX_DELETE AS


---------------------------------------------------------------------------
PROCEDURE DISABLE_CONSTRAINT (xTABLE IN VARCHAR2, xCONSTRAINT IN VARCHAR2) IS
        cur INTEGER;
        ret INTEGER;
        str VARCHAR2(250);
    BEGIN
        --
        -- dynamic SQL (DDL statement)
        --
        str := 'ALTER TABLE ' || xTABLE || ' DISABLE CONSTRAINT ' ||
               xCONSTRAINT ;
        cur := DBMS_SQL.OPEN_CURSOR;
        DBMS_SQL.PARSE (cur, str, dbms_sql.v7);
        ret := DBMS_SQL.EXECUTE (cur);
        DBMS_SQL.CLOSE_CURSOR(cur);
    END DISABLE_CONSTRAINT;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE ENABLE_CONSTRAINT (xTABLE IN VARCHAR2, xCONSTRAINT IN VARCHAR2) IS
        cur INTEGER;
        ret INTEGER;
        str VARCHAR2(250);
    BEGIN
        --
        -- dynamic SQL (DDL statement)
        --
        str := 'ALTER TABLE ' || xTABLE || ' ENABLE CONSTRAINT ' ||
               xCONSTRAINT ;
        cur := DBMS_SQL.OPEN_CURSOR;
        DBMS_SQL.PARSE (cur, str, dbms_sql.v7);
        ret := DBMS_SQL.EXECUTE (cur);
        DBMS_SQL.CLOSE_CURSOR(cur);
    END ENABLE_CONSTRAINT;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DEBUG1 (I NUMBER, BOOL BOOLEAN) IS
    BEGIN
        if BOOL then
            dbms_output.put_line (TO_CHAR(I) || ' BOOL=TRUE');
        else
            dbms_output.put_line (TO_CHAR(I) || ' BOOL=FALSE');
        end if;
    END DEBUG1;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DELETE_EMPLOYEE (xID_PERSON NUMBER) IS
        --
        -- If an EMPLOYEE record is deleted, then all records from the
        -- following tables (with the same ID_PERSON) must also be deleted:
        --    EMP_JOB_HISTORY
        --    EMPLOYEE_SKILL
        --    UNIT_EMP_LINK
        --    EMP_ON_CALL_LINK
        --    EMP_TEMP_ASSIGN
        --    EMPLOYEE
        --    PERSON_CATEGORY
        --    EMP_SEC_CLASS_LINK
        --

    BEGIN
        DELETE EMP_JOB_HISTORY  E WHERE E.ID_PERSON          = xID_PERSON;
        DELETE EMPLOYEE_SKILL   E WHERE E.ID_PERSON          = xID_PERSON;
        DELETE UNIT_EMP_LINK    E WHERE E.ID_PERSON          = xID_PERSON;
        DELETE EMP_ON_CALL_LINK E WHERE E.ID_PERSON          = xID_PERSON;

        DELETE EMP_TEMP_ASSIGN  E WHERE E.ID_PERSON_EMP      = xID_PERSON;
        DELETE EMP_TEMP_ASSIGN  E WHERE E.ID_PERSON_DESIGNEE = xID_PERSON;
        DELETE EMP_SEC_CLASS_LINK E WHERE E.ID_PERSON        = xID_PERSON;

        DELETE EMPLOYEE         E WHERE E.ID_PERSON          = xID_PERSON;


        DELETE PERSON_CATEGORY  P
        WHERE  P.ID_PERSON          =  xID_PERSON
        AND    P.CD_PERSON_CATEGORY IN ('FEM','EMP');

   EXCEPTION
      WHEN OTHERS THEN RAISE;

   END DELETE_EMPLOYEE;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DELETE_PERSON (xID_PERSON NUMBER) IS

    -----------------------------------------------------------------------
    -- PURPOSE: For a xID_PERSON specified delete all the following tables:
    --    RECORDS_CHECK
    --    PERSON_PHONE
    --    PERSON_ID
    --    NAME
    --    PERSON_CATEGORY
    --    PERSON_HISTORY
    --    PERSON_ADDRESS
    --    ADDRESS_PERSON_LINK
      --    *SIR 22637
      --    EDUCATIONAL_HISTORY
      --    FA_INDIV_TRAINING
      --    FIN_ACCT_TRANSACTION
      --    FINANCIAL_ACCOUNT
      --    PERSON_DTL
      --    PERSON_MATCH_REQUEST
      --    *SIR 22637
    --    PERSON
    --
    --    SIR 1058 - *EMP* tables removed because they are redundant to
    --    DELETE_EMPLOYEE().
    -----------------------------------------------------------------------

    --
    -- get list of all addresses for a given person. FOR UPDATE is used
    -- so I can delete these records later.
    --
    -- SIR 11153 - Removed FOR UPDATE and added select of primary key
    -- ID_ADDR_PERSON_LINK
    --
    CURSOR TOTAL_LINKS (xID NUMBER) IS
        SELECT ID_PERSON_ADDR,
               ID_ADDR_PERSON_LINK
        FROM   ADDRESS_PERSON_LINK
        WHERE  ID_PERSON = xID;

    --
    -- Count the total number of people living at a given address.
    --
    CURSOR TOTAL_SHARED_ADDRESSES (xADDR NUMBER) IS
        SELECT COUNT(*)
        FROM   ADDRESS_PERSON_LINK
        WHERE  ID_PERSON_ADDR = xADDR;

    xID_PERSON_ADDR         NUMBER;
    xTOTAL_SHARED_ADDRESSES NUMBER;
    --
    -- SIR 11153 - added xID_ADDR_PERSON_LINK
    --
    xID_ADDR_PERSON_LINK    NUMBER;


    BEGIN

        --
        -- Mike Bui: 11/30/95: No need for these delete commands on these 2
        -- tables since they already have cascade delete constraints on them.
        --
        --      DELETE CRIMINAL_HIST_NARR
        --      WHERE ID_CRIM_HIST IN   (SELECT ID_CRIM_HIST
        --                  FROM    CRIMINAL_HISTORY C, RECORDS_CHECK R
        --                  WHERE   R.ID_REC_CHECK = C.ID_REC_CHECK
        --                  AND R.ID_REC_CHECK_PERSON = xID_PERSON);
        --
        --      DELETE CRIMINAL_HISTORY
        --      WHERE ID_REC_CHECK IN   (SELECT ID_REC_CHECK
        --                  FROM    RECORDS_CHECK R
        --                  WHERE   R.ID_REC_CHECK_PERSON = xID_PERSON);
        --

        DELETE RECORDS_CHECK  WHERE   ID_REC_CHECK_PERSON = xID_PERSON;

        --
        -- SIR 11153 - The code to delete from ADDRESS_PERSON_LINK and
        -- PERSON_ADDRESS has been moved and cleaned up (see below).  In
        -- addition, the following five lines have been reordered to match
        -- DELETE_INTAKE_PERSON() in hopes to avoid database deadlock
        -- problems
        --
        DELETE PERSON_PHONE        WHERE ID_PERSON           = xID_PERSON;
        DELETE PERSON_ID           WHERE ID_PERSON           = xID_PERSON;
        DELETE NAME                WHERE ID_PERSON           = xID_PERSON;
        DELETE PERSON_CATEGORY     WHERE ID_PERSON           = xID_PERSON;
        DELETE PERSON_HISTORY      WHERE ID_PERS_HIST_PERSON = xID_PERSON;

        --
        -- SIR 15512: Delete Person_Race and Person_Ethnicity when deleting
        --            a person
        --
        DELETE PERSON_RACE         WHERE ID_PERSON          = xID_PERSON;
        DELETE PERSON_ETHNICITY    WHERE ID_PERSON          = xID_PERSON;

        --
        -- SIR 15933: Delete from INCOME_AND_RESOURCES,
        -- PERSON_ELIGIBILITY_DETAIL and PERSON_ELIGIBILITY when deleting a person
        --
        DELETE INCOME_AND_RESOURCES WHERE ID_PERSON = xID_PERSON;
        DELETE PERSON_ELIGIBILITY_DETAIL WHERE ID_PERS_ELIG_DTL_PERSON  = xID_PERSON;
        DELETE PERSON_ELIGIBILITY WHERE ID_PERS_ELIG_PERSON = xID_PERSON;
        --
        -- SIR 15787: Delete from Adjustment_Request when deleting a person
        -- Adjustment_request should be deleted after Person_eligibility since
        -- delete trigger on Person_eligibility inserts into Adjustment_request
        -- for any corresponding EA records
        --
        DELETE ADJUSTMENT_REQUEST WHERE ID_ADJ_REQ_PERSON   = xID_PERSON;


        ---------------------------------------------------------------------
        ---------------------------------------------------------------------
        ---------------------------------------------------------------------
        -- THIS PORTION SHOULD BE IDENTICAL TO THE DELETE_INTAKE_PERSON()
        -- PROCEDURE BELOW:
        --
        -- Now delete records from ADDRESS_PERSON_LINK and PERSON_ADDRESS
        --
        -- Criteria: Assume Person P1 has 5 addresses A1..A5 , thus there are
        --           5 links L1..L5
        --      If NO other person are living at these same 5 address A1..A5,
        --          then delete 5 addresses, and 5 links
        --      If another person are living at any of these 5 addresses,
        --      then those addresses that are shared must NOT be deleted;
        --      addresses that are not shared must be deleted. The 5 links
        --      for that Person P1 must be deleted still.
        --
        OPEN TOTAL_LINKS (xID_PERSON);  --total link records for person
            LOOP
                --
                -- SIR 11153 - added xID_ADDR_PERSON_LINK
                --
              FETCH TOTAL_LINKS INTO xID_PERSON_ADDR,
                                     xID_ADDR_PERSON_LINK;
              EXIT WHEN TOTAL_LINKS%NOTFOUND OR TOTAL_LINKS%NOTFOUND IS NULL;

                --
                -- count how many other people are living at the same
                -- addresses:
                --
                OPEN  TOTAL_SHARED_ADDRESSES (xID_PERSON_ADDR);
                   FETCH TOTAL_SHARED_ADDRESSES INTO xTOTAL_SHARED_ADDRESSES;

                CLOSE TOTAL_SHARED_ADDRESSES;

                --
                -- delete this person_address only if no other person is
                -- sharing the same address:
                --
                IF xTOTAL_SHARED_ADDRESSES = 1 THEN
                    DELETE PERSON_ADDRESS
                    WHERE  ID_PERSON_ADDR = xID_PERSON_ADDR;
                END IF;

                --
                -- SIR 11153 - removed CURRENT OF TOTAL_LINKS and replaced
                -- with ID_ADDR_PERSON_LINK = xID_ADDR_PERSON_LINK
                --
                -- delete address_person_link record regardless of how many
                -- people sharing that address:
                --
                DELETE ADDRESS_PERSON_LINK
                WHERE  ID_ADDR_PERSON_LINK = xID_ADDR_PERSON_LINK;
            END LOOP;
        CLOSE TOTAL_LINKS;
        ---------------------------------------------------------------------
        ---------------------------------------------------------------------
        ---------------------------------------------------------------------

	-- SIR 22637
        DELETE EDUCATIONAL_HISTORY WHERE ID_PERSON = xID_PERSON;
        DELETE FA_INDIV_TRAINING WHERE ID_PERSON = xID_PERSON;
        DELETE PERSON_DTL WHERE ID_PERSON = xID_PERSON;
        DELETE PERSON_MATCH_REQUEST WHERE ID_PERS_MATCH_REQ_PERSON = xID_PERSON;
        DELETE FIN_ACCT_TRANSACTION WHERE ID_FIN_ACCT IN (SELECT ID_FIN_ACCT
							FROM FINANCIAL_ACCOUNT
							WHERE ID_PERSON = xID_PERSON);
        DELETE FINANCIAL_ACCOUNT WHERE ID_PERSON = xID_PERSON;
	    DELETE FROM CHARACTERISTICS   WHERE ID_PERSON           = xID_PERSON;
	    --  *STGAP00003956
	    DELETE PERSON_CITIZENSHIP WHERE ID_PERSON = xID_PERSON;
	    DELETE TRIBAL WHERE ID_PERSON = xID_PERSON;
	    DELETE MEDICATION WHERE ID_PERSON = xID_PERSON;
	    
	-- SIR 22637

        DELETE PERSON WHERE ID_PERSON = xID_PERSON;

    END DELETE_PERSON;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DELETE_INTAKE_PERSON (xID_PERSON NUMBER) IS

    --
    -- get INCOMING_PERSON link:
    --
    CURSOR INCMG_PERSON_CURSOR (yID_PERSON NUMBER) IS
        SELECT ID_INCMG_PERSON
        FROM   INCOMING_PERSON
        WHERE  ID_PERSON = yID_PERSON ;

    --
    -- get list of all addresses for a given person.  FOR UPDATE is used so
    -- I can delete these records later.
    --
    -- SIR 11153 - Removed FOR UPDATE and added select of primary key
    -- ID_ADDR_PERSON_LINK
    --
    CURSOR TOTAL_LINKS (xID NUMBER) IS
        SELECT ID_PERSON_ADDR,
               ID_ADDR_PERSON_LINK
        FROM   ADDRESS_PERSON_LINK
        WHERE  ID_PERSON = xID;

    --
    -- Count the total number of people living at a given address.
    --
    CURSOR TOTAL_SHARED_ADDRESSES (xADDR NUMBER) IS
        SELECT COUNT(*)
        FROM   ADDRESS_PERSON_LINK
        WHERE  ID_PERSON_ADDR = xADDR;

    xID_INCMG_PERSON        NUMBER;
    xID_PERSON_ADDR         NUMBER;
    xTOTAL_SHARED_ADDRESSES NUMBER;
    --
    -- SIR 11153 - added xID_ADDR_PERSON_LINK
    --
    xID_ADDR_PERSON_LINK    NUMBER;


    BEGIN

        OPEN  INCMG_PERSON_CURSOR (xID_PERSON);
            FETCH INCMG_PERSON_CURSOR INTO xID_INCMG_PERSON;
            IF    INCMG_PERSON_CURSOR%FOUND THEN

                --
                -- delete from the INCOMING_* tables using xID_INCMG_PERSON
                --
                DELETE FROM INCOMING_ADDRESS
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                DELETE FROM INCOMING_NAME
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                DELETE FROM INCOMING_PERSON_ID
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                DELETE FROM INCOMING_PHONE
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

            END IF;
        CLOSE INCMG_PERSON_CURSOR;

        --
        -- delete from the PERSON_* tables using xID_PERSON
        --
        DELETE FROM INCOMING_PERSON   WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM PERSON_PHONE      WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM PERSON_ID         WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM NAME              WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM CHARACTERISTICS   WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM PERSON_CATEGORY   WHERE ID_PERSON           = xID_PERSON;
        DELETE FROM PERSON_HISTORY    WHERE ID_PERS_HIST_PERSON = xID_PERSON;
        --
        -- SIR 15512: Delete Person_Race and Person_Ethnicity when deleting
        --            a person
        --
        DELETE FROM PERSON_RACE       WHERE ID_PERSON          = xID_PERSON;
        DELETE FROM PERSON_ETHNICITY  WHERE ID_PERSON          = xID_PERSON;

    --
    -- SIR 15933: Delete from RECORDS_CHECK, INCOME_AND_RESOURCES,
    -- PERSON_ELIGIBILITY_DETAIL and PERSON_ELIGIBILITY when deleting a person
    --
    DELETE RECORDS_CHECK  WHERE   ID_REC_CHECK_PERSON = xID_PERSON;
    DELETE INCOME_AND_RESOURCES WHERE ID_PERSON = xID_PERSON;
    DELETE PERSON_ELIGIBILITY_DETAIL WHERE ID_PERS_ELIG_DTL_PERSON  = xID_PERSON;
    DELETE PERSON_ELIGIBILITY WHERE ID_PERS_ELIG_PERSON = xID_PERSON;
    --
    -- SIR 15787: Delete from Adjustment_Request when deleting a person
    DELETE ADJUSTMENT_REQUEST WHERE ID_ADJ_REQ_PERSON   = xID_PERSON;


        ---------------------------------------------------------------------
        ---------------------------------------------------------------------
        ---------------------------------------------------------------------
        -- THIS PORTION SHOULD BE IDENTICAL TO THE DELETE_PERSON()
        -- PROCEDURE ABOVE:
        --
        -- Now delete records from ADDRESS_PERSON_LINK and PERSON_ADDRESS
        --
        -- Criteria: Assume Person P1 has 5 addresses A1..A5 , thus there are
        --           5 links L1..L5
        --      If NO other person are living at these same 5 address A1..A5,
        --          then delete 5 addresses, and 5 links
        --      If another person are living at any of these 5 addresses,
        --          then those addresses that are shared must NOT be deleted;
        --          addresses that are not shared must be deleted.
        --          The 5 links for that Person P1 must be deleted still.

        OPEN TOTAL_LINKS (xID_PERSON);  -- total link records for person
            LOOP
                --
                -- SIR 11153 - added xID_ADDR_PERSON_LINK
                --
              FETCH TOTAL_LINKS INTO xID_PERSON_ADDR,
                                     xID_ADDR_PERSON_LINK;
              EXIT WHEN TOTAL_LINKS%NOTFOUND OR TOTAL_LINKS%NOTFOUND IS NULL;

                --
                -- count how many other people are living at the same
                -- addresses:
                OPEN  TOTAL_SHARED_ADDRESSES (xID_PERSON_ADDR);
                   FETCH TOTAL_SHARED_ADDRESSES INTO xTOTAL_SHARED_ADDRESSES;

                CLOSE TOTAL_SHARED_ADDRESSES;

                --
                -- delete this person_address only if no other person is
                -- sharing the same address:
                --
                IF xTOTAL_SHARED_ADDRESSES = 1 THEN
                    DELETE PERSON_ADDRESS
                    WHERE  ID_PERSON_ADDR = xID_PERSON_ADDR;
                END IF;

                --
                -- SIR 11153 - removed CURRENT OF TOTAL_LINKS and replaced
                -- with ID_ADDR_PERSON_LINK = xID_ADDR_PERSON_LINK
                --
                -- delete address_person_link record regardless of how many
                -- sharing that address:
                --
                DELETE ADDRESS_PERSON_LINK
                WHERE  ID_ADDR_PERSON_LINK = xID_ADDR_PERSON_LINK;

            END LOOP;
        CLOSE TOTAL_LINKS;


        -- SIR 22637
        DELETE EDUCATIONAL_HISTORY WHERE ID_PERSON = xID_PERSON;
        DELETE FA_INDIV_TRAINING WHERE ID_PERSON = xID_PERSON;
        DELETE PERSON_DTL WHERE ID_PERSON = xID_PERSON;
        DELETE PERSON_MATCH_REQUEST WHERE ID_PERS_MATCH_REQ_PERSON = xID_PERSON;
        DELETE FIN_ACCT_TRANSACTION WHERE ID_FIN_ACCT IN (SELECT ID_FIN_ACCT
                                                        FROM FINANCIAL_ACCOUNT
                                                        WHERE ID_PERSON = xID_PERSON);
        DELETE FINANCIAL_ACCOUNT WHERE ID_PERSON = xID_PERSON;
        --  *STGAP00003956
	    DELETE PERSON_CITIZENSHIP WHERE ID_PERSON = xID_PERSON;
	    DELETE TRIBAL WHERE ID_PERSON = xID_PERSON;
	    DELETE MEDICATION WHERE ID_PERSON = xID_PERSON;
        -- SIR 22637

        --
        -- Finally delete PERSON record:
        --
        DELETE PERSON WHERE ID_PERSON = xID_PERSON;

    EXCEPTION
        WHEN OTHERS THEN RAISE;

    END DELETE_INTAKE_PERSON;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DELETE_INCOMING_PERSON (xID_PERSON NUMBER, xID_STAGE NUMBER) IS

    --
    -- (ID_PERSON, ID_STAGE) is a unique key of the INCOMING_PERSON table.
    -- Use them to determine the ID_INCMG_PERSON.
    --
    -- SIR 11153 - removed FOR UPDATE since ID_INCMG_PERSON is unique
    --
    CURSOR INCOMING_PERSON_CURSOR (xID_PERSON NUMBER, xID_STAGE NUMBER) IS
        SELECT ID_INCMG_PERSON
        FROM   INCOMING_PERSON
        WHERE  ID_PERSON = xID_PERSON
        AND    ID_STAGE  = xID_STAGE;

    xID_INCMG_PERSON NUMBER;


    BEGIN
        OPEN  INCOMING_PERSON_CURSOR (xID_PERSON,xID_STAGE);
            FETCH INCOMING_PERSON_CURSOR INTO xID_INCMG_PERSON;

            IF INCOMING_PERSON_CURSOR%FOUND THEN
                DELETE INCOMING_ADDRESS
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                DELETE INCOMING_NAME
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                DELETE INCOMING_PERSON_ID
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                --
                -- SIR 15512: Delete Person_Race and Person_Ethnicity when
                --             deleting a person
                --
                DELETE INCOMING_RACE
                WHERE ID_PERSON  = xID_INCMG_PERSON;

                DELETE INCOMING_ETHNICITY
                WHERE ID_PERSON  = xID_INCMG_PERSON;

                DELETE INCOMING_PHONE
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

                --
                -- SIR 11153 - removed CURRENT OF INCOMING_PERSON_CURSOR and
                -- replaced with ID_INCMG_PERSON = xID_INCMG_PERSON
                --
                DELETE INCOMING_PERSON
                WHERE  ID_INCMG_PERSON = xID_INCMG_PERSON;

            END IF;
        CLOSE INCOMING_PERSON_CURSOR;

    EXCEPTION
        WHEN OTHERS THEN RAISE;

   END DELETE_INCOMING_PERSON;
---------------------------------------------------------------------------


---------------------------------------------------------------------------
PROCEDURE DELETE_INCOMING_DETAIL (xID_STAGE NUMBER) IS


    --
    -- SIR 10674 - Added a cursor to retrieve the ID_CASE prior to deleting
    -- the Stage record. This ID_CASE value will be used to delete a row
    -- from the SITUATION and CAPS_CASE tables. Previously a row was being
    -- deleted from those tables based on the ID_STAGE value.
    --

    --
    -- Get the ID_CASE from the Stage table
    --
    CURSOR GET_CASE_ID (yID_STAGE NUMBER) IS
        SELECT ID_CASE
        FROM   STAGE
        WHERE  ID_STAGE = yID_STAGE;

    --
    -- get all person for this stage:
    --
    -- SIR 11153 - added select of ID_STAGE_PERSON_LINK, removed the
    -- FOR UPDATE, and included the condition
    -- AND CD_STAGE_PERS_TYPE <> 'STF' since we will never delete staff
    -- data.  This will reduce the count from stage_person_link and
    -- event_person_link since a staff person may have more than 10,000
    -- cases
    --
    CURSOR SPL (yID_STAGE NUMBER) IS
        SELECT ID_PERSON,
               ID_STAGE_PERSON_LINK
        FROM   STAGE_PERSON_LINK
        WHERE  ID_STAGE            = yID_STAGE
        AND    CD_STAGE_PERS_TYPE <> 'STF';

        --
        -- how many records of current person that are NOT 'CAS':
        --
        CURSOR PERSON_CATEGORY_CURSOR (yID_PERSON NUMBER) IS
            SELECT COUNT(*)
            FROM   PERSON_CATEGORY
            WHERE  ID_PERSON           = yID_PERSON
            AND    CD_PERSON_CATEGORY <> 'CAS';

        --
        -- how many recors in EPL of current person:
        --
        CURSOR EPL (yID_PERSON NUMBER) IS
            SELECT COUNT(*)
            FROM   EVENT_PERSON_LINK
            WHERE  ID_PERSON = yID_PERSON;

        --
        -- how many others stages current person is in:
        --
        CURSOR SPL_PERSON (yID_PERSON NUMBER, yID_STAGE NUMBER) IS
            SELECT COUNT(*)
            FROM   STAGE_PERSON_LINK
            WHERE  ID_PERSON  = yID_PERSON
            AND    ID_STAGE  <> yID_STAGE;

        xDELETE_PERSON      BOOLEAN;
        xID_PERSON          NUMBER;
        xTOTAL_NON_CAS      NUMBER;
        xTOTAL_EPL          NUMBER;
        xTOTAL_SPL          NUMBER;
        --
        -- SIR 10674 - added xID_CASE
        --
        xID_CASE            NUMBER;
        --
        -- SIR 11153 - added xID_SPL
        --
        xID_SPL             NUMBER;


    BEGIN

        DELETE INCOMING_DETAIL       WHERE ID_STAGE              = xID_STAGE;
        DELETE INCOMING_NARRATIVE    WHERE ID_STAGE              = xID_STAGE;
        DELETE INCOMING_FACILITY     WHERE ID_STAGE              = xID_STAGE;
        DELETE INCMG_DETERM_FACTORS  WHERE ID_INCMG_DETERM_STAGE = xID_STAGE;

        DELETE CONTACT_NARRATIVE
            WHERE ID_EVENT IN
                (SELECT ID_EVENT
                 FROM   CONTACT
                 WHERE  ID_CONTACT_STAGE = xID_STAGE);

        DELETE CONTACT               WHERE ID_CONTACT_STAGE      = xID_STAGE;


        --
        -- SIR 10282, 10295 - Intakes marked for deletion could not be
        -- deleted because there were records on the EVENT_PERSON_LINK table
        -- for events associated with the stage to be deleted. This caused an
        -- integrity constraint when deleting from the EVENT table. The
        -- DELETE below was added to delete all records from the
        -- EVENT_PERSON_LINK for events that will be deleted by the DELETE
        -- statement for the EVENT table.
        --
        DELETE EVENT_PERSON_LINK
            WHERE ID_EVENT IN
                (SELECT ID_EVENT
                 FROM   EVENT
                 WHERE  ID_EVENT_STAGE = xID_STAGE);

        DELETE EVENT    WHERE ID_EVENT_STAGE   = xID_STAGE;

        --
        -- Now attemping to delete from table PERSON: For a given xID_STAGE,
        -- identifies all person (xID_PERSON) associated with this stage,
        -- then delete all related tables.
        -- For table PERSON only delete its record (xID_PERSON) only if the
        -- following 3 conditions are satisfied:
        --   1. there's only 1 record in table PERSON_CATEGORY, and its type
        --      must be 'CAS'
        --   2. that person (xID_PERSON) does not exist in table
        --      EVENT_PERSON_LINK
        --   3. that person (xID_PERSON) does not belong in another stage
        --      (xID_STAGE)
        -- Only if all 3 conditions are satisfied can we delete PERSON record
        -- (xID_PERSON)
        -- If any condition fails, do not delete PERSON record.
        --

        OPEN SPL(xID_STAGE);
            LOOP
                xDELETE_PERSON := TRUE;

                --
                -- get next ID_PERSON from xID_STAGE:
                --
                -- SIR 11153 - added xID_SPL
                --
                FETCH SPL INTO xID_PERSON,
                               xID_SPL;
                EXIT  WHEN SPL%NOTFOUND OR SPL%NOTFOUND IS NULL;


                --
                -- Condition 1 (PERSON_CATEGORY): If there is any record
                -- other than 'CAS' then do not delete table PERSON
                -- (xID_PERSON)
                -- (Only delete if there's only 1 record of type 'CAS')
                --
                IF xDELETE_PERSON THEN
                    OPEN PERSON_CATEGORY_CURSOR (xID_PERSON);
                        FETCH PERSON_CATEGORY_CURSOR INTO xTOTAL_NON_CAS;
                    CLOSE PERSON_CATEGORY_CURSOR;

                    IF xTOTAL_NON_CAS > 0 THEN
                        --
                        -- if there are records other than CAS, then do NOT
                        -- delete this person
                        --
                        xDELETE_PERSON := FALSE;
                    END IF;
                END IF;


                --
                -- Condition 2 (EVENT_PERSON_LINK): if there is at least one
                -- record in table EVENT_PERSON_LINK then do not delete
                -- PERSON (xID_PERSON)
                --
                IF xDELETE_PERSON THEN
                    xTOTAL_EPL := 0;

                    OPEN   EPL (xID_PERSON);
                        FETCH  EPL INTO xTOTAL_EPL;
                    CLOSE  EPL;

                    IF xTOTAL_EPL > 0 THEN
                        --
                        -- if there's a record in EVENT_PERSON_LINK, do not
                        -- delete person
                        --
                        xDELETE_PERSON := FALSE;
                    END IF;
                END IF;


                --
                -- Condition 3: STAGE_PERSON_LINK: if xID_PERSON exists in
                -- any stages other than current xID_STAGE, then do not
                -- delete PERSON (xID_PERSON)
                --
                IF xDELETE_PERSON THEN
                    xTOTAL_SPL := 0;

                    OPEN   SPL_PERSON (xID_PERSON,xID_STAGE);
                        FETCH  SPL_PERSON INTO xTOTAL_SPL;
                    CLOSE  SPL_PERSON;

                    IF xTOTAL_SPL > 0 THEN
                        xDELETE_PERSON := FALSE;
                    END IF;
                END IF;

                --
                -- must delete from the STAGE_PERSON_LINK table before
                -- delete PERSON (xID_PERSON)
                --
                -- SIR 11153 - removed CURRENT OF SPL and replaced with
                -- ID_STAGE_PERSON_LINK = xID_SPL
                --
                DELETE STAGE_PERSON_LINK
                WHERE  ID_STAGE_PERSON_LINK = xID_SPL;


                --
                -- Always delete incoming-related tables even if PERSON
                -- record is not deleted:
                --
                -- First start by calling the DELETE_INCOMING_PERSON()
                -- stored procedure.
                --
                -- SIR 11153 - changed the order of the input variables for
                -- the call to DELETE_INCOMING_PERSON() from
                -- xID_STAGE,xID_PERSON to xID_PERSON,xID_STAGE since this
                -- is the order of the variables in the prototype
                --
                DELETE_INCOMING_PERSON (xID_PERSON,xID_STAGE);

                DELETE TODO  WHERE ID_TODO_STAGE        = xID_STAGE;

                --
                -- SIR 10881 - The delete from INTAKE_ALLEGATION was only
                -- being performed when xDELETE_PERSON was TRUE (i.e., it was
                -- within the if-statement).  These records should always be
                -- deleted.
                --
                DELETE INTAKE_ALLEGATION
                WHERE  ID_ALLEGATION_STAGE  = xID_STAGE;

                --
                -- delete the person if all 3 conditions have been met by
                -- calling the DELETE_INTAKE_PERSON() stored procedure
                --
                IF xDELETE_PERSON THEN
                    DELETE_INTAKE_PERSON   (xID_PERSON);
                END IF;

            END LOOP;
        CLOSE SPL;

        --
        -- SIR 10674 - Get ID_CASE prior to deleting Stage record
        --
        OPEN   GET_CASE_ID (xID_STAGE);
            FETCH  GET_CASE_ID INTO xID_CASE;
        CLOSE  GET_CASE_ID;

        --
        -- SIR 10674 - Now delete from the SITUATION and CAPS_CASE tables
        -- using the ID_CASE.  Previously, it was deleting using the ID_STAGE
        -- value as the primary keys (ID_SITUATION, ID_CASE) which is
        -- incorrect
        --
        DELETE STAGE      WHERE ID_STAGE     = xID_STAGE;
        DELETE SITUATION  WHERE ID_CASE      = xID_CASE;
        DELETE CAPS_CASE  WHERE ID_CASE      = xID_CASE;

    EXCEPTION
        WHEN OTHERS THEN RAISE;

    END DELETE_INCOMING_DETAIL;
---------------------------------------------------------------------------

---------------------------------------------------------------------------
PROCEDURE DELETE_SUBCARE_EVENT (xID_EVENT NUMBER, xDATE DATE) IS


    BEGIN
        DELETE TODO                 WHERE ID_TODO_EVENT = xID_EVENT;
        DELETE EVENT_PERSON_LINK    WHERE ID_EVENT      = xID_EVENT;

        DELETE EVENT
        WHERE  ID_EVENT        = xID_EVENT
        AND    DT_LAST_UPDATE  = xDATE;

        --
        -- If this delete fails then timestamp has changed.
        -- Must raise exception to alert user
        --

        IF SQL%NOTFOUND THEN
            ROLLBACK;
            RAISE  NO_DATA_FOUND;
        END IF;

   EXCEPTION
     WHEN OTHERS THEN RAISE;

   END DELETE_SUBCARE_EVENT;
---------------------------------------------------------------------------


---------------------------------------------------------------------------
PROCEDURE DELETE_SERVICE_AUTH (xID_SVC_AUTH NUMBER) IS


    BEGIN
        DELETE FROM DELVRD_SVC_DTL        WHERE ID_SVC_AUTH_DTL IN
                (SELECT ID_SVC_AUTH_DTL
                 FROM   SVC_AUTH_DETAIL
                 WHERE  ID_SVC_AUTH = xID_SVC_AUTH);

        DELETE FROM FMIS_BREAKOUT         WHERE ID_SVC_AUTH_DTL IN
                (SELECT ID_SVC_AUTH_DTL
                 FROM   SVC_AUTH_DETAIL
                 WHERE  ID_SVC_AUTH = xID_SVC_AUTH);

        DELETE FROM SVC_AUTH_VALID        WHERE ID_SVC_AUTH = xID_SVC_AUTH;

        -- DELETE FROM APS_IN_HOME_TASKS     WHERE ID_APS_INHOME_SVC_AUTH = xID_SVC_AUTH;

        DELETE FROM TODO                  WHERE ID_TODO_EVENT IN
                (SELECT ID_SVC_AUTH_EVENT
                 FROM   SVC_AUTH_EVENT_LINK
                 WHERE  ID_SVC_AUTH = xID_SVC_AUTH);

        DELETE FROM EVENT_PERSON_LINK     WHERE ID_EVENT IN
                (SELECT ID_SVC_AUTH_EVENT
                 FROM   SVC_AUTH_EVENT_LINK
                 WHERE  ID_SVC_AUTH = xID_SVC_AUTH);

        DELETE FROM EVENT                 WHERE ID_EVENT IN
                (SELECT ID_SVC_AUTH_EVENT
                 FROM   SVC_AUTH_EVENT_LINK
                 WHERE  ID_SVC_AUTH = xID_SVC_AUTH);

        DELETE FROM SVC_AUTH_EVENT_LINK   WHERE ID_SVC_AUTH = xID_SVC_AUTH;

        DELETE FROM SVC_AUTH_DETAIL       WHERE ID_SVC_AUTH = xID_SVC_AUTH;

        DELETE FROM SERVICE_AUTHORIZATION WHERE ID_SVC_AUTH = xID_SVC_AUTH;


   EXCEPTION
     WHEN OTHERS THEN RAISE;


   END DELETE_SERVICE_AUTH;
---------------------------------------------------------------------------


END COMPLEX_DELETE;
/
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO CAPSBAT;
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO CAPSON;
GRANT EXECUTE ON CAPS.COMPLEX_DELETE TO OPERATOR;

DROP TABLE CAPS.EXT_DOCUME_07112007203052000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00003945
UPDATE caps.Codes_Tables
SET DECODE = 5000.00
WHERE code_type = 'CSAMTLMT'
AND code = '57610a';
UPDATE caps.Codes_Tables
SET DECODE = 1000.00
WHERE code_type = 'CSAMTLMT'
AND code = '57610d';
UPDATE caps.Codes_Tables
SET DECODE = 5000.00
WHERE code_type = 'CSAMTLMT'
AND code = '57810a';
UPDATE caps.Codes_Tables
SET DECODE = 1000.00
WHERE code_type = 'CSAMTLMT'
AND code = '57810d';
UPDATE caps.Codes_Tables
SET DECODE = 8000.00
WHERE code_type = 'CSAMTLMT'
AND code = '58678';

-- change STGAP00003976
UPDATE caps.BATCH_PARAMETERS
SET TXT_PARAMETER_VALUE = '168.75'
WHERE NM_BATCH_PROGRAM = 'CTCM01B'
AND NM_BATCH_PARAMETER = 'AMOUNT';

-- change STGAP00003985
update CAPS.MESSAGE set TXT_MESSAGE = 'The question, ''Was a judicial determination regarding ''Reasonable Efforts to Finalize the child''s Permanency Plan'' made during the past 12 months?'' must be answered.' where NBR_MESSAGE = 25475 and TXT_MESSAGE_NAME = 'MSG_JUDICIAL_FINDING_12MO_REQ';
update CAPS.MESSAGE set TXT_MESSAGE = 'The question, ''Is a judicial determination regarding ''Reasonable efforts to Finalize the child''s Permanency Plan'' due? (Reminder: Permanency must be addressed every 12 months while child is in care, regardless of TPR or extension of custody.)'' must be answered.' where NBR_MESSAGE = 25474 and TXT_MESSAGE_NAME = 'MSG_JUDICIAL_FINDING_REQ';
update CAPS.MESSAGE set TXT_MESSAGE = 'The question, ''The question ''Were any Permanency Review hearings held for the child since the last foster care eligibility determination/redetermination?'' must be answered.' where NBR_MESSAGE = 25193 and TXT_MESSAGE_NAME = 'MSG_PERMANENCY_REQ';


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (208, 'SacwisRev2', 'static updates, field name adjustments, COMPLEX_DELETE update');                        
commit;