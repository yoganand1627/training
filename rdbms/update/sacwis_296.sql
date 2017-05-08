-- All changes for version 2.3 of SHINES


--- STGAP00007672 Begins Here ---
create index caps.ind_unit_5 on caps.unit (cd_county) tablespace index01; 

create index caps.ind_employee_10 on caps.employee (id_emp_unit) tablespace index01;
--- STGAP00007672 Ends Here ---


--- STGAP00007695 Begins Here ---
update caps.report_parameter set nbr_rpt_parm_seq = 4 where nm_rpt_sqr_name = 'InvestigationMonthlyStatistics' and nm_rpt_parm_name = 'UNIT';

update caps.report_parameter set nbr_rpt_parm_seq = 3, ind_required = 'N' where nm_rpt_sqr_name = 'InvestigationMonthlyStatistics' and nm_rpt_parm_name = 'COUNTYCD';

update caps.report_parameter set nbr_rpt_parm_seq = 1 where nm_rpt_sqr_name = 'InvestigationMonthlyStatistics' and nm_rpt_parm_name = 'MONTHYEAR';

insert into caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq, nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values ('InvestigationMonthlyStatistics', '00', 2, 3, 'REGIONCD', 'CHAR', 'N', 'Region');
--- STGAP00007695 Ends Here ---



insert into caps.schema_version (id_schema_version, application_version, comments)
                        values (297, 'SacwisRev2', 'Static table updates,new indexes for EMPLOYEE and UNIT');

commit;