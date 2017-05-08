--STGAP00015992 - Release(4.0) MR-70: Batch Alerts add columns and rename column

--9/14/2010
alter table CAPS.YRPP_LINK add DT_REPORTING_PERIOD_START DATE not null;
alter table CAPS.YRPP_LINK add DT_REPORTING_PERIOD_END DATE not null;
alter table CAPS.YRPP_LINK rename column NYTD_BASELINE_YEAR to REPORTING_YEAR;


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (897, 'SacwisRev4', 'Release 4.0 - DBCR 15992');

commit;

