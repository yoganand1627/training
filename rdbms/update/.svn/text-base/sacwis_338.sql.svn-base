-- Release 2.5 

--STGAP00009243
--Updating Codes tables
UPDATE caps.codes_tables 
SET DECODE = '8094' 
WHERE CODE_TYPE = 'CEVNTAPV' 
AND code = 'CRA';

UPDATE caps.codes_tables 
SET DECODE = '8093' 
WHERE CODE_TYPE = 'CEVNTAPV' 
AND code = 'VLT';

--Inserting 
INSERT INTO caps.codes_tables 
(CODE_TYPE, CODE, DECODE, DT_LAST_UPDATE) 
VALUES 
('CPOLVIOL', 'IAS', 'Inadequate Supervision', sysdate);

--STGAP00009242
update caps.codes_tables
set decode = 'Not In DFCS Custody - Permanent Custody To Relative'
where code_type = 'CLEGSTAT'
and code = 'NPR';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (339, 'SacwisRev2', 'static table updates');                        
commit;
