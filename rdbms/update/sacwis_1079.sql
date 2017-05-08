--STGAP00017050 - Release(5.0) MR-092 New Person_Dtl columns

ALTER TABLE caps.PERSON_DTL ADD (
  IND_SSI_APP_SUBMITTED VARCHAR(1),
  IND_SSI_MED_DSBLTY_REQ_MET VARCHAR(1),
  IND_SSI_RECIPIENT VARCHAR(1),
  IND_SSI_DFCS_PAYEE VARCHAR(1)
);


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1080, 'SacwisRev5', 'Release 5.0 - DBCR 17050');

commit;
