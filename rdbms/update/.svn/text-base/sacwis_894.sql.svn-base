--STGAP00015991 - Release(4.0) To modify description of NYTDrpt on the launch pag

-- to change the description on the launch page
-- SMS # 67689
-- DBCR  STGAP00015991

update caps.reports
set nm_rpt_desc = 'List of children currently in Foster Care (FCC), Adoption (ADO), or Post Foster Care (PFC) stages eligible for ILP services not having their Youth Report Detail Page completed for the NYTD reporting period. Generated for specific reporting period and optional Region and County parameters.'
where nm_rpt_sqr_name = 'ChildrenMissingYouthReportDetailForNYTD' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (895, 'SacwisRev4', 'Release 4.0 - DBCR 15991');

commit;

