--STGAP00017072 - Release(5.0) MR-092 - New message

INSERT INTO caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
VALUES (0, 60906, 'MSG_SSI_APP_SUBMITTED_REQ', 'Please indicate if an application was submitted to the SSA for SSI.', 700, 500, 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1089, 'SacwisRev5', 'Release 5.0 - DBCR 17072');

commit;

