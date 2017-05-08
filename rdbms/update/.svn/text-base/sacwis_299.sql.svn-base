-- All changes for version 2.3 of SHINES

-- change STGAP00007804
update caps.report_parameter set nbr_rpt_parm_seq = 3, ind_required = 'N' where nm_rpt_sqr_name = 'IntakeMonthlyStatistics' and nm_rpt_parm_name = 'COUNTYCD';

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('IntakeMonthlyStatistics', '00', 2, 3, 'REGIONCD', 'CHAR', 'N', 'Region');

insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (300, 'SacwisRev2', 'static table updates');                        
commit;

