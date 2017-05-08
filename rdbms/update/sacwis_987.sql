--STGAP00016104 - Release(4.2) MR-074-2 AFCARS: update msg per client request

-- SMS#97845 MR-074-2 AFCARS updated messages per client request
update caps.message
set TXT_MESSAGE_NAME = 'MSG_LEG_STAT_ADO_APP_APRV_AGMT_ERR_NI',
TXT_MESSAGE = 'There is an active Adoption Assistance Agreement in COMP status, but it should be linked to a monthly (Basic, Custom or Specialized Rate) Adoption Assistance Application in APRV status.'
where NBR_MESSAGE = 60823
;
update caps.message
set TXT_MESSAGE_NAME = 'MSG_LEG_STAT_ADO_APP_APRV_ERR_NI'
where NBR_MESSAGE = 60825
;
update caps.message
set TXT_MESSAGE_NAME = 'MSG_LEG_STAT_ADO_APP_AGMT_ERR',
TXT_MESSAGE = 'There must be an active Adoption Assistance Agreement (not Special Services or Non-Recurring) in COMP status linked to a monthly (Basic, Custom or Specialized Rate) Adoption Assistance Application in APRV status.'
where NBR_MESSAGE = 60821
;
update caps.message
set TXT_MESSAGE = 'There is an active Adoption Assistance Agreement in COMP status, but it should be linked to a monthly (Basic, Custom or Specialized Rate) Adoption Assistance Application in APRV status.'
where NBR_MESSAGE = 60822
;
update caps.message
set txt_message = 'One or more parents is missing documentation. All parents must have either a TPR Court Order Date with an outcome of TPR Granted, Voluntary Surrender Action Date, or Date of Death. A parent with a Date of Death must have a relationship of either Biological Mother, Legal Mother, Bi
ological Father, Biological and Legal Father, Legal Father, Putative Father or Biological Parent (with Gender of Male or Female).'
where txt_message_name = 'MSG_MISSING_PARENT_TPR'
;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (988, 'SacwisRev4', 'Release 4.2 - DBCR 16104');

commit;

