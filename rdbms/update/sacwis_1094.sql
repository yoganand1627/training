--STGAP00017078 - Release(5.0) New Message


INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0,60911, 'SSM_TOO_MANY_ROWS_RETURNED', 'Too many rows returned.', 700, 500, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1095, 'SacwisRev5', 'Release 5.0 - DBCR 17078');

commit;
