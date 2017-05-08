--STGAP00017502 - Release(5.0) Modify rpt descn, security OverdueLifeHistoriesRpt

--DBCR STGAP00017502
-- Modify the report description, security of the Childen With Overdue Life Histories Report
-- ClearQuest # STGAP00017106


update caps.reports
set nm_rpt_desc = 'A list of all children in adoption stage, under 18 years of age, and in DFCS custody with no approved child life history checklist record on the case with out TPR/VS or it has been more than 60 days since the TPR or VS of the first parent. Generated for optional region and county
parameters.',
cd_sec_attr = ''
where nm_rpt_sqr_name = 'ChildrenWithOverdueLifeHistories'
and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1159, 'SacwisRev5', 'Release 5.0 - DBCR 17502');

commit;
