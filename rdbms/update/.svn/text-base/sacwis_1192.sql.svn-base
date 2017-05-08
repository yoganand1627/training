--STGAP00017859 - Release(5.1) Insert a new ,message to the mesage table

--DBCR   for adding a new message for MR-097 - Unsubstantiated MIC
--Clear quest reference STGAP00017829

insert into caps.message  (id_message, dt_last_update, nbr_message,TXT_MESSAGE_NAME,TXT_Message)
values (16800546, sysdate, 60946,'MSG_INV_NOTIFICATION_COMMENT_REQ', 'Comment is required when the answer for ''Was the foster parent notified of the right to have an advocate present?'' is ''No'' and Maltreatment in Care exists.');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1193, 'SacwisRev5', 'Release 5.1 - DBCR 17859');

commit;
