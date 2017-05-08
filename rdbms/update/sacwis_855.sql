--STGAP00015939 - Release(Undetermined) Add two new report parameters

--Diversion Activity Report --Add to new report parameters top report launch page
--SMS #: 54117

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('DiversionActivity','00','6','16','STAFFID', 'NUMBER', 'N', 'Staff ID');

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('DiversionActivity','00','7','1','STATUS', 'CHAR', 'N', 'Case Status');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (856, 'SacwisRev3', 'Release 4.0 - DBCR 15939');

commit;

