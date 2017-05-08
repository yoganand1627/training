
-- Standard Alter Table SQL

ALTER TABLE CAPS.CASE_BUDGET_LIMIT DROP PRIMARY KEY DROP INDEX
;
ALTER TABLE CAPS.CASE_BUDGET_LIMIT MODIFY(CD_SVC_CODE  NOT NULL)
;
ALTER TABLE CAPS.CASE_BUDGET_LIMIT ADD CD_SVC_AUTH_STATUS VARCHAR2(4)     NULL
;
ALTER TABLE CAPS.CASE_BUDGET_LIMIT ADD CONSTRAINT PK_CASE_BUDGET_LIMIT
PRIMARY KEY (ID_CASE, CD_SVC_CODE)
USING INDEX TABLESPACE INDEX01
    ENABLE
    VALIDATE
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };

-- change STGAP00001920
INSERT INTO CAPS.METAPHOR
(
  ID_TAB,
  TXT_TAB_URL,
  TXT_TAB_CONSTANT,
  TXT_TAB,
  TXT_L1_IMG_INACTIVE,
  TXT_L1_IMG_ACTIVE,
  TXT_FILTER_PATH,
  DT_LAST_UPDATE 
)
VALUES(1235, '/financials/CaseBudgetLimitList/displayCaseBudgetLimit', 'CASE_BUDGET_LIMIT','Case Budget Limit','','','',SYSDATE);

-- change STGAP00001921
insert into caps.codes_tables (code_type, code, decode,dt_last_update) values('CEVNTTYP','POC','Payment of Care',sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                         values (152, 'SacwisRev2', 'static updates, schema changes');
commit;
