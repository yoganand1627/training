--STGAP00017887 - Release(5.1) CPS Intake Log Modify Parameter sequence

--CPS Intake Log Modify Parameter sequence
--Modify Sequence of Parameters
--ClearQuest #: STGAP00017869
--ASR #: ASR11217


update caps.report_parameter
set nbr_rpt_parm_seq = '8'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'ENDDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '7'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'STARTDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '6'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'COUNTYCD';

update caps.report_parameter
set nbr_rpt_parm_seq = '5'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'REGIONCD';

update caps.report_parameter
set nbr_rpt_parm_seq = '1'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'STARTDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '2'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'ENDDATE';

update caps.report_parameter
set nbr_rpt_parm_seq = '3'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'REGIONCD';

update caps.report_parameter
set nbr_rpt_parm_seq = '4'
where nm_rpt_sqr_name = 'CPSIntakeLog'
and nm_rpt_parm_name = 'COUNTYCD';

insert into caps.schema_version(id_schema_version,application_version,comments)
            values (1202, 'SacwisRev5', 'Release 5.1 - DBCR 17887');

commit;
