--change STGAP00007152
-- Reporting Table Updates To Support Release 2.2

update caps.report_parameter set nbr_rpt_parm_length = '10', nm_rpt_parm_name = 'STARTDATE', txt_rpt_parm_type = 'DATE'
where nm_rpt_sqr_name='OnCall' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=1;

update caps.report_parameter set nbr_rpt_parm_length = '10', nm_rpt_parm_name = 'ENDDATE', txt_rpt_parm_type = 'DATE'
where nm_rpt_sqr_name='OnCall' and nm_rpt_sqr_ver='00' and nbr_rpt_parm_seq=2;

update caps.reports set txt_rpt_full_name = 'Case Worker Child Visit'
where nm_rpt_sqr_name = 'CaseWorkerChildVisit';

update caps.reports set nm_rpt_area_type = 'Investigations'
where nm_rpt_sqr_name = 'PendingIncidents';

update caps.reports set nm_rpt_area_type = 'Resource Development'
where nm_rpt_sqr_name = 'HomeFacilityList';

update caps.reports set nm_rpt_desc = 'Statewide, region, and county totals of investigation stages pending more than 45 days. This report accepts an optional region parameter. Leave the region parameter blank to generate the statewide view of the report.'
where nm_rpt_sqr_name = 'OverduePendingStatewide';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (281, 'SacwisRev2', 'Reporting Table Updates To Support Release 2.2');                        
commit;