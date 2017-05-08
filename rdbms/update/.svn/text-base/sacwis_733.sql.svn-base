--STGAP00015771 - Release(3.5) per CAPTA - insert new code in CEVNTTYP

 --Add new Codes Tables value for Event type of CNS 'Child Death/Near Fatality/Serious Injury'
 INSERT INTO caps.codes_tables
 (Code_type, code, decode, dt_last_update)
 VALUES('CEVNTTYP', 'CNS','Child Death/Near Fatality/Serious Injury', sysdate);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (734, 'SacwisRev3', 'Release 3.5 - DBCR 15771');


commit;
 
