--STGAP00016116 - Release(4.2) Ref MR75 Add new Status Parameter to Workload Repo

------ SMS# 103950 Reference MR75 Add new Status Parameter to Workload report

INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('WorkloadReport','00','2','3','STAGECD', 'CHAR', 'N', 'Stage Type');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (999, 'SacwisRev4', 'Release 4.2 - DBCR 16116');

commit;


