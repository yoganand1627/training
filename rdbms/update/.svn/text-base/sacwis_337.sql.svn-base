-- Release 2.5 
-- Standard Alter Table SQL
--change STGAP00009241 

ALTER TABLE CAPS.NON_COMPLIANCE ADD IND_ST_OFF_CONCURRENCE VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.NON_COMPLIANCE ADD DT_ST_OFF_CONCURRENCE DATE     NULL
;
ALTER TABLE CAPS.NON_COMPLIANCE ADD IND_CAP_CONCURRENCE VARCHAR2(1)     NULL
;
ALTER TABLE CAPS.NON_COMPLIANCE ADD DT_CAP_CONCURRENCE DATE     NULL
;

{ call dbms_utility.compile_schema('CAPS') };
{ call dbms_utility.compile_schema('CAPSBAT') };
{ call dbms_utility.compile_schema('CAPSON') };
{ call dbms_utility.compile_schema('OPERATOR') };
{ call dbms_utility.compile_schema('SACWISIFC') };


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (338, 'SacwisRev2', 'static table updates, 4 new columns for NON_COMPLIANCE');                        
commit;
