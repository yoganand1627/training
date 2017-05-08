--STGAP00016141 - Release(4.3) MR-087 New Messages

--MR-087 DBCR New messages

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60856,'MSG_RCS_CRT_RVW_PAST','Court Review Due By date must be the current date or a future date.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60857,'MSG_RCS_18_PRIOR_TO_CRT_RVW','Child will turn 18 prior to the next Court Review. Select checkbox or correct DOB.',700,500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1018, 'SacwisRev4', 'Release 4.3 - DBCR 16141');

commit;

