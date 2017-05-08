-- All changes for version 2.4 of SHINES

-- change STGAP00007759
UPDATE CAPS.MESSAGE 
SET txt_message = 'End Date must not be more than 5 days from the Start Date for Respite placements.' 
WHERE nbr_message = 60272;

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (299, 'SacwisRev2', 'static table updates');                        
commit;

