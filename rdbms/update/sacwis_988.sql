--STGAP00016105 - Release(4.2) MR-075 Add new messages.

-- new placement validation messages
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60826,'MSG_FAD_GCIC_NCIC_NOT_CURRENT','GCIC or NCIC Records Checks are not current. Update documentation or select home status of ''30 Day Grace''.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60827,'MSG_FAD_MEDICAL_NOT_CURRENT','Medicals are not current. Update documentation or select home status of ''30 Day Grace''.',700,500,'N');

-- new policy waiver validation messages
insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60828,'MSG_FAD_WVR_PERIOD_EXPIRED','30 Day Grace Policy Waiver is no longer needed. Home should be closed.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0, 60829,'MSG_FAD_WVR_HOME_INVALID_STATUS','Home current status does not warrant a 30 Day Grace Policy Waiver.',700,500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (989, 'SacwisRev4', 'Release 4.2 - DBCR 16105');

commit;

