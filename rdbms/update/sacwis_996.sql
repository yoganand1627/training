--STGAP00016113 - Release(4.2) MR-074-2 AFCARS LS AA messages

-- SMS#97845 MR-074-2 AFCARS

INSERT INTO CAPS.MESSAGE
(ID_MESSAGE,DT_LAST_UPDATE,NBR_MESSAGE,TXT_MESSAGE_NAME,
TXT_MESSAGE,CD_SOURCE,CD_PRESENTATION,IND_BATCH)
VALUES
(0,SYSDATE,60830,'MSG_LEG_STAT_MISSING_MONTHLY_AA_APP_ERR_NI',
'There must be a monthly (Basic, Custom or Specialized rate) Adoption Assistance Application in APRV status in order to finalize the adoption.',
700,500,'N');

update caps. message
set TXT_MESSAGE = 'There is at least one approved or deferred monthly (Basic, Custom or Specialized Rate) Adoption Assistance Application in APRV status, but there is no active Adoption Assistance Agreement in COMP status linked to it.'
where TXT_MESSAGE_NAME = 'MSG_LEG_STAT_ADO_APP_APRV_AGMT_ERR_NI'
;

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (997, 'SacwisRev4', 'Release 4.2 - DBCR 16113');

commit;


