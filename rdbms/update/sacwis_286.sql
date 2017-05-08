-- All changes for version 2.3 of SHINES

-- change STGAP00007329
update caps.Task 
set txt_3rd_tab = 'CONTACTS_SUMMARIES_CONTACTSEARCH_3RD'
where cd_task in (3910,8060,4120,1010,2180,3010,8520,9010,7020,3810,1510,6530);

-- change STGAP00007359
UPDATE CAPS.CODES_TABLES SET DECODE = '58242 - IDA Match' WHERE CODE = '58242' 
AND CODE_TYPE = 'CSVCCODE';

UPDATE CAPS.CODES_TABLES SET DECODE = '42 - IDA Match' WHERE CODE = '42' 
AND CODE_TYPE = 'CENTCODE';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (287, 'SacwisRev2', 'static table updates');                        
commit;

