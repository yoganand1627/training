--STGAP00015904 - Release(3.6) Home List- Update rpt launch page

-- For SMS#51990
update caps.reports
set nm_rpt_desc = 'A list of  Foster/Adoptive DFCS or Non DFCS Homes displayed with contact information, capacity and open slots. Generated for a specific home type with optional category, status, region and county parameters.' 
where nm_rpt_sqr_name = 'HomeFacilityList' and nm_rpt_sqr_ver = '00';


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (827, 'SacwisRev3', 'Release 3.6 - DBCR 15904');

commit;

