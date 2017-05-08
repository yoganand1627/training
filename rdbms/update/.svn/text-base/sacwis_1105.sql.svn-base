--STGAP00017108 - Release(5.0) modify the descrpn of ConsiderationOverdue report

--  Consideration Overdue Report
-- Report Defect No STGAP00017105
-- DBCR to change the description on the launch page.
-- DBCR ClearQuest No: STGAP00017108


update caps.reports
set nm_rpt_desc = 'A list of registered children in consideration whose date out is more than 15 calendar days. Generated for optional region and county parameters.'
where nm_rpt_sqr_name = 'ConsiderationOverdue' and nm_rpt_sqr_ver = '00';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1106, 'SacwisRev5', 'Release 5.0 - DBCR 17108');

commit;
