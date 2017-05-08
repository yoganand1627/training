-- All changes for version 2.21 of SHINES

-- change STGAP00007477
UPDATE CAPS.CODES_TABLES SET DECODE = 'There has not been an extension of custody, in the past 12 months, since the most recent custody order.'
WHERE CODE_TYPE = 'CFCERNE' AND CODE = 'R08';

-- change STGAP00007479
UPDATE CAPS.MESSAGE SET txt_message = 'The question ''Has there been an extension of custody, in the past 12 months, since the most recent custody order?'' must be answered.'
WHERE txt_message_name = 'MSG_EXTENSION_CUSTODY_REQ';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (292, 'SacwisRev2', 'static table updates');                        
commit;

