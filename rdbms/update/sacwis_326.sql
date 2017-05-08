-- Release 2.5 

-- The field definition for the SRVCNT field in the ORS.FACSRV table is currently NUMBER(4,0), but the source system defines it as NUMBER. Even though the FACILITY table also has a SRVCNT field that is NUMBER(4,0), we need to change the FACSRV table to match the source system being propogated from.
-- Downside: NUMBER defaults to NUMBER(38), which is huge compared to 4 digit number.

-- Drop Constraint, Rename and Create Table SQL

ALTER TABLE ORS.FACSRV DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE ORS.FACSRV RENAME TO FACSRV_05272008203836000
;
CREATE TABLE ORS.FACSRV
(
    FACILITY_INTERNAL_ID NUMBER(10)   NOT NULL,
    SRVTYPE              CHAR(2)      NOT NULL,
    SRVDESC              VARCHAR2(30)     NULL,
    SRVEFFECT            DATE         NOT NULL,
    SRVABBREV            VARCHAR2(6)      NULL,
    SRVCNT               NUMBER           NULL,
    SRVPROV              CHAR(2)          NULL,
    SRVPROVDES           VARCHAR2(15)     NULL,
    SERVICEID            NUMBER(10)       NULL,
    SRVENDDT             DATE             NULL,
    DT_LAST_UPDATE       DATE         NOT NULL
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
GRANT DELETE ON ORS.FACSRV TO CAPS
;
GRANT INSERT ON ORS.FACSRV TO CAPS
;
GRANT SELECT ON ORS.FACSRV TO CAPS
;
GRANT UPDATE ON ORS.FACSRV TO CAPS
;
GRANT DELETE ON ORS.FACSRV TO CAPSBAT
;
GRANT INSERT ON ORS.FACSRV TO CAPSBAT
;
GRANT SELECT ON ORS.FACSRV TO CAPSBAT
;
GRANT UPDATE ON ORS.FACSRV TO CAPSBAT
;
GRANT DELETE ON ORS.FACSRV TO CAPSON
;
GRANT INSERT ON ORS.FACSRV TO CAPSON
;
GRANT SELECT ON ORS.FACSRV TO CAPSON
;
GRANT UPDATE ON ORS.FACSRV TO CAPSON
;
GRANT SELECT ON ORS.FACSRV TO OPERATOR
;

-- Insert Data SQL

ALTER SESSION ENABLE PARALLEL DML
;
INSERT INTO ORS.FACSRV(
                       FACILITY_INTERNAL_ID,
                       SRVTYPE,
                       SRVDESC,
                       SRVEFFECT,
                       SRVABBREV,
                       SRVCNT,
                       SRVPROV,
                       SRVPROVDES,
                       SERVICEID,
                       SRVENDDT,
                       DT_LAST_UPDATE
                      )
                SELECT 
                       FACILITY_INTERNAL_ID,
                       SRVTYPE,
                       SRVDESC,
                       SRVEFFECT,
                       SRVABBREV,
                       SRVCNT,
                       SRVPROV,
                       SRVPROVDES,
                       SERVICEID,
                       SRVENDDT,
                       DT_LAST_UPDATE
                  FROM ORS.FACSRV_05272008203836000 
;
COMMIT
;
ALTER TABLE ORS.FACSRV LOGGING
;

-- Add Constraint SQL

ALTER TABLE ORS.FACSRV ADD CONSTRAINT PK_FACSRV
PRIMARY KEY (FACILITY_INTERNAL_ID,SRVTYPE,SRVEFFECT)
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

DROP TRIGGER ORS.TIBR_FACSRV;
/
CREATE OR REPLACE TRIGGER ORS.TIBR_FACSRV
BEFORE INSERT
ON ORS.FACSRV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
  :new.DT_LAST_UPDATE := SYSDATE;
END;
/

DROP TRIGGER ORS.TUBR_FACSRV;
/
CREATE OR REPLACE TRIGGER ORS.TUBR_FACSRV
BEFORE UPDATE
ON ORS.FACSRV
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
   IF ((:OLD.FACILITY_INTERNAL_ID <> :NEW.FACILITY_INTERNAL_ID) OR
      (:OLD.SRVDESC <> :NEW.SRVDESC) OR
      (:OLD.SRVENDDT <> :NEW.SRVENDDT)) THEN
    :new.DT_LAST_UPDATE := SYSDATE;
   END IF;
END;
/

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };
{ call dbms_utility.compile_schema('ORS') };

-- change STGAP00008969
-- Adding a new Code Type to Codes Tables for STGAP00006035 enhancement. 
-- New Code Type is CNUMMULT, and contains Y or N in decode to dictate if the corresponding CNUMTYPE allows multiple instances of itself or not.

insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'CRS ID#', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'CMO ID#', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Medicaid/MHN #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Probation ID#', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'SMILE Client ID#', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'IDS #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Comp. Vendor #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'UID Tool ID', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'AFCARS ID', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Food Stamp #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'MHMR Client #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Medicare #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Other #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Parole #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Prisoner #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'SSN', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'RSDI Claim #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Arrest #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Driver''s License #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'INS #', 'Y', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'Refugee #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'SSI Claim #', 'N', null, sysdate);
insert into CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_END, DT_LAST_UPDATE) values ('CNUMMULT', 'TANF #', 'N', null, sysdate);

-- change STGAP00008940
insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
select 'CaseWorkerChildVisitStatewide', '00', 31, 'A', 'CaseWorker Child Visit Statewide', 'ondport', 'L', 'W', 'Statewide, region, and county totals of face to face contacts made with the primary child during the reporting month. Generated for a specific reporting month with an optional region parameter. Leave the region parameter blank to generate the statewide view of the report.', 'Foster Care', 'Y'
from dual 
where not exists (select 'x' from caps.reports where nm_rpt_sqr_name='CaseWorkerChildVisitStatewide' and nm_rpt_sqr_ver='00');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CaseWorkerChildVisitStatewide', '00', 1, 7, 'MONTHYEAR', 'CHAR', 'Y', 'Month/Year'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CaseWorkerChildVisitStatewide' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='1');

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
select 'CaseWorkerChildVisitStatewide', '00', 2, 2, 'REGIONCD', 'CHAR', 'N', 'Region'
from dual
where not exists (select 'x' from caps.report_parameter where nm_rpt_sqr_name='CaseWorkerChildVisitStatewide' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq='2');

-- change STGAP00008956
INSERT INTO CAPS.CODES_TABLES C (CODE_TYPE, CODE,DECODE,DT_LAST_UPDATE)
VALUES ('CEVNTTYP', 'SRP','Safety Resource',sysdate);

UPDATE CAPS.TASK
SET CD_TASK_EVENT_TYPE = 'SRP'
WHERE CD_TASK IN (7331,2277);


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (327, 'SacwisRev2', 'static table updates,srvcnt change');                        
commit;
