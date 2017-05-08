-- All changes for version 2.3 of SHINES

-- change STGAP00007432
INSERT INTO CAPS.MESSAGE (nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch) 
VALUES (99314, 'MSG_EXTENSION_CUSTODY_REQ', 'The question ''Was extension of custody provided within 12 months of removal?'' must be answered.', '560', '740', 'N');

-- change STGAP00007433
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='You have entered Status as Pending Closure and must enter a value in the Change Of Status Reason section.' WHERE NBR_MESSAGE='25006';


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (290, 'SacwisRev2', 'static table updates');                        
commit;
