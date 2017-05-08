--STGAP00016019 - Release(4.1) FTM-Add new paramter

--SMS #  78537 - Add new parameter to report

update caps.report_parameter
set nbr_rpt_parm_seq = '4'
where  nm_rpt_parm_name = 'UNIT'
 AND  nm_rpt_sqr_name = 'CasesWithoutFamilyTeamMeeting'
and nm_rpt_sqr_ver = '00';

update caps.report_parameter
set nbr_rpt_parm_seq = '3'
where  nm_rpt_parm_name = 'COUNTYCD'
 AND  nm_rpt_sqr_name = 'CasesWithoutFamilyTeamMeeting'
and nm_rpt_sqr_ver = '00';

update caps.report_parameter
set nbr_rpt_parm_seq = '2'
where  nm_rpt_parm_name = 'REGIONCD'
 AND  nm_rpt_sqr_name = 'CasesWithoutFamilyTeamMeeting'
and nm_rpt_sqr_ver = '00';


INSERT INTO caps.report_parameter (nm_rpt_sqr_name, nm_rpt_sqr_ver, nbr_rpt_parm_seq,
nbr_rpt_parm_length, nm_rpt_parm_name, txt_rpt_parm_type, ind_required, nm_rpt_parm_label)
values('CasesWithoutFamilyTeamMeeting','00','1','3','STAGECD', 'CHAR', 'N', 'Stage Type');


insert into caps.schema_version(id_schema_version,application_version,comments)
            values (915, 'SacwisRev4', 'Release 4.1 - DBCR 16019');

commit;

