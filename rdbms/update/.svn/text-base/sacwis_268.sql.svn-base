-- change STGAP00006772
UPDATE CAPS.MESSAGE SET txt_message='You have indicated a Change Of Status Reason without setting the status to ''Closed'' or ''Pending Closure'''
WHERE txt_message_name='MSG_NO_CLOSURE';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (269, 'SacwisRev2', 'static table updates');                        
commit;
