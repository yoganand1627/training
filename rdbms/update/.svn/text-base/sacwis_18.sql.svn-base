
-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE CAPS.STFF_ASGNMT_HISTORY DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.STFF_ASGNMT_HISTORY RENAME TO STFF_ASGNM_09192006153630000
;
CREATE TABLE CAPS.STFF_ASGNMT_HISTORY
(
    ID_STFF_ASGNMT_HSTRY NUMBER(16) NOT NULL,
    DT_LAST_UPDATE       DATE       NOT NULL,
    ID_FROM_PERSON       NUMBER(16) NOT NULL,
    ID_TO_PERSON         NUMBER(16) NOT NULL,
    ID_ENTERED_BY_PERSON NUMBER(16) NOT NULL,
    ID_STAGE             NUMBER(16) NOT NULL,
    ID_CASE              NUMBER(16) NOT NULL
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

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO CAPS.STFF_ASGNMT_HISTORY(
                                     ID_STFF_ASGNMT_HSTRY,
                                     DT_LAST_UPDATE,
                                     ID_FROM_PERSON,
                                     ID_TO_PERSON,
                                     ID_ENTERED_BY_PERSON,
                                     ID_STAGE,
                                     ID_CASE
                                    )
                              SELECT 
                                     ID_STFF_ASGNMT_HSTRY,
                                     DT_LAST_UPDATE,
                                     ID_FROM_PERSON,
                                     ID_TO_PERSON,
                                     ID_ENTERED_BY_PERSON,
                                     ID_STAGE,
                                     NVL(TO_NUMBER(ID_CASE),0)
                                FROM CAPS.STFF_ASGNM_09192006153630000 
;
COMMIT
;
ALTER TABLE CAPS.STFF_ASGNMT_HISTORY LOGGING
;

-- Add Constraint SQL

ALTER TABLE CAPS.STFF_ASGNMT_HISTORY ADD CONSTRAINT PK_ID_STAFF_ASGNMT_HSTRY
PRIMARY KEY (ID_STFF_ASGNMT_HSTRY)
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


-- Add Dependencies SQL
/
DROP TRIGGER CAPS.TIBR_STFF_ASGNMT_HISTORY
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
DROP TRIGGER CAPS.TUBR_STFF_ASGNMT_HISTORY
/
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

drop table CAPS.STFF_ASGNM_09192006153630000;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

INSERT INTO caps.security_class 
(cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) 
VALUES 
('REG_DIRECTOR', SYSDATE, '00000000000000000000000000000','N',1); 
INSERT INTO caps.security_class 
(cd_security_class_name, dt_last_update, txt_security_class_profil, ind_restrict, id_person_modified_by) 
VALUES 
('COUNTY_DIRECTOR', SYSDATE, '10111011110100000110100000000','N',1);  
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='TATUML',cd_emp_security_class_nm='ALL_SECURITY' where id_person='7470';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='HUSKEYC',cd_emp_security_class_nm='CASE_MANAGER' where id_person='9486';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='KEITHL',cd_emp_security_class_nm='CASE_MANAGER' where id_person='9268';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='TUCKERM',cd_emp_security_class_nm='SUPERVISOR' where id_person='743';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BREWERS',cd_emp_security_class_nm='CASE_MANAGER' where id_person='9265';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='RODENBEM',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8871';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='SPILLERC',cd_emp_security_class_nm='SUPERVISOR' where id_person='8110';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BABINS',cd_emp_security_class_nm='CASE_MANAGER' where id_person='5570';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='KOSTR',cd_emp_security_class_nm='CASE_MANAGER' where id_person='3715';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='VALDIVIA',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8799';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='COMPTONL',cd_emp_security_class_nm='COUNTY_DIRECTOR' where id_person='9105';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='DEDORSEL',cd_emp_security_class_nm='REG_DIRECTOR' where id_person='64';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='GIBBONSK',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8386';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='HARRISL',cd_emp_security_class_nm='CASE_MANAGER' where id_person='5005';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='HOLLOWEC',cd_emp_security_class_nm='SUPERVISOR' where id_person='1868';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='CONRARDD',cd_emp_security_class_nm='CASE_MANAGER' where id_person='9003';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='MARTINEM',cd_emp_security_class_nm='SUPERVISOR' where id_person='5101';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='MAGERJ',cd_emp_security_class_nm='COUNTY_DIRECTOR' where id_person='2596';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BRADLEYC',cd_emp_security_class_nm='REG_DIRECTOR' where id_person='8948';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='FOSTERW',cd_emp_security_class_nm='CASE_MANAGER' where id_person='4656';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='RAMIREZV',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8473';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='ENGELKEM',cd_emp_security_class_nm='CASE_MANAGER' where id_person='4637';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='HERNANDM',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8359';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='KUEMPELM',cd_emp_security_class_nm='SUPERVISOR' where id_person='2673';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='LARGER',cd_emp_security_class_nm='SUPERVISOR' where id_person='6117';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='ROGERSN',cd_emp_security_class_nm='CASE_MANAGER' where id_person='1905';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='NELSONA',cd_emp_security_class_nm='CASE_MANAGER' where id_person='1110';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BARRONF',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8582';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BLANKENA',cd_emp_security_class_nm='CASE_MANAGER' where id_person='2545';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='CANCHOLG',cd_emp_security_class_nm='CASE_MANAGER' where id_person='4823';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='LANGES',cd_emp_security_class_nm='SUPERVISOR' where id_person='5234';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='MELANTS',cd_emp_security_class_nm='CASE_MANAGER' where id_person='6069';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='MYATTD',cd_emp_security_class_nm='CASE_MANAGER' where id_person='2149';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='REICHH',cd_emp_security_class_nm='CASE_MANAGER' where id_person='2392';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='TASIND',cd_emp_security_class_nm='CASE_MANAGER' where id_person='3913';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='CARTERB',cd_emp_security_class_nm='SUPERVISOR' where id_person='5897';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='GOSLINAG',cd_emp_security_class_nm='CASE_MANAGER' where id_person='8772';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='STRONGV',cd_emp_security_class_nm='COUNTY_DIRECTOR' where id_person='3985';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BACHICHM',cd_emp_security_class_nm='REG_DIRECTOR' where id_person='6905';
update CAPS.EMPLOYEE set ID_EMPLOYEE_LOGON='BLACKWEG',cd_emp_security_class_nm='REG_DIRECTOR' where id_person='5764';
UPDATE caps.emp_sec_class_link a
SET a.cd_security_class_name = (SELECT b.cd_emp_security_class_nm FROM caps.employee b WHERE b.id_person=a.id_person)
where exists (select 'x' from caps.employee c WHERE c.id_person=a.id_person and c.cd_emp_security_class_nm is not null);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (19, 'SacwisRev1', 'FIX STFF_ASGNMT_HISTORY table, security table updates');
                         
commit;

