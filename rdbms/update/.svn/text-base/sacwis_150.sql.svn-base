
-- Standard Alter Table SQL

ALTER TABLE CAPS.EMPLOYEE_AUDIT MODIFY(ID_EMPLOYEE_LOGON  VARCHAR2(20))
;
ALTER TABLE CAPS.EMPLOYEE_AUDIT ADD ID_RACF VARCHAR2(8)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD CD_SUCCESS_CLASS_ASSISTANCE VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD DT_SUCC_CLASS_ASSISTANCE DATE     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD CD_TYPE VARCHAR2(3)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NM_COMPANY VARCHAR2(50)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NBR_POLICY VARCHAR2(20)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NBR_GROUP VARCHAR2(20)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ADDR_STREET_LN1 VARCHAR2(30)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ADDR_STREET_LN2 VARCHAR2(30)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ADDR_CITY VARCHAR2(20)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ADDR_STATE VARCHAR2(2)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD ADDR_ZIP VARCHAR2(10)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NBR_PHONE VARCHAR2(10)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NBR_PHONE_EXT VARCHAR2(8)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD NM_EMPLOYER VARCHAR2(50)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD DT_BEGIN DATE     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD DT_END DATE     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD IND_CHILD_COVERAGE VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.INITIAL_MEDICAID_APP ADD IND_PARENT VARCHAR2(1)     NULL
;


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TUBR_EMPLOYEE
BEFORE UPDATE
ON CAPS.EMPLOYEE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
    ------------------------------------------------------------
    -- SIR #10495 08/27/96 GLOORJW moved update of EMPLOYEE
    -- table from EMP_JOB_HISTORY to this trigger in
    -- order to avoid circular logic.
    -- CD_EMP_BJN_EMP, CD_EMP_JOB_CLASS, and IND_EMP_JOB_ASSIG_CURR
    -- are updated from the values on the EMP_JOB_HISTORY table
    -----------------------------------------------------------
    xID_EMP_JOB_HIST    EMP_JOB_HISTORY.ID_EMP_JOB_HISTORY%TYPE;
    xCD_JOB_BJN         EMP_JOB_HISTORY.CD_JOB_BJN%TYPE;
    xCD_JOB_CLASS       EMP_JOB_HISTORY.CD_JOB_CLASS%TYPE;
    xIND_JOB_ASSIGNABLE EMP_JOB_HISTORY.IND_JOB_ASSIGNABLE%TYPE;
    xNM_OFFICE_NAME  OFFICE.NM_OFFICE_NAME%TYPE;
    xCD_OFFICE_MAIL  OFFICE.CD_OFFICE_MAIL%TYPE;
    --check for combination (ID_PERSON, ID_EMP_JOB_HISTORY) must already
    --exists in table EMP_JOB_HISTORY
    CURSOR C1 (xID_EMP_JOB_HISTORY in NUMBER, xID_PERSON in NUMBER) IS
    SELECT  ID_EMP_JOB_HISTORY,
            CD_JOB_BJN,
            CD_JOB_CLASS,
            IND_JOB_ASSIGNABLE
    FROM    EMP_JOB_HISTORY E
    WHERE   E.ID_EMP_JOB_HISTORY    = xID_EMP_JOB_HISTORY
    AND     E.ID_PERSON             = xID_PERSON;
BEGIN
    OPEN  C1 (:NEW.ID_EMP_JOB_HISTORY, :NEW.ID_PERSON);
    FETCH C1 INTO xID_EMP_JOB_HIST,
                  xCD_JOB_BJN,
                  xCD_JOB_CLASS,
                  xIND_JOB_ASSIGNABLE;
    IF C1%FOUND THEN
        :NEW.CD_EMP_BJN_EMP          := xCD_JOB_BJN;
        :NEW.CD_EMPLOYEE_CLASS       := xCD_JOB_CLASS;
        :NEW.IND_EMP_JOB_ASSIGN_CURR := xIND_JOB_ASSIGNABLE;
    ELSE
        -- The recored above must be found or it is an error
        RAISE NO_DATA_FOUND;
    END IF;
    CLOSE C1;
        :NEW.DT_LAST_UPDATE := sysdate;
    ---------------------------------------------------------------
    -- SIR #10495 08/27/96 GLOORJW Removed begin and end from around
    -- select statement, moved the population of the office name
    -- and code to within the if statement, and moved before the EXCEPTION
    -- statement
    ---------------------------------------------------------------
    ---
    --- GRD If the ID_EMP_OFFICE has changed, then get the Mail Code and
    --- Office Name and update the EMPLOYEE table
    ---
    IF (:NEW.ID_EMP_OFFICE <> :OLD.ID_EMP_OFFICE)
    THEN
        SELECT NM_OFFICE_NAME,
               CD_OFFICE_MAIL
        INTO   xNM_OFFICE_NAME,
               xCD_OFFICE_MAIL
        FROM   OFFICE
        WHERE  ID_OFFICE = :NEW.ID_EMP_OFFICE;
        :NEW.NM_EMP_OFFICE_NAME := xNM_OFFICE_NAME;
        :NEW.CD_EMP_OFFICE_MAIL := xCD_OFFICE_MAIL;
    END IF;
    
    IF ((:NEW.ID_PERSON <> :OLD.ID_PERSON) OR
    (:NEW.CD_EMPLOYEE_CLASS <> :OLD.CD_EMPLOYEE_CLASS) OR
    (:NEW.DT_EMP_HIRE <> :OLD.DT_EMP_HIRE) OR
    (:NEW.ID_EMP_JOB_HISTORY <> :OLD.ID_EMP_JOB_HISTORY) OR
    (:NEW.NBR_EMP_ACTIVE_PCT <> :OLD.NBR_EMP_ACTIVE_PCT) OR
    (:NEW.ID_EMP_OFFICE <> :OLD.ID_EMP_OFFICE) OR
    (:NEW.ID_EMPLOYEE_LOGON <> :OLD.ID_EMPLOYEE_LOGON) OR
    (:NEW.CD_EMP_SECURITY_CLASS_NM <> :OLD.CD_EMP_SECURITY_CLASS_NM) OR
    (:NEW.CD_EMP_PROGRAM <> :OLD.CD_EMP_PROGRAM) OR
    (:NEW.DT_EMP_LAST_ASSIGNED <> :OLD.DT_EMP_LAST_ASSIGNED) OR
    (:NEW.DT_EMP_TERMINATION <> :OLD.DT_EMP_TERMINATION) OR
    (:NEW.IND_EMP_ACTIVE_STATUS <> :OLD.IND_EMP_ACTIVE_STATUS) OR
    (:NEW.IND_EMP_CONFIRMED_HRMIS <> :OLD.IND_EMP_CONFIRMED_HRMIS) OR
    (:NEW.NM_EMPLOYEE_FIRST <> :OLD.NM_EMPLOYEE_FIRST) OR
    (:NEW.NM_EMPLOYEE_MIDDLE <> :OLD.NM_EMPLOYEE_MIDDLE) OR
    (:NEW.NM_EMPLOYEE_LAST <> :OLD.NM_EMPLOYEE_LAST) OR
    (:NEW.CD_EMP_BJN_EMP <> :OLD.CD_EMP_BJN_EMP) OR
    (:NEW.IND_EMP_JOB_ASSIGN_CURR <> :OLD.IND_EMP_JOB_ASSIGN_CURR) OR
    (:NEW.NM_EMP_OFFICE_NAME <> :OLD.NM_EMP_OFFICE_NAME) OR
    (:NEW.CD_EMP_OFFICE_MAIL <> :OLD.CD_EMP_OFFICE_MAIL) OR
    (:NEW.NBR_EMP_UNIT_EMP_IN <> :OLD.NBR_EMP_UNIT_EMP_IN) OR
    (:NEW.ID_EMP_UNIT <> :OLD.ID_EMP_UNIT) OR
    (:NEW.CD_EMP_UNIT_REGION <> :OLD.CD_EMP_UNIT_REGION) OR
    (:NEW.CD_EMPLOYEE_SUFFIX <> :OLD.CD_EMPLOYEE_SUFFIX) OR
    (:NEW.ID_PERSON_MODIFIED_BY <> :OLD.ID_PERSON_MODIFIED_BY) OR
    (:NEW.ID_RACF <> :OLD.ID_RACF))
    THEN
    insert into employee_audit(
      ID_PERSON,
      CD_EMPLOYEE_CLASS,
      DT_EMP_HIRE,
      ID_EMP_JOB_HISTORY,
      NBR_EMP_ACTIVE_PCT,
      ID_EMP_OFFICE,
      ID_EMPLOYEE_LOGON,
      CD_EMP_SECURITY_CLASS_NM,
      CD_EMP_PROGRAM,
      DT_EMP_LAST_ASSIGNED,
      DT_EMP_TERMINATION,
      IND_EMP_ACTIVE_STATUS,
      IND_EMP_CONFIRMED_HRMIS,
      IND_EMP_PENDING_HRMIS,
      NM_EMPLOYEE_FIRST,
      NM_EMPLOYEE_MIDDLE,
      NM_EMPLOYEE_LAST,
      CD_EMP_BJN_EMP,
      IND_EMP_JOB_ASSIGN_CURR,
      NM_EMP_OFFICE_NAME,
      CD_EMP_OFFICE_MAIL,
      NBR_EMP_UNIT_EMP_IN,
      ID_EMP_UNIT,
      CD_EMP_UNIT_REGION,
      CD_EMPLOYEE_SUFFIX,
      DT_LAST_LOGIN,
      ID_PERSON_MODIFIED_BY,
      ID_RACF
    ) values (
      :NEW.ID_PERSON,
      :NEW.CD_EMPLOYEE_CLASS,
      :NEW.DT_EMP_HIRE,
      :NEW.ID_EMP_JOB_HISTORY,
      :NEW.NBR_EMP_ACTIVE_PCT,
      :NEW.ID_EMP_OFFICE,
      :NEW.ID_EMPLOYEE_LOGON,
      :NEW.CD_EMP_SECURITY_CLASS_NM,
      :NEW.CD_EMP_PROGRAM,
      :NEW.DT_EMP_LAST_ASSIGNED,
      :NEW.DT_EMP_TERMINATION,
      :NEW.IND_EMP_ACTIVE_STATUS,
      :NEW.IND_EMP_CONFIRMED_HRMIS,
      :NEW.IND_EMP_PENDING_HRMIS,
      :NEW.NM_EMPLOYEE_FIRST,
      :NEW.NM_EMPLOYEE_MIDDLE,
      :NEW.NM_EMPLOYEE_LAST,
      :NEW.CD_EMP_BJN_EMP,
      :NEW.IND_EMP_JOB_ASSIGN_CURR,
      :NEW.NM_EMP_OFFICE_NAME,
      :NEW.CD_EMP_OFFICE_MAIL,
      :NEW.NBR_EMP_UNIT_EMP_IN,
      :NEW.ID_EMP_UNIT,
      :NEW.CD_EMP_UNIT_REGION,
      :NEW.CD_EMPLOYEE_SUFFIX,
      :NEW.DT_LAST_LOGIN,
      :NEW.ID_PERSON_MODIFIED_BY,
      :NEW.ID_RACF
    );
    END IF;
EXCEPTION
        WHEN OTHERS THEN RAISE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_EMPLOYEE
BEFORE INSERT
ON CAPS.EMPLOYEE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
    ------------------------------------------------------------
    -- SIR #10495 08/27/96 GLOORJW moved update of EMPLOYEE
    -- table from EMP_JOB_HISTORY to this trigger in
    -- order to avoid circular logic.
    -- CD_EMP_BJN_EMP, CD_EMP_JOB_CLASS, and IND_EMP_JOB_ASSIG_CURR
    -- are updated from the values on the EMP_JOB_HISTORY table
    -- SIR# 22211 - Remove CD_EMP_JOB_CLASS. Same as CD_EMPLOYEE_CLASS
    -----------------------------------------------------------
    xID_EMP_JOB_HIST    EMP_JOB_HISTORY.ID_EMP_JOB_HISTORY%TYPE;
    xCD_JOB_BJN         EMP_JOB_HISTORY.CD_JOB_BJN%TYPE;
    xCD_JOB_CLASS       EMP_JOB_HISTORY.CD_JOB_CLASS%TYPE;
    xIND_JOB_ASSIGNABLE EMP_JOB_HISTORY.IND_JOB_ASSIGNABLE%TYPE;
    xNM_OFFICE_NAME  OFFICE.NM_OFFICE_NAME%TYPE;
    xCD_OFFICE_MAIL  OFFICE.CD_OFFICE_MAIL%TYPE;
    -- check for combination (ID_PERSON, ID_EMP_JOB_HISTORY) must already --exists in table EMP_JOB_HISTORY
    CURSOR C1 (xID_EMP_JOB_HISTORY in NUMBER, xID_PERSON in NUMBER) IS
    SELECT  ID_EMP_JOB_HISTORY,
            CD_JOB_BJN,
            CD_JOB_CLASS,
            IND_JOB_ASSIGNABLE
    FROM    EMP_JOB_HISTORY E
    WHERE   E.ID_EMP_JOB_HISTORY    = xID_EMP_JOB_HISTORY
    AND     E.ID_PERSON             = xID_PERSON;
BEGIN
    OPEN  C1 (:NEW.ID_EMP_JOB_HISTORY, :NEW.ID_PERSON);
    FETCH C1 INTO xID_EMP_JOB_HIST,
                  xCD_JOB_BJN,
                  xCD_JOB_CLASS,
                  xIND_JOB_ASSIGNABLE;
    IF C1%FOUND THEN
        :NEW.CD_EMP_BJN_EMP          := xCD_JOB_BJN;
        :NEW.CD_EMPLOYEE_CLASS       := xCD_JOB_CLASS;
        :NEW.IND_EMP_JOB_ASSIGN_CURR := xIND_JOB_ASSIGNABLE;
    ELSE
        -- The recored above must be found or it is an error
        RAISE NO_DATA_FOUND;
    END IF;
    CLOSE C1;
    :NEW.DT_LAST_UPDATE := sysdate;
    ---------------------------------------------------------------
    -- SIR #10495 08/27/96 GLOORJW Removed begin and end from around
    -- select statement and moved before the EXCEPTION statement
    ---------------------------------------------------------------
    ---
    --- GRD New trigger to insert data on the denormalized EMPLOYEE table
    ---
    --- SIR# 22212 - Saravigm -  Changed CD_EMP_JOB_CLASS to
    --- CD_EMPLOYEE_CLASS and add if (NEW.ID_EMP_OFFICE <> 0). This allows
    --- the termination of a new employee on the same day they are created
    -------------------------------------------------------------------
    IF (:NEW.ID_EMP_OFFICE <>  0)
    THEN
      SELECT NM_OFFICE_NAME,
             CD_OFFICE_MAIL
      INTO   xNM_OFFICE_NAME,
             xCD_OFFICE_MAIL
      FROM   OFFICE
      WHERE  ID_OFFICE = :NEW.ID_EMP_OFFICE;
      :NEW.NM_EMP_OFFICE_NAME := xNM_OFFICE_NAME;
      :NEW.CD_EMP_OFFICE_MAIL := xCD_OFFICE_MAIL;
    END IF;

    insert into employee_audit(
      ID_PERSON,
      CD_EMPLOYEE_CLASS,
      DT_EMP_HIRE,
      ID_EMP_JOB_HISTORY,
      NBR_EMP_ACTIVE_PCT,
      ID_EMP_OFFICE,
      ID_EMPLOYEE_LOGON,
      CD_EMP_SECURITY_CLASS_NM,
      CD_EMP_PROGRAM,
      DT_EMP_LAST_ASSIGNED,
      DT_EMP_TERMINATION,
      IND_EMP_ACTIVE_STATUS,
      IND_EMP_CONFIRMED_HRMIS,
      IND_EMP_PENDING_HRMIS,
      NM_EMPLOYEE_FIRST,
      NM_EMPLOYEE_MIDDLE,
      NM_EMPLOYEE_LAST,
      CD_EMP_BJN_EMP,
      IND_EMP_JOB_ASSIGN_CURR,
      NM_EMP_OFFICE_NAME,
      CD_EMP_OFFICE_MAIL,
      NBR_EMP_UNIT_EMP_IN,
      ID_EMP_UNIT,
      CD_EMP_UNIT_REGION,
      CD_EMPLOYEE_SUFFIX,
      DT_LAST_LOGIN,
      ID_PERSON_MODIFIED_BY,
      ID_RACF
    ) values (
      :NEW.ID_PERSON,
      :NEW.CD_EMPLOYEE_CLASS,
      :NEW.DT_EMP_HIRE,
      :NEW.ID_EMP_JOB_HISTORY,
      :NEW.NBR_EMP_ACTIVE_PCT,
      :NEW.ID_EMP_OFFICE,
      :NEW.ID_EMPLOYEE_LOGON,
      :NEW.CD_EMP_SECURITY_CLASS_NM,
      :NEW.CD_EMP_PROGRAM,
      :NEW.DT_EMP_LAST_ASSIGNED,
      :NEW.DT_EMP_TERMINATION,
      :NEW.IND_EMP_ACTIVE_STATUS,
      :NEW.IND_EMP_CONFIRMED_HRMIS,
      :NEW.IND_EMP_PENDING_HRMIS,
      :NEW.NM_EMPLOYEE_FIRST,
      :NEW.NM_EMPLOYEE_MIDDLE,
      :NEW.NM_EMPLOYEE_LAST,
      :NEW.CD_EMP_BJN_EMP,
      :NEW.IND_EMP_JOB_ASSIGN_CURR,
      :NEW.NM_EMP_OFFICE_NAME,
      :NEW.CD_EMP_OFFICE_MAIL,
      :NEW.NBR_EMP_UNIT_EMP_IN,
      :NEW.ID_EMP_UNIT,
      :NEW.CD_EMP_UNIT_REGION,
      :NEW.CD_EMPLOYEE_SUFFIX,
      :NEW.DT_LAST_LOGIN,
      :NEW.ID_PERSON_MODIFIED_BY,
      :NEW.ID_RACF
    );
EXCEPTION
        WHEN OTHERS THEN RAISE;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001903
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60255, 'MSG_CMN_YDP_UPDATE', 'Please save if updates have occurred to Person Information', '600', '700', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60256, 'MSG_CMN_YDP_OUTCOME_DATE', 'An Outcome Date is required when an Outcome Reporting Status is selected', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60257, 'MSG_CMN_YDP_OUTCOME_STAT', 'An Outcomes Reporting Status is required when an Outcome Date is entered', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60258, 'MSG_CMN_YDP_REQ_FIELD', 'Field is required when Outcome Status is ''Youth Participated''', '540', '730', 'N');
INSERT INTO CAPS.MESSAGE (ID_MESSAGE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH) VALUES (0, 60259, 'MSG_CMN_YDP_SEX', 'Sex cannot be unknown', '540', '720', 'N');

-- change STGAP00001904
insert into caps.codes_tables values ('CCNTPURP','SOO','State Office Oversight',null,SYSDATE);

-- change STGAP00001908
update caps.message
set txt_message = 'Person with legal status of PMC must have a FCC or ADO to close FCF.'
where nbr_message = 8381;

update caps.message
set txt_message = 'A FCC stage has been opened from this stage. The selected Risk Finding is inappropriate. You must choose ''Risk Indicated'' as the Risk Finding.'
where nbr_message = 55035;

update caps.message
set txt_message = 'Duplicate OPEN FCC, ADO, and/or PAD stages exist.  Please close all duplicate stages and retry the merge.'
where nbr_message = 8250;

update caps.message
set txt_message = 'Home is for adoption only and can''t be selected in FCC stage.'
where nbr_message = 7114;

update caps.message
set txt_message = 'There is already an open FCC stage for the Primary child of this stage.  This stage cannot be reopened.'
where nbr_message = 8407;

-- change STGAP00001907
INSERT INTO CAPS.MESSAGE
(TXT_MESSAGE_NAME, TXT_MESSAGE, NBR_MESSAGE) 
VALUES ('MSG_CMN_CIT_FCE_SAVE','Information has been changed. If an FCE App or Foster Care Redetermination is in progress, the Age and Citizenship or Redetermination page must be saved to capture the updates', '60261');

INSERT INTO CAPS.MESSAGE
(TXT_MESSAGE_NAME, TXT_MESSAGE, NBR_MESSAGE) 
VALUES ('MSG_OUT_OF_STATE_CNTY','Information must be entered in the Out of State County field if the state is not Georgia', '60262');

INSERT INTO CAPS.MESSAGE
(TXT_MESSAGE_NAME, TXT_MESSAGE, NBR_MESSAGE) 
VALUES ('MSG_CMN_ENTRY_DATE','Entry date must be entered for non-U.S. Birth', '60263');

INSERT INTO CAPS.MESSAGE
(TXT_MESSAGE_NAME, TXT_MESSAGE, NBR_MESSAGE) 
VALUES ('MSG_CMN_IDENT_VERIF_REQ','Identity verification type is required for the selected citizenship verification', '60264');

INSERT INTO CAPS.MESSAGE
(TXT_MESSAGE_NAME, TXT_MESSAGE, NBR_MESSAGE) 
VALUES ('MSG_CMN_IDENT_VERIF_AGE','Person is over 16. Select an adult identity verification type', '60265');

-- change STGAP00001909
Insert into CAPS.MESSAGE
   (ID_MESSAGE, DT_LAST_UPDATE, NBR_MESSAGE, TXT_MESSAGE_NAME, TXT_MESSAGE, CD_SOURCE, CD_PRESENTATION, IND_BATCH)
 Values
   (0, SYSDATE, 60260, 'MSG_INV_SPCL_NOTIFICATION', 'Foster parent notification regarding an advocate is required for special investigation', 700, 500, 'N');

-- change STGAP00001906
update  CAPS.CODES_TABLES 
set dt_end = to_date('01/01/2006', 'MM/DD/YYYY')
WHERE CODE_TYPE='CELIGMED';

INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F11', 'F11 - IV-E');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F13', 'F13 - IV-E Adopt.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F15', 'F15 - Newborn');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F22', 'F22 - RSM');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F40', 'F40 - IV-B');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'F99', 'F99 - Medically Needy');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'D02', 'D02 - State Adopt.');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'P01', 'P01 - Pregnancy');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'EMA', 'EMA - Emer. Medical');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'SSI', 'SSI');
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE) VALUES('CELIGMED', 'XXX', 'Other');


insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (151, 'SacwisRev2', 'static updates, schema changes');
commit;                      
