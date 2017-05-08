--STGAP00017131 - Release(5.0) Modify security attr,launchpage descConsOverdue rp

-- Modify security attribute and description on the launch page of the ConsiderationOverdue Report
-- Report Defect No STGAP00017105

--DBCR STGAP00017131

update CAPS.reports set cd_sec_attr = '',
nm_rpt_desc='A list of registered children in DFCS custody under consideration whose date out is more than 15 calendar days. Generated for optional region and county parameters.'
where nm_rpt_sqr_name = 'ConsiderationOverdue' and nm_rpt_sqr_ver = '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1116, 'SacwisRev5', 'Release 5.0 - DBCR 17131');

commit;
