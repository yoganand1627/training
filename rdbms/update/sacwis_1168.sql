--DBCR STGAP00017705
-- Modify the report description of the Childen With Overdue Life Histories Report
-- ClearQuest # STGAP00017106


update caps.reports set nm_rpt_desc = 'A list of all children in adoption stage, under 18 years of age, and in DFCS custody with no approved child life history checklist record on the case and it has been more than 60 days since the TPR or VS of the first parent. Generated for optional region and county parameters.' where nm_rpt_sqr_name = 'ChildrenWithOverdueLifeHistories' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1169, 'SacwisRev5', 'Release 5.0 - DBCR 17705');

commit;