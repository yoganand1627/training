--STGAP00016082 - Release(4.2) MR75Remove thevalue Temp apprvl from rpt launchpge

-- SMS# 98081
--Reference MR75 Remove the value temporary approval from report description on launch page

update caps.reports
set nm_rpt_desc = 'Monthly status view of the number of Active - Approved(Full) and Approved(Special) DFCS Foster Homes in the County, Region or Statewide. Generated for specific Month and optional Region and County parameters.'
where nm_rpt_sqr_name = 'DFCSFosterHomeMonthlyStatus'
and nm_rpt_sqr_ver = '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (968, 'SacwisRev4', 'Release 4.2 - DBCR 16082');

commit;

