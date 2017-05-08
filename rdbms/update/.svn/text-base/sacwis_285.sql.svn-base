-- All changes for version 2.3 of SHINES

-- change STGAP00007270
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='You have entered Status as Closed and must enter a value in the Change Of Status Reason section' WHERE NBR_MESSAGE='25006';

-- change STGAP00007276

insert into caps.message
(id_message, dt_last_update, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
values
(0, sysdate, 60381, 'MSG_FCE_CSUPREF_INDPRPAR','Please identify a Principal that is a Parent when referring the child for child support','700','500','N');


insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (286, 'SacwisRev2', 'static table updates');                        
commit;

