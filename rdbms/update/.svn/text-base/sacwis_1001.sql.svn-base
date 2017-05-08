--STGAP00016121 - Release(4.2) MR-074-2 AFCARS: Legal Status messages update

-- MR-074-2: update per client request

update caps.message
set txt_message = 'There is at least one approved (Basic, Custom or Specialized Rate) or deferred monthly Adoption Assistance Application in APRV status, but there is no active Adoption Assistance Agreement in COMP status linked to it.'
where txt_message_name = 'MSG_LEG_STAT_ADO_APP_APRV_AGMT_ERR_NI';

delete caps.message
where txt_message_name = 'MSG_LEG_STAT_MISSING_MONTHLY_AA_APP_ERR_NI';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1002, 'SacwisRev4', 'Release 4.2 - DBCR 16121');

commit;

