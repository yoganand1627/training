--STGAP00015973 - Release(4.0) MR-70: Batch Alerts add column set default val

--8/24/2010
alter table CAPS.YRPP_LINK add ID_PERSON Number(16,0) not null;
ALTER TABLE CAPS.YRPP_LINK MODIFY(ID_PORTAL_USER  NULL);
ALTER TABLE CAPS.YRPP_LINK MODIFY (IND_NYTD_GREET_EMAIL_SENT default 'N');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (879, 'SacwisRev4', 'Release 4.0 - DBCR 15973');

commit;

