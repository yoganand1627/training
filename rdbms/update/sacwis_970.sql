--STGAP00016090 - Release(4.2) MR-75: Add new entry in BATCH_ALERTS_PARAM

--02/25/2011
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'APRVHOMESTATUSCHANGE', 'Y');
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'VERIFICATIONNOTRECEIVED', 'Y');
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'30DAYGRACECOMPWAIVEREXP', 'Y');
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'MEDICALRECORDSCHECKDUE', 'Y');
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'GCICRECORDSCHECKDUE', 'Y');
insert into CAPS.BATCH_ALERT_PARAMS (ID_BATCH_ALERT_PARAMS,ALERT_EMAIL_STEP_NAME, IND_RUN) values(0,'NCICRECORDSCHECKDUE', 'Y');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (971, 'SacwisRev4', 'Release 4.2 - DBCR 16090');

commit;
