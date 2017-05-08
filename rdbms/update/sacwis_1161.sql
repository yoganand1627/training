--STGAP00017569 - Release(5.0) Add new Rpt Resource Placement History Log

---- Insert new Placement History Log Report under the Resource Tab
----SMS # 116757
-----ASR#: 10672

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, 
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, 
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page) 
values ('ResourcePlacementHistoryLog', '00', 31, 'A', 'Placement History Log','ondport', 'L', 'W','A history of children who have been placed in a specified resource.', 'Resource Development', 'Y');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, 
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ResourcePlacementHistoryLog','00','1','16','RESOURCEID', 'NUMBER', 'Y', 'Resource ID');

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1162, 'SacwisRev5', 'Release 5.0 - DBCR 17569');

commit;
