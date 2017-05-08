--STGAP00016115 - Release(4.2) RefMR75 UpdateFosterHMonthlystatus Def page chang

---- SMS# 98081 Reference MR75 Update DFCS Foster Home Monthly status launch page to add new
---- status wording to definition


update caps.reports
set nm_rpt_desc = 'Monthly status view of the number of Active - Approved(Full), Approved(Special) DFCS Foster Homes, Full 30 Day Grace, Special 30 Day Grace and Unapproved in the County, Region or Statewide. Generated for specific Month and optional Region and County parameters.'
where nm_rpt_sqr_name = 'DFCSFosterHomeMonthlyStatus';



insert into caps.schema_version(id_schema_version,application_version,comments)
            values (998, 'SacwisRev4', 'Release 4.2 - DBCR 16115');

commit;


