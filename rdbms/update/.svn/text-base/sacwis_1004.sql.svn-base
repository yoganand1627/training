--STGAP00016124 - Release(4.3) MR-75: Update entry in BATCH_ALERTS_PARAM

--4/26/2011
update caps.BATCH_ALERT_PARAMS set ALERT_EMAIL_STEP_NAME = '60-90DAYFADHOMEWAIVEREXP' where ALERT_EMAIL_STEP_NAME = '30DAYGRACECOMPWAIVEREXP';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1005, 'SacwisRev4', 'Release 4.3 - DBCR 16124');

commit;

