-- All changes for version 2.4 of SHINES

-- change STGAP00008136
update caps.reports
set nm_rpt_desc = 'A list of children in foster care age 14 and older in the county. Generated for a specific county with an optional case manager parameter.'
where nm_rpt_sqr_name = 'FosterCareAge14AndOlder';

update caps.report_parameter
set nm_rpt_parm_name = 'STAFFID', nm_rpt_parm_label = 'Staff ID'
where nm_rpt_sqr_name = 'FosterCareAge14AndOlder' 
and nbr_rpt_parm_seq = '2';

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (315, 'SacwisRev2', 'static table updates');                        
commit;

