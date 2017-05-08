--STGAP00016054 - Release(4.1) MR-53: Add fce review batch alerts param

--12/15/2010
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'FOSTERCAREREIMBURSABILITYDUE', 'Y');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (946, 'SacwisRev4', 'Release 4.1 - DBCR 16054');

commit;

