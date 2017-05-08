-- Release 2.5 
-- Standard Alter Table SQL

-- change STGAP00009158
ALTER TABLE CAPS.STAGE MODIFY(TXT_STAGE_PRIORITY_CMNTS  VARCHAR2(500))
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00009155
update caps.codes_tables
set dt_end = sysdate
where code_type = 'CPL'
and code in ('16','20','34','49','53','51','86','48','06');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (334, 'SacwisRev2', 'static table updates, comment field expansion');                        
commit;
