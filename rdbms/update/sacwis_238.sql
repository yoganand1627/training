
-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_RACF
    START WITH 11000000
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
GRANT SELECT ON CAPS.SEQ_RACF TO CAPSBAT
;
GRANT SELECT ON CAPS.SEQ_RACF TO CAPSON
;

-- Alter Trigger SQL
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
    dummy            NUMBER;
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
    -- DBCR STGAP00005162 to autopopulate the ID_RACF field
    IF (:NEW.ID_RACF IS NULL) THEN
      SELECT  SEQ_RACF.NEXTVAL
      INTO  dummy
      FROM  DUAL;
      :NEW.ID_RACF := TO_CHAR(dummy);
    END IF;
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
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00005162
/
DECLARE
xID_RACF    CAPS.EMPLOYEE.ID_RACF%TYPE;
racfCount   NUMBER(8);
    
CURSOR employee_cur is SELECT ID_RACF from CAPS.EMPLOYEE for update;
employee_rec employee_cur%ROWTYPE;
BEGIN
 racfCount := 10000000;
 OPEN employee_cur;
 LOOP
   FETCH employee_cur into employee_rec;
   IF employee_cur%NOTFOUND
   THEN
       EXIT;
   ELSE
       xID_RACF := TO_CHAR(racfCount);
       UPDATE caps.employee set id_racf=xID_RACF
          WHERE CURRENT OF employee_cur;
       racfCount := racfCount + 1;
   END IF;
 END LOOP;
CLOSE employee_cur;

END;
/

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (239, 'SacwisRev2', 'Employee ID_RACF Population');  
commit;


