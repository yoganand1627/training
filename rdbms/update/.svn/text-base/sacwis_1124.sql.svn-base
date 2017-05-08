--DBCR STGAP00017145
-- Modify the report description, orientation, security of the ChildManagementreport
-- ClearQuest # STGAP00016526


update caps.reports
set nm_rpt_orientation = 'L' ,
nm_rpt_desc = 'A list of all children registered with the Adoption Exchange but have not been adopted, with at least one TPR or VS or with an open ADO stage.
The report only pulls children under 18 years of age who are in DFCS custody as of the report run date. Generated for optional region and county parameters.',
cd_sec_attr = ''
where nm_rpt_sqr_name = 'MonthlyChildMangement' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1125, 'SacwisRev5', 'Release 5.0 - DBCR 17145');

commit;
