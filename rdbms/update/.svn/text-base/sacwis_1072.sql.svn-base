--STGAP00017037 - Release(4.3.2) Add new column to FCE_ELIGIBILITY for childsupport

ALTER TABLE CAPS.FCE_ELIGIBILITY
    ADD AMT_CSUP_WITH_UNEARNED_INCOME number (16);



    COMMENT ON COLUMN CAPS.FCE_ELIGIBILITY.AMT_CSUP_WITH_UNEARNED_INCOME
    IS
      'Child Support with Unearned Income';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1073, 'SacwisRev4', 'Release 4.3.2 - DBCR 17037');

commit;

