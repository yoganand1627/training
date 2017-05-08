-- STGAP00009718 - Children Eligible For ILP Services - New Report

insert into caps.reports (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_retainage, nm_rpt_type, txt_rpt_full_name, nm_rpt_template_name, nm_rpt_orientation, txt_rpt_email_options, nm_rpt_desc, nm_rpt_area_type, ind_rpt_page)
values ('ILPEligibility', '00', 31, 'A', 'Children Eligible For ILP Services', 'ondport', 'L', 'W', 'List of children currently in Foster Care(FCC), Adoption(ADO) or Post Foster Care(PFC) stages eligible for ILP services.Report runs for an optional Region parameter.If Region is blank, the report runs for statewide', 'Independent Living Program', 'Y');

INSERT INTO caps.report_parameter
(nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('ILPEligibility','00','1','2','REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (366, 'SacwisRev2', 'Release 2.5 - DBCR 9718');

commit;


