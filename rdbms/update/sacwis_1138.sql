--STGAP00017211 - Release(5.0) Modify launch page descrptn of ChildManagement Rpt

--DBCR STGAP00017211
-- Modify the launch page report description of the ChildManagementreport.
-- ClearQuest # STGAP00016526


update caps.reports
set nm_rpt_desc = 'A list of all children under 18 years of age, in DFCS custody, registered with the Adoption Exchange who have at least one TPR or VS or an open ADO stage and have not been adopted as of the report run date. Generated for optional region and county parameters.'
where nm_rpt_sqr_name = 'MonthlyChildMangement' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1139, 'SacwisRev5', 'Release 5.0 - DBCR 17211');

commit;
