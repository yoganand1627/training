
-- Trigger for logon to set data format and default schema to CAPS
/
CREATE OR REPLACE TRIGGER SYSTEM.TLA_SHINES_LOGON
AFTER LOGON ON DATABASE
DECLARE
   SHINES_USER VARCHAR2(30) ;
   CMD varchar2(100) ;
BEGIN
    CMD := 'ALTER SESSION SET NLS_DATE_FORMAT='||chr(39)||'MM/DD/YYYY'||chr(39) ;
    EXECUTE IMMEDIATE CMD;
    SELECT USER INTO SHINES_USER FROM DUAL ;
    IF SHINES_USER='CAPSON' OR SHINES_USER='CAPSBAT' OR SHINES_USER='OPERATOR' THEN
       CMD := 'ALTER SESSION SET CURRENT_SCHEMA=CAPS' ;
       EXECUTE IMMEDIATE CMD;
    END IF;
END;
/

ALTER TABLE CAPS.CHARACTERISTICS MODIFY(CD_CHARACTERISTIC VARCHAR2(3 BYTE));

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };


UPDATE caps.metaphor 
SET txt_filter_path = NULL 
WHERE id_tab = 1180; 

UPDATE caps.TASK 
SET txt_2nd_tab = 'RISK_ASSESSMENT_RISKASSMT' 
WHERE cd_task = 2330; 

UPDATE caps.TASK 
SET txt_3rd_tab = 'RISK_ASSESSMENT_RISKASSMT_3RD', 
ind_task_code_prefer = 3 
WHERE cd_task = 2295;

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (12, 'SacwisRev1', 'Expand CD_CHARACTERISTIC, update METAPHOR table, add LOGON trigger.');
                         
commit;
