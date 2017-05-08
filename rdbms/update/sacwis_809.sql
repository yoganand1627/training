--STGAP00015881 - Release(3.5) Update MSG_APRV_REQ_BEFORE_SAVE_CLOSE

--Update MSG_APRV_REQ_BEFORE_SAVE_CLOSE message  changing message text
--from 'Status must be Approved before a Save and Close.'  to  'Status must be Denied
--or Closed before a Save and Close.'

Update CAPS.MESSAGE
SET txt_message = 'Status must be Denied or Closed before a Save and Close.'
where id_message = 17014
and txt_message_name = 'MSG_APRV_REQ_BEFORE_SAVE_CLOSE'
and txt_message = 'Status must be Approved before a Save and Close.';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (810, 'SacwisRev3', 'Release 3.5 - DBCR 15881');

commit;


