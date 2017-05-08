-- Standard Alter Table SQL
-- STGAP00007223
ALTER TABLE CAPS.FCE_REVIEW  ADD IND_EXTNSION_PROVIDED_12_MNTHS VARCHAR2(1)     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };

-- change STGAP00007185
INSERT INTO CAPS.CODES_TABLES(code_type,code,decode,dt_last_update)VALUES('CFCERNE','R08','An extension of custody was not provided within 12 months of removal',sysdate);

insert into caps.schema_version (id_schema_version, application_version, comments)
                       values (283, 'SacwisRev2', 'static table updates');

commit;