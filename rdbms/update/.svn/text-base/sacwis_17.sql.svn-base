
-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_STFF_ASGNMT_HISTORY
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;


-- Standard Alter Table SQL

ALTER INDEX CAPS.UK1_UNIT 
REBUILD TABLESPACE INDEX01
;

-- Drop Referencing Constraint SQL


-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.STFF_ASGNMT_HISTORY
(
    ID_STFF_ASGNMT_HSTRY NUMBER(16)  NOT NULL,
    DT_LAST_UPDATE       DATE        NOT NULL,
    ID_FROM_PERSON       NUMBER(16)  NOT NULL,
    ID_TO_PERSON         NUMBER(16)  NOT NULL,
    ID_ENTERED_BY_PERSON NUMBER(16)  NOT NULL,
    ID_STAGE             NUMBER(16)  NOT NULL,
    ID_CASE              VARCHAR2(1)     NULL,
    CONSTRAINT PK_ID_STAFF_ASGNMT_HSTRY
    PRIMARY KEY (ID_STFF_ASGNMT_HSTRY)
    USING INDEX TABLESPACE INDEX01
                STORAGE(BUFFER_POOL DEFAULT)
    ENABLE
    VALIDATE
)
TABLESPACE DATA01
LOGGING
STORAGE(BUFFER_POOL DEFAULT)
NOPARALLEL
NOCACHE
;
COMMENT ON TABLE CAPS.STFF_ASGNMT_HISTORY IS
'Represents staff assignment history of a case. Updated by 2 tables STAGE_PERSON_LINK and TO_DO.'
;
COMMENT ON COLUMN CAPS.STFF_ASGNMT_HISTORY.DT_LAST_UPDATE IS
'Date of insert or last update'
;
GRANT DELETE ON CAPS.STFF_ASGNMT_HISTORY TO CAPSBAT
;
GRANT INSERT ON CAPS.STFF_ASGNMT_HISTORY TO CAPSBAT
;
GRANT SELECT ON CAPS.STFF_ASGNMT_HISTORY TO CAPSBAT
;
GRANT UPDATE ON CAPS.STFF_ASGNMT_HISTORY TO CAPSBAT
;
GRANT DELETE ON CAPS.STFF_ASGNMT_HISTORY TO CAPSON
;
GRANT INSERT ON CAPS.STFF_ASGNMT_HISTORY TO CAPSON
;
GRANT SELECT ON CAPS.STFF_ASGNMT_HISTORY TO CAPSON
;
GRANT UPDATE ON CAPS.STFF_ASGNMT_HISTORY TO CAPSON
;
GRANT SELECT ON CAPS.STFF_ASGNMT_HISTORY TO OPERATOR
;


-- Alter Trigger SQL

/
CREATE OR REPLACE TRIGGER CAPS.TUBR_STFF_ASGNMT_HISTORY
BEFORE UPDATE
ON CAPS.STFF_ASGNMT_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
        :NEW.DT_LAST_UPDATE := SYSDATE;
END;
/
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_STFF_ASGNMT_HISTORY
BEFORE INSERT
ON CAPS.STFF_ASGNMT_HISTORY
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
        dummy           NUMBER;
BEGIN
        :NEW.DT_LAST_UPDATE := SYSDATE;
        IF (:NEW.ID_STFF_ASGNMT_HSTRY = 0) THEN
                SELECT  SEQ_STFF_ASGNMT_HISTORY.NEXTVAL
                INTO    dummy
                FROM    DUAL;
                :NEW.ID_STFF_ASGNMT_HSTRY := dummy;
        END IF;
END;
/
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
    (:NEW.ID_PERSON_MODIFIED_BY <> :OLD.ID_PERSON_MODIFIED_BY))
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
      ID_PERSON_MODIFIED_BY
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
      :NEW.ID_PERSON_MODIFIED_BY
    );
    END IF;
EXCEPTION
        WHEN OTHERS THEN RAISE;
END;
/

-- Synonym Alter SQL

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

--change 47
update caps.MESSAGE set TXT_MESSAGE = 'There is already an active identifier of this type.  Clicking OK will end-date the old identifier.'
where NBR_MESSAGE = 3091 and TXT_MESSAGE_NAME = 'MSG_INT_ACTIVE_TYPE_EXISTS';

-- change 49
UPDATE caps.MESSAGE m 
SET m.txt_message = 'Unit, Reg/Div, and Mail Code values are required for DFCS Storage Locations.' 
WHERE m.NBR_MESSAGE = 25368;

-- change 50
UPDATE caps.codes_tables 
SET code = 'CP' 
WHERE code = 'CPA' 
AND code_type = 'CADDRTYP';

-- change 51
UPDATE caps.codes_tables 
SET code = 'BP' 
WHERE code = 'BPP' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'CF' 
WHERE code = 'CMF' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'DC' 
WHERE code = 'DCO' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'GC' 
WHERE code = 'GCI' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'SO' 
WHERE code = 'GSO' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'IS' 
WHERE code = 'ISS' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'LE' 
WHERE code = 'LLE' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'NC' 
WHERE code = 'NCI' 
AND code_type = 'CCHKTYPE'; 

UPDATE caps.codes_tables 
SET code = 'SC' 
WHERE code = 'SUC' 
AND code_type = 'CCHKTYPE';

-- change 52
INSERT INTO caps.codes_tables 
(code_type, code, DECODE, dt_last_update) 
VALUES 
('CEVNTTYP','WVR','Policy Waiver',SYSDATE);

-- change 21
delete from caps.codes_tables where code_type='CNIRTYPE' ; 
insert into caps.codes_tables values ('CNIRTYPE','GC','General CPS information',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','VP','Voluntary placement',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','AS','Adoption Services',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','FP','Foster Parent information',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','PQ','Placement Questions',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','AN','Agency Phone Numbers',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','MR','Medical Resources',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','GI','General Information',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','TA','TANF Assessment/Sanction',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','CI','Custody issues',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','IC','ICPC',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','OT','OTI',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','AP','APS',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','JC','Juvenile Court',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','RR','Records request',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CNIRTYPE','IR','Information and Referral',null,to_date('08/30/2006','MM/DD/YYYY')); 

update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NLA' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NPS' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NRC' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NST' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'XXX' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CAD' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CCO' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CDC' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CJP' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'COS' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CPB' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CPL' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CTY' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NEX' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NIP' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CBC' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CFH' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CCL' and CODE_TYPE = 'CSPECREQ'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CCR' and CODE_TYPE = 'CSPECREQ'; 

update caps.CODES_TABLES set DECODE = 'ICPC'  where CODE = 'CIC' and CODE_TYPE = 'CSPECREQ'; 

update caps.CODES_TABLES set DECODE = 'Mail'   where CODE = '1'   and CODE_TYPE = 'CINCCTYP'; 
update caps.CODES_TABLES set DECODE = 'Fax'   where CODE = '3'   and CODE_TYPE = 'CINCCTYP'; 
update caps.CODES_TABLES set DECODE = 'Email'   where CODE = '4'   and CODE_TYPE = 'CINCCTYP'; 
update caps.CODES_TABLES set dt_end = to_date('01/01/2006','MM/DD/YYYY')  where CODE = '0'   and CODE_TYPE = 'CINCCTYP'; 
update caps.CODES_TABLES set dt_end = to_date('01/01/2006','MM/DD/YYYY')  where CODE = '2'   and CODE_TYPE = 'CINCCTYP'; 

update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'AA' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'AB' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'AF' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'AG' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'AT' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'BY' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CA' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'CR' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'DA' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'DR' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'EM' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'FI' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'FV' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'GC' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'GU' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'IL' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'IN' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'MF' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'MH' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'NN' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'OS' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'PA' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'PC' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'PP' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'PR' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'PY' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'SA' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'SF' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'SO' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'SP' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'TP' and CODE_TYPE = 'CSRCRPTR'; 

insert into caps.codes_tables values ('CSRCRPTR','AM','Alleged Maltreater',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','CP','Custodial Parent/Guardian',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','CW','Counselor/Social Worker',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','DH','DHR Staff (Non-TANF)',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','DN','Dentist',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','LW','Lawyer',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','NC','Non-Custodial Parent',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','PH','Physician',null,to_date('08/30/2006','MM/DD/YYYY')); 
insert into caps.codes_tables values ('CSRCRPTR','UK','Unknown',null,to_date('08/30/2006','MM/DD/YYYY')); 

update caps.CODES_TABLES set DECODE = 'Guardian Ad Litem' where CODE = 'GX' and CODE_TYPE = 'CSRCRPTR'; 
update caps.CODES_TABLES set DECODE = 'Podiatrist' where CODE = 'PO' and CODE_TYPE = 'CSRCRPTR'; 
     
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'FC' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'OC' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DECODE = 'Business Cell'   where CODE = 'BC' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DECODE = 'Business Fax'    where CODE = 'BF' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DECODE = 'Business Pager'  where CODE = 'BP' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DECODE = 'Personal Fax'    where CODE = 'RF' and CODE_TYPE = 'CPHNTYP';   
update caps.CODES_TABLES set DECODE = 'Personal Pager'  where CODE = 'RP' and CODE_TYPE = 'CPHNTYP'; 
update caps.CODES_TABLES set DECODE = 'Pay Phone'       where CODE = 'PA' and CODE_TYPE = 'CPHNTYP'; 

update caps.CODES_TABLES set DT_END = to_date('01/01/2006','MM/DD/YYYY') where CODE = 'FC' and CODE_TYPE = 'CADDRTYP'; 
update caps.CODES_TABLES set DECODE = 'Family/Relative'   where CODE = 'FM' and CODE_TYPE = 'CADDRTYP'; 
update caps.CODES_TABLES set DECODE = 'Friend/Neighbor'   where CODE =  'FN' and CODE_TYPE = 'CADDRTYP'; 
update caps.CODES_TABLES set DECODE = 'Residence-Mail'   where CODE = 'RM' and CODE_TYPE = 'CADDRTYP'; 

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (18, 'SacwisRev1', 'Add new STFF_ASGNMT_HISTORY table, codes table updates');
                         
commit;
