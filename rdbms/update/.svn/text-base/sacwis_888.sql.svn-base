--STGAP00015983 - Release(4.0) MR-067 New message and codes table update

--STGAP00015983 MR-067 New messages and codes table update

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60774,'MSG_CMN_YDP_NO_OHIT_MED','Youth does not have medical coverage according to question #16a, response should be N/A.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60775,'MSG_CMN_YDP_NO_OHIT','Youth does not have health insurance according to question #16, response should be N/A.',700,500,'N');

insert into caps.message (id_message, nbr_message, txt_message_name, txt_message, cd_source, cd_presentation, ind_batch)
  values (0,60776,'MSG_CMN_YDP_NO_CHLD','Youth has not given birth or fathered a child according to question #13, response should be N/A.',700,500,'N');

UPDATE caps.message
set txt_message = 'The data in the General Information section has changed due to updates in the Person Detail page, please save this page to ensure youth data is up-to-date for federal reporting.'
WHERE txt_message_name = 'MSG_CMN_YDP_UPDATE';

update caps.codes_tables
set dt_end = sysdate
where code_type = 'COUTSTAT'
and code = 'NS'
and dt_end is null;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (889, 'SacwisRev4', 'Release 4.0 - DBCR 15983');

commit;


