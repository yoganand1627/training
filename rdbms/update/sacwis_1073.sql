--STGAP00017039 - Release(4.3.1) Modify data type precision for FCE_ELIGIBILITY

ALTER TABLE CAPS.FCE_ELIGIBILITY
MODIFY AMT_CSUP_WITH_UNEARNED_INCOME number (16,2);

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1074, 'SacwisRev4', 'Release 4.3.1 - DBCR 17039');

commit;


