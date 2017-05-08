-- change STGAP00007208
UPDATE CAPS.MESSAGE SET TXT_MESSAGE='You indicated the child was in a hospital when DFCS obtained custody.  An Admission Date is required.' WHERE NBR_MESSAGE='25156';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (284, 'SacwisRev2', 'static table updates - MESSAGE');                        
commit;

