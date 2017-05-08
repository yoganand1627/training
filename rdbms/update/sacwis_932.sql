--STGAP00016040 - Release(4.1) MR-053 Add new message.

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60814,'MSG_REMOVAL_YEAR_NOT_CURRENT','Removal Date year is not the same as current year. Do you wish to continue? Click OK to continue or Cancel to stay on the page.',700,500,'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (933, 'SacwisRev4', 'Release 4.1 - DBCR 16040');

commit;

