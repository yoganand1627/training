--STGAP00017094 - Release(5.0) CREATE NEW PLACEMENT COLUMNS

ALTER TABLE caps.placement ADD (DT_LAST_PLCMT_LOG_VIEW DATE);

ALTER TABLE caps.placement ADD (DT_CASE_MNGR_CERT DATE);

ALTER TABLE caps.placement ADD (DT_SUP_CERT DATE);

ALTER TABLE caps.placement ADD (IND_CASE_MNGR_CERT VARCHAR (1));

ALTER TABLE caps.placement ADD (IND_SUP_CERT VARCHAR (1));

ALTER TABLE caps.placement ADD (ID_CASE_MNGR_CERT NUMBER (16, 0));

ALTER TABLE caps.placement ADD (ID_SUP_CERT NUMBER (16, 0));

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1101, 'SacwisRev5', 'Release 5.0 - DBCR 17094');

commit;
