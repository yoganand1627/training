-- All changes for version 2.3 of SHINES

-- change STGAP00007892
UPDATE CAPS.MESSAGE
SET TXT_MESSAGE = 'Only resources of type Home/Other Facility OR MHMR Facility are valid for placement payments through this page. Please confirm the placement type and contact your resource maintainer as appropriate.'
WHERE NBR_MESSAGE = 60392
AND TXT_MESSAGE_NAME = 'MSG_PLCMT_RSRC_TYP_INVALID';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (303, 'SacwisRev2', 'static table updates - cosmetic change');                        
commit;

