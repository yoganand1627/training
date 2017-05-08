-- Standard Alter Table SQL

ALTER TABLE SACWISIFC.CHILD_SUPPORT_INBOUND ADD CD_CHILD_SUP_PAYMNT_PROCESS VARCHAR2(2)     NULL
;

{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00008534
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '00', 'Payment processed correctly no errors', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '01', 'Non Custodial Parent CrsId not found', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '02', 'County by CrsId not found', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '03', 'Payement is null', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '04', 'Stage not found', SYSDATE);
INSERT INTO CAPS.CODES_TABLES (CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) VALUES ('CPMTPROC', '05', 'No Income and Resources updated', SYSDATE);

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (319, 'SacwisRev2', 'static table updates, new STARS interface field');                        
commit;
