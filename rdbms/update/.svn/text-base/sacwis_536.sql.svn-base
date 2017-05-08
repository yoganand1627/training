--STGAP00015353 - Remove Alleged Maltreator from Intake, Allegations

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CINTROLE'
AND code = 'AP'; 

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CINTROLE'
AND code = 'UK'; 

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CINVROLE'
AND code = 'AP';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CINVROLE'
AND code = 'UK';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CROLEALL'
AND code = 'AP';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CROLEALL'
AND code = 'UK';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CROLEALL'
AND code = 'UN';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CROLES'
AND code = 'AP';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CROLES'
AND code = 'UK';

UPDATE caps.codes_tables 
SET dt_end = sysdate 
WHERE dt_end IS NULL 
AND code_type = 'CCHKROLE'
AND code = 'AP';


insert into caps.schema_version (id_schema_version, application_version, comments)
            values (537, 'SacwisRev3', 'Release 3.3 - DBCR 15353');


commit;

