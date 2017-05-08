--STGAP00015896 - Release(3.6) Add new parameters to Home/Facility List Rpt

-- For SMS#51990
update caps.reports
set txt_rpt_full_name = 'Home List'
, nm_rpt_desc = 'A list of active Foster/Adoptive DFCS or Non DFCS Homes
displayed with contact information, approved capacity, and open slots. Generated for a specific home type with optional category, status, region and county parameters.'
where nm_rpt_sqr_name = 'HomeFacilityList'
and nm_rpt_sqr_ver = '00';


update caps.report_parameter
set nm_rpt_parm_label = 'Home Type'
where  nm_rpt_parm_name = 'FACILITYCD'
 AND  nm_rpt_sqr_name = 'HomeFacilityList'
and nm_rpt_sqr_ver = '00';


update caps.report_parameter
set nbr_rpt_parm_seq = '5', ind_required = 'N'
where  nm_rpt_parm_name = 'COUNTYCD'
AND nm_rpt_sqr_name = 'HomeFacilityList'
and nm_rpt_sqr_ver = '00';


update caps.report_parameter
set nbr_rpt_parm_seq = '4', ind_required = 'N'
where  nm_rpt_parm_name = 'REGIONCD'
AND nm_rpt_sqr_name = 'HomeFacilityList'
and nm_rpt_sqr_ver = '00';


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('HomeFacilityList','00','2','1','CATEGORYCD', 'CHAR', 'N', 'Category');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('HomeFacilityList','00','3','3','FAHOMESTATUSCD', 'CHAR', 'N','Status');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (819, 'SacwisRev3', 'Release 3.6 - DBCR 15896');

commit;


