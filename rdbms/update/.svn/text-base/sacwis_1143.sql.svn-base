--STGAP00017266 - Release(5.0) Insert new Placement Log rpt (Resource Dev)

---- Insert new Placement Log Report under the Resource Tab
----SMS # 116756
-----ASR#: 10670

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type,
txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options,
nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ResourcePlacementLog', '00', 31, 'A', 'Placement Log','ondport', 'L', 'W','A list of children currently placed in a specified resource.', 'Resource Development', 'Y');


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('ResourcePlacementLog','00','1','16','RESOURCEID', 'NUMBER', 'Y', 'Resource ID');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1144, 'SacwisRev5', 'Release 5.0 - DBCR 17266');

commit;
