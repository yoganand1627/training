-- Standard Alter Table SQL

DROP INDEX ORS.FK_COMP_ALG_CINTAKE
;
ALTER TABLE ORS.COMP_ALG DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE ORS.COMP_ALG DROP CONSTRAINT FK_COMP_ALG_CINTAKE
;
ALTER TABLE ORS.COMP_ALG ADD CONSTRAINT PK_COMP_ALG
PRIMARY KEY (INTAKEID,ALGID)
    ENABLE
    VALIDATE
;


-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER ORS.TUBR_CINTAKE
BEFORE UPDATE
ON ORS.CINTAKE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
declare
     vID_RESOURCE number(16);

BEGIN
    IF ((:OLD.INTAKEID <> :NEW.INTAKEID) OR
       (:OLD.FACID <> :NEW.FACID) OR
       (:OLD.CMPTYPE <> :NEW.CMPTYPE) OR
       (:OLD.STATUS <> :NEW.STATUS) OR
       (:OLD.SANOTEPAD <> :NEW.SANOTEPAD) OR
       (:OLD.PRIORITY <> :NEW.PRIORITY) OR
       (:OLD.RECVSTART <> :NEW.RECVSTART)) THEN
	     :new.DT_LAST_UPDATE := SYSDATE;
    END IF;
    IF (:OLD.STATUS <> :NEW.STATUS) THEN
	select distinct(nvl(f.shines_rsrc_id,-1)) into vID_RESOURCE from ors.facility f where f.facid=:new.facid;
	caps.ors_notification(vID_RESOURCE,'Complaint Update',:new.facname,:new.status);
    END IF;
EXCEPTION
  WHEN OTHERS THEN
    IF SQL%NOTFOUND THEN
      vID_RESOURCE := NULL;
    END IF;
END;
/
/
CREATE OR REPLACE TRIGGER ORS.TIBR_CINTAKE
BEFORE INSERT
ON ORS.CINTAKE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
declare
     vID_RESOURCE number(16);
BEGIN

:new.DT_LAST_UPDATE := SYSDATE;

select distinct(nvl(f.shines_rsrc_id,-1)) into vID_RESOURCE from ors.facility f where f.facid=:new.facid;
caps.ors_notification(vID_RESOURCE,'New Complaint',:new.facname,:new.status);
EXCEPTION
  WHEN OTHERS THEN
    IF SQL%NOTFOUND THEN
      vID_RESOURCE := NULL;
    END IF;
END;
/


-- Sequence Alter SQL

CREATE SEQUENCE CAPS.SEQ_DATAFIX_AUDIT_TABLE
    START WITH 1
    INCREMENT BY 1
    NOMINVALUE
    NOMAXVALUE
    CACHE 20
    NOORDER
;
GRANT SELECT ON CAPS.SEQ_DATAFIX_AUDIT_TABLE TO CAPSBAT
;
GRANT SELECT ON CAPS.SEQ_DATAFIX_AUDIT_TABLE TO CAPSON
;

-- Drop Constraint, Rename and Create Table SQL

CREATE TABLE CAPS.DATAFIX_AUDIT_TABLE
(
    ID_DATAFIX     NUMBER(16)    NOT NULL,
    SCRIPT_NAME    VARCHAR2(20)  NOT NULL,
    LOGFILE_NAME   VARCHAR2(20)      NULL,
    ID_DEFECT_CQ   VARCHAR2(20)  NOT NULL,
    ERROR_CATEGORY VARCHAR2(20)  NOT NULL,
    DATAFIX_DESC   VARCHAR2(200) NOT NULL,
    DT_START       DATE          NOT NULL,
    DT_COMPLETED   DATE              NULL,
    ID_CASE        NUMBER(16)        NULL,
    ID_PERSON      NUMBER(16)        NULL,
    ID_EVENT       NUMBER(16)        NULL,
    ID_RESOURCE    NUMBER(16)        NULL,
    ID_STAGE       NUMBER(16)        NULL,
    CONSTRAINT PK_DATAFIX_AUDIT_TABLE
    PRIMARY KEY (ID_DATAFIX)
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
COMMENT ON TABLE CAPS.DATAFIX_AUDIT_TABLE IS
'Audit table used by the DataFix process to keep track of what data fixes have been applied to the database and when.'
;
GRANT DELETE ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSBAT
;
GRANT INSERT ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSBAT
;
GRANT SELECT ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSBAT
;
GRANT UPDATE ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSBAT
;
GRANT DELETE ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSON
;
GRANT INSERT ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSON
;
GRANT SELECT ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSON
;
GRANT UPDATE ON CAPS.DATAFIX_AUDIT_TABLE TO CAPSON
;
GRANT SELECT ON CAPS.DATAFIX_AUDIT_TABLE TO OPERATOR
;

-- Update Views SQL

CREATE OR REPLACE
VIEW CAPS.LEGAL_STATUS_VIEW 
( 
 id_legal_stat_event,
 dt_last_update,
 id_person,
 id_case,
 cd_legal_stat_cnty,
 cd_legal_stat_status,
 dt_legal_stat_status_dt,
 ind_csup_send,
 cd_court_nbr,
 dt_legal_stat_crt_odr_exp_dt,
 dt_legal_stat_cus_exp_dt,
 dt_legal_stat_p_m_due_dt,
 ind_legal_stat_risk,
 ID_EVENT_STAGE,
 dt_legal_stat_end
) AS 
select legal_status_prime.id_legal_stat_event,
legal_status_prime.dt_last_update,
legal_status_prime.id_person,
legal_status_prime.id_case,
legal_status_prime.cd_legal_stat_cnty,
legal_status_prime.cd_legal_stat_status,
legal_status_prime.dt_legal_stat_status_dt,
legal_status_prime.ind_csup_send,
legal_status_prime.cd_court_nbr,
legal_status_prime.dt_legal_stat_crt_odr_exp_dt,
legal_status_prime.dt_legal_stat_cus_exp_dt,
legal_status_prime.dt_legal_stat_p_m_due_dt,
legal_status_prime.ind_legal_stat_risk, 
event_prime.ID_EVENT_STAGE, 
NVL( (select (min(legal_status.DT_LEGAL_STAT_STATUS_DT)-1)
from legal_status, event
where legal_status.DT_LEGAL_STAT_STATUS_DT > legal_status_prime.DT_LEGAL_STAT_STATUS_DT
and legal_status.ID_LEGAL_STAT_EVENT = event.ID_EVENT
and event.ID_CASE = event_prime.ID_CASE -- joined on ID_CASE here to look within the overall case for the same person.
and legal_status.ID_PERSON = legal_status_prime.ID_PERSON
), '31-Dec-4712') as dt_legal_stat_end
from legal_status legal_status_prime, event event_prime
where legal_status_prime.ID_LEGAL_STAT_EVENT = event_prime.ID_EVENT
order by legal_status_prime.ID_CASE asc, event_prime.ID_EVENT_STAGE asc, legal_status_prime.ID_PERSON asc
;

-- Alter Trigger SQL
/
CREATE OR REPLACE TRIGGER CAPS.TIBR_DATAFIX_AUDIT_TABLE
BEFORE INSERT
ON CAPS.DATAFIX_AUDIT_TABLE
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
	dummy		NUMBER;
BEGIN
	IF (:new.ID_DATAFIX = 0) THEN
		SELECT	SEQ_DATAFIX_AUDIT_TABLE.NEXTVAL
		INTO		dummy
		FROM		DUAL;
		:new.ID_DATAFIX := dummy;
	END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- All changes for version 2.4 of SHINES

-- change STGAP00008209
update caps.reports set reports.ind_rpt_page = 'N' where reports.NM_RPT_SQR_NAME = 'AfcarsDischarge';

-- change STGAP00008265
update caps.reports
set reports.NM_RPT_DESC = 'A detailed view of cases and stages that require conversion validation organized by county, unit, and case manager. Generated for a specific county with an optional case manager parameter.'
where reports.NM_RPT_SQR_NAME = 'StageValidationDetail';

update caps.reports
set reports.NM_RPT_DESC = 'A list of case manager conversion validation statistics organized by region, county, unit and case manager. Generated for an optional region parameter.'
where reports.NM_RPT_SQR_NAME = 'ValidationStatus';

update caps.reports
set reports.NM_RPT_DESC = 'A count of all TCM claims actually billed by program type (CPS, Safety Resource, Placement, and YPS). Generated for a specific service month between two specified billing dates, with an optional region parameter.'
where reports.NM_RPT_SQR_NAME = 'TCMStatewideBillingCounts';

-- change STGAP00008305
INSERT INTO caps.MESSAGE
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES
(0,SYSDATE,60418, 'MSG_INT_CLOS_APRV_REQ','The Intake Closure change to Response Time or Disposition must be approved before stage progressing the Intake.','700','500','N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (317, 'SacwisRev2', 'static table updates');                        
commit;
